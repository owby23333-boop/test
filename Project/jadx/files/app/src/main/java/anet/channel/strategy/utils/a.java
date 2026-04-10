package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static AtomicInteger a = new AtomicInteger(0);
    private static ScheduledThreadPoolExecutor b = null;

    static ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new ScheduledThreadPoolExecutor(2, new b());
                    b.setKeepAliveTime(60L, TimeUnit.SECONDS);
                    b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }

    public static void a(Runnable runnable) {
        try {
            a().submit(runnable);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "submit task failed", null, e2, new Object[0]);
        }
    }

    public static void a(Runnable runnable, long j2) {
        try {
            a().schedule(runnable, j2, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            ALog.e(anet.channel.strategy.dispatch.a.TAG, "schedule task failed", null, e2, new Object[0]);
        }
    }
}
