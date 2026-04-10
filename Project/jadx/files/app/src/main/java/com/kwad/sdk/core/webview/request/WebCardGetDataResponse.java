package com.kwad.sdk.core.webview.request;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.kwai.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.s;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WebCardGetDataResponse extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final String TAG = "WebCardGetDataResponse";
    private static final long serialVersionUID = 2407409365862659643L;
    public JSONObject data;
    public JSONArray impAdInfo;

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("impAdInfo");
            if (ba.isNullString(strOptString)) {
                String strOptString2 = jSONObject.optString("data");
                if (ba.isNullString(strOptString2)) {
                    return;
                }
                this.data = new JSONObject(d.getResponseData(strOptString2));
                return;
            }
            String responseData = d.getResponseData(strOptString);
            if (ba.isNullString(responseData)) {
                return;
            }
            this.impAdInfo = new JSONArray(responseData);
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        JSONObject jSONObject = this.data;
        if (jSONObject != null) {
            s.putValue(json, "data", jSONObject);
        }
        JSONArray jSONArray = this.impAdInfo;
        if (jSONArray != null) {
            s.putValue(json, "impAdInfo", jSONArray);
        }
        return json;
    }
}
