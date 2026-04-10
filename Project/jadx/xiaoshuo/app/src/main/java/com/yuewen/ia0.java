package com.yuewen;

import android.os.Handler;
import android.os.Looper;
import com.duokan.core.diagnostic.LogLevel;
import com.xiaomi.onetrack.CrashAnalysis;
import java.lang.Thread;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes12.dex */
public class ia0 extends rt1 {
    public static final Object h = new Object();
    public static ia0 i;
    public final Thread.UncaughtExceptionHandler d;
    public final AtomicReference<c> c = new AtomicReference<>();
    public final HashMap<Object, Long> e = new HashMap<>();
    public boolean f = false;
    public b g = null;

    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            if (ia0.this.f) {
                ia0.this.j(LogLevel.DISASTER, "crash", "crash detected!", th);
            }
            if (ia0.this.d != null) {
                ia0.this.d.uncaughtException(thread, th);
            }
        }
    }

    public interface b {
        void a();
    }

    public class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f12437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public StackTraceElement[] f12438b;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f12439a = false;

            public a() {
            }

            public void a() {
                this.f12439a = false;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f12439a = true;
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Handler handler = new Handler(Looper.getMainLooper());
            a aVar = new a();
            while (!this.f12437a) {
                aVar.a();
                handler.post(aVar);
                try {
                    Thread.sleep(5000L);
                    if (!aVar.f12439a) {
                        handler.removeCallbacks(aVar);
                        StackTraceElement[] stackTraceElementArr = this.f12438b;
                        StackTraceElement[] stackTrace = rv1.e().getStackTrace();
                        this.f12438b = stackTrace;
                        if (stackTrace.length == stackTraceElementArr.length) {
                            boolean z = false;
                            int i = 0;
                            while (true) {
                                StackTraceElement[] stackTraceElementArr2 = this.f12438b;
                                if (i >= stackTraceElementArr2.length) {
                                    z = true;
                                    break;
                                } else if (!stackTraceElementArr2[i].equals(stackTraceElementArr[i])) {
                                    break;
                                } else {
                                    i++;
                                }
                            }
                            if (z) {
                            }
                        }
                        ia0.this.e(LogLevel.WARNING, CrashAnalysis.ANR_CRASH, "ANR detected!");
                        b bVar = ia0.this.g;
                        if (bVar != null) {
                            bVar.a();
                        }
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Throwable unused2) {
                }
            }
        }

        public c() {
            this.f12437a = false;
            this.f12438b = new StackTraceElement[0];
        }
    }

    public ia0() {
        b(false);
        this.d = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new a());
    }

    public static ia0 w() {
        ia0 ia0Var = i;
        if (ia0Var != null) {
            return ia0Var;
        }
        synchronized (h) {
            ia0 ia0Var2 = i;
            if (ia0Var2 != null) {
                return ia0Var2;
            }
            ia0 ia0Var3 = new ia0();
            i = ia0Var3;
            return ia0Var3;
        }
    }

    public void A(boolean z) {
        c andSet;
        if (z) {
            c cVar = new c();
            andSet = this.c.getAndSet(cVar);
            cVar.start();
        } else {
            andSet = this.c.getAndSet(null);
        }
        if (andSet != null) {
            andSet.f12437a = true;
        }
    }

    public void B(boolean z) {
        this.f = z;
    }

    public void o(String str) {
        try {
            throw new AssertionError();
        } catch (Throwable unused) {
            LogLevel logLevel = LogLevel.WARNING;
            if (str == null) {
                str = "assertion error!";
            }
            i(logLevel, "assert", str);
        }
    }

    public void p(boolean z) {
        s(!z);
    }

    public void q() {
        s(rv1.g());
    }

    public void r() {
        p(rv1.g());
    }

    public void s(boolean z) {
        if (z) {
            return;
        }
        o(null);
    }

    public void t() {
        p(true);
    }

    public void u(String str) {
        synchronized (this.e) {
            this.e.remove(str);
        }
    }

    public long v(String str) {
        long jMax;
        synchronized (this.e) {
            Long l = this.e.get(str);
            long jCurrentTimeMillis = System.currentTimeMillis();
            jMax = 0;
            if (l != null) {
                jMax = Math.max(0L, jCurrentTimeMillis - l.longValue());
            }
            this.e.put(str, Long.valueOf(jCurrentTimeMillis));
        }
        return jMax;
    }

    public boolean x() {
        return this.c.get() != null;
    }

    public boolean y() {
        return this.f;
    }

    public void z(b bVar) {
        this.g = bVar;
    }
}
