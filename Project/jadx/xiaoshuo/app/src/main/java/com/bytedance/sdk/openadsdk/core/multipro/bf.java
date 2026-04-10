package com.bytedance.sdk.openadsdk.core.multipro;

import com.bytedance.sdk.openadsdk.core.a.cv;

/* JADX INFO: loaded from: classes10.dex */
public class bf {
    public static boolean bf;
    public static boolean e;

    public static class e {
        static final com.bytedance.sdk.component.vn.e e = cv.e("sp_multi_info");
    }

    public static void bf() {
        if (bf) {
            e.e.e("is_support_multi_process", false);
        }
        e = false;
    }

    public static boolean d() {
        if (!bf) {
            e = e.e.bf("is_support_multi_process", false);
            bf = true;
        }
        return e;
    }

    public static void e() {
        if (!bf) {
            e.e.e("is_support_multi_process", true);
        }
        e = true;
        bf = true;
    }
}
