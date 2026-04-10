package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static yh1 f19328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kv3<yh1> f19329b;

    public static yh1 a() {
        kv3<yh1> kv3Var = f19329b;
        return kv3Var != null ? kv3Var.get() : f19328a;
    }

    public static void b(kv3<yh1> kv3Var) {
        f19329b = kv3Var;
    }
}
