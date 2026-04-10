package com.bytedance.sdk.openadsdk.core.kb.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.gk;
import com.ss.android.z.z.g.p;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g extends com.bytedance.sdk.openadsdk.core.ti.a implements p, LongSupplier {
    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (pluginValueSet == null) {
            return null;
        }
        if (i == 223100) {
            if (!com.bytedance.sdk.openadsdk.ls.dl.a.z(gk.dl)) {
                pluginValueSet = com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-99999979, SparseArray.class)).g();
            }
            z(com.bykv.z.z.z.z.z.z((SparseArray<Object>) pluginValueSet.objectValue(-999902, SparseArray.class)).g().booleanValue(223101));
        } else if (i == 223110) {
            z();
        }
        return null;
    }
}
