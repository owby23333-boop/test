package com.bytedance.sdk.openadsdk.core.sy;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class gc extends fo {
    public gc(SparseArray<Object> sparseArray, int i) {
        super(sparseArray, i);
    }

    public boolean z() {
        if (dl() != null) {
            return dl().z();
        }
        return false;
    }

    public e g() {
        PluginValueSet pluginValueSetA;
        if (dl() == null || (pluginValueSetA = dl().a()) == null) {
            return null;
        }
        return new e((JSONObject) pluginValueSetA.objectValue(4, JSONObject.class));
    }
}
