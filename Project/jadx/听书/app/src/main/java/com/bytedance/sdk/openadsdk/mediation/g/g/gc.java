package com.bytedance.sdk.openadsdk.mediation.g.g;

import android.util.SparseArray;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class gc {
    private Function<SparseArray<Object>, Object> z;

    public gc(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public int z() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271044);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }

    public z g() {
        Object objApply = this.z.apply(com.bytedance.sdk.openadsdk.ls.a.z().z(271045).z(SparseArray.class).g());
        if (objApply instanceof SparseArray) {
            return new z((SparseArray) objApply);
        }
        return null;
    }

    public List<String> dl() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271046);
        sparseArray.put(-99999985, List.class);
        return (List) this.z.apply(sparseArray);
    }
}
