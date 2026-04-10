package com.bytedance.msdk.m.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class e extends com.bytedance.sdk.openadsdk.core.ti.a implements Supplier<SparseArray<Object>> {
    private com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g z;

    public e(com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g gVar) {
        this.z = gVar;
    }

    public PluginValueSet dl() {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        zVarZ.z(8476, a());
        zVarZ.z(8477, gc());
        zVarZ.z(8478, m());
        zVarZ.z(8027, z());
        zVarZ.z(8028, g());
        return zVarZ.g();
    }

    public List<String> a() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g gVar = this.z;
        if (gVar != null) {
            return gVar.z();
        }
        return null;
    }

    public List<String> gc() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g gVar = this.z;
        if (gVar != null) {
            return gVar.g();
        }
        return null;
    }

    public boolean m() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g gVar = this.z;
        if (gVar != null) {
            return gVar.dl();
        }
        return true;
    }

    public boolean z() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g gVar = this.z;
        if (gVar != null) {
            return gVar.a();
        }
        return false;
    }

    public boolean g() {
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.g gVar = this.z;
        if (gVar != null) {
            return gVar.gc();
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) dl().sparseArray();
        }
        return null;
    }

    @Override // java.util.function.Supplier
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public SparseArray<Object> get() {
        PluginValueSet pluginValueSetDl = dl();
        if (pluginValueSetDl != null) {
            return pluginValueSetDl.sparseArray();
        }
        return null;
    }
}
