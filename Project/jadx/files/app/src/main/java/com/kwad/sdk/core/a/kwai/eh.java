package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.HttpDnsInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class eh implements com.kwad.sdk.core.d<HttpDnsInfo.IpInfo> {
    private static void a(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        ipInfo.ip = jSONObject.optString("ip");
        if (ipInfo.ip == JSONObject.NULL) {
            ipInfo.ip = "";
        }
        ipInfo.weight = jSONObject.optInt("weight");
    }

    private static JSONObject b(HttpDnsInfo.IpInfo ipInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = ipInfo.ip;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "ip", ipInfo.ip);
        }
        int i2 = ipInfo.weight;
        if (i2 != 0) {
            com.kwad.sdk.utils.s.putValue(jSONObject, "weight", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((HttpDnsInfo.IpInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((HttpDnsInfo.IpInfo) bVar, jSONObject);
    }
}
