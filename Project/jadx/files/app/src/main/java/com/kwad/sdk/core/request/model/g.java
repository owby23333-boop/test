package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements com.kwad.sdk.core.b {
    public int aaB;
    public int aaC;
    public String aaD;
    private String alk;
    private String all;

    public static g xH() {
        return new g();
    }

    public final void co(String str) {
        this.all = str;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        s.putValue(jSONObject, "user_id", this.alk);
        s.putValue(jSONObject, "thirdUserId", this.all);
        int i2 = this.aaB;
        if (i2 != 0) {
            s.putValue(jSONObject, "thirdAge", i2);
        }
        int i3 = this.aaC;
        if (i3 != 0) {
            s.putValue(jSONObject, "thirdGender", i3);
        }
        s.putValue(jSONObject, "thirdInterest", this.aaD);
        return jSONObject;
    }
}
