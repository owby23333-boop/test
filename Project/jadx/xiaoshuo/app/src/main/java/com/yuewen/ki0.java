package com.yuewen;

import com.duokan.reader.domain.account.User;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ki0 extends ji0 {
    public final ii0 i;
    public final User j;

    public ki0(JSONObject jSONObject) throws JSONException {
        super(jSONObject);
        ii0 ii0VarB = ii0.b(jSONObject);
        this.i = ii0VarB;
        User user = new User();
        user.mUserId = ii0VarB.f12489b;
        user.mIsVip = false;
        user.mNickName = jSONObject.optString("re_reply_alias");
        user.mIconUrl = jSONObject.optString("re_reply_user_icon");
        this.j = user;
    }

    @Override // com.yuewen.ji0, com.yuewen.bm0.a
    public long a() {
        return this.i.e / 1000;
    }

    @Override // com.yuewen.ji0, com.yuewen.bm0.a
    public String b() {
        return this.i.f;
    }

    @Override // com.yuewen.ji0, com.yuewen.bm0.a
    public User c() {
        return this.j;
    }

    @Override // com.yuewen.ji0, com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
        try {
            jSONObject.put("re_reply_alias", this.j.mNickName);
            jSONObject.put("re_reply_user_icon", this.j.mIconUrl);
        } catch (JSONException unused) {
        }
    }
}
