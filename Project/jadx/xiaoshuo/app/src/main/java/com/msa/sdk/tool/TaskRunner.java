package com.msa.sdk.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class TaskRunner {
    public static final ExecutorService CACHED_EXECUTOR;
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final int MAXIMUM_POOL_SIZE;
    private static final int MINIMUM_CPU_COUNT;

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
        CACHED_EXECUTOR = new ThreadPoolExecutor(i, i2, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
    }
}
