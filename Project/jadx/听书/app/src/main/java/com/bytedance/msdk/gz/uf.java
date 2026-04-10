package com.bytedance.msdk.gz;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class uf {
    public static void z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            z(str2);
        }
    }

    private static void z(String str) {
        throw new IllegalArgumentException(str);
    }
}
