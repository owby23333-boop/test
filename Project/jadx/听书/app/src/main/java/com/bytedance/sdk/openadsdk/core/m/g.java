package com.bytedance.sdk.openadsdk.core.m;

import com.bytedance.sdk.openadsdk.core.zw;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile boolean g;
    private static volatile Random z;

    public static boolean z() {
        return g;
    }

    public static void g() {
        z(zw.g().xl(), true);
    }

    public static boolean z(float f, boolean z2) {
        if (f <= 0.0f) {
            if (z2) {
                g = false;
            }
            return false;
        }
        int iNextInt = dl().nextInt(100);
        int i = (int) (f * 100.0f);
        if (z2) {
            g = iNextInt < i;
        }
        return iNextInt < i;
    }

    private static Random dl() {
        if (z != null) {
            return z;
        }
        Random randomDl = com.bytedance.sdk.component.utils.z.dl();
        z = randomDl;
        return randomDl;
    }
}
