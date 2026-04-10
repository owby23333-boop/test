package com.bytedance.sdk.component.zk;

import com.bytedance.sdk.component.zk.e;
import com.iflytek.aikit.media.param.MscKeys;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ga {
    public static d bf;
    private static volatile ThreadPoolExecutor ga;
    private static volatile ThreadPoolExecutor p;
    private static volatile ThreadPoolExecutor v;
    private static volatile ThreadPoolExecutor vn;
    private static volatile ScheduledExecutorService zk;
    public static final int e = Runtime.getRuntime().availableProcessors();
    public static int d = 120;
    public static boolean tg = true;

    public static void bf(p pVar) {
        if (ga == null) {
            e();
        }
        if (ga != null) {
            ga.execute(pVar);
        }
    }

    public static void d(p pVar) {
        if (p == null) {
            bf();
        }
        if (p != null) {
            p.execute(pVar);
        }
    }

    public static void e(p pVar) {
        e(pVar, 10);
    }

    public static boolean ga() {
        return tg;
    }

    public static d p() {
        return bf;
    }

    public static void tg(p pVar) {
        if (v == null) {
            d();
        }
        if (v != null) {
            v.execute(pVar);
        }
    }

    public static RejectedExecutionHandler vn() {
        return new RejectedExecutionHandler() { // from class: com.bytedance.sdk.component.zk.ga.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }

    public static ExecutorService e() {
        return e(10);
    }

    public static void ga(p pVar) {
        if (vn == null) {
            bf(10);
        }
        if (pVar == null || vn == null) {
            return;
        }
        vn.execute(pVar);
    }

    public static ExecutorService e(int i) {
        if (ga == null) {
            synchronized (ga.class) {
                if (ga == null) {
                    ga = new e.C0110e().e("io").e(4).bf(i).e(20L).e(TimeUnit.SECONDS).e(new PriorityBlockingQueue(e)).e(vn()).e();
                    ga.allowCoreThreadTimeOut(true);
                }
            }
        }
        return ga;
    }

    public static ExecutorService bf() {
        if (p == null) {
            synchronized (ga.class) {
                if (p == null) {
                    p = new e.C0110e().e(MscKeys.KEY_LOG_PATH).bf(10).e(2).e(20L).e(TimeUnit.SECONDS).e(new PriorityBlockingQueue()).e(vn()).e();
                    p.allowCoreThreadTimeOut(true);
                }
            }
        }
        return p;
    }

    public static ExecutorService d() {
        if (v == null) {
            synchronized (ga.class) {
                if (v == null) {
                    v = new e.C0110e().e("aidl").bf(10).e(2).e(30L).e(TimeUnit.SECONDS).e(new PriorityBlockingQueue()).e(vn()).e();
                    v.allowCoreThreadTimeOut(true);
                }
            }
        }
        return v;
    }

    public static ScheduledExecutorService tg() {
        if (zk == null) {
            synchronized (ga.class) {
                if (zk == null) {
                    zk = Executors.newSingleThreadScheduledExecutor(new v(5, "scheduled"));
                }
            }
        }
        return zk;
    }

    public static void e(p pVar, int i) {
        if (ga == null) {
            e();
        }
        if (pVar == null || ga == null) {
            return;
        }
        pVar.e(i);
        ga.execute(pVar);
    }

    public static void bf(p pVar, int i) {
        if (v == null) {
            d();
        }
        if (pVar == null || v == null) {
            return;
        }
        pVar.e(i);
        v.execute(pVar);
    }

    public static void d(int i) {
        d = i;
    }

    public static void e(boolean z) {
        tg = z;
    }

    public static void e(d dVar) {
        bf = dVar;
    }

    public static ExecutorService bf(int i) {
        if (vn == null) {
            synchronized (ga.class) {
                if (vn == null) {
                    vn = new e.C0110e().e("ad").e(5).bf(i).e(40L).e(TimeUnit.SECONDS).e(new PriorityBlockingQueue(e)).e(vn()).e();
                    vn.allowCoreThreadTimeOut(true);
                }
            }
        }
        return vn;
    }
}
