package com.umeng.message.proguard;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.umeng.message.common.UPLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: UMExecutors.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    private static final String a = "UMExecutors";
    private static volatile ScheduledThreadPoolExecutor b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ExecutorService f20449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f20450d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ThreadFactory f20451e = new ThreadFactory() { // from class: com.umeng.message.proguard.c.1
        private final AtomicInteger a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("UMThread-" + this.a.incrementAndGet());
            return thread;
        }
    };

    /* JADX INFO: compiled from: UMExecutors.java */
    static class a implements Runnable {
        private final Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (this.a != null) {
                    this.a.run();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @SafeVarargs
    public static <Params, Progress, Result> void a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        try {
            asyncTask.executeOnExecutor(c(), paramsArr);
        } catch (Throwable th) {
            UPLog.e(a, "executeOnExecutor error:", th);
        }
    }

    private static ScheduledThreadPoolExecutor b() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new ScheduledThreadPoolExecutor(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors(), 4)), f20451e);
                    b.setKeepAliveTime(10L, TimeUnit.SECONDS);
                    b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }

    private static ExecutorService c() {
        if (f20449c == null) {
            synchronized (c.class) {
                if (f20449c == null) {
                    f20449c = Executors.newSingleThreadExecutor(f20451e);
                }
            }
        }
        return f20449c;
    }

    public static void d(Runnable runnable) {
        Runnable runnableF = f(runnable);
        if (Looper.myLooper() == f20450d.getLooper()) {
            runnableF.run();
        } else {
            f20450d.post(runnableF);
        }
    }

    public static void e(Runnable runnable) {
        f20450d.removeCallbacks(runnable);
    }

    private static Runnable f(Runnable runnable) {
        return new a(runnable);
    }

    public static void a(Runnable runnable) {
        try {
            c().submit(runnable);
        } catch (Throwable th) {
            UPLog.e(a, "submitSingleTask error:", th);
        }
    }

    public static Runnable a(Runnable runnable, long j2) {
        Runnable runnableF = f(runnable);
        f20450d.postDelayed(runnableF, j2);
        return runnableF;
    }

    public static Handler a() {
        return f20450d;
    }

    public static void c(Runnable runnable) {
        a aVar = new a(runnable);
        if (Looper.myLooper() == f20450d.getLooper()) {
            b(aVar);
        } else {
            aVar.run();
        }
    }

    public static void a(Runnable runnable, long j2, TimeUnit timeUnit) {
        try {
            b().schedule(runnable, j2, timeUnit);
        } catch (Throwable unused) {
            UPLog.e(a, "schedule exception");
        }
    }

    public static void b(Runnable runnable) {
        try {
            b().execute(runnable);
        } catch (Throwable unused) {
            UPLog.e(a, "execute exception");
        }
    }
}
