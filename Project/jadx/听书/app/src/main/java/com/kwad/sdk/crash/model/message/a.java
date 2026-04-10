package com.kwad.sdk.crash.model.message;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.crash.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private JSONObject aPy = new JSONObject();

    public final void fE(String str) {
        put(d.aOO, str);
    }

    public final void putInt(String str, int i) {
        put(str, Integer.valueOf(i));
    }

    public final void putString(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.length() > 100) {
            c.d("AnrAndNativeAdExceptionCollector", "string value to long ,max is 100");
        } else {
            put(str, str2);
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        put(str, jSONObject);
    }

    private void put(String str, Object obj) {
        try {
            this.aPy.put(str, obj);
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }

    public final String toString() {
        return this.aPy.toString();
    }
}
