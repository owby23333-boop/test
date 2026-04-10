package com.yuewen;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public abstract class wy3 implements xl3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static kv3<wy3> f19742a;

    public static wy3 b() {
        kv3<wy3> kv3Var = f19742a;
        if (kv3Var != null) {
            return kv3Var.get();
        }
        return null;
    }

    public static void g(kv3<wy3> kv3Var) {
        f19742a = kv3Var;
    }

    public abstract void a(xv1 xv1Var);

    public abstract void c(Context context);

    public abstract void d();

    public abstract void e(Activity activity);

    public abstract void f();
}
