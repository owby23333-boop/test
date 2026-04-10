package com.amgcyo.cuttadon.utils.otherutils;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: SortListUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class q0 {
    public static List<?> a(List<?> list, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length - 1;
            while (length >= 0) {
                final String str = strArr[length];
                final String str2 = (strArr2 == null || strArr2.length <= length || strArr2[length] == null) ? "asc" : strArr2[length];
                Collections.sort(list, new Comparator() { // from class: com.amgcyo.cuttadon.utils.otherutils.c
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return q0.a(str, str2, obj, obj2);
                    }
                });
                length--;
            }
        }
        return list;
    }

    static /* synthetic */ int a(String str, String str2, Object obj, Object obj2) {
        int iCompareTo;
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            Class<?> type = declaredField.getType();
            if (type == Integer.TYPE) {
                iCompareTo = Integer.compare(declaredField.getInt(obj), declaredField.getInt(obj2));
            } else if (type == Double.TYPE) {
                iCompareTo = Double.compare(declaredField.getDouble(obj), declaredField.getDouble(obj2));
            } else if (type == Long.TYPE) {
                iCompareTo = Long.compare(declaredField.getLong(obj), declaredField.getLong(obj2));
            } else if (type == Float.TYPE) {
                iCompareTo = Float.compare(declaredField.getFloat(obj), declaredField.getFloat(obj2));
            } else if (type == Date.class) {
                iCompareTo = ((Date) Objects.requireNonNull(declaredField.get(obj))).compareTo((Date) declaredField.get(obj2));
            } else if (a(type, Comparable.class)) {
                iCompareTo = ((Comparable) Objects.requireNonNull(declaredField.get(obj))).compareTo(declaredField.get(obj2));
            } else {
                iCompareTo = String.valueOf(declaredField.get(obj)).compareTo(String.valueOf(declaredField.get(obj2)));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            iCompareTo = 0;
        }
        return (str2 == null || !str2.toLowerCase().equals("desc")) ? iCompareTo : -iCompareTo;
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        Class<?>[] interfaces = cls.getInterfaces();
        int length = interfaces.length;
        boolean zA = false;
        for (int i2 = 0; i2 < length; i2++) {
            Class<?> cls3 = interfaces[i2];
            zA = cls3 == cls2 ? true : a(cls3, cls2);
        }
        return (zA || cls.getSuperclass() == null) ? zA : a(cls.getSuperclass(), cls2);
    }
}
