package com.bytedance.sdk.openadsdk.core.wl;

import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e extends ga {
    public e(Result result, int i) {
        super(result, i);
    }

    public d bf() {
        ValueSet valueSetValues;
        if (d() == null || (valueSetValues = d().values()) == null) {
            return null;
        }
        return new d((JSONObject) valueSetValues.objectValue(4, JSONObject.class));
    }

    public boolean e() {
        if (d() != null) {
            return d().isSuccess();
        }
        return false;
    }
}
