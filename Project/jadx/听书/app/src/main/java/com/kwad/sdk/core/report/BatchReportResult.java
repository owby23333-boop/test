package com.kwad.sdk.core.report;

import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.aa;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class BatchReportResult extends BaseResultData implements com.kwad.sdk.core.b {
    private long interval;

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.interval = jSONObject.optLong(an.aU);
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        aa.putValue(json, an.aU, this.interval);
        return json;
    }

    public long getResult() {
        return this.result;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public long getInterval() {
        return this.interval;
    }
}
