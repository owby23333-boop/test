package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends gz {
    private PluginValueSet z;

    public abstract int a();

    public abstract View dl();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.e e();

    public abstract View g();

    public abstract Map<String, Object> gc();

    public abstract void m();

    public abstract void z(ViewGroup viewGroup);

    public abstract void z(ViewGroup viewGroup, Activity activity);

    public abstract void z(com.bytedance.sdk.openadsdk.a.z.g.z.g gVar);

    public abstract void z(com.bytedance.sdk.openadsdk.a.z.g.z.z zVar);

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar);

    public PluginValueSet z() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetGz = gz();
        this.z = pluginValueSetGz;
        return pluginValueSetGz;
    }

    private PluginValueSet gz() {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        zVarZ.z(110001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.g.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public View get() {
                return g.this.g();
            }
        }));
        zVarZ.z(110003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.g.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public View get() {
                return g.this.dl();
            }
        }));
        zVarZ.z(110004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.g.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(g.this.a());
            }
        }));
        zVarZ.z(110005, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.g.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return g.this.gc();
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
        switch (iIntValue) {
            case -99999986:
                return z().sparseArray();
            case 110101:
                m();
                return null;
            case 110102:
                z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl((Function) pluginValueSetG.objectValue(0, Function.class)));
                return null;
            case 110103:
                z(new com.bytedance.sdk.openadsdk.a.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                return null;
            case 110106:
                z(new com.bytedance.sdk.openadsdk.a.z.g.z.g((Function) pluginValueSetG.objectValue(0, Function.class)));
                return null;
            case 110108:
                z((ViewGroup) pluginValueSetG.objectValue(0, ViewGroup.class));
                return null;
            case 110109:
                z((ViewGroup) pluginValueSetG.objectValue(0, ViewGroup.class), (Activity) pluginValueSetG.objectValue(1, Activity.class));
                return null;
            case 110110:
                return e();
            default:
                return super.apply(sparseArray);
        }
    }
}
