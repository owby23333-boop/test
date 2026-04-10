package com.kwad.sdk.core.webview.d.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends com.kwad.sdk.core.response.a.a {
    public String aNS;
    public AdTemplate adTemplate;
    public String extra;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            String strOptString = jSONObject.optString("adTemplate");
            if (!bp.isNullString(strOptString)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    AdTemplate adTemplate = new AdTemplate();
                    this.adTemplate = adTemplate;
                    adTemplate.parseJson(jSONObject2);
                } catch (JSONException e) {
                    ServiceProvider.reportSdkCaughtException(e);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
