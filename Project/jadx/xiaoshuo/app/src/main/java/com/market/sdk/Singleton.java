package com.market.sdk;

/* JADX INFO: loaded from: classes7.dex */
public abstract class Singleton<T> {
    private T mInstance;

    public abstract T create();

    public final T get() {
        T t;
        synchronized (this) {
            if (this.mInstance == null) {
                this.mInstance = create();
            }
            t = this.mInstance;
        }
        return t;
    }
}
