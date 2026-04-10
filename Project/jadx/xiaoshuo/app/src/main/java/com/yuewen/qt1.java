package com.yuewen;

import android.util.Log;
import com.xm.logsdk.log.CrashHandler;

/* JADX INFO: loaded from: classes12.dex */
public class qt1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16695a = "LogUtil";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f16696b = true;
    public static boolean c = true;
    public static boolean d = false;

    public static void a(String str, String str2) {
        bl0.b(str, str2);
    }

    public static void b(String str, String str2, Throwable th) {
        bl0.c(str, str2, th);
    }

    public static void c(String str, Object... objArr) {
        bl0.d(str, objArr);
    }

    public static void d(String str, String str2) {
        bl0.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        bl0.f(str, str2, th);
    }

    public static void f(String str, Object[] objArr) {
        bl0.g(str, objArr);
    }

    public static boolean g() {
        return f16696b;
    }

    public static String h(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Throwable th2) {
            p(th2);
            return null;
        }
    }

    public static void i(String str, String str2) {
        bl0.i(str, str2);
    }

    public static void j(String str, String str2, Throwable th) {
        bl0.j(str, str2, th);
    }

    public static void k(String str, Object... objArr) {
        bl0.k(str, objArr);
    }

    public static void l(String str, int i, CrashHandler.CrashCallback crashCallback) {
        bl0.l(str, i, crashCallback);
    }

    public static void m() {
        bl0.m();
    }

    public static void n(int i, String str, String str2) {
        bl0.p(i, str, str2);
    }

    public static void o(String str) {
        bl0.r(str);
    }

    public static void p(Throwable th) {
        if (th != null) {
            th.printStackTrace();
        }
    }

    public static void q(int i) {
        bl0.s(i);
    }

    public static void r(String str, String str2) {
        bl0.t(str, str2);
    }

    public static void s(String str, String str2, Throwable th) {
        bl0.u(str, str2, th);
    }

    public static void t(String str, String str2) {
        bl0.v(str, str2);
    }

    public static void u(String str, String str2, Throwable th) {
        bl0.w(str, str2, th);
    }

    public static void v(String str, Throwable th) {
        bl0.x(str, th);
    }

    public static void w(String str, Object... objArr) {
        bl0.y(str, objArr);
    }
}
