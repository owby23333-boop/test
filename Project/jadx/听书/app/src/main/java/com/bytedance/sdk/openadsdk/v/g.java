package com.bytedance.sdk.openadsdk.v;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1486a;
    private gz g;
    private ScheduledExecutorService z = null;
    private long dl = 0;

    public g(gz gzVar, int i) {
        this.g = gzVar;
        this.f1486a = i;
    }

    public void z(long j) {
        this.dl = j;
    }

    public void z(int i) {
        ScheduledExecutorService scheduledExecutorServiceZ = com.bytedance.sdk.component.uy.dl.z(1, new com.bytedance.sdk.component.uy.uy("/CrashMonitor"));
        this.z = scheduledExecutorServiceZ;
        scheduledExecutorServiceZ.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.v.g.1
            @Override // java.lang.Runnable
            public void run() {
                System.currentTimeMillis();
                if (System.currentTimeMillis() - g.this.dl > g.this.f1486a) {
                    g.this.z.shutdown();
                    if (g.this.g != null) {
                        g.this.g.g(0, "自动检测卡死");
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void z() {
        ScheduledExecutorService scheduledExecutorService = this.z;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }

    public boolean g() {
        ScheduledExecutorService scheduledExecutorService = this.z;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }
}
