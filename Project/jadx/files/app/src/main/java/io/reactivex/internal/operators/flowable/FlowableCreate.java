package io.reactivex.internal.operators.flowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.functions.Cancellable;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class FlowableCreate<T> extends Flowable<T> {
    final BackpressureStrategy backpressure;
    final FlowableOnSubscribe<T> source;

    /* JADX INFO: renamed from: io.reactivex.internal.operators.flowable.FlowableCreate$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$BackpressureStrategy = new int[BackpressureStrategy.values().length];

        static {
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$reactivex$BackpressureStrategy[BackpressureStrategy.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    static abstract class BaseEmitter<T> extends AtomicLong implements FlowableEmitter<T>, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> downstream;
        final SequentialDisposable serial = new SequentialDisposable();

        BaseEmitter(Subscriber<? super T> subscriber) {
            this.downstream = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public final void cancel() {
            this.serial.dispose();
            onUnsubscribed();
        }

        protected void complete() {
            if (isCancelled()) {
                return;
            }
            try {
                this.downstream.onComplete();
            } finally {
                this.serial.dispose();
            }
        }

        protected boolean error(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (isCancelled()) {
                return false;
            }
            try {
                this.downstream.onError(th);
                this.serial.dispose();
                return true;
            } catch (Throwable th2) {
                this.serial.dispose();
                throw th2;
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public final boolean isCancelled() {
            return this.serial.isDisposed();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            complete();
        }

        @Override // io.reactivex.Emitter
        public final void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }

        @Override // org.reactivestreams.Subscription
        public final void request(long j2) {
            if (SubscriptionHelper.validate(j2)) {
                BackpressureHelper.add(this, j2);
                onRequested();
            }
        }

        @Override // io.reactivex.FlowableEmitter
        public final long requested() {
            return get();
        }

        @Override // io.reactivex.FlowableEmitter
        public final FlowableEmitter<T> serialize() {
            return new SerializedEmitter(this);
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setCancellable(Cancellable cancellable) {
            setDisposable(new CancellableDisposable(cancellable));
        }

        @Override // io.reactivex.FlowableEmitter
        public final void setDisposable(Disposable disposable) {
            this.serial.update(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            return error(th);
        }
    }

    static final class BufferAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final SpscLinkedArrayQueue<T> queue;
        final AtomicInteger wip;

        BufferAsyncEmitter(Subscriber<? super T> subscriber, int i2) {
            super(subscriber);
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.wip = new AtomicInteger();
        }

        void drain() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.downstream;
            SpscLinkedArrayQueue<T> spscLinkedArrayQueue = this.queue;
            int iAddAndGet = 1;
            do {
                long j2 = get();
                long j3 = 0;
                while (j3 != j2) {
                    if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z2 = this.done;
                    T tPoll = spscLinkedArrayQueue.poll();
                    boolean z3 = tPoll == null;
                    if (z2 && z3) {
                        Throwable th = this.error;
                        if (th != null) {
                            error(th);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(tPoll);
                    j3++;
                }
                if (j3 == j2) {
                    if (isCancelled()) {
                        spscLinkedArrayQueue.clear();
                        return;
                    }
                    boolean z4 = this.done;
                    boolean zIsEmpty = spscLinkedArrayQueue.isEmpty();
                    if (z4 && zIsEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            error(th2);
                            return;
                        } else {
                            complete();
                            return;
                        }
                    }
                }
                if (j3 != 0) {
                    BackpressureHelper.produced(this, j3);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t2) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t2 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.offer(t2);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }
    }

    static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    static final class LatestAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<T> queue;
        final AtomicInteger wip;

        LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
        
            if (r8 != r4) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0053, code lost:
        
            if (isCancelled() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0055, code lost:
        
            r1.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
        
            r4 = r15.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x005f, code lost:
        
            if (r1.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0062, code lost:
        
            if (r4 == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0064, code lost:
        
            if (r10 == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0066, code lost:
        
            r0 = r15.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0068, code lost:
        
            if (r0 == null) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006a, code lost:
        
            error(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x006e, code lost:
        
            complete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0074, code lost:
        
            if (r8 == 0) goto L46;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0076, code lost:
        
            io.reactivex.internal.util.BackpressureHelper.produced(r15, r8);
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
        
            r3 = r15.wip.addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void drain() {
            /*
                r15 = this;
                java.util.concurrent.atomic.AtomicInteger r0 = r15.wip
                int r0 = r0.getAndIncrement()
                if (r0 == 0) goto L9
                return
            L9:
                org.reactivestreams.Subscriber<? super T> r0 = r15.downstream
                java.util.concurrent.atomic.AtomicReference<T> r1 = r15.queue
                r2 = 1
                r3 = 1
            Lf:
                long r4 = r15.get()
                r6 = 0
                r8 = r6
            L16:
                r10 = 0
                r11 = 0
                int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r12 == 0) goto L4b
                boolean r12 = r15.isCancelled()
                if (r12 == 0) goto L26
                r1.lazySet(r11)
                return
            L26:
                boolean r12 = r15.done
                java.lang.Object r13 = r1.getAndSet(r11)
                if (r13 != 0) goto L30
                r14 = 1
                goto L31
            L30:
                r14 = 0
            L31:
                if (r12 == 0) goto L41
                if (r14 == 0) goto L41
                java.lang.Throwable r0 = r15.error
                if (r0 == 0) goto L3d
                r15.error(r0)
                goto L40
            L3d:
                r15.complete()
            L40:
                return
            L41:
                if (r14 == 0) goto L44
                goto L4b
            L44:
                r0.onNext(r13)
                r10 = 1
                long r8 = r8 + r10
                goto L16
            L4b:
                int r12 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r12 != 0) goto L72
                boolean r4 = r15.isCancelled()
                if (r4 == 0) goto L59
                r1.lazySet(r11)
                return
            L59:
                boolean r4 = r15.done
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L62
                r10 = 1
            L62:
                if (r4 == 0) goto L72
                if (r10 == 0) goto L72
                java.lang.Throwable r0 = r15.error
                if (r0 == 0) goto L6e
                r15.error(r0)
                goto L71
            L6e:
                r15.complete()
            L71:
                return
            L72:
                int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r4 == 0) goto L79
                io.reactivex.internal.util.BackpressureHelper.produced(r15, r8)
            L79:
                java.util.concurrent.atomic.AtomicInteger r4 = r15.wip
                int r3 = -r3
                int r3 = r4.addAndGet(r3)
                if (r3 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableCreate.LatestAsyncEmitter.drain():void");
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.Emitter
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t2) {
            if (this.done || isCancelled()) {
                return;
            }
            if (t2 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.queue.set(t2);
                drain();
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onRequested() {
            drain();
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        @Override // io.reactivex.internal.operators.flowable.FlowableCreate.BaseEmitter, io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            if (this.done || isCancelled()) {
                return false;
            }
            if (th == null) {
                onError(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.error = th;
            this.done = true;
            drain();
            return true;
        }
    }

    static final class MissingEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        MissingEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t2) {
            long j2;
            if (isCancelled()) {
                return;
            }
            if (t2 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.downstream.onNext(t2);
            do {
                j2 = get();
                if (j2 == 0) {
                    return;
                }
            } while (!compareAndSet(j2, j2 - 1));
        }
    }

    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // io.reactivex.Emitter
        public final void onNext(T t2) {
            if (isCancelled()) {
                return;
            }
            if (t2 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                onOverflow();
            } else {
                this.downstream.onNext(t2);
                BackpressureHelper.produced(this, 1L);
            }
        }

        abstract void onOverflow();
    }

    static final class SerializedEmitter<T> extends AtomicInteger implements FlowableEmitter<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final BaseEmitter<T> emitter;
        final AtomicThrowable error = new AtomicThrowable();
        final SimplePlainQueue<T> queue = new SpscLinkedArrayQueue(16);

        SerializedEmitter(BaseEmitter<T> baseEmitter) {
            this.emitter = baseEmitter;
        }

        void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        void drainLoop() {
            BaseEmitter<T> baseEmitter = this.emitter;
            SimplePlainQueue<T> simplePlainQueue = this.queue;
            AtomicThrowable atomicThrowable = this.error;
            int iAddAndGet = 1;
            while (!baseEmitter.isCancelled()) {
                if (atomicThrowable.get() != null) {
                    simplePlainQueue.clear();
                    baseEmitter.onError(atomicThrowable.terminate());
                    return;
                }
                boolean z2 = this.done;
                T tPoll = simplePlainQueue.poll();
                boolean z3 = tPoll == null;
                if (z2 && z3) {
                    baseEmitter.onComplete();
                    return;
                } else if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    baseEmitter.onNext(tPoll);
                }
            }
            simplePlainQueue.clear();
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean isCancelled() {
            return this.emitter.isCancelled();
        }

        @Override // io.reactivex.Emitter
        public void onComplete() {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Emitter
        public void onError(Throwable th) {
            if (tryOnError(th)) {
                return;
            }
            RxJavaPlugins.onError(th);
        }

        @Override // io.reactivex.Emitter
        public void onNext(T t2) {
            if (this.emitter.isCancelled() || this.done) {
                return;
            }
            if (t2 == null) {
                onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            if (get() == 0 && compareAndSet(0, 1)) {
                this.emitter.onNext(t2);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                SimplePlainQueue<T> simplePlainQueue = this.queue;
                synchronized (simplePlainQueue) {
                    simplePlainQueue.offer(t2);
                }
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        @Override // io.reactivex.FlowableEmitter
        public long requested() {
            return this.emitter.requested();
        }

        @Override // io.reactivex.FlowableEmitter
        public FlowableEmitter<T> serialize() {
            return this;
        }

        @Override // io.reactivex.FlowableEmitter
        public void setCancellable(Cancellable cancellable) {
            this.emitter.setCancellable(cancellable);
        }

        @Override // io.reactivex.FlowableEmitter
        public void setDisposable(Disposable disposable) {
            this.emitter.setDisposable(disposable);
        }

        @Override // java.util.concurrent.atomic.AtomicInteger
        public String toString() {
            return this.emitter.toString();
        }

        @Override // io.reactivex.FlowableEmitter
        public boolean tryOnError(Throwable th) {
            if (!this.emitter.isCancelled() && !this.done) {
                if (th == null) {
                    th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                if (this.error.addThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }
    }

    public FlowableCreate(FlowableOnSubscribe<T> flowableOnSubscribe, BackpressureStrategy backpressureStrategy) {
        this.source = flowableOnSubscribe;
        this.backpressure = backpressureStrategy;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.Flowable
    public void subscribeActual(Subscriber<? super T> subscriber) {
        int i2 = AnonymousClass1.$SwitchMap$io$reactivex$BackpressureStrategy[this.backpressure.ordinal()];
        BaseEmitter bufferAsyncEmitter = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new BufferAsyncEmitter(subscriber, Flowable.bufferSize()) : new LatestAsyncEmitter(subscriber) : new DropAsyncEmitter(subscriber) : new ErrorAsyncEmitter(subscriber) : new MissingEmitter(subscriber);
        subscriber.onSubscribe(bufferAsyncEmitter);
        try {
            this.source.subscribe(bufferAsyncEmitter);
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            bufferAsyncEmitter.onError(th);
        }
    }
}
