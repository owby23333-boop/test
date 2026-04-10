package com.bytedance.sdk.openadsdk.core.ti;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.LongSupplier;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z extends a implements LongSupplier {
    public abstract void g();

    @Override // java.util.function.LongSupplier
    public long getAsLong() {
        return -99999981L;
    }

    public abstract void z();

    @Override // com.bytedance.sdk.openadsdk.core.ti.a
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 0) {
            z();
            return null;
        }
        if (i != 1) {
            return null;
        }
        g();
        return null;
    }
}
