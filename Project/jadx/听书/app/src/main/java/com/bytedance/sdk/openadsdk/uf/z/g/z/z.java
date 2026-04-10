package com.bytedance.sdk.openadsdk.uf.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends g {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 151105);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
