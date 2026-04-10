package com.anythink.core.common.a;

import android.text.TextUtils;
import com.anythink.basead.b.a;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ac;
import com.anythink.core.common.e.k;
import com.anythink.core.common.l;
import com.anythink.expressad.foundation.d.r;
import com.bytedance.msdk.api.v2.GMAdConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static com.anythink.core.common.e.g a(String str, JSONObject jSONObject, int i2) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(g.c.f6826d);
            if (jSONObjectOptJSONObject != null) {
                jSONObject = jSONObjectOptJSONObject;
            } else if (!jSONObject.has("seatbid")) {
                return null;
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONArray("seatbid").optJSONObject(0);
            com.anythink.core.common.e.g gVar = new com.anythink.core.common.e.g();
            gVar.b(str);
            gVar.j(jSONObjectOptJSONObject2.optString(l.ad));
            gVar.k(jSONObjectOptJSONObject2.optString(GMAdConstant.EXTRA_CID));
            gVar.w(jSONObjectOptJSONObject2.optString("pkg"));
            gVar.l(jSONObjectOptJSONObject2.optString("title"));
            gVar.m(jSONObjectOptJSONObject2.optString("desc"));
            gVar.f(jSONObjectOptJSONObject2.optInt(com.anythink.expressad.foundation.d.c.Y));
            gVar.n(jSONObjectOptJSONObject2.optString("icon_u"));
            gVar.p(jSONObjectOptJSONObject2.optString("full_u"));
            gVar.d(jSONObjectOptJSONObject2.optInt("unit_type"));
            gVar.q(jSONObjectOptJSONObject2.optString("tp_logo_u"));
            gVar.r(jSONObjectOptJSONObject2.optString(a.C0132a.f5846k));
            gVar.s(jSONObjectOptJSONObject2.optString("video_u"));
            gVar.d(jSONObjectOptJSONObject2.optInt("video_l"));
            gVar.J(jSONObjectOptJSONObject2.optString("video_r"));
            gVar.K(jSONObjectOptJSONObject2.optString("ec_u"));
            gVar.t(jSONObjectOptJSONObject2.optString("store_u"));
            gVar.e(jSONObjectOptJSONObject2.optInt("link_type"));
            gVar.v(jSONObjectOptJSONObject2.optString("click_u"));
            gVar.u(jSONObjectOptJSONObject2.optString("deeplink"));
            gVar.j(jSONObjectOptJSONObject2.optInt("crt_type", 1));
            gVar.L(jSONObjectOptJSONObject2.optString("img_list"));
            gVar.M(jSONObjectOptJSONObject2.optString("banner_xhtml"));
            gVar.c(jSONObjectOptJSONObject2.optInt("offer_firm_id"));
            gVar.i(jSONObjectOptJSONObject2.optString("jump_url"));
            try {
                String strOptString = jSONObjectOptJSONObject2.optString("sdk_resp");
                if (!TextUtils.isEmpty(strOptString)) {
                    gVar.a(new JSONObject(strOptString).optString("data"));
                }
            } catch (Throwable unused) {
            }
            gVar.N(jSONObjectOptJSONObject2.optString("app_name"));
            gVar.y(jSONObjectOptJSONObject2.optString("publisher"));
            gVar.z(jSONObjectOptJSONObject2.optString("app_version"));
            gVar.A(jSONObjectOptJSONObject2.optString("privacy"));
            gVar.B(jSONObjectOptJSONObject2.optString("permission"));
            gVar.h(jSONObjectOptJSONObject2.optString("mtr_ver"));
            gVar.k(jSONObjectOptJSONObject2.optInt("o_im_cap_sw", 2));
            gVar.l(jSONObjectOptJSONObject2.optInt("o_cl_cap_sw", 2));
            gVar.m(jSONObjectOptJSONObject2.optInt("c_im_cap_sw", 2));
            gVar.n(jSONObjectOptJSONObject2.optInt("c_cl_cap_sw", 2));
            gVar.a(jSONObjectOptJSONObject2.optLong("expire", 0L));
            if (i2 == 67) {
                gVar.a(2);
            } else {
                gVar.a(1);
            }
            gVar.a((k) ab.c(jSONObjectOptJSONObject2.optString("ctrl")));
            gVar.a(ac.a(jSONObjectOptJSONObject2.optString("tk")));
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject2.optString("nw_info"));
                gVar.E(jSONObject2.optString("app_id"));
                gVar.F(jSONObject2.optString("app_key"));
                gVar.G(jSONObject2.optString("unit_id"));
            } catch (Throwable unused2) {
            }
            gVar.H(jSONObjectOptJSONObject2.optString("dsp_id", ""));
            gVar.I(jSONObjectOptJSONObject2.optString("dsp_oid", ""));
            gVar.h(jSONObjectOptJSONObject2.optInt(com.anythink.expressad.foundation.d.c.T, -1));
            gVar.i(jSONObjectOptJSONObject2.optInt("install_sw", -1));
            gVar.C(jSONObjectOptJSONObject2.optString("wv_ctrl"));
            gVar.b(jSONObjectOptJSONObject2.optInt("adp_type"));
            gVar.e(jSONObjectOptJSONObject2.optString("offer_html"));
            gVar.f(jSONObjectOptJSONObject2.optString(r.ab));
            gVar.c(jSONObjectOptJSONObject2.optString("wx_username"));
            gVar.d(jSONObjectOptJSONObject2.optString("wx_path"));
            return gVar;
        } catch (Throwable unused3) {
            return null;
        }
    }
}
