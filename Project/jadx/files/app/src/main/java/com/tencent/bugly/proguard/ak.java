package com.tencent.bugly.proguard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes3.dex */
public final class ak {
    private static final AtomicInteger a = new AtomicInteger(1);
    private static ak b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ScheduledExecutorService f18538c;

    protected ak() {
        this.f18538c = null;
        this.f18538c = Executors.newScheduledThreadPool(3, new ThreadFactory() { // from class: com.tencent.bugly.proguard.ak.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BuglyThread-" + ak.a.getAndIncrement());
                return thread;
            }
        });
        ScheduledExecutorService scheduledExecutorService = this.f18538c;
        if (scheduledExecutorService == null || scheduledExecutorService.isShutdown()) {
            al.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized ak a() {
        if (b == null) {
            b = new ak();
        }
        return b;
    }

    public final synchronized void b() {
        if (this.f18538c != null && !this.f18538c.isShutdown()) {
            al.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.f18538c.shutdownNow();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized boolean c() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.concurrent.ScheduledExecutorService r0 = r1.f18538c     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L10
            java.util.concurrent.ScheduledExecutorService r0 = r1.f18538c     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isShutdown()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L10
            r0 = 1
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = 0
            goto Le
        L12:
            r0 = move-exception
            monitor-exit(r1)
            goto L16
        L15:
            throw r0
        L16:
            goto L15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.ak.c():boolean");
    }

    public final synchronized boolean a(Runnable runnable, long j2) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (j2 <= 0) {
            j2 = 0;
        }
        al.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j2), runnable.getClass().getName());
        try {
            this.f18538c.schedule(runnable, j2, TimeUnit.MILLISECONDS);
            return true;
        } catch (Throwable th) {
            if (p.f18774c) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public final synchronized boolean a(Runnable runnable) {
        if (!c()) {
            al.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        }
        if (runnable == null) {
            al.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        }
        al.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
        try {
            this.f18538c.execute(runnable);
            return true;
        } catch (Throwable th) {
            if (p.f18774c) {
                th.printStackTrace();
            }
            return false;
        }
    }
}
