package com.yuewen;

import com.duokan.account.b;
import com.duokan.reader.domain.account.User;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ji0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12918b;
    public final String c;
    public final String d;
    public final int e;
    public final String f;
    public final ii0 g;
    public final User h;

    public ji0(JSONObject jSONObject) {
        this.f12917a = jSONObject.optString("user_id");
        this.f12918b = jSONObject.optString("feed_id");
        this.c = jSONObject.optString("book_id");
        this.d = jSONObject.optString(b.d.a.f2202b);
        this.e = jSONObject.optInt("feed_type");
        this.f = jSONObject.optString("comment");
        ii0 ii0VarA = ii0.a(jSONObject);
        this.g = ii0VarA;
        User user = new User();
        user.mUserId = ii0VarA.f12489b;
        user.mIsVip = false;
        user.mNickName = jSONObject.optString("reply_alias");
        user.mIconUrl = jSONObject.optString("reply_user_icon");
        this.h = user;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return this.g.e / 1000;
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return this.g.f;
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.h;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.h.mNickName);
            jSONObject.put("reply_user_icon", this.h.mIconUrl);
        } catch (JSONException unused) {
        }
    }
}
