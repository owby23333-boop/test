package com.bytedance.z.dl.z.g;

import com.bytedance.z.dl.z.g.g;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class gc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f1504a;
    private static final int dl;
    private static final int g;
    private static final PriorityBlockingQueue<Runnable> gc;
    private static final int z;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        z = iAvailableProcessors;
        g = (iAvailableProcessors / 2) + 1 < 4 ? 4 : (iAvailableProcessors / 2) + 1;
        dl = (iAvailableProcessors / 2) + 1 >= 4 ? (iAvailableProcessors / 2) + 1 : 4;
        f1504a = new PriorityBlockingQueue<>();
        gc = new PriorityBlockingQueue<>();
    }

    public static ThreadPoolExecutor z() {
        int i = g;
        return new com.bytedance.sdk.component.uy.a.a(i, i, 1L, TimeUnit.SECONDS, f1504a, new a(g.z.NORMAL, "tt-api-thread-"));
    }

    public static ThreadPoolExecutor g() {
        int i = dl;
        return new com.bytedance.sdk.component.uy.a.a(i, i, 1L, TimeUnit.SECONDS, gc, new a(g.z.NORMAL, "tt-default-thread-"));
    }

    public static ScheduledExecutorService dl() {
        return com.bytedance.sdk.component.uy.dl.dl(new a(g.z.LOW, "tt-delay-thread-"));
    }
}
