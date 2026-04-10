package com.bytedance.pangle.util;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static <T> boolean z(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean z(T[] tArr, T t) {
        return g(tArr, t) != -1;
    }

    public static <T> int g(T[] tArr, T t) {
        if (tArr == null) {
            return -1;
        }
        for (int i = 0; i < tArr.length; i++) {
            T t2 = tArr[i];
            if (t2 == t || (t2 != null && t2.equals(t))) {
                return i;
            }
        }
        return -1;
    }

    public static <T> boolean z(T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t : tArr2) {
            if (!z(tArr, t)) {
                return false;
            }
        }
        return true;
    }
}
