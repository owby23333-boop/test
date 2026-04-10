package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.un.x;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public static boolean g;
    public static boolean z;

    static class z {
        static final com.bytedance.sdk.component.a.g.dl z = x.z("sp_multi_info");
    }

    public static void z() {
        if (!g) {
            z.z.put("is_support_multi_process", true);
        }
        z = true;
        g = true;
    }

    public static void g() {
        if (g) {
            z.z.put("is_support_multi_process", false);
        }
        z = false;
    }

    public static boolean dl() {
        if (!g) {
            z = z.z.get("is_support_multi_process", false);
            g = true;
        }
        return z;
    }
}
