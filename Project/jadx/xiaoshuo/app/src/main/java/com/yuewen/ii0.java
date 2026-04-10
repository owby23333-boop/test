package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ii0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12489b;
    public final boolean c;
    public final String d;
    public final long e;
    public final String f;

    public ii0(JSONObject jSONObject) {
        this.f12488a = jSONObject.optString("reply_id");
        this.f12489b = jSONObject.optString("user_id");
        this.c = jSONObject.optInt("is_vip") == 1;
        this.d = jSONObject.optString("to_user_id", "");
        this.e = jSONObject.optLong("publish_time") * 1000;
        this.f = jSONObject.optString("content");
    }

    public static ii0 a(JSONObject jSONObject) {
        return new ii0(jSONObject.optString("reply_id"), jSONObject.optString("reply_user_id"), false, "", 1000 * jSONObject.optLong("reply_time"), jSONObject.optString("reply"));
    }

    public static ii0 b(JSONObject jSONObject) {
        return new ii0(jSONObject.optString("re_reply_id"), jSONObject.optString("re_reply_user_id"), false, "", 1000 * jSONObject.optLong("re_reply_time"), jSONObject.optString("re_reply"));
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("reply_id", this.f12488a);
            jSONObject.put("user_id", this.f12489b);
            jSONObject.put("is_vip", this.c ? 1 : 0);
            jSONObject.put("to_user_id", this.d);
            jSONObject.put("publish_time", this.e / 1000);
            jSONObject.put("content", this.f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public ii0(String str, String str2, boolean z, String str3, long j, String str4) {
        this.f12488a = str;
        this.f12489b = str2;
        this.c = z;
        this.d = str3;
        this.e = j;
        this.f = str4;
    }
}
