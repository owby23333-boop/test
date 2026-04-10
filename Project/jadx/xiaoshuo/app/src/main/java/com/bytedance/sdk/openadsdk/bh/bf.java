package com.bytedance.sdk.openadsdk.bh;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    private v bf;
    private e ga;
    private int tg;
    private ScheduledExecutorService e = null;
    private long d = 0;

    public interface e {
        void e();
    }

    public bf(v vVar, int i) {
        this.bf = vVar;
        this.tg = i;
    }

    public boolean bf() {
        ScheduledExecutorService scheduledExecutorService = this.e;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService.isShutdown();
        }
        return true;
    }

    public void e(long j) {
        this.d = j;
    }

    public void e(int i) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.e = scheduledExecutorServiceNewScheduledThreadPool;
        scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: com.bytedance.sdk.openadsdk.bh.bf.1
            @Override // java.lang.Runnable
            public void run() {
                p.e("Playable_CrashMonitor", "-- check page stuck  " + (System.currentTimeMillis() - bf.this.d));
                if (System.currentTimeMillis() - bf.this.d > bf.this.tg) {
                    bf.this.e.shutdown();
                    if (bf.this.bf != null) {
                        bf.this.bf.bf(0, "自动检测卡死");
                    }
                    if (bf.this.ga != null) {
                        bf.this.ga.e();
                    }
                }
            }
        }, 0L, i, TimeUnit.MILLISECONDS);
    }

    public void e() {
        ScheduledExecutorService scheduledExecutorService = this.e;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
        }
    }
}
