package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends ThreadPoolExecutor implements c {
    public static volatile boolean aJR;
    private final ConcurrentHashMap<Runnable, Long> aJS;
    private long aJT;
    private int aJU;

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
        this.aJS = new ConcurrentHashMap<>();
        this.aJT = 0L;
        this.aJU = 0;
    }

    public b(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.aJS = new ConcurrentHashMap<>();
        this.aJT = 0L;
        this.aJU = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long JK() {
        return this.aJT;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aJR) {
            this.aJS.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aJR && this.aJS.containsKey(runnable) && this.aJS.get(runnable) != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.aJS.get(runnable).longValue();
            if (jElapsedRealtime >= 0 && jElapsedRealtime < 1800000) {
                long j = this.aJT;
                int i = this.aJU;
                this.aJT = ((j * ((long) i)) + jElapsedRealtime) / ((long) (i + 1));
                this.aJU = i + 1;
            }
            this.aJS.remove(runnable);
        }
    }
}
