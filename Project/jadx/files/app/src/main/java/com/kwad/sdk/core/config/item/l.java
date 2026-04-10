package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends b<String> {
    private boolean adF;

    public l(String str, String str2) {
        super(str, str2);
        this.adF = false;
    }

    public l(String str, String str2, boolean z2) {
        this(str, str2);
        this.adF = false;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        if (this.adF) {
            setValue(sharedPreferences.getString(getKey(), vj()));
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        if (this.adF) {
            editor.putString(getKey(), getValue());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        setValue((jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject(getKey())) == null) ? vj() : jSONObjectOptJSONObject.toString());
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }
}
