package com.yyxk.xlog;

import android.text.TextUtils;

/* JADX INFO: compiled from: KLog.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static boolean a = true;
    private static String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f20613c = System.getProperty("line.separator");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f20614d = true;

    public static void a(String str, boolean z2) {
        a = z2;
        b = str;
        f20614d = TextUtils.isEmpty(b);
    }
}
