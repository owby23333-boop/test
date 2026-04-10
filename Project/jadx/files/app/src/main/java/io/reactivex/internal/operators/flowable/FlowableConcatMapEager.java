package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscribers.InnerQueuedSubscriber;
import io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowableConcatMapEager<T, R> extends AbstractFlowableWithUpstream<T, R> {
    final ErrorMode errorMode;
    final Function<? super T, ? extends Publisher<? extends R>> mapper;
    final int maxConcurrency;
    final int prefetch;

    static final class ConcatMapEagerDelayErrorSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, InnerQueuedSubscriberSupport<R> {
        private static final long serialVersionUID = -4255299542215038287L;
        volatile boolean cancelled;
        volatile InnerQueuedSubscriber<R> current;
        volatile boolean done;
        final Subscriber<? super R> downstream;
        final ErrorMode errorMode;
        final Function<? super T, ? extends Publisher<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        final SpscLinkedArrayQueue<InnerQueuedSubscriber<R>> subscribers;
        Subscription upstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicLong requested = new AtomicLong();

        ConcatMapEagerDelayErrorSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
            this.downstream = subscriber;
            this.mapper = function;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = errorMode;
            this.subscribers = new SpscLinkedArrayQueue<>(Math.min(i3, i2));
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.upstream.cancel();
            drainAndCancel();
        }

        void cancelAll() {
            InnerQueuedSubscriber<R> innerQueuedSubscriber = this.current;
            this.current = null;
            if (innerQueuedSubscriber != null) {
                innerQueuedSubscriber.cancel();
            }
            while (true) {
                InnerQueuedSubscriber<R> innerQueuedSubscriberPoll = this.subscribers.poll();
                if (innerQueuedSubscriberPoll == null) {
                    return;
                } else {
                    innerQueuedSubscriberPoll.cancel();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:73:0x0112  */
        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void drain() {
            /*
                Method dump skipped, instruction units count: 317
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber.drain():void");
        }

        void drainAndCancel() {
            if (getAndIncrement() == 0) {
                do {
                    cancelAll();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerComplete(InnerQueuedSubscriber<R> innerQueuedSubscriber) {
            innerQueuedSubscriber.setDone();
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerError(InnerQueuedSubscriber<R> innerQueuedSubscriber, Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
                return;
            }
            innerQueuedSubscriber.setDone();
            if (this.errorMode != ErrorMode.END) {
                this.upstream.cancel();
            }
            drain();
        }

        @Override // io.reactivex.internal.subscribers.InnerQueuedSubscriberSupport
        public void innerNext(InnerQueuedSubscriber<R> innerQueuedSubscriber, R r2) {
            if (innerQueuedSubscriber.queue().offer(r2)) {
                drain();
            } else {
                innerQueuedSubscriber.cancel();
                innerError(innerQueuedSubscriber, new MissingBackpressureException());
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            if (!this.errors.addThrowable(th)) {
                RxJavaPlugins.onError(th);
            } else {
                this.done = true;
                drain();
            }
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t2) {
            try {
                Publisher publisher = (Publisher) ObjectHelper.requireNonNull(this.mapper.apply(t2), "The mapper returned a null Publisher");
                InnerQueuedSubscriber<R> innerQueuedSubscriber = new InnerQueuedSubscriber<>(this, this.prefetch);
                if (this.cancelled) {
                    return;
                }
                this.subscribers.offer(innerQueuedSubscriber);
                publisher.subscribe(innerQueuedSubscriber);
                if (this.cancelled) {
                    innerQueuedSubscriber.cancel();
                    drainAndCancel();
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.upstream.cancel();
                onError(th);
            }
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
                int i2 = this.maxConcurrency;
                subscription.request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : i2);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this.requested, j2);
                drain();
            }
        }
    }

    public FlowableConcatMapEager(Flowable<T> flowable, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
        super(flowable);
        this.mapper = function;
        this.maxConcurrency = i2;
        this.prefetch = i3;
        this.errorMode = errorMode;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe((FlowableSubscriber) new ConcatMapEagerDelayErrorSubscriber(subscriber, this.mapper, this.maxConcurrency, this.prefetch, this.errorMode));
    }
}
