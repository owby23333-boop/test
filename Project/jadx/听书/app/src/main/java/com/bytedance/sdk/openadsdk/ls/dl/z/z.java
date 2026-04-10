package com.bytedance.sdk.openadsdk.ls.dl.z;

import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final Function<SparseArray<Object>, Object> z;

    public z(Object obj) {
        this.z = obj != null ? (Function) obj : com.bykv.z.z.z.z.z.g;
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 223101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
