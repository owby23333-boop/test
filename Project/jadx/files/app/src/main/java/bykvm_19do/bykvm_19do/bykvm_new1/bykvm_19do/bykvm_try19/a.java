package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_try19;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {
    private Handler a;
    private final long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f2009c;

    a(Handler handler, long j2, long j3) {
        this.a = handler;
        this.b = j2;
        this.f2009c = j3;
    }

    void a() {
        long jB = b();
        Handler handler = this.a;
        if (jB > 0) {
            handler.postDelayed(this, b());
        } else {
            handler.post(this);
        }
    }

    void a(long j2) {
        if (j2 > 0) {
            this.a.postDelayed(this, j2);
        } else {
            this.a.post(this);
        }
    }

    long b() {
        return this.b;
    }

    long c() {
        return this.f2009c;
    }
}
