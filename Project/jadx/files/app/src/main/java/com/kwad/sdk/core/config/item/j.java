package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends b<a> {

    public static class a extends com.kwad.sdk.core.response.kwai.a {
        public int adD = 180000;
        public int adE = com.anythink.expressad.foundation.g.a.bM;
    }

    public j(String str) {
        super(str, new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a value = getValue();
        if (value == null) {
            value = new a();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        if (jSONObject != null) {
            value.parseJson(jSONObject);
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        String key;
        String string;
        if (getValue() == null || getValue().toJson() == null) {
            key = getKey();
            string = "";
        } else {
            key = getKey();
            string = getValue().toJson().toString();
        }
        editor.putString(key, string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(vj());
            return;
        }
        a aVar = new a();
        aVar.parseJson(jSONObjectOptJSONObject);
        setValue(aVar);
    }
}
