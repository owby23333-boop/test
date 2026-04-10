package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends a<Integer> {
    public k(String str, Integer num) {
        super(str, num);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Integer.valueOf(sharedPreferences.getInt(getKey(), vj().intValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putInt(getKey(), getValue().intValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        setValue(jSONObject != null ? Integer.valueOf(jSONObject.optInt(getKey(), vj().intValue())) : vj());
    }

    public final boolean vo() {
        return getValue().intValue() == 1;
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* JADX INFO: renamed from: vp, reason: merged with bridge method [inline-methods] */
    public final Integer getValue() {
        return (Integer) super.getValue();
    }
}
