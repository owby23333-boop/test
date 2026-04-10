package com.bytedance.sdk.openadsdk.tb.z.g.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ls.dl.g.pf;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    private final Function<SparseArray<Object>, Object> z;

    public e(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 124101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(pf pfVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, pfVar);
        sparseArray.put(-99999987, 124102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(-99999987, 124104);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g(pf pfVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, pfVar);
        sparseArray.put(-99999987, 124103);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
