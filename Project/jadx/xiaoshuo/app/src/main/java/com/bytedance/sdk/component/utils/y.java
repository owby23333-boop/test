package com.bytedance.sdk.component.utils;

import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class y {
    private static volatile String e;

    public static String e() {
        if (!TextUtils.isEmpty(e)) {
            return e;
        }
        e = Build.MODEL;
        return e;
    }
}
