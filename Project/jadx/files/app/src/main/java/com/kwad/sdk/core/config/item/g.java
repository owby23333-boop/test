package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends a<Float> {
    public g(String str, float f2) {
        super(str, Float.valueOf(f2));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Float.valueOf(sharedPreferences.getFloat(getKey(), vj().floatValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putFloat(getKey(), getValue().floatValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        setValue(jSONObject != null ? Float.valueOf((float) jSONObject.optDouble(getKey(), vj().floatValue())) : vj());
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* JADX INFO: renamed from: vn, reason: merged with bridge method [inline-methods] */
    public final Float getValue() {
        return (Float) super.getValue();
    }
}
