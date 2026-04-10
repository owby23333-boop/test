package com.bytedance.sdk.openadsdk.io.z.g.z;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private final Function<SparseArray<Object>, Object> z;

    public dl(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(View view, float f, float f2, boolean z) {
        SparseArray<Object> sparseArray = new SparseArray<>(6);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        sparseArray.put(3, Boolean.valueOf(z));
        sparseArray.put(-99999987, 142101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
