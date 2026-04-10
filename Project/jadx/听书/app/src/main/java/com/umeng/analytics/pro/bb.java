package com.umeng.analytics.pro;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: TEnumHelper.java */
/* JADX INFO: loaded from: classes4.dex */
public class bb {
    public static ba a(Class<? extends ba> cls, int i) {
        try {
            return (ba) cls.getMethod("findByValue", Integer.TYPE).invoke(null, Integer.valueOf(i));
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }
}
