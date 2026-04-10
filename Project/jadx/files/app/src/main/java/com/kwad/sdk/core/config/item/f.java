package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends a<Double> {
    public f(String str, Double d2) {
        super(str, d2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* JADX INFO: renamed from: vm, reason: merged with bridge method [inline-methods] */
    public Double getValue() {
        return (Double) super.getValue();
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Double.valueOf(Double.parseDouble(sharedPreferences.getString(getKey(), vj().toString()))));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue().toString());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        setValue(jSONObject != null ? Double.valueOf(jSONObject.optDouble(getKey(), vj().doubleValue())) : vj());
    }
}
