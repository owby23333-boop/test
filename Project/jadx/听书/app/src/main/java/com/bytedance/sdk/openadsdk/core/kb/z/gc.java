package com.bytedance.sdk.openadsdk.core.kb.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.gk;
import com.ss.android.z.z.g.uf;
import java.util.function.Function;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class gc extends com.bytedance.sdk.openadsdk.core.ti.a implements uf, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void onItemClick();

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (!com.bytedance.sdk.openadsdk.ls.dl.a.z(gk.dl)) {
            pluginValueSet = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).g();
        }
        if (i == 223200 && pluginValueSet != null) {
            PluginValueSet pluginValueSetG = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g();
            onItemClick((Function<SparseArray<Object>, Object>) pluginValueSetG.objectValue(223201, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetG.objectValue(223202, Function.class), (Function<SparseArray<Object>, Object>) pluginValueSetG.objectValue(223203, Function.class));
        }
        return null;
    }

    private void onItemClick(Function<SparseArray<Object>, Object> function, Function<SparseArray<Object>, Object> function2, Function<SparseArray<Object>, Object> function3) {
        onItemClick();
    }

    @Override // com.ss.android.z.z.g.uf
    public void onItemClick(com.ss.android.z.z.dl.dl dlVar, com.ss.android.z.z.dl.g gVar, com.ss.android.z.z.dl.z zVar) {
        onItemClick();
    }
}
