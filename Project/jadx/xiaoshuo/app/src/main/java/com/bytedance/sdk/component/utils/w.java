package com.bytedance.sdk.component.utils;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class w {
    private static void bf(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            bf(str);
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            bf(str2);
        }
    }

    public static void e(boolean z, String str) {
        if (z) {
            return;
        }
        bf(str);
    }

    public static void e(String str) {
        bf(str);
    }
}
