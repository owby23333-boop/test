package com.yuewen;

import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class hi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<hi> f12039a;

    public static hi a() {
        kv3<hi> kv3Var = f12039a;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void c(kv3<hi> kv3Var) {
        f12039a = kv3Var;
    }

    public abstract HashMap<String, String> b();
}
