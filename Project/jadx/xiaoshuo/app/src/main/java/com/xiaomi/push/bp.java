package com.xiaomi.push;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes8.dex */
public class bp<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f7830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7831b;
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private final long i;

    public bp(long j, long j2) {
        this.i = j * 1000000;
        this.f7830a = j2;
    }

    public long a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public long c() {
        long j = this.f;
        if (j > 0) {
            long j2 = this.e;
            if (j2 > 0) {
                return j / j2;
            }
        }
        return 0L;
    }

    public long d() {
        long j = this.h;
        long j2 = this.g;
        if (j > j2) {
            return j - j2;
        }
        return 0L;
    }

    public T a(Callable<T> callable) {
        T tCall;
        long j = this.f7831b;
        long j2 = this.i;
        if (j > j2) {
            long j3 = (j / j2) * this.f7830a;
            this.f7831b = 0L;
            if (j3 > 0) {
                try {
                    Thread.sleep(j3);
                } catch (Exception unused) {
                }
            }
        }
        long jNanoTime = System.nanoTime();
        if (this.g <= 0) {
            this.g = jNanoTime;
        }
        try {
            tCall = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
            tCall = null;
        }
        long jNanoTime2 = System.nanoTime() - jNanoTime;
        this.h = System.nanoTime();
        this.e++;
        if (this.c < jNanoTime2) {
            this.c = jNanoTime2;
        }
        if (jNanoTime2 > 0) {
            this.f += jNanoTime2;
            long j4 = this.d;
            if (j4 == 0 || j4 > jNanoTime2) {
                this.d = jNanoTime2;
            }
        }
        this.f7831b += Math.max(jNanoTime2, 0L);
        return tCall;
    }
}
