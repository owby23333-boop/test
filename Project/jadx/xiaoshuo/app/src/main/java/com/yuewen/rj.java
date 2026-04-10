package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public abstract class rj implements xl3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<rj> f17057a;

    public static rj b() {
        kv3<rj> kv3Var = f17057a;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void e(kv3<rj> kv3Var) {
        f17057a = kv3Var;
    }

    public abstract boolean c();

    public abstract void d(boolean z);
}
