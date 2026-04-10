package com.yuewen;

import com.duokan.reader.domain.account.User;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class b81 extends i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f9009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f9010b;
    public String c;
    public String d;
    public String e;
    public String f;
    public List<ed2> g;

    public static b81 e(String str) {
        try {
            return f(new JSONObject(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static b81 f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        b81 b81Var = new b81();
        b81Var.f9009a = jSONObject.optInt("user_type");
        b81Var.f9010b = jSONObject.optString(com.xiaomi.onetrack.api.at.d);
        b81Var.c = jSONObject.optString("nick_name");
        b81Var.d = jSONObject.optString("head_url");
        b81Var.e = jSONObject.optString("real_name");
        b81Var.f = jSONObject.optString("real_identity");
        b81Var.g = ed2.b(jSONObject.optJSONArray("open_ids"));
        return b81Var;
    }

    @Override // com.yuewen.i3
    public String b() {
        return this.c;
    }

    @Override // com.yuewen.i3
    public String c() {
        return null;
    }

    public void d(ed2 ed2Var) {
        if (this.g == null) {
            this.g = new LinkedList();
        }
        this.g.add(ed2Var);
    }

    public ed2 g() {
        for (ed2 ed2Var : this.g) {
            if (ed2Var.f10570b == 5) {
                return ed2Var;
            }
        }
        return null;
    }

    public e9 h() {
        return new e9(g());
    }

    public ea4 i(String str) {
        ea4 ea4Var = new ea4();
        User user = new User();
        ea4Var.f10555a = user;
        user.mUserId = str;
        user.mNickName = this.c;
        user.mIconUrl = this.d;
        return ea4Var;
    }

    public ed2 j() {
        for (ed2 ed2Var : this.g) {
            if (ed2Var.f10570b == 3) {
                return ed2Var;
            }
        }
        return null;
    }

    public void k(String str, String str2) {
        this.e = str;
        this.f = str2;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("user_type", this.f9009a);
            jSONObject.put(com.xiaomi.onetrack.api.at.d, this.f9010b);
            jSONObject.put("nick_name", this.c);
            jSONObject.put("head_url", this.d);
            jSONObject.put("real_name", this.e);
            jSONObject.put("real_identity", this.f);
            List<ed2> list = this.g;
            if (list != null && list.size() > 0) {
                jSONObject.putOpt("open_ids", ed2.c(this.g));
            }
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }
}
