package com.bytedance.sdk.openadsdk.mediation.manager.z.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e extends dl {
    private SparseArray<Object> z;

    public abstract void destroy();

    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl
    public SparseArray<Object> values() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayZ = z();
        this.z = sparseArrayZ;
        return sparseArrayZ;
    }

    private SparseArray<Object> z() {
        return com.bytedance.sdk.openadsdk.ls.a.z(super.values()).g();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.dl, java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return values();
        }
        if (iIntValue == 270007) {
            destroy();
            return null;
        }
        return super.apply(sparseArray);
    }
}
