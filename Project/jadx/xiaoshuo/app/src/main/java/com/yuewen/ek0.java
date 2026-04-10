package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ek0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lh0 f10619a;

    public static ek0 e(JSONObject jSONObject) throws JSONException {
        ek0 ek0Var = new ek0();
        lh0 lh0Var = new lh0();
        lh0Var.f13913a.mUserId = jSONObject.getString("comment_user");
        lh0Var.f13913a.mNickName = jSONObject.optString("comment_user_nick");
        lh0Var.f13913a.mIconUrl = jSONObject.optString("comment_user_icon");
        lh0Var.d = jSONObject.getString("object_id");
        lh0Var.c = jSONObject.getInt("type");
        lh0Var.f13914b = jSONObject.getString("content");
        lh0Var.e = jSONObject.getString("ref");
        lh0Var.f = jSONObject.getLong(et.j);
        ek0Var.f10619a = lh0Var;
        return ek0Var;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return this.f10619a.f;
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return this.f10619a.f13914b;
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.f10619a.f13913a;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
    }
}
