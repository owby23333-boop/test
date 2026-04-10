package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.s;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BatchReportResult extends BaseResultData implements com.kwad.sdk.core.b {
    private long interval;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getInterval() {
        return this.interval;
    }

    public long getResult() {
        return this.result;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.interval = jSONObject.optLong(am.aU);
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        s.putValue(json, am.aU, this.interval);
        return json;
    }
}
