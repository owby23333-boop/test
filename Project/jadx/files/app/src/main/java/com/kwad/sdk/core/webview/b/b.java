package com.kwad.sdk.core.webview.b;

import androidx.annotation.Nullable;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements com.kwad.sdk.core.b {
    public String apA;
    public String apz;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.apz = jSONObject.optString(NativeAdvancedJsUtils.f8246p);
        this.data = jSONObject.optString("data");
        this.apA = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, NativeAdvancedJsUtils.f8246p, this.apz);
        s.putValue(jSONObject, "data", this.data);
        s.putValue(jSONObject, "callback", this.apA);
        return jSONObject;
    }
}
