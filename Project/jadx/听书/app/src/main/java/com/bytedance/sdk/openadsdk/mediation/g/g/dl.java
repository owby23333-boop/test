package com.bytedance.sdk.openadsdk.mediation.g.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract void g();

    public abstract void z();

    public abstract void z(int i, String str);

    public PluginValueSet dl() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetA = a();
        this.z = pluginValueSetA;
        return pluginValueSetA;
    }

    private PluginValueSet a() {
        return com.bykv.z.z.z.z.z.z().g();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
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
            switch (iIntValue) {
                case 268013:
                    z(pluginValueSetG.intValue(0), (String) pluginValueSetG.objectValue(1, String.class));
                    return null;
                case 268014:
                    z();
                    return null;
                case 268015:
                    g();
                    return null;
                default:
                    return null;
            }
        }
        return dl().sparseArray();
    }
}
