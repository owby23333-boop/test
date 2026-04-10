package com.kwad.sdk.core.webview.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String ZC;
    private final int result;

    public e(int i2, String str) {
        this.result = i2;
        this.ZC = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "result", this.result);
        s.putValue(jSONObject, "error_msg", this.ZC);
        return jSONObject;
    }
}
