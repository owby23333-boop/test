package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends a<Float> {
    public g(String str, float f) {
        super(str, Float.valueOf(f));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Float.valueOf((float) jSONObject.optDouble(getKey(), Gu().floatValue())));
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putFloat(getKey(), getValue().floatValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Float.valueOf(sharedPreferences.getFloat(getKey(), Gu().floatValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    /* JADX INFO: renamed from: Gy, reason: merged with bridge method [inline-methods] */
    public final Float getValue() {
        return (Float) super.getValue();
    }
}
