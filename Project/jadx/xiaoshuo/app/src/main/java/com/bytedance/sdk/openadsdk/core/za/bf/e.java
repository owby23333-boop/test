package com.bytedance.sdk.openadsdk.core.za.bf;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class e {
    private static Map<String, Field> e = new HashMap();

    private static String bf(Class<?> cls, String str) {
        return cls.toString() + "#" + str;
    }

    public static Field e(Class<?> cls, String str) {
        Field field;
        String strBf = bf(cls, str);
        synchronized (e) {
            field = e.get(strBf);
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
                synchronized (e) {
                    continue;
                    e.put(strBf, declaredField);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        return null;
    }

    public static Object e(Field field, Object obj) throws IllegalAccessException {
        if (!field.isAccessible()) {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object e(Object obj, String str) throws IllegalAccessException {
        Field fieldE = e(obj.getClass(), str);
        if (fieldE != null) {
            return e(fieldE, obj);
        }
        return null;
    }
}
