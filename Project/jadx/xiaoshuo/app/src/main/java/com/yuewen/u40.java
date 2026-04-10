package com.yuewen;

import com.duokan.core.diagnostic.LogLevel;

/* JADX INFO: loaded from: classes12.dex */
public class u40<T> {
    public static final String c = "ComingObj";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f18356a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f18357b = null;

    public boolean a() {
        return this.f18357b != null;
    }

    public T b() {
        return c(0);
    }

    public T c(int i) {
        T t = this.f18357b;
        if (t != null) {
            return t;
        }
        synchronized (this.f18356a) {
            T t2 = this.f18357b;
            if (t2 != null) {
                return t2;
            }
            boolean zG = rv1.g();
            if (zG) {
                ia0.w().i(LogLevel.WARNING, getClass().getSimpleName(), "too early to access a coming object in main thread...");
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                if (i <= 0) {
                    this.f18356a.wait();
                    ia0.w().s(this.f18357b != null);
                } else {
                    this.f18356a.wait(i);
                }
            } catch (InterruptedException e) {
                ia0.w().j(LogLevel.ERROR, "coming", "get meet error:", e);
            }
            if (zG && this.f18357b != null) {
                ia0.w().g(LogLevel.WARNING, getClass().getSimpleName(), "block main thread for %s for %dms", this.f18357b.getClass().getName(), Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
            }
            return this.f18357b;
        }
    }

    public T d(long j) {
        T t = this.f18357b;
        if (t != null) {
            return t;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        synchronized (this.f18356a) {
            T t2 = this.f18357b;
            if (t2 != null) {
                return t2;
            }
            while (System.currentTimeMillis() - jCurrentTimeMillis < j) {
                try {
                    this.f18356a.wait(Math.max(1L, j - (System.currentTimeMillis() - jCurrentTimeMillis)));
                    break;
                } catch (InterruptedException unused) {
                }
            }
            if (rv1.g()) {
                ia0.w().i(LogLevel.WARNING, c, String.format("blocked %dms in main thread", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis)));
            } else if (System.currentTimeMillis() - jCurrentTimeMillis >= j) {
                ia0.w().i(LogLevel.WARNING, c, String.format("blocked %dms in thread '%s'", Long.valueOf(System.currentTimeMillis() - jCurrentTimeMillis), b80.a().toString()));
            }
            return this.f18357b;
        }
    }

    public void e(T t) {
        boolean z = true;
        ia0.w().s(t != null);
        if (t == null) {
            return;
        }
        synchronized (this.f18356a) {
            ia0 ia0VarW = ia0.w();
            if (this.f18357b != null) {
                z = false;
            }
            ia0VarW.s(z);
            if (this.f18357b != null) {
                return;
            }
            this.f18357b = t;
            this.f18356a.notifyAll();
        }
    }
}
