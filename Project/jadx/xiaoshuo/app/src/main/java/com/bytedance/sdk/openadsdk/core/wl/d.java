package com.bytedance.sdk.openadsdk.core.wl;

import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class d {
    private JSONObject e;

    public d(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    @NonNull
    public String toString() {
        JSONObject jSONObject = this.e;
        return jSONObject != null ? jSONObject.toString() : "pitaya error is null";
    }
}
