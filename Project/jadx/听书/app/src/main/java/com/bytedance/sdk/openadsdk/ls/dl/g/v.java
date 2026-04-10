package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends gz {
    private PluginValueSet z;

    public abstract void a();

    public abstract int dl();

    public abstract void e();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc fo();

    public abstract int g();

    public abstract void gc();

    public abstract Map<String, Object> gz();

    public abstract a m();

    public abstract View z();

    public abstract e z(Activity activity);

    public abstract void z(int i);

    public abstract void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar);

    public abstract void z(Dialog dialog, Integer[] numArr);

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar);

    public abstract void z(com.bytedance.sdk.openadsdk.uf.z.g.z.dl dlVar);

    public abstract void z(com.bytedance.sdk.openadsdk.uf.z.g.z.g gVar);

    public abstract void z(com.bytedance.sdk.openadsdk.uf.z.g.z.z zVar);

    public abstract void z(String str);

    public abstract void z(JSONObject jSONObject);

    public abstract void z(boolean z);

    public PluginValueSet wp() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetUy = uy();
        this.z = pluginValueSetUy;
        return pluginValueSetUy;
    }

    private PluginValueSet uy() {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        zVarZ.z(150001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.v.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public View get() {
                return v.this.z();
            }
        }));
        zVarZ.z(150002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.v.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(v.this.g());
            }
        }));
        zVarZ.z(150003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<a>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.v.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public a get() {
                return v.this.m();
            }
        }));
        zVarZ.z(150004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.v.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(v.this.dl());
            }
        }));
        zVarZ.z(150005, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.v.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return v.this.gz();
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
        if (iIntValue != -99999986) {
            switch (iIntValue) {
                case 150101:
                    z(new com.bytedance.sdk.openadsdk.uf.z.g.z.g((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 150102:
                    z(new com.bytedance.sdk.openadsdk.uf.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 150103:
                    z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 150104:
                    a();
                    return null;
                case 150105:
                    gc();
                    return null;
                case 150106:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.js.z.g.z.z((Function) pluginValueSetG.objectValue(1, Function.class)));
                    return null;
                case 150107:
                    Dialog dialog = (Dialog) pluginValueSetG.objectValue(0, Dialog.class);
                    Integer[] numArr = (Integer[]) pluginValueSetG.arrayValue(1, Integer.class);
                    if (numArr == null) {
                        numArr = new Integer[0];
                    }
                    z(dialog, numArr);
                    return null;
                case 150108:
                    return z((Activity) pluginValueSetG.objectValue(0, Activity.class));
                case 150109:
                    pluginValueSetG.objectValue(0, Activity.class);
                    return null;
                case 150110:
                    z(pluginValueSetG.intValue(0));
                    return null;
                case 150111:
                    z(new com.bytedance.sdk.openadsdk.uf.z.g.z.dl((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 150112:
                    z(pluginValueSetG.booleanValue(0));
                    return null;
                case 150113:
                    return fo();
                case 150114:
                    z((String) pluginValueSetG.objectValue(0, String.class));
                    return null;
                case 150115:
                    z((JSONObject) pluginValueSetG.objectValue(0, JSONObject.class));
                    return null;
                case 150116:
                    e();
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return wp().sparseArray();
    }
}
