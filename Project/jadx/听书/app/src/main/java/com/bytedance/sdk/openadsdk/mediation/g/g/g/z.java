package com.bytedance.sdk.openadsdk.mediation.g.g.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract void z(String str, com.bytedance.sdk.openadsdk.tb.z.g.z.g gVar);

    public PluginValueSet z() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetG = g();
        this.z = pluginValueSetG;
        return pluginValueSetG;
    }

    private PluginValueSet g() {
        return com.bykv.z.z.z.z.z.z().g();
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
        if (iIntValue == -99999986) {
            return z().sparseArray();
        }
        if (iIntValue == 270031) {
            z((String) pluginValueSetG.objectValue(0, String.class), new com.bytedance.sdk.openadsdk.tb.z.g.z.g((Function) pluginValueSetG.objectValue(1, Function.class)));
        }
        return null;
    }
}
