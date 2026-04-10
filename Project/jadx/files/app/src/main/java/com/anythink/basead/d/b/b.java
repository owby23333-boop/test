package com.anythink.basead.d.b;

import com.anythink.basead.b.a;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.z;
import com.anythink.core.common.l;
import com.anythink.expressad.foundation.d.c;
import com.anythink.expressad.foundation.d.r;
import com.bytedance.msdk.api.v2.GMAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final String a = "sdk_updatetime";

    public static final z a(j jVar, JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(g.c.f6826d);
            if (jSONObjectOptJSONObject == null) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONArray("offers").optJSONObject(0);
            z zVar = new z();
            zVar.a(jVar.f7305f);
            zVar.j(jSONObjectOptJSONObject2.optString(l.ad));
            zVar.k(jSONObjectOptJSONObject2.optString(GMAdConstant.EXTRA_CID));
            zVar.w(jSONObjectOptJSONObject2.optString("pkg"));
            zVar.l(jSONObjectOptJSONObject2.optString("title"));
            zVar.m(jSONObjectOptJSONObject2.optString("desc"));
            zVar.f(jSONObjectOptJSONObject2.optInt(c.Y));
            zVar.n(jSONObjectOptJSONObject2.optString("icon_u"));
            zVar.p(jSONObjectOptJSONObject2.optString("full_u"));
            zVar.d(jSONObjectOptJSONObject2.optInt("unit_type"));
            zVar.q(jSONObjectOptJSONObject2.optString("tp_logo_u"));
            zVar.r(jSONObjectOptJSONObject2.optString(a.C0132a.f5846k));
            zVar.s(jSONObjectOptJSONObject2.optString("video_u"));
            zVar.d(jSONObjectOptJSONObject2.optInt("video_l"));
            zVar.J(jSONObjectOptJSONObject2.optString("video_r"));
            zVar.K(jSONObjectOptJSONObject2.optString("ec_u"));
            zVar.t(jSONObjectOptJSONObject2.optString("store_u"));
            zVar.e(jSONObjectOptJSONObject2.optInt("link_type"));
            zVar.v(jSONObjectOptJSONObject2.optString("click_u"));
            zVar.u(jSONObjectOptJSONObject2.optString("deeplink"));
            zVar.g(jSONObjectOptJSONObject2.optInt("r_target"));
            zVar.a(jSONObjectOptJSONObject2.optLong("expire"));
            zVar.x(jSONObjectOptJSONObject2.optString("ad_logo_title"));
            zVar.j(jSONObjectOptJSONObject2.optInt("crt_type", 1));
            zVar.L(jSONObjectOptJSONObject2.optString("img_list"));
            zVar.M(jSONObjectOptJSONObject2.optString("banner_xhtml"));
            zVar.b(jSONObject.optLong(a));
            zVar.c(jSONObjectOptJSONObject2.optInt("offer_firm_id"));
            zVar.i(jSONObjectOptJSONObject2.optString("jump_url"));
            zVar.N(jSONObjectOptJSONObject2.optString("app_name"));
            zVar.y(jSONObjectOptJSONObject2.optString("publisher"));
            zVar.z(jSONObjectOptJSONObject2.optString("app_version"));
            zVar.A(jSONObjectOptJSONObject2.optString("privacy"));
            zVar.B(jSONObjectOptJSONObject2.optString("permission"));
            zVar.C(jSONObjectOptJSONObject2.optString("wv_ctrl"));
            zVar.a((k) ab.c(jSONObjectOptJSONObject2.optString("ctrl")));
            zVar.a(ac.a(jSONObjectOptJSONObject2.optString("tk")));
            zVar.b(jSONObjectOptJSONObject2.optInt("adp_type"));
            zVar.e(jSONObjectOptJSONObject2.optString("offer_html"));
            zVar.f(jSONObjectOptJSONObject2.optString(r.ab));
            zVar.c(jSONObjectOptJSONObject2.optString("wx_username"));
            zVar.d(jSONObjectOptJSONObject2.optString("wx_path"));
            return zVar;
        } catch (Throwable unused) {
            return null;
        }
    }
}
