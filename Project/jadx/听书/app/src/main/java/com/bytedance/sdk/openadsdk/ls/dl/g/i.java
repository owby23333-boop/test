package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends gz {
    private SparseArray<Object> z;

    public abstract String e();

    public abstract String fo();

    public abstract a fv();

    public abstract void g(Activity activity);

    public abstract void g(Dialog dialog, Integer[] numArr);

    public abstract wp gc();

    public abstract String gz();

    public abstract String i();

    public abstract void io();

    public abstract Map<String, Object> iq();

    public abstract dl js();

    public abstract int kb();

    public abstract int ls();

    public abstract Bitmap m();

    public abstract int p();

    public abstract List<wp> pf();

    public abstract View q();

    public abstract gc tb();

    public abstract com.bytedance.sdk.openadsdk.mediation.manager.z.g.z.gc uf();

    public abstract int uy();

    public abstract wp v();

    public abstract int wp();

    public abstract e z(Activity activity);

    public abstract e z(Dialog dialog, Integer[] numArr);

    public abstract void z(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar, com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a aVar);

    public abstract void z(Activity activity, com.bytedance.sdk.openadsdk.js.z.g.z.z zVar);

    public abstract void z(ViewGroup viewGroup, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar);

    public abstract void z(ViewGroup viewGroup, List<View> list, List<View> list2, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar);

    public abstract void z(ViewGroup viewGroup, List<View> list, List<View> list2, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar);

    public abstract void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar);

    public abstract void z(ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, List<View> list4, View view, com.bytedance.sdk.openadsdk.io.z.g.z.z zVar);

    public abstract void z(com.bytedance.sdk.openadsdk.io.z.g.z.dl dlVar);

    public abstract void z(com.bytedance.sdk.openadsdk.io.z.g.z.g gVar);

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.z.dl dlVar);

    public abstract void z(String str);

    public abstract void zw();

    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.z;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> sparseArrayZ = z();
        this.z = sparseArrayZ;
        return sparseArrayZ;
    }

    private SparseArray<Object> z() {
        com.bytedance.sdk.openadsdk.ls.a aVarZ = com.bytedance.sdk.openadsdk.ls.a.z();
        aVarZ.z(140001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<wp>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public wp get() {
                return i.this.gc();
            }
        }));
        aVarZ.z(140002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.11
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Bitmap get() {
                return i.this.m();
            }
        }));
        aVarZ.z(140003, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.12
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return i.this.e();
            }
        }));
        aVarZ.z(140004, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.13
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return i.this.gz();
            }
        }));
        aVarZ.z(140018, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.14
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return i.this.fo();
            }
        }));
        aVarZ.z(140005, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.15
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(i.this.uy());
            }
        }));
        aVarZ.z(140006, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.16
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(i.this.kb());
            }
        }));
        aVarZ.z(140007, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.17
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(i.this.wp());
            }
        }));
        aVarZ.z(140008, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.18
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return i.this.i();
            }
        }));
        aVarZ.z(140009, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<wp>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public wp get() {
                return i.this.v();
            }
        }));
        aVarZ.z(140010, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<List<wp>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.3
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public List<wp> get() {
                return i.this.pf();
            }
        }));
        aVarZ.z(140011, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.4
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(i.this.ls());
            }
        }));
        aVarZ.z(140012, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Integer>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.5
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(i.this.p());
            }
        }));
        aVarZ.z(140013, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<a>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.6
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public a get() {
                return i.this.fv();
            }
        }));
        aVarZ.z(140014, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<dl>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.7
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public dl get() {
                return i.this.js();
            }
        }));
        aVarZ.z(140015, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<gc>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.8
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public gc get() {
                return i.this.tb();
            }
        }));
        aVarZ.z(140016, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<View>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.9
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public View get() {
                return i.this.q();
            }
        }));
        aVarZ.z(140017, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Map<String, Object>>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.i.10
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Map<String, Object> get() {
                return i.this.iq();
            }
        }));
        return aVarZ.g();
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
                case 140101:
                    return z((Activity) pluginValueSetG.objectValue(0, Activity.class));
                case 140102:
                    Dialog dialog = (Dialog) pluginValueSetG.objectValue(0, Dialog.class);
                    Integer[] numArr = (Integer[]) pluginValueSetG.arrayValue(1, Integer.class);
                    if (numArr == null) {
                        numArr = new Integer[0];
                    }
                    return z(dialog, numArr);
                case 140103:
                    z((ViewGroup) pluginValueSetG.objectValue(0, ViewGroup.class), (View) pluginValueSetG.objectValue(1, View.class), new com.bytedance.sdk.openadsdk.io.z.g.z.z((Function) pluginValueSetG.objectValue(2, Function.class)));
                    return null;
                case 140104:
                    z((ViewGroup) pluginValueSetG.objectValue(0, ViewGroup.class), (List) pluginValueSetG.objectValue(1, List.class), (List) pluginValueSetG.objectValue(2, List.class), new com.bytedance.sdk.openadsdk.io.z.g.z.z((Function) pluginValueSetG.objectValue(3, Function.class)));
                    return null;
                case 140105:
                    z((ViewGroup) pluginValueSetG.objectValue(0, ViewGroup.class), (List) pluginValueSetG.objectValue(1, List.class), (List) pluginValueSetG.objectValue(2, List.class), (View) pluginValueSetG.objectValue(3, View.class), new com.bytedance.sdk.openadsdk.io.z.g.z.z((Function) pluginValueSetG.objectValue(4, Function.class)));
                    return null;
                case 140106:
                    z((ViewGroup) pluginValueSetG.objectValue(0, ViewGroup.class), (List) pluginValueSetG.objectValue(1, List.class), (List) pluginValueSetG.objectValue(2, List.class), (List) pluginValueSetG.objectValue(3, List.class), (View) pluginValueSetG.objectValue(4, View.class), new com.bytedance.sdk.openadsdk.io.z.g.z.z((Function) pluginValueSetG.objectValue(5, Function.class)));
                    return null;
                case 140107:
                    z((ViewGroup) pluginValueSetG.objectValue(0, ViewGroup.class), (List<View>) pluginValueSetG.objectValue(1, List.class), (List<View>) pluginValueSetG.objectValue(2, List.class), (List<View>) pluginValueSetG.objectValue(3, List.class), (List<View>) pluginValueSetG.objectValue(4, List.class), (View) pluginValueSetG.objectValue(5, View.class), new com.bytedance.sdk.openadsdk.io.z.g.z.z((Function) pluginValueSetG.objectValue(6, Function.class)));
                    return null;
                case 140108:
                    z(new com.bytedance.sdk.openadsdk.ls.dl.z.dl((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 140109:
                    g((Activity) pluginValueSetG.objectValue(0, Activity.class));
                    return null;
                case 140110:
                    zw();
                    return null;
                case 140111:
                    z(new com.bytedance.sdk.openadsdk.io.z.g.z.dl((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 140112:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class), new com.bytedance.sdk.openadsdk.js.z.g.z.z((Function) pluginValueSetG.objectValue(1, Function.class)));
                    return null;
                case 140113:
                    Dialog dialog2 = (Dialog) pluginValueSetG.objectValue(0, Dialog.class);
                    Integer[] numArr2 = (Integer[]) pluginValueSetG.arrayValue(1, Integer.class);
                    if (numArr2 == null) {
                        numArr2 = new Integer[0];
                    }
                    g(dialog2, numArr2);
                    return null;
                case 140114:
                    io();
                    return null;
                case 140115:
                    pluginValueSetG.objectValue(0, Activity.class);
                    return null;
                case 140116:
                    return uf();
                case 140117:
                    z((Activity) pluginValueSetG.objectValue(0, Activity.class), (ViewGroup) pluginValueSetG.objectValue(1, ViewGroup.class), (List<View>) pluginValueSetG.objectValue(2, List.class), (List<View>) pluginValueSetG.objectValue(3, List.class), (List<View>) pluginValueSetG.objectValue(4, List.class), new com.bytedance.sdk.openadsdk.io.z.g.z.z((Function) pluginValueSetG.objectValue(5, Function.class)), new com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.a((Function) pluginValueSetG.objectValue(6, Function.class)));
                    return null;
                case 140118:
                    z((String) pluginValueSetG.objectValue(0, String.class));
                    return null;
                case 140119:
                    z(new com.bytedance.sdk.openadsdk.io.z.g.z.g((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                default:
                    return super.apply(sparseArray);
            }
        }
        return u_();
    }
}
