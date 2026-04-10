package com.bytedance.sdk.component.utils;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private static Method bf;
    private static Object e;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            bf = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            e = method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            wu.bf("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean e(String... strArr) {
        Method method;
        Object obj = e;
        if (obj != null && (method = bf) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean e() {
        return e("L");
    }
}
