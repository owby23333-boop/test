package com.alipay.sdk.m.y;

import com.alipay.sdk.interior.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Log.ISdkLogCallback f1984a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f1985b = "alipaysdk";

    public static void a(Log.ISdkLogCallback iSdkLogCallback) {
        f1984a = iSdkLogCallback;
    }

    public static void b(String str, String str2) {
        a(a(str, str2));
    }

    public static void c(String str, String str2) {
        a(a(str, str2));
    }

    public static void d(String str, String str2) {
        a(a(str, str2));
    }

    public static void e(String str, String str2) {
        a(a(str, str2));
    }

    public static void a(String str) {
        try {
            Log.ISdkLogCallback iSdkLogCallback = f1984a;
            if (iSdkLogCallback != null) {
                if (com.alipay.sdk.m.o.b.i().g(null)) {
                    iSdkLogCallback.onLogLine("[AlipaySDK] " + str);
                } else {
                    iSdkLogCallback.onLogLine(String.format("[AlipaySDK] %s %s", new SimpleDateFormat("hh:mm:ss.SSS", Locale.getDefault()).format(new Date()), str));
                }
            }
        } catch (Throwable unused) {
            android.util.Log.w("alipaySdkLog", "writeLog error");
        }
    }

    public static String b(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void a(String str, String str2, Throwable th) {
        a(a(str, str2) + " " + b(th));
    }

    public static void a(Throwable th) {
        if (th == null) {
            return;
        }
        try {
            a(b(th));
        } catch (Throwable unused) {
        }
    }

    public static String a(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!com.alipay.sdk.m.o.b.i().g(null)) {
            return "[" + str + "][" + str2 + "]";
        }
        return String.format("[%s][%s]", str, str2);
    }
}
