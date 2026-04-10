package com.bytedance.sdk.openadsdk.core.ti.z;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private static Boolean z;

    private static boolean z() {
        if (z == null) {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant$RitScenes");
                z = Boolean.TRUE;
            } catch (Throwable unused) {
                z = Boolean.FALSE;
            }
        }
        return z.booleanValue();
    }

    public static String z(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return "game_more_kllkrtunities".equalsIgnoreCase(str) ? z(str) : str;
        }
        if (z()) {
            try {
                if (obj instanceof TTAdConstant.RitScenes) {
                    return ((TTAdConstant.RitScenes) obj).getScenesName();
                }
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static String z(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }
}
