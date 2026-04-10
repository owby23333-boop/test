package com.amgcyo.cuttadon.j.g.h;

/* JADX INFO: compiled from: RxAsyncTask.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a<T, R> implements com.amgcyo.cuttadon.j.g.g.a<T, R>, com.amgcyo.cuttadon.j.g.g.b<R> {
    private T a;
    private R b;

    public a(T t2) {
        this.a = t2;
    }

    public T a() {
        return this.a;
    }

    public R b() {
        return this.b;
    }

    public a c(R r2) {
        this.b = r2;
        return this;
    }
}
