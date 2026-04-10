package com.amgcyo.cuttadon.utils.otherutils;

import androidx.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MkRxJavaUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class b0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: MkRxJavaUtils.java */
    class a<T> implements Consumer<com.amgcyo.cuttadon.j.g.h.b<T>> {
        a() {
        }

        @Override // io.reactivex.functions.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(com.amgcyo.cuttadon.j.g.h.b<T> bVar) throws Exception {
            bVar.a(bVar.a());
        }
    }

    public static <T> Disposable a(@NonNull com.amgcyo.cuttadon.j.g.h.b<T> bVar) {
        return a(bVar, new n0("MkRxJavaUtils"));
    }

    public static <T> Disposable a(@NonNull com.amgcyo.cuttadon.j.g.h.b<T> bVar, @NonNull Consumer<Throwable> consumer) {
        return Flowable.just(bVar).observeOn(Schedulers.io()).subscribe(new a(), consumer);
    }

    public static Flowable<Long> a(long j2, long j3, @NonNull TimeUnit timeUnit) {
        return Flowable.interval(j2, j3, timeUnit);
    }
}
