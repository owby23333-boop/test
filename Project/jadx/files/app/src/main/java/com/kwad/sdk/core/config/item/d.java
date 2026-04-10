package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends a<Boolean> {
    public d(String str, boolean z2) {
        super(str, Boolean.valueOf(z2));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Boolean.valueOf(sharedPreferences.getBoolean(getKey(), vj().booleanValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putBoolean(getKey(), getValue().booleanValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        setValue(jSONObject != null ? Boolean.valueOf(jSONObject.optBoolean(getKey(), vj().booleanValue())) : vj());
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* JADX INFO: renamed from: vk, reason: merged with bridge method [inline-methods] */
    public final Boolean getValue() {
        return (Boolean) super.getValue();
    }
}
