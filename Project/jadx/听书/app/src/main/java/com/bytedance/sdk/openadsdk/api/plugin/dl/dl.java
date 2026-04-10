package com.bytedance.sdk.openadsdk.api.plugin.dl;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.m;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static boolean z() {
        String[] strArr = Build.SUPPORTED_ABIS;
        m.z("abi-support: " + (strArr == null ? "null" : strArr.toString()));
        if (strArr == null) {
            return false;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str) && str.toLowerCase().contains("arm64-v8a")) {
                return true;
            }
        }
        return false;
    }

    public static boolean g() {
        return dl() && !z();
    }

    public static boolean dl() {
        m.dl("isOA8A: false");
        return false;
    }
}
