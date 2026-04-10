package com.duokan.reader.domain.store;

import com.yuewen.nh0;
import com.yuewen.oh0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DkCommentDetailInfo extends nh0 {
    public static final String s = "publish_utc_time";
    public String m = null;
    public String n = null;
    public String o = null;
    public String p = null;
    public String q = null;
    public CommentBookType r = CommentBookType.BOOK;

    public enum CommentBookType {
        UNKNOWN,
        BOOK,
        FICTION
    }

    public static DkCommentDetailInfo g(nh0 nh0Var, String str, String str2, String str3, CommentBookType commentBookType) {
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        nh0.a(nh0Var, dkCommentDetailInfo);
        dkCommentDetailInfo.m = str;
        dkCommentDetailInfo.n = str2;
        dkCommentDetailInfo.o = str3;
        dkCommentDetailInfo.r = commentBookType;
        return dkCommentDetailInfo;
    }

    public static DkCommentDetailInfo h(String str) throws JSONException {
        return i(new JSONObject(str));
    }

    public static DkCommentDetailInfo i(JSONObject jSONObject) throws JSONException {
        DkCommentDetailInfo dkCommentDetailInfo = new DkCommentDetailInfo();
        dkCommentDetailInfo.m = jSONObject.getString("book_id");
        dkCommentDetailInfo.n = jSONObject.optString("book_name", "");
        dkCommentDetailInfo.o = jSONObject.optString("cover_url");
        dkCommentDetailInfo.p = jSONObject.optString("authors", "");
        dkCommentDetailInfo.q = jSONObject.optString("editors", "");
        dkCommentDetailInfo.d(jSONObject.optLong(s, System.currentTimeMillis() / 1000) + 28800);
        dkCommentDetailInfo.r = jSONObject.getInt("comment_type") == 0 ? CommentBookType.BOOK : CommentBookType.FICTION;
        dkCommentDetailInfo.f14847a = jSONObject.getInt("useful");
        dkCommentDetailInfo.f14848b = jSONObject.getInt("useless");
        dkCommentDetailInfo.c = jSONObject.getString("title");
        dkCommentDetailInfo.d.mUserId = jSONObject.getString("user_id");
        dkCommentDetailInfo.d.mNickName = jSONObject.getString("nick_name");
        dkCommentDetailInfo.d.mIconUrl = jSONObject.optString("user_icon");
        dkCommentDetailInfo.e = jSONObject.getString("comment_id");
        dkCommentDetailInfo.f = jSONObject.getString("content");
        dkCommentDetailInfo.h = jSONObject.getInt("score");
        dkCommentDetailInfo.i = jSONObject.getString("device_type");
        dkCommentDetailInfo.g = jSONObject.optInt("reply_count");
        dkCommentDetailInfo.o = jSONObject.optString("link_cover");
        dkCommentDetailInfo.k = jSONObject.optBoolean("voted");
        if (dkCommentDetailInfo.g > 0) {
            JSONArray jSONArray = jSONObject.getJSONArray("reply");
            dkCommentDetailInfo.j = new oh0[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                dkCommentDetailInfo.j[i] = new oh0(jSONArray.getJSONObject(i));
            }
        }
        return dkCommentDetailInfo;
    }

    public static void j(DkCommentDetailInfo dkCommentDetailInfo, JSONObject jSONObject) throws JSONException {
        jSONObject.put("nick_name", dkCommentDetailInfo.d.mNickName);
        jSONObject.put("user_icon", dkCommentDetailInfo.d.mIconUrl);
        if (dkCommentDetailInfo.g > 0) {
            JSONArray jSONArray = jSONObject.getJSONArray("reply");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                String string = jSONObject2.getString("reply_id");
                oh0[] oh0VarArr = dkCommentDetailInfo.j;
                int length = oh0VarArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        oh0 oh0Var = oh0VarArr[i2];
                        if (oh0Var.c.equals(string)) {
                            jSONObject2.put("nick_name", oh0Var.f15275a.mNickName);
                            jSONObject2.put("user_icon", oh0Var.f15275a.mIconUrl);
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
    }
}
