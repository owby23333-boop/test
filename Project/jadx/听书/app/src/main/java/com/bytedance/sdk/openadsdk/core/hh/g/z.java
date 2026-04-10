package com.bytedance.sdk.openadsdk.core.hh.g;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static Map<String, Field> z = new HashMap();

    private static String g(Class<?> cls, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(cls.toString()).append("#").append(str);
        return sb.toString();
    }

    public static Field z(Class<?> cls, String str) {
        Field field;
        String strG = g(cls, str);
        synchronized (z) {
            field = z.get(strG);
        }
        if (field != null) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field;
        }
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                synchronized (z) {
                    continue;
                    z.put(strG, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object z(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object z(Object obj, String str) throws IllegalAccessException {
        Field fieldZ = z(obj.getClass(), str);
        if (fieldZ != null) {
            return z(fieldZ, obj);
        }
        return null;
    }
}
