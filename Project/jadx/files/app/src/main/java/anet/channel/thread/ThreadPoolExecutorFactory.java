package anet.channel.thread;

import anet.channel.util.ALog;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class ThreadPoolExecutorFactory {
    private static ScheduledThreadPoolExecutor a = new ScheduledThreadPoolExecutor(1, new b("AWCN Scheduler"));
    private static ThreadPoolExecutor b = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(H)"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ThreadPoolExecutor f487c = new anet.channel.thread.a(16, 16, 60, TimeUnit.SECONDS, new PriorityBlockingQueue(), new b("AWCN Worker(M)"));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f488d = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(L)"));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ThreadPoolExecutor f489e = new ThreadPoolExecutor(32, 32, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Worker(Backup)"));

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ThreadPoolExecutor f490f = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Detector"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ThreadPoolExecutor f491g = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN HR"));

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static ThreadPoolExecutor f492h = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, new LinkedBlockingDeque(), new b("AWCN Cookie"));

    /* JADX INFO: compiled from: Taobao */
    public static class Priority {
        public static int HIGH = 0;
        public static int LOW = 9;
        public static int NORMAL = 1;
    }

    /* JADX INFO: compiled from: Taobao */
    static class a implements Comparable<a>, Runnable {
        Runnable a;
        int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f493c;

        public a(Runnable runnable, int i2) {
            this.a = null;
            this.b = 0;
            this.f493c = System.currentTimeMillis();
            this.a = runnable;
            this.b = i2;
            this.f493c = System.currentTimeMillis();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            int i2 = this.b;
            int i3 = aVar.b;
            return i2 != i3 ? i2 - i3 : (int) (aVar.f493c - this.f493c);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.run();
        }
    }

    /* JADX INFO: compiled from: Taobao */
    private static class b implements ThreadFactory {
        AtomicInteger a = new AtomicInteger(0);
        String b;

        b(String str) {
            this.b = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.b + this.a.incrementAndGet());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", null, "name", thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    static {
        b.allowCoreThreadTimeOut(true);
        f487c.allowCoreThreadTimeOut(true);
        f488d.allowCoreThreadTimeOut(true);
        f489e.allowCoreThreadTimeOut(true);
        f490f.allowCoreThreadTimeOut(true);
        f491g.allowCoreThreadTimeOut(true);
        f492h.allowCoreThreadTimeOut(true);
    }

    public static void removeScheduleTask(Runnable runnable) {
        a.remove(runnable);
    }

    public static synchronized void setNormalExecutorPoolSize(int i2) {
        if (i2 < 6) {
            i2 = 6;
        }
        f487c.setCorePoolSize(i2);
        f487c.setMaximumPoolSize(i2);
    }

    public static Future<?> submitBackupTask(Runnable runnable) {
        return f489e.submit(runnable);
    }

    public static Future<?> submitCookieMonitor(Runnable runnable) {
        return f492h.submit(runnable);
    }

    public static Future<?> submitDetectTask(Runnable runnable) {
        return f490f.submit(runnable);
    }

    public static Future<?> submitHRTask(Runnable runnable) {
        return f491g.submit(runnable);
    }

    public static Future<?> submitPriorityTask(Runnable runnable, int i2) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, "priority", Integer.valueOf(i2));
        }
        if (i2 < Priority.HIGH || i2 > Priority.LOW) {
            i2 = Priority.LOW;
        }
        return i2 == Priority.HIGH ? b.submit(runnable) : i2 == Priority.LOW ? f488d.submit(runnable) : f487c.submit(new a(runnable, i2));
    }

    public static Future<?> submitScheduledTask(Runnable runnable) {
        return a.submit(runnable);
    }

    public static Future<?> submitScheduledTask(Runnable runnable, long j2, TimeUnit timeUnit) {
        return a.schedule(runnable, j2, timeUnit);
    }
}
