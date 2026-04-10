package com.baidu.mobads.sdk.internal;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class bb {
    private static final String a = "ThreadPoolFactory";
    private static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12885c = 60;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ThreadPoolExecutor f12886d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static LinkedBlockingQueue<Runnable> f12887e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ThreadFactory f12888f = new bc();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final RejectedExecutionHandler f12889g = new be();

    public static ThreadPoolExecutor a(int i2, int i3) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i3, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f12888f);
        threadPoolExecutor.setRejectedExecutionHandler(f12889g);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static ScheduledThreadPoolExecutor a(int i2) {
        return new ScheduledThreadPoolExecutor(i2, f12888f);
    }
}
