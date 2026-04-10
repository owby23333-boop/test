package com.ss.android.socialbase.downloader.fo;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private static long e = -1;
    private static final String g = "g";
    private static volatile g gz;
    public static volatile boolean z;
    private long m;
    private final wp dl = wp.z();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f2073a = new AtomicInteger();
    private final z gc = new z(com.ss.android.socialbase.downloader.v.gc.z());

    public static g z() {
        if (gz == null) {
            synchronized (g.class) {
                if (gz == null) {
                    gz = new g();
                }
            }
        }
        return gz;
    }

    private g() {
    }

    public void g() {
        try {
            com.ss.android.socialbase.downloader.m.z.dl(g, "startSampling: mSamplingCounter = " + this.f2073a);
            if (this.f2073a.getAndIncrement() == 0) {
                this.gc.z();
                this.m = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void dl() {
        try {
            com.ss.android.socialbase.downloader.m.z.dl(g, "stopSampling: mSamplingCounter = " + this.f2073a);
            if (this.f2073a.decrementAndGet() == 0) {
                this.gc.g();
                e();
            }
        } catch (Throwable unused) {
        }
    }

    public static long a() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void gc() {
        z = com.ss.android.socialbase.downloader.pf.m.g(com.ss.android.socialbase.downloader.downloader.dl.xl());
    }

    protected void m() {
        long mobileRxBytes;
        try {
            gc();
            if (z) {
                mobileRxBytes = a();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = e;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.dl.z(j2, jUptimeMillis - this.m);
                    this.m = jUptimeMillis;
                }
            }
            e = mobileRxBytes;
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.wp.z(e2);
        }
    }

    protected void e() {
        m();
        e = -1L;
    }

    private class z extends Handler {
        public z(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.m();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void z() {
            sendEmptyMessage(1);
        }

        public void g() {
            removeMessages(1);
        }
    }
}
