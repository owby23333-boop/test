package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k extends a<Integer> {
    public k(String str, Integer num) {
        super(str, num);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Integer.valueOf(jSONObject.optInt(getKey(), Gu().intValue())));
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putInt(getKey(), getValue().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(sharedPreferences.getInt(getKey(), Gu().intValue())));
    }

    public final boolean Gz() {
        return getValue().intValue() == 1;
    }

    @Override // com.kwad.sdk.core.config.item.b
    /* JADX INFO: renamed from: GA, reason: merged with bridge method [inline-methods] */
    public final Integer getValue() {
        return (Integer) super.getValue();
    }
}
