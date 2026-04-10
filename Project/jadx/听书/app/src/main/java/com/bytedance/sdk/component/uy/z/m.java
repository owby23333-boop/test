package com.bytedance.sdk.component.uy.z;

import com.bytedance.sdk.component.uy.kb;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class m implements com.bytedance.sdk.component.uy.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Condition f809a;
    private final ReentrantLock dl;
    private volatile RejectedExecutionHandler e;
    private volatile int fo;
    private final BlockingQueue<Runnable> g;
    private int gc;
    private volatile long gz;
    private ThreadPoolExecutor i;
    private boolean kb;
    private volatile ThreadFactory m;
    private final ThreadPoolExecutor uy;
    private volatile int wp;
    private final AtomicInteger z = new AtomicInteger(z(-536870912, 0));

    private static boolean dl(int i) {
        return i < 0;
    }

    private static boolean dl(int i, int i2) {
        return i >= i2;
    }

    private static int g(int i) {
        return i & 536870911;
    }

    private static boolean g(int i, int i2) {
        return i < i2;
    }

    private static int z(int i) {
        return i & (-536870912);
    }

    private static int z(int i, int i2) {
        return i | i2;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public void setCorePoolSize(int i) {
    }

    private boolean a(int i) {
        return this.z.compareAndSet(i, i + 1);
    }

    private boolean gc(int i) {
        return this.z.compareAndSet(i, i - 1);
    }

    private void dl() {
        while (!gc(this.z.get())) {
        }
    }

    private void m(int i) {
        int i2;
        do {
            i2 = this.z.get();
            if (dl(i2, i)) {
                return;
            }
        } while (!this.z.compareAndSet(i2, z(i, g(i2))));
    }

    public ThreadPoolExecutor z() {
        if (this.i == null) {
            this.i = kb.g.uy();
        }
        return this.i;
    }

    final void g() {
        while (true) {
            int i = this.z.get();
            if (dl(i) || dl(i, 1073741824)) {
                return;
            }
            if ((z(i) == 0 && !this.g.isEmpty()) || g(i) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.dl;
            reentrantLock.lock();
            try {
                if (this.z.compareAndSet(i, z(1073741824, 0))) {
                    this.z.set(z(1610612736, 0));
                    this.f809a.signalAll();
                    return;
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    final void z(Runnable runnable) {
        this.e.rejectedExecution(runnable, this.uy);
    }

    private List<Runnable> a() {
        BlockingQueue<Runnable> blockingQueue = this.g;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof dl) {
                        arrayList.add(((dl) runnable).dl);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0080, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean g(java.lang.Runnable r6, boolean r7) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicInteger r0 = r5.z
            int r0 = r0.get()
            int r1 = z(r0)
            r2 = 0
            if (r1 < 0) goto L1a
            if (r1 != 0) goto L19
            if (r6 != 0) goto L19
            java.util.concurrent.BlockingQueue<java.lang.Runnable> r3 = r5.g
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L1a
        L19:
            return r2
        L1a:
            int r3 = g(r0)
            r4 = 536870911(0x1fffffff, float:1.0842021E-19)
            if (r3 >= r4) goto L80
            if (r7 == 0) goto L28
            int r4 = r5.fo
            goto L2a
        L28:
            int r4 = r5.wp
        L2a:
            if (r3 < r4) goto L2d
            goto L80
        L2d:
            boolean r0 = r5.a(r0)
            if (r0 != 0) goto L40
            java.util.concurrent.atomic.AtomicInteger r0 = r5.z
            int r0 = r0.get()
            int r3 = z(r0)
            if (r3 != r1) goto L0
            goto L1a
        L40:
            java.util.concurrent.locks.ReentrantLock r7 = r5.dl     // Catch: java.lang.Throwable -> L7b
            r7.lock()     // Catch: java.lang.Throwable -> L7b
            java.util.concurrent.atomic.AtomicInteger r0 = r5.z     // Catch: java.lang.Throwable -> L76
            int r0 = r0.get()     // Catch: java.lang.Throwable -> L76
            int r0 = z(r0)     // Catch: java.lang.Throwable -> L76
            if (r0 < 0) goto L55
            if (r0 != 0) goto L6d
            if (r6 != 0) goto L6d
        L55:
            java.util.concurrent.ThreadPoolExecutor r0 = r5.z()     // Catch: java.lang.Throwable -> L76
            r0.execute(r6)     // Catch: java.lang.Throwable -> L76
            java.util.concurrent.atomic.AtomicInteger r6 = r5.z     // Catch: java.lang.Throwable -> L76
            int r6 = r6.get()     // Catch: java.lang.Throwable -> L76
            int r6 = g(r6)     // Catch: java.lang.Throwable -> L76
            int r0 = r5.gc     // Catch: java.lang.Throwable -> L76
            if (r6 <= r0) goto L6c
            r5.gc = r6     // Catch: java.lang.Throwable -> L76
        L6c:
            r2 = 1
        L6d:
            r7.unlock()     // Catch: java.lang.Throwable -> L7b
            if (r2 != 0) goto L75
            r5.gc()
        L75:
            return r2
        L76:
            r6 = move-exception
            r7.unlock()     // Catch: java.lang.Throwable -> L7b
            throw r6     // Catch: java.lang.Throwable -> L7b
        L7b:
            r6 = move-exception
            r5.gc()
            throw r6
        L80:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.uy.z.m.g(java.lang.Runnable, boolean):boolean");
    }

    private void gc() {
        ReentrantLock reentrantLock = this.dl;
        reentrantLock.lock();
        try {
            dl();
            g();
        } finally {
            reentrantLock.unlock();
        }
    }

    public m(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.dl = reentrantLock;
        this.f809a = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        }
        this.fo = i;
        this.wp = i2;
        this.g = blockingQueue;
        this.gz = timeUnit.toNanos(j);
        this.m = threadFactory;
        this.e = rejectedExecutionHandler;
        this.uy = threadPoolExecutor;
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        dl dlVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof dl) {
            dlVar = (dl) runnable;
            dlVar.z(this);
        } else {
            dlVar = new dl(runnable, this);
        }
        z(dlVar);
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    private void z(dl dlVar) {
        int i = this.z.get();
        if (g(i) < this.fo) {
            if (g((Runnable) dlVar, true)) {
                kb.g.e();
                return;
            }
            i = this.z.get();
        }
        if (g(i) == 0) {
            if (g((Runnable) dlVar, false)) {
                kb.g.e();
                return;
            }
            i = this.z.get();
        }
        if (dl(i) && this.g.offer(dlVar)) {
            if (!dl(this.z.get()) && remove(dlVar)) {
                z(dlVar.z());
                kb.g.e();
                return;
            } else {
                kb.g.e();
                return;
            }
        }
        if (g(i) < this.wp && g((Runnable) dlVar, false)) {
            kb.g.e();
        } else {
            z(dlVar.z());
            kb.g.e();
        }
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.dl;
        reentrantLock.lock();
        try {
            m(0);
            reentrantLock.unlock();
            g();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.dl;
        reentrantLock.lock();
        try {
            m(536870912);
            List<Runnable> listA = a();
            reentrantLock.unlock();
            g();
            return listA;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !dl(this.z.get());
    }

    @Override // com.bytedance.sdk.component.uy.g
    public boolean isTerminating() {
        int i = this.z.get();
        return !dl(i) && g(i, 1610612736);
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return dl(this.z.get(), 1610612736);
    }

    @Override // com.bytedance.sdk.component.uy.g, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.dl;
        reentrantLock.lock();
        while (!dl(this.z.get(), 1610612736)) {
            try {
                if (nanos > 0) {
                    nanos = this.f809a.awaitNanos(nanos);
                } else {
                    reentrantLock.unlock();
                    return false;
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    protected void finalize() {
        shutdown();
    }

    @Override // com.bytedance.sdk.component.uy.g
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.m = threadFactory;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public ThreadFactory getThreadFactory() {
        return this.m;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.e = rejectedExecutionHandler;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.e;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public int getCorePoolSize() {
        return this.fo;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public boolean allowsCoreThreadTimeOut() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public void allowCoreThreadTimeOut(boolean z) {
        this.kb = true;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.fo) {
            throw new IllegalArgumentException();
        }
        this.wp = i;
        this.z.get();
    }

    @Override // com.bytedance.sdk.component.uy.g
    public int getMaximumPoolSize() {
        return this.wp;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.gz = timeUnit.toNanos(j);
    }

    @Override // com.bytedance.sdk.component.uy.g
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.gz, TimeUnit.NANOSECONDS);
    }

    @Override // com.bytedance.sdk.component.uy.g
    public BlockingQueue<Runnable> getQueue() {
        return this.g;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public boolean remove(Runnable runnable) {
        boolean zRemove = this.g.remove(runnable);
        g();
        return zRemove;
    }

    @Override // com.bytedance.sdk.component.uy.g
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.g;
        try {
            Iterator it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable runnable = (Runnable) it.next();
                if ((runnable instanceof Future) && ((Future) runnable).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        g();
    }

    @Override // com.bytedance.sdk.component.uy.g
    public int getPoolSize() {
        if (dl(this.z.get(), 1073741824)) {
            return 0;
        }
        return g(this.z.get());
    }

    @Override // com.bytedance.sdk.component.uy.g
    public int getActiveCount() {
        return g(this.z.get());
    }

    @Override // com.bytedance.sdk.component.uy.g
    public String toString() {
        String str;
        int i = this.z.get();
        if (g(i, 0)) {
            str = "Running";
        } else {
            str = dl(i, 1610612736) ? "Terminated" : "Shutting down";
        }
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + str + ", runnable name = , core size = " + this.fo + ", max size = " + this.wp + ", worker count = " + g(i) + ", queued tasks = " + this.g.size() + "]";
    }

    public void z(Runnable runnable, boolean z) {
        int i = this.z.get();
        int iG = g(runnable);
        if (g(i, 536870912)) {
            do {
                Runnable runnablePoll = this.g.poll();
                if (runnablePoll != null) {
                    if (e(iG) && (runnablePoll instanceof dl)) {
                        dl dlVar = (dl) runnablePoll;
                        dlVar.g();
                        dlVar.z(iG);
                        dlVar.z((m) null);
                        runnablePoll.run();
                    } else {
                        z().execute(runnablePoll);
                        return;
                    }
                } else {
                    dl();
                    return;
                }
            } while (g(i, 536870912));
            g();
            return;
        }
        g();
    }

    private boolean e(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.bytedance.sdk.component.uy.dl.a.a();
        }
        return false;
    }

    private int g(Runnable runnable) {
        if (runnable instanceof dl) {
            return ((dl) runnable).a();
        }
        return 0;
    }
}
