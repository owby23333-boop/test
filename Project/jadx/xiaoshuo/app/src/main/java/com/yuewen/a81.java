package com.yuewen;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class a81 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f8441b;
    public String c;
    public b81 d;
    public boolean e;

    public static a81 a(JSONObject jSONObject) {
        a81 a81Var = new a81();
        try {
            a81Var.f8440a = jSONObject.getString("user_id");
            a81Var.f8441b = jSONObject.getString("token");
            a81Var.c = jSONObject.optString("growth_token");
            a81Var.e = jSONObject.optBoolean("is_new");
            a81Var.d = b81.f(jSONObject);
        } catch (Throwable unused) {
        }
        return a81Var;
    }
}
