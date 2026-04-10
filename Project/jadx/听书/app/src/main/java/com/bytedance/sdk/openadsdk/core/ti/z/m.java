package com.bytedance.sdk.openadsdk.core.ti.z;

import com.bytedance.sdk.openadsdk.TTAdLoadType;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static Boolean z;

    private static boolean z() {
        if (z == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdLoadType");
                z = Boolean.TRUE;
            } catch (Throwable unused) {
                z = Boolean.FALSE;
            }
        }
        return z.booleanValue();
    }

    public static int z(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (z()) {
            try {
                if (TTAdLoadType.LOAD == obj) {
                    return 3;
                }
                if (TTAdLoadType.PRELOAD == obj) {
                    return 1;
                }
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
