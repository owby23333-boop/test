package com.bytedance.sdk.openadsdk.mediation.ad.z.g.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract int a();

    public abstract int dl();

    public abstract int e();

    public abstract int fo();

    public abstract int g();

    public abstract int gc();

    public abstract int gz();

    public abstract int i();

    public abstract int kb();

    public abstract int m();

    public abstract int uy();

    public abstract Map<String, Integer> v();

    public abstract int wp();

    public abstract int z();

    private PluginValueSet pf() {
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
            switch (iIntValue) {
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet pluginValueSetPf = pf();
        this.z = pluginValueSetPf;
        return pluginValueSetPf.sparseArray();
    }
}
