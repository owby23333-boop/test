package com.lxj.xpopup.util;

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

/* JADX INFO: compiled from: FuckRomUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final String[] a = {AgooConstants.MESSAGE_SYSTEM_SOURCE_HUAWEI};
    private static final String[] b = {AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f17561c = {AgooConstants.MESSAGE_SYSTEM_SOURCE_XIAOMI};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f17562d = {AgooConstants.MESSAGE_SYSTEM_SOURCE_OPPO};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f17563e = {"leeco", "letv"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f17564f = {"360", "qiku"};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f17565g = {"zte"};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String[] f17566h = {"oneplus"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String[] f17567i = {"nubia"};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f17568j = {"coolpad", "yulong"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f17569k = {"lg", "lge"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f17570l = {"google"};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String[] f17571m = {"samsung"};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String[] f17572n = {AgooConstants.MESSAGE_SYSTEM_SOURCE_MEIZU};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String[] f17573o = {"lenovo"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final String[] f17574p = {"smartisan"};

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String[] f17575q = {"htc"};

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String[] f17576r = {"sony"};

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String[] f17577s = {"gionee", "amigo"};

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String[] f17578t = {"motorola"};

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static C0496a f17579u = null;

    /* JADX INFO: renamed from: com.lxj.xpopup.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FuckRomUtils.java */
    public static class C0496a {
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

    public static C0496a c() {
        C0496a c0496a = f17579u;
        if (c0496a != null) {
            return c0496a;
        }
        f17579u = new C0496a();
        String strA = a();
        String strB = b();
        if (a(strA, strB, a)) {
            f17579u.a = a[0];
            String strA2 = a("ro.build.version.emui");
            String[] strArrSplit = strA2.split("_");
            if (strArrSplit.length > 1) {
                f17579u.b = strArrSplit[1];
            } else {
                f17579u.b = strA2;
            }
            return f17579u;
        }
        if (a(strA, strB, b)) {
            f17579u.a = b[0];
            f17579u.b = a("ro.vivo.os.build.display.id");
            return f17579u;
        }
        if (a(strA, strB, f17561c)) {
            f17579u.a = f17561c[0];
            f17579u.b = a("ro.build.version.incremental");
            return f17579u;
        }
        if (a(strA, strB, f17562d)) {
            f17579u.a = f17562d[0];
            f17579u.b = a("ro.build.version.opporom");
            return f17579u;
        }
        if (a(strA, strB, f17563e)) {
            f17579u.a = f17563e[0];
            f17579u.b = a("ro.letv.release.version");
            return f17579u;
        }
        if (a(strA, strB, f17564f)) {
            f17579u.a = f17564f[0];
            f17579u.b = a("ro.build.uiversion");
            return f17579u;
        }
        if (a(strA, strB, f17565g)) {
            f17579u.a = f17565g[0];
            f17579u.b = a("ro.build.MiFavor_version");
            return f17579u;
        }
        if (a(strA, strB, f17566h)) {
            f17579u.a = f17566h[0];
            f17579u.b = a("ro.rom.version");
            return f17579u;
        }
        if (a(strA, strB, f17567i)) {
            f17579u.a = f17567i[0];
            f17579u.b = a("ro.build.rom.id");
            return f17579u;
        }
        if (a(strA, strB, f17568j)) {
            f17579u.a = f17568j[0];
        } else if (a(strA, strB, f17569k)) {
            f17579u.a = f17569k[0];
        } else if (a(strA, strB, f17570l)) {
            f17579u.a = f17570l[0];
        } else if (a(strA, strB, f17571m)) {
            f17579u.a = f17571m[0];
        } else if (a(strA, strB, f17572n)) {
            f17579u.a = f17572n[0];
        } else if (a(strA, strB, f17573o)) {
            f17579u.a = f17573o[0];
        } else if (a(strA, strB, f17574p)) {
            f17579u.a = f17574p[0];
        } else if (a(strA, strB, f17575q)) {
            f17579u.a = f17575q[0];
        } else if (a(strA, strB, f17576r)) {
            f17579u.a = f17576r[0];
        } else if (a(strA, strB, f17577s)) {
            f17579u.a = f17577s[0];
        } else if (a(strA, strB, f17578t)) {
            f17579u.a = f17578t[0];
        } else {
            f17579u.a = strB;
        }
        f17579u.b = a("");
        return f17579u;
    }

    public static boolean d() {
        return b[0].equals(c().a);
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
