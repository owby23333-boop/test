package com.baidu.mobads.sdk.internal;

import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ba {
    private static final String a = "TaskScheduler";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ba f12883d;
    private ThreadPoolExecutor b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledThreadPoolExecutor f12884c;

    private ba() {
        b();
    }

    public static ba a() {
        if (f12883d == null) {
            synchronized (ba.class) {
                if (f12883d == null) {
                    f12883d = new ba();
                }
            }
        }
        return f12883d;
    }

    private void b() {
        this.b = bb.a(1, 1);
        this.f12884c = bb.a(1);
    }

    public void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor;
        if (runnable == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            this.b.submit(runnable);
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (hVar == null || (threadPoolExecutor = this.b) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            FutureTask futureTask = null;
            if (this.b != null && !this.b.isShutdown()) {
                futureTask = (FutureTask) this.b.submit(hVar);
            }
            hVar.a((Future) futureTask);
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar, long j2, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f12884c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f12884c.schedule(hVar, j2, timeUnit));
        } catch (Throwable unused) {
        }
    }

    public void a(h hVar, long j2, long j3, TimeUnit timeUnit) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        if (hVar == null || (scheduledThreadPoolExecutor = this.f12884c) == null || scheduledThreadPoolExecutor.isShutdown()) {
            return;
        }
        try {
            hVar.a(System.currentTimeMillis());
            hVar.a((Future) this.f12884c.scheduleAtFixedRate(hVar, j2, j3, timeUnit));
        } catch (Throwable unused) {
        }
    }
}
