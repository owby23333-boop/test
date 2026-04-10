package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class l12 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f13776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fq1 f13777b;

    public l12(JSONObject jSONObject) {
        this.f13776a = jSONObject;
        try {
            this.f13777b = new fq1(jSONObject.getJSONObject(mo3.c));
        } catch (JSONException unused) {
        }
    }

    public JSONObject a() {
        return this.f13776a;
    }

    public fq1 b() {
        return this.f13777b;
    }
}
