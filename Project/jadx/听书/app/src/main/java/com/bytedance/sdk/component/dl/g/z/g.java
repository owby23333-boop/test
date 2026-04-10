package com.bytedance.sdk.component.dl.g.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements Runnable {
    protected final String g;

    protected abstract void dl();

    public g(String str, Object... objArr) {
        this.g = dl.z(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.g);
        try {
            dl();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
