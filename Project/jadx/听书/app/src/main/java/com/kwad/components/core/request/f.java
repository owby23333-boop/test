package com.kwad.components.core.request;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aa;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends com.kwad.sdk.core.network.d {
    public long requestStartTime;

    public f(int i, AdTemplate adTemplate) {
        String strBS = com.kwad.sdk.core.response.b.a.bS(com.kwad.sdk.core.response.b.e.el(adTemplate));
        try {
            String strBT = com.kwad.sdk.core.response.b.a.bT(com.kwad.sdk.core.response.b.e.el(adTemplate));
            try {
                if (!TextUtils.isEmpty(strBT)) {
                    putBody("serverExt", new JSONObject(strBT));
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
            if (!TextUtils.isEmpty(strBS) && strBS != null) {
                JSONObject jSONObject = new JSONObject(strBS);
                aa.putValue(jSONObject, "checkType", i);
                putBody("callbackUrlInfo", jSONObject.toString());
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.c.printStackTrace(e2);
        }
        ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
        JSONArray jSONArray = new JSONArray();
        aa.a(jSONArray, impInfo.toJson());
        putBody("impInfo", jSONArray);
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return com.kwad.sdk.h.AV();
    }
}
