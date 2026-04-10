package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class v12 implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f18869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f18870b;
    public long c;

    public v12() {
        this.f18869a = 0L;
        this.f18870b = 0L;
        this.c = 0L;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public v12 clone() {
        try {
            return (v12) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("total", this.f18869a);
            jSONObject.put("available", this.f18870b);
            jSONObject.put("ns_used", this.c);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public v12(JSONObject jSONObject) {
        this.f18869a = 0L;
        this.f18870b = 0L;
        this.c = 0L;
        this.f18869a = jSONObject.optLong("total");
        this.f18870b = jSONObject.optLong("available");
        this.c = jSONObject.optLong("ns_used");
    }
}
