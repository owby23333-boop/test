package com.kwad.sdk.core.b.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class hy implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.j> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.j) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jVar.aEJ = jSONObject.optLong("request_prepare_cost");
        jVar.aEK = jSONObject.optLong("request_add_params_cost");
        jVar.aEL = jSONObject.optLong("request_create_cost");
        jVar.aEM = jSONObject.optInt("keep_alive");
        jVar.aEN = jSONObject.optLong("dns_start");
        jVar.aEO = jSONObject.optLong("dns_cost");
        jVar.aEP = jSONObject.optLong("connect_establish_start");
        jVar.aEQ = jSONObject.optLong("connect_establish_cost");
        jVar.aER = jSONObject.optLong("request_start");
        jVar.aES = jSONObject.optLong("request_cost");
        jVar.aET = jSONObject.optLong("request_size");
        jVar.aEU = jSONObject.optLong("response_start");
        jVar.aEV = jSONObject.optLong("response_cost");
        jVar.aEW = jSONObject.optLong("response_parse_cost");
        jVar.aEX = jSONObject.optLong("response_size");
        jVar.aEY = jSONObject.optLong("waiting_response_cost");
        jVar.aEZ = jSONObject.optLong("total_cost");
        jVar.aFa = jSONObject.optInt("proxy_used");
        jVar.aFb = jSONObject.optString("request_id");
        if (JSONObject.NULL.toString().equals(jVar.aFb)) {
            jVar.aFb = "";
        }
        jVar.aFc = jSONObject.optInt("has_data_v2");
        jVar.result = jSONObject.optInt("result");
        jVar.aFd = jSONObject.optLong("response_done_cost");
        jVar.aFe = jSONObject.optString("host_ip");
        if (JSONObject.NULL.toString().equals(jVar.aFe)) {
            jVar.aFe = "";
        }
        jVar.aFf = jSONObject.optInt("ip_type");
        jVar.aFg = jSONObject.optInt("recommend_ping_time");
        jVar.aFh = jSONObject.optInt("backup_ping_time");
        jVar.aFi = jSONObject.optInt("other_ping_time");
    }

    private static JSONObject b(com.kwad.sdk.core.network.j jVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jVar.aEJ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_prepare_cost", jVar.aEJ);
        }
        if (jVar.aEK != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_add_params_cost", jVar.aEK);
        }
        if (jVar.aEL != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_create_cost", jVar.aEL);
        }
        if (jVar.aEM != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "keep_alive", jVar.aEM);
        }
        if (jVar.aEN != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_start", jVar.aEN);
        }
        if (jVar.aEO != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "dns_cost", jVar.aEO);
        }
        if (jVar.aEP != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_start", jVar.aEP);
        }
        if (jVar.aEQ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "connect_establish_cost", jVar.aEQ);
        }
        if (jVar.aER != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_start", jVar.aER);
        }
        if (jVar.aES != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_cost", jVar.aES);
        }
        if (jVar.aET != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_size", jVar.aET);
        }
        if (jVar.aEU != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_start", jVar.aEU);
        }
        if (jVar.aEV != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_cost", jVar.aEV);
        }
        if (jVar.aEW != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_parse_cost", jVar.aEW);
        }
        if (jVar.aEX != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_size", jVar.aEX);
        }
        if (jVar.aEY != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "waiting_response_cost", jVar.aEY);
        }
        if (jVar.aEZ != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "total_cost", jVar.aEZ);
        }
        if (jVar.aFa != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "proxy_used", jVar.aFa);
        }
        if (jVar.aFb != null && !jVar.aFb.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "request_id", jVar.aFb);
        }
        if (jVar.aFc != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "has_data_v2", jVar.aFc);
        }
        if (jVar.result != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "result", jVar.result);
        }
        if (jVar.aFd != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "response_done_cost", jVar.aFd);
        }
        if (jVar.aFe != null && !jVar.aFe.equals("")) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "host_ip", jVar.aFe);
        }
        if (jVar.aFf != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "ip_type", jVar.aFf);
        }
        if (jVar.aFg != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "recommend_ping_time", jVar.aFg);
        }
        if (jVar.aFh != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "backup_ping_time", jVar.aFh);
        }
        if (jVar.aFi != 0) {
            com.kwad.sdk.utils.aa.putValue(jSONObject, "other_ping_time", jVar.aFi);
        }
        return jSONObject;
    }
}
