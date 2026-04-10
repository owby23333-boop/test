package com.qq.e.comm.managers.plugin;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f1952a;
    private static boolean b;

    private static void a(Throwable th) throws Throwable {
        if (b) {
            return;
        }
        if (f1952a == null) {
            Method declaredMethod = Class.forName("com.tencent.bugly.crashreport.CrashReport").getDeclaredMethod("postCatchedException", Throwable.class);
            f1952a = declaredMethod;
            declaredMethod.setAccessible(true);
        }
        f1952a.invoke(null, th);
    }

    public static void a(Throwable th, String str) {
        try {
            a(new Exception("插件错误：" + str, th));
        } catch (Throwable unused) {
            b = true;
        }
    }
}
