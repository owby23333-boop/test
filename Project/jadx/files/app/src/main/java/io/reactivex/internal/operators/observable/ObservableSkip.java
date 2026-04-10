package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes3.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final long f20902n;

    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> downstream;
        long remaining;
        Disposable upstream;

        SkipObserver(Observer<? super T> observer, long j2) {
            this.downstream = observer;
            this.remaining = j2;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t2) {
            long j2 = this.remaining;
            if (j2 != 0) {
                this.remaining = j2 - 1;
            } else {
                this.downstream.onNext(t2);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j2) {
        super(observableSource);
        this.f20902n = j2;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.f20902n));
    }
}
