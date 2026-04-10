package com.kwad.sdk.core.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.reward.RewardItem;
import com.kwad.sdk.utils.ba;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.utils.s.putValue(jSONObject, "llsid", this.llsid);
        com.kwad.sdk.utils.s.putValue(jSONObject, "extra", this.extra);
        com.kwad.sdk.utils.s.putValue(jSONObject, "result", this.result);
        com.kwad.sdk.utils.s.putValue(jSONObject, "hasAd", this.hasAd);
        com.kwad.sdk.utils.s.putValue(jSONObject, RewardItem.KEY_ERROR_MSG, this.errorMsg);
        com.kwad.sdk.utils.s.putValue(jSONObject, "cookie", this.cookie);
        return jSONObject;
    }

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong("llsid");
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString(RewardItem.KEY_ERROR_MSG);
        String strOptString = jSONObject.optString("extra");
        if (!ba.isNullString(strOptString)) {
            this.extra = com.kwad.sdk.core.kwai.d.getResponseData(strOptString);
        }
        com.kwad.sdk.components.f fVar = (com.kwad.sdk.components.f) com.kwad.sdk.components.c.f(com.kwad.sdk.components.f.class);
        if (fVar != null) {
            fVar.aq(jSONObject.optString("egid"));
            fVar.r(jSONObject.optLong("gidExpireTimeMs"));
        }
        this.cookie = jSONObject.optString("cookie");
        if (TextUtils.isEmpty(this.cookie)) {
            return;
        }
        e.wo().bM(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }
}
