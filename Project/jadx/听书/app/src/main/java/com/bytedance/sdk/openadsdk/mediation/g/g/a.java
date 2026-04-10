package com.bytedance.sdk.openadsdk.mediation.g.g;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract int z(com.bytedance.sdk.openadsdk.mediation.g.g.z.a aVar);

    public abstract Object z(int i, PluginValueSet pluginValueSet);

    public abstract Map<String, Object> z();

    public abstract void z(int i);

    public abstract void z(Activity activity, List<gc> list, int i, int i2, Function<SparseArray<Object>, Object> function);

    public abstract void z(Context context);

    public abstract void z(Context context, z zVar, com.bytedance.sdk.openadsdk.mediation.g.g.z.dl dlVar, Function<SparseArray<Object>, Object> function);

    public abstract void z(Context context, z zVar, com.bytedance.sdk.openadsdk.mediation.g.g.z.z zVar2, Function<SparseArray<Object>, Object> function);

    public abstract void z(Context context, int[] iArr);

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.dl.a aVar);

    public abstract void z(com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl dlVar);

    public abstract void z(String str);

    public abstract void z(Map<String, Object> map);

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
            case 270024:
                return z();
            case 271043:
                return z(pluginValueSetG.intValue(0), com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSetG.objectValue(1, SparseArray.class)).g());
            case 271050:
                z((Map<String, Object>) pluginValueSetG.objectValue(0, Map.class));
                return null;
            default:
                switch (iIntValue) {
                    case 270013:
                        Activity activity = (Activity) pluginValueSetG.objectValue(0, Activity.class);
                        List arrayList = (List) pluginValueSetG.objectValue(1, List.class);
                        if (arrayList == null) {
                            arrayList = new ArrayList(0);
                        }
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            arrayList2.add(new gc((Function) it.next()));
                        }
                        z(activity, arrayList2, pluginValueSetG.intValue(2), pluginValueSetG.intValue(3), (Function) pluginValueSetG.objectValue(4, Function.class));
                        return null;
                    case 270014:
                        z(new com.bytedance.sdk.openadsdk.mediation.init.z.g.z.dl((SparseArray) pluginValueSetG.objectValue(0, SparseArray.class)));
                        return null;
                    case 270015:
                        z((String) pluginValueSetG.objectValue(0, String.class));
                        return null;
                    case 270016:
                        z(new com.bytedance.sdk.openadsdk.ls.dl.dl.a((SparseArray) pluginValueSetG.objectValue(0, SparseArray.class)));
                        return null;
                    case 270017:
                        z((Context) pluginValueSetG.objectValue(0, Context.class));
                        return null;
                    case 270018:
                        z((Context) pluginValueSetG.objectValue(0, Context.class), (int[]) pluginValueSetG.objectValue(1, int[].class));
                        return null;
                    case 270019:
                        z(pluginValueSetG.intValue(0));
                        return null;
                    case 270020:
                        return Integer.class.cast(Integer.valueOf(z(new com.bytedance.sdk.openadsdk.mediation.g.g.z.a((Function) pluginValueSetG.objectValue(0, Function.class)))));
                    case 270021:
                        Context context = (Context) pluginValueSetG.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> function = (Function) pluginValueSetG.objectValue(3, Function.class);
                        z(context, new z((SparseArray) pluginValueSetG.objectValue(1, SparseArray.class)), new com.bytedance.sdk.openadsdk.mediation.g.g.z.dl((Function) pluginValueSetG.objectValue(2, Function.class)), function);
                        return null;
                    case 270022:
                        Context context2 = (Context) pluginValueSetG.objectValue(0, Context.class);
                        Function<SparseArray<Object>, Object> function2 = (Function) pluginValueSetG.objectValue(3, Function.class);
                        z(context2, new z((SparseArray) pluginValueSetG.objectValue(1, SparseArray.class)), new com.bytedance.sdk.openadsdk.mediation.g.g.z.z((Function) pluginValueSetG.objectValue(2, Function.class)), function2);
                        return null;
                    default:
                        return null;
                }
        }
    }
}
