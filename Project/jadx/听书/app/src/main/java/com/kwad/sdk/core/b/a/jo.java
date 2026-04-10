package com.kwad.sdk.core.b.a;

import com.kwad.sdk.j.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class jo implements com.kwad.sdk.core.d<a.b> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((a.b) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((a.b) bVar, jSONObject);
    }

    private static void a(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aTt = jSONObject.optInt("enable_monitor");
        bVar.aTu = jSONObject.optString("c_sc_name");
        if (JSONObject.NULL.toString().equals(bVar.aTu)) {
            bVar.aTu = "";
        }
        bVar.aTv = jSONObject.optString("c_pcl_name");
        if (JSONObject.NULL.toString().equals(bVar.aTv)) {
            bVar.aTv = "";
        }
        bVar.aTw = jSONObject.optString("m_gam_name");
        if (JSONObject.NULL.toString().equals(bVar.aTw)) {
            bVar.aTw = "";
        }
        bVar.aTx = jSONObject.optString("m_gsv_name");
        if (JSONObject.NULL.toString().equals(bVar.aTx)) {
            bVar.aTx = "";
        }
        bVar.aTy = jSONObject.optString("m_gpv_name");
        if (JSONObject.NULL.toString().equals(bVar.aTy)) {
            bVar.aTy = "";
        }
    }

    private static JSONObject b(a.b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (bVar.aTt != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "enable_monitor", bVar.aTt);
        }
        if (bVar.aTu != null && !bVar.aTu.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_sc_name", bVar.aTu);
        }
        if (bVar.aTv != null && !bVar.aTv.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "c_pcl_name", bVar.aTv);
        }
        if (bVar.aTw != null && !bVar.aTw.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gam_name", bVar.aTw);
        }
        if (bVar.aTx != null && !bVar.aTx.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gsv_name", bVar.aTx);
        }
        if (bVar.aTy != null && !bVar.aTy.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "m_gpv_name", bVar.aTy);
        }
        return jSONObject;
    }
}
