package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class ty1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<uj1> f18260a;

    public static uj1 a() {
        kv3<uj1> kv3Var = f18260a;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        throw new RuntimeException("Menu factory need to be init first");
    }

    public static void b(kv3<uj1> kv3Var) {
        f18260a = kv3Var;
    }
}
