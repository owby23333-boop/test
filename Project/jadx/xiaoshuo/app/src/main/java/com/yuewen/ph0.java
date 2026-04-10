package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkCommentDetailInfo;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ph0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public oh0 f16040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DkCommentDetailInfo f16041b;

    public static ph0 e(JSONObject jSONObject) throws JSONException {
        ph0 ph0Var = new ph0();
        oh0 oh0Var = new oh0();
        oh0Var.f15275a.mUserId = jSONObject.getString("reply_user_id");
        oh0Var.f15275a.mNickName = jSONObject.optString("reply_alias");
        oh0Var.f15275a.mIconUrl = jSONObject.optString("reply_user_icon");
        oh0Var.c = jSONObject.getString("reply_id");
        oh0Var.f15276b = jSONObject.getString("reply");
        oh0Var.b(jSONObject.getLong("reply_time"));
        ph0Var.f16040a = oh0Var;
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.d.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.e = jSONObject.getString("comment_id");
        dkCommentDetailInfo.m = jSONObject.getString("book_id");
        dkCommentDetailInfo.n = jSONObject.optString("book_name");
        dkCommentDetailInfo.f = jSONObject.getString("comment");
        ph0Var.f16041b = dkCommentDetailInfo;
        return ph0Var;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return this.f16040a.a();
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return this.f16040a.f15276b;
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.f16040a.f15275a;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.f16040a.f15275a.mNickName);
            jSONObject.put("reply_user_icon", this.f16040a.f15275a.mIconUrl);
        } catch (JSONException unused) {
        }
    }
}
