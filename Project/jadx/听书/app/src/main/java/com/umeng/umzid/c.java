package com.umeng.umzid;

import android.util.Log;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile ScheduledThreadPoolExecutor f2400a;
    public static ThreadFactory b = new a();

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AtomicInteger f2401a = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("ZIDThreadPoolExecutor" + this.f2401a.addAndGet(1));
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor a() {
        if (f2400a == null) {
            synchronized (c.class) {
                if (f2400a == null) {
                    f2400a = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4, b);
                }
            }
        }
        return f2400a;
    }

    public static void a(Runnable runnable) {
        try {
            a().execute(runnable);
        } catch (Throwable unused) {
            Log.e("com.umeng.umzid.c", "UmengThreadPoolExecutorFactory execute exception");
        }
    }
}
