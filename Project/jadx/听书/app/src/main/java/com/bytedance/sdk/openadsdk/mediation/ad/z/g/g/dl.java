package com.bytedance.sdk.openadsdk.mediation.ad.z.g.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract void z();

    public abstract void z(com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.z zVar);

    public PluginValueSet g() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetDl = dl();
        this.z = pluginValueSetDl;
        return pluginValueSetDl;
    }

    private PluginValueSet dl() {
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
        switch (iIntValue) {
            case -99999986:
                return g().sparseArray();
            case 270032:
                z();
                return null;
            case 270033:
                z(new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                return null;
            default:
                return null;
        }
    }
}
