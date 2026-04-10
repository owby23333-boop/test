package com.bytedance.sdk.openadsdk.mediation.g.g.z;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.openadsdk.zw.z.g.z.z {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 131106);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void m() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131107);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void e() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131108);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void gz() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 131109);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(Bundle bundle) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, bundle);
        sparseArray.put(-99999987, 131110);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
