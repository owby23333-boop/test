package com.xiaomi.ad;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes5.dex */
public class z {
    public static volatile z c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f7309a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f7310b = -1;

    public class a extends TimerTask {
        public a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            z.a(z.this, 1000L);
        }
    }

    public static z c() {
        if (c == null) {
            synchronized (z.class) {
                if (c == null) {
                    c = new z();
                }
            }
        }
        return c;
    }

    public long a() {
        if (!this.f7309a.get()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f7310b = jCurrentTimeMillis;
            if (jCurrentTimeMillis <= 0) {
                if (this.f7309a.compareAndSet(false, true)) {
                    b();
                } else {
                    this.f7310b = 0L;
                }
            }
        }
        return this.f7310b;
    }

    public void b() {
        new Timer().schedule(new a(), 1000L, 1000L);
    }

    public static /* synthetic */ long a(z zVar, long j) {
        long j2 = zVar.f7310b + j;
        zVar.f7310b = j2;
        return j2;
    }
}
