package com.umeng.message.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.PushAgent;
import com.umeng.message.common.UPLog;

/* JADX INFO: compiled from: R2.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static final String a = "R2";
    private static b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f20444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Class<?> f20445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Class<?> f20446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Class<?> f20447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Class<?> f20448g;

    private b(Context context) {
        this.f20444c = context.getApplicationContext();
        String resourcePackageName = PushAgent.getInstance(context).getResourcePackageName();
        resourcePackageName = TextUtils.isEmpty(resourcePackageName) ? context.getPackageName() : resourcePackageName;
        UPLog.d(a, "resPackageName:" + resourcePackageName);
        try {
            this.f20446e = Class.forName(resourcePackageName + ".R$drawable");
        } catch (ClassNotFoundException e2) {
            UPLog.e(a, e2.getMessage());
            UMLog.aq(t.f20514c, 0, "\\|");
        }
        try {
            this.f20447f = Class.forName(resourcePackageName + ".R$layout");
        } catch (ClassNotFoundException e3) {
            UPLog.w(a, e3.getMessage());
        }
        try {
            this.f20445d = Class.forName(resourcePackageName + ".R$id");
        } catch (ClassNotFoundException e4) {
            UPLog.w(a, e4.getMessage());
        }
        try {
            this.f20448g = Class.forName(resourcePackageName + ".R$raw");
        } catch (ClassNotFoundException e5) {
            UPLog.i(a, e5.getMessage());
        }
    }

    public static int a(String str) {
        return a(r.b()).g(str);
    }

    public static int b(String str) {
        return a(r.b()).e(str);
    }

    public static int c(String str) {
        return a(r.b()).f(str);
    }

    public static int d(String str) {
        return a(r.b()).h(str);
    }

    private int e(String str) {
        return a(this.f20445d, str);
    }

    private int f(String str) {
        return a(this.f20446e, str);
    }

    private int g(String str) {
        return a(this.f20447f, str);
    }

    private int h(String str) {
        return a(this.f20448g, str);
    }

    public static b a(Context context) {
        if (b == null) {
            b = new b(context);
        }
        return b;
    }

    private int a(Class<?> cls, String str) {
        if (cls != null) {
            try {
                return cls.getField(str).getInt(str);
            } catch (Exception unused) {
                UPLog.w(a, "getRes(" + cls.getName() + ", " + str + ") failed!");
                return -1;
            }
        }
        UPLog.e(a, "getRes(null," + str + ad.f20406s);
        throw new IllegalArgumentException("资源包名未初始化，请确保你已经添加了必要的资源。同时确保你在混淆文件中添加了" + this.f20444c.getPackageName() + ".R$* 。 field=" + str);
    }
}
