package com.bytedance.sdk.component.zk;

import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.wu;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class e extends ThreadPoolExecutor {
    private String e;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.zk.e$e, reason: collision with other inner class name */
    public static class C0110e {
        private RejectedExecutionHandler v;
        private String e = "io";
        private int bf = 1;
        private long d = 30;
        private TimeUnit tg = TimeUnit.SECONDS;
        private int ga = Integer.MAX_VALUE;
        private BlockingQueue<Runnable> vn = null;
        private ThreadFactory p = null;
        private int zk = 5;

        public C0110e bf(int i) {
            this.zk = i;
            return this;
        }

        public C0110e e(String str) {
            this.e = str;
            return this;
        }

        public C0110e e(int i) {
            this.bf = i;
            return this;
        }

        public C0110e e(long j) {
            this.d = j;
            return this;
        }

        public C0110e e(TimeUnit timeUnit) {
            this.tg = timeUnit;
            return this;
        }

        public C0110e e(BlockingQueue<Runnable> blockingQueue) {
            this.vn = blockingQueue;
            return this;
        }

        public C0110e e(RejectedExecutionHandler rejectedExecutionHandler) {
            this.v = rejectedExecutionHandler;
            return this;
        }

        public e e() {
            if (this.p == null) {
                this.p = new v(this.zk, this.e);
            }
            if (this.v == null) {
                this.v = ga.vn();
            }
            if (this.vn == null) {
                this.vn = new LinkedBlockingQueue();
            }
            return new e(this.e, this.bf, this.ga, this.d, this.tg, this.vn, this.p, this.v);
        }
    }

    public e(String str, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.e = str;
    }

    private void e(Runnable runnable) {
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            e(runnable, e);
        } catch (Throwable th) {
            e(runnable, th);
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        BlockingQueue<Runnable> queue;
        super.afterExecute(runnable, th);
        if (!ga.ga() || TextUtils.isEmpty(this.e) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.e;
        str.hashCode();
        switch (str) {
            case "io":
                e(queue, 4);
                break;
            case "log":
                e(queue, 2);
                break;
            case "aidl":
                e(queue, 2);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        BlockingQueue<Runnable> queue;
        if (runnable instanceof p) {
            e(new bf((p) runnable, this));
        } else {
            e(new bf(new p("unknown") { // from class: com.bytedance.sdk.component.zk.e.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            }, this));
        }
        if (!ga.ga() || TextUtils.isEmpty(this.e) || (queue = getQueue()) == null) {
            return;
        }
        String str = this.e;
        str.hashCode();
        switch (str) {
            case "io":
                e(queue, ga.e + 2, getCorePoolSize() * 2);
                break;
            case "log":
                e(queue, 6, 6);
                break;
            case "aidl":
                e(queue, 5, 5);
                break;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if ("io".equals(this.e) || "aidl".equals(this.e)) {
            return;
        }
        super.shutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return ("io".equals(this.e) || "aidl".equals(this.e)) ? Collections.emptyList() : super.shutdownNow();
    }

    private void e(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        e(runnable, (Throwable) outOfMemoryError);
    }

    private void e(Runnable runnable, Throwable th) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        try {
            runnable.run();
        } catch (Throwable th2) {
            wu.d("", "try exc failed", th2);
        }
    }

    private void e(BlockingQueue<Runnable> blockingQueue, int i) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() > 0) {
            return;
        }
        try {
            setCorePoolSize(i);
            wu.bf("ADThreadPoolExecutor", "reduceCoreThreadSize: reduce poolType =  ", this.e, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
        } catch (Exception e) {
            wu.d("ADThreadPoolExecutor", e.getMessage());
        }
    }

    private void e(BlockingQueue<Runnable> blockingQueue, int i, int i2) {
        if (getCorePoolSize() == i || blockingQueue == null || blockingQueue.size() < i2) {
            return;
        }
        try {
            setCorePoolSize(i);
            wu.bf("ADThreadPoolExecutor", "increaseCoreThreadSize: increase poolType =  ", this.e, " coreSize=", Integer.valueOf(getCorePoolSize()), "  maxSize=", Integer.valueOf(getMaximumPoolSize()));
        } catch (Exception e) {
            wu.d("ADThreadPoolExecutor", e.getMessage());
        }
    }

    public String e() {
        return this.e;
    }
}
