package com.kwad.sdk.commercial.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.response.kwai.a;
import com.kwad.sdk.utils.s;
import com.kwai.adclient.logger.model.BusinessType;
import com.kwai.adclient.logger.model.SubBusinessType;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewCommercialMsg extends a implements b, Serializable {
    private static final long serialVersionUID = -1007322423487775751L;
    public BusinessType biz;
    public String category;
    public String eventId;
    public JSONObject extraParam;
    public JSONObject msg;
    public double rate;
    public SubBusinessType subBiz;
    public String suffixRatio;
    public String tag;
    public com.kwai.adclient.logger.model.b type;

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        if (jSONObject.has("sub_biz")) {
            try {
                this.subBiz = SubBusinessType.valueOf(jSONObject.optString("sub_biz"));
            } catch (Exception unused) {
                this.subBiz = SubBusinessType.OTHER;
            }
        }
        if (jSONObject.has("biz")) {
            try {
                this.biz = BusinessType.valueOf(jSONObject.optString("biz"));
            } catch (Exception unused2) {
                this.biz = BusinessType.OTHER;
            }
        }
        if (jSONObject.has("type")) {
            try {
                this.type = new com.kwai.adclient.logger.model.b(jSONObject.optString("type"));
            } catch (Exception unused3) {
                this.type = new com.kwai.adclient.logger.model.b("OTHER");
            }
        }
    }

    @Override // com.kwad.sdk.core.response.kwai.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        s.putValue(jSONObject, "biz", this.biz.value);
        s.putValue(jSONObject, "subBiz", this.subBiz.value);
        s.putValue(jSONObject, "type", this.type.getValue());
    }
}
