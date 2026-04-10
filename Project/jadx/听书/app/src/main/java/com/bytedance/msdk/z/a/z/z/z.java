package com.bytedance.msdk.z.a.z.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.ls.dl;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z extends com.bytedance.msdk.api.a.z.e.z {
    public z(Function<SparseArray<Object>, Object> function) {
        PluginValueSet pluginValueSetG;
        if (function == null || (pluginValueSetG = dl.g(function)) == null) {
            return;
        }
        a(pluginValueSetG.stringValue(8505));
        gc(pluginValueSetG.stringValue(8506));
        z(pluginValueSetG.longValue(8507));
        m(pluginValueSetG.stringValue(8508));
        z((Map<String, String>) pluginValueSetG.objectValue(8509, Map.class));
        e(pluginValueSetG.stringValue(8510));
        gz(pluginValueSetG.stringValue(8511));
        g((Map<String, Object>) pluginValueSetG.objectValue(8512, Map.class));
        dl(pluginValueSetG.stringValue(8551));
    }
}
