package com.bytedance.sdk.openadsdk.s;

import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.cv;

/* JADX INFO: loaded from: classes10.dex */
public class vn {
    public static void bf(com.bytedance.sdk.component.zk.p pVar) {
        com.bytedance.sdk.component.zk.ga.d(pVar);
    }

    public static boolean e() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void e(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            cv.p().post(runnable);
        }
    }

    public static void e(com.bytedance.sdk.component.zk.p pVar) {
        com.bytedance.sdk.component.zk.ga.bf(pVar);
    }
}
