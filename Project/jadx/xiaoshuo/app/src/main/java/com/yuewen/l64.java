package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l64 extends pr0 {
    public l64() {
    }

    public static l64 g(String str) {
        try {
            return new l64(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public l64(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
    }

    public l64(l64 l64Var) {
        super(l64Var);
    }
}
