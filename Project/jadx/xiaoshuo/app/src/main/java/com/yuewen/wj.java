package com.yuewen;

import android.content.Context;

/* JADX INFO: loaded from: classes12.dex */
public abstract class wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f19516a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f19517b = 1;
    public static boolean c = false;
    public static boolean d = false;
    public static String e = "";
    public static kv3<wj> f;

    public static wj b() {
        kv3<wj> kv3Var = f;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static boolean c() {
        return c && d;
    }

    public static boolean d() {
        return c;
    }

    public static void f(kv3<wj> kv3Var) {
        f = kv3Var;
    }

    public abstract void a(Context context);

    public abstract void e();
}
