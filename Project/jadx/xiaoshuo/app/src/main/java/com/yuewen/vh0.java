package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkCommentDetailInfo;
import com.yuewen.bm0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class vh0 extends bm0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public uh0 f19029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DkCommentDetailInfo f19030b;

    public static vh0 e(JSONObject jSONObject) throws JSONException {
        vh0 vh0Var = new vh0();
        uh0 uh0Var = new uh0();
        uh0Var.f18460a.mUserId = jSONObject.getString("reply_user_id");
        uh0Var.f18460a.mNickName = jSONObject.getString("reply_alias");
        uh0Var.f18461b = jSONObject.getLong("reply_time");
        vh0Var.f19029a = uh0Var;
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.d.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.e = jSONObject.getString("comment_id");
        dkCommentDetailInfo.m = jSONObject.getString("book_id");
        dkCommentDetailInfo.f = jSONObject.getString("comment");
        vh0Var.f19030b = dkCommentDetailInfo;
        return vh0Var;
    }

    @Override // com.yuewen.bm0.a
    public long a() {
        return this.f19029a.f18461b;
    }

    @Override // com.yuewen.bm0.a
    public String b() {
        return "";
    }

    @Override // com.yuewen.bm0.a
    public User c() {
        return this.f19029a.f18460a;
    }

    @Override // com.yuewen.bm0.a
    public void d(JSONObject jSONObject) {
    }
}
