package com.bytedance.sdk.openadsdk.mediation.ad.z.g.g;

import android.app.Activity;
import android.app.Dialog;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ls.dl.g.e;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract String a();

    public abstract String dl();

    public abstract List<String> e();

    public abstract int fo();

    public abstract e g(Activity activity);

    public abstract e g(Dialog dialog, Integer[] numArr);

    public abstract String g();

    public abstract String gc();

    public abstract String gz();

    public abstract com.bytedance.sdk.openadsdk.ls.dl.g.a i();

    public abstract a kb();

    public abstract double m();

    public abstract int uy();

    public abstract boolean wp();

    public abstract dl z(Activity activity);

    public abstract dl z(Activity activity, Map<String, Object> map);

    public abstract String z();

    public abstract void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar);

    public abstract void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar);

    public abstract void z(Dialog dialog, Integer[] numArr);

    public PluginValueSet v() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetPf = pf();
        this.z = pluginValueSetPf;
        return pluginValueSetPf;
    }

    private PluginValueSet pf() {
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        zVarZ.z(268101, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<a>() { // from class: com.bytedance.sdk.openadsdk.mediation.ad.z.g.g.z.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public a get() {
                return z.this.kb();
            }
        }));
        return zVarZ.g();
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
                case 268001:
                    return z();
                case 268002:
                    return g();
                case 268003:
                    return dl();
                case 268004:
                    return a();
                case 268005:
                    return gc();
                case 268006:
                    return Double.class.cast(Double.valueOf(m()));
                case 268007:
                    return e();
                case 268008:
                    return gz();
                case 268009:
                    return Integer.class.cast(Integer.valueOf(fo()));
                case 268010:
                    return Integer.class.cast(Integer.valueOf(uy()));
                case 268011:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class), (ViewGroup) pluginValueSetG.objectValue(1, ViewGroup.class), (List) pluginValueSetG.objectValue(2, List.class), (List) pluginValueSetG.objectValue(3, List.class), (List) pluginValueSetG.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a((Function) pluginValueSetG.objectValue(5, Function.class)));
                    return null;
                case 268012:
                    return Boolean.class.cast(Boolean.valueOf(wp()));
                default:
                    switch (iIntValue) {
                        case 268016:
                            z((Activity) pluginValueSetG.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.js.z.g.z.z((Function) pluginValueSetG.objectValue(1, Function.class)));
                            return null;
                        case 268017:
                            z((Dialog) pluginValueSetG.objectValue(0, Dialog.class), (Integer[]) pluginValueSetG.arrayValue(1, Integer.class));
                            return null;
                        case 268018:
                            return g((Activity) pluginValueSetG.objectValue(0, Activity.class));
                        case 268019:
                            return g((Dialog) pluginValueSetG.objectValue(0, Dialog.class), (Integer[]) pluginValueSetG.arrayValue(1, Integer.class));
                        case 268020:
                            return i();
                        default:
                            switch (iIntValue) {
                                case 268102:
                                    return z((Activity) pluginValueSetG.objectValue(0, Activity.class));
                                case 268103:
                                    return z((Activity) pluginValueSetG.objectValue(0, Activity.class), (Map<String, Object>) pluginValueSetG.objectValue(1, Map.class));
                                default:
                                    return null;
                            }
                    }
            }
        }
        return v().sparseArray();
    }
}
