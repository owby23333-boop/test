package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class pf extends gz {
    private PluginValueSet z;

    public abstract long a();

    public abstract int dl();

    public abstract Map<String, Object> g();

    public abstract void g(com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar);

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.m gc();

    public abstract int z();

    public abstract void z(Activity activity);

    public abstract void z(Activity activity, Object obj, String str);

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar);

    public abstract void z(com.bytedance.sdk.openadsdk.sy.z.g.z.g gVar);

    public abstract void z(com.bytedance.sdk.openadsdk.sy.z.g.z.z zVar);

    public PluginValueSet gz() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetM = m();
        this.z = pluginValueSetM;
        return pluginValueSetM;
    }

    private PluginValueSet m() {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        zVarZ.z(120001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.pf.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(pf.this.z());
            }
        }));
        zVarZ.z(120002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.pf.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return pf.this.g();
            }
        }));
        zVarZ.z(120003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.pf.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(pf.this.dl());
            }
        }));
        zVarZ.z(120004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Long>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.pf.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(pf.this.a());
            }
        }));
        return zVarZ.g();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz, java.util.function.Function
    /* JADX INFO: renamed from: z */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        pluginValueSetG.objectValue(-99999985, Class.class);
        if (iIntValue == -99999986) {
            return gz().sparseArray();
        }
        if (iIntValue != 121109) {
            switch (iIntValue) {
                case 120101:
                    z(new com.bytedance.sdk.openadsdk.sy.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 120102:
                    g(new com.bytedance.sdk.openadsdk.sy.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 120103:
                    z(new com.bytedance.sdk.openadsdk.sy.z.g.z.g((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 120104:
                    z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 120105:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class));
                    return null;
                case 120106:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class), pluginValueSetG.objectValue(1, Object.class), (String) pluginValueSetG.objectValue(2, String.class));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return gc();
    }
}
