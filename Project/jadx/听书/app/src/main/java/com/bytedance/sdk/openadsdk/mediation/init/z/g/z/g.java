package com.bytedance.sdk.openadsdk.mediation.init.z.g.z;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    public final PluginValueSet z;

    public g(SparseArray<Object> sparseArray) {
        this.z = com.bykv.z.z.z.z.z.z(sparseArray).g();
    }

    public List<String> z() {
        return (List) this.z.objectValue(262114, List.class);
    }

    public List<String> g() {
        return (List) this.z.objectValue(262115, List.class);
    }

    public boolean dl() {
        return this.z.booleanValue(262116);
    }

    public boolean a() {
        return this.z.booleanValue(262117);
    }

    public boolean gc() {
        return this.z.booleanValue(262118);
    }
}
