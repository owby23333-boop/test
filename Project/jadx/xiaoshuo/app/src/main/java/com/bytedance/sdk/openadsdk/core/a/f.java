package com.bytedance.sdk.openadsdk.core.a;

import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes10.dex */
public class f {
    public static boolean bf = false;
    public static boolean e = false;
    private static String p = null;
    private static int v = Integer.MAX_VALUE;
    private static final CharSequence d = "sony";
    private static final CharSequence tg = "amigo";
    private static final CharSequence ga = "funtouch";
    private static final CharSequence vn = "origin";

    public static class e implements Callable<String> {
        private String e;

        public e(String str) {
            this.e = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strD = f.d(this.e);
            com.bytedance.sdk.component.utils.wu.bf("RomUtils", "property:" + strD + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strD)) {
                try {
                    cv.e("rom_info").e("rom_property_info", strD);
                } catch (Throwable unused) {
                }
            }
            return strD;
        }
    }

    public static String bh() {
        String strT = t();
        if (strT == null || !strT.toLowerCase().contains("emotionui")) {
            return "";
        }
        return strT + "_" + Build.DISPLAY;
    }

    public static String d() {
        return tg("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean dt() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("huawei")) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2)) {
                    return false;
                }
                if (!str2.toLowerCase().startsWith("huawei")) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String e() {
        if (!TextUtils.isEmpty(p)) {
            return p;
        }
        String strE = com.bytedance.sdk.openadsdk.core.xu.e("sdk_local_rom_info", 604800000L);
        p = strE;
        if (TextUtils.isEmpty(strE)) {
            String strPe = pe();
            p = strPe;
            com.bytedance.sdk.openadsdk.core.xu.bf("sdk_local_rom_info", strPe);
        }
        return p;
    }

    public static boolean f() {
        if (v == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strZk = a.zk("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ROOT).contains(strZk)) {
                v = 0;
            } else {
                v = 1;
            }
        }
        return v == 1;
    }

    public static boolean ga() {
        if (!bf) {
            try {
                Class.forName("miui.os.Build");
                e = true;
                bf = true;
                return true;
            } catch (Exception unused) {
                bf = true;
            }
        }
        return e;
    }

    public static String k() {
        if (!f()) {
            return "";
        }
        return "coloros_" + tg(a.zk("ro.build.version.kllkrom")) + "_" + Build.DISPLAY;
    }

    public static String l() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String m() {
        if (!wu()) {
            return "";
        }
        return "eui_" + tg("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static boolean p() {
        String strTg = tg("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strTg) && strTg.toLowerCase(Locale.ROOT).contains(ga);
    }

    private static String pe() {
        if (s()) {
            return w();
        }
        if (ga()) {
            return xu();
        }
        if (bf()) {
            return l();
        }
        if (f()) {
            return k();
        }
        String strBh = bh();
        if (!TextUtils.isEmpty(strBh)) {
            return strBh;
        }
        if (p()) {
            return vn();
        }
        if (v()) {
            return zk();
        }
        if (tg()) {
            return d();
        }
        String strM = m();
        return !TextUtils.isEmpty(strM) ? strM : Build.DISPLAY;
    }

    public static boolean s() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String t() {
        return tg(com.alipay.sdk.m.d.a.f1791a);
    }

    public static boolean tg() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean v() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(tg);
    }

    public static String vn() {
        return tg("ro.vivo.os.build.display.id") + "_" + tg("ro.vivo.product.version");
    }

    public static String w() {
        if (s()) {
            try {
                return "smartisan_" + tg("ro.smartisan.version");
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static boolean wu() {
        return !TextUtils.isEmpty(tg("ro.letv.release.version"));
    }

    public static String xu() {
        if (!ga()) {
            return "";
        }
        return "miui_" + tg("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String y() {
        try {
            return cv.e("rom_info").bf("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String zk() {
        return Build.DISPLAY + "_" + tg("ro.gn.sv.version");
    }

    public static boolean bf() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        String line = "";
        Process process = null;
        try {
        } catch (IOException e2) {
            com.bytedance.sdk.component.utils.wu.d("ToolUtils", "Exception while closing InputStream", e2);
        }
        try {
            try {
                Process processExec = Runtime.getRuntime().exec("getprop " + str);
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                    try {
                        line = bufferedReader.readLine();
                        processExec.exitValue();
                        bufferedReader.close();
                    } catch (IllegalThreadStateException unused) {
                        process = processExec;
                        try {
                            process.destroy();
                        } catch (Throwable unused2) {
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return line;
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            com.bytedance.sdk.component.utils.wu.d("ToolUtils", "Unable to read sysprop " + str, th);
                            return line;
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    com.bytedance.sdk.component.utils.wu.d("ToolUtils", "Exception while closing InputStream", e3);
                                }
                            }
                        }
                    }
                } catch (IllegalThreadStateException unused3) {
                    bufferedReader = null;
                }
            } catch (IllegalThreadStateException unused4) {
                bufferedReader = null;
            }
            return line;
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String tg(String str) {
        String strY;
        try {
            strY = y();
            try {
                if (TextUtils.isEmpty(strY)) {
                    final com.bytedance.sdk.component.zk.vn vnVar = new com.bytedance.sdk.component.zk.vn(new e(str), 5, 2);
                    com.bytedance.sdk.component.zk.ga.bf(new com.bytedance.sdk.component.zk.p("getSystemPropertyTask") { // from class: com.bytedance.sdk.openadsdk.core.a.f.1
                        @Override // java.lang.Runnable
                        public void run() {
                            vnVar.run();
                        }
                    });
                    strY = (String) vnVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strY = "";
        }
        return strY == null ? "" : strY;
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = t();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || dt();
    }
}
