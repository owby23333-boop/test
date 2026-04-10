package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.Scheduler;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowableDelay<T> extends AbstractFlowableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class DelaySubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final long delay;
        final boolean delayError;
        final Subscriber<? super T> downstream;
        final TimeUnit unit;
        Subscription upstream;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f20883w;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.downstream.onComplete();
                } finally {
                    DelaySubscriber.this.f20883w.dispose();
                }
            }
        }

        final class OnError implements Runnable {

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private final Throwable f20884t;

            OnError(Throwable th) {
                this.f20884t = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelaySubscriber.this.downstream.onError(this.f20884t);
                } finally {
                    DelaySubscriber.this.f20883w.dispose();
                }
            }
        }

        final class OnNext implements Runnable {

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private final T f20885t;

            OnNext(T t2) {
                this.f20885t = t2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelaySubscriber.this.downstream.onNext(this.f20885t);
            }
        }

        DelaySubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.downstream = subscriber;
            this.delay = j2;
            this.unit = timeUnit;
            this.f20883w = worker;
            this.delayError = z2;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.upstream.cancel();
            this.f20883w.dispose();
        }

        @Override // org.reactivestreams.Subscriber
        public void onComplete() {
            this.f20883w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onError(Throwable th) {
            this.f20883w.schedule(new OnError(th), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // org.reactivestreams.Subscriber
        public void onNext(T t2) {
            this.f20883w.schedule(new OnNext(t2), this.delay, this.unit);
        }

        @Override // io.reactivex.FlowableSubscriber, org.reactivestreams.Subscriber
        public void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j2) {
            this.upstream.request(j2);
        }
    }

    public FlowableDelay(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z2) {
        super(flowable);
        this.delay = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z2;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.source.subscribe((FlowableSubscriber) new DelaySubscriber(this.delayError ? subscriber : new SerializedSubscriber(subscriber), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
