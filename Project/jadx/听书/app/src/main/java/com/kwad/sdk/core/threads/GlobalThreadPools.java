package com.kwad.sdk.core.threads;

import android.util.Log;
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

/* JADX INFO: loaded from: classes4.dex */
public final class GlobalThreadPools {
    private static String TAG;
    private static final int aJs;
    private static final int aJt;
    private static final int aJu;
    private static Map<String, WeakReference<ExecutorService>> aJv;
    private static Map<String, Integer> aJw;
    private static boolean aJx;

    enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    interface a {
        ExecutorService JE();
    }

    public static void Jj() {
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        aJs = iAvailableProcessors;
        if (iAvailableProcessors <= 0) {
            iAvailableProcessors = 9;
        }
        aJt = iAvailableProcessors;
        aJu = iAvailableProcessors;
        TAG = "GlobalThreadPools";
        aJv = new ConcurrentHashMap();
        aJw = new ConcurrentHashMap();
        aJx = true;
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] aJy;

        static {
            int[] iArr = new int[ParamType.values().length];
            aJy = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aJy[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aJy[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(String str, ParamType paramType, int i2) {
        String str2;
        int i3 = AnonymousClass4.aJy[paramType.ordinal()];
        if (i3 == 1) {
            str2 = str + "_core";
        } else if (i3 == 2) {
            str2 = str + "_max";
        } else {
            if (i3 != 3) {
                return i2;
            }
            str2 = str + "_keep_alive";
        }
        try {
            if (aJw.containsKey(str2) && aJw.get(str2) != null) {
                return aJw.get(str2).intValue();
            }
        } catch (Exception unused) {
        }
        return i2;
    }

    public static void q(String str, int i2) {
        aJw.put(str, Integer.valueOf(i2));
    }

    public static boolean Jk() {
        return aJx;
    }

    public static void Jl() {
        for (String str : aJv.keySet()) {
            if (aJv.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aJv.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(TimeUnit.SECONDS);
                int iA = a(str, ParamType.CORE, corePoolSize);
                int iA2 = a(str, ParamType.MAX, maximumPoolSize);
                try {
                    threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), TimeUnit.SECONDS);
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                }
                if (corePoolSize != iA || maximumPoolSize != iA2) {
                    if (corePoolSize <= iA2) {
                        threadPoolExecutor.setMaximumPoolSize(iA2);
                        threadPoolExecutor.setCorePoolSize(iA);
                    } else if (iA <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(iA);
                        threadPoolExecutor.setMaximumPoolSize(iA2);
                    }
                }
            }
        }
    }

    public static ExecutorService Jm() {
        if (Jk()) {
            return Jy();
        }
        return a("lruDiskCache", new h((byte) 0));
    }

    public static ExecutorService Jn() {
        return a("backSingle", new j((byte) 0));
    }

    public static synchronized ExecutorService Jo() {
        com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTask");
        return a("ksImageLoaderTask", new g((byte) 0));
    }

    public static synchronized ExecutorService Jp() {
        com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderCachedImages");
        return a("ksImageLoaderTask", new g((byte) 0));
    }

    public static ExecutorService Jq() {
        com.kwad.sdk.core.d.c.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new e((byte) 0));
    }

    public static synchronized ExecutorService Jr() {
        com.kwad.sdk.core.d.c.d(TAG, "forBaseBatchReporter");
        if (Jk()) {
            return Jy();
        }
        return a("report", new i((byte) 0));
    }

    public static synchronized ExecutorService Js() {
        com.kwad.sdk.core.d.c.d(TAG, "forAdReportManager");
        if (Jk()) {
            return Jy();
        }
        return a("report", new i((byte) 0));
    }

    public static ExecutorService Jt() {
        com.kwad.sdk.core.d.c.d(TAG, "forBaseNetwork");
        if (Jk()) {
            return Jy();
        }
        return a("httpIO", new b((byte) 0));
    }

    public static ExecutorService Ju() {
        com.kwad.sdk.core.d.c.d(TAG, "forCoreNetwork");
        if (Jk()) {
            return Jv();
        }
        return Jt();
    }

