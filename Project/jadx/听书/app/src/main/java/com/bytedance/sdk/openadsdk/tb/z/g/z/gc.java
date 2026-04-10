package com.bytedance.sdk.openadsdk.tb.z.g.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ls.dl.g.i;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private final Function<SparseArray<Object>, Object> z;

    public gc(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 143101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(List<i> list) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, list);
        sparseArray.put(-99999987, 143102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
