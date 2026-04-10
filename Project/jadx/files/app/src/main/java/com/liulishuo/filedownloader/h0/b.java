package com.liulishuo.filedownloader.h0;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: FileDownloadExecutors.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: compiled from: FileDownloadExecutors.java */
    static class a implements ThreadFactory {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final String f17204s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private final AtomicInteger f17206u = new AtomicInteger(1);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final ThreadGroup f17205t = Thread.currentThread().getThreadGroup();

        static {
            new AtomicInteger(1);
        }

        a(String str) {
            this.f17204s = f.l(str);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f17205t, runnable, this.f17204s + this.f17206u.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public static ThreadPoolExecutor a(String str) {
        return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15L, TimeUnit.SECONDS, new SynchronousQueue(), new a(str));
    }

    public static ThreadPoolExecutor a(int i2, String str) {
        return a(i2, new LinkedBlockingQueue(), str);
    }

    public static ThreadPoolExecutor a(int i2, LinkedBlockingQueue<Runnable> linkedBlockingQueue, String str) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, linkedBlockingQueue, new a(str));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
