package com.alipay.sdk.m.o;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.y.f;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.m;
import com.alipay.sdk.m.y.q;
import com.duokan.dksearch.ui.b;
import com.xiaomi.ad.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final String A0 = "start_trans";
    public static final String B0 = "up_before_pay";
    public static final String C0 = "lck_k";
    public static final String D0 = "use_sc_lck_a";
    public static final String E0 = "utdid_factor";
    public static final String F0 = "cfg_max_time";
    public static final String G0 = "get_oa_id";
    public static final String H0 = "notifyFailApp";
    public static final String I0 = "startactivity_in_ui_thread";
    public static final String J0 = "optimize_trans_activity_degrade";
    public static final String K0 = "register_app_degrade_2";
    public static final String L0 = "sdk_pre_heat";
    public static final String M = "DynCon";
    public static final String M0 = "external_sdk_data_degrade";
    public static final int N = 10000;
    public static final String N0 = "local_web_pay";
    public static final String O = "https://h5.m.taobao.com/mlapp/olist.html";
    public static final String O0 = "degrade_web_ua_version";
    public static final int P = 10;
    public static final String P0 = "intercept_batch";
    public static final boolean Q = true;
    public static final String Q0 = "debug_upgrade_warn";
    public static final boolean R = false;
    public static final String R0 = "fetch_config_when_register_app";
    public static final boolean S = true;
    public static final String S0 = "gray_log_print_performance";
    public static final boolean T = true;
    public static final String T0 = "enable_china_mobile_bridge_mode";
    public static final boolean U = false;
    public static final String U0 = "bind_with_startActivity";
    public static final boolean V = true;
    public static final String V0 = "enableStartActivityFallback";
    public static final boolean W = false;
    public static final String W0 = "enableBindExFallback";
    public static final boolean X = false;
    public static final String X0 = "degrade_exit_local_web_pay_on_back";
    public static final boolean Y = false;
    public static b Y0 = null;
    public static final boolean Z = true;
    public static final String a0 = "";
    public static final boolean b0 = false;
    public static final boolean c0 = false;
    public static final int d0 = 1000;
    public static final boolean e0 = true;
    public static final String f0 = "";
    public static final boolean g0 = false;
    public static final boolean h0 = false;
    public static final int i0 = 1000;
    public static final int j0 = 20000;
    public static final boolean k0 = false;
    public static final boolean l0 = false;
    public static final String m0 = "alipay_cashier_dynamic_config";
    public static final String n0 = "timeout";
    public static final String o0 = "h5_port_degrade";
    public static final String p0 = "st_sdk_config";
    public static final String q0 = "tbreturl";
    public static final String r0 = "launchAppSwitch";
    public static final String s0 = "configQueryInterval";
    public static final String t0 = "deg_log_mcgw";
    public static final String u0 = "deg_start_srv_first";
    public static final String v0 = "prev_jump_dual";
    public static final String w0 = "bind_use_imp";
    public static final String x0 = "bind_use_allow_activity_starts";
    public static final String y0 = "retry_bnd_once";
    public static final String z0 = "skip_trans";
    public Boolean E;
    public Boolean F;
    public Boolean G;
    public boolean H;
    public JSONObject I;
    public boolean J;
    public List<C0032b> K;
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1887a = 10000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1888b = false;
    public String c = O;
    public int d = 10;
    public boolean e = true;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = true;
    public boolean j = true;
    public boolean k = false;
    public boolean l = true;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = true;
    public String q = "";
    public String r = "";
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public int v = 1000;
    public boolean w = false;
    public Boolean x = null;
    public Boolean y = null;
    public Boolean z = null;
    public Boolean A = null;
    public Boolean B = null;
    public Boolean C = null;
    public com.alipay.sdk.m.o.a D = new com.alipay.sdk.m.o.a();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.w.a f1889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f1890b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public a(com.alipay.sdk.m.w.a aVar, Context context, boolean z, int i) {
            this.f1889a = aVar;
            this.f1890b = context;
            this.c = z;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alipay.sdk.m.t.b bVarA = new com.alipay.sdk.m.u.b().a(this.f1889a, this.f1890b);
                if (bVarA != null) {
                    b.this.a(this.f1889a, bVarA.a());
                    b.this.j(com.alipay.sdk.m.w.a.f());
                    com.alipay.sdk.m.m.a.a(this.f1889a, com.alipay.sdk.m.m.b.l, "offcfg|" + this.c + b.e.t + this.d);
                }
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }

    public b() {
        Boolean bool = Boolean.FALSE;
        this.E = bool;
        this.F = bool;
        this.G = bool;
        this.H = false;
        this.J = true;
        this.K = null;
        this.L = -1;
    }

    public boolean A() {
        return this.f1888b;
    }

    public boolean B() {
        return this.f;
    }

    public boolean C() {
        return this.o;
    }

    public final JSONObject D() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("timeout", l());
        jSONObject.put(o0, A());
        jSONObject.put(q0, s());
        jSONObject.put(s0, e());
        jSONObject.put(r0, C0032b.a(m()));
        jSONObject.put(P0, j());
        jSONObject.put(t0, g());
        jSONObject.put(u0, h());
        jSONObject.put(v0, o());
        jSONObject.put(w0, c());
        jSONObject.put(x0, b());
        jSONObject.put(y0, p());
        jSONObject.put(z0, r());
        jSONObject.put(A0, C());
        jSONObject.put(B0, t());
        jSONObject.put(D0, q());
        jSONObject.put(C0, k());
        jSONObject.put(U0, d());
        jSONObject.put(F0, f());
        jSONObject.put(G0, z());
        jSONObject.put(H0, x());
        jSONObject.put(V0, y());
        jSONObject.put(W0, w());
        jSONObject.put(I0, B());
        jSONObject.put(com.alipay.sdk.m.y.a.f1979b, a());
        f.a(jSONObject, J0, this.x);
        f.a(jSONObject, K0, this.y);
        f.a(jSONObject, L0, this.A);
        f.a(jSONObject, M0, this.B);
        f.a(jSONObject, N0, this.C);
        f.a(jSONObject, O0, this.z);
        f.a(jSONObject, Q0, this.D.a());
        f.a(jSONObject, R0, this.E);
        f.a(jSONObject, S0, this.F);
        f.a(jSONObject, T0, this.G);
        f.a(jSONObject, X0, Boolean.valueOf(this.H));
        return jSONObject;
    }

    public boolean b() {
        return this.l;
    }

    public boolean c() {
        return this.k;
    }

    public String d() {
        return this.r;
    }

    public int e() {
        return this.d;
    }

    public final int f() {
        return this.v;
    }

    public boolean g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    public boolean i(com.alipay.sdk.m.w.a aVar) {
        a(aVar, L0, String.valueOf(this.A));
        Boolean bool = this.A;
        return bool != null && bool.booleanValue();
    }

    public boolean j() {
        return this.e;
    }

    public String k() {
        return this.q;
    }

    public int l() {
        int i = this.f1887a;
        if (i < 1000 || i > 20000) {
            g.b(M, "time(def) = 10000");
            return 10000;
        }
        g.b(M, "time = " + this.f1887a);
        return this.f1887a;
    }

    public List<C0032b> m() {
        return this.K;
    }

    public String n() {
        return this.D.b();
    }

    public boolean o() {
        return this.j;
    }

    public boolean p() {
        return this.m;
    }

    public boolean q() {
        return this.u;
    }

    public boolean r() {
        return this.n;
    }

    public String s() {
        return this.c;
    }

    public boolean t() {
        return this.p;
    }

    public void u() {
        Context contextB = com.alipay.sdk.m.w.b.c().b();
        String strA = m.a(com.alipay.sdk.m.w.a.f(), contextB, m0, null);
        try {
            this.L = Integer.parseInt(m.a(com.alipay.sdk.m.w.a.f(), contextB, E0, "-1"));
        } catch (Exception unused) {
        }
        a(strA);
    }

    public boolean v() {
        Boolean bool = this.z;
        return bool != null && bool.booleanValue();
    }

    public boolean w() {
        return this.t;
    }

    public boolean x() {
        return this.w;
    }

    public boolean y() {
        return this.s;
    }

    public boolean z() {
        return this.J;
    }

    public boolean b(com.alipay.sdk.m.w.a aVar) {
        a(aVar, J0, String.valueOf(this.x));
        Boolean bool = this.x;
        return bool != null && bool.booleanValue();
    }

    public boolean c(com.alipay.sdk.m.w.a aVar) {
        a(aVar, K0, String.valueOf(this.y));
        Boolean bool = this.y;
        return bool != null && bool.booleanValue();
    }

    public boolean d(com.alipay.sdk.m.w.a aVar) {
        a(aVar, X0, String.valueOf(this.H));
        return !this.H;
    }

    public boolean e(com.alipay.sdk.m.w.a aVar) {
        a(aVar, R0, String.valueOf(this.E));
        Boolean bool = this.E;
        return bool != null && bool.booleanValue();
    }

    public boolean f(com.alipay.sdk.m.w.a aVar) {
        a(aVar, T0, String.valueOf(this.G));
        Boolean bool = this.G;
        return bool != null && bool.booleanValue();
    }

    public boolean g(com.alipay.sdk.m.w.a aVar) {
        a(aVar, S0, String.valueOf(this.F));
        Boolean bool = this.F;
        return bool != null && bool.booleanValue();
    }

    public boolean h(com.alipay.sdk.m.w.a aVar) {
        a(aVar, N0, String.valueOf(this.C));
        Boolean bool = this.C;
        return bool != null && bool.booleanValue();
    }

    public final void j(com.alipay.sdk.m.w.a aVar) {
        try {
            m.b(aVar, com.alipay.sdk.m.w.b.c().b(), m0, D().toString());
        } catch (Exception e) {
            g.a(e);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.o.b$b, reason: collision with other inner class name */
    public static final class C0032b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f1891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1892b;
        public final String c;

        public C0032b(String str, int i, String str2) {
            this.f1891a = str;
            this.f1892b = i;
            this.c = str2;
        }

        public static C0032b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new C0032b(jSONObject.optString(y.n), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public String toString() {
            return String.valueOf(a(this));
        }

        public static List<C0032b> a(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                C0032b c0032bA = a(jSONArray.optJSONObject(i));
                if (c0032bA != null) {
                    arrayList.add(c0032bA);
                }
            }
            return arrayList;
        }

        public static JSONObject a(C0032b c0032b) {
            if (c0032b == null) {
                return null;
            }
            try {
                return new JSONObject().put(y.n, c0032b.f1891a).put("v", c0032b.f1892b).put("pk", c0032b.c);
            } catch (JSONException e) {
                g.a(e);
                return null;
            }
        }

        public static JSONArray a(List<C0032b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<C0032b> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(a(it.next()));
            }
            return jSONArray;
        }
    }

    public static b i() {
        if (Y0 == null) {
            b bVar = new b();
            Y0 = bVar;
            bVar.u();
        }
        return Y0;
    }

    public JSONObject a() {
        return this.I;
    }

    public boolean a(com.alipay.sdk.m.w.a aVar) {
        a(aVar, M0, String.valueOf(this.B));
        Boolean bool = this.B;
        return bool != null && bool.booleanValue();
    }

    public void a(boolean z) {
        this.g = z;
    }

    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            a(new JSONObject(str));
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public final void a(com.alipay.sdk.m.w.a aVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(p0);
            com.alipay.sdk.m.y.a.a(aVar, jSONObjectOptJSONObject, com.alipay.sdk.m.y.a.a(aVar, jSONObject));
            if (jSONObjectOptJSONObject != null) {
                a(jSONObjectOptJSONObject);
            } else {
                g.e(M, "empty config");
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public final void a(JSONObject jSONObject) {
        g.d(com.alipay.sdk.m.n.a.B, "readFromJson:" + jSONObject);
        this.f1887a = jSONObject.optInt("timeout", 10000);
        this.f1888b = jSONObject.optBoolean(o0, false);
        this.c = jSONObject.optString(q0, O).trim();
        this.d = jSONObject.optInt(s0, 10);
        this.K = C0032b.a(jSONObject.optJSONArray(r0));
        this.e = jSONObject.optBoolean(P0, true);
        this.h = jSONObject.optBoolean(t0, false);
        this.i = jSONObject.optBoolean(u0, true);
        this.j = jSONObject.optBoolean(v0, true);
        this.k = jSONObject.optBoolean(w0, false);
        this.l = jSONObject.optBoolean(x0, true);
        this.m = jSONObject.optBoolean(y0, false);
        this.n = jSONObject.optBoolean(z0, false);
        this.o = jSONObject.optBoolean(A0, false);
        this.p = jSONObject.optBoolean(B0, true);
        this.q = jSONObject.optString(C0, "");
        this.u = jSONObject.optBoolean(D0, false);
        this.w = jSONObject.optBoolean(H0, false);
        this.r = jSONObject.optString(U0, "");
        this.v = jSONObject.optInt(F0, 1000);
        this.J = jSONObject.optBoolean(G0, true);
        this.s = jSONObject.optBoolean(V0, false);
        this.t = jSONObject.optBoolean(W0, false);
        this.f = jSONObject.optBoolean(I0, false);
        this.I = jSONObject.optJSONObject(com.alipay.sdk.m.y.a.f1979b);
        if (jSONObject.has(J0)) {
            this.x = Boolean.valueOf(jSONObject.optBoolean(J0, false));
        } else {
            this.x = null;
        }
        if (jSONObject.has(K0)) {
            this.y = Boolean.valueOf(jSONObject.optBoolean(K0, false));
        } else {
            this.y = null;
        }
        if (jSONObject.has(L0)) {
            this.A = Boolean.valueOf(jSONObject.optBoolean(L0, false));
        } else {
            this.A = null;
        }
        if (jSONObject.has(M0)) {
            this.B = Boolean.valueOf(jSONObject.optBoolean(M0, false));
        } else {
            this.B = null;
        }
        if (jSONObject.has(N0)) {
            this.C = Boolean.valueOf(jSONObject.optBoolean(N0, false));
        } else {
            this.C = null;
        }
        if (jSONObject.has(O0)) {
            this.z = Boolean.valueOf(jSONObject.optBoolean(O0, false));
        } else {
            this.z = null;
        }
        this.D.a(jSONObject.optString(Q0, null));
        if (jSONObject.has(R0)) {
            this.E = Boolean.valueOf(jSONObject.optBoolean(R0, false));
        } else {
            this.E = null;
        }
        if (jSONObject.has(S0)) {
            this.F = Boolean.valueOf(jSONObject.optBoolean(S0, false));
        } else {
            this.F = null;
        }
        if (jSONObject.has(T0)) {
            this.G = Boolean.valueOf(jSONObject.optBoolean(T0, false));
        } else {
            this.G = null;
        }
        this.H = jSONObject.optBoolean(X0, false);
    }

    public void a(com.alipay.sdk.m.w.a aVar, Context context, boolean z, int i) {
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "oncfg|" + z + b.e.t + i);
        a aVar2 = new a(aVar, context, z, i);
        if (z && !q.h()) {
            int iF = f();
            if (q.a(iF, aVar2, "AlipayDCPBlok")) {
                return;
            }
            com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.m0, "" + iF);
            return;
        }
        Thread thread = new Thread(aVar2);
        thread.setName("AlipayDCP");
        thread.start();
    }

    public boolean a(Context context, int i) {
        if (this.L == -1) {
            this.L = q.a();
            m.b(com.alipay.sdk.m.w.a.f(), context, E0, String.valueOf(this.L));
        }
        return this.L < i;
    }

    public final void a(com.alipay.sdk.m.w.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "getConfig", str + b.e.t + str2);
    }
}
