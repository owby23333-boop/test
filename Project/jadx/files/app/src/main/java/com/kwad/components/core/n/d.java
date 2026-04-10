package com.kwad.components.core.n;

import com.kwad.sdk.utils.s;
import com.kwad.sdk.utils.x;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.sdk.core.network.d {
    public d() {
        JSONArray jSONArray = new JSONArray();
        s.putValue(jSONArray, new JSONObject());
        putBody("impInfo", jSONArray);
        putBody("appTag", x.Dr());
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.g
    public final String getUrl() {
        return com.kwad.sdk.c.sy();
    }

    @Override // com.kwad.sdk.core.network.d
    public final boolean isAddAppPackageNameParam() {
        return true;
    }
}
