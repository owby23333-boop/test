package com.bytedance.msdk.z.gc;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.utils.wp;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f502a = null;
    private static boolean dl = false;
    private static final int e;
    private static final ThreadPoolExecutor fo;
    private static final Object g = new Object();
    private static HandlerThread gc = null;
    private static final int gz;
    private static Handler m = null;
    private static final Executor uy;
    static final /* synthetic */ boolean z = true;

    static {
        z();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        e = iAvailableProcessors;
        gz = Math.min(iAvailableProcessors, 4);
        fo = fo();
        uy = uy();
    }

    public static void z() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            gc = handlerThread;
            handlerThread.start();
            m = new Handler(gc.getLooper());
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    private static boolean gz() {
        HandlerThread handlerThread = gc;
        return (handlerThread == null || !handlerThread.isAlive() || m == null) ? false : true;
    }

    public static void z(Runnable runnable) {
        if (gz()) {
            if (dl()) {
                runnable.run();
                return;
            } else {
                m.post(runnable);
                return;
            }
        }
        z();
    }

    public static void z(Runnable runnable, long j) {
        if (gz()) {
            m.postDelayed(runnable, j);
        } else {
            z();
        }
    }

    public static Looper g() {
        if (gz()) {
            return gc.getLooper();
        }
        return null;
    }

    public static boolean dl() {
        return gz() && gc.getLooper() == Looper.myLooper();
    }

    public static ThreadFactory z(final String str) {
        return new ThreadFactory() { // from class: com.bytedance.msdk.z.gc.m.1
            private final AtomicInteger g = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new com.bytedance.sdk.component.uy.a.dl(runnable, str + " # " + this.g.getAndIncrement());
            }
        };
    }

    public static Handler a() {
        Handler handler;
        synchronized (g) {
            if (f502a == null) {
                if (dl) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                f502a = new Handler(Looper.getMainLooper());
            }
            handler = f502a;
        }
        return handler;
    }

    public static void g(Runnable runnable) {
        if (gc()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        z(futureTask);
        try {
            futureTask.get();
        } catch (Exception e2) {
            throw new RuntimeException("Exception occured while waiting for runnable", e2);
        }
    }

    public static void dl(Runnable runnable) {
        if (gc()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }

    public static <T> FutureTask<T> z(FutureTask<T> futureTask) {
        a().post(futureTask);
        return futureTask;
    }

    public static void g(Runnable runnable, long j) {
        a().postDelayed(runnable, j);
    }

    public static boolean gc() {
        return a().getLooper() == Looper.myLooper();
    }

    public static ExecutorService z(String str, int i, RejectedExecutionHandler rejectedExecutionHandler) {
        return new com.bytedance.sdk.component.uy.a.a(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(i), z("gm_t_single_".concat(String.valueOf(str))), rejectedExecutionHandler);
    }

    private static ThreadPoolExecutor fo() {
        int i = gz;
        com.bytedance.sdk.component.uy.a.a aVar = new com.bytedance.sdk.component.uy.a.a(i, i, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), z("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.bytedance.msdk.z.gc.m.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                com.bytedance.msdk.e.g.z.z().dl();
            }
        });
        try {
            aVar.allowCoreThreadTimeOut(true);
        } catch (Exception e2) {
            wp.dl("ThreadHelper", "stackerror:", e2);
        } catch (NoSuchMethodError e3) {
            wp.z(e3);
        }
        return aVar;
    }

    public static Executor m() {
        return fo;
    }

    private static Executor uy() {
        return new com.bytedance.sdk.component.uy.a.a(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), z("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    public static Executor e() {
        return uy;
    }

    public static void a(Runnable runnable) {
        z(fo, runnable);
    }

    public static <T> Future<T> z(Callable<T> callable) {
        try {
            return fo.submit(callable);
        } catch (Exception e2) {
            wp.dl("ThreadHelper", "stackerror:", e2);
            return null;
        }
    }

    private static boolean z(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Exception e2) {
            wp.dl("ThreadHelper", "stackerror:", e2);
            return false;
        }
    }
}
