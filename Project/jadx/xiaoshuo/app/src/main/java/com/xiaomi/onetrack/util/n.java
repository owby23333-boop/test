package com.xiaomi.onetrack.util;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7719a = "IdentifierManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f7720b;
    private static Class<?> c;
    private static Method d;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            c = cls;
            f7720b = cls.newInstance();
            d = c.getMethod("getOAID", Context.class);
        } catch (Exception e) {
            p.a("IdentifierManager", "reflect exception!", e);
        }
    }

    public static boolean a() {
        return (c == null || f7720b == null) ? false : true;
    }

    public static String a(Context context) {
        return a(context, d);
    }

    private static String a(Context context, Method method) {
        Object obj;
        if (context == null || (obj = f7720b) == null || method == null) {
            return "";
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            return objInvoke != null ? (String) objInvoke : "";
        } catch (Throwable th) {
            p.a("IdentifierManager", "oaid invoke exception!", th);
            return "";
        }
    }
}
