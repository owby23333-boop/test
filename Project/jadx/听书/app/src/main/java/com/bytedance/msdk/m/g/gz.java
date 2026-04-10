package com.bytedance.msdk.m.g;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class gz extends com.bytedance.sdk.openadsdk.core.ti.a {
    private com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl z;

    public gz(com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar) {
        this.z = dlVar;
    }

    public PluginValueSet z() {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar = this.z;
        zVarZ.z(8468, dlVar != null ? dlVar.z() : new HashMap<>());
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar2 = this.z;
        zVarZ.z(8469, dlVar2 != null ? dlVar2.gc() : 0);
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar3 = this.z;
        zVarZ.z(8470, dlVar3 != null ? dlVar3.dl() : "");
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar4 = this.z;
        zVarZ.z(8471, dlVar4 != null ? dlVar4.a() : "");
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar5 = this.z;
        zVarZ.z(8472, dlVar5 != null ? dlVar5.g() : "");
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar6 = this.z;
        zVarZ.z(8473, dlVar6 != null ? dlVar6.m() : "");
        com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar7 = this.z;
        zVarZ.z(8474, dlVar7 != null ? dlVar7.e() : "");
        return zVarZ.g();
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == -99999986) {
            return (T) z().sparseArray();
        }
        return null;
    }
}
