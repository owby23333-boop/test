package com.bumptech.glide.load.engine.z;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements ExecutorService {
    private static final long b = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile int f13649c;
    private final ExecutorService a;

    /* JADX INFO: compiled from: GlideExecutor.java */
    private static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.z.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0263a extends Thread {
            C0263a(c cVar, Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        private c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new C0263a(this, runnable);
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    private static final class d implements ThreadFactory {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private final ThreadFactory f13655s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private final String f13656t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        final e f13657u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        final boolean f13658v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private final AtomicInteger f13659w = new AtomicInteger();

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.z.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class RunnableC0264a implements Runnable {

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            final /* synthetic */ Runnable f13660s;

            RunnableC0264a(Runnable runnable) {
                this.f13660s = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f13658v) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f13660s.run();
                } catch (Throwable th) {
                    d.this.f13657u.a(th);
                }
            }
        }

        d(ThreadFactory threadFactory, String str, e eVar, boolean z2) {
            this.f13655s = threadFactory;
            this.f13656t = str;
            this.f13657u = eVar;
            this.f13658v = z2;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread threadNewThread = this.f13655s.newThread(new RunnableC0264a(runnable));
            threadNewThread.setName("glide-" + this.f13656t + "-thread-" + this.f13659w.getAndIncrement());
            return threadNewThread;
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public interface e {
        public static final e a;
        public static final e b;

        /* JADX INFO: renamed from: com.bumptech.glide.load.engine.z.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0265a implements e {
            C0265a() {
            }

            @Override // com.bumptech.glide.load.engine.z.a.e
            public void a(Throwable th) {
            }
        }

        /* JADX INFO: compiled from: GlideExecutor.java */
        class b implements e {
            b() {
            }

            @Override // com.bumptech.glide.load.engine.z.a.e
            public void a(Throwable th) {
                if (th != null) {
                    Log.isLoggable("GlideExecutor", 6);
                }
            }
        }

        /* JADX INFO: compiled from: GlideExecutor.java */
        class c implements e {
            c() {
            }

            @Override // com.bumptech.glide.load.engine.z.a.e
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            new C0265a();
            a = new b();
            new c();
            b = a;
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.a = executorService;
    }

    public static int a() {
        if (f13649c == 0) {
            f13649c = Math.min(4, com.bumptech.glide.load.engine.z.b.a());
        }
        return f13649c;
    }

    public static b b() {
        int i2 = a() >= 4 ? 2 : 1;
        b bVar = new b(true);
        bVar.a(i2);
        bVar.a("animation");
        return bVar;
    }

    public static a c() {
        return b().a();
    }

    public static b d() {
        b bVar = new b(true);
        bVar.a(1);
        bVar.a("disk-cache");
        return bVar;
    }

    public static a e() {
        return d().a();
    }

    public static b f() {
        b bVar = new b(false);
        bVar.a(a());
        bVar.a("source");
        return bVar;
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), "source-unlimited", e.b, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public static final class b {
        private final boolean a;
        private int b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f13650c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private final ThreadFactory f13651d = new c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NonNull
        private e f13652e = e.b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f13653f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f13654g;

        b(boolean z2) {
            this.a = z2;
        }

        public b a(@IntRange(from = 1) int i2) {
            this.b = i2;
            this.f13650c = i2;
            return this;
        }

        public b a(String str) {
            this.f13653f = str;
            return this;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f13653f)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.f13650c, this.f13654g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.f13651d, this.f13653f, this.f13652e, this.a));
                if (this.f13654g != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f13653f);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t2) {
        return this.a.submit(runnable, t2);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.a.submit(callable);
    }
}
