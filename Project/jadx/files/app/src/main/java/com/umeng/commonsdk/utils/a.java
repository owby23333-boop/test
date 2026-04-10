package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: CountDownTimer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f20200e = 1;
    private final long a;
    private final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f20201c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HandlerThread f20203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f20204g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f20202d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler.Callback f20205h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f20202d) {
                    return true;
                }
                long jElapsedRealtime = a.this.f20201c - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f20203f != null) {
                        a.this.f20203f.quit();
                    }
                } else if (jElapsedRealtime < a.this.b) {
                    a.this.f20204g.sendMessageDelayed(a.this.f20204g.obtainMessage(1), jElapsedRealtime);
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(jElapsedRealtime);
                    long jElapsedRealtime3 = (jElapsedRealtime2 + a.this.b) - SystemClock.elapsedRealtime();
                    while (jElapsedRealtime3 < 0) {
                        jElapsedRealtime3 += a.this.b;
                    }
                    a.this.f20204g.sendMessageDelayed(a.this.f20204g.obtainMessage(1), jElapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j2, long j3) {
        this.a = j2;
        this.b = j3;
        if (d()) {
            this.f20204g = new Handler(this.f20205h);
            return;
        }
        this.f20203f = new HandlerThread("CountDownTimerThread");
        this.f20203f.start();
        this.f20204g = new Handler(this.f20203f.getLooper(), this.f20205h);
    }

    public abstract void a(long j2);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f20202d = true;
        this.f20204g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f20202d = false;
        if (this.a <= 0) {
            c();
            return this;
        }
        this.f20201c = SystemClock.elapsedRealtime() + this.a;
        this.f20204g.sendMessage(this.f20204g.obtainMessage(1));
        return this;
    }
}
