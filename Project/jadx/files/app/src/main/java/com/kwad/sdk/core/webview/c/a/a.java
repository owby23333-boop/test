package com.kwad.sdk.core.webview.c.a;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
    public boolean IV;
    public String Jl;

    @Deprecated
    public boolean Tw;
    public int Ty;
    public c Tz;
    public int apI;
    public int apJ;
    public int jS;
    public boolean Jd = true;
    public long creativeId = -1;
    public int adStyle = -1;

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        try {
            if (this.jS == 0 && this.apJ == 0 && jSONObject != null && jSONObject.has("logParam")) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("logParam");
                this.jS = jSONObjectOptJSONObject.getInt("itemClickType");
                this.apJ = jSONObjectOptJSONObject.getInt("sceneType");
            }
        } catch (Throwable unused) {
        }
    }

    public final boolean zr() {
        return 1 == this.Ty;
    }
}
