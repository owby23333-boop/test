package com.amgcyo.cuttadon.j.f;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: compiled from: NotchRomUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private static final String[] a = {AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI};
    private static final String[] b = {AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f4083c = {AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f4084d = {AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f4085e = {"leeco", "letv"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f4086f = {"360", "qiku"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f4087g = {"zte"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f4088h = {"oneplus"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f4089i = {"nubia"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f4090j = {"coolpad", "yulong"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f4091k = {"lg", "lge"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f4092l = {"google"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f4093m = {"samsung"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String[] f4094n = {AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String[] f4095o = {"lenovo"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f4096p = {"smartisan"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f4097q = {"htc"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String[] f4098r = {"sony"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String[] f4099s = {"gionee", "amigo"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String[] f4100t = {"motorola"};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static a f4101u = null;

    /* JADX INFO: compiled from: NotchRomUtils.java */
    public static class a {
        private String a;
        private String b;

        public String toString() {
            return "RomInfo{name=" + this.a + ", version=" + this.b + "}";
        }
    }

    private static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    private static String b() {
        try {
            String str = Build.MANUFACTURER;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    public static a c() {
        a aVar = f4101u;
        if (aVar != null) {
            return aVar;
        }
        f4101u = new a();
        String strA = a();
        String strB = b();
        if (a(strA, strB, a)) {
            f4101u.a = a[0];
            String strA2 = a("ro.build.version.emui");
            String[] strArrSplit = strA2.split("_");
            if (strArrSplit.length > 1) {
                f4101u.b = strArrSplit[1];
            } else {
                f4101u.b = strA2;
            }
            return f4101u;
        }
        if (a(strA, strB, b)) {
            f4101u.a = b[0];
            f4101u.b = a("ro.vivo.os.build.display.id");
            return f4101u;
        }
        if (a(strA, strB, f4083c)) {
            f4101u.a = f4083c[0];
            f4101u.b = a("ro.build.version.incremental");
            return f4101u;
        }
        if (a(strA, strB, f4084d)) {
            f4101u.a = f4084d[0];
            f4101u.b = a("ro.build.version.opporom");
            return f4101u;
        }
        if (a(strA, strB, f4085e)) {
            f4101u.a = f4085e[0];
            f4101u.b = a("ro.letv.release.version");
            return f4101u;
        }
        if (a(strA, strB, f4086f)) {
            f4101u.a = f4086f[0];
            f4101u.b = a("ro.build.uiversion");
            return f4101u;
        }
        if (a(strA, strB, f4087g)) {
            f4101u.a = f4087g[0];
            f4101u.b = a("ro.build.MiFavor_version");
            return f4101u;
        }
        if (a(strA, strB, f4088h)) {
            f4101u.a = f4088h[0];
            f4101u.b = a("ro.rom.version");
            return f4101u;
        }
        if (a(strA, strB, f4089i)) {
            f4101u.a = f4089i[0];
            f4101u.b = a("ro.build.rom.id");
            return f4101u;
        }
        if (a(strA, strB, f4090j)) {
            f4101u.a = f4090j[0];
        } else if (a(strA, strB, f4091k)) {
            f4101u.a = f4091k[0];
        } else if (a(strA, strB, f4092l)) {
            f4101u.a = f4092l[0];
        } else if (a(strA, strB, f4093m)) {
            f4101u.a = f4093m[0];
        } else if (a(strA, strB, f4094n)) {
            f4101u.a = f4094n[0];
        } else if (a(strA, strB, f4095o)) {
            f4101u.a = f4095o[0];
        } else if (a(strA, strB, f4096p)) {
            f4101u.a = f4096p[0];
        } else if (a(strA, strB, f4097q)) {
            f4101u.a = f4097q[0];
        } else if (a(strA, strB, f4098r)) {
            f4101u.a = f4098r[0];
        } else if (a(strA, strB, f4099s)) {
            f4101u.a = f4099s[0];
        } else if (a(strA, strB, f4100t)) {
            f4101u.a = f4100t[0];
        } else {
            f4101u.a = strB;
        }
        f4101u.b = a("");
        return f4101u;
    }

    public static boolean d() {
        return a[0].equals(c().a);
    }

    public static boolean e() {
        return f4083c[0].equals(c().a);
    }

    private static String d(String str) throws Throwable {
        BufferedReader bufferedReader;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    line = bufferedReader.readLine();
                } catch (IOException unused) {
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 == null) {
                        return "";
                    }
                    bufferedReader2.close();
                } catch (Throwable th) {
                    th = th;
                    bufferedReader2 = bufferedReader;
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
            if (line != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused4) {
                }
                return line;
            }
            bufferedReader.close();
            return "";
        } catch (IOException unused5) {
            return "";
        }
    }

    private static String e(String str) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
            return properties.getProperty(str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a() {
        try {
            String str = Build.BRAND;
            return !TextUtils.isEmpty(str) ? str.toLowerCase() : "unknown";
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static String b(String str) throws Throwable {
        String strD = d(str);
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        String strE = e(str);
        return (TextUtils.isEmpty(strE) && Build.VERSION.SDK_INT < 28) ? c(str) : strE;
    }

    private static String a(String str) {
        String strB = !TextUtils.isEmpty(str) ? b(str) : "";
        if (TextUtils.isEmpty(strB) || strB.equals("unknown")) {
            try {
                String str2 = Build.DISPLAY;
                if (!TextUtils.isEmpty(str2)) {
                    strB = str2.toLowerCase();
                }
            } catch (Throwable unused) {
            }
        }
        return TextUtils.isEmpty(strB) ? "unknown" : strB;
    }

    private static String c(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }
}
