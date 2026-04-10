package com.bytedance.sdk.openadsdk.uf.z.g.z;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(View view, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 151101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g(View view, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, Integer.valueOf(i));
        sparseArray.put(-99999987, 151102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(View view, String str, int i) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, view);
        sparseArray.put(1, str);
        sparseArray.put(2, Integer.valueOf(i));
        sparseArray.put(-99999987, 151103);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(View view, float f, float f2) {
        SparseArray<Object> sparseArray = new SparseArray<>(5);
        sparseArray.put(0, view);
        sparseArray.put(1, Float.valueOf(f));
        sparseArray.put(2, Float.valueOf(f2));
        sparseArray.put(-99999987, 151104);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
