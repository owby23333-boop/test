package com.xiaomi.passport.jsb;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class PassportJsbMethodResult {
    private final Object mResult;

    public PassportJsbMethodResult(long j) {
        this.mResult = Long.valueOf(j);
    }

    public void fillResultInJsonObject(JSONObject jSONObject, String str) {
        try {
            jSONObject.put(str, this.mResult);
        } catch (JSONException e) {
            throw new IllegalStateException("should not happen", e);
        }
    }

    public PassportJsbMethodResult(double d) {
        this.mResult = Double.valueOf(d);
    }

    public PassportJsbMethodResult(boolean z) {
        this.mResult = Boolean.valueOf(z);
    }

    public PassportJsbMethodResult(String str) {
        if (str != null) {
            this.mResult = str;
            return;
        }
        throw new IllegalArgumentException("params can not be null");
    }

    public PassportJsbMethodResult(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.mResult = jSONObject;
            return;
        }
        throw new IllegalArgumentException("params can not be null");
    }
}
