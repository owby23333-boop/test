package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkCommentDetailInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class oh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final User f15275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15276b;
    public String c;
    public String d;
    public String e;
    public long f;

    public oh0() {
        this.f15275a = new User();
        this.f15276b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    public long a() {
        return this.f;
    }

    public void b(long j) {
        this.f = j;
    }

    public oh0(JSONObject jSONObject) throws JSONException {
        User user = new User();
        this.f15275a = user;
        this.f15276b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        user.mUserId = jSONObject.getString("user_id");
        user.mNickName = jSONObject.getString("nick_name");
        user.mIconUrl = jSONObject.optString("user_icon");
        this.f15276b = jSONObject.getString("content");
        b(jSONObject.optLong(DkCommentDetailInfo.s, System.currentTimeMillis() / 1000) + 28800);
        this.c = jSONObject.getString("reply_id");
        this.d = jSONObject.optString("reply_to", null);
        this.e = jSONObject.getString("device_type");
    }
}
