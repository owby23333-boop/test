package com.yuewen;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class aa4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8460b;
    public int c;
    public int d;

    public aa4() {
        this.f8459a = 0;
        this.f8460b = 0;
        this.c = 0;
        this.d = 0;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("comment_count", this.f8459a);
            jSONObject.put("note_count", this.f8460b);
            jSONObject.put("book_count", this.c);
            jSONObject.put("useful_count", this.d);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public void b(aa4 aa4Var) {
        this.f8459a = aa4Var.f8459a;
        this.f8460b = aa4Var.f8460b;
        this.c = aa4Var.c;
        this.d = aa4Var.d;
    }

    public aa4(JSONObject jSONObject) {
        this.f8459a = jSONObject.optInt("comment_count");
        this.f8460b = jSONObject.optInt("note_count");
        this.c = jSONObject.optInt("book_count");
        this.d = jSONObject.optInt("useful_count");
    }
}
