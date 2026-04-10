package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: classes2.dex */
public class v {
    public static void z(pf pfVar) {
        uf.z(pfVar);
    }

    public static boolean z(Context context) {
        return dl(context) != 0;
    }

    public static int g(Context context) {
        int iDl = dl(context);
        if (iDl == 1) {
            return 0;
        }
        if (iDl == 4) {
            return 1;
        }
        if (iDl == 5) {
            return 4;
        }
        if (iDl != 6) {
            return iDl;
        }
        return 6;
    }

    public static int dl(Context context) {
        return uf.z(context, 60000L);
    }

    public static boolean a(Context context) {
        return dl(context) == 4;
    }

    public static boolean gc(Context context) {
        return dl(context) == 5;
    }

    public static boolean m(Context context) {
        return dl(context) == 6;
    }

    public static String e(Context context) {
        int iDl = dl(context);
        return iDl != 2 ? iDl != 3 ? iDl != 4 ? iDl != 5 ? iDl != 6 ? "mobile" : NetworkUtil.NETWORK_CLASS_5G : NetworkUtil.NETWORK_CLASS_4G : "wifi" : NetworkUtil.NETWORK_CLASS_3G : "2g";
    }

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
