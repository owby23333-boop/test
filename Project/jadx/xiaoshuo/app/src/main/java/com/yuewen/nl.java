package com.yuewen;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: loaded from: classes5.dex */
public class nl implements Runnable {
    public static final boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f14884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14885b;

    public nl(Runnable runnable) {
        this.f14884a = runnable;
    }

    public static boolean b(Runnable runnable, Handler handler, long j) {
        if (runnable == null) {
            throw new IllegalArgumentException("runnable must not be null");
        }
        if (handler == null) {
            throw new IllegalArgumentException("handler must not be null");
        }
        if (Looper.myLooper() != handler.getLooper()) {
            return new nl(runnable).a(handler, j);
        }
        runnable.run();
        return true;
    }

    public final boolean a(Handler handler, long j) {
        if (!handler.post(this)) {
            return false;
        }
        synchronized (this) {
            if (this.f14885b) {
                return true;
            }
            if (j < 0) {
                try {
                    wait();
                    return true;
                } catch (InterruptedException unused) {
                    return false;
                }
            }
            try {
                wait(j);
                return true;
            } catch (InterruptedException unused2) {
                return false;
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f14884a.run();
            synchronized (this) {
                this.f14885b = true;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.f14885b = true;
                notifyAll();
                throw th;
            }
        }
    }
}
