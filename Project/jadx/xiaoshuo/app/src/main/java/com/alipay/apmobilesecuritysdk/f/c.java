package com.alipay.apmobilesecuritysdk.f;

import android.os.Process;

/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f1687a;

    public c(b bVar) {
        this.f1687a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Process.setThreadPriority(0);
            while (!this.f1687a.c.isEmpty()) {
                Runnable runnable = (Runnable) this.f1687a.c.get(0);
                this.f1687a.c.remove(0);
                if (runnable != null) {
                    runnable.run();
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.f1687a.f1686b = null;
            throw th;
        }
        this.f1687a.f1686b = null;
    }
}
