package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: UmengCountDownTimer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w {
    private static final String a = "com.umeng.message.proguard.w";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f20528g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f20529h = 2;
    private final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f20530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f20531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f20532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f20533f = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Handler f20534i = new Handler() { // from class: com.umeng.message.proguard.w.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (w.this) {
                if (message.what == 1) {
                    if (w.this.f20533f) {
                        return;
                    }
                    long jElapsedRealtime = w.this.f20531d - SystemClock.elapsedRealtime();
                    if (jElapsedRealtime <= 0) {
                        w.this.e();
                    } else if (jElapsedRealtime < w.this.f20530c) {
                        w.this.a(jElapsedRealtime);
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                    } else {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        w.this.a(jElapsedRealtime);
                        long jElapsedRealtime3 = (jElapsedRealtime2 + w.this.f20530c) - SystemClock.elapsedRealtime();
                        while (jElapsedRealtime3 < 0) {
                            jElapsedRealtime3 += w.this.f20530c;
                        }
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime3);
                    }
                }
            }
        }
    };

    public w(long j2, long j3) {
        this.b = j2;
        this.f20530c = j3;
    }

    public abstract void a(long j2);

    public final synchronized w d() {
        this.f20533f = false;
        if (this.f20532e <= 0) {
            return this;
        }
        this.f20534i.removeMessages(2);
        this.f20531d = this.f20532e + SystemClock.elapsedRealtime();
        this.f20534i.sendMessageAtFrontOfQueue(this.f20534i.obtainMessage(1));
        return this;
    }

    public abstract void e();

    public final synchronized void a() {
        this.f20533f = true;
        this.f20534i.removeMessages(1);
    }

    public final synchronized w b() {
        this.f20533f = false;
        if (this.b <= 0) {
            e();
            return this;
        }
        this.f20531d = SystemClock.elapsedRealtime() + this.b;
        this.f20534i.sendMessage(this.f20534i.obtainMessage(1));
        return this;
    }

    public final synchronized w c() {
        this.f20533f = false;
        this.f20532e = this.f20531d - SystemClock.elapsedRealtime();
        if (this.f20532e <= 0) {
            return this;
        }
        this.f20534i.removeMessages(1);
        this.f20534i.sendMessageAtFrontOfQueue(this.f20534i.obtainMessage(2));
        return this;
    }
}
