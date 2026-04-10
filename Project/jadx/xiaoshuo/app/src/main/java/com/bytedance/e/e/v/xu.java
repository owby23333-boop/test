package com.bytedance.e.e.v;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class xu {
    private static final CharSequence e = "sony";
    private static final CharSequence bf = "amigo";
    private static final CharSequence d = "funtouch";

    public static String bf() {
        return e("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean bh() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static boolean d() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String e() {
        if (d.d()) {
            return m();
        }
        if (d.tg()) {
            return xu();
        }
        if (bh()) {
            return t();
        }
        String strWu = wu();
        if (!TextUtils.isEmpty(strWu)) {
            return strWu;
        }
        if (ga()) {
            return tg();
        }
        if (vn()) {
            return p();
        }
        if (d()) {
            return bf();
        }
        String strV = v();
        return !TextUtils.isEmpty(strV) ? strV : Build.DISPLAY;
    }

    public static boolean ga() {
        String strE = e("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strE) && strE.toLowerCase(Locale.getDefault()).contains(d);
    }

    public static String m() {
        if (!d.d()) {
            return "";
        }
        return "miui_" + e("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String p() {
        return Build.DISPLAY + "_" + e("ro.gn.sv.version");
    }

    public static String t() {
        if (!bh()) {
            return "";
        }
        return "coloros_" + e("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String tg() {
        return e("ro.vivo.os.build.display.id") + "_" + e("ro.vivo.product.version");
    }

    public static String v() {
        if (!zk()) {
            return "";
        }
        return "eui_" + e("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean vn() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(bf);
    }

    public static String wu() {
        String strE = d.e();
        if (strE == null || !strE.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        return strE + "_" + Build.DISPLAY;
    }

    public static String xu() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean zk() {
        return !TextUtils.isEmpty(e("ro.letv.release.version"));
    }

    private static String e(String str) {
        Process processExec;
        BufferedReader bufferedReader;
        String line = "";
        BufferedReader bufferedReader2 = null;
        try {
            processExec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
        } catch (Throwable unused) {
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            vn.e(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            bufferedReader2 = bufferedReader;
            vn.e(bufferedReader2);
            return line;
        }
    }
}
