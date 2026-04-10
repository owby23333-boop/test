package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: InternalConfig.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String[] f2156a = new String[2];

    public static void a(Context context, String str, String str2) {
        String[] strArr = f2156a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            com.umeng.common.b.a(context).a(str, str2);
        }
    }

    public static String[] a(Context context) {
        String[] strArrA;
        if (!TextUtils.isEmpty(f2156a[0]) && !TextUtils.isEmpty(f2156a[1])) {
            return f2156a;
        }
        if (context == null || (strArrA = com.umeng.common.b.a(context).a()) == null) {
            return null;
        }
        String[] strArr = f2156a;
        strArr[0] = strArrA[0];
        strArr[1] = strArrA[1];
        return strArr;
    }

    public static void b(Context context) {
        String[] strArr = f2156a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            com.umeng.common.b.a(context).b();
        }
    }
}
