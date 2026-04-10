package com.bytedance.sdk.component.adexpress.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static boolean z(String str) {
        return TextUtils.equals(str, "fullscreen_interstitial_ad") || TextUtils.equals(str, "rewarded_video");
    }

    public static boolean g(String str) {
        return com.bytedance.sdk.component.adexpress.a.z() && z(str);
    }
}
