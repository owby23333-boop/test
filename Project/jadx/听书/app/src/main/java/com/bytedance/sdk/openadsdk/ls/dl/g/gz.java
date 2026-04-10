package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gz implements Function<SparseArray<Object>, Object> {
    public abstract void g(Double d);

    public abstract void z(com.bytedance.sdk.openadsdk.ls.dl.z.g gVar);

    public abstract void z(Double d);

    public abstract void z(Double d, String str, String str2);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.util.function.Function
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
                case 210101:
                    z(Double.valueOf(pluginValueSetG.doubleValue(0)));
                    return null;
                case 210102:
                    z(Double.valueOf(pluginValueSetG.doubleValue(0)), (String) pluginValueSetG.objectValue(1, String.class), (String) pluginValueSetG.objectValue(2, String.class));
                    return null;
                case 210103:
                    g(Double.valueOf(pluginValueSetG.doubleValue(0)));
                    return null;
                case 210104:
                    z(new com.bytedance.sdk.openadsdk.ls.dl.z.g((Function) pluginValueSetG.objectValue(0, Function.class)));
                    return null;
                default:
                    return null;
            }
        }
        return new SparseArray();
    }
}
