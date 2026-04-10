package com.bytedance.sdk.openadsdk.core.ti;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements Function<SparseArray<Object>, Object> {
    public abstract <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls);

    @Override // java.util.function.Function
    public Object apply(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z(sparseArray).g();
        return applyFunction(pluginValueSetG.intValue(-99999987, 0), pluginValueSetG, (Class) pluginValueSetG.objectValue(-99999985, Class.class));
    }
}
