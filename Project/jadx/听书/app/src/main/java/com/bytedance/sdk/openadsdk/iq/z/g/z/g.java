package com.bytedance.sdk.openadsdk.iq.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(-99999987, 163101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
