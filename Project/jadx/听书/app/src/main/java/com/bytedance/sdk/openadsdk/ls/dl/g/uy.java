package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class uy extends i {
    private SparseArray<Object> z;

    public abstract int a();

    public abstract int dl();

    public abstract com.bytedance.sdk.openadsdk.iq.z.g.g.z g();

    public abstract double z();

    public abstract void z(com.bytedance.sdk.openadsdk.iq.z.g.z.g gVar);

    public abstract void z(com.bytedance.sdk.openadsdk.iq.z.g.z.z zVar);

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i
    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArraySy = sy();
        this.z = sparseArraySy;
        return sparseArraySy;
    }

    private SparseArray<Object> sy() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z(super.u_());
        aVarZ.z(160001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Double>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.uy.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Double get() {
                return Double.valueOf(uy.this.z());
            }
        }));
        aVarZ.z(160002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<com.bytedance.sdk.openadsdk.iq.z.g.g.z>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.uy.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public com.bytedance.sdk.openadsdk.iq.z.g.g.z get() {
                return uy.this.g();
            }
        }));
        aVarZ.z(160003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.uy.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(uy.this.dl());
            }
        }));
        aVarZ.z(160004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.uy.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(uy.this.a());
            }
        }));
        return aVarZ.g();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.i, com.bytedance.sdk.openadsdk.ls.dl.g.gz, java.util.function.Function
    /* JADX INFO: renamed from: z */
    public Object apply(SparseArray<Object> sparseArray) {
        com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        switch (iIntValue) {
            case -99999986:
                return u_();
            case 140111:
                Function function = (Function) pluginValueSetG.objectValue(0, Function.class);
                if (pluginValueSetG.intValue(1) == 1) {
                    dlVar = new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.gc(function);
                } else {
                    dlVar = new com.bytedance.sdk.openadsdk.io.z.g.z.dl(function);
                }
                z(dlVar);
                return null;
            case 160101:
                z(new com.bytedance.sdk.openadsdk.iq.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                return null;
            case 160102:
                z(new com.bytedance.sdk.openadsdk.iq.z.g.z.g((Function) pluginValueSetG.objectValue(0, Function.class)));
                return null;
            default:
                return super.apply(sparseArray);
        }
    }
}
