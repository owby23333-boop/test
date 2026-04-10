package com.kwad.sdk.core.config.item;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class n extends r {
    private JSONObject aCp;

    public n(String str) {
        this(str, "{}");
    }

    private n(String str, String str2) {
        super(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.config.item.b
    public void setValue(String str) {
        super.setValue(str);
        try {
            this.aCp = new JSONObject(getValue());
        } catch (NullPointerException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e2);
        }
    }

    public final int dA(String str) {
        JSONObject jSONObject;
        if (str != null && (jSONObject = this.aCp) != null) {
            try {
                return jSONObject.optInt(str);
            } catch (Exception unused) {
            }
        }
        return -1;
    }
}
