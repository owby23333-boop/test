package com.bytedance.sdk.component.utils;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class js {
    private static Method g;
    private static Object z;

    static {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class cls = (Class) declaredMethod.invoke(null, "dalvik.system.VMRuntime");
            Method method = (Method) declaredMethod2.invoke(cls, "getRuntime", null);
            g = (Method) declaredMethod2.invoke(cls, "setHiddenApiExemptions", new Class[]{String[].class});
            z = method.invoke(null, new Object[0]);
        } catch (Throwable th) {
            wp.g("Reflection", "reflect bootstrap failed:", th);
        }
    }

    public static boolean z(String... strArr) {
        Method method;
        Object obj = z;
        if (obj != null && (method = g) != null) {
            try {
                method.invoke(obj, strArr);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean z() {
        return z("L");
    }
}
