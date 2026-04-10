package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: compiled from: LogTime.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final double a;

    static {
        a = Build.VERSION.SDK_INT >= 17 ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    @TargetApi(17)
    public static long a() {
        return Build.VERSION.SDK_INT >= 17 ? SystemClock.elapsedRealtimeNanos() : SystemClock.uptimeMillis();
    }

    public static double a(long j2) {
        double dA = a() - j2;
        double d2 = a;
        Double.isNaN(dA);
        return dA * d2;
    }
}
