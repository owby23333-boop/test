package com.anythink.expressad.videocommon.c;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private String a;
    private String b;

    private a(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private String a() {
        return this.a;
    }

    private String b() {
        return this.b;
    }

    private void a(String str) {
        this.a = str;
    }

    private void b(String str) {
        this.b = str;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new a(jSONObject.optString(com.anythink.expressad.videocommon.e.b.f12231u), jSONObject.optString(com.anythink.expressad.videocommon.e.b.f12232v));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
