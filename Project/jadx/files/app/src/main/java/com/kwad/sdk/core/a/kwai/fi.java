package com.kwad.sdk.core.a.kwai;

import com.anythink.core.api.ATAdConst;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class fi implements com.kwad.sdk.core.d<com.kwad.sdk.core.network.k> {
    private static void a(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kVar.agh = jSONObject.optLong("request_prepare_cost");
        kVar.agi = jSONObject.optLong("request_add_params_cost");
        kVar.agj = jSONObject.optLong("request_create_cost");
        kVar.agk = jSONObject.optInt("keep_alive");
        kVar.agl = jSONObject.optLong("dns_start");
        kVar.agm = jSONObject.optLong("dns_cost");
        kVar.agn = jSONObject.optLong("connect_establish_start");
        kVar.ago = jSONObject.optLong("connect_establish_cost");
        kVar.agp = jSONObject.optLong("request_start");
        kVar.agq = jSONObject.optLong("request_cost");
        kVar.agr = jSONObject.optLong("request_size");
        kVar.ags = jSONObject.optLong("response_start");
        kVar.agt = jSONObject.optLong("response_cost");
        kVar.agu = jSONObject.optLong("response_parse_cost");
        kVar.agv = jSONObject.optLong("response_size");
        kVar.agw = jSONObject.optLong("waiting_response_cost");
        kVar.agx = jSONObject.optLong("total_cost");
        kVar.agy = jSONObject.optInt("proxy_used");
        kVar.agz = jSONObject.optString(ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID);
        if (kVar.agz == JSONObject.NULL) {
            kVar.agz = "";
        }
        kVar.agA = jSONObject.optInt("has_data_v2");
        kVar.result = jSONObject.optInt("result");
        kVar.agB = jSONObject.optLong("response_done_cost");
        kVar.agC = jSONObject.optString(MonitorConstants.HOST_IP);
        if (kVar.agC == JSONObject.NULL) {
            kVar.agC = "";
        }
        kVar.agD = jSONObject.optInt("ip_type");
        kVar.agE = jSONObject.optInt("recommend_ping_time");
        kVar.agF = jSONObject.optInt("backup_ping_time");
        kVar.agG = jSONObject.optInt("other_ping_time");
    }

    private static JSONObject b(com.kwad.sdk.core.network.k kVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j2 = kVar.agh;
        if (j2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "request_prepare_cost", j2);
        }
        long j3 = kVar.agi;
        if (j3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "request_add_params_cost", j3);
        }
        long j4 = kVar.agj;
        if (j4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "request_create_cost", j4);
        }
        int i2 = kVar.agk;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "keep_alive", i2);
        }
        long j5 = kVar.agl;
        if (j5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "dns_start", j5);
        }
        long j6 = kVar.agm;
        if (j6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "dns_cost", j6);
        }
        long j7 = kVar.agn;
        if (j7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "connect_establish_start", j7);
        }
        long j8 = kVar.ago;
        if (j8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "connect_establish_cost", j8);
        }
        long j9 = kVar.agp;
        if (j9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "request_start", j9);
        }
        long j10 = kVar.agq;
        if (j10 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "request_cost", j10);
        }
        long j11 = kVar.agr;
        if (j11 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "request_size", j11);
        }
        long j12 = kVar.ags;
        if (j12 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "response_start", j12);
        }
        long j13 = kVar.agt;
        if (j13 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "response_cost", j13);
        }
        long j14 = kVar.agu;
        if (j14 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "response_parse_cost", j14);
        }
        long j15 = kVar.agv;
        if (j15 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "response_size", j15);
        }
        long j16 = kVar.agw;
        if (j16 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "waiting_response_cost", j16);
        }
        long j17 = kVar.agx;
        if (j17 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "total_cost", j17);
        }
        int i3 = kVar.agy;
        if (i3 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "proxy_used", i3);
        }
        String str = kVar.agz;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, ATAdConst.NETWORK_CUSTOM_KEY.NETWORK_REQUEST_ID, kVar.agz);
        }
        int i4 = kVar.agA;
        if (i4 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "has_data_v2", i4);
        }
        int i5 = kVar.result;
        if (i5 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "result", i5);
        }
        long j18 = kVar.agB;
        if (j18 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "response_done_cost", j18);
        }
        String str2 = kVar.agC;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, MonitorConstants.HOST_IP, kVar.agC);
        }
        int i6 = kVar.agD;
        if (i6 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ip_type", i6);
        }
        int i7 = kVar.agE;
        if (i7 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "recommend_ping_time", i7);
        }
        int i8 = kVar.agF;
        if (i8 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "backup_ping_time", i8);
        }
        int i9 = kVar.agG;
        if (i9 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "other_ping_time", i9);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.network.k) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.network.k) bVar, jSONObject);
    }
}
