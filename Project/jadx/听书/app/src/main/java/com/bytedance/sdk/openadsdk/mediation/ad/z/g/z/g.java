package com.bytedance.sdk.openadsdk.mediation.ad.z.g.z;

import android.util.SparseArray;
import android.view.View;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public View z(com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z zVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, zVar);
        sparseArray.put(-99999987, 266013);
        sparseArray.put(-99999985, View.class);
        return (View) this.z.apply(sparseArray);
    }
}
