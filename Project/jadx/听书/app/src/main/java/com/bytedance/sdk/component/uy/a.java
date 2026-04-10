package com.bytedance.sdk.component.uy;

import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final a z = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z f798a;
    private g dl;
    private final List<WeakReference<ThreadPoolExecutor>> g = new ArrayList();

    public interface g {
    }

    public interface z {
    }

    private ScheduledExecutorService g() {
        return kb.g.wp();
    }

    public synchronized void z(com.bytedance.sdk.component.uy.a.a aVar) {
        g(aVar);
        this.g.add(new WeakReference<>(aVar));
    }

    public synchronized void g(com.bytedance.sdk.component.uy.a.a aVar) {
        Iterator<WeakReference<ThreadPoolExecutor>> it = this.g.iterator();
        while (it.hasNext()) {
            if (it.next().get() == aVar) {
                it.remove();
            }
        }
    }

    public String z(BlockingQueue blockingQueue) {
        if (blockingQueue instanceof com.bytedance.sdk.component.uy.z.z) {
            return ((com.bytedance.sdk.component.uy.z.z) blockingQueue).z();
        }
        return blockingQueue.getClass().getName();
    }

    public ThreadPoolExecutor z(String str, String str2) {
        List<ThreadPoolExecutor> listZ = z(str2, false, true);
        z(listZ, str);
        ThreadPoolExecutor threadPoolExecutor = listZ.size() > 0 ? listZ.get(0) : null;
        z();
        return threadPoolExecutor;
    }

    private synchronized List<ThreadPoolExecutor> z(String str, boolean z2, boolean z3) {
        ArrayList arrayList;
        ThreadPoolExecutor threadPoolExecutor;
        boolean z4;
        arrayList = new ArrayList();
        for (WeakReference<ThreadPoolExecutor> weakReference : this.g) {
            if (weakReference != null && (threadPoolExecutor = weakReference.get()) != null) {
                BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
                if (queue instanceof com.bytedance.sdk.component.uy.z.z) {
                    z4 = ((com.bytedance.sdk.component.uy.z.z) queue).g() instanceof PriorityBlockingQueue;
                } else {
                    z4 = queue instanceof PriorityBlockingQueue;
                }
                if (!threadPoolExecutor.isShutdown() && !threadPoolExecutor.isTerminated() && !threadPoolExecutor.isTerminating() && threadPoolExecutor.getQueue().isEmpty() && (str == null || !z4)) {
                    if (threadPoolExecutor.getActiveCount() < threadPoolExecutor.getPoolSize()) {
                        arrayList.add(threadPoolExecutor);
                        if (z2) {
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (z3 && !z2) {
            try {
                Collections.sort(arrayList, new Comparator<ThreadPoolExecutor>() { // from class: com.bytedance.sdk.component.uy.a.1
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
                    public int compare(ThreadPoolExecutor threadPoolExecutor2, ThreadPoolExecutor threadPoolExecutor3) {
                        int poolSize = threadPoolExecutor2.getPoolSize() - threadPoolExecutor2.getActiveCount();
                        int poolSize2 = threadPoolExecutor3.getPoolSize() - threadPoolExecutor3.getActiveCount();
                        if (poolSize2 > poolSize) {
                            return 1;
                        }
                        return poolSize > poolSize2 ? -1 : 0;
                    }
                });
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
            arrayList.size();
            this.g.size();
        } else {
            arrayList.size();
            this.g.size();
        }
        return arrayList;
    }

    public void z() {
        if (kb.g.z()) {
            g().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dl();
                }
            }, 100L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dl() {
        List<ThreadPoolExecutor> listZ = z(null, false, false);
        if (listZ == null || listZ.size() == 0) {
            return;
        }
        if (this.dl != null) {
            gc.z();
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : listZ) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof uy) {
                    map.put(((uy) threadFactory).z + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.uy.z.a) {
                    map.put(((com.bytedance.sdk.component.uy.z.a) threadFactory).z() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
                z(threadPoolExecutor);
            }
        }
        if (this.dl != null) {
            gc.z();
        }
    }

    private void z(final ThreadPoolExecutor threadPoolExecutor) {
        final long keepAliveTime = threadPoolExecutor.getKeepAliveTime(TimeUnit.NANOSECONDS);
        final boolean zAllowsCoreThreadTimeOut = threadPoolExecutor.allowsCoreThreadTimeOut();
        threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.NANOSECONDS);
        if (zAllowsCoreThreadTimeOut) {
            threadPoolExecutor.allowCoreThreadTimeOut(false);
        }
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        g().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.3
            @Override // java.lang.Runnable
            public void run() {
                ThreadPoolExecutor threadPoolExecutor2 = threadPoolExecutor;
                long j = keepAliveTime;
                if (j == 0) {
                    j = 60;
                }
                threadPoolExecutor2.setKeepAliveTime(j, TimeUnit.NANOSECONDS);
                threadPoolExecutor.allowCoreThreadTimeOut(zAllowsCoreThreadTimeOut);
            }
        }, 10L, TimeUnit.MILLISECONDS);
    }

    private void z(List<ThreadPoolExecutor> list, String str) {
        if (list == null || list.size() == 0 || this.f798a == null) {
            return;
        }
        HashMap map = new HashMap();
        for (ThreadPoolExecutor threadPoolExecutor : list) {
            if (threadPoolExecutor != null) {
                ThreadFactory threadFactory = threadPoolExecutor.getThreadFactory();
                if (threadFactory instanceof uy) {
                    map.put(((uy) threadFactory).z + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else if (threadFactory instanceof com.bytedance.sdk.component.uy.z.a) {
                    map.put(((com.bytedance.sdk.component.uy.z.a) threadFactory).z() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                } else {
                    map.put(threadFactory.getClass().getName() + "_" + threadPoolExecutor.hashCode(), Integer.valueOf(threadPoolExecutor.getPoolSize()));
                }
            }
        }
        HashMap map2 = new HashMap();
        ThreadGroup threadGroupG = gc.g();
        int iActiveCount = threadGroupG.activeCount();
        Thread[] threadArr = new Thread[iActiveCount + (iActiveCount / 2)];
        int iEnumerate = threadGroupG.enumerate(threadArr);
        for (int i = 0; i < iEnumerate; i++) {
            Thread thread = threadArr[i];
            Thread.State state = thread.getState();
            if (state == Thread.State.BLOCKED || state == Thread.State.WAITING || state == Thread.State.TIMED_WAITING) {
                String strReplaceAll = thread.getName().replaceAll("[0-9]", "");
                Integer num = (Integer) map2.get(strReplaceAll);
                map2.put(strReplaceAll, Integer.valueOf(num != null ? 1 + num.intValue() : 1));
            }
        }
    }

    public void z(String str) {
        List<ThreadPoolExecutor> listZ = z(null, false, true);
        if (listZ == null || listZ.size() == 0) {
            return;
        }
        z(listZ, str);
        listZ.size();
        ThreadPoolExecutor threadPoolExecutor = listZ.get(0);
        if (threadPoolExecutor != null) {
            z(threadPoolExecutor);
        }
        z();
    }

    private a() {
        g().schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.a.4
            @Override // java.lang.Runnable
            public void run() {
            }
        }, 1L, TimeUnit.MINUTES);
    }
}
