package com.bytedance.sdk.openadsdk.iq.z.g.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract void a();

    public abstract void dl();

    public abstract void dl(long j);

    public abstract void g();

    public abstract void g(long j);

    public abstract String z();

    public abstract void z(int i, int i2);

    public abstract void z(long j);

    public abstract void z(long j, int i, int i2);

    public PluginValueSet gc() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetM = m();
        this.z = pluginValueSetM;
        return pluginValueSetM;
    }

    private PluginValueSet m() {
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
                case 162101:
                    return z();
                case 162102:
                    g();
                    return null;
                case 162103:
                    z(pluginValueSetG.longValue(0));
                    return null;
                case 162104:
                    g(pluginValueSetG.longValue(0));
                    return null;
                case 162105:
                    dl();
                    return null;
                case 162106:
                    dl(pluginValueSetG.longValue(0));
                    return null;
                case 162107:
                    a();
                    return null;
                case 162108:
                    z(pluginValueSetG.intValue(0), pluginValueSetG.intValue(1));
                    return null;
                case 162109:
                    z(pluginValueSetG.longValue(0), pluginValueSetG.intValue(1), pluginValueSetG.intValue(2));
                    return null;
                default:
                    return null;
            }
        }
        return gc().sparseArray();
    }
}
