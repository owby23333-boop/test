package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkCommentDetailInfo;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class qh0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public oh0 f16522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DkCommentDetailInfo f16523b;
    public oh0 c;

    public static qh0 e(JSONObject jSONObject) throws JSONException {
        qh0 qh0Var = new qh0();
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.d.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.e = jSONObject.getString("comment_id");
        dkCommentDetailInfo.m = jSONObject.getString("book_id");
        dkCommentDetailInfo.n = jSONObject.optString("book_name");
        dkCommentDetailInfo.f = jSONObject.getString("comment");
        qh0Var.f16523b = dkCommentDetailInfo;
        oh0 oh0Var = new oh0();
        oh0Var.f15275a.mUserId = jSONObject.getString("reply_user_id");
        oh0Var.f15275a.mNickName = jSONObject.optString("reply_alias");
        oh0Var.f15275a.mIconUrl = jSONObject.optString("reply_user_icon");
        oh0Var.c = jSONObject.getString("reply_id");
        oh0Var.f15276b = jSONObject.getString("reply");
        oh0Var.b(jSONObject.getLong("reply_time"));
        qh0Var.f16522a = oh0Var;
        oh0 oh0Var2 = new oh0();
        oh0Var2.f15275a.mUserId = jSONObject.getString("re_reply_user_id");
        oh0Var2.f15275a.mNickName = jSONObject.optString("re_reply_alias");
        oh0Var2.f15275a.mIconUrl = jSONObject.optString("re_reply_user_icon");
        oh0Var2.c = jSONObject.getString("re_reply_id");
        oh0Var2.f15276b = jSONObject.getString("re_reply");
        oh0Var2.b(jSONObject.getLong("re_reply_time"));
        qh0Var.c = oh0Var2;
        return qh0Var;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return this.c.a();
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return this.c.f15276b;
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.c.f15275a;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
        try {
            jSONObject.put("reply_alias", this.f16522a.f15275a.mNickName);
            jSONObject.put("reply_user_icon", this.f16522a.f15275a.mIconUrl);
            jSONObject.put("re_reply_alias", this.c.f15275a.mNickName);
            jSONObject.put("re_reply_user_icon", this.c.f15275a.mIconUrl);
        } catch (JSONException unused) {
        }
    }
}
