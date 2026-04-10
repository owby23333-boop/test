package com.bytedance.sdk.openadsdk.core.fv.z;

import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class io extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private WeakReference<SSWebView> z;

    public static void z(com.bytedance.sdk.component.z.p pVar, SSWebView sSWebView) {
        pVar.z("preventTouchEvent", (com.bytedance.sdk.component.z.gc<?, ?>) new io(sSWebView));
    }

    public io(SSWebView sSWebView) {
        this.z = new WeakReference<>(sSWebView);
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean zOptBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = this.z.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(zOptBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
