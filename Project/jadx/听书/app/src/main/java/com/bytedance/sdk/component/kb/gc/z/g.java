package com.bytedance.sdk.component.kb.gc.z;

import com.bytedance.sdk.component.kb.gc.z.z.a;
import com.bytedance.sdk.component.kb.gc.z.z.dl;
import com.bytedance.sdk.component.kb.gc.z.z.e;
import com.bytedance.sdk.component.kb.gc.z.z.gc;
import com.bytedance.sdk.component.kb.gc.z.z.gz;
import com.bytedance.sdk.component.kb.gc.z.z.m;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static final Map<Class, z> z;

    static {
        HashMap map = new HashMap();
        z = map;
        m mVar = new m();
        gz gzVar = new gz();
        e eVar = new e();
        com.bytedance.sdk.component.kb.gc.z.z.g gVar = new com.bytedance.sdk.component.kb.gc.z.z.g();
        a aVar = new a();
        gc gcVar = new gc();
        com.bytedance.sdk.component.kb.gc.z.z.z zVar = new com.bytedance.sdk.component.kb.gc.z.z.z();
        dl dlVar = new dl();
        map.put(Integer.class, mVar);
        map.put(Integer.TYPE, mVar);
        map.put(Short.class, gzVar);
        map.put(Short.TYPE, gzVar);
        map.put(Long.class, eVar);
        map.put(Long.TYPE, eVar);
        map.put(Byte.class, gVar);
        map.put(Byte.TYPE, gVar);
        map.put(Double.class, aVar);
        map.put(Double.TYPE, aVar);
        map.put(Float.class, gcVar);
        map.put(Float.TYPE, gcVar);
        map.put(Boolean.class, zVar);
        map.put(Boolean.TYPE, zVar);
        map.put(Character.class, dlVar);
        map.put(Character.TYPE, dlVar);
    }

    public static void z(Object obj, Field field, Object obj2) {
        Object objZ;
        if (field == null || obj2 == null) {
            return;
        }
        Class<?> type = field.getType();
        try {
            objZ = type.getConstructor(new Class[0]).newInstance(obj2);
        } catch (Throwable unused) {
            objZ = z(type, obj2);
        }
        try {
            field.setAccessible(true);
            field.set(obj, objZ);
        } catch (Throwable unused2) {
        }
    }

    public static void z(Object obj, Map<String, Object> map, Field field, String str) {
        Object obj2;
        if (field == null || (obj2 = map.get(str)) == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(obj, obj2);
        } catch (Throwable unused) {
            z(obj, field, obj2);
        }
    }

    public static Object z(Class cls, Object obj) {
        String strValueOf = String.valueOf(obj);
        if (String.class.equals(cls)) {
            return strValueOf;
        }
        z zVar = z.get(cls);
        return zVar == null ? obj : zVar.z(cls, strValueOf);
    }
}
