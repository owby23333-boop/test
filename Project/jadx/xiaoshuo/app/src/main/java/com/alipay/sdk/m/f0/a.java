package com.alipay.sdk.m.f0;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f1809a = new a();

    public static a a() {
        return f1809a;
    }

    public String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName;
        } catch (Exception unused) {
            return "0.0.0";
        }
    }
}
