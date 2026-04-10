package com.bytedance.sdk.openadsdk.tb.z.g.z;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.ls.dl.g.kb;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final Function<SparseArray<Object>, Object> z;

    public a(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public void z(int i, String str) {
        SparseArray<Object> sparseArray = new SparseArray<>(4);
        sparseArray.put(0, Integer.valueOf(i));
        sparseArray.put(1, str);
        sparseArray.put(-99999987, 132101);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z(kb kbVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, kbVar);
        sparseArray.put(-99999987, 132102);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 132104);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }

    public void g(kb kbVar) {
        SparseArray<Object> sparseArray = new SparseArray<>(3);
        sparseArray.put(0, kbVar);
        sparseArray.put(-99999987, 132103);
        sparseArray.put(-99999985, Void.class);
        this.z.apply(sparseArray);
    }
}
