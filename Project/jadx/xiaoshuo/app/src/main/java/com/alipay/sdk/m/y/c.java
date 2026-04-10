package com.alipay.sdk.m.y;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f1980a = 3000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static long f1981b = -1;

    public static synchronized boolean a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f1981b < 3000) {
            return true;
        }
        f1981b = jElapsedRealtime;
        return false;
    }
}
