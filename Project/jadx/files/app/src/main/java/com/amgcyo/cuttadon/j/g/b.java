package com.amgcyo.cuttadon.j.g;

import androidx.annotation.NonNull;
import com.amgcyo.cuttadon.utils.otherutils.n0;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RxJavaUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: RxJavaUtils.java */
    class a<T> implements Consumer<com.amgcyo.cuttadon.j.g.h.b<T>> {
        a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(com.amgcyo.cuttadon.j.g.h.b<T> bVar) throws Exception {
            bVar.a(bVar.a());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: renamed from: com.amgcyo.cuttadon.j.g.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RxJavaUtils.java */
    class C0108b<R, T> implements Consumer<com.amgcyo.cuttadon.j.g.h.a<T, R>> {
        C0108b() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(com.amgcyo.cuttadon.j.g.h.a<T, R> aVar) throws Exception {
            aVar.b(aVar.b());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    /* JADX INFO: compiled from: RxJavaUtils.java */
    class c<R, T> extends e<com.amgcyo.cuttadon.j.g.h.a<T, R>> {
        c(com.amgcyo.cuttadon.j.g.h.a aVar) {
            super(aVar);
        }

        @Override // io.reactivex.FlowableOnSubscribe
        public void subscribe(FlowableEmitter<com.amgcyo.cuttadon.j.g.h.a<T, R>> flowableEmitter) throws Exception {
            com.amgcyo.cuttadon.j.g.h.a<T, R> aVar = (com.amgcyo.cuttadon.j.g.h.a) a();
            aVar.c(aVar.a(aVar.a()));
            flowableEmitter.onNext(aVar);
            flowableEmitter.onComplete();
        }
    }

    public static <T> Disposable a(@NonNull com.amgcyo.cuttadon.j.g.h.b<T> bVar) {
        return a(bVar, new n0("RxJavaUtils"));
    }

    @NonNull
    private static <T, R> e<com.amgcyo.cuttadon.j.g.h.a<T, R>> b(@NonNull com.amgcyo.cuttadon.j.g.h.a<T, R> aVar) {
        return new c(aVar);
    }

    public static <T> Disposable a(@NonNull com.amgcyo.cuttadon.j.g.h.b<T> bVar, @NonNull Consumer<Throwable> consumer) {
        return Flowable.just(bVar).observeOn(Schedulers.io()).subscribe(new a(), consumer);
    }

    public static Flowable<Long> a(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return Flowable.interval(j2, j3, timeUnit).observeOn(AndroidSchedulers.mainThread());
    }

    public static <T, R> Disposable a(@NonNull com.amgcyo.cuttadon.j.g.h.a<T, R> aVar) {
        return a(aVar, new n0("RxJavaUtils"));
    }

    public static <T, R> Disposable a(@NonNull com.amgcyo.cuttadon.j.g.h.a<T, R> aVar, @NonNull Consumer<Throwable> consumer) {
        return Flowable.create(b(aVar), BackpressureStrategy.LATEST).compose(com.amgcyo.cuttadon.j.g.c.a()).subscribe(new C0108b(), consumer);
    }
}
