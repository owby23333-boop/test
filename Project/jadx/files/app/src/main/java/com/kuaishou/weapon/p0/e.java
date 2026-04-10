package com.kuaishou.weapon.p0;

import android.text.TextUtils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static final int a = 0;
    public static final int b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16717c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f16718d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16719e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f16720f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static ThreadLocal<StringBuilder> f16721g = new ThreadLocal<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f16722h;

    public static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private static void a(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length < 3) {
            return;
        }
        String fileName = stackTrace[2].getFileName();
        int lineNumber = stackTrace[2].getLineNumber();
        String methodName = stackTrace[2].getMethodName();
        if (fileName.length() > 5) {
            fileName = fileName.substring(0, fileName.length() - 5);
        }
        StringBuilder sb = f16721g.get();
        if (sb == null) {
            sb = new StringBuilder();
            f16721g.set(sb);
        }
        synchronized (sb) {
            sb.setLength(0);
            sb.append("[");
            sb.append(f16722h);
            sb.append("][");
            sb.append(fileName);
            sb.append(':');
            sb.append(lineNumber);
            sb.append('.');
            sb.append(methodName);
            sb.append("] ");
            sb.append(str);
            sb.toString();
            f16722h++;
        }
    }

    public static void a(String str) {
        int i2 = f16720f;
        if (i2 == -1 || i2 == 0) {
            a(0, str);
        }
    }

    public static void a(String str, Throwable th) {
        int i2 = f16720f;
        if (i2 == -1 || i2 == 0) {
            a(0, str + "\n" + a(th));
        }
    }

    public static void b(String str) {
        int i2 = f16720f;
        if (i2 == -1 || i2 == 0 || i2 == 1) {
            a(1, str);
        }
    }

    public static void b(String str, Throwable th) {
        int i2 = f16720f;
        if (i2 == -1 || i2 == 0 || i2 == 1) {
            a(1, str + "\n" + a(th));
        }
    }

    public static void c(String str) {
        int i2 = f16720f;
        if (i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
            a(2, str);
        }
    }

    public static void c(String str, Throwable th) {
        int i2 = f16720f;
        if (i2 == -1 || i2 == 0 || i2 == 1 || i2 == 2) {
            a(2, str + "\n" + a(th));
        }
    }

    public static void d(String str) {
    }
}
