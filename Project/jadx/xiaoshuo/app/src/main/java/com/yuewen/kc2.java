package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class kc2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13444a;

    public kc2(JSONObject jSONObject) throws JSONException {
        this.f13444a = jSONObject.getInt("status");
    }

    public static kc2 a(JSONObject jSONObject) throws JSONException {
        return new kc2(jSONObject);
    }

    public boolean b() {
        return this.f13444a == 0;
    }
}
