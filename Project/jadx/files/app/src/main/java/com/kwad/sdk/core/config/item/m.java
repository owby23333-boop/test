package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends a<Long> {
    public m(String str) {
        this(str, 0L);
    }

    public m(String str, Long l2) {
        super(str, l2);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        setValue(Long.valueOf(sharedPreferences.getLong(getKey(), vj().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putLong(getKey(), getValue().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        setValue(jSONObject != null ? Long.valueOf(jSONObject.optLong(getKey(), vj().longValue())) : vj());
    }

    @Override // com.kwad.sdk.core.config.item.b
    @NonNull
    /* JADX INFO: renamed from: vq, reason: merged with bridge method [inline-methods] */
    public final Long getValue() {
        return (Long) super.getValue();
    }
}
