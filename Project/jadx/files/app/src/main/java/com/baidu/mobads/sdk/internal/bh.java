package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: classes2.dex */
final class bh implements Runnable {
    final /* synthetic */ Runnable a;

    bh(Runnable runnable) {
        this.a = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.run();
    }
}
