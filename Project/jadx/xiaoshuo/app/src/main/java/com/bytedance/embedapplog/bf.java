package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ryg.utils.DLConstants;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class bf {
    private static final CharSequence e = "sony";
    private static final CharSequence bf = "amigo";
    private static final CharSequence d = "funtouch";
    private static final e<Boolean> tg = new e<Boolean>() { // from class: com.bytedance.embedapplog.bf.1
    };

    public static abstract class e<T> {
    }

    public static boolean bf() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("huawei")) {
                return false;
            }
        }
        return true;
    }

    private static String bh() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean d() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("honor")) {
            String str2 = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith("honor")) {
                return false;
            }
        }
        return true;
    }

    public static String e() {
        return bf(com.alipay.sdk.m.d.a.f1791a);
    }

    public static boolean ga() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean m() {
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strBf = bf("ro.build.version.incremental");
        return !TextUtils.isEmpty(strBf) && strBf.contains("VIBEUI_V2");
    }

    public static boolean p() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains("meizu");
    }

    public static boolean tg() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean v() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean vn() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean wu() {
        return bh().toUpperCase().contains("NUBIA");
    }

    public static boolean xu() {
        return bh().toUpperCase().contains("ASUS");
    }

    public static boolean zk() {
        return DLConstants.BRAND_SAMSUNG.equalsIgnoreCase(Build.BRAND) || DLConstants.BRAND_SAMSUNG.equalsIgnoreCase(Build.MANUFACTURER);
    }

    private static String bf(String str) {
        String strE = g.e(str);
        return !TextUtils.isEmpty(strE) ? strE : pl.e(str);
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = e();
        }
        return (!TextUtils.isEmpty(str) && (str.toLowerCase().contains("emotionui") || str.toLowerCase().contains("magicui"))) || bf() || d();
    }

    public static boolean e(Context context) {
        return bh().toUpperCase().contains("HUAWEI");
    }
}
