package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes.dex */
abstract class ev<T> {
    private volatile T e;

    public final T bf(Object... objArr) {
        if (this.e == null) {
            synchronized (this) {
                if (this.e == null) {
                    this.e = e(objArr);
                }
            }
        }
        return this.e;
    }

    public abstract T e(Object... objArr);
}
