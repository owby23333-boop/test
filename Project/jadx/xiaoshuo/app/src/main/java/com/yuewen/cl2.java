package com.yuewen;

import com.duokan.core.diagnostic.LogLevel;
import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes12.dex */
public abstract class cl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9681a = "PooledThread";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f9682b;
    public static final int c;
    public static final ScheduledExecutorService d;
    public static final ThreadPoolExecutor e;
    public static final int f = 50;
    public static int g;
    public static final ThreadPoolExecutor h;
    public static final LinkedList<h<?>> i;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f9683a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9684b;

        public a(h hVar, String str) {
            this.f9683a = hVar;
            this.f9684b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            cl2.i.add(this.f9683a);
            cl2.w(this.f9684b);
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f9685a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9686b;

        public b(i iVar, String str) {
            this.f9685a = iVar;
            this.f9686b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            cl2.i.add(this.f9685a);
            cl2.w(this.f9686b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f9687a;

        public c(j jVar) {
            this.f9687a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            cl2.h.submit(this.f9687a);
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f9688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9689b;

        public d(h hVar, String str) {
            this.f9688a = hVar;
            this.f9689b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            cl2.i.add(this.f9688a);
            cl2.w(this.f9689b);
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f9690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9691b;

        public e(i iVar, String str) {
            this.f9690a = iVar;
            this.f9691b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            cl2.i.add(this.f9690a);
            cl2.w(this.f9691b);
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ j f9692a;

        public f(j jVar) {
            this.f9692a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            cl2.q(this.f9692a);
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f9682b = iAvailableProcessors;
        int i2 = (iAvailableProcessors * 2) + 1;
        c = i2;
        d = Executors.newSingleThreadScheduledExecutor();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e = new ThreadPoolExecutor(1, i2, 60L, timeUnit, new LinkedBlockingQueue(), new g("IOTask"));
        g = 50;
        h = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, new SynchronousQueue());
        i = new LinkedList<>();
    }

    public static <T> Future<T> f(Callable<T> callable) {
        l(m());
        return h.submit(callable);
    }

    public static <T> Future<?> g(Callable<T> callable) {
        return h(callable, "");
    }

    public static <T> Future<T> h(Callable<T> callable, String str) {
        h hVar = new h(str, callable);
        d.submit(new d(hVar, str));
        return hVar;
    }

    public static <T> ScheduledFuture<T> i(Callable<T> callable, long j2) {
        return j(callable, "", j2);
    }

    public static <T> ScheduledFuture<T> j(Callable<T> callable, String str, long j2) {
        i iVar = new i(str, callable, System.currentTimeMillis() + j2);
        d.schedule(new e(iVar, str), j2, TimeUnit.MILLISECONDS);
        return iVar;
    }

    public static <T> ScheduledFuture<T> k(Callable<T> callable, long j2) {
        j jVar = new j(callable, System.currentTimeMillis() + j2);
        d.schedule(new f(jVar), j2, TimeUnit.MILLISECONDS);
        return jVar;
    }

    public static void l(int i2) {
        int i3 = g;
        if (i2 <= i3) {
            if (i2 < 50) {
                g = 50;
                return;
            }
            return;
        }
        g = i3 + 1;
        ia0.w().f(LogLevel.WARNING, f9681a, "too large pool size :" + i2);
    }

    public static int m() {
        return h.getPoolSize();
    }

    public static /* synthetic */ void n(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            qt1.e(f9681a, "wrapRunnableForDebug crash. ", th);
            throw th;
        }
    }

    public static <T> Future<T> o(Callable<T> callable) {
        return e.submit(callable);
    }

    public static void p(Runnable runnable) {
        e.execute(x(runnable));
    }

    public static Future<?> q(Runnable runnable) {
        l(m());
        return h.submit(x(runnable));
    }

    public static Future<?> r(Runnable runnable) {
        return s(runnable, "");
    }

    public static Future<?> s(Runnable runnable, String str) {
        h hVar = new h(str, x(runnable));
        d.submit(new a(hVar, str));
        return hVar;
    }

    public static ScheduledFuture<?> t(Runnable runnable, long j2) {
        return u(runnable, "", j2);
    }

    public static ScheduledFuture<?> u(Runnable runnable, String str, long j2) {
        i iVar = new i(str, x(runnable), System.currentTimeMillis() + j2);
        d.schedule(new b(iVar, str), j2, TimeUnit.MILLISECONDS);
        return iVar;
    }

    public static ScheduledFuture<?> v(Runnable runnable, long j2) {
        j jVar = new j(x(runnable), System.currentTimeMillis() + j2);
        d.schedule(new c(jVar), j2, TimeUnit.MILLISECONDS);
        return jVar;
    }

    public static void w(String str) {
        for (h<?> hVar : i) {
            if (hVar.f9695a.equals(str)) {
                if (hVar.f9696b) {
                    return;
                }
                hVar.f9696b = true;
                q(hVar);
                return;
            }
        }
    }

    public static Runnable x(final Runnable runnable) {
        return (!qt1.g() || runnable == null) ? runnable : new Runnable() { // from class: com.yuewen.bl2
            @Override // java.lang.Runnable
            public final void run() {
                cl2.n(runnable);
            }
        };
    }

    public static class i<T> extends h<T> implements ScheduledFuture<T> {
        public final long c;

        public i(String str, Runnable runnable, long j) {
            super(str, runnable);
            this.c = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long delay = getDelay(timeUnit) - delayed.getDelay(timeUnit);
            if (delay == 0) {
                return 0;
            }
            return delay > 0 ? 1 : -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(Math.max(0L, this.c - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
        }

        public i(String str, Callable<T> callable, long j) {
            super(str, callable);
            this.c = j;
        }
    }

    public static class j<T> extends FutureTask<T> implements ScheduledFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f9698a;

        public j(Runnable runnable, long j) {
            super(runnable, null);
            this.f9698a = j;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long delay = getDelay(timeUnit) - delayed.getDelay(timeUnit);
            if (delay == 0) {
                return 0;
            }
            return delay > 0 ? 1 : -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return timeUnit.convert(Math.max(0L, this.f9698a - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
        }

        public j(Callable<T> callable, long j) {
            super(callable);
            this.f9698a = j;
        }
    }

    public static class h<T> extends FutureTask<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9696b;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                cl2.i.remove(h.this);
                h.this.f9696b = false;
                cl2.w(h.this.f9695a);
            }
        }

        public h(String str, Runnable runnable) {
            super(runnable, null);
            this.f9696b = false;
            this.f9695a = str;
        }

        @Override // java.util.concurrent.FutureTask, java.util.concurrent.RunnableFuture, java.lang.Runnable
        public void run() {
            ScheduledExecutorService scheduledExecutorService;
            a aVar;
            try {
                super.run();
                scheduledExecutorService = cl2.d;
                aVar = new a();
            } catch (Throwable th) {
                try {
                    if (qt1.g()) {
                        qt1.b(cl2.f9681a, "-->QueuedTask.run(): encount fc", th);
                    }
                    scheduledExecutorService = cl2.d;
                    aVar = new a();
                } catch (Throwable th2) {
                    cl2.d.submit(new a());
                    throw th2;
                }
            }
            scheduledExecutorService.submit(aVar);
        }

        public h(String str, Callable<T> callable) {
            super(callable);
            this.f9696b = false;
            this.f9695a = str;
        }
    }

    public static class g implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9694b;
        public final AtomicInteger c;

        public g(String str) {
            this.f9694b = 5;
            this.c = new AtomicInteger(1);
            this.f9693a = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f9693a + "-pool-thread-" + this.c.getAndIncrement());
            int i = this.f9694b;
            if (i != 5) {
                thread.setPriority(i);
            }
            return thread;
        }

        public g(String str, int i) {
            this.f9694b = 5;
            this.c = new AtomicInteger(1);
            this.f9693a = str;
            this.f9694b = i;
        }
    }
}
