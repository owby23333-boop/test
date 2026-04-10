package com.bytedance.sdk.gromore.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.mediation.ad.z.g.z.dl;
import com.bytedance.sdk.openadsdk.mediation.g.g.g;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private com.bytedance.sdk.openadsdk.mediation.g.g.z g;
    private PluginValueSet z;

    public z(SparseArray<Object> sparseArray) {
        this.z = com.bykv.z.z.z.z.z.z(sparseArray).g();
        this.g = new com.bytedance.sdk.openadsdk.mediation.g.g.z(sparseArray);
    }

    public int z() {
        return this.g.m();
    }

    public int g() {
        return this.g.e();
    }

    public float dl() {
        return this.g.gz();
    }

    public float a() {
        return this.g.fo();
    }

    public String gc() {
        return this.g.a();
    }

    public g m() {
        com.bytedance.sdk.openadsdk.mediation.g.g.z zVar = this.g;
        if (zVar != null) {
            return zVar.l();
        }
        return null;
    }

    public dl e() {
        if (m() != null) {
            return m().i();
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> gz() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return com.bytedance.sdk.openadsdk.l.dl.z(pluginValueSet.objectValue(8302, Object.class));
        }
        return null;
    }

    public int fo() {
        PluginValueSet pluginValueSet = this.z;
        if (pluginValueSet != null) {
            return pluginValueSet.intValue(3);
        }
        return 0;
    }
}
