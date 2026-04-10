package com.baidu.tts.concurrency;

import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.factory.base.NameThreadFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class LimitQueueThreadPoolExecutor extends ThreadPoolExecutor {
    private static final String TAG = "LimitQueueThreadPoolExecutor";

    public static class BlockRejectedExecutionHandler implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            LoggerProxy.d(LimitQueueThreadPoolExecutor.TAG, "rejectedExecution");
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            try {
                threadPoolExecutor.getQueue().put(runnable);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public LimitQueueThreadPoolExecutor(int i2, String str) {
        this(i2, str, new BlockRejectedExecutionHandler());
    }

    public LimitQueueThreadPoolExecutor(int i2, String str, RejectedExecutionHandler rejectedExecutionHandler) {
        this(i2, new NameThreadFactory(str), rejectedExecutionHandler);
    }

    public LimitQueueThreadPoolExecutor(int i2, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        this(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i2), threadFactory, rejectedExecutionHandler);
    }

    public LimitQueueThreadPoolExecutor(int i2, int i3, int i4, String str) {
        this(i2, i3, i4, str, new ThreadPoolExecutor.AbortPolicy());
    }

    public LimitQueueThreadPoolExecutor(int i2, int i3, int i4, String str, RejectedExecutionHandler rejectedExecutionHandler) {
        this(i2, i3, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(i4), new NameThreadFactory(str), rejectedExecutionHandler);
    }

    public LimitQueueThreadPoolExecutor(int i2, int i3, long j2, TimeUnit timeUnit, String str) {
        this(i2, i3, j2, timeUnit, new SynchronousQueue(), new NameThreadFactory(str), new ThreadPoolExecutor.AbortPolicy());
    }

    public LimitQueueThreadPoolExecutor(int i2, int i3, long j2, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i2, i3, j2, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }
}
