package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.domain.account.User;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class cb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9593b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public float h;
    public String i;
    public String j;

    public cb4(String str) {
        this.f9592a = str;
        this.f9593b = false;
        this.c = 0;
        this.i = "";
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0.0f;
        this.j = "";
    }

    public void a(cb4 cb4Var) {
        this.f9592a = cb4Var.f9592a;
        this.f9593b = cb4Var.f9593b;
        this.c = cb4Var.c;
        this.i = cb4Var.i;
        this.d = cb4Var.d;
        this.e = cb4Var.e;
        this.f = cb4Var.f;
        this.g = cb4Var.g;
        this.h = cb4Var.h;
        this.j = cb4Var.j;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_vip", this.f9593b ? 1 : 0);
            jSONObject.put("following_count", this.d);
            jSONObject.put("follower_count", this.e);
            jSONObject.put("note_count", this.f);
            jSONObject.put("favourite_count", this.g);
            jSONObject.put("ranking", this.h);
            jSONObject.put("description", this.i);
            jSONObject.put("auth_info", this.j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public cb4(User user) {
        this.f9592a = user.mUserId;
        this.f9593b = user.mIsVip;
        this.c = 0;
        this.i = "";
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0.0f;
        this.j = "";
    }

    public cb4(String str, JSONObject jSONObject) {
        this.f9592a = str;
        this.f9593b = jSONObject.optInt("is_vip", 0) == 1;
        String strOptString = jSONObject.optString("description");
        this.i = strOptString;
        if (TextUtils.isEmpty(strOptString)) {
            this.i = jSONObject.optString("intro");
        }
        this.d = jSONObject.optInt("following_count", 0);
        this.e = jSONObject.optInt("follower_count", 0);
        this.f = jSONObject.optInt("note_count", 0);
        this.g = jSONObject.optInt("favourite_count", 0);
        this.h = (float) jSONObject.optDouble("ranking", w51.l);
        this.j = jSONObject.optString("auth_info");
    }
}
