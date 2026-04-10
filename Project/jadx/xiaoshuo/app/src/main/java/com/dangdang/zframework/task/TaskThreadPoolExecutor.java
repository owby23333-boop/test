package com.dangdang.zframework.task;

import com.dangdang.zframework.utils.deque.LinkedBlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class TaskThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int defaultCorePoolSize = 1;
    private static final long defaultKeepAliveTime = 60;
    private static final int defaultMaximumPoolSize = 1;
    private static final TimeUnit defaultUnit = TimeUnit.SECONDS;

    public TaskThreadPoolExecutor() {
        this(1, 1, new LinkedBlockingDeque());
    }

    public static TaskThreadPoolExecutor getDefault() {
        return new TaskThreadPoolExecutor();
    }

    public TaskThreadPoolExecutor(int i, int i2, BlockingQueue<Runnable> blockingQueue) {
        this(i, i2, defaultKeepAliveTime, defaultUnit, blockingQueue);
    }

    public TaskThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue) {
        super(i, i2, j, timeUnit, blockingQueue);
    }

    public TaskThreadPoolExecutor(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue);
    }
}
