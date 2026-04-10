package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends b<com.kwad.sdk.core.network.idc.kwai.a> {
    public i() {
        super("idc", new com.kwad.sdk.core.network.idc.kwai.a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(vj());
            return;
        }
        com.kwad.sdk.core.network.idc.kwai.a aVar = new com.kwad.sdk.core.network.idc.kwai.a();
        aVar.parseJson(jSONObjectOptJSONObject);
        setValue(aVar);
    }
}
