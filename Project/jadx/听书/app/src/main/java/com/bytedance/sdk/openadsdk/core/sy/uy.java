package com.bytedance.sdk.openadsdk.core.sy;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class uy {
    public abstract JSONObject g(Context context);

    public abstract void z(int i, fo foVar);

    public abstract boolean z();

    public void z(Context context) {
        dl dlVar;
        if (z() && (dlVar = (dl) com.bytedance.sdk.openadsdk.ats.dl.z("pitaya")) != null && dlVar.isPitayaEnvAvailable()) {
            final JSONObject jSONObjectG = g(context);
            dlVar.runTask("common", jSONObjectG, new com.bytedance.sdk.openadsdk.core.ti.a() { // from class: com.bytedance.sdk.openadsdk.core.sy.uy.1
                @Override // com.bytedance.sdk.openadsdk.core.ti.a
                public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
                    SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
                    com.bytedance.sdk.openadsdk.core.q.v.z();
                    com.bytedance.sdk.openadsdk.core.q.v.z((SparseArray<Object>) sparseArray, jSONObjectG);
                    uy.this.z(i, new fo(sparseArray, i));
                    return null;
                }
            });
        }
    }
}
