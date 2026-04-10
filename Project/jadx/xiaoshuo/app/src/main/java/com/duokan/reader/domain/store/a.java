package com.duokan.reader.domain.store;

import android.text.TextUtils;
import com.duokan.reader.domain.store.DkCommentDetailInfo;
import com.yuewen.bx2;
import com.yuewen.oh0;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final String f = "involved_time";
    public static final String g = "involved_type";
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5078b;
    public long c;
    public String d;
    public DkCommentDetailInfo e;

    public static a a(String str) throws JSONException {
        return b(new JSONObject(str));
    }

    public static a b(JSONObject jSONObject) throws JSONException {
        a aVar = new a();
        aVar.f5078b = jSONObject.getInt(g);
        aVar.c = jSONObject.getLong(f) + 28800;
        aVar.d = jSONObject.optString("reply");
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.m = jSONObject.getString("book_id");
        dkCommentDetailInfo.n = jSONObject.getString("book_name");
        dkCommentDetailInfo.r = jSONObject.getInt("comment_type") == 0 ? DkCommentDetailInfo.CommentBookType.BOOK : DkCommentDetailInfo.CommentBookType.FICTION;
        dkCommentDetailInfo.d(jSONObject.optLong("publish_time", System.currentTimeMillis() / 1000) + 28800);
        dkCommentDetailInfo.f14847a = jSONObject.getInt("useful");
        dkCommentDetailInfo.f14848b = jSONObject.getInt("useless");
        dkCommentDetailInfo.c = bx2.T1(jSONObject.getString("title"));
        dkCommentDetailInfo.d.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.d.mNickName = jSONObject.getString("nick_name");
        dkCommentDetailInfo.d.mIconUrl = jSONObject.optString("user_icon");
        dkCommentDetailInfo.e = jSONObject.getString("comment_id");
        dkCommentDetailInfo.f = bx2.T1(jSONObject.getString("content"));
        dkCommentDetailInfo.h = jSONObject.getInt("score");
        dkCommentDetailInfo.i = jSONObject.getString("device_type");
        dkCommentDetailInfo.g = jSONObject.optInt("reply_count");
        dkCommentDetailInfo.o = jSONObject.optString("link_cover");
        dkCommentDetailInfo.k = jSONObject.optBoolean("voted");
        dkCommentDetailInfo.j = new oh0[0];
        aVar.e = dkCommentDetailInfo;
        return aVar;
    }

    public static boolean c(a aVar, a aVar2) {
        return aVar.c == aVar2.c && aVar.f5078b == aVar2.f5078b && TextUtils.equals(aVar.e.e, aVar2.e.e) && TextUtils.equals(aVar.d, aVar2.d);
    }

    public static void e(a aVar, JSONObject jSONObject) throws JSONException {
        jSONObject.put("nick_name", aVar.e.d.mNickName);
        jSONObject.put("user_icon", aVar.e.d.mIconUrl);
    }

    public boolean d() {
        int i2 = this.f5078b;
        return i2 == 0 || i2 == 1 || i2 == 2;
    }
}
