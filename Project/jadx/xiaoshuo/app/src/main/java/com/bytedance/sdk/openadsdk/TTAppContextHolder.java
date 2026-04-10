package com.bytedance.sdk.openadsdk;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bytedance.sdk.openadsdk.api.bf;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes10.dex */
public class TTAppContextHolder {

    @SuppressLint({"StaticFieldLeak"})
    private static volatile Context e;

    public static class e {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application e;

        static {
            try {
                Object objBf = bf();
                e = (Application) objBf.getClass().getMethod("getApplication", new Class[0]).invoke(objBf, new Object[0]);
                bf.d("MyApplication", "application get success");
            } catch (Throwable th) {
                bf.e("MyApplication", "application get failed", th);
            }
        }

        private static Object bf() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                bf.e("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application e() {
            return e;
        }
    }

    public static Context getContext() {
        if (e == null) {
            setContext(null);
        }
        return e;
    }

    public static synchronized void setContext(Context context) {
        if (e == null) {
            if (context != null) {
                e = context.getApplicationContext();
            } else if (e.e() != null) {
                try {
                    e = e.e();
                    if (e != null) {
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }
}
