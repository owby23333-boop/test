package com.bytedance.sdk.openadsdk.core.playable.g;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static boolean z(Context context) {
        try {
            String lowerCase = Build.MANUFACTURER.toLowerCase();
            if (!lowerCase.contains("huawei") && !lowerCase.contains("honor")) {
                if (lowerCase.contains("vivo")) {
                    return a(context);
                }
                if (lowerCase.contains("oppo")) {
                    return gc(context);
                }
                if (!lowerCase.contains(MediationConstant.ADN_XIAOMI) && !lowerCase.contains("redmi")) {
                    if (lowerCase.contains("samsung")) {
                        return false;
                    }
                    return m(context);
                }
                return dl(context);
            }
            return g(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean z() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        return lowerCase.contains("huawei") || lowerCase.contains("honor") || lowerCase.contains("vivo") || lowerCase.contains(MediationConstant.ADN_XIAOMI) || lowerCase.contains("redmi") || lowerCase.contains("oppo");
    }

    private static boolean g(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }

    private static boolean dl(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    private static boolean a(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
    }

    private static boolean gc(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "hide_navigationbar_enable", 0) != 0;
    }

    private static boolean m(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) != 0;
    }
}
