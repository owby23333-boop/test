package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class d0 {
    private static final CharSequence a = "amigo";
    private static final CharSequence b = "funtouch";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ExecutorService f1766c = ThreadHelper.initSingleThreadExecutor("romutils", 2, new a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f1767d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f1768e = false;

    static final class a implements RejectedExecutionHandler {
        a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    public static class b implements Callable<String> {
        private final String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strB = d0.b(this.a);
            Logger.d("RomUtils", "property:" + strB + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strB)) {
                try {
                    Logger.w("RomUtils", "SP-getPropertyFromSP:" + strB);
                    e0.a("rom_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("rom_property_info", strB);
                } catch (Throwable unused) {
                }
            }
            return strB;
        }
    }

    public static String a() {
        return c("ro.build.uiversion") + "_" + Build.DISPLAY;
    }

    public static String b() {
        return Build.DISPLAY + "_" + c("ro.gn.sv.version");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            try {
                Process processExec = Runtime.getRuntime().exec("getprop " + str);
                bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
                try {
                    line = bufferedReader.readLine();
                    processExec.destroy();
                    bufferedReader.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        Logger.e("ToolUtils", "Unable to read sysprop " + str, th);
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return line;
                    } catch (Throwable th2) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                Logger.e("ToolUtils", "Exception while closing InputStream", e2);
                            }
                        }
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (IOException e3) {
            Logger.e("ToolUtils", "Exception while closing InputStream", e3);
        }
        return line;
    }

    public static String c() {
        if (!o()) {
            return "";
        }
        return "coloros_" + c("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    private static String c(String str) {
        String str2;
        try {
            String strJ = j();
            if (TextUtils.isEmpty(strJ)) {
                FutureTask futureTask = new FutureTask(new b(str));
                f1766c.execute(futureTask);
                str2 = (String) futureTask.get(1L, TimeUnit.SECONDS);
            } else {
                str2 = strJ;
            }
        } catch (Throwable unused) {
            str2 = "";
        }
        return str2 == null ? "" : str2;
    }

    public static String d() {
        String strF = f();
        if (strF == null || !strF.toLowerCase().contains("emotionui")) {
            return "";
        }
        return strF + "_" + Build.DISPLAY;
    }

    public static boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            str = f();
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || s();
    }

    public static String e() {
        if (!p()) {
            return "";
        }
        return "eui_" + c("ro.letv.release.version") + "_" + Build.DISPLAY;
    }

    public static String f() {
        return c("ro.build.version.emui");
    }

    public static String g() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static String h() {
        return c("ro.vivo.os.build.display.id") + "_" + c("ro.vivo.product.version");
    }

    public static String i() {
        if (!t()) {
            return "";
        }
        return "miui_" + c("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    }

    private static String j() {
        try {
            String strA = e0.a("rom_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).a("rom_property_info", "");
            Logger.i("RomUtils", "get Property From SP...=" + strA);
            return strA;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String k() {
        if (u()) {
            return l();
        }
        if (t()) {
            return i();
        }
        if (q()) {
            return g();
        }
        if (o()) {
            return c();
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        if (r()) {
            return h();
        }
        if (n()) {
            return b();
        }
        if (m()) {
            return a();
        }
        String strE = e();
        return TextUtils.isEmpty(strE) ? Build.DISPLAY : strE;
    }

    public static String l() {
        if (u()) {
            try {
                return "smartisan_" + c("ro.smartisan.version");
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static boolean m() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains("360") || lowerCase.contains("qiku")) {
                return true;
            }
        }
        return false;
    }

    public static boolean n() {
        return !TextUtils.isEmpty(Build.DISPLAY) && Build.DISPLAY.toLowerCase().contains(a);
    }

    public static boolean o() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO);
    }

    public static boolean p() {
        return !TextUtils.isEmpty(c("ro.letv.release.version"));
    }

    public static boolean q() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean r() {
        String strC = c("ro.vivo.os.build.display.id");
        return !TextUtils.isEmpty(strC) && strC.toLowerCase().contains(b);
    }

    public static boolean s() {
        if (TextUtils.isEmpty(Build.BRAND) || !Build.BRAND.toLowerCase().startsWith(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
            if (!TextUtils.isEmpty(Build.MANUFACTURER)) {
                if (Build.MANUFACTURER.toLowerCase().startsWith(AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI)) {
                }
            }
            return false;
        }
        return true;
    }

    public static boolean t() {
        if (!f1768e) {
            try {
                if (Class.forName("miui.os.Build") != null) {
                    f1767d = true;
                    f1768e = true;
                    return f1767d;
                }
            } catch (Exception unused) {
            }
            f1768e = true;
        }
        return f1767d;
    }

    public static boolean u() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }
}
