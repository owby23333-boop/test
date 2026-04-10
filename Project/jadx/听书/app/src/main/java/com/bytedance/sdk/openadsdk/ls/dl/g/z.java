package com.bytedance.sdk.openadsdk.ls.dl.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements Function<SparseArray<Object>, Object> {
    private PluginValueSet z;

    public abstract String g();

    public abstract int z();

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
        com.bykv.z.z.z.z.z zVarZ = com.bykv.z.z.z.z.z.z();
        zVarZ.z(263001, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<Object>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.z.1
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public Integer get() {
                return Integer.valueOf(z.this.z());
            }
        }));
        zVarZ.z(263002, com.bytedance.sdk.openadsdk.ls.dl.a.z((Supplier) new Supplier<String>() { // from class: com.bytedance.sdk.openadsdk.ls.dl.g.z.2
            @Override // java.util.function.Supplier
            /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
            public String get() {
                return z.this.g();
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
            return null;
        }
        return dl().sparseArray();
    }
}
