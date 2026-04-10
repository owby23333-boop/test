package com.bytedance.msdk.m.g;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class dl {
    private final PluginValueSet z;

    public static dl z(PluginValueSet pluginValueSet) {
        return new dl(pluginValueSet);
    }

    private dl(PluginValueSet pluginValueSet) {
        this.z = pluginValueSet;
    }

    public Function<SparseArray<Object>, Object> z() {
        if (g()) {
            return (Function) this.z.objectValue(8301, Function.class);
        }
        return null;
    }

    private boolean g() {
        PluginValueSet pluginValueSet = this.z;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }
}
