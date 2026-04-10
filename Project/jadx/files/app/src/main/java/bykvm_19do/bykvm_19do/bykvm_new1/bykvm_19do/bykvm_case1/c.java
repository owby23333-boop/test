package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class c {
    private static boolean a;

    public static String a() {
        return a("ro.build.version.emui");
    }

    private static String a(String str) {
        String str2;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String line = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
        } catch (Throwable unused) {
            str2 = null;
        }
        try {
            line = bufferedReader.readLine();
            bufferedReader.close();
            f.a(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            str2 = line;
            bufferedReader2 = bufferedReader;
            f.a(bufferedReader2);
            return str2;
        }
    }

    public static boolean b() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            str = a();
        }
        if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.getDefault()).startsWith("emotionui")) {
            return c();
        }
        return true;
    }

    public static boolean c() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase(Locale.getDefault()).startsWith(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
            if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
                if (Build.MANUFACTURER.toLowerCase(Locale.getDefault()).startsWith(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean d() {
        if (!a) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.a = true;
                    a = true;
                    return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.a;
                }
            } catch (Exception unused) {
            }
            a = true;
        }
        return bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b.b.a;
    }
}
