package com.bytedance.sdk.component.kb.m;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private z() {
    }

    public static z z() {
        if (z != null) {
            return z;
        }
        synchronized (z.class) {
            if (z != null) {
                return z;
            }
            z zVar = new z();
            z = zVar;
            return zVar;
        }
    }

    public com.bytedance.sdk.component.kb.z.z.z z(com.bytedance.sdk.component.kb.z.z.z zVar) {
        try {
            Class<?> cls = zVar.getClass();
            return (cls.isAnnotationPresent(com.bytedance.sdk.component.kb.g.g.class) && !"SINGLETON".equals(((com.bytedance.sdk.component.kb.g.g) cls.getAnnotation(com.bytedance.sdk.component.kb.g.g.class)).z())) ? (com.bytedance.sdk.component.kb.z.z.z) cls.newInstance() : zVar;
        } catch (Throwable unused) {
            return zVar;
        }
    }

    public void z(Object obj, Map<String, Object> map) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        if (cls.isAnnotationPresent(com.bytedance.sdk.component.kb.g.g.class)) {
            z(obj, map, cls);
        }
    }

    private static void z(Object obj, Map<String, Object> map, Class<?> cls) {
        com.bytedance.sdk.component.kb.g.z zVar;
        for (Field field : z(cls)) {
            if (field != null && field.isAnnotationPresent(com.bytedance.sdk.component.kb.g.z.class) && (zVar = (com.bytedance.sdk.component.kb.g.z) field.getAnnotation(com.bytedance.sdk.component.kb.g.z.class)) != null) {
                field.setAccessible(true);
                String strZ = zVar.z();
                if (TextUtils.isEmpty(strZ)) {
                    strZ = com.bytedance.sdk.component.kb.gz.z.z(field.getName(), true);
                }
                if (!TextUtils.isEmpty(strZ)) {
                    com.bytedance.sdk.component.kb.gc.z.g.z(obj, map, field, strZ);
                }
            }
        }
    }

    public static Field[] z(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null && cls != Object.class) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        return (Field[]) arrayList.toArray(new Field[arrayList.size()]);
    }
}
