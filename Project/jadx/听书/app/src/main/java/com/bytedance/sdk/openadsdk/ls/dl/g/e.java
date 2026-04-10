package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements Function<SparseArray<Object>, Object> {
    public abstract boolean dl();

    public abstract void g();

    public abstract void z();

    public abstract void z(com.bytedance.sdk.openadsdk.js.z.g.z.z zVar);

    public abstract void z(String str);

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
                case 240101:
                    z();
                    return null;
                case 240102:
                    z(new com.bytedance.sdk.openadsdk.js.z.g.z.z((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                case 240103:
                    z((String) pluginValueSetG.objectValue(0, String.class));
                    return null;
                case 240104:
                    g();
                    return null;
                case 240105:
                    return Boolean.class.cast(Boolean.valueOf(dl()));
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
