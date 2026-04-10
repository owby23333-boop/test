package com.tramini.plugin.a.g;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public String a;
    public int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19336c;

    public final JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("att_pl", this.b);
            jSONObject.put("att_ver", this.a);
            jSONObject.put("att_inf", this.f19336c);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }
}
