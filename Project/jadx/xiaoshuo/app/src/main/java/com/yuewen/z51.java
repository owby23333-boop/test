package com.yuewen;

/* JADX INFO: loaded from: classes3.dex */
public class z51 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f20690a = "FontManagerProxy";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static kv3<nj1> f20691b;
    public static nj1 c;

    public static nj1 a() {
        kv3<nj1> kv3Var;
        if (c == null && (kv3Var = f20691b) != null) {
            c = kv3Var.get();
        }
        nj1 nj1Var = c;
        if (nj1Var != null) {
            return nj1Var;
        }
        throw new RuntimeException("FontManager need be initiated first");
    }

    public static void b(kv3<nj1> kv3Var) {
        f20691b = kv3Var;
    }
}
