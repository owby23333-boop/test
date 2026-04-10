package com.yuewen;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ls {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f13987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f13988b;

    public ls(JSONObject jSONObject) throws Throwable {
        this.f13987a = jSONObject.getString("ad_name");
        this.f13988b = jSONObject.getString("reference_id");
    }

    public static ls c(JSONObject jSONObject) {
        try {
            return new ls(jSONObject);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a() {
        return this.f13988b;
    }

    public String b() {
        return this.f13987a;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_name", this.f13987a);
            jSONObject.put("reference_id", this.f13988b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
