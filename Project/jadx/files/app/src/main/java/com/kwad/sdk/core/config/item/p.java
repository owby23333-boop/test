package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class p extends a<String> {
    public p(String str, String str2) {
        super(str, str2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(b.bn(sharedPreferences.getString(getKey(), vj())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), b.bm(getValue()));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        String strOptString = jSONObject != null ? jSONObject.optString(getKey(), vj()) : null;
        if (TextUtils.isEmpty(strOptString)) {
            setValue(vj());
        } else {
            setValue(strOptString);
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    public final String getValue() {
        return (String) super.getValue();
    }
}
