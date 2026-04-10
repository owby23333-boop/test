package com.bytedance.sdk.openadsdk.upie.z;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.utils.gz;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final Handler z = new Handler(Looper.getMainLooper());

    public static void z(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            z.post(runnable);
        }
    }

    public static void g(Runnable runnable) {
        z.post(runnable);
    }

    public static void dl(Runnable runnable) {
        gz.dl().post(runnable);
    }
}
