package com.bytedance.sdk.openadsdk.core.gz;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.zw;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    public static String z(String str) {
        String strLs = zw.g().ls();
        if (TextUtils.isEmpty(strLs)) {
            return "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/csj_assets/".concat(String.valueOf(str));
        }
        return strLs + str;
    }
}
