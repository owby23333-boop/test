package com.duokan.account;

import android.text.TextUtils;
import com.duokan.reader.domain.account.User;
import com.xiaomi.ad.mediation.DspNameConstant;
import com.yuewen.cb4;
import com.yuewen.ea4;
import com.yuewen.i3;
import com.yuewen.openapi.track.TrackConstants;
import com.yuewen.wq2;
import fm.qingting.qtsdk.QTConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class p extends i3 {
    public String c;
    public final User f;
    public final ea4 g;
    public wq2 d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f2324a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f2325b = new b();
    public cb4 e = new cb4("");

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2327b;
        public String c;
        public long d;
        public String e;
        public String f;
        public String g;
        public String h;
        public String i;

        public static a a(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject2 == null) {
                jSONObject2 = jSONObject;
            }
            a aVar = new a();
            aVar.f2326a = jSONObject.optString(TrackConstants.OPENID);
            aVar.f2327b = jSONObject.optString("access_token");
            aVar.c = jSONObject.optString("unionid");
            aVar.d = jSONObject.optLong("expires_in");
            aVar.e = jSONObject.optString("scope");
            aVar.f = jSONObject.optString(QTConstant.REFRESH_TOKEN);
            aVar.g = jSONObject2.optString("nickname");
            aVar.h = jSONObject2.optString("avatarUrl");
            aVar.i = jSONObject2.optString("unionIdSign");
            return aVar;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TrackConstants.OPENID, this.f2326a);
                jSONObject.put("unionid", this.c);
                jSONObject.put("expires_in", this.d);
                jSONObject.put("scope", this.e);
                jSONObject.put("nickname", this.g);
                jSONObject.put("avatarUrl", this.h);
                jSONObject.put("unionIdSign", this.i);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2328a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2329b;
        public String c;
        public String d;

        public static b a(JSONObject jSONObject) {
            b bVar = new b();
            try {
                bVar.f2328a = jSONObject.optString("visitorId");
                bVar.f2329b = jSONObject.optString("visitorPassTokenMd5");
                bVar.d = jSONObject.optString("cVisitorId");
                bVar.c = jSONObject.optString("visitorPassToken");
            } catch (Throwable unused) {
            }
            return bVar;
        }

        public String toString() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("visitorId", this.f2328a);
                jSONObject.put("cVisitorId", this.d);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
    }

    public p() {
        User user = new User();
        this.f = user;
        ea4 ea4Var = new ea4();
        this.g = ea4Var;
        ea4Var.f10555a = user;
        ea4Var.f10556b = this.e;
    }

    public static p d(JSONObject jSONObject, JSONObject jSONObject2) {
        p pVar = new p();
        try {
            pVar.f2324a = a.a(jSONObject.getJSONObject("weixin"), TextUtils.isEmpty(jSONObject.getJSONObject(DspNameConstant.DSP_XIAOMI).optString("wechatData")) ? null : new JSONObject(jSONObject.getJSONObject(DspNameConstant.DSP_XIAOMI).optString("wechatData")));
            pVar.f2325b = b.a(jSONObject.getJSONObject(DspNameConstant.DSP_XIAOMI));
            pVar.c = jSONObject.optString("user_cert");
            User user = pVar.f;
            a aVar = pVar.f2324a;
            user.mIconUrl = aVar.h;
            user.mNickName = aVar.g;
            user.mUserId = pVar.f2325b.f2328a;
            user.mIsVip = false;
            String strOptString = jSONObject.optString("user_summary");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    pVar.e.a(new cb4(pVar.f2325b.f2328a, new JSONObject(strOptString)));
                } catch (Throwable unused) {
                }
            }
            if (jSONObject2 != null) {
                pVar.g(jSONObject2);
            }
        } catch (JSONException unused2) {
        }
        return pVar;
    }

    @Override // com.yuewen.i3
    public String b() {
        return this.f2324a.g;
    }

    @Override // com.yuewen.i3
    public String c() {
        cb4 cb4Var = this.e;
        return cb4Var != null ? cb4Var.i : "";
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("wx_access_token", this.f2324a.f2327b);
            jSONObject.put("wx_refresh_token", this.f2324a.f);
            jSONObject.put("mi_visitor_pass_token", this.f2325b.c);
            jSONObject.put("mi_visitor_pass_token_md5", this.f2325b.f2329b);
            wq2 wq2Var = this.d;
            if (wq2Var != null) {
                jSONObject.put("qingtingToken", wq2Var.toString());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public User f() {
        return this.f;
    }

    public void g(JSONObject jSONObject) {
        try {
            this.f2324a.f2327b = jSONObject.optString("wx_access_token");
            this.f2324a.f = jSONObject.optString("wx_refresh_token");
            this.f2325b.c = jSONObject.optString("mi_visitor_pass_token");
            this.f2325b.f2329b = jSONObject.optString("mi_visitor_pass_token_md5");
            this.d = wq2.a(jSONObject.optString("qingtingToken"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("weixin", new JSONObject(this.f2324a.toString()));
            jSONObject.put(DspNameConstant.DSP_XIAOMI, new JSONObject(this.f2325b.toString()));
            jSONObject.put("user_cert", this.c);
            wq2 wq2Var = this.d;
            if (wq2Var != null) {
                jSONObject.put("qingtingToken", wq2Var.toString());
            }
            cb4 cb4Var = this.e;
            if (cb4Var != null) {
                jSONObject.put("user_summary", cb4Var.b().toString());
            }
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }
}
