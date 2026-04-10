package com.kwad.sdk.core.threads.kwai;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean amh = false;
    private final ConcurrentHashMap<Runnable, Long> ami;
    private long amj;
    private int amk;

    public a(int i2, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.ami = new ConcurrentHashMap<>();
        this.amj = 0L;
        this.amk = 0;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (amh && this.ami.containsKey(runnable) && this.ami.get(runnable) != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.ami.get(runnable).longValue();
            if (jElapsedRealtime >= 0 && jElapsedRealtime < 1800000) {
                long j2 = this.amj;
                int i2 = this.amk;
                this.amj = ((j2 * ((long) i2)) + jElapsedRealtime) / ((long) (i2 + 1));
                this.amk = i2 + 1;
            }
            this.ami.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (amh) {
            this.ami.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }

    @Override // com.kwad.sdk.core.threads.kwai.c
    public final long yr() {
        return this.amj;
    }
}
