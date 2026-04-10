package com.bytedance.sdk.openadsdk.core.nativeexpress;

import com.bytedance.sdk.openadsdk.core.mc;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {
    public static void z(NativeExpressView nativeExpressView) {
        if (nativeExpressView == null) {
            return;
        }
        mc jsObject = nativeExpressView.getJsObject();
        if (jsObject != null) {
            jsObject.z("notifyAdClicked", (JSONObject) null);
        }
        com.bytedance.sdk.openadsdk.core.ugeno.express.m uGenV3Render = nativeExpressView.getUGenV3Render();
        if (uGenV3Render != null) {
            uGenV3Render.z("notifyAdClicked", (Map<String, String>) null);
        }
    }
}
