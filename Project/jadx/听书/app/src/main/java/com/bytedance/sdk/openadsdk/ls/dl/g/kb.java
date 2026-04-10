package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class kb extends gz {
    private PluginValueSet z;

    public abstract long a();

    public abstract int dl();

    public abstract Map<String, Object> g();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.a gc();

    public abstract int z();

    public abstract void z(Activity activity);

    public abstract void z(Activity activity, Object obj, String str);

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar);

    public abstract void z(com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar);

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
        zVarZ.z(130001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.kb.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(kb.this.z());
            }
        }));
        zVarZ.z(130002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.kb.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return kb.this.g();
            }
        }));
        zVarZ.z(130003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.kb.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(kb.this.dl());
            }
        }));
        zVarZ.z(130004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Long>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.kb.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Long get() {
                return Long.valueOf(kb.this.a());
            }
        }));
        return zVarZ.g();
    }

    @Override // com.bytedance.sdk.openadsdk.ls.dl.g.gz, java.util.function.Function
    /* JADX INFO: renamed from: z */
    public Object apply(SparseArray<Object> sparseArray) {
        com.bytedance.sdk.openadsdk.zw.z.g.z.z zVar;
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        int iIntValue = pluginValueSetG.intValue(-99999987);
        if (iIntValue == -99999986) {
            return gz().sparseArray();
        }
        if (iIntValue != 130106) {
            switch (iIntValue) {
                case 130101:
                    Function function = (Function) pluginValueSetG.objectValue(0, Function.class);
                    if (pluginValueSetG.intValue(1) == 1) {
                        zVar = new com.bytedance.sdk.openadsdk.mediation.g.g.z.g(function);
                    } else {
                        zVar = new com.bytedance.sdk.openadsdk.zw.z.g.z.z(function);
                    }
                    z(zVar);
                    return null;
                case 130102:
                    z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 130103:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class));
                    return null;
                case 130104:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class), pluginValueSetG.objectValue(1, Object.class), (String) pluginValueSetG.objectValue(2, String.class));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return gc();
    }
}
