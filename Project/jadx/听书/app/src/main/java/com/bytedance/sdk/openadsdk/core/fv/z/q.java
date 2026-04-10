package com.bytedance.sdk.openadsdk.core.fv.z;

import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.core.mc;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q extends com.bytedance.sdk.component.z.gc<JSONObject, JSONObject> {
    private com.bytedance.sdk.openadsdk.core.mc g;
    private String z;

    public q(String str, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        this.g = mcVar;
        this.z = str;
    }

    public static void z(com.bytedance.sdk.component.z.p pVar, com.bytedance.sdk.openadsdk.core.mc mcVar) {
        pVar.z("appInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new q("appInfo", mcVar));
        pVar.z("adInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new q("adInfo", mcVar));
        pVar.z("getTemplateInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new q("getTemplateInfo", mcVar));
        pVar.z("getTeMaiAds", (com.bytedance.sdk.component.z.gc<?, ?>) new q("getTeMaiAds", mcVar));
        pVar.z("isViewable", (com.bytedance.sdk.component.z.gc<?, ?>) new q("isViewable", mcVar));
        pVar.z("getScreenSize", (com.bytedance.sdk.component.z.gc<?, ?>) new q("getScreenSize", mcVar));
        pVar.z("getCloseButtonInfo", (com.bytedance.sdk.component.z.gc<?, ?>) new q("getCloseButtonInfo", mcVar));
        pVar.z("getVolume", (com.bytedance.sdk.component.z.gc<?, ?>) new q("getVolume", mcVar));
        pVar.z("sendReward", (com.bytedance.sdk.component.z.gc<?, ?>) new q("sendReward", mcVar));
        pVar.z("subscribe_app_ad", (com.bytedance.sdk.component.z.gc<?, ?>) new q("subscribe_app_ad", mcVar));
        pVar.z("download_app_ad", (com.bytedance.sdk.component.z.gc<?, ?>) new q("download_app_ad", mcVar));
        pVar.z("cancel_download_app_ad", (com.bytedance.sdk.component.z.gc<?, ?>) new q("cancel_download_app_ad", mcVar));
        pVar.z("unsubscribe_app_ad", (com.bytedance.sdk.component.z.gc<?, ?>) new q("unsubscribe_app_ad", mcVar));
        pVar.z("clickEvent", (com.bytedance.sdk.component.z.gc<?, ?>) new q("clickEvent", mcVar));
        pVar.z("renderDidFinish", (com.bytedance.sdk.component.z.gc<?, ?>) new q("renderDidFinish", mcVar));
        pVar.z("dynamicTrack", (com.bytedance.sdk.component.z.gc<?, ?>) new q("dynamicTrack", mcVar));
        pVar.z("skipVideo", (com.bytedance.sdk.component.z.gc<?, ?>) new q("skipVideo", mcVar));
        pVar.z("muteVideo", (com.bytedance.sdk.component.z.gc<?, ?>) new q("muteVideo", mcVar));
        pVar.z("changeVideoState", (com.bytedance.sdk.component.z.gc<?, ?>) new q("changeVideoState", mcVar));
        pVar.z("getCurrentVideoState", (com.bytedance.sdk.component.z.gc<?, ?>) new q("getCurrentVideoState", mcVar));
        pVar.z("send_temai_product_ids", (com.bytedance.sdk.component.z.gc<?, ?>) new q("send_temai_product_ids", mcVar));
        pVar.z("getMaterialMeta", (com.bytedance.sdk.component.z.gc<?, ?>) new q("getMaterialMeta", mcVar));
        pVar.z("endcard_load", (com.bytedance.sdk.component.z.gc<?, ?>) new q("endcard_load", mcVar));
        pVar.z("pauseWebView", (com.bytedance.sdk.component.z.gc<?, ?>) new q("pauseWebView", mcVar));
        pVar.z("pauseWebViewTimers", (com.bytedance.sdk.component.z.gc<?, ?>) new q("pauseWebViewTimers", mcVar));
        pVar.z("webview_time_track", (com.bytedance.sdk.component.z.gc<?, ?>) new q("webview_time_track", mcVar));
        pVar.z("adInfoStash", (com.bytedance.sdk.component.z.gc<?, ?>) new q("adInfoStash", mcVar));
    }

    @Override // com.bytedance.sdk.component.z.gc
    public JSONObject z(JSONObject jSONObject, com.bytedance.sdk.component.z.m mVar) throws Exception {
        mc.z zVar = new mc.z();
        zVar.z = NotificationCompat.CATEGORY_CALL;
        zVar.dl = this.z;
        zVar.f1262a = jSONObject;
        return this.g.z(zVar, 3);
    }
}
