package com.alipay.sdk.m.n0;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1877a = "OpenIdHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f1878b;

    public static String a(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.c);
    }

    public static String b(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.f1884b);
    }

    public static String c(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.f1883a);
    }

    public static String d(Context context) {
        f fVarA = f.a();
        return fVarA.a(context.getApplicationContext(), fVarA.d);
    }

    public static void a(boolean z) {
        f.a();
        f.a(z);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (f1878b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f1878b = method;
                method.setAccessible(true);
            }
            context = (Context) f1878b.invoke(null, new Object[0]);
        } catch (Exception e) {
            Log.e(f1877a, "ActivityThread:currentApplication --> " + e.toString());
        }
        if (context == null) {
            return false;
        }
        return f.a().a(context, false);
    }
}
