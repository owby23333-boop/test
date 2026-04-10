package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class h extends b<a> {

    public static final class a extends com.kwad.sdk.core.response.a.a {
        public String aCk = "";
        public String aCl = "";
    }

    public h() {
        super("idMapping", new a());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey());
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        a aVar = new a();
        aVar.parseJson(jSONObjectOptJSONObject);
        setValue(aVar);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), dz(getValue().toJson().toString()));
        } else {
            editor.putString(getKey(), "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        a value = getValue();
        if (value == null) {
            value = new a();
        }
        String string = sharedPreferences.getString(getKey(), "");
        if (!TextUtils.isEmpty(string)) {
            try {
                value.parseJson(new JSONObject(getDecodeString(string)));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        setValue(value);
    }

    public final String getImei() {
        a value = getValue();
        return (value == null || TextUtils.isEmpty(value.aCk)) ? "" : value.aCk;
    }

    public final String getOaid() {
        a value = getValue();
        return (value == null || TextUtils.isEmpty(value.aCl)) ? "" : value.aCl;
    }
}
