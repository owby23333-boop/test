package com.bytedance.sdk.openadsdk.core.un;

import com.bytedance.sdk.openadsdk.core.iq.jq;
import com.bytedance.sdk.openadsdk.core.iq.y;

/* JADX INFO: loaded from: classes2.dex */
public class iq {
    public static String z(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return "";
        }
        int iGz = gz(naVar);
        if (iGz != 3) {
            return iGz != 4 ? "" : jq.gc(naVar);
        }
        return com.bytedance.sdk.openadsdk.core.iq.js.m(naVar);
    }

    public static boolean g(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        return (naVar == null || gz(naVar) == 0) ? false : true;
    }

    private static int gz(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (com.bytedance.sdk.openadsdk.core.iq.js.z(naVar)) {
            return 3;
        }
        return jq.z(naVar) ? 4 : 0;
    }

    public static boolean dl(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null || y.z(naVar) || gz(naVar) != 3) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.iq.js.z(naVar);
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        return naVar != null && gz(naVar) == 4;
    }

    public static int gc(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar != null && gz(naVar) == 3) {
            return com.bytedance.sdk.openadsdk.core.iq.js.fo(naVar);
        }
        return 0;
    }

    public static int m(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        if (naVar == null) {
            return -1;
        }
        if (gz(naVar) != 3) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.iq.js.uy(naVar);
    }

    public static boolean e(com.bytedance.sdk.openadsdk.core.iq.na naVar) {
        return gz(naVar) == 3;
    }
}
