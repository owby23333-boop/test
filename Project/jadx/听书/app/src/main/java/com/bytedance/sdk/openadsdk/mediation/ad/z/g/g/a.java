package com.bytedance.sdk.openadsdk.mediation.ad.z.g.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract String a();

    public abstract long dl();

    public abstract String e();

    public abstract String fo();

    public abstract String g();

    public abstract Map<String, String> gc();

    public abstract String gz();

    public abstract String m();

    public abstract Map<String, Object> uy();

    public abstract String z();

    protected PluginValueSet kb() {
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
            if (iIntValue == 271047) {
                return gz();
            }
            if (iIntValue == 271051) {
                return fo();
            }
            switch (iIntValue) {
            }
            return null;
        }
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet.sparseArray();
        }
        PluginValueSet pluginValueSetKb = kb();
        this.z = pluginValueSetKb;
        return pluginValueSetKb.sparseArray();
    }
}
