package com.yuewen;

import com.duokan.reader.domain.account.User;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ea4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public User f10555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public cb4 f10556b;

    public void a(ea4 ea4Var) {
        this.f10555a.copy(ea4Var.f10555a);
        this.f10556b.a(ea4Var.f10556b);
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_id", this.f10555a.mUserId);
            jSONObject.put("user_nick_name", this.f10555a.mNickName);
            jSONObject.put("user_icon", this.f10555a.mIconUrl);
            jSONObject.put("is_vip", this.f10555a.mIsVip);
            jSONObject.put("user_summary", this.f10556b.b());
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
