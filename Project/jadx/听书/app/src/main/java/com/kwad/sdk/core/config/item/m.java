package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class m extends b<String> {
    private boolean aCo;

    public m(String str, String str2) {
        super(str, str2);
        this.aCo = false;
    }

    public m(String str, String str2, boolean z) {
        this(str, str2);
        this.aCo = false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject != null && (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            setValue(jSONObjectOptJSONObject.toString());
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        if (this.aCo) {
            editor.putString(getKey(), getValue());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        if (this.aCo) {
            setValue(sharedPreferences.getString(getKey(), Gu()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final String getValue() {
        return (String) super.getValue();
    }
}
