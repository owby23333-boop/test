package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Function<SparseArray<Object>, Object> {
    private SparseArray<Object> z;

    public abstract List<m> z();

    public SparseArray<Object> g() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayDl = dl();
        this.z = sparseArrayDl;
        return sparseArrayDl;
    }

    private SparseArray<Object> dl() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(243001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<List<m>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.a.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public List<m> get() {
                return a.this.z();
            }
        }));
        return aVarZ.g();
    }

    @Override // java.util.function.Function
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        if (iIntValue != -99999986) {
            return null;
        }
        return g();
    }
}
