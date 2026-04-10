package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class zw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f1432a;
    private static final AtomicBoolean dl = new AtomicBoolean(false);
    private static volatile com.bytedance.sdk.openadsdk.core.gk.uy g;
    private static volatile sy<com.bytedance.sdk.openadsdk.core.i.z> z;

    public static Context getContext() {
        if (f1432a == null) {
            f1432a = z.z();
        }
        return f1432a;
    }

    public static synchronized void z(Context context) {
        if (f1432a == null && context != null) {
            f1432a = context.getApplicationContext();
        }
    }

    public static sy<com.bytedance.sdk.openadsdk.core.i.z> z() {
        if (z == null) {
            synchronized (zw.class) {
                if (z == null) {
                    z = new hh(getContext());
                }
            }
        }
        return z;
    }

    public static com.bytedance.sdk.openadsdk.core.gk.uy g() {
        if (g == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.gk.uy.class) {
                if (g == null) {
                    g = new com.bytedance.sdk.openadsdk.core.gk.uy();
                }
            }
        }
        return g;
    }

    public static Function<SparseArray<Object>, Object> z(int i) {
        return un.z().z(i);
    }

    private static class z {
        private static volatile Application z;

        public static Application z() {
            return z;
        }

        static {
            try {
                Object objG = g();
                z = (Application) objG.getClass().getMethod("getApplication", new Class[0]).invoke(objG, new Object[0]);
                com.bytedance.sdk.component.utils.wp.g("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.g("MyApplication", "application get failed", th);
            }
        }

        private static Object g() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wp.g("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
