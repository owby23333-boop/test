package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class bg extends Thread {
    public bf a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f18665g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f18661c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f18662d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f18663e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18664f = 1;
    public boolean b = true;

    /* JADX INFO: compiled from: BUGLY */
    public interface a {
    }

    public final boolean a() {
        this.f18661c = true;
        if (!isAlive()) {
            return false;
        }
        try {
            interrupt();
        } catch (Exception e2) {
            al.b(e2);
        }
        al.d("MainHandlerChecker is reset to null.", new Object[0]);
        this.a = null;
        return true;
    }

    public final boolean b() {
        Handler handler = new Handler(Looper.getMainLooper());
        bf bfVar = this.a;
        if (bfVar != null) {
            bfVar.b = 5000L;
        } else {
            this.a = new bf(handler, handler.getLooper().getThread().getName());
        }
        if (isAlive()) {
            return false;
        }
        try {
            start();
            return true;
        } catch (Exception e2) {
            al.b(e2);
            return false;
        }
    }

    public final synchronized void c() {
        this.f18662d = false;
        al.c("Record stack trace is disabled.", new Object[0]);
    }

    public final synchronized void d() {
        this.f18663e = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!this.f18661c) {
            try {
                boolean z2 = false;
                if (this.a == null) {
                    al.c("Main handler checker is null. Stop thread monitor.", new Object[0]);
                    return;
                }
                bf bfVar = this.a;
                if (bfVar.f18656c) {
                    bfVar.f18656c = false;
                    bfVar.f18657d = SystemClock.uptimeMillis();
                    bfVar.a.post(bfVar);
                }
                a(bfVar);
                boolean z3 = true;
                if (this.b && this.f18662d) {
                    long jB = bfVar.b();
                    if (jB > 1510 && jB < 199990) {
                        if (jB <= 5010) {
                            this.f18664f = 1;
                            al.c("timeSinceMsgSent in [2s, 5s], record stack", new Object[0]);
                            z2 = true;
                        } else {
                            this.f18664f++;
                            if ((this.f18664f & (this.f18664f - 1)) != 0) {
                                z3 = false;
                            }
                            if (z3) {
                                al.c("timeSinceMsgSent in (5s, 200s), should record stack:true", new Object[0]);
                            }
                            z2 = z3;
                        }
                    }
                }
                if (z2) {
                    bfVar.d();
                }
                if (this.f18665g != null && this.f18662d) {
                    bfVar.a();
                    bfVar.b();
                }
                ap.b(500 - ((System.currentTimeMillis() - jCurrentTimeMillis) % 500));
            } catch (Exception e2) {
                al.b(e2);
            } catch (OutOfMemoryError e3) {
                al.b(e3);
            }
        }
    }

    private synchronized void a(bf bfVar) {
        if (this.f18662d) {
            return;
        }
        if (this.f18663e && !bfVar.a()) {
            al.c("Restart getting main stack trace.", new Object[0]);
            this.f18662d = true;
            this.f18663e = false;
        }
    }
}
