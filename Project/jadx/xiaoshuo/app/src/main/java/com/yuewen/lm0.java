package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class lm0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final User f13938a;

    public lm0(User user) {
        User user2 = new User();
        this.f13938a = user2;
        User.copy(user, user2);
    }

    public static lm0 e(JSONObject jSONObject) throws JSONException {
        User user = new User();
        user.mUserId = jSONObject.getString("user_id");
        user.mNickName = jSONObject.optString("user_nick_name");
        user.mIconUrl = jSONObject.optString("user_icon");
        return new lm0(user);
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return 0L;
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return "";
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.f13938a;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
        try {
            jSONObject.put("user_nick_name", this.f13938a.mNickName);
            jSONObject.put("user_icon", this.f13938a.mIconUrl);
        } catch (JSONException unused) {
        }
    }
}
