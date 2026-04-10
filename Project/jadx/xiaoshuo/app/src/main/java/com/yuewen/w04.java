package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class w04 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f19335a;

    public w04(JSONObject jSONObject) {
        this.f19335a = jSONObject;
    }

    public static w04 a(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        return new w04(jSONObject);
    }

    public boolean b(String str) {
        return this.f19335a.optBoolean(str);
    }

    public void c(String str, boolean z) {
        try {
            this.f19335a.put(str, z);
        } catch (JSONException unused) {
        }
    }

    public String toString() {
        return this.f19335a.toString();
    }
}
