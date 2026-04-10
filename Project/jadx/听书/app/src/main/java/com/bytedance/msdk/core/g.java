package com.bytedance.msdk.core;

import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile com.bytedance.msdk.gc.g.z<com.bytedance.msdk.gc.z> dl;
    private static volatile com.bytedance.msdk.core.v.dl g;
    private static volatile Context z;

    public static Context getContext() {
        if (z == null) {
            z(null);
        }
        return z;
    }

    public static com.bytedance.msdk.gc.g.z<com.bytedance.msdk.gc.z> z() {
        if (dl == null) {
            synchronized (g.class) {
                if (dl == null) {
                    dl = new com.bytedance.msdk.gc.g.g();
                }
            }
        }
        return dl;
    }

    public static synchronized void z(Context context) {
        if (z == null) {
            synchronized (g.class) {
                if (z.z() != null) {
                    try {
                        Application applicationZ = z.z();
                        z = applicationZ;
                        if (applicationZ != null) {
                            return;
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (context != null) {
                    z = context.getApplicationContext();
                }
            }
        }
    }

    public static com.bytedance.msdk.core.v.dl g() {
        if (g == null) {
            synchronized (com.bytedance.msdk.core.v.dl.class) {
                if (g == null) {
                    g = new com.bytedance.msdk.core.v.dl();
                }
            }
        }
        return g;
    }

    public static class z {
        private static volatile Application z;

        public static Application z() {
            return z;
        }

        static {
            try {
                Object objG = g();
                z = (Application) objG.getClass().getMethod("getApplication", new Class[0]).invoke(objG, new Object[0]);
                com.bytedance.msdk.z.gc.dl.a("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.msdk.z.gc.dl.g("MyApplication", "application get failed", th);
            }
        }

        private static Object g() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.msdk.z.gc.dl.g("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
