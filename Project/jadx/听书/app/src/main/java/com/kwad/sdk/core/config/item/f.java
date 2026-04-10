package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f extends a<Double> {
    public f(String str, Double d) {
        super(str, d);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Double.valueOf(jSONObject.optDouble(getKey(), Gu().doubleValue())));
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue().toString());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Double.valueOf(Double.parseDouble(sharedPreferences.getString(getKey(), Gu().toString()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.config.item.b
    /* JADX INFO: renamed from: Gx, reason: merged with bridge method [inline-methods] */
    public Double getValue() {
        return (Double) super.getValue();
    }
}
