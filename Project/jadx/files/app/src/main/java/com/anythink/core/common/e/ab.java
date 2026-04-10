package com.anythink.core.common.e;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ab extends k {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7107n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f7108o;

    private void P(int i2) {
        this.f7108o = i2;
    }

    private void Q(int i2) {
        this.f7107n = i2;
    }

    public static ab c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ab abVar = new ab();
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                abVar.q(jSONObject.optInt("f_t"));
                int iOptInt = jSONObject.optInt("v_c");
                if (iOptInt == 1) {
                    iOptInt = 0;
                } else if (iOptInt == 2) {
                    iOptInt = 1;
                }
                abVar.r(iOptInt);
                abVar.s(jSONObject.optInt("s_b_t"));
                if (jSONObject.has("s_b_d")) {
                    abVar.t(jSONObject.optInt("s_b_d"));
                }
                int iOptInt2 = jSONObject.optInt("e_c_a");
                if (iOptInt2 == 1) {
                    iOptInt2 = 0;
                } else if (iOptInt2 == 2) {
                    iOptInt2 = 1;
                } else if (iOptInt2 == 3) {
                    iOptInt2 = 2;
                }
                abVar.u(iOptInt2);
                int iOptInt3 = jSONObject.optInt("ak_cfm");
                if (iOptInt3 == 1) {
                    iOptInt3 = 0;
                } else if (iOptInt3 == 2) {
                    iOptInt3 = 1;
                }
                abVar.m(iOptInt3);
                abVar.l(jSONObject.optInt("m_t"));
                int iOptInt4 = jSONObject.optInt("cm");
                if (iOptInt4 == 1) {
                    iOptInt4 = 0;
                } else if (iOptInt4 == 2) {
                    iOptInt4 = 1;
                }
                abVar.f7107n = iOptInt4;
                abVar.c(jSONObject.optInt("ipua"));
                abVar.d(jSONObject.optInt("clua"));
                abVar.k(jSONObject.optInt("dp_cm"));
                abVar.f7108o = jSONObject.optInt("l_o_num");
                abVar.j(jSONObject.optInt("ld_t"));
                abVar.x(jSONObject.optInt("ec_r"));
                abVar.y(jSONObject.optInt("ec_s_t"));
                abVar.z(jSONObject.optInt("ec_l_t"));
                abVar.a(jSONObject.optLong("or_t"));
                abVar.e(jSONObject.optInt("rv_fail_reward"));
                abVar.f(jSONObject.optInt("cl_sz"));
                abVar.i(jSONObject.optInt("si_fit"));
                if (jSONObject.has("at_cl_sw")) {
                    abVar.A(jSONObject.optInt("at_cl_sw"));
                }
                if (jSONObject.has("at_ct_ti")) {
                    abVar.B(jSONObject.optInt("at_ct_ti"));
                }
                if (jSONObject.has("int_cl_sw")) {
                    abVar.C(jSONObject.optInt("int_cl_sw"));
                }
                if (jSONObject.has("int_cl_ti")) {
                    abVar.D(jSONObject.optInt("int_cl_ti"));
                }
                if (jSONObject.has("sh_ec")) {
                    abVar.E(jSONObject.optInt("sh_ec"));
                }
                if (jSONObject.has("ap_arpt")) {
                    abVar.F(jSONObject.optInt("ap_arpt"));
                }
                if (jSONObject.has("ap_pasbl")) {
                    abVar.G(jSONObject.optInt("ap_pasbl"));
                }
                if (jSONObject.has("inter_type")) {
                    abVar.b(jSONObject.optString("inter_type"));
                }
                if (jSONObject.has("shk_sw")) {
                    abVar.H(jSONObject.optInt("shk_sw"));
                }
                if (jSONObject.has("shk_strength_and")) {
                    abVar.I(jSONObject.optInt("shk_strength_and"));
                }
                if (jSONObject.has("shk_time")) {
                    abVar.d(jSONObject.optLong("shk_time"));
                }
                if (jSONObject.has("click_cache_time")) {
                    abVar.J(jSONObject.optInt("click_cache_time"));
                }
                if (jSONObject.has("click_nt_sw")) {
                    abVar.K(jSONObject.optInt("click_nt_sw"));
                }
                if (jSONObject.has("ft_cl_sz")) {
                    abVar.g(jSONObject.optInt("ft_cl_sz"));
                } else {
                    abVar.g(1);
                }
                if (jSONObject.has("sh_cl_itp")) {
                    abVar.h(jSONObject.optInt("sh_cl_itp"));
                } else {
                    abVar.h(2);
                }
                abVar.L(jSONObject.optInt("shm_t", -1));
                if (jSONObject.has("ready_rate")) {
                    abVar.M(jSONObject.optInt("ready_rate"));
                } else {
                    abVar.M(100);
                }
                if (jSONObject.has("rsdl_rate")) {
                    abVar.N(jSONObject.optInt("rsdl_rate"));
                } else {
                    abVar.N(0);
                }
                if (jSONObject.has("video_ctn_type")) {
                    abVar.O(jSONObject.optInt("video_ctn_type"));
                } else {
                    abVar.O(2);
                }
                if (jSONObject.has("preload_offer_html")) {
                    abVar.a(jSONObject.optInt("preload_offer_html") == 1);
                } else {
                    abVar.a(true);
                }
                if (jSONObject.has("re_monitor")) {
                    boolean z2 = true;
                    if (jSONObject.optInt("re_monitor") != 1) {
                        z2 = false;
                    }
                    abVar.b(z2);
                } else {
                    abVar.b(false);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return abVar;
    }

    public final int X() {
        return this.f7108o;
    }

    public final int Y() {
        return this.f7107n;
    }
}
