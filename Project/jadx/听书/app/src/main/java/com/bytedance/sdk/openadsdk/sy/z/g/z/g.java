package com.bytedance.sdk.openadsdk.sy.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(int i, com.bytedance.sdk.openadsdk.p.z.z.g.z.z zVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, zVar);
        sparseArray.put(-99999987, 122101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
