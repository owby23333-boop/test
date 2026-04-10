package com.bytedance.sdk.openadsdk.mediation.g.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private final Function<SparseArray<Object>, Object> z;

    public dl(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(String str, com.bytedance.sdk.openadsdk.mediation.g.g.g.g gVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, str);
        sparseArray.put(1, gVar);
        sparseArray.put(-99999987, 270026);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 270027);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
