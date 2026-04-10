package com.bytedance.sdk.openadsdk;

import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class TTAppContextHolder {
    private static volatile Context z;

    public static Context getContext() {
        if (z == null) {
            setContext(null);
        }
        return z;
    }

    public static synchronized void setContext(Context context) {
        if (z == null) {
            if (context != null) {
                z = context.getApplicationContext();
            } else if (z.z() != null) {
                try {
                    Application applicationZ = z.z();
                    z = applicationZ;
                    if (applicationZ != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
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
                m.a("MyApplication", "application get success");
            } catch (Throwable th) {
                m.gc("MyApplication", "application get failed", th);
            }
        }

        private static Object g() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                m.gc("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }
}
