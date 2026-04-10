package com.yuewen;

/* JADX INFO: loaded from: classes2.dex */
public abstract class sj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<sj> f17472a;

    public static sj c() {
        kv3<sj> kv3Var = f17472a;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void e(kv3<sj> kv3Var) {
        f17472a = kv3Var;
    }

    public abstract void a(o30 o30Var);

    public abstract void b(boolean z);

    public abstract void d();
}
