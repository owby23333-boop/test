package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private String g;
    private SSWebView z;

    public static void z(com.bytedance.sdk.component.z.p pVar, SSWebView sSWebView, String str) {
        pVar.z("start_twist_observer", (com.bytedance.sdk.component.z.gc<?, ?>) new g(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        return dl();
    }

    public g(SSWebView sSWebView, String str) {
        this.z = sSWebView;
        this.g = str;
    }

    public JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.uy.ls().g(com.bytedance.sdk.openadsdk.core.zw.getContext()) && this.z != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.z.z(2, com.bytedance.sdk.openadsdk.core.uy.ls().gc());
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
