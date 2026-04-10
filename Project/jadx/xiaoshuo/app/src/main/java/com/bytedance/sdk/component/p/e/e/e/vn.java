package com.bytedance.sdk.component.p.e.e.e;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes.dex */
public class vn {
    public static String bf(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str, 10));
    }

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 10);
    }
}
