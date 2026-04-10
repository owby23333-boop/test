package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class io {
    private static volatile String z;

    public static String z() {
        if (!TextUtils.isEmpty(z)) {
            return z;
        }
        String str = Build.MODEL;
        z = str;
        return str;
    }
}
