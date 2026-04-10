package com.bytedance.sdk.openadsdk.core.live.gc;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static boolean z(na naVar) {
        if (naVar == null) {
            return false;
        }
        return z(naVar.vy());
    }

    public static boolean z(ls lsVar) {
        if (lsVar == null) {
            return false;
        }
        String strG = lsVar.g();
        if (TextUtils.isEmpty(strG)) {
            return false;
        }
        return strG.startsWith("snssdk2329") || strG.startsWith("snssdk1128");
    }

    public static boolean z(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("snssdk1128")) {
            return eo.z("com.ss.android.ugc.aweme");
        }
        if (str.startsWith("snssdk2329")) {
            return eo.z("com.ss.android.ugc.aweme.lite");
        }
        return false;
    }
}
