package com.yuewen;

import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.store.DkCommentDetailInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class nh0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14847a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14848b = 0;
    public String c = "";
    public final User d = new User();
    public String e = "";
    public String f = "";
    public int g = 0;
    public int h = 0;
    public String i = "";
    public oh0[] j = new oh0[0];
    public boolean k = false;
    public long l;

    public static void a(nh0 nh0Var, nh0 nh0Var2) {
        nh0Var2.f14847a = nh0Var.f14847a;
        nh0Var2.f14848b = nh0Var.f14848b;
        nh0Var2.c = nh0Var.c;
        User.copy(nh0Var.d, nh0Var2.d);
        nh0Var2.e = nh0Var.e;
        nh0Var2.f = nh0Var.f;
        nh0Var2.g = nh0Var.g;
        nh0Var2.h = nh0Var.h;
        nh0Var2.i = nh0Var.i;
        nh0Var2.j = nh0Var.j;
        nh0Var2.k = nh0Var.k;
        nh0Var2.l = nh0Var.l;
    }

    public static nh0 b(JSONObject jSONObject) throws Exception {
        nh0 nh0Var = new nh0();
        nh0Var.d(jSONObject.optLong(DkCommentDetailInfo.s, System.currentTimeMillis() / 1000) + 28800);
        nh0Var.f14847a = jSONObject.getInt("useful");
        nh0Var.f14848b = jSONObject.getInt("useless");
        nh0Var.c = bx2.T1(jSONObject.getString("title"));
        nh0Var.d.mUserId = jSONObject.getString("user_id");
        nh0Var.d.mNickName = jSONObject.getString("nick_name");
        nh0Var.e = jSONObject.getString("comment_id");
        nh0Var.f = bx2.T1(jSONObject.getString("content"));
        nh0Var.h = jSONObject.getInt("score");
        nh0Var.i = jSONObject.getString("device_type");
        nh0Var.k = jSONObject.optBoolean("voted");
        int iOptInt = jSONObject.optInt("reply_count");
        nh0Var.g = iOptInt;
        if (iOptInt > 0) {
            JSONArray jSONArray = jSONObject.getJSONArray("reply");
            nh0Var.j = new oh0[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                nh0Var.j[i] = new oh0();
                nh0Var.j[i].f15275a.mUserId = jSONObject2.getString("user_id");
                nh0Var.j[i].f15275a.mNickName = jSONObject2.getString("nick_name");
                nh0Var.j[i].f15276b = jSONObject2.getString("content");
                nh0Var.j[i].b(jSONObject2.optLong(DkCommentDetailInfo.s, System.currentTimeMillis() / 1000) + 28800);
                nh0Var.j[i].c = jSONObject2.getString("reply_id");
                nh0Var.j[i].d = jSONObject2.optString("reply_to", null);
                nh0Var.j[i].e = jSONObject2.getString("device_type");
            }
        }
        return nh0Var;
    }

    public long c() {
        return this.l;
    }

    public void d(long j) {
        this.l = j;
    }

    public void e(int i, int i2) {
        this.f14847a = i;
        this.f14848b = i2;
    }

    public void f() {
        if (this.k) {
            return;
        }
        this.k = true;
        this.f14847a++;
    }
}
