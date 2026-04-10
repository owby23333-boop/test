package com.bytedance.sdk.openadsdk.core.kb.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.gk;
import java.util.Map;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.bytedance.sdk.openadsdk.core.ti.a implements com.ss.android.z.z.g.gz, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet != null && i == 223901) {
            if (!com.bytedance.sdk.openadsdk.ls.dl.a.z(gk.dl)) {
                pluginValueSet = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).g();
            }
            if (pluginValueSet != null) {
                return (T) com.bytedance.sdk.openadsdk.ls.a.z().z(223902, z((Map) com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g().objectValue(223902, Map.class))).g();
            }
        }
        return null;
    }
}
