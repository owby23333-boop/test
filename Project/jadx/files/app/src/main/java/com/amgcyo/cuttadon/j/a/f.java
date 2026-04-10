package com.amgcyo.cuttadon.j.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: FutureThreadPool.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static volatile f a;
    private static ExecutorService b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f4046c = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f4047d = Math.max(2, Math.min(f4046c - 1, 4));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f4048e = (f4046c * 2) + 1;

    private f() {
    }

    public static f a() {
        if (a == null) {
            synchronized (f.class) {
                a = new f();
                String str = "线程数：" + f4047d + " 最大：" + f4048e + " CPU个数：" + f4046c;
                b = Executors.newFixedThreadPool(f4048e / 2);
            }
        }
        return a;
    }

    public <T> FutureTask<T> a(h<T> hVar) {
        b.submit(hVar);
        return hVar;
    }
}
