package com.bytedance.msdk.gz;

import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class hh {
    private static final CharSequence dl = "sony";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharSequence f489a = "amigo";
    private static final CharSequence gc = "funtouch";
    private static final ExecutorService m = com.bytedance.msdk.z.gc.m.z("romutils", 2, new RejectedExecutionHandler() { // from class: com.bytedance.msdk.gz.hh.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });
    public static boolean z = false;
    public static boolean g = false;

    public static String z() {
        if (pf()) {
            return ls();
        }
        if (gc()) {
            return wp();
        }
        if (g()) {
            return p();
        }
        if (fv()) {
            return js();
        }
        String strI = i();
        if (!TextUtils.isEmpty(strI)) {
            return strI;
        }
        if (e()) {
            return m();
        }
        if (gz()) {
            return fo();
        }
        if (a()) {
            return dl();
        }
        String strUy = uy();
        return !TextUtils.isEmpty(strUy) ? strUy : Build.DISPLAY;
    }

    public static boolean g() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String dl() {
        return dl("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static boolean a() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static boolean gc() {
        if (!g) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    z = true;
                    g = true;
                    return true;
                }
            } catch (Exception unused) {
            }
            g = true;
        }
        return z;
    }

    public static String m() {
        return dl("ro.vivo.os.build.display.id") + "_" + dl("ro.vivo.product.version");
    }

    public static boolean e() {
        String strDl = dl("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strDl) && strDl.toLowerCase().contains(gc);
    }

    public static boolean gz() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(f489a);
    }

    public static String fo() {
        return Build.DISPLAY + "_" + dl("ro.gn.sv.version");
    }

    public static String uy() {
        return kb() ? "eui_" + dl("ro.letv.release.version") + "_" + Build.DISPLAY : "";
    }

    public static boolean kb() {
        return !TextUtils.isEmpty(dl("ro.letv.release.version"));
    }

    public static String wp() {
        return gc() ? "miui_" + dl("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL : "";
    }

    public static String i() {
        String strV = v();
        return (strV == null || !strV.toLowerCase().contains("emotionui")) ? "" : strV + "_" + Build.DISPLAY;
    }

    public static String v() {
        return dl("ro.build.version.emui");
    }

    public static boolean pf() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String ls() {
        if (pf()) {
            try {
                return "smartisan_".concat(String.valueOf(dl("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String p() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean fv() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    public static String js() {
        return fv() ? "coloros_" + dl("ro.build.version.opporom") + "_" + Build.DISPLAY : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(String str) {
        com.bytedance.sdk.component.a.kb kbVar = (com.bytedance.sdk.component.a.kb) com.bytedance.sdk.openadsdk.ats.dl.z("system_info");
        return kbVar != null ? kbVar.get(str) : "";
    }

    private static String dl(String str) {
        String strTb;
        try {
            strTb = tb();
            try {
                if (TextUtils.isEmpty(strTb)) {
                    FutureTask futureTask = new FutureTask(new z(str));
                    m.execute(futureTask);
                    strTb = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strTb = "";
        }
        return strTb == null ? "" : strTb;
    }

    public static class z implements Callable<String> {
        private final String z;

        public z(String str) {
            this.z = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strG = hh.g(this.z);
            com.bytedance.msdk.z.gc.dl.z("RomUtils", "property:" + strG + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strG)) {
                try {
                    com.bytedance.msdk.z.gc.dl.dl("RomUtils", "SP-getPropertyFromSP:".concat(String.valueOf(strG)));
                    l.z("rom_info", com.bytedance.msdk.core.g.getContext()).z("rom_property_info", strG);
                } catch (Throwable unused) {
                }
            }
            return strG;
        }
    }

    private static String tb() {
        try {
            String strG = l.z("rom_info", com.bytedance.msdk.core.g.getContext()).g("rom_property_info", "");
            com.bytedance.msdk.z.gc.dl.g("RomUtils", "get Property From SP...=".concat(String.valueOf(strG)));
            return strG;
        } catch (Throwable unused) {
            return "";
        }
    }
}
