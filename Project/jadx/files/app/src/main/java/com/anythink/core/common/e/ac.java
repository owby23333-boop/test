package com.anythink.core.common.e;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class ac implements Serializable {
    String[] A;
    String[] B;
    String[] C;
    String[] D;
    String[] E;
    Map<Integer, String[]> F;
    String[] G;
    String[] H;
    String I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O;
    String P;
    String Q;
    String R;
    String S;
    String T;
    String U;
    String V;
    String W;
    String X;
    String Y;
    String Z;
    String a;
    String aa;
    String ab;
    String ac;
    String ad;
    String ae;
    String af;
    String ag;
    String ah;
    String ai;
    String aj;
    String ak;
    String al;
    String am;
    String an;
    String[] ao;
    String ap;
    String[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String[] f7109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String[] f7110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String[] f7111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String[] f7112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    String[] f7113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String[] f7114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    String[] f7115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String[] f7116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    String[] f7117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    String[] f7118l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    String[] f7119m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    String[] f7120n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    String[] f7121o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    String[] f7122p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    String[] f7123q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    String[] f7124r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    String[] f7125s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    String[] f7126t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    String[] f7127u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    String[] f7128v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    String[] f7129w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    String[] f7130x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    String[] f7131y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    String[] f7132z;

    public static final ac a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            ac acVar = new ac();
            acVar.a = jSONObject.optString("ks");
            acVar.b = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("nurl"));
            acVar.f7109c = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("imp"));
            acVar.f7110d = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("click"));
            acVar.f7111e = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vstart"));
            acVar.f7112f = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v25"));
            acVar.f7113g = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v50"));
            acVar.f7114h = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v75"));
            acVar.f7115i = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("v100"));
            acVar.f7116j = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vpaused"));
            acVar.f7117k = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vclick"));
            acVar.f7118l = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vmute"));
            acVar.f7119m = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vunmute"));
            acVar.f7120n = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("ec_show"));
            acVar.f7121o = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("ec_close"));
            acVar.f7122p = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("apk_dl_star"));
            acVar.f7123q = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("apk_dl_end"));
            acVar.f7124r = com.anythink.core.common.k.h.a(jSONObject.optJSONArray(com.anythink.expressad.foundation.d.h.cM));
            acVar.f7125s = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vresumed"));
            acVar.f7126t = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vskip"));
            acVar.f7127u = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vfail"));
            acVar.f7128v = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("apk_start_install"));
            acVar.f7129w = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_start"));
            acVar.f7130x = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_succ"));
            acVar.f7131y = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("app_install"));
            acVar.f7132z = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("app_uninstall"));
            acVar.A = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("app_unknow"));
            acVar.C = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_inst_fail"));
            acVar.B = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("dp_uninst_fail"));
            acVar.D = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vd_succ"));
            acVar.E = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vrewarded"));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("v_p_tracking");
            if (jSONArrayOptJSONArray != null) {
                acVar.F = new HashMap();
                for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i2);
                    int iOptInt = jSONObjectOptJSONObject.optInt("play_sec");
                    acVar.F.put(Integer.valueOf(iOptInt), com.anythink.core.common.k.h.a(jSONObjectOptJSONObject.optJSONArray("list")));
                }
            }
            acVar.G = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("load_success"));
            acVar.H = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("load_fail"));
            acVar.I = jSONObject.optString("tp_nurl");
            acVar.J = jSONObject.optString("tp_imp");
            acVar.K = jSONObject.optString("tp_click");
            acVar.L = jSONObject.optString("tp_vstart");
            acVar.M = jSONObject.optString("tp_v25");
            acVar.N = jSONObject.optString("tp_v50");
            acVar.O = jSONObject.optString("tp_v75");
            acVar.P = jSONObject.optString("tp_v100");
            acVar.Q = jSONObject.optString("tp_vpaused");
            acVar.R = jSONObject.optString("tp_vclick");
            acVar.S = jSONObject.optString("tp_vmute");
            acVar.T = jSONObject.optString("tp_vunmute");
            acVar.U = jSONObject.optString("tp_ec_show");
            acVar.V = jSONObject.optString("tp_ec_close");
            acVar.W = jSONObject.optString("tp_apk_dl_star");
            acVar.X = jSONObject.optString("tp_apk_dl_end");
            acVar.Y = jSONObject.optString("tp_apk_install");
            acVar.Z = jSONObject.optString("tp_vresumed");
            acVar.aa = jSONObject.optString("tp_vskip");
            acVar.ab = jSONObject.optString("tp_vfail");
            acVar.ac = jSONObject.optString("tp_apk_start_install");
            acVar.ad = jSONObject.optString("tp_dp_start");
            acVar.ae = jSONObject.optString("tp_dp_succ");
            acVar.af = jSONObject.optString("tp_app_install");
            acVar.ag = jSONObject.optString("tp_app_uninstall");
            acVar.ah = jSONObject.optString("tp_app_unknow");
            acVar.aj = jSONObject.optString("tp_dp_inst_fail");
            acVar.ai = jSONObject.optString("tp_dp_uninst_fail");
            acVar.ak = jSONObject.optString("tp_vd_succ");
            acVar.al = jSONObject.optString("tp_vrewarded");
            acVar.am = jSONObject.optString("tp_load_success");
            acVar.an = jSONObject.optString("tp_load_fail");
            acVar.ao = com.anythink.core.common.k.h.a(jSONObject.optJSONArray("vready"));
            acVar.ap = jSONObject.optString("tp_ready");
            return acVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final String A() {
        return this.J;
    }

    public final String B() {
        return this.K;
    }

    public final String C() {
        return this.L;
    }

    public final String D() {
        return this.M;
    }

    public final String E() {
        return this.N;
    }

    public final String F() {
        return this.O;
    }

    public final String G() {
        return this.P;
    }

    public final String H() {
        return this.Q;
    }

    public final String I() {
        return this.R;
    }

    public final String J() {
        return this.S;
    }

    public final String K() {
        return this.T;
    }

    public final String L() {
        return this.U;
    }

    public final String M() {
        return this.V;
    }

    public final String N() {
        return this.W;
    }

    public final String O() {
        return this.X;
    }

    public final String P() {
        return this.Y;
    }

    public final String[] Q() {
        return this.f7125s;
    }

    public final String[] R() {
        return this.f7126t;
    }

    public final String[] S() {
        return this.f7127u;
    }

    public final String[] T() {
        return this.f7128v;
    }

    public final String[] U() {
        return this.f7129w;
    }

    public final String[] V() {
        return this.f7130x;
    }

    public final String[] W() {
        return this.f7131y;
    }

    public final String[] X() {
        return this.f7132z;
    }

    public final String[] Y() {
        return this.A;
    }

    public final String Z() {
        return this.Z;
    }

    public final String aa() {
        return this.aa;
    }

    public final String ab() {
        return this.ab;
    }

    public final String ac() {
        return this.ac;
    }

    public final String ad() {
        return this.ad;
    }

    public final String ae() {
        return this.ae;
    }

    public final String af() {
        return this.af;
    }

    public final String ag() {
        return this.ag;
    }

    public final String ah() {
        return this.ah;
    }

    public final String ai() {
        return this.ai;
    }

    public final String aj() {
        return this.aj;
    }

    public final String ak() {
        return this.ak;
    }

    public final String al() {
        return this.al;
    }

    public final String am() {
        return this.am;
    }

    public final String an() {
        return this.an;
    }

    public final String[] ao() {
        return this.ao;
    }

    public final String ap() {
        return this.ap;
    }

    public final void b(String[] strArr) {
        this.f7122p = strArr;
    }

    public final void c(String[] strArr) {
        this.f7123q = strArr;
    }

    public final void d(String[] strArr) {
        this.f7124r = strArr;
    }

    public final String[] e() {
        return this.f7109c;
    }

    public final String[] f() {
        return this.f7110d;
    }

    public final String[] g() {
        return this.f7111e;
    }

    public final String[] h() {
        return this.f7112f;
    }

    public final String[] i() {
        return this.f7113g;
    }

    public final String[] j() {
        return this.f7114h;
    }

    public final String[] k() {
        return this.f7115i;
    }

    public final String[] l() {
        return this.f7116j;
    }

    public final String[] m() {
        return this.f7117k;
    }

    public final String[] n() {
        return this.f7118l;
    }

    public final String[] o() {
        return this.f7119m;
    }

    public final String[] p() {
        return this.f7120n;
    }

    public final String[] q() {
        return this.f7121o;
    }

    public final String[] r() {
        return this.f7122p;
    }

    public final String[] s() {
        return this.f7123q;
    }

    public final String[] t() {
        return this.f7124r;
    }

    public final String[] u() {
        return this.B;
    }

    public final String[] v() {
        return this.C;
    }

    public final String[] w() {
        return this.D;
    }

    public final String[] x() {
        return this.E;
    }

    public final Map<Integer, String[]> y() {
        return this.F;
    }

    public final String z() {
        return this.I;
    }

    public final String[] b() {
        return this.H;
    }

    public final String c() {
        return this.a;
    }

    public final String[] d() {
        return this.b;
    }

    public final void a(String[] strArr) {
        this.f7110d = strArr;
    }

    public final String[] a() {
        return this.G;
    }
}
