package com.yuewen;

import android.text.TextUtils;
import com.duokan.reader.domain.account.User;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class yz1 extends i3 {
    public static final int n = -1;
    public static final int o = 0;
    public static final int p = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20656a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f20657b = "";
    public wq2 c = null;
    public String d;
    public String e;
    public ea4 f;
    public aa4 g;
    public boolean h;
    public boolean i;
    public int j;
    public String[] k;
    public boolean l;
    public String m;

    public yz1(String str) {
        ea4 ea4Var = new ea4();
        this.f = ea4Var;
        ea4Var.f10555a = new User();
        ea4 ea4Var2 = this.f;
        User user = ea4Var2.f10555a;
        user.mUserId = str;
        ea4Var2.f10556b = new cb4(user);
        this.g = new aa4();
        this.h = false;
        this.i = true;
        this.j = -1;
        this.k = new String[0];
        this.l = false;
        this.m = "";
    }

    public static yz1 d(String str, String str2, String str3) {
        try {
            return e(str, new JSONObject(str2), new JSONObject(str3));
        } catch (Exception e) {
            yz1 yz1Var = new yz1("");
            e.printStackTrace();
            return yz1Var;
        }
    }

    public static yz1 e(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        yz1 yz1Var = new yz1("");
        try {
            ea4 ea4Var = new ea4();
            yz1Var.f = ea4Var;
            ea4Var.f10555a = new User();
            User user = yz1Var.f.f10555a;
            user.mUserId = str;
            user.mNickName = jSONObject.optString("miliaoNick");
            yz1Var.f.f10555a.mIconUrl = jSONObject.optString("miliaoIcon");
            if (!TextUtils.isEmpty(yz1Var.f.f10555a.mIconUrl)) {
                User user2 = yz1Var.f.f10555a;
                user2.mIconUrl = user2.mIconUrl.trim();
            }
            yz1Var.f20656a = jSONObject.optString("miPassToken");
            yz1Var.f20657b = jSONObject.optString("dushuServiceToken");
            if (jSONObject2 != null) {
                yz1Var.f20656a = jSONObject2.optString("miPassToken");
                yz1Var.f20657b = jSONObject2.optString("dushuServiceToken");
                yz1Var.c = wq2.a(jSONObject2.optString("qingtingToken"));
            }
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("user_summary");
            if (jSONObjectOptJSONObject == null) {
                ea4 ea4Var2 = yz1Var.f;
                ea4Var2.f10556b = new cb4(ea4Var2.f10555a.mUserId);
            } else {
                ea4 ea4Var3 = yz1Var.f;
                ea4Var3.f10556b = new cb4(ea4Var3.f10555a.mUserId, jSONObjectOptJSONObject);
            }
            ea4 ea4Var4 = yz1Var.f;
            ea4Var4.f10555a.mIsVip = ea4Var4.f10556b.f9593b;
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("user_feeds_summary");
            if (jSONObjectOptJSONObject2 == null) {
                yz1Var.g = new aa4();
            } else {
                yz1Var.g = new aa4(jSONObjectOptJSONObject2);
            }
            yz1Var.h = jSONObject.optBoolean("followings_auto_recommended");
            yz1Var.i = jSONObject.optBoolean("is_newbie", true);
            yz1Var.l = jSONObject.optBoolean("newbie_info_pending_commit", false);
            yz1Var.j = jSONObject.optInt(com.xiaomi.onetrack.api.at.f7541b, -1);
            yz1Var.k = np1.l(jSONObject, "interest_category");
            yz1Var.m = np1.k(jSONObject, "user_cert", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return yz1Var;
    }

    @Override // com.yuewen.i3
    public String b() {
        return !TextUtils.isEmpty(this.f.f10555a.mNickName) ? this.f.f10555a.mNickName : this.f.f10555a.mUserId;
    }

    @Override // com.yuewen.i3
    public String c() {
        return !TextUtils.isEmpty(this.f.f10556b.i) ? this.f.f10556b.i : "";
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", this.f.f10555a.mUserId);
            jSONObject.put("miliaoNick", this.f.f10555a.mNickName);
            jSONObject.put("miliaoIcon", this.f.f10555a.mIconUrl);
            cb4 cb4Var = this.f.f10556b;
            if (cb4Var != null) {
                jSONObject.put("user_summary", cb4Var.b());
            }
            aa4 aa4Var = this.g;
            if (aa4Var != null) {
                jSONObject.put("user_feeds_summary", aa4Var.a());
            }
            jSONObject.put("followings_auto_recommended", this.h);
            jSONObject.put("is_newbie", this.i);
            jSONObject.put(com.xiaomi.onetrack.api.at.f7541b, this.j);
            jSONObject.put("interest_category", np1.m(this.k));
            jSONObject.put("newbie_info_pending_commit", this.l);
            jSONObject.put("user_cert", this.m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }
}
