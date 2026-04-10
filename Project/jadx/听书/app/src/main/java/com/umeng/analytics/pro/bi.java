package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldMetaData.java */
/* JADX INFO: loaded from: classes4.dex */
public class bi implements Serializable {
    private static Map<Class<? extends aw>, Map<? extends bd, bi>> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2191a;
    public final byte b;
    public final bj c;

    public bi(String str, byte b, bj bjVar) {
        this.f2191a = str;
        this.b = b;
        this.c = bjVar;
    }

    public static void a(Class<? extends aw> cls, Map<? extends bd, bi> map) {
        d.put(cls, map);
    }

    public static Map<? extends bd, bi> a(Class<? extends aw> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (InstantiationException e2) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return d.get(cls);
    }
}
