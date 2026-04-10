package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends com.kwad.sdk.core.network.d {
    public m(AdTemplate adTemplate) {
        String strBS = com.kwad.sdk.core.response.b.a.bS(com.kwad.sdk.core.response.b.e.el(adTemplate));
        try {
            String strBT = com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.el(adTemplate));
            String strBU = com.kwad.sdk.core.response.b.a.bU(com.kwad.sdk.core.response.b.e.el(adTemplate));
            if (!TextUtils.isEmpty(strBU)) {
                putBody("adExt", strBU);
            }
            if (!TextUtils.isEmpty(strBT)) {
                putBody("serverExt", new JSONObject(strBT));
            }
            if (!TextUtils.isEmpty(strBS) && strBS != null) {
                putBody("callbackUrlInfo", new JSONObject(strBS).toString());
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.AW();
    }
}
