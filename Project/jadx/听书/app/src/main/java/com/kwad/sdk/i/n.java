package com.kwad.sdk.i;

/* JADX INFO: loaded from: classes4.dex */
abstract class n implements Runnable {
    abstract void doTask();

    n() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            doTask();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
