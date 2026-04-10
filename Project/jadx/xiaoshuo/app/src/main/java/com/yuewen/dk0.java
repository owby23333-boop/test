package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class dk0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mh0 f10183a;

    public static dk0 e(JSONObject jSONObject) throws JSONException {
        dk0 dk0Var = new dk0();
        mh0 mh0Var = new mh0();
        mh0Var.f14375a.mUserId = jSONObject.getString("user_id");
        mh0Var.f14375a.mNickName = jSONObject.optString("user_nick");
        mh0Var.f14375a.mIconUrl = jSONObject.optString("user_icon");
        mh0Var.c = jSONObject.getString("object_id");
        mh0Var.f14376b = jSONObject.getInt("type");
        mh0Var.d = jSONObject.getString("ref");
        mh0Var.e = jSONObject.getLong(et.j);
        dk0Var.f10183a = mh0Var;
        return dk0Var;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return this.f10183a.e;
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return "";
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.f10183a.f14375a;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
    }
}
