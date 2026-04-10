package io.reactivex.internal.schedulers;

import com.umeng.message.common.inter.ITagManager;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class SchedulerPoolFactory {
    public static final boolean PURGE_ENABLED;
    static final String PURGE_ENABLED_KEY = "rx2.purge-enabled";
    public static final int PURGE_PERIOD_SECONDS;
    static final String PURGE_PERIOD_SECONDS_KEY = "rx2.purge-period-seconds";
    static final AtomicReference<ScheduledExecutorService> PURGE_THREAD = new AtomicReference<>();
    static final Map<ScheduledThreadPoolExecutor, Object> POOLS = new ConcurrentHashMap();

    static final class ScheduledTask implements Runnable {
        ScheduledTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(SchedulerPoolFactory.POOLS.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    SchedulerPoolFactory.POOLS.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static final class SystemPropertyAccessor implements Function<String, String> {
        SystemPropertyAccessor() {
        }

        @Override // io.reactivex.functions.Function
        public String apply(String str) throws Exception {
            return System.getProperty(str);
        }
    }

    static {
        SystemPropertyAccessor systemPropertyAccessor = new SystemPropertyAccessor();
        PURGE_ENABLED = getBooleanProperty(true, PURGE_ENABLED_KEY, true, true, systemPropertyAccessor);
        PURGE_PERIOD_SECONDS = getIntProperty(PURGE_ENABLED, PURGE_PERIOD_SECONDS_KEY, 1, 1, systemPropertyAccessor);
        start();
    }

    private SchedulerPoolFactory() {
        throw new IllegalStateException("No instances!");
    }

    public static ScheduledExecutorService create(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        tryPutIntoPool(PURGE_ENABLED, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    static boolean getBooleanProperty(boolean z2, String str, boolean z3, boolean z4, Function<String, String> function) {
        if (!z2) {
            return z4;
        }
        try {
            String strApply = function.apply(str);
            return strApply == null ? z3 : ITagManager.STATUS_TRUE.equals(strApply);
        } catch (Throwable unused) {
            return z3;
        }
    }

    static int getIntProperty(boolean z2, String str, int i2, int i3, Function<String, String> function) {
        if (!z2) {
            return i3;
        }
        try {
            String strApply = function.apply(str);
            return strApply == null ? i2 : Integer.parseInt(strApply);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public static void shutdown() {
        ScheduledExecutorService andSet = PURGE_THREAD.getAndSet(null);
        if (andSet != null) {
            andSet.shutdownNow();
        }
        POOLS.clear();
    }

    public static void start() {
        tryStart(PURGE_ENABLED);
    }

    static void tryPutIntoPool(boolean z2, ScheduledExecutorService scheduledExecutorService) {
        if (z2 && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            POOLS.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }

    static void tryStart(boolean z2) {
        if (!z2) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = PURGE_THREAD.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (PURGE_THREAD.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                ScheduledTask scheduledTask = new ScheduledTask();
                int i2 = PURGE_PERIOD_SECONDS;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(scheduledTask, i2, i2, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }
}
