package com.bytedance.z.g;

import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class gz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1520a = false;
    private static String dl = "default";
    private static long g;
    private static com.bytedance.z.g.gc.z gc;
    private static volatile ConcurrentHashMap<Integer, String> gz;
    private static volatile String kb;
    private static volatile int uy;
    private static Context z;
    private static com.bytedance.z.g.gc.g m = new com.bytedance.z.g.gc.g();
    private static g e = new g();
    private static com.bytedance.z.g.gc.gz fo = null;

    public static com.bytedance.z.g.gc.z z() {
        return gc;
    }

    public static g g() {
        return e;
    }

    public static com.bytedance.z.g.gc.gz dl() {
        if (fo == null) {
            synchronized (gz.class) {
                fo = new com.bytedance.z.g.gc.gz(z);
            }
        }
        return fo;
    }

    static void z(Context context, gc gcVar) {
        g = System.currentTimeMillis();
        z = context;
        gc = new com.bytedance.z.g.gc.z(z, gcVar);
    }

    public static Context a() {
        return z;
    }

    public static com.bytedance.z.g.gc.g gc() {
        return m;
    }

    public static long m() {
        return g;
    }

    public static String e() {
        return dl;
    }

    public static boolean gz() {
        return f1520a;
    }

    public static ConcurrentHashMap<Integer, String> fo() {
        return gz;
    }

    public static int uy() {
        return uy;
    }

    public static String kb() {
        return kb;
    }
}
