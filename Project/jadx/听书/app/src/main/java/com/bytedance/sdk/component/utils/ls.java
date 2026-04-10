package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ls {
    public static void z(Object obj, String str) {
        if (obj == null) {
            g(str);
        }
    }

    public static void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g(str2);
        }
    }

    public static void z(boolean z, String str) {
        if (z) {
            return;
        }
        g(str);
    }

    public static void z(String str) {
        g(str);
    }

    private static void g(String str) {
        throw new IllegalArgumentException(str);
    }
}
