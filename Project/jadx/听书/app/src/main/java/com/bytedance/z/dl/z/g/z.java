package com.bytedance.z.dl.z.g;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ScheduledExecutorService f1505a;
    private static volatile ThreadPoolExecutor dl;
    private static volatile ThreadPoolExecutor g;
    private static final ConcurrentHashMap<String, dl> gc = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, dl> m = new ConcurrentHashMap<>();
    private static volatile z z;

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    private z() {
        g = gc.z();
        dl = gc.g();
        f1505a = gc.dl();
    }

    public void z(dl dlVar) {
        if (dlVar == null) {
            throw new IllegalArgumentException("param is not be null");
        }
        if (g != null) {
            g.execute(dlVar);
        }
    }
}
