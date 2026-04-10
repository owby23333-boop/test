package com.bytedance.sdk.openadsdk.core.sy.g;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.core.sy.kb;
import com.bytedance.sdk.openadsdk.core.ti.a;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    public static void z() {
        try {
            com.bytedance.sdk.openadsdk.core.sy.z.z.z().gc();
            kb.z(new a() { // from class: com.bytedance.sdk.openadsdk.core.sy.g.z.1
                @Override // com.bytedance.sdk.openadsdk.core.ti.a
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    if (i != 0) {
                        return null;
                    }
                    com.bytedance.sdk.openadsdk.core.sy.a.z.gc();
                    return null;
                }
            });
        } catch (Throwable th) {
            wp.z(th);
        }
    }
}
