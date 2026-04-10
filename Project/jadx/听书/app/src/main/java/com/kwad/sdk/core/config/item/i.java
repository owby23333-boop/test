package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class i extends b<com.kwad.sdk.core.network.idc.a.b> {
    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
    }

    public i() {
        super("idc", new com.kwad.sdk.core.network.idc.a.b());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            com.kwad.sdk.core.network.idc.a.b bVar = new com.kwad.sdk.core.network.idc.a.b();
            bVar.parseJson(jSONObjectOptJSONObject);
            setValue(bVar);
            return;
        }
        setValue(Gu());
    }
}
