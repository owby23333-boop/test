package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes3.dex */
public final class am {
    private static volatile am ayY = new am();
    private volatile boolean ayZ;
    private volatile long aza = 0;
    private volatile PowerManager azb;

    public static am DJ() {
        return ayY;
    }

    public final boolean aH(Context context) {
        if (this.aza > 0 && SystemClock.elapsedRealtime() - this.aza < 600) {
            return this.ayZ;
        }
        if (this.azb == null && context != null) {
            synchronized (this) {
                if (this.azb == null) {
                    this.azb = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        this.ayZ = this.azb != null ? Build.VERSION.SDK_INT >= 20 ? this.azb.isInteractive() : this.azb.isScreenOn() : false;
        this.aza = SystemClock.elapsedRealtime();
        return this.ayZ;
    }
}
