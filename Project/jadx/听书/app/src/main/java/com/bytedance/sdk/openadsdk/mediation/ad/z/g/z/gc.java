package com.bytedance.sdk.openadsdk.mediation.ad.z.g.z;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends com.bytedance.sdk.openadsdk.io.z.g.z.dl {
    private final Function<SparseArray<Object>, Object> z;

    public gc(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(View view, String str, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(-99999987, 142102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 142103);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 142104);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
