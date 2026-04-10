package com.bytedance.sdk.component.gz.g.z.z;

import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static String z(String str) {
        return TextUtils.isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(), 10);
    }

    public static String g(String str) {
        return TextUtils.isEmpty(str) ? "" : new String(Base64.decode(str, 10));
    }
}
