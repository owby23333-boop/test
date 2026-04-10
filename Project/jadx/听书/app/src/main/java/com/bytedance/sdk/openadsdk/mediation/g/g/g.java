package com.bytedance.sdk.openadsdk.mediation.g.g;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Function<SparseArray<Object>, Object> z;

    public g(Function<SparseArray<Object>, Object> function) {
        this.z = function == null ? com.bykv.z.z.z.z.z.g : function;
    }

    public boolean z() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266001);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public boolean g() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266002);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public boolean dl() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266003);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public float a() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266004);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.z.apply(sparseArray)).floatValue();
    }

    public boolean gc() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266005);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public Map<String, Object> m() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266006);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.z.apply(sparseArray);
    }

    public boolean e() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266007);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public String gz() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266008);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    public boolean fo() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266009);
        sparseArray.put(-99999985, Boolean.TYPE);
        return ((Boolean) this.z.apply(sparseArray)).booleanValue();
    }

    public com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.g uy() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266101);
        sparseArray.put(-99999985, Object.class);
        Object objApply = this.z.apply(sparseArray);
        if (objApply instanceof Function) {
            return new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.g((Function) objApply);
        }
        return null;
    }

    public float kb() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266010);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.z.apply(sparseArray)).floatValue();
    }

    public float wp() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266011);
        sparseArray.put(-99999985, Float.TYPE);
        return ((Float) this.z.apply(sparseArray)).floatValue();
    }

    public com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.dl i() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266102);
        sparseArray.put(-99999985, Object.class);
        return new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.dl(com.bytedance.sdk.openadsdk.l.dl.z(this.z.apply(sparseArray)));
    }

    public String v() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266103);
        sparseArray.put(-99999985, String.class);
        return (String) this.z.apply(sparseArray);
    }

    public int pf() {
        SparseArray<Object> sparseArray = new SparseArray<>(2);
        sparseArray.put(-99999987, 266104);
        sparseArray.put(-99999985, Integer.TYPE);
        return ((Integer) this.z.apply(sparseArray)).intValue();
    }
}
