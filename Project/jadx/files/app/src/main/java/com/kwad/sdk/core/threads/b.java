package com.kwad.sdk.core.threads;

import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static String TAG;
    private static final int alL;
    private static final int alM;
    private static final int alN;
    private static Map<String, WeakReference<ExecutorService>> alO;

    interface a {
        @NonNull
        ExecutorService yk();
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.threads.b$b, reason: collision with other inner class name */
    static class C0445b implements a {
        private C0445b() {
        }

        /* synthetic */ C0445b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService yk() {
            return new com.kwad.sdk.core.threads.kwai.b(b.alM, b.alN, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp"));
        }
    }

    static class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService yk() {
            return new com.kwad.sdk.core.threads.kwai.b(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new d(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    public static class d implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public d(int i2, String str) {
            this.threadPriority = i2;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.group, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    static class e implements a {
        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService yk() {
            return new com.kwad.sdk.core.threads.kwai.b(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "uil-pool-"));
        }
    }

    static class f implements a {
        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService yk() {
            return new com.kwad.sdk.core.threads.kwai.b(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache"));
        }
    }

    static class g implements a {
        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService yk() {
            return new com.kwad.sdk.core.threads.kwai.b(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new d(3, "report-"));
        }
    }

    static class h implements a {
        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.b.a
        @NonNull
        public final ExecutorService yk() {
            return new com.kwad.sdk.core.threads.kwai.b(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "videoCache"));
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        alL = iAvailableProcessors;
        int i2 = iAvailableProcessors > 0 ? alL + 4 : 9;
        alM = i2;
        alN = i2;
        TAG = "GlobalThreadPools";
        alO = new ConcurrentHashMap();
    }

    @NonNull
    private static ExecutorService a(String str, @NonNull a aVar) {
        WeakReference<ExecutorService> weakReference = alO.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        ExecutorService executorServiceYk = aVar.yk();
        alO.put(str, new WeakReference<>(executorServiceYk));
        return executorServiceYk;
    }

    public static ExecutorService cr(String str) {
        if (!alO.containsKey(str) || alO.get(str) == null) {
            return null;
        }
        return alO.get(str).get();
    }

    public static ExecutorService xW() {
        return a("lruDiskCache", new f((byte) 0));
    }

    public static synchronized ExecutorService xX() {
        com.kwad.sdk.core.d.b.d(TAG, "forKsImageLoaderTask");
        return a("ksImageLoaderTask", new e((byte) 0));
    }

    public static synchronized ExecutorService xY() {
        com.kwad.sdk.core.d.b.d(TAG, "forKsImageLoaderCachedImages");
        return a("ksImageLoaderTask", new e((byte) 0));
    }

    public static ExecutorService xZ() {
        com.kwad.sdk.core.d.b.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new c((byte) 0));
    }

    public static synchronized ExecutorService ya() {
        com.kwad.sdk.core.d.b.d(TAG, "forBaseBatchReporter");
        return a(AgooConstants.MESSAGE_REPORT, new g((byte) 0));
    }

    public static synchronized ExecutorService yb() {
        com.kwad.sdk.core.d.b.d(TAG, "forAdReportManager");
        return a(AgooConstants.MESSAGE_REPORT, new g((byte) 0));
    }

    public static ExecutorService yc() {
        com.kwad.sdk.core.d.b.d(TAG, "forBaseNetwork");
        return a("httpIO", new C0445b((byte) 0));
    }

    public static ExecutorService yd() {
        com.kwad.sdk.core.d.b.d(TAG, "forHttpCacheServer");
        return a("videoCache", new h((byte) 0));
    }

    public static ExecutorService ye() {
        com.kwad.sdk.core.d.b.d(TAG, "forAppStatusHelper");
        return new com.kwad.sdk.core.threads.kwai.b(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.b.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService yf() {
        com.kwad.sdk.core.d.b.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.b.2
            @Override // com.kwad.sdk.core.threads.b.a
            @NonNull
            public final ExecutorService yk() {
                return new com.kwad.sdk.core.threads.kwai.b(3, 3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "async"));
            }
        });
    }

    public static ScheduledExecutorService yg() {
        com.kwad.sdk.core.d.b.d(TAG, "forAsyncSchedule");
        ExecutorService executorServiceA = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.b.3
            @Override // com.kwad.sdk.core.threads.b.a
            @NonNull
            public final ExecutorService yk() {
                return new com.kwad.sdk.core.threads.kwai.a(1, new d(5, "async-schedule"));
            }
        });
        return executorServiceA instanceof ScheduledExecutorService ? (ScheduledExecutorService) executorServiceA : new com.kwad.sdk.core.threads.kwai.a(1, new d(5, "async-schedule"));
    }

    public static Set<String> yh() {
        return alO.keySet();
    }
}
