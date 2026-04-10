package com.bytedance.e.e.v;

import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.m.d.a;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private static boolean e = false;

    private static String bf(String str) {
        BufferedReader bufferedReader;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                vn.e(bufferedReader);
                return line;
            } catch (Throwable unused) {
                vn.e(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static boolean d() {
        if (!e) {
            try {
                Class.forName("miui.os.Build");
                com.bytedance.e.e.p.bf.e = true;
                e = true;
                return true;
            } catch (Exception unused) {
                e = true;
            }
        }
        return com.bytedance.e.e.p.bf.e;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = e();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return bf();
        }
        return true;
    }

    public static boolean tg() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String e() {
        return bf(a.f1791a);
    }

    public static boolean bf() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase(Locale.getDefault()).startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
