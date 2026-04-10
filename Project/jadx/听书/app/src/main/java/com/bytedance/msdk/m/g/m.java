package com.bytedance.msdk.m.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class m extends com.bytedance.sdk.openadsdk.core.ti.a implements Supplier<SparseArray<Object>> {
    private com.bytedance.sdk.openadsdk.ls.dl.dl.dl z;

    public m(com.bytedance.sdk.openadsdk.ls.dl.dl.dl dlVar) {
        this.z = dlVar;
    }

    public PluginValueSet z() {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        com.bytedance.sdk.openadsdk.ls.dl.dl.dl dlVar = this.z;
        zVarZ.z(8481, dlVar != null ? dlVar.z() : 0.0d);
        com.bytedance.sdk.openadsdk.ls.dl.dl.dl dlVar2 = this.z;
        zVarZ.z(8482, dlVar2 != null ? dlVar2.g() : 0.0d);
        return zVarZ.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) z().sparseArray();
        }
        return null;
    }

    @Override // java.util.function.Supplier
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet pluginValueSetZ = z();
        if (pluginValueSetZ != null) {
            return pluginValueSetZ.sparseArray();
        }
        return null;
    }
}
