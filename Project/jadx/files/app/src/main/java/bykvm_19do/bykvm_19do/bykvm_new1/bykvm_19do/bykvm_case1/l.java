package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private static final CharSequence a = "amigo";
    private static final CharSequence b = "funtouch";

    public static String a() {
        return a("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    private static String a(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop " + str);
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
        f.a(bufferedReader);
        return line;
    }

    public static String b() {
        return Build.DISPLAY + "_" + a("ro.gn.sv.version");
    }

    public static String c() {
        if (!l()) {
            return "";
        }
        return "coloros_" + a("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String d() {
        String strA = c.a();
        if (strA == null || !strA.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        return strA + "_" + Build.DISPLAY;
    }

    public static String e() {
        if (!m()) {
            return "";
        }
        return "eui_" + a("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String f() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static String g() {
        return a("ro.vivo.os.build.display.id") + "_" + a("ro.vivo.product.version");
    }

    public static String h() {
        if (!c.d()) {
            return "";
        }
        return "miui_" + a("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    public static String i() {
        if (c.d()) {
            return h();
        }
        if (c.b()) {
            return f();
        }
        if (l()) {
            return c();
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        if (n()) {
            return g();
        }
        if (k()) {
            return b();
        }
        if (j()) {
            return a();
        }
        String strE = e();
        return TextUtils.isEmpty(strE) ? Build.DISPLAY : strE;
    }

    public static boolean j() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase(Locale.getDefault());
            if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                return true;
            }
        }
        return false;
    }

    public static boolean k() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase(Locale.getDefault()).contains(a);
    }

    public static boolean l() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO);
    }

    public static boolean m() {
        return !TextUtils.isEmpty(a("ro.letv.release.version"));
    }

    public static boolean n() {
        String strA = a("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strA) && strA.toLowerCase(Locale.getDefault()).contains(b);
    }
}
