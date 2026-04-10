package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.observers.SerializedObserver;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class ObservableDelay<T> extends AbstractObservableWithUpstream<T, T> {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final TimeUnit unit;

    static final class DelayObserver<T> implements Observer<T>, Disposable {
        final long delay;
        final boolean delayError;
        final Observer<? super T> downstream;
        final TimeUnit unit;
        Disposable upstream;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        final Scheduler.Worker f20898w;

        final class OnComplete implements Runnable {
            OnComplete() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onComplete();
                } finally {
                    DelayObserver.this.f20898w.dispose();
                }
            }
        }

        final class OnError implements Runnable {
            private final Throwable throwable;

            OnError(Throwable th) {
                this.throwable = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    DelayObserver.this.downstream.onError(this.throwable);
                } finally {
                    DelayObserver.this.f20898w.dispose();
                }
            }
        }

        final class OnNext implements Runnable {

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            private final T f20899t;

            OnNext(T t2) {
                this.f20899t = t2;
            }

            @Override // java.lang.Runnable
            public void run() {
                DelayObserver.this.downstream.onNext(this.f20899t);
            }
        }

        DelayObserver(Observer<? super T> observer, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z2) {
            this.downstream = observer;
            this.delay = j2;
            this.unit = timeUnit;
            this.f20898w = worker;
            this.delayError = z2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.f20898w.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f20898w.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f20898w.schedule(new OnComplete(), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f20898w.schedule(new OnError(th), this.delayError ? this.delay : 0L, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t2) {
            this.f20898w.schedule(new OnNext(t2), this.delay, this.unit);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableDelay(ObservableSource<T> observableSource, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z2) {
        super(observableSource);
        this.delay = j2;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = z2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new DelayObserver(this.delayError ? observer : new SerializedObserver(observer), this.delay, this.unit, this.scheduler.createWorker(), this.delayError));
    }
}
