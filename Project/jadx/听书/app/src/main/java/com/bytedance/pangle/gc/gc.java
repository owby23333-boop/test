package com.bytedance.pangle.gc;

import com.bytedance.pangle.m;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static m z;

    public static void z(m mVar) {
        z = mVar;
    }

    public static void z(Runnable runnable, boolean z2) {
        if (z2) {
            z(runnable);
        } else {
            g(runnable);
        }
    }

    public static void z(Runnable runnable) {
        z.z(runnable);
    }

    public static void g(Runnable runnable) {
        z.g(runnable);
    }

    public static void dl(Runnable runnable) {
        z.dl(runnable);
    }
}
