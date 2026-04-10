package com.bytedance.z.g.gz;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private static boolean z;

    public static boolean z(String str) {
        if (TextUtils.isEmpty(str)) {
            str = z();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return g();
        }
        return true;
    }

    public static String z() {
        return g("ro.build.version.emui");
    }

    private static String g(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                m.z(bufferedReader);
                return line;
            } catch (Throwable unused) {
                m.z(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean g() {
        try {
            if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                if (TextUtils.isEmpty(Build.MANUFACTURER)) {
                    return false;
                }
                if (!Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean dl() {
        if (!z) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    com.bytedance.z.g.e.g.z = true;
                    z = true;
                    return com.bytedance.z.g.e.g.z;
                }
            } catch (Exception unused) {
            }
            z = true;
        }
        return com.bytedance.z.g.e.g.z;
    }

    public static boolean a() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }
}
