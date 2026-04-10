package com.bytedance.sdk.openadsdk.a.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(com.bytedance.sdk.openadsdk.ls.dl.g.g gVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, gVar);
        sparseArray.put(-99999987, 121201);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 112103);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
