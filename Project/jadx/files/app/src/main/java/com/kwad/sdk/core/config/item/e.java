package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends b<JSONObject> {
    public e() {
        super(vl(), new JSONObject());
    }

    private static String vl() {
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        return (eVar == null || !eVar.getIsExternal()) ? "commercialReportConf" : "commercialExternalReportConf";
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        JSONObject value = getValue();
        if (value == null) {
            value = new JSONObject();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (Throwable unused) {
        }
        if (jSONObject != null) {
            value = jSONObject;
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        String key;
        String string;
        if (getValue() != null) {
            key = getKey();
            string = getValue().toString();
        } else {
            key = getKey();
            string = "";
        }
        editor.putString(key, string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) == null) {
            setValue(vj());
        } else {
            setValue(jSONObjectOptJSONObject);
        }
    }
}
