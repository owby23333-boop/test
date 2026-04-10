package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.bykv.vk.openvk.api.proto.Bridge;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes10.dex */
public class lc {
    private static volatile com.bytedance.sdk.openadsdk.core.lc.vn bf;
    private static final AtomicBoolean d = new AtomicBoolean(false);
    private static volatile uk<com.bytedance.sdk.openadsdk.core.wu.e> e;
    private static volatile Context tg;

    public static class e {

        @SuppressLint({"StaticFieldLeak"})
        private static volatile Application e;

        static {
            try {
                Object objBf = bf();
                e = (Application) objBf.getClass().getMethod("getApplication", new Class[0]).invoke(objBf, new Object[0]);
                com.bytedance.sdk.component.utils.wu.tg("MyApplication", "application get success");
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wu.bf("MyApplication", "application get failed", th);
            }
        }

        private static Object bf() {
            try {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
                method.setAccessible(true);
                return method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.wu.bf("MyApplication", "ActivityThread get error, maybe api level <= 4.2.2", th);
                return null;
            }
        }

        public static Application e() {
            return e;
        }
    }

    public static com.bytedance.sdk.openadsdk.core.lc.vn bf() {
        if (bf == null) {
            synchronized (com.bytedance.sdk.openadsdk.core.lc.vn.class) {
                if (bf == null) {
                    bf = new com.bytedance.sdk.openadsdk.core.lc.vn();
                }
            }
        }
        return bf;
    }

    public static void d() {
        AtomicBoolean atomicBoolean = d;
        if (atomicBoolean != null) {
            atomicBoolean.set(true);
        }
    }

    public static synchronized void e(Context context) {
        if (tg == null && context != null) {
            tg = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        if (tg == null) {
            tg = e.e();
        }
        return tg;
    }

    public static boolean tg() {
        AtomicBoolean atomicBoolean = d;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }

    public static uk<com.bytedance.sdk.openadsdk.core.wu.e> e() {
        if (e == null) {
            synchronized (lc.class) {
                if (e == null) {
                    e = new fy(getContext());
                }
            }
        }
        return e;
    }

    public static Bridge e(int i) {
        return rm.e().e(i);
    }
}
