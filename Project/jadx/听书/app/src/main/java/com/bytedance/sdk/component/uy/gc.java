package com.bytedance.sdk.component.uy;

import java.lang.reflect.Field;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class gc {
    private static void z(Throwable th) {
        String.valueOf(th.getMessage());
    }

    public static int z() {
        ThreadGroup threadGroupG = g();
        if (threadGroupG == null) {
            return 0;
        }
        int iActiveCount = threadGroupG.activeCount();
        try {
            return threadGroupG.enumerate(new Thread[(iActiveCount / 2) + iActiveCount]);
        } catch (Throwable unused) {
            return iActiveCount;
        }
    }

    public static ThreadGroup g() {
        try {
            Field declaredField = ThreadGroup.class.getDeclaredField("systemThreadGroup");
            declaredField.setAccessible(true);
            return (ThreadGroup) declaredField.get(ThreadGroup.class);
        } catch (Exception e) {
            z(e);
            return null;
        }
    }

    public static void z(ExecutorService executorService, final ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor != null) {
            try {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
                threadPoolExecutor.setKeepAliveTime(2L, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                z(e);
            }
            executorService.execute(new Runnable() { // from class: com.bytedance.sdk.component.uy.gc.1
                @Override // java.lang.Runnable
                public void run() {
                    gc.g(threadPoolExecutor);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.setKeepAliveTime(1L, TimeUnit.MILLISECONDS);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            z(e);
        }
        BlockingQueue<Runnable> queue = threadPoolExecutor.getQueue();
        while (true) {
            if (queue != null) {
                try {
                    if (queue.size() > 0) {
                        while (true) {
                            Runnable runnablePoll = queue.poll(0L, TimeUnit.MILLISECONDS);
                            if (runnablePoll == null) {
                                break;
                            } else {
                                runnablePoll.run();
                            }
                        }
                    }
                } catch (Exception unused) {
                    continue;
                }
            }
            if (threadPoolExecutor.getActiveCount() != 0) {
                Thread.sleep(1000L);
            } else {
                threadPoolExecutor.shutdown();
                return;
            }
        }
    }
}
