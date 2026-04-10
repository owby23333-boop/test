package com.bytedance.sdk.openadsdk.mediation.ad.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private final Function<SparseArray<Object>, Object> z;

    public m(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 270012);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
