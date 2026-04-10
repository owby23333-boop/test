package com.bytedance.pangle.util;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    public static <T> boolean a(@Nullable T[] tArr) {
        return tArr == null || tArr.length == 0;
    }

    public static <T> boolean a(@Nullable T[] tArr, T[] tArr2) {
        if (tArr2 == null) {
            return true;
        }
        for (T t2 : tArr2) {
            if (!a(tArr, t2)) {
                return false;
            }
        }
        return true;
    }

    private static <T> boolean a(@Nullable T[] tArr, T t2) {
        int i2;
        if (tArr != null) {
            i2 = 0;
            while (i2 < tArr.length) {
                if (tArr[i2] == t2 || (tArr[i2] != null && tArr[i2].equals(t2))) {
                    break;
                }
                i2++;
            }
            i2 = -1;
        } else {
            i2 = -1;
        }
        return i2 != -1;
    }
}
