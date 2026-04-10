package com.bytedance.sdk.openadsdk.io.z.g.z;

import android.util.SparseArray;
import android.view.View;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private final Function<SparseArray<Object>, Object> z;

    public z(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(View view, i iVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, iVar);
        sparseArray.put(-99999987, 141101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g(View view, i iVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, view);
        sparseArray.put(1, iVar);
        sparseArray.put(-99999987, 141102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(i iVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, iVar);
        sparseArray.put(-99999987, 141103);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
