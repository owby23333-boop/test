package com.bytedance.e.e;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.e.e.ga.m;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zk {
    private static long bf = 0;
    private static String d = "default";
    private static Context e = null;

    @SuppressLint({"StaticFieldLeak"})
    private static com.bytedance.e.e.ga.e ga = null;
    private static volatile int m = 0;
    private static boolean tg = false;
    private static volatile ConcurrentHashMap<Integer, String> v;
    private static volatile String wu;
    private static com.bytedance.e.e.ga.bf vn = new com.bytedance.e.e.ga.bf();
    private static bf p = new bf();
    private static m zk = null;

    public static bf bf() {
        return p;
    }

    public static m d() {
        if (zk == null) {
            synchronized (zk.class) {
                zk = new m(e);
            }
        }
        return zk;
    }

    public static com.bytedance.e.e.ga.e e() {
        return ga;
    }

    public static com.bytedance.e.e.ga.bf ga() {
        return vn;
    }

    public static int m() {
        return m;
    }

    public static String p() {
        return d;
    }

    public static Context tg() {
        return e;
    }

    public static boolean v() {
        return tg;
    }

    public static long vn() {
        return bf;
    }

    public static String wu() {
        return wu;
    }

    public static ConcurrentHashMap<Integer, String> zk() {
        return v;
    }

    public static void e(Context context, ga gaVar) {
        bf = System.currentTimeMillis();
        e = context;
        ga = new com.bytedance.e.e.ga.e(context, gaVar);
    }
}
