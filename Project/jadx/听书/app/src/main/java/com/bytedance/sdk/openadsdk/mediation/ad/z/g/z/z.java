package com.bytedance.sdk.openadsdk.mediation.ad.z.g.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 268013);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268014);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 268015);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
