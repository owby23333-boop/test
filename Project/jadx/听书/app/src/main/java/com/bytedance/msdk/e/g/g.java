package com.bytedance.msdk.e.g;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g {
    private static volatile g z;

    private g() {
    }

    public static g z() {
        if (z == null) {
            synchronized (g.class) {
                if (z == null) {
                    z = new g();
                }
            }
        }
        return z;
    }

    public void z(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.g.g(com.bytedance.msdk.core.g.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.z.kb().wp(), 0).edit().putString("rit_conf", jSONArray.toString()).apply();
    }

    public void z(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.api.plugin.g.g(com.bytedance.msdk.core.g.getContext(), "tt_sdk_test_tool_data_" + com.bytedance.msdk.core.z.kb().wp(), 0).edit().putString("adn_init_conf", jSONObject.toString()).apply();
    }
}
