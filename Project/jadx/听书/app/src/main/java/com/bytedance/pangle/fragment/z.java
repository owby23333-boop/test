package com.bytedance.pangle.fragment;

import androidx.collection.SimpleArrayMap;
import androidx.fragment.app.Fragment;
import com.bytedance.sdk.openadsdk.api.m;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
class z {
    public static void z(Class cls) {
        try {
            if (Fragment.class.getName().contains("support")) {
                ((SimpleArrayMap) z(Fragment.class, "sClassMap").get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldZ = z(Fragment.class, "sClassMap");
            if (fieldZ != null) {
                ((SimpleArrayMap) fieldZ.get(null)).put(cls.getName(), cls);
                return;
            }
            Class clsZ = z("androidx.fragment.app.FragmentFactory");
            if (clsZ == null) {
                return;
            }
            Field fieldZ2 = z(clsZ, "sClassMap");
            if (fieldZ2 != null) {
                ((SimpleArrayMap) fieldZ2.get(null)).put(cls.getName(), cls);
                return;
            }
            Field fieldZ3 = z(clsZ, "sClassCacheMap");
            if (fieldZ3 != null) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) fieldZ3.get(null);
                SimpleArrayMap simpleArrayMap2 = new SimpleArrayMap();
                simpleArrayMap2.put(cls.getName(), cls);
                simpleArrayMap.put(cls.getClassLoader(), simpleArrayMap2);
            }
        } catch (Exception e) {
            m.z(e);
        }
    }

    private static Field z(Class cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (declaredField != null) {
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    private static Class z(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
