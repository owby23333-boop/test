package com.xiaomi.ad.common.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes5.dex */
public class ExecutorUtils {
    public static final int CORE_POOL_SIZE;
    public static final int CPU_COUNT;
    public static final int DEFAULT_BACKGROUND_THREAD_PRIORITY = 7;
    public static final int DEFAULT_UI_THREAD_PRIORITY = 1;
    public static final int MAXIMUM_POOL_SIZE;
    public static final int MINIMUM_CPU_COUNT;
    public static final ExecutorService THREAD_POOL_EXECUTOR;
    public static final ScheduledExecutorService WORKING_EXECUTOR;
    public static final ThreadFactory sBackgroundThreadFactory;
    public static final ThreadFactory sMainWorkingThreadFactory;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = iAvailableProcessors;
        if (iAvailableProcessors < 4) {
            iAvailableProcessors = 4;
        }
        MINIMUM_CPU_COUNT = iAvailableProcessors;
        int i = iAvailableProcessors + 1;
        CORE_POOL_SIZE = i;
        int i2 = (iAvailableProcessors * 2) + 1;
        MAXIMUM_POOL_SIZE = i2;
        ThreadFactory threadFactory = new ThreadFactory() { // from class: com.xiaomi.ad.common.util.ExecutorUtils.1
            public final AtomicInteger mCount = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "BackgroundThread-" + this.mCount.getAndIncrement());
                thread.setPriority(7);
                return thread;
            }
        };
        sBackgroundThreadFactory = threadFactory;
        THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(i, i2, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), threadFactory);
        ThreadFactory threadFactory2 = new ThreadFactory() { // from class: com.xiaomi.ad.common.util.ExecutorUtils.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "WorkingThread");
                thread.setPriority(1);
                return thread;
            }
        };
        sMainWorkingThreadFactory = threadFactory2;
        WORKING_EXECUTOR = Executors.newSingleThreadScheduledExecutor(threadFactory2);
    }
}
