package com.anythink.expressad.exoplayer.k;

/* JADX INFO: loaded from: classes2.dex */
public final class ac {
    public static final long a = Long.MAX_VALUE;
    private static final long b = 8589934592L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f9809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f9810d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile long f9811e = com.anythink.expressad.exoplayer.b.b;

    public ac(long j2) {
        c(j2);
    }

    private long b() {
        return this.f9809c;
    }

    private synchronized void c(long j2) {
        a.b(this.f9811e == com.anythink.expressad.exoplayer.b.b);
        this.f9809c = j2;
    }

    private void d() {
        this.f9811e = com.anythink.expressad.exoplayer.b.b;
    }

    private synchronized void e() {
        while (this.f9811e == com.anythink.expressad.exoplayer.b.b) {
            wait();
        }
    }

    public final long a() {
        if (this.f9809c == Long.MAX_VALUE) {
            return 0L;
        }
        return this.f9811e == com.anythink.expressad.exoplayer.b.b ? com.anythink.expressad.exoplayer.b.b : this.f9810d;
    }

    private static long d(long j2) {
        return (j2 * 1000000) / 90000;
    }

    public final long b(long j2) {
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        if (this.f9811e != com.anythink.expressad.exoplayer.b.b) {
            this.f9811e = j2;
        } else {
            long j3 = this.f9809c;
            if (j3 != Long.MAX_VALUE) {
                this.f9810d = j3 - j2;
            }
            synchronized (this) {
                this.f9811e = j2;
                notifyAll();
            }
        }
        return j2 + this.f9810d;
    }

    public final long a(long j2) {
        if (j2 == com.anythink.expressad.exoplayer.b.b) {
            return com.anythink.expressad.exoplayer.b.b;
        }
        if (this.f9811e != com.anythink.expressad.exoplayer.b.b) {
            long j3 = (this.f9811e * 90000) / 1000000;
            long j4 = (4294967296L + j3) / b;
            long j5 = ((j4 - 1) * b) + j2;
            j2 += j4 * b;
            if (Math.abs(j5 - j3) < Math.abs(j2 - j3)) {
                j2 = j5;
            }
        }
        return b((j2 * 1000000) / 90000);
    }

    private long c() {
        if (this.f9811e != com.anythink.expressad.exoplayer.b.b) {
            return this.f9811e + this.f9810d;
        }
        long j2 = this.f9809c;
        return j2 != Long.MAX_VALUE ? j2 : com.anythink.expressad.exoplayer.b.b;
    }

    private static long e(long j2) {
        return (j2 * 90000) / 1000000;
    }
}
