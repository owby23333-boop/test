package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class s12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f17331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17332b;
    public gq1 c;

    public s12(JSONObject jSONObject) {
        this.f17331a = jSONObject;
        try {
            this.f17332b = jSONObject.getString("upload_id");
            this.c = new gq1(this.f17331a.getJSONObject(mo3.c));
        } catch (JSONException unused) {
        }
    }

    public JSONObject a() {
        return this.f17331a;
    }

    public gq1 b() {
        return this.c;
    }

    public String c() {
        return this.f17332b;
    }
}
