package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class o extends a<Long> {
    public o(String str) {
        this(str, 0L);
    }

    public o(String str, Long l) {
        super(str, l);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            setValue(Long.valueOf(jSONObject.optLong(getKey(), Gu().longValue())));
        } else {
            setValue(Gu());
        }
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putLong(getKey(), getValue().longValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        setValue(Long.valueOf(sharedPreferences.getLong(getKey(), Gu().longValue())));
    }

    @Override // com.kwad.sdk.core.config.item.b
    /* JADX INFO: renamed from: GB, reason: merged with bridge method [inline-methods] */
    public final Long getValue() {
        return (Long) super.getValue();
    }
}
