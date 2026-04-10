package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.widget.SSWebView;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class sy extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private String g;
    private SSWebView z;

    public static void z(com.bytedance.sdk.component.z.p pVar, SSWebView sSWebView, String str) {
        pVar.z("close_wobble_observer", (com.bytedance.sdk.component.z.gc<?, ?>) new sy(sSWebView, str));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        return dl();
    }

    public sy(SSWebView sSWebView, String str) {
        this.z = sSWebView;
        this.g = str;
    }

    public JSONObject dl() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (com.bytedance.sdk.openadsdk.core.uy.ls().z(com.bytedance.sdk.openadsdk.core.zw.getContext()) && this.z != null) {
                jSONObject.put("code", 0);
                jSONObject.put("codeMsg", "success");
                this.z.I_();
                return jSONObject;
            }
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "unavailable");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
