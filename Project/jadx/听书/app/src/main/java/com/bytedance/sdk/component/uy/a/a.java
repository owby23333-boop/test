package com.bytedance.sdk.component.uy.a;

import com.bytedance.sdk.component.uy.kb;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a extends z {
    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void allowCoreThreadTimeOut(boolean z) {
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.uy.z.z(blockingQueue), new com.bytedance.sdk.component.uy.z.a(threadFactory, 2));
        z();
    }

    public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.bytedance.sdk.component.uy.z.z(blockingQueue), new com.bytedance.sdk.component.uy.z.a(threadFactory, 2), rejectedExecutionHandler);
        z();
    }

    private void z() {
        if (kb.g.gc()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(z(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.bytedance.sdk.component.uy.a.z.z(this);
        }
    }

    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.ThreadPoolExecutor, com.bytedance.sdk.component.uy.g
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.bytedance.sdk.component.uy.z.a(threadFactory, 2));
    }

    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public void shutdown() {
        super.shutdown();
        com.bytedance.sdk.component.uy.a.z.g(this);
    }

    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public List shutdownNow() {
        com.bytedance.sdk.component.uy.a.z.g(this);
        return super.shutdownNow();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void finalize() {
        super.finalize();
        shutdown();
        com.bytedance.sdk.component.uy.a.z.g(this);
    }

    private ExecutorService g() {
        return com.bytedance.sdk.component.uy.a.z.z("PThreadPoolExecutor", com.bytedance.sdk.component.uy.a.z.z(getQueue()));
    }

    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public <T> Future<T> submit(Callable<T> callable) {
        if (kb.g.gc()) {
            try {
                return super.submit(callable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceG = g();
                if (executorServiceG != null) {
                    return executorServiceG.submit(callable);
                }
                throw e;
            }
        }
        return super.submit(callable);
    }

    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (kb.g.gc()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceG = g();
                if (executorServiceG != null) {
                    return executorServiceG.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.bytedance.sdk.component.uy.g
    public Future submit(Runnable runnable) {
        if (kb.g.gc()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceG = g();
                if (executorServiceG != null) {
                    return executorServiceG.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }

    @Override // com.bytedance.sdk.component.uy.a.z, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.bytedance.sdk.component.uy.g
    public void execute(Runnable runnable) {
        if (kb.g.gc()) {
            try {
                super.execute(runnable);
                return;
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceG = g();
                if (executorServiceG != null) {
                    executorServiceG.execute(runnable);
                    return;
                }
                throw e;
            }
        }
        super.execute(runnable);
    }

    private long z(long j) {
        long jMin = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (jMin > 1) {
            return jMin;
        }
        return 1L;
    }
}
