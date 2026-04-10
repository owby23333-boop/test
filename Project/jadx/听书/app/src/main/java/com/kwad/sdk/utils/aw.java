package com.kwad.sdk.utils;

import android.content.Context;
import android.os.PowerManager;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes4.dex */
public final class aw {
    private static volatile aw bad = new aw();
    private volatile boolean bae;
    private volatile long baf = 0;
    private volatile PowerManager bag;

    public static aw Rh() {
        return bad;
    }

    public final boolean dl(Context context) {
        if (this.baf > 0 && SystemClock.elapsedRealtime() - this.baf < 600) {
            return this.bae;
        }
        if (this.bag == null && context != null) {
            synchronized (this) {
                if (this.bag == null) {
                    this.bag = (PowerManager) context.getApplicationContext().getSystemService("power");
                }
            }
        }
        this.bae = this.bag != null ? this.bag.isInteractive() : false;
        this.baf = SystemClock.elapsedRealtime();
        return this.bae;
    }
}
