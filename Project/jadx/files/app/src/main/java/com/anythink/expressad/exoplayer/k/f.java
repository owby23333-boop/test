package com.anythink.expressad.exoplayer.k;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class f {
    private boolean a;

    public final synchronized boolean a() {
        if (this.a) {
            return false;
        }
        this.a = true;
        notifyAll();
        return true;
    }

    public final synchronized boolean b() {
        boolean z2;
        z2 = this.a;
        this.a = false;
        return z2;
    }

    public final synchronized void c() {
        while (!this.a) {
            wait();
        }
    }

    private synchronized boolean a(long j2) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j3 = j2 + jElapsedRealtime;
        while (!this.a && jElapsedRealtime < j3) {
            wait(j3 - jElapsedRealtime);
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        return this.a;
    }
}
