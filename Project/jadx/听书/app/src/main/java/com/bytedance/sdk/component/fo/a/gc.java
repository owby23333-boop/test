package com.bytedance.sdk.component.fo.a;

import com.bytedance.sdk.component.utils.wp;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static int g = 4;
    private static boolean z;

    public static boolean z() {
        return z;
    }

    public static void z(String str, String str2) {
        if (z && str2 != null && g <= 4) {
            wp.z(wp.a(str), str2);
        }
    }
}
