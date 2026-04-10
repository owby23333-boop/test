package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldMetaData.java */
/* JADX INFO: loaded from: classes3.dex */
public class bh implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Map<Class<? extends av>, Map<? extends bc, bh>> f19538d = new HashMap();
    public final String a;
    public final byte b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bi f19539c;

    public bh(String str, byte b, bi biVar) {
        this.a = str;
        this.b = b;
        this.f19539c = biVar;
    }

    public static void a(Class<? extends av> cls, Map<? extends bc, bh> map) {
        f19538d.put(cls, map);
    }

    public static Map<? extends bc, bh> a(Class<? extends av> cls) {
        if (!f19538d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            } catch (InstantiationException e3) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e3.getMessage());
            }
        }
        return f19538d.get(cls);
    }
}
