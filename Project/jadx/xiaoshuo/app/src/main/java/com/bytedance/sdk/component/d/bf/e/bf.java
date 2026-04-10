package com.bytedance.sdk.component.d.bf.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class bf implements Runnable {
    protected final String bf;

    public bf(String str, Object... objArr) {
        this.bf = d.e(str, objArr);
    }

    public abstract void e();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.bf);
        try {
            e();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
