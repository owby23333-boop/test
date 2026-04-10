package com.bytedance.sdk.component.g.z.g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gc implements Runnable {
    protected final String g;

    protected abstract void g();

    public gc(String str, Object... objArr) {
        this.g = uy.z(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.g);
        try {
            g();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
