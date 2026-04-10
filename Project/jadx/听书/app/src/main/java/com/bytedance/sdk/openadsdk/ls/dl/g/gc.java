package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gc implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract void g();

    public abstract void z();

    public PluginValueSet dl() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet;
        }
        PluginValueSet pluginValueSetA = a();
        this.z = pluginValueSetA;
        return pluginValueSetA;
    }

    private PluginValueSet a() {
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
                return dl().sparseArray();
            case 222101:
                z();
                return null;
            case 222102:
                g();
                return null;
            default:
                return null;
        }
    }
}
