package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class TTAppContextHolder {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context mb;

    private static class mb {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application mb;

        static {
            try {
                Object objOx = ox();
                mb = (Application) objOx.getClass().getMethod("getApplication", new Class[0]).invoke(objOx, new Object[0]);
                com.bytedance.sdk.openadsdk.api.mb.hj("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.mb.ox("MyApplication", "application get failed", th);
            }
        }

        public static Application mb() {
            return mb;
        }

        private static Object ox() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.mb.ox("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }
    }

    public static Context getContext() {
        if (mb == null) {
            setContext(null);
        }
        return mb;
    }

    public static synchronized void setContext(Context context) {
        if (mb == null) {
            if (context != null) {
                mb = context.getApplicationContext();
            } else if (mb.mb() != null) {
                try {
                    mb = mb.mb();
                    if (mb != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
