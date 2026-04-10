package com.bytedance.sdk.openadsdk.hh;

import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.zw;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean z() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void z(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            q.m().post(runnable);
        }
    }

    public static void z(Runnable runnable, long j) {
        q.m().postDelayed(runnable, j);
    }

    public static void z(com.bytedance.sdk.component.uy.fo foVar) {
        com.bytedance.sdk.component.uy.e.g(foVar);
    }

    public static void g(com.bytedance.sdk.component.uy.fo foVar) {
        com.bytedance.sdk.component.uy.e.dl(foVar);
    }

    public static void g(Runnable runnable) {
        if (zw.g().re() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            q.m().post(runnable);
        }
    }

    public static void dl(Runnable runnable) {
        if (zw.g().jt()) {
            com.bytedance.sdk.component.utils.gz.dl().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void z(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (!z()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(runnable);
        } else {
            com.bytedance.sdk.component.uy.e.g(new com.bytedance.sdk.component.uy.fo("") { // from class: com.bytedance.sdk.openadsdk.hh.e.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }

    public static void a(Runnable runnable) {
        z(runnable, (ScheduledExecutorService) null);
    }

    public static Looper g() {
        return zw.g().jt() ? com.bytedance.sdk.component.utils.gz.dl().getLooper() : Looper.getMainLooper();
    }
}
