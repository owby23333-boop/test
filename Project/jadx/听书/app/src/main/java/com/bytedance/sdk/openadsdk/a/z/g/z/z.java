package com.bytedance.sdk.openadsdk.a.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, gVar);
        sparseArray.put(-99999987, 111101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, gVar);
        sparseArray.put(-99999987, 111102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, gVar);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 111103);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
