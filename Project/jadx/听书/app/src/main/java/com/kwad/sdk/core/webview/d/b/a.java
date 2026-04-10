package com.kwad.sdk.core.webview.d.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends com.kwad.sdk.core.response.a.a {

    @Deprecated
    public boolean OU;
    public String Pv;
    public int aNO;
    public int aNP;

    @Deprecated
    public boolean adL;
    public int adN;
    public d adO;
    public AdTemplate adTemplate;
    public int mI;
    public boolean Ph = true;
    public long creativeId = -1;
    public int adStyle = -1;
    public boolean aNQ = false;
    public boolean aNR = false;

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.mI == 0 && this.aNP == 0) {
                if (jSONObject != null && jSONObject.has("logParam")) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logParam");
                    this.mI = jSONObjectOptJSONObject.getInt("itemClickType");
                    this.aNP = jSONObjectOptJSONObject.getInt("sceneType");
                    this.aNQ = jSONObjectOptJSONObject.optBoolean("isCallbackOnly");
                }
                String strOptString = jSONObject.optString("adTemplate");
                if (bp.isNullString(strOptString)) {
                    return;
                }
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

    public final boolean KY() {
        return 1 == this.adN;
    }
}
