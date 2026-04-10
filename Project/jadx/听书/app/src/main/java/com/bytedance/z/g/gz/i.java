package com.bytedance.z.g.gz;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static final CharSequence z = "sony";
    private static final CharSequence g = "amigo";
    private static final CharSequence dl = "funtouch";

    public static String z() {
        if (dl.dl()) {
            return uy();
        }
        if (dl.a()) {
            return wp();
        }
        if (i()) {
            return v();
        }
        String strKb = kb();
        if (!TextUtils.isEmpty(strKb)) {
            return strKb;
        }
        if (gc()) {
            return a();
        }
        if (m()) {
            return e();
        }
        if (dl()) {
            return g();
        }
        String strGz = gz();
        return !TextUtils.isEmpty(strGz) ? strGz : Build.DISPLAY;
    }

    public static String g() {
        return z("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean dl() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String a() {
        return z("ro.vivo.os.build.display.id") + "_" + z("ro.vivo.product.version");
    }

    public static boolean gc() {
        String strZ = z("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strZ) && strZ.toLowerCase(Locale.getDefault()).contains(dl);
    }

    public static boolean m() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(g);
    }

    public static String e() {
        return Build.DISPLAY + "_" + z("ro.gn.sv.version");
    }

    public static String gz() {
        return fo() ? "eui_" + z("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean fo() {
        return !TextUtils.isEmpty(z("ro.letv.release.version"));
    }

    public static String uy() {
        return dl.dl() ? "miui_" + z("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String kb() {
        String strZ = dl.z();
        return (strZ == null || !strZ.toLowerCase(Locale.getDefault()).contains("emotionui")) ? "" : strZ + "_" + Build.DISPLAY;
    }

    public static String wp() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static boolean i() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String v() {
        return i() ? "coloros_" + z("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    private static String z(String str) {
        BufferedReader bufferedReader;
        Process processExec;
        String line = "";
        try {
            processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        try {
            line = bufferedReader.readLine();
            processExec.destroy();
            m.z(bufferedReader);
            return line;
        } catch (Throwable unused2) {
            m.z(bufferedReader);
            return line;
        }
    }
}
