package com.bytedance.msdk.gz;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: classes2.dex */
public class lq {
    private static String z;

    public static boolean z() {
        return com.bytedance.msdk.z.gc.dl.g() && com.bytedance.msdk.core.z.kb().tb() && com.bytedance.msdk.core.z.kb().q();
    }

    public static String z(String str) {
        try {
            if (!z()) {
                return str;
            }
            String strJs = com.bytedance.msdk.core.z.kb().js();
            if (TextUtils.isEmpty(strJs)) {
                return str;
            }
            com.bytedance.msdk.z.gc.dl.z("TestHelperUtils", "AnyDoorId=" + strJs);
            return Uri.parse(str).buildUpon().appendQueryParameter(g(), strJs).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String g() {
        if (TextUtils.isEmpty(z)) {
            z = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return z;
    }
}
