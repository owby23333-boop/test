package com.qmuiteam.qmui;

/* JADX INFO: loaded from: classes4.dex */
public class QMUILog {
    private static QMUILogDelegate sDelegete;

    public interface QMUILogDelegate {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void setDelegete(QMUILogDelegate qMUILogDelegate) {
        sDelegete = qMUILogDelegate;
    }

    public static void e(String str, String str2, Object... objArr) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        QMUILogDelegate qMUILogDelegate = sDelegete;
        if (qMUILogDelegate != null) {
            qMUILogDelegate.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