    private static ExecutorService Jv() {
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor");
        ExecutorService executorServiceA = a("httpIOForCoreV1", new c(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorServiceA;
        int poolSize = threadPoolExecutor.getPoolSize();
        int iA = a("httpIOForCoreV1", ParamType.CORE, 5);
        int iA2 = a("httpIOForCoreExtraV1", ParamType.MAX, 3);
        ExecutorService executorServiceA2 = a("httpIOForCoreExtraV1", new d(0 == true ? 1 : 0));
        ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) executorServiceA2;
        int poolSize2 = threadPoolExecutor2.getPoolSize();
        int activeCount = threadPoolExecutor.getActiveCount();
        int activeCount2 = threadPoolExecutor2.getActiveCount();
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize:" + poolSize + " configSize:" + iA);
        com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor extraPoolSize:" + poolSize2 + " extraConfigSize:" + iA2);
        com.kwad.sdk.core.d.c.e(TAG, "getCoreExecutor queueSize:" + (threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size()) + " extraQueueSize:" + (threadPoolExecutor2.getQueue() != null ? threadPoolExecutor2.getQueue().size() : 0));
        if (poolSize < iA) {
            com.kwad.sdk.core.d.c.d(TAG, "getCoreExecutor currentPoolSize < configSize");
            return executorServiceA;
        }
        if (activeCount < iA) {
            com.kwad.sdk.core.d.c.e(TAG, "activeCount < configSize");
            return executorServiceA;
        }
        if (activeCount2 == iA2) {
            com.kwad.sdk.core.d.c.e(TAG, "extraActiveCount == extraConfigSize");
            return executorServiceA;
        }
        com.kwad.sdk.core.d.c.e(TAG, "use extra");
        return executorServiceA2;
    }

    public static ExecutorService Jw() {
        com.kwad.sdk.core.d.c.d(TAG, "forHttpCacheServer");
        if (Jk()) {
            return Jy();
        }
        return a("videoCache", new k((byte) 0));
    }

    public static ExecutorService Jx() {
        com.kwad.sdk.core.d.c.d(TAG, "forAppStatusHelper");
        if (Jk()) {
            return Jy();
        }
        return new com.kwad.sdk.core.threads.a.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService Jy() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService JE() {
                f fVar = new f(5, "async");
                int i2 = GlobalThreadPools.Jk() ? 5 : 3;
                return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, i2), GlobalThreadPools.a("async", ParamType.MAX, i2), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            }
        });
    }

    public static ScheduledExecutorService Jz() {
        com.kwad.sdk.core.d.c.d(TAG, "forAsyncSchedule");
        ExecutorService executorServiceA = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            public final ExecutorService JE() {
                return new com.kwad.sdk.core.threads.a.a(1, new f(5, "async-schedule"));
            }
        });
        if (executorServiceA instanceof ScheduledExecutorService) {
            return (ScheduledExecutorService) executorServiceA;
        }
        return new com.kwad.sdk.core.threads.a.a(1, new f(5, "async-schedule"));
    }

    public static Set<String> JA() {
        return aJv.keySet();
    }

    public static ExecutorService eC(String str) {
        if (!aJv.containsKey(str) || aJv.get(str) == null) {
            return null;
        }
        return aJv.get(str).get();
    }

    private static ExecutorService a(String str, a aVar) {
        WeakReference<ExecutorService> weakReference = aJv.get(str);
        if (weakReference == null || weakReference.get() == null) {
            ExecutorService executorServiceJE = aVar.JE();
            aJv.put(str, new WeakReference<>(executorServiceJE));
            return executorServiceJE;
        }
        return weakReference.get();
    }

    static class j implements a {
        private j() {
        }

        /* synthetic */ j(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "backSingle"));
        }
    }

    static class h implements a {
        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "lruDiskCache"));
        }
    }

    static class i implements a {
        private i() {
        }

        /* synthetic */ i(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("report", ParamType.CORE, 1), GlobalThreadPools.a("report", ParamType.MAX, 1), GlobalThreadPools.a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(3, "report-"));
        }
    }

    static class k implements a {
        private k() {
        }

        /* synthetic */ k(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "videoCache"));
        }
    }

    static class b implements a {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.aJt), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.aJu), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "diskAndHttp"));
        }
    }

    static class c implements a {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            int i = 5;
            f fVar = new f(5, "ForCore");
            try {
                int iA = GlobalThreadPools.a("httpIOForCoreV1", ParamType.CORE, 5);
                int iA2 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.MAX, 5);
                if (iA < 0) {
                    iA = 5;
                }
                if (iA2 < 0) {
                    iA2 = 5;
                }
                if (iA2 < iA) {
                    iA2 = 5;
                } else {
                    i = iA;
                }
                com.kwad.sdk.core.d.c.d(GlobalThreadPools.TAG, "HttpIOCreatorForCore create, coreSize:" + i + ", maxSize:" + iA2);
                int i2 = 60;
                int iA3 = GlobalThreadPools.a("httpIOForCoreV1", ParamType.KEEP_ALIVE, 60);
                if (iA3 >= 0) {
                    i2 = iA3;
                }
                return new com.kwad.sdk.core.threads.a.b(i, iA2, GlobalThreadPools.a("httpIOForCoreV1", ParamType.KEEP_ALIVE, i2), TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.e(GlobalThreadPools.TAG, Log.getStackTraceString(e));
                return new com.kwad.sdk.core.threads.a.b(5, 5, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), fVar);
            }
        }
    }

    static class d implements a {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.CORE, 0), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.MAX, 3), GlobalThreadPools.a("httpIOForCoreExtraV1", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new f(5, "ForCoreExtra"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    static class g implements a {
        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new f(5, "uil-pool-"));
        }
    }

    static class e implements a {
        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        public final ExecutorService JE() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new f(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    public static class f implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public f(int i, String str) {
            this.threadPriority = i;
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
}
