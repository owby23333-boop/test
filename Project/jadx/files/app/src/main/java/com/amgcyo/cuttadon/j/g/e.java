package com.amgcyo.cuttadon.j.g;

import io.reactivex.FlowableOnSubscribe;

/* JADX INFO: compiled from: RxTaskOnSubscribe.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class e<T> implements FlowableOnSubscribe<T> {
    private T a;

    public e(T t2) {
        this.a = t2;
    }

    public T a() {
        return this.a;
    }
}
