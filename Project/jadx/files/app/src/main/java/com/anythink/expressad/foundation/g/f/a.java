package com.anythink.expressad.foundation.g.f;

import android.net.TrafficStats;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static long a;
    private static long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f10504c;

    /* JADX INFO: renamed from: com.anythink.expressad.foundation.g.f.a$a, reason: collision with other inner class name */
    private static class C0208a {
        private static a a = new a(0);

        private C0208a() {
        }
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0208a.a;
    }

    public static long b() {
        return b;
    }

    private synchronized void c() {
        if (a == 0) {
            a = SystemClock.elapsedRealtime();
            f10504c = TrafficStats.getTotalRxBytes();
        }
    }

    private synchronized void d() {
        if (a != 0 && f10504c != 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - a;
            if (jElapsedRealtime != 0) {
                try {
                    if (TrafficStats.getTotalRxBytes() != -1) {
                        long totalRxBytes = ((TrafficStats.getTotalRxBytes() - f10504c) * 1000) / jElapsedRealtime;
                        if (totalRxBytes == 0) {
                            b = 1L;
                        } else {
                            b = totalRxBytes;
                        }
                    } else {
                        b = 0L;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            e();
        }
    }

    private synchronized void e() {
        f10504c = 0L;
        a = 0L;
    }

    private a() {
    }
}
