package com.bytedance.msdk.z.gc;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    public static String z() {
        return "TTMediationSDK_";
    }

    public static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return z();
        }
        return "TTMediationSDK_" + str + "_";
    }

    public static String z(com.bytedance.msdk.core.uy.g gVar) {
        if (gVar == null || TextUtils.isEmpty(gVar.un())) {
            return z();
        }
        return "TTMediationSDK_" + gVar.un() + "_";
    }

    public static String z(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return z();
        }
        if (TextUtils.isEmpty(str2)) {
            return z(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }

    public static String g(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return z();
        }
        if (TextUtils.isEmpty(str2)) {
            return z(str);
        }
        return "TTMediationSDK_" + str + "_" + str2 + "_";
    }
}
