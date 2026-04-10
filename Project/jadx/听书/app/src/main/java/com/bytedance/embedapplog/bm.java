package com.bytedance.embedapplog;

/* JADX INFO: loaded from: classes2.dex */
abstract class bm<T> {
    private volatile T z;

    protected abstract T z(Object... objArr);

    bm() {
    }

    public final T g(Object... objArr) {
        if (this.z == null) {
            synchronized (this) {
                if (this.z == null) {
                    this.z = z(objArr);
                }
            }
        }
        return this.z;
    }
}
