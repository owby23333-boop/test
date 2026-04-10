package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122.b;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final int a = Runtime.getRuntime().availableProcessors();
    private static final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f2034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f2035d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final PriorityBlockingQueue<Runnable> f2036e;

    static {
        int i2 = (a / 2) + 1;
        if (i2 < 4) {
            i2 = 4;
        }
        b = i2;
        int i3 = (a / 2) + 1;
        if (i3 < 4) {
            i3 = 4;
        }
        f2034c = i3;
        f2035d = new PriorityBlockingQueue<>();
        f2036e = new PriorityBlockingQueue<>();
    }

    public static ThreadPoolExecutor a() {
        int i2 = b;
        return new ThreadPoolExecutor(i2, i2, 1L, TimeUnit.SECONDS, f2035d, new d(b.a.NORMAL, "tt-api-thread-"));
    }

    public static ScheduledExecutorService b() {
        return Executors.newSingleThreadScheduledExecutor(new d(b.a.LOW, "tt-delay-thread-"));
    }

    public static ThreadPoolExecutor c() {
        int i2 = f2034c;
        return new ThreadPoolExecutor(i2, i2, 1L, TimeUnit.SECONDS, f2036e, new d(b.a.NORMAL, "tt-default-thread-"));
    }
}
