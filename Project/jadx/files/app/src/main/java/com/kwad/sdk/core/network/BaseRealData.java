package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRealData extends BaseResultData {
    protected abstract void parseData(@NonNull JSONObject jSONObject);

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String responseData = com.kwad.sdk.core.kwai.d.getResponseData(jSONObject.optString("data"));
            if (responseData == null || responseData.isEmpty()) {
                this.result = 0;
            } else {
                parseData(new JSONObject(responseData));
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            this.result = 0;
            this.errorMsg = e2.getMessage();
        }
    }
}
