package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class n extends b<String> {
    private static volatile String[] adG;

    public n(String str, String str2) {
        super(str, str2);
        adG = null;
    }

    public static boolean C(long j2) {
        if (adG == null) {
            return false;
        }
        for (String str : adG) {
            if (str != null && String.valueOf(j2).equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    private static void bo(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        adG = str.split(",");
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void a(@NonNull SharedPreferences sharedPreferences) {
        String string = sharedPreferences.getString(getKey(), vj());
        setValue(string);
        bo(string);
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void b(@NonNull SharedPreferences.Editor editor) {
        editor.putString(getKey(), getValue());
    }

    @Override // com.kwad.sdk.core.config.item.b
    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            setValue(vj());
            return;
        }
        String strOptString = jSONObject.optString(getKey(), vj());
        setValue(strOptString);
        bo(strOptString);
    }
}
