package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.adlog.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ch implements com.kwad.sdk.core.d<a.C0392a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.C0392a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.C0392a) bVar, jSONObject);
    }

    private static void a(a.C0392a c0392a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0392a.awU = jSONObject.optInt("ad_retry_type");
        c0392a.templateId = jSONObject.optString("template_id");
        if (JSONObject.NULL.toString().equals(c0392a.templateId)) {
            c0392a.templateId = "";
        }
        c0392a.awV = jSONObject.optString("template_sub_id");
        if (JSONObject.NULL.toString().equals(c0392a.awV)) {
            c0392a.awV = "";
        }
        c0392a.awW = jSONObject.optString("default_type");
        if (JSONObject.NULL.toString().equals(c0392a.awW)) {
            c0392a.awW = "";
        }
        c0392a.awY = jSONObject.optString("template_show_type");
        if (JSONObject.NULL.toString().equals(c0392a.awY)) {
            c0392a.awY = "";
        }
        c0392a.awZ = jSONObject.optInt("network_download_status", new Integer("3").intValue());
        c0392a.axa = jSONObject.optInt("award_task_name");
        c0392a.axb = jSONObject.optInt("jumps_liveroom_type");
        c0392a.axc = jSONObject.optInt("universe_feature_freg");
        c0392a.axd = jSONObject.optInt("replace_url_succ");
        c0392a.axe = jSONObject.optBoolean("is_dp_opt");
        c0392a.axf = jSONObject.optString("component_module");
        if (JSONObject.NULL.toString().equals(c0392a.axf)) {
            c0392a.axf = "";
        }
        c0392a.axh = jSONObject.optInt("is_carousel");
        c0392a.axi = jSONObject.optInt("is_special_preload");
        c0392a.axj = jSONObject.optInt("card_type");
    }

    private static JSONObject b(a.C0392a c0392a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (c0392a.awU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ad_retry_type", c0392a.awU);
        }
        if (c0392a.templateId != null && !c0392a.templateId.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_id", c0392a.templateId);
        }
        if (c0392a.awV != null && !c0392a.awV.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_sub_id", c0392a.awV);
        }
        if (c0392a.awW != null && !c0392a.awW.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "default_type", c0392a.awW);
        }
        if (c0392a.awY != null && !c0392a.awY.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "template_show_type", c0392a.awY);
        }
        com.kwad.sdk.utils.aa.putValue(jSONObject, "network_download_status", c0392a.awZ);
        if (c0392a.axa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "award_task_name", c0392a.axa);
        }
        if (c0392a.axb != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "jumps_liveroom_type", c0392a.axb);
        }
        if (c0392a.axc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "universe_feature_freg", c0392a.axc);
        }
        if (c0392a.axd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "replace_url_succ", c0392a.axd);
        }
        if (c0392a.axe) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_dp_opt", c0392a.axe);
        }
        if (c0392a.axf != null && !c0392a.axf.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "component_module", c0392a.axf);
        }
        if (c0392a.axh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_carousel", c0392a.axh);
        }
        if (c0392a.axi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "is_special_preload", c0392a.axi);
        }
        if (c0392a.axj != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "card_type", c0392a.axj);
        }
        return jSONObject;
    }
}
