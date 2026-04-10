package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ve0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kh0 f18984a;

    public static ve0 e(JSONObject jSONObject) throws JSONException {
        ve0 ve0Var = new ve0();
        kh0 kh0Var = new kh0();
        User user = kh0Var.f13487a;
        user.mUserId = "800383";
        user.mNickName = jSONObject.getString("user_nick");
        kh0Var.f13487a.mIconUrl = jSONObject.getString("user_icon");
        kh0Var.d = jSONObject.getString("object_id");
        kh0Var.c = jSONObject.getString("title");
        kh0Var.f13488b = jSONObject.getString("content");
        kh0Var.e = jSONObject.getLong(et.j);
        ve0Var.f18984a = kh0Var;
        return ve0Var;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return this.f18984a.e;
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return this.f18984a.f13488b;
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.f18984a.f13487a;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
    }
}
