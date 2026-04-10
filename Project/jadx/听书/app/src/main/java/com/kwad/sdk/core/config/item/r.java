package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class r extends a<String> {
    public r(String str) {
        this(str, "");
    }

    public r(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString(getKey(), Gu()) : null;
        if (TextUtils.isEmpty(strOptString)) {
            setValue(Gu());
        } else {
            setValue(strOptString);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), dz(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(getDecodeString(sharedPreferences.getString(getKey(), Gu())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final String getValue() {
        return (String) super.getValue();
    }
}
