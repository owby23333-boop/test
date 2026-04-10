package com.bytedance.sdk.openadsdk.core.un;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class uf {
    private static Method dl;
    private static Method g;
    private static Method z;

    static {
        try {
            z = Class.class.getDeclaredMethod("forName", String.class);
            g = Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            dl = Class.class.getDeclaredMethod("getDeclaredField", String.class);
        } catch (NoSuchMethodException | NullPointerException unused) {
        }
    }

    public static Object z(Object obj, String str, String str2, Object obj2) {
        try {
            Field fieldZ = z(str, str2);
            if (fieldZ == null) {
                return obj2;
            }
            fieldZ.setAccessible(true);
            return fieldZ.get(obj);
        } catch (IllegalAccessException unused) {
            return obj2;
        }
    }

    public static Field z(String str, String str2) {
        if (!z()) {
            return null;
        }
        try {
            Field field = (Field) dl.invoke((Class) z.invoke(null, str), str2);
            try {
                field.setAccessible(true);
            } catch (Throwable unused) {
            }
            return field;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static boolean z() {
        return (z == null || g == null || dl == null) ? false : true;
    }
}
