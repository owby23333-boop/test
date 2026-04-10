package com.bytedance.z.g;

import android.app.Application;
import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1509a;
    private static boolean dl;
    private static boolean g;
    private static boolean z;

    public static synchronized void z(Context context, gc gcVar, boolean z2, boolean z3) {
        z(context, gcVar, z2, false, z3);
    }

    public static synchronized void z(Context context, gc gcVar, boolean z2, boolean z3, boolean z4) {
        z(context, gcVar, z2, z2, z3, z4);
    }

    public static synchronized void z(final Context context, gc gcVar, boolean z2, boolean z3, boolean z4, final boolean z5) {
        if (z) {
            return;
        }
        if (context == null) {
            throw new IllegalArgumentException("context must be not null.");
        }
        if (gcVar == null) {
            throw new IllegalArgumentException("params must be not null.");
        }
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        if (com.bytedance.z.g.gz.z.dl(context)) {
            return;
        }
        gz.z(context, gcVar);
        com.bytedance.z.g.gc.z.gc.z(context);
        if (z2 || z3) {
            com.bytedance.z.g.a.z zVarZ = com.bytedance.z.g.a.z.z();
            if (z2) {
                zVarZ.z(new com.bytedance.z.g.a.dl(context));
            }
            g = true;
        }
        f1509a = z4;
        z = true;
        dl = z5;
        com.bytedance.z.g.gc.e.g().post(new Runnable() { // from class: com.bytedance.z.g.e.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.z.g.g.z.z().z(context);
                com.bytedance.z.g.e.a.z(context);
                if (z5) {
                    com.bytedance.z.g.z.m.z(context).z();
                }
            }
        });
    }

    @Deprecated
    public static void z(String str) {
        if (gz.gc().z()) {
            com.bytedance.z.g.a.z.z(str);
        }
    }

    public static void z(m mVar) {
        gz.g().z(mVar);
    }

    public static void z(Map<? extends String, ? extends String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        gz.g().z(map);
    }

    public static void z(final com.bytedance.z.z.g gVar) {
        com.bytedance.z.g.gc.e.g().post(new Runnable() { // from class: com.bytedance.z.g.e.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.z.z.z.z(gVar);
            }
        });
    }
}
