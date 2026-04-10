package com.bytedance.sdk.openadsdk.core;

import android.util.SparseArray;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class io {
    private static final SparseArray<HashMap> z = new SparseArray<>();

    public static <T> void z(String str, T t, Class cls) {
        if (t == null) {
            return;
        }
        int iHashCode = cls.hashCode();
        SparseArray<HashMap> sparseArray = z;
        HashMap map = sparseArray.get(iHashCode);
        if (map == null) {
            map = new HashMap();
            sparseArray.put(iHashCode, map);
        }
        map.put(str, t);
    }

    public static <T> void z(String str) {
        int size = z.size();
        for (int i = 0; i < size; i++) {
            SparseArray<HashMap> sparseArray = z;
            HashMap map = sparseArray.get(sparseArray.keyAt(i));
            if (map != null) {
                map.remove(str);
            }
        }
    }

    public static <T> T z(String str, Class<T> cls) {
        HashMap map;
        if (cls == null || str == null || (map = z.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) map.get(str);
    }

    public static <T> T g(String str, Class<T> cls) {
        HashMap map;
        if (cls == null || str == null || (map = z.get(cls.hashCode())) == null) {
            return null;
        }
        return (T) map.remove(str);
    }
}
