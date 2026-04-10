package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d extends a<Boolean> {
    public d(String str) {
        this(str, false);
    }

    public d(String str, boolean z) {
        super(str, Boolean.valueOf(z));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Boolean.valueOf(jSONObject.optBoolean(getKey(), Gu().booleanValue())));
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putBoolean(getKey(), getValue().booleanValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Boolean.valueOf(sharedPreferences.getBoolean(getKey(), Gu().booleanValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    /* JADX INFO: renamed from: Gv, reason: merged with bridge method [inline-methods] */
    public final Boolean getValue() {
        return (Boolean) super.getValue();
    }
}
