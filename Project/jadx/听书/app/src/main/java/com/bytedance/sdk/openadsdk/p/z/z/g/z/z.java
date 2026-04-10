package com.bytedance.sdk.openadsdk.p.z.z.g.z;

import android.os.Bundle;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract void z(Bundle bundle);

    private PluginValueSet z() {
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
        if (iIntValue != -99999986) {
            if (iIntValue == 123101) {
                z((Bundle) pluginValueSetG.objectValue(0, Bundle.class));
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet pluginValueSetZ = z();
        this.z = pluginValueSetZ;
        return pluginValueSetZ.sparseArray();
    }
}
