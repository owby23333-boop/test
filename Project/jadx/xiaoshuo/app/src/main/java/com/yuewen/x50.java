package com.yuewen;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class x50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f19792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f19793b;
    public String c;
    public JSONObject d;
    public String e;
    public boolean f;
    public int g = 0;
    public JSONObject h;

    public x50(JSONObject jSONObject) {
        this.h = jSONObject;
        g(jSONObject);
    }

    public JSONObject a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f19793b;
    }

    public String d() {
        return this.f19792a;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof x50) {
            return TextUtils.equals(this.h.toString(), ((x50) obj).h.toString());
        }
        return false;
    }

    public boolean f() {
        return this.f;
    }

    public final void g(JSONObject jSONObject) {
        try {
            this.f19792a = jSONObject.getString("title");
            this.f19793b = jSONObject.getString("id");
            this.c = jSONObject.getJSONObject("extend").getString("type");
            this.d = jSONObject.getJSONObject("data");
            this.e = jSONObject.getJSONObject("extend").optString("tab_icon");
            this.f = jSONObject.getJSONObject("extend").optBoolean("tab_prior");
            if (jSONObject.getJSONObject("extend").has("slide")) {
                this.g = Integer.parseInt(jSONObject.getJSONObject("extend").optString("slide"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
