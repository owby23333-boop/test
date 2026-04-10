package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p extends b<String> {
    private static volatile String[] aCq;

    public p(String str, String str2) {
        super(str, str2);
        aCq = null;
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void k(JSONObject jSONObject) {
        if (jSONObject != null) {
            String strOptString = jSONObject.optString(getKey(), Gu());
            setValue(strOptString);
            dB(strOptString);
            return;
        }
        setValue(Gu());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), Gu());
        setValue(string);
        dB(string);
    }

    public static boolean ah(long j) {
        if (aCq == null) {
            return false;
        }
        for (String str : aCq) {
            if (str != null && String.valueOf(j).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void dB(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        aCq = str.split(",");
    }
}
