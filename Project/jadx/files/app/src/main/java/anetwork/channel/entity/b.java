package anetwork.channel.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final ExecutorService[] a = new ExecutorService[2];
    private static AtomicInteger b = new AtomicInteger(0);

    static {
        for (int i2 = 0; i2 < 2; i2++) {
            a[i2] = Executors.newSingleThreadExecutor(new c());
        }
    }

    public static void a(int i2, Runnable runnable) {
        a[Math.abs(i2 % 2)].submit(runnable);
    }
}
