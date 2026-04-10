package com.yuewen;

/* JADX INFO: loaded from: classes2.dex */
public abstract class tj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<tj> f17995a;

    public static tj a() {
        kv3<tj> kv3Var = f17995a;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void d(kv3<tj> kv3Var) {
        f17995a = kv3Var;
    }

    public abstract void b(long j, boolean z);

    public abstract void c(long j, boolean z);
}
