package com.bytedance.sdk.component.uy;

import androidx.media3.common.C;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class kb {
    private volatile boolean fo;
    private volatile ThreadPoolExecutor fv;
    private volatile boolean hh;
    private com.bytedance.sdk.component.uy.z.g io;
    private int iq;
    private volatile ThreadPoolExecutor js;
    private com.bytedance.sdk.component.uy.z.gc p;
    private volatile boolean sy;
    private volatile ScheduledExecutorService tb;
    private boolean uf;
    public static final int z = e.z;
    public static final kb g = new kb();
    public volatile boolean dl = true;
    private long m = 5000;
    private long e = 20000;
    private volatile boolean gz = true;
    private boolean uy = true;
    private long kb = 100;
    private long wp = 50;
    private long i = 1000;
    private long v = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private boolean pf = false;
    private volatile boolean ls = true;
    private boolean q = true;
    private boolean zw = true;
    private volatile boolean l = true;
    private volatile boolean h = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f806a = Math.min(z, 4);
    private int gc = 50;

    private kb() {
    }

    public void z(int i) {
        this.iq = i;
    }

    public boolean g(int i) {
        return (this.iq & i) == i;
    }

    public boolean z() {
        return this.uy;
    }

    public void z(boolean z2) {
        this.uy = z2;
    }

    public boolean g() {
        return this.q;
    }

    public void g(boolean z2) {
        this.q = z2;
    }

    public com.bytedance.sdk.component.uy.z.g dl() {
        return this.io;
    }

    public void z(com.bytedance.sdk.component.uy.z.g gVar) {
        this.io = gVar;
    }

    public long a() {
        return this.kb;
    }

    public boolean gc() {
        return this.dl;
    }

    public void dl(boolean z2) {
        this.dl = z2;
    }

    public boolean m() {
        return this.uf;
    }

    public void a(boolean z2) {
        this.uf = z2;
    }

    public com.bytedance.sdk.component.uy.z.gc e() {
        if (this.p == null) {
            this.p = new com.bytedance.sdk.component.uy.z.gc();
        }
        return this.p;
    }

    public int gz() {
        return this.f806a;
    }

    public void dl(int i) {
        this.f806a = i;
        fo().setCorePoolSize(i);
        uy().setCorePoolSize(i);
    }

    public ThreadPoolExecutor fo() {
        if (this.fv == null) {
            synchronized (this) {
                if (this.fv == null) {
                    this.fv = new com.bytedance.sdk.component.uy.dl.a(this.f806a, this.gc, this.e, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new uy(10, "a") { // from class: com.bytedance.sdk.component.uy.kb.1
                        @Override // com.bytedance.sdk.component.uy.uy
                        protected Thread z(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.fv;
    }

    public ThreadPoolExecutor uy() {
        if (this.js == null) {
            synchronized (this) {
                if (this.js == null) {
                    this.js = new com.bytedance.sdk.component.uy.dl.g(this.f806a, this.gc, this.m, TimeUnit.MILLISECONDS, new uy(10, t.l) { // from class: com.bytedance.sdk.component.uy.kb.2
                        @Override // com.bytedance.sdk.component.uy.uy
                        protected Thread z(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.h) {
                        try {
                            this.js.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.js;
    }

    public void z(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.js;
        this.js = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        gc.z(threadPoolExecutor, threadPoolExecutor2);
    }

    public void g(ThreadPoolExecutor threadPoolExecutor) {
        if (threadPoolExecutor == null) {
            return;
        }
        ThreadPoolExecutor threadPoolExecutor2 = this.fv;
        this.fv = threadPoolExecutor;
        if (threadPoolExecutor2 == null || threadPoolExecutor2 == threadPoolExecutor) {
            return;
        }
        ((com.bytedance.sdk.component.uy.dl.a) threadPoolExecutor2).dl();
        gc.z(threadPoolExecutor, threadPoolExecutor2);
    }

    public void a(int i) {
        this.gc = i;
        fo().setMaximumPoolSize(i);
        uy().setMaximumPoolSize(i);
    }

    public int kb() {
        return this.gc;
    }

    public void gc(boolean z2) {
        this.fo = z2;
    }

    public ScheduledExecutorService wp() {
        if (this.tb == null) {
            synchronized (this) {
                if (this.tb == null) {
                    this.tb = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.bytedance.sdk.component.uy.kb.3
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, kb.this.uf ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.bytedance.sdk.component.uy.a.z.z);
                }
            }
        }
        return this.tb;
    }

    public void z(ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService == null) {
            return;
        }
        final ScheduledExecutorService scheduledExecutorService2 = this.tb;
        this.tb = scheduledExecutorService;
        if (scheduledExecutorService2 == null || scheduledExecutorService2 == scheduledExecutorService) {
            return;
        }
        this.tb.schedule(new Runnable() { // from class: com.bytedance.sdk.component.uy.kb.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    scheduledExecutorService2.shutdown();
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.dl("ThreadCenter", e);
                }
            }
        }, 5000L, TimeUnit.MILLISECONDS);
    }

    public ThreadPoolExecutor i() {
        if (this.fo) {
            return uy();
        }
        return fo();
    }

    public void z(long j) {
        this.m = j;
        uy().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }

    public void m(boolean z2) {
        this.gz = z2;
    }

    public boolean v() {
        return this.sy;
    }

    public void e(boolean z2) {
        if (z2) {
            gz(false);
            e.z(false);
        }
        this.sy = z2;
    }

    public boolean pf() {
        return this.hh;
    }

    public boolean ls() {
        return this.l && e.gc();
    }

    public void gz(boolean z2) {
        if (this.sy) {
            return;
        }
        if (this.js != null) {
            this.js.allowCoreThreadTimeOut(z2);
        }
        this.h = z2;
    }

    public long p() {
        return this.wp;
    }

    public void g(long j) {
        this.wp = j;
    }

    public long fv() {
        return this.i;
    }

    public void dl(long j) {
        this.i = j;
    }

    public long js() {
        return this.v;
    }

    public void a(long j) {
        this.v = j;
    }

    public boolean tb() {
        return this.pf;
    }

    public void fo(boolean z2) {
        this.pf = z2;
    }
}
