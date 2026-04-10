package com.bytedance.sdk.openadsdk.ls.z.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class pf {
    public static Function<SparseArray<Object>, Object> z(Object obj) {
        if (obj instanceof Function) {
            return (Function) obj;
        }
        return com.bykv.z.z.z.z.dl.dl;
    }

    public static Integer[] z(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return null;
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }
}
