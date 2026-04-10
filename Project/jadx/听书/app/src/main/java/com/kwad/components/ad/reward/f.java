package com.kwad.components.ad.reward;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public f(AdTemplate adTemplate) {
        putBody("callbackUrlInfo", com.kwad.sdk.core.response.b.a.bS(com.kwad.sdk.core.response.b.e.el(adTemplate)));
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
        try {
            String strBT = com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.el(adTemplate));
            if (TextUtils.isEmpty(strBT)) {
                return;
            }
            putBody("serverExt", new JSONObject(strBT));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.AR();
    }
}
