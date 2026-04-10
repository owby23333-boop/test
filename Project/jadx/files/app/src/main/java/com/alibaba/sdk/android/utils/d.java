package com.alibaba.sdk.android.utils;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f2251c;

    public static void a(String str, String str2) {
        boolean z2 = f2251c;
    }

    public static void b(String str, String str2) {
        boolean z2 = f2251c;
    }

    public static void c(String str, String str2) {
        boolean z2 = f2251c;
    }

    public static void e(String str, Throwable th) {
        if (!f2251c || th == null) {
            return;
        }
        th.toString();
    }

    public static void setLogEnabled(boolean z2) {
        f2251c = z2;
    }
}
