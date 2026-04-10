package com.anythink.core.c;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATCustomAdapterConfig;
import com.anythink.core.api.ATRewardInfo;
import com.anythink.core.common.b.g;
import com.anythink.core.common.b.n;
import com.anythink.core.common.b.p;
import com.anythink.core.common.e.ab;
import com.anythink.core.common.e.ag;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.k;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.s;
import com.anythink.core.common.e.u;
import com.anythink.core.common.g.j;
import com.anythink.core.common.k.g;
import com.anythink.core.common.k.h;
import com.anythink.core.common.l;
import com.anythink.core.common.v;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.bytedance.msdk.api.v2.GMAdConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    private String A;
    private ag B;
    private int C;
    private String D;
    private int E;
    private int F;
    private String G;
    private Map<String, Object> H;
    private Map<String, ATRewardInfo> I;
    private ATRewardInfo J;
    private String K;
    private String L;
    private long M;
    private String N;
    private long O;
    private int P;
    private long Q;
    private int R;
    private List<s> S;
    private u T;
    private long U;
    private double V;
    private String W;
    private List<String> X;
    private String Y;
    private String Z;
    private final String a = "Placement";
    private int aA;
    private int aB;
    private int aC;
    private String aD;
    private String aE;
    private String aF;
    private long aG;
    private String aH;
    private String aI;
    private double aJ;
    private int aK;
    private int aL;
    private int aM;
    private int aN;
    private String aa;
    private String ab;
    private long ac;
    private String ad;
    private String ae;
    private String af;
    private double ag;
    private String ah;
    private long ai;
    private List<ai> aj;
    private long ak;
    private long al;
    private long am;
    private int an;
    private int ao;
    private int ap;
    private long aq;
    private JSONObject ar;
    private String as;
    private JSONObject at;
    private int au;
    private String av;
    private String aw;
    private int ax;
    private int ay;
    private List<Integer> az;
    private long b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f6687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f6688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f6691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f6692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f6693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f6694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f6695k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f6696l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f6697m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f6698n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f6699o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f6700p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f6701q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f6702r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<ai> f6703s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private List<ai> f6704t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f6705u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f6706v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private long f6707w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f6708x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f6709y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f6710z;

    public static class a {
        public static final String A = "req_w_time";
        public static final String B = "wf_loadts";
        public static final String C = "req_ug_type";
        public static final String D = "req_ug_numsp";
        public static final String E = "bf_ldf_rf_sw";
        public static final String F = "hb_start_time";
        public static final String G = "dsp_list";
        public static final String H = "bid_floor";
        public static final String I = "max_unit_ids";
        public static final String J = "xdb_list";
        public static final String K = "s2s_bd_max";
        public static final String L = "req_merge";
        public static final String M = "exclude_id_max";
        public static final String N = "install_id_max";
        public static final String O = "install_ids";
        public static final String P = "exclude_ids";
        public static final String Q = "is_test";
        public static final String R = "gsp_rates";
        public static final String S = "mdna_r";
        public static final String T = "adx_ext";
        public static final String U = "wf_id";
        public static final String V = "sysh_mtg_sw";
        public static final String W = "mid_gdt_sw";
        public static final String X = "lm_lrqf_interval_sws";
        public static final String Y = "wf_lscb_type";
        public static final String Z = "reqid_pg_sw";
        public static final String a = "hb_bid_timeout";
        private static final String aA = "s_id";
        private static final String aB = "u_n_f_sw";
        private static final String aC = "m_o";
        private static final String aD = "m_o_s";
        private static final String aE = "m_o_ks";
        private static final String aF = "p_m_o";
        private static final String aG = "callback";
        private static final String aH = "sc_list";
        private static final String aI = "rw_n";
        private static final String aJ = "rw_num";
        private static final String aK = "reward";
        private static final String aL = "currency";
        private static final String aM = "cc";
        private static final String aN = "exch_r";
        private static final String aO = "acct_cy";
        private static final String aa = "ps_id_timeout";
        private static final String ab = "ps_ct";
        private static final String ac = "ps_ct_out";
        private static final String ad = "pucs";
        private static final String ae = "ad_delivery_sw";
        private static final String af = "req_ug_num";
        private static final String ag = "unit_caps_d";
        private static final String ah = "unit_caps_h";
        private static final String ai = "unit_pacing";
        private static final String aj = "wifi_auto_sw";
        private static final String ak = "show_type";
        private static final String al = "refresh";
        private static final String am = "ug_list";
        private static final String an = "ol_list";
        private static final String ao = "gro_id";
        private static final String ap = "hb_list";
        private static final String aq = "s2shb_list";
        private static final String ar = "format";
        private static final String as = "auto_refresh";
        private static final String at = "auto_refresh_time";
        private static final String au = "s_t";
        private static final String av = "l_s_t";
        private static final String aw = "ra";
        private static final String ax = "asid";
        private static final String ay = "tp_ps";
        private static final String az = "t_g_id";
        public static final String b = "addr_bid";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f6711c = "load_fail_wtime";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f6712d = "load_cap";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f6713e = "load_cap_time";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f6714f = "cached_offers_num";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f6715g = "adx_list";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f6716h = "adx_st";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f6717i = "ilrd";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f6718j = "hb_list";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f6719k = "inh_list";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f6720l = "fbhb_bid_wtime";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f6721m = "burl_nt_firm";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f6722n = "wf_bid_addr";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f6723o = "ss_data";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f6724p = "cn_addr_bid";

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f6725q = "cn_wf_bid_addr";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f6726r = "byuid_wt";

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f6727s = "addr_bks";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final String f6728t = "addr_subbks";

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final String f6729u = "s2sbks_list";

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final String f6730v = "exch_rate_c2u";

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final String f6731w = "doffer_list";

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f6732x = "bottom_list";

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String f6733y = "bottom_reqts";

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final String f6734z = "cb_w_time";
    }

    private List<ai> aA() {
        return this.aj;
    }

    private String aB() {
        return this.aF;
    }

    private String aC() {
        return this.N;
    }

    private int aD() {
        return this.f6689e;
    }

    private int aE() {
        return this.f6694j;
    }

    private int aF() {
        return this.f6695k;
    }

    private int aG() {
        return this.f6696l;
    }

    private ag aH() {
        return this.B;
    }

    private long aI() {
        return this.aG;
    }

    private String aJ() {
        return this.aa;
    }

    private long aK() {
        return this.ak;
    }

    private long aL() {
        return this.al;
    }

    private int aM() {
        return this.ay;
    }

    private int aN() {
        return this.aB;
    }

    private JSONObject ay() {
        return this.ar;
    }

    private int az() {
        return this.ao;
    }

    private void f(String str) {
        this.aw = str;
    }

    private void g(String str) {
        this.av = str;
    }

    private void h(String str) {
        this.as = str;
    }

    public final String A() {
        return this.f6702r;
    }

    public final String B() {
        return this.aD;
    }

    public final String C() {
        return this.aE;
    }

    public final u D() {
        return this.T;
    }

    public final List<s> E() {
        return this.S;
    }

    public final List<ai> F() {
        return this.f6703s;
    }

    public final List<ai> G() {
        return this.f6704t;
    }

    public final long H() {
        return this.M;
    }

    public final Map<String, ATRewardInfo> I() {
        return this.I;
    }

    public final String J() {
        return this.K;
    }

    public final String K() {
        return this.L;
    }

    public final ATRewardInfo L() {
        return this.J;
    }

    public final Map<String, Object> M() {
        return this.H;
    }

    public final int N() {
        return this.F;
    }

    public final int O() {
        return this.C;
    }

    public final String P() {
        return this.D;
    }

    public final int Q() {
        return this.E;
    }

    public final long R() {
        return this.f6708x;
    }

    public final long S() {
        return this.f6709y;
    }

    public final int T() {
        return this.f6710z;
    }

    public final String U() {
        return this.A;
    }

    public final int V() {
        return this.f6706v;
    }

    public final long W() {
        return this.f6707w;
    }

    public final int X() {
        return this.f6705u;
    }

    public final long Y() {
        return this.f6687c;
    }

    public final int Z() {
        return this.f6688d;
    }

    public final int a() {
        return this.aA;
    }

    public final int aa() {
        return this.f6690f;
    }

    public final long ab() {
        return this.f6691g;
    }

    public final long ac() {
        return this.f6692h;
    }

    public final long ad() {
        return this.f6693i;
    }

    public final int ae() {
        return this.f6697m;
    }

    public final String af() {
        return this.f6698n;
    }

    public final String ag() {
        return this.f6699o;
    }

    public final String ah() {
        return this.f6700p;
    }

    public final String ai() {
        return this.f6701q;
    }

    public final long aj() {
        return this.O;
    }

    public final int ak() {
        return this.P;
    }

    public final long al() {
        return this.Q;
    }

    public final int am() {
        return this.R;
    }

    public final String an() {
        return this.ab;
    }

    public final String ao() {
        return this.aH;
    }

    public final String ap() {
        return this.aI;
    }

    public final int aq() {
        return this.aL;
    }

    public final int ar() {
        return this.aK;
    }

    public final double as() {
        return this.aJ;
    }

    public final int at() {
        return this.aM;
    }

    public final int au() {
        return this.aN;
    }

    public final int av() {
        return this.ax;
    }

    public final boolean aw() {
        return this.f6689e == 1;
    }

    public final boolean ax() {
        new StringBuilder("Already cache time -- > ").append(System.currentTimeMillis() - this.aG);
        return System.currentTimeMillis() - this.aG > this.b;
    }

    public final List<Integer> b() {
        return this.az;
    }

    public final String c() {
        return this.aw;
    }

    public final int d() {
        return this.au;
    }

    public final String e() {
        return this.av;
    }

    public final long i() {
        return this.aq;
    }

    public final int j() {
        return this.ap;
    }

    public final int k() {
        return this.an;
    }

    public final int l() {
        int i2 = this.an;
        if (i2 == 1) {
            return this.f6690f;
        }
        if (i2 != 2) {
            return 1;
        }
        return this.ao;
    }

    public final long m() {
        return this.am;
    }

    public final String n() {
        return this.ah;
    }

    public final long o() {
        return this.ai;
    }

    public final double p() {
        return this.ag;
    }

    public final String q() {
        return this.ad;
    }

    public final String r() {
        return this.ae;
    }

    public final String s() {
        return this.af;
    }

    public final long t() {
        return this.ac;
    }

    public final String u() {
        return this.Z;
    }

    public final String v() {
        return this.Y;
    }

    public final List<String> w() {
        return this.X;
    }

    public final double x() {
        return this.V;
    }

    public final String y() {
        return this.W;
    }

    public final long z() {
        return this.U;
    }

    private void A(String str) {
        this.f6700p = str;
    }

    private void B(String str) {
        this.f6701q = str;
    }

    private void C(String str) {
        this.aa = str;
    }

    private void D(String str) {
        this.ab = str;
    }

    private void E(String str) {
        this.aH = str;
    }

    private void F(String str) {
        this.aI = str;
    }

    private void a(int i2) {
        this.aA = i2;
    }

    private void b(int i2) {
        this.au = i2;
    }

    private void c(int i2) {
        this.aC = i2;
    }

    private void d(int i2) {
        this.ap = i2;
    }

    private void e(int i2) {
        this.an = i2;
    }

    private void i(String str) {
        this.ah = str;
    }

    private void j(String str) {
        this.ad = str;
    }

    private void k(String str) {
        this.ae = str;
    }

    private void m(String str) {
        this.Z = str;
    }

    private void n(String str) {
        this.Y = str;
    }

    private void o(String str) {
        this.W = str;
    }

    private void p(String str) {
        this.f6702r = str;
    }

    private void q(String str) {
        this.aD = str;
    }

    private void r(String str) {
        this.aF = str;
    }

    private void s(String str) {
        this.aE = str;
    }

    private void t(String str) {
        this.N = str;
    }

    private void u(String str) {
        this.K = str;
    }

    private void v(String str) {
        this.L = str;
    }

    private void w(String str) {
        this.D = str;
    }

    private void x(String str) {
        this.A = str;
    }

    private void y(String str) {
        this.f6698n = str;
    }

    private void z(String str) {
        this.f6699o = str;
    }

    public final JSONObject f() {
        return this.at;
    }

    public final String g() {
        return this.as;
    }

    public final int h() {
        return this.aC;
    }

    private void A(int i2) {
        this.ay = i2;
    }

    private void B(int i2) {
        this.aB = i2;
    }

    private void a(List<Integer> list) {
        this.az = list;
    }

    private void b(JSONObject jSONObject) {
        this.ar = jSONObject;
    }

    private void c(long j2) {
        this.ai = j2;
    }

    private void d(long j2) {
        this.ac = j2;
    }

    private void e(long j2) {
        this.U = j2;
    }

    private void f(int i2) {
        this.ao = i2;
    }

    private void g(int i2) {
        this.F = i2;
    }

    private void h(int i2) {
        this.C = i2;
    }

    private void i(int i2) {
        this.E = i2;
    }

    private void j(int i2) {
        this.f6710z = i2;
    }

    private void k(int i2) {
        this.f6706v = i2;
    }

    private void m(int i2) {
        this.f6688d = i2;
    }

    private void n(int i2) {
        this.f6689e = i2;
    }

    private void o(int i2) {
        this.f6690f = i2;
    }

    private void p(int i2) {
        this.f6694j = i2;
    }

    private void q(int i2) {
        this.f6695k = i2;
    }

    private void r(int i2) {
        this.f6696l = i2;
    }

    private void s(int i2) {
        this.f6697m = i2;
    }

    private void t(int i2) {
        this.P = i2;
    }

    private void u(int i2) {
        this.R = i2;
    }

    private void v(int i2) {
        this.aL = i2;
    }

    private void w(int i2) {
        this.aK = i2;
    }

    private void x(int i2) {
        this.aM = i2;
    }

    private void y(int i2) {
        this.aN = i2;
    }

    private void z(int i2) {
        this.ax = i2;
    }

    private void a(JSONObject jSONObject) {
        this.at = jSONObject;
    }

    private void b(List<ai> list) {
        this.aj = list;
    }

    private void c(List<String> list) {
        this.X = list;
    }

    private void d(List<s> list) {
        this.S = list;
    }

    private void e(List<ai> list) {
        this.f6703s = list;
    }

    private void f(List<ai> list) {
        this.f6704t = list;
    }

    private void g(long j2) {
        this.f6708x = j2;
    }

    private void h(long j2) {
        this.f6709y = j2;
    }

    private void i(long j2) {
        this.f6707w = j2;
    }

    private void j(long j2) {
        this.b = j2;
    }

    private void k(long j2) {
        this.f6687c = j2;
    }

    private void l(String str) {
        this.af = str;
    }

    private void m(long j2) {
        this.f6692h = j2;
    }

    private void n(long j2) {
        this.f6693i = j2;
    }

    private void o(long j2) {
        this.aG = j2;
    }

    private void p(long j2) {
        this.O = j2;
    }

    private void q(long j2) {
        this.Q = j2;
    }

    private void r(long j2) {
        this.ak = j2;
    }

    private void s(long j2) {
        this.al = j2;
    }

    private void a(long j2) {
        this.aq = j2;
    }

    private void b(long j2) {
        this.am = j2;
    }

    private void c(double d2) {
        this.aJ = d2;
    }

    public static List<ai> d(String str) {
        List<ai> listA = a(str, 2);
        Iterator<ai> it = listA.iterator();
        while (it.hasNext()) {
            it.next().aj();
        }
        return listA;
    }

    private void f(long j2) {
        this.M = j2;
    }

    private void l(int i2) {
        this.f6705u = i2;
    }

    public final s e(String str) {
        List<s> list = this.S;
        if (list == null) {
            return null;
        }
        for (s sVar : list) {
            if (sVar.k() == null) {
                sVar.a((k) this.T);
            }
            if (TextUtils.equals(str, sVar.p()) && !sVar.a(this.T)) {
                return sVar;
            }
        }
        return null;
    }

    private void a(double d2) {
        this.ag = d2;
    }

    private void b(double d2) {
        this.V = d2;
    }

    public static List<ai> c(String str) {
        return a(str, 8);
    }

    private void l(long j2) {
        this.f6691g = j2;
    }

    private void a(u uVar) {
        this.T = uVar;
    }

    private void b(Map<String, Object> map) {
        this.H = map;
    }

    public static d b(String str) {
        long jOptLong;
        int i2;
        int i3;
        if (str == null) {
            return null;
        }
        try {
            d dVar = new d();
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.isNull("ps_ct")) {
                dVar.b = 0L;
            } else {
                dVar.b = jSONObject.optLong("ps_ct");
            }
            if (jSONObject.isNull("ps_ct_out")) {
                dVar.f6687c = 0L;
            } else {
                dVar.f6687c = jSONObject.optLong("ps_ct_out");
            }
            if (jSONObject.isNull("pucs")) {
                dVar.f6688d = 1;
            } else {
                dVar.f6688d = jSONObject.optInt("pucs");
            }
            if (jSONObject.isNull("ad_delivery_sw")) {
                dVar.f6689e = 1;
            } else {
                dVar.f6689e = jSONObject.optInt("ad_delivery_sw");
            }
            if (jSONObject.isNull("req_ug_num")) {
                dVar.f6690f = -1;
            } else {
                dVar.f6690f = jSONObject.optInt("req_ug_num");
            }
            if (jSONObject.isNull("unit_caps_d")) {
                dVar.f6691g = -1L;
            } else {
                dVar.f6691g = jSONObject.optLong("unit_caps_d");
            }
            if (jSONObject.isNull("unit_caps_h")) {
                dVar.f6692h = -1L;
            } else {
                dVar.f6692h = jSONObject.optLong("unit_caps_h");
            }
            if (jSONObject.isNull("unit_pacing")) {
                dVar.f6693i = -1L;
            } else {
                dVar.f6693i = jSONObject.optLong("unit_pacing");
            }
            if (jSONObject.isNull("wifi_auto_sw")) {
                dVar.f6694j = 0;
            } else {
                dVar.f6694j = jSONObject.optInt("wifi_auto_sw");
            }
            if (jSONObject.isNull("show_type")) {
                dVar.f6695k = 0;
            } else {
                dVar.f6695k = jSONObject.optInt("show_type");
            }
            if (jSONObject.isNull("refresh")) {
                dVar.f6696l = 0;
            } else {
                dVar.f6696l = jSONObject.optInt("refresh");
            }
            if (jSONObject.isNull("gro_id")) {
                dVar.f6697m = 0;
            } else {
                dVar.f6697m = jSONObject.optInt("gro_id");
            }
            if (jSONObject.isNull("format")) {
                dVar.f6705u = 0;
            } else {
                dVar.f6705u = jSONObject.optInt("format");
            }
            if (jSONObject.isNull("auto_refresh")) {
                dVar.f6706v = 0;
            } else {
                dVar.f6706v = jSONObject.optInt("auto_refresh");
            }
            if (jSONObject.isNull("auto_refresh_time")) {
                dVar.f6707w = 0L;
            } else {
                dVar.f6707w = jSONObject.optLong("auto_refresh_time");
            }
            if (jSONObject.isNull("s_t")) {
                dVar.f6708x = 900000L;
            } else {
                dVar.f6708x = jSONObject.optLong("s_t");
            }
            if (jSONObject.isNull(l.J)) {
                dVar.f6709y = 1800000L;
            } else {
                dVar.f6709y = jSONObject.optLong(l.J);
            }
            if (jSONObject.isNull("ra")) {
                dVar.f6710z = -1;
            } else {
                dVar.f6710z = jSONObject.optInt("ra");
            }
            if (jSONObject.isNull("asid")) {
                dVar.A = "";
            } else {
                dVar.A = jSONObject.optString("asid");
            }
            if (jSONObject.isNull("tp_ps")) {
                dVar.B = null;
            } else {
                try {
                    ag agVar = new ag();
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("tp_ps");
                    agVar.a = jSONObjectOptJSONObject.optInt("pucs") == 1;
                    agVar.b = jSONObjectOptJSONObject.optLong("apdt");
                    agVar.f7149c = jSONObjectOptJSONObject.optInt("aprn");
                    agVar.f7150d = jSONObjectOptJSONObject.optInt("puas") == 1;
                    agVar.f7151e = jSONObjectOptJSONObject.optLong("cdt");
                    agVar.f7152f = jSONObjectOptJSONObject.optInt("ski_swt") == 1;
                    agVar.f7153g = jSONObjectOptJSONObject.optInt("aut_swt") == 1;
                    dVar.B = agVar;
                } catch (Exception unused) {
                }
            }
            if (jSONObject.isNull("ug_list")) {
                dVar.f6698n = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.f6698n = jSONObject.optString("ug_list");
            }
            if (jSONObject.isNull("ol_list")) {
                dVar.f6699o = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.f6699o = jSONObject.optString("ol_list");
            }
            dVar.f6703s = a(dVar.f6698n, dVar.f6699o);
            if (jSONObject.isNull("s2shb_list")) {
                dVar.f6700p = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.f6700p = jSONObject.optString("s2shb_list");
            }
            if (jSONObject.isNull(a.f6715g)) {
                dVar.aE = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.aE = jSONObject.optString(a.f6715g);
            }
            if (jSONObject.isNull(a.f6718j)) {
                dVar.f6701q = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.f6701q = jSONObject.optString(a.f6718j);
            }
            if (jSONObject.isNull(a.f6719k)) {
                dVar.f6702r = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.f6702r = jSONObject.optString(a.f6719k);
            }
            if (jSONObject.isNull(a.f6729u)) {
                dVar.af = "";
            } else {
                dVar.af = jSONObject.optString(a.f6729u);
            }
            if (jSONObject.isNull(a.f6731w)) {
                dVar.aH = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.aH = jSONObject.optString(a.f6731w);
            }
            if (jSONObject.isNull("updateTime")) {
                dVar.aG = 0L;
                jOptLong = 0;
            } else {
                jOptLong = jSONObject.optLong("updateTime");
                dVar.aG = jOptLong;
            }
            if (jSONObject.isNull("t_g_id")) {
                dVar.C = -1;
            } else {
                dVar.C = jSONObject.optInt("t_g_id");
            }
            if (jSONObject.isNull("s_id")) {
                dVar.D = "";
            } else {
                dVar.D = jSONObject.optString("s_id");
            }
            if (jSONObject.isNull("u_n_f_sw")) {
                dVar.E = 0;
            } else {
                dVar.E = jSONObject.optInt("u_n_f_sw");
            }
            if (!jSONObject.isNull("m_o_s")) {
                dVar.T = u.c(jSONObject.optString("m_o_s"));
            }
            if (jSONObject.isNull("m_o")) {
                dVar.S = null;
            } else {
                dVar.S = a(jSONObject.optString("m_o"), jSONObject.optString("m_o_ks"), jOptLong, dVar.T);
            }
            if (jSONObject.isNull("p_m_o")) {
                dVar.F = 0;
            } else {
                dVar.F = jSONObject.optInt("p_m_o");
            }
            if (jSONObject.isNull(j.a)) {
                dVar.H = null;
            } else {
                JSONObject jSONObject2 = new JSONObject(jSONObject.optString(j.a));
                HashMap map = new HashMap();
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.opt(next));
                }
                dVar.H = map;
            }
            if (!jSONObject.isNull("callback")) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString("callback"));
                if (!jSONObject3.isNull("sc_list")) {
                    JSONObject jSONObject4 = new JSONObject(jSONObject3.optString("sc_list"));
                    HashMap map2 = new HashMap();
                    Iterator<String> itKeys2 = jSONObject4.keys();
                    while (itKeys2.hasNext()) {
                        String next2 = itKeys2.next();
                        JSONObject jSONObject5 = new JSONObject(jSONObject4.optString(next2));
                        ATRewardInfo aTRewardInfo = new ATRewardInfo();
                        aTRewardInfo.rewardName = jSONObject5.optString("rw_n");
                        aTRewardInfo.rewardNumber = jSONObject5.optInt("rw_num");
                        map2.put(next2, aTRewardInfo);
                    }
                    dVar.I = map2;
                }
                if (!jSONObject3.isNull("reward")) {
                    JSONObject jSONObject6 = new JSONObject(jSONObject3.optString("reward"));
                    ATRewardInfo aTRewardInfo2 = new ATRewardInfo();
                    if (!jSONObject6.isNull("rw_n")) {
                        aTRewardInfo2.rewardName = jSONObject6.optString("rw_n");
                    }
                    if (!jSONObject6.isNull("rw_num")) {
                        aTRewardInfo2.rewardNumber = jSONObject6.optInt("rw_num");
                    }
                    dVar.J = aTRewardInfo2;
                }
                if (!jSONObject3.isNull("currency")) {
                    dVar.K = jSONObject3.optString("currency");
                }
                if (!jSONObject3.isNull(com.anythink.expressad.d.a.b.f8383h)) {
                    dVar.L = jSONObject3.optString(com.anythink.expressad.d.a.b.f8383h);
                }
                if (!jSONObject3.isNull("exch_r")) {
                    dVar.V = jSONObject3.optDouble("exch_r", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                }
                if (!jSONObject3.isNull("acct_cy")) {
                    dVar.W = jSONObject3.optString("acct_cy");
                }
            }
            if (jSONObject.isNull(a.a)) {
                dVar.M = 10000L;
            } else {
                dVar.M = jSONObject.optLong(a.a);
            }
            if (jSONObject.isNull(a.b)) {
                dVar.N = "";
            } else {
                dVar.N = jSONObject.optString(a.b);
            }
            if (jSONObject.isNull(a.f6711c)) {
                dVar.O = 10000L;
            } else {
                dVar.O = jSONObject.optLong(a.f6711c);
            }
            if (jSONObject.isNull(a.f6712d)) {
                dVar.P = -1;
            } else {
                dVar.P = jSONObject.optInt(a.f6712d);
            }
            if (jSONObject.isNull(a.f6713e)) {
                dVar.Q = 900000L;
            } else {
                dVar.Q = jSONObject.optLong(a.f6713e);
            }
            if (jSONObject.isNull(a.f6714f)) {
                dVar.R = 2;
            } else {
                dVar.R = jSONObject.optInt(a.f6714f);
            }
            if (jSONObject.isNull(a.f6717i)) {
                dVar.aD = null;
            } else {
                dVar.aD = jSONObject.optString(a.f6717i);
            }
            if (jSONObject.isNull(a.f6716h)) {
                dVar.aF = "";
            } else {
                dVar.aF = jSONObject.optString(a.f6716h);
            }
            if (jSONObject.isNull(a.f6720l)) {
                dVar.U = 4000L;
            } else {
                dVar.U = jSONObject.optLong(a.f6720l);
            }
            if (jSONObject.isNull(a.f6721m)) {
                dVar.X = null;
            } else {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(a.f6721m);
                ArrayList arrayList = new ArrayList(3);
                for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                    arrayList.add(jSONArrayOptJSONArray.optString(i4));
                }
                dVar.X = arrayList;
            }
            if (jSONObject.isNull(a.f6722n)) {
                dVar.Y = "";
            } else {
                dVar.Y = jSONObject.optString(a.f6722n);
            }
            if (jSONObject.isNull(a.f6723o)) {
                dVar.Z = "";
            } else {
                dVar.Z = jSONObject.optString(a.f6723o);
            }
            if (jSONObject.isNull(a.f6724p)) {
                dVar.aa = "";
            } else {
                dVar.aa = jSONObject.optString(a.f6724p);
            }
            if (jSONObject.isNull(a.f6725q)) {
                dVar.ab = "";
            } else {
                dVar.ab = jSONObject.optString(a.f6725q);
            }
            if (jSONObject.isNull(a.f6726r)) {
                dVar.ac = 500L;
            } else {
                dVar.ac = jSONObject.optLong(a.f6726r);
            }
            if (jSONObject.isNull(a.f6727s)) {
                dVar.ad = "";
            } else {
                dVar.ad = jSONObject.optString(a.f6727s);
            }
            if (jSONObject.isNull(a.f6728t)) {
                dVar.ae = "";
            } else {
                dVar.ae = jSONObject.optString(a.f6728t);
            }
            if (jSONObject.isNull(a.f6730v)) {
                dVar.ag = 0.1614d;
            } else {
                dVar.ag = jSONObject.optDouble(a.f6730v);
            }
            if (jSONObject.isNull(a.f6732x)) {
                dVar.ah = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.ah = jSONObject.optString(a.f6732x);
                dVar.aj = a(dVar.ah, 8);
            }
            if (jSONObject.isNull(a.f6733y)) {
                dVar.ai = 1000L;
            } else {
                dVar.ai = jSONObject.optLong(a.f6733y);
            }
            if (jSONObject.isNull(a.f6734z)) {
                dVar.ak = 0L;
            } else {
                dVar.ak = jSONObject.optLong(a.f6734z);
            }
            if (jSONObject.isNull(a.A)) {
                dVar.al = com.anythink.expressad.exoplayer.i.a.f9492f;
            } else {
                dVar.al = jSONObject.optLong(a.A);
            }
            if (jSONObject.isNull(a.B)) {
                dVar.am = -1L;
            } else {
                dVar.am = jSONObject.optLong(a.B);
            }
            if (jSONObject.isNull(a.C)) {
                dVar.an = 1;
            } else {
                dVar.an = jSONObject.optInt(a.C);
            }
            if (jSONObject.isNull(a.D)) {
                dVar.ao = 1;
            } else {
                dVar.ao = jSONObject.optInt(a.D);
            }
            if (jSONObject.isNull(a.E)) {
                dVar.ap = 2;
            } else {
                dVar.ap = jSONObject.optInt(a.E);
            }
            if (jSONObject.isNull(a.F)) {
                dVar.aq = com.anythink.expressad.exoplayer.i.a.f9492f;
            } else {
                dVar.aq = jSONObject.optLong(a.F);
            }
            if (jSONObject.isNull(a.G)) {
                dVar.aI = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            } else {
                dVar.aI = jSONObject.optString(a.G);
            }
            if (jSONObject.isNull("bid_floor")) {
                dVar.aJ = PangleAdapterUtils.CPM_DEFLAUT_VALUE;
            } else {
                dVar.aJ = jSONObject.optDouble("bid_floor");
            }
            if (jSONObject.isNull(a.I)) {
                dVar.ar = null;
            } else {
                dVar.ar = jSONObject.optJSONObject(a.I);
            }
            if (jSONObject.isNull(a.J)) {
                dVar.as = "";
            } else {
                dVar.as = jSONObject.optString(a.J);
            }
            if (jSONObject.isNull(a.K)) {
                dVar.aK = 0;
            } else {
                dVar.aK = jSONObject.optInt(a.K);
            }
            if (jSONObject.isNull(a.L)) {
                dVar.aL = 2;
            } else {
                dVar.aL = jSONObject.optInt(a.L);
            }
            try {
                dVar.f6704t = a(dVar.f6700p, dVar.aE, dVar.f6701q, dVar.f6702r, dVar.af, dVar.aH, dVar.aI);
            } catch (Exception unused2) {
            }
            if (jSONObject.isNull(a.M)) {
                dVar.aN = 0;
            } else {
                dVar.aN = jSONObject.optInt(a.M);
            }
            if (jSONObject.isNull(a.N)) {
                i2 = 0;
                dVar.aM = 0;
            } else {
                i2 = 0;
                dVar.aM = jSONObject.optInt(a.N);
            }
            if (jSONObject.isNull("is_test")) {
                dVar.aC = 2;
            } else {
                dVar.aC = jSONObject.optInt("is_test");
            }
            dVar.at = jSONObject.optJSONObject(a.R);
            if (jSONObject.isNull("mdna_r")) {
                dVar.au = 1;
            } else {
                dVar.au = jSONObject.optInt("mdna_r");
            }
            if (jSONObject.isNull(a.T)) {
                dVar.av = "";
            } else {
                dVar.av = jSONObject.optString(a.T);
            }
            if (jSONObject.isNull(a.U)) {
                dVar.aw = "";
            } else {
                dVar.aw = jSONObject.optString(a.U);
            }
            if (!jSONObject.isNull(a.V)) {
                dVar.ax = jSONObject.optInt(a.V);
            } else {
                dVar.ax = 2;
            }
            if (!jSONObject.isNull(a.W)) {
                dVar.ay = jSONObject.optInt(a.W);
                i3 = 1;
            } else {
                i3 = 1;
                dVar.ay = 1;
            }
            if (jSONObject.isNull(a.X)) {
                dVar.az = new ArrayList(i3);
            } else {
                ArrayList arrayList2 = new ArrayList(3);
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(a.X);
                if (jSONArrayOptJSONArray2 != null) {
                    int length = jSONArrayOptJSONArray2.length();
                    while (i2 < length) {
                        arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray2.optInt(i2)));
                        i2++;
                    }
                }
                dVar.az = arrayList2;
            }
            if (jSONObject.isNull(a.Y)) {
                dVar.aA = 2;
            } else {
                dVar.aA = jSONObject.optInt(a.Y);
            }
            if (!jSONObject.isNull(a.Z)) {
                dVar.aB = jSONObject.optInt(a.Z);
            } else {
                dVar.aB = 1;
            }
            return dVar;
        } catch (Exception unused3) {
            return null;
        }
    }

    public final boolean a(String str) {
        List<ai> list = this.f6704t;
        if (list == null) {
            return false;
        }
        Iterator<ai> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(str, it.next().t())) {
                return true;
            }
        }
        return false;
    }

    private void a(Map<String, ATRewardInfo> map) {
        this.I = map;
    }

    private void a(ATRewardInfo aTRewardInfo) {
        this.J = aTRewardInfo;
    }

    private void a(ag agVar) {
        this.B = agVar;
    }

    public static List<ai> a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        List<ai> listA = a(str, 1);
        List<ai> listA2 = a(str2, 3);
        List<ai> listA3 = a(str3, 2);
        List<ai> listA4 = a(str4, 5);
        List<ai> listA5 = a(str5, 6);
        List<ai> listA6 = a(str6, 7);
        List<ai> listA7 = a(str7, 3);
        listA.addAll(listA2);
        listA.addAll(listA3);
        listA.addAll(listA4);
        listA.addAll(listA5);
        listA.addAll(listA6);
        listA.addAll(listA7);
        return listA;
    }

    public static List<ai> a(String str, String str2) {
        List<ai> listA = a(str, 0);
        listA.addAll(a(str2, 4));
        Collections.sort(listA);
        return listA;
    }

    private static List<ai> a(String str, int i2) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONArray jSONArray;
        ATCustomAdapterConfig aTCustomAdapterConfigB;
        String str7 = l.f7764t;
        String str8 = l.A;
        String str9 = l.f7766v;
        String str10 = "nw_firm_id";
        String str11 = l.f7770z;
        boolean z2 = (i2 == 0 || i2 == 4 || i2 == 8) ? false : true;
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray2 = new JSONArray(str);
            int i3 = 0;
            while (i3 < jSONArray2.length()) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i3);
                if (jSONObject != null) {
                    ai aiVar = new ai();
                    aiVar.e(i2);
                    aiVar.d(z2 ? 1 : 0);
                    jSONArray = jSONArray2;
                    if (jSONObject.isNull(str11)) {
                        aiVar.c("");
                    } else {
                        aiVar.c(jSONObject.optString(str11));
                    }
                    str6 = str11;
                    if (jSONObject.isNull(l.f7767w)) {
                        aiVar.b(-1);
                    } else {
                        aiVar.b(jSONObject.optInt(l.f7767w));
                    }
                    if (jSONObject.isNull(l.f7768x)) {
                        aiVar.c(-1);
                    } else {
                        aiVar.c(jSONObject.optInt(l.f7768x));
                    }
                    if (jSONObject.isNull("content")) {
                        aiVar.b("");
                    } else {
                        aiVar.b(jSONObject.optString("content"));
                    }
                    if (jSONObject.isNull(str10)) {
                        aiVar.a(-1);
                    } else {
                        aiVar.a(jSONObject.optInt(str10));
                    }
                    if (jSONObject.isNull(str9)) {
                        aiVar.a("");
                    } else {
                        aiVar.a(jSONObject.optString(str9));
                    }
                    if (jSONObject.isNull(str8)) {
                        aiVar.d("unknown");
                    } else {
                        aiVar.d(jSONObject.optString(str8));
                    }
                    str3 = str8;
                    str4 = str9;
                    if (jSONObject.isNull(str7)) {
                        aiVar.c(0L);
                    } else {
                        aiVar.c(jSONObject.optInt(str7));
                    }
                    if (jSONObject.isNull(l.f7762r)) {
                        aiVar.d(0L);
                    } else {
                        aiVar.d(jSONObject.optInt(l.f7762r));
                    }
                    if (jSONObject.isNull(l.f7763s)) {
                        aiVar.h(1);
                    } else {
                        aiVar.h(jSONObject.optInt(l.f7763s));
                    }
                    if (jSONObject.isNull("pacing")) {
                        aiVar.e(-1L);
                    } else {
                        aiVar.e(jSONObject.optLong("pacing"));
                    }
                    if (jSONObject.isNull("unit_id")) {
                        aiVar.e("");
                    } else {
                        aiVar.e(jSONObject.optString("unit_id"));
                    }
                    str5 = str10;
                    if (jSONObject.isNull("ecpm")) {
                        aiVar.a(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                        str2 = str7;
                    } else {
                        str2 = str7;
                        aiVar.a(jSONObject.optDouble("ecpm", PangleAdapterUtils.CPM_DEFLAUT_VALUE));
                    }
                    if (jSONObject.isNull(l.E)) {
                        aiVar.f(com.anythink.expressad.exoplayer.i.a.f9492f);
                    } else {
                        aiVar.f(jSONObject.optInt(l.E));
                    }
                    if (jSONObject.isNull(l.G)) {
                        aiVar.f("");
                    } else {
                        aiVar.f(jSONObject.optString(l.G));
                    }
                    if (jSONObject.isNull(l.H)) {
                        aiVar.i(0);
                    } else {
                        aiVar.i(jSONObject.optInt(l.H));
                    }
                    if (jSONObject.isNull(l.I)) {
                        aiVar.j(3000);
                    } else {
                        aiVar.j(jSONObject.optInt(l.I));
                    }
                    if (jSONObject.isNull("payload")) {
                        aiVar.g("");
                    } else {
                        aiVar.g(jSONObject.optString("payload"));
                    }
                    if (jSONObject.isNull("error")) {
                        aiVar.h("");
                    } else {
                        aiVar.h(jSONObject.optString("error"));
                    }
                    if (jSONObject.isNull(l.J)) {
                        aiVar.g(1800000L);
                    } else {
                        aiVar.g(jSONObject.optLong(l.J));
                    }
                    if (jSONObject.isNull(l.K)) {
                        aiVar.h(-1L);
                    } else {
                        aiVar.h(jSONObject.optLong(l.K));
                    }
                    if (jSONObject.isNull(l.L)) {
                        aiVar.b(1800000L);
                    } else {
                        aiVar.b(jSONObject.optLong(l.L));
                    }
                    if (jSONObject.isNull(l.ai)) {
                        aiVar.g(z2 ? 0 : 1);
                    } else {
                        aiVar.g(jSONObject.optInt(l.ai));
                    }
                    if (jSONObject.isNull(l.M)) {
                        aiVar.k(1);
                    } else {
                        aiVar.k(jSONObject.optInt(l.M));
                    }
                    if (jSONObject.isNull(l.N)) {
                        aiVar.l(1);
                    } else {
                        aiVar.l(jSONObject.optInt(l.N));
                    }
                    if (jSONObject.isNull(l.O)) {
                        aiVar.n(-1);
                    } else {
                        aiVar.n(jSONObject.optInt(l.O));
                    }
                    if (jSONObject.isNull(l.P)) {
                        aiVar.i("publisher_defined");
                    } else {
                        aiVar.i(jSONObject.optString(l.P));
                    }
                    if (jSONObject.isNull(l.Q)) {
                        aiVar.i(0L);
                    } else {
                        aiVar.i(jSONObject.optLong(l.Q));
                    }
                    if (jSONObject.isNull(l.R)) {
                        aiVar.j(0L);
                    } else {
                        aiVar.j(jSONObject.optLong(l.R));
                    }
                    if (jSONObject.isNull(l.S)) {
                        aiVar.b(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                    } else {
                        aiVar.b(jSONObject.optDouble(l.S, PangleAdapterUtils.CPM_DEFLAUT_VALUE));
                    }
                    if (jSONObject.isNull(l.T)) {
                        aiVar.o(1);
                    } else {
                        aiVar.o(jSONObject.optInt(l.T));
                    }
                    if (jSONObject.isNull(l.U)) {
                        aiVar.p(1);
                    } else {
                        aiVar.p(jSONObject.optInt(l.U));
                    }
                    int i4 = 2;
                    if (jSONObject.isNull(l.V)) {
                        aiVar.q(2);
                    } else {
                        aiVar.q(jSONObject.optInt(l.V));
                    }
                    if (jSONObject.isNull(l.W)) {
                        aiVar.f(1);
                    } else {
                        aiVar.f(jSONObject.optInt(l.W));
                    }
                    if (jSONObject.isNull(l.Z)) {
                        aiVar.r(2);
                    } else {
                        aiVar.r(jSONObject.optInt(l.Z));
                    }
                    if (jSONObject.isNull(l.X)) {
                        aiVar.t(2);
                    } else {
                        aiVar.t(jSONObject.optInt(l.X));
                    }
                    if (jSONObject.isNull(l.Y)) {
                        aiVar.s(0);
                    } else {
                        aiVar.s(jSONObject.optInt(l.Y));
                    }
                    if (jSONObject.isNull(l.aa)) {
                        aiVar.u(1);
                    } else {
                        aiVar.u(jSONObject.optInt(l.aa));
                    }
                    if (jSONObject.isNull(l.ad)) {
                        aiVar.j("");
                    } else {
                        aiVar.j(jSONObject.optString(l.ad));
                    }
                    if (i2 == 7) {
                        com.anythink.core.common.d.c.a(n.a().g()).a(aiVar.t(), aiVar.W());
                    }
                    if (jSONObject.isNull(l.ab)) {
                        aiVar.v(2);
                    } else {
                        aiVar.v(jSONObject.optInt(l.ab));
                    }
                    if (jSONObject.isNull("ad_type")) {
                        aiVar.w(-1);
                    } else {
                        aiVar.w(jSONObject.optInt("ad_type", -1));
                    }
                    if (jSONObject.isNull(l.ae)) {
                        aiVar.x(-1);
                    } else {
                        aiVar.x(jSONObject.optInt(l.ae, -1));
                    }
                    if (aiVar.l() == 2 && aiVar.c() == 22) {
                        aiVar.a(ATAdConst.CURRENCY.RMB_CENT);
                    } else {
                        aiVar.a(ATAdConst.CURRENCY.USD);
                    }
                    if (jSONObject.isNull(l.af)) {
                        aiVar.z(0);
                    } else {
                        aiVar.z(jSONObject.optInt(l.af, 0));
                    }
                    if (jSONObject.isNull("bid_floor")) {
                        aiVar.c(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
                    } else {
                        aiVar.c(jSONObject.optDouble("bid_floor", PangleAdapterUtils.CPM_DEFLAUT_VALUE));
                    }
                    if (aiVar.c() >= 100000 && (aTCustomAdapterConfigB = n.a().b(aiVar.h())) != null) {
                        if (!aTCustomAdapterConfigB.isRealTimeBidSwitch()) {
                            i4 = 1;
                        }
                        aiVar.f(i4);
                        aiVar.c(aTCustomAdapterConfigB.getAdCacheTime());
                    }
                    if (jSONObject.isNull(l.al)) {
                        aiVar.A(-1);
                    } else {
                        aiVar.A(jSONObject.optInt(l.al, -1));
                    }
                    if (jSONObject.isNull(l.am)) {
                        aiVar.d(aiVar.x());
                    } else {
                        aiVar.d(jSONObject.optDouble(l.am, aiVar.x()));
                    }
                    if (jSONObject.isNull(l.an)) {
                        aiVar.k("CNY");
                    } else {
                        aiVar.k(jSONObject.optString(l.an, "CNY"));
                    }
                    arrayList.add(aiVar);
                } else {
                    str2 = str7;
                    str3 = str8;
                    str4 = str9;
                    str5 = str10;
                    str6 = str11;
                    jSONArray = jSONArray2;
                }
                i3++;
                str10 = str5;
                jSONArray2 = jSONArray;
                str11 = str6;
                str8 = str3;
                str9 = str4;
                str7 = str2;
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    private static List<s> a(String str, String str2, long j2, u uVar) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                s sVar = new s();
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                sVar.j(jSONObjectOptJSONObject.optString("o_id"));
                sVar.k(jSONObjectOptJSONObject.optString(GMAdConstant.EXTRA_CID));
                sVar.l(jSONObjectOptJSONObject.optString("t"));
                sVar.w(jSONObjectOptJSONObject.optString("p_g"));
                sVar.m(jSONObjectOptJSONObject.optString("d"));
                sVar.n(jSONObjectOptJSONObject.optString("ic_u"));
                sVar.o(jSONObjectOptJSONObject.optString("im_u"));
                sVar.p(jSONObjectOptJSONObject.optString("f_i_u"));
                sVar.q(jSONObjectOptJSONObject.optString("a_c_u"));
                sVar.r(jSONObjectOptJSONObject.optString("c_t"));
                sVar.s(jSONObjectOptJSONObject.optString("v_u"));
                sVar.e(jSONObjectOptJSONObject.optInt("l_t"));
                sVar.t(jSONObjectOptJSONObject.optString("p_u"));
                sVar.u(jSONObjectOptJSONObject.optString("dl"));
                sVar.v(jSONObjectOptJSONObject.optString("c_u"));
                sVar.H(jSONObjectOptJSONObject.optString("ip_u"));
                sVar.I(jSONObjectOptJSONObject.optString("t_u"));
                sVar.J(jSONObjectOptJSONObject.optString("t_u_25"));
                sVar.K(jSONObjectOptJSONObject.optString("t_u_50"));
                sVar.L(jSONObjectOptJSONObject.optString("t_u_75"));
                sVar.M(jSONObjectOptJSONObject.optString("t_u_100"));
                sVar.N(jSONObjectOptJSONObject.optString("s_e_c_t_u"));
                sVar.O(jSONObjectOptJSONObject.optString("c_t_u"));
                sVar.P(jSONObjectOptJSONObject.optString("ip_n_u"));
                sVar.Q(jSONObjectOptJSONObject.optString("c_n_u"));
                sVar.R = jSONObjectOptJSONObject.optInt("o_a_d_c");
                sVar.S = jSONObjectOptJSONObject.optLong("o_a_p");
                sVar.a(j2);
                sVar.d(jSONObjectOptJSONObject.optInt("unit_type"));
                sVar.a(jSONObjectOptJSONObject.optInt("c_m"));
                sVar.b(jSONObjectOptJSONObject.optString("ext_h_pic"));
                sVar.E(jSONObjectOptJSONObject.optString("ext_big_h_pic"));
                sVar.F(jSONObjectOptJSONObject.optString("ext_rect_h_pic"));
                sVar.G(jSONObjectOptJSONObject.optString("ext_home_h_pic"));
                sVar.a(str2);
                sVar.y(jSONObjectOptJSONObject.optString("pub"));
                sVar.z(jSONObjectOptJSONObject.optString("app_vc"));
                sVar.A(jSONObjectOptJSONObject.optString("pvc"));
                sVar.B(jSONObjectOptJSONObject.optString("pms"));
                sVar.a((k) uVar);
                arrayList.add(sVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return arrayList;
    }

    public final Map<String, Object> a(String str, String str2, ai aiVar) {
        m mVarN;
        Map<String, Object> mapC = h.c(aiVar.g());
        boolean zB = g.b();
        com.anythink.core.c.a aVarB = b.a(n.a().g()).b(n.a().p());
        if (!TextUtils.isEmpty(aiVar.y())) {
            mapC.put("payload", aiVar.y());
        }
        if (!TextUtils.isEmpty(aiVar.R())) {
            mapC.put("custom_inhouse_bid_result", aiVar.R());
        }
        boolean z2 = false;
        mapC.put(g.k.f6893c, Boolean.valueOf(aVarB.p() == 3));
        if (aVarB.q() == 2 && zB) {
            z2 = true;
        }
        mapC.put(g.k.f6894d, Boolean.valueOf(z2));
        mapC.put(g.k.f6895e, Boolean.valueOf(p.a(n.a().g()).c()));
        mapC.put("ad_type", Integer.valueOf(aiVar.Y()));
        if (this.ay == 1) {
            mapC.put(g.k.f6903m, str + "_" + this.C + "_" + this.f6697m);
        }
        mapC.put(g.k.f6904n, v.a().g(str));
        if (aiVar.c() == 28 && (mVarN = aiVar.N()) != null) {
            mapC.put(g.k.f6905o, Double.valueOf(com.anythink.core.common.k.g.a(aiVar) * mVarN.f7347l));
        }
        String strL = com.anythink.core.common.k.d.l();
        if (!TextUtils.isEmpty(strL)) {
            mapC.put(ATAdConst.KEY.WECHAT_APPID, strL);
        }
        if (aiVar.c() == 35 || aiVar.l() == 3 || aiVar.l() == 4 || aiVar.l() == 7) {
            com.anythink.core.common.e.j jVar = new com.anythink.core.common.e.j();
            jVar.a = aiVar.y();
            jVar.f7305f = aiVar.c();
            jVar.f7302c = aiVar.t();
            jVar.f7303d = str2;
            jVar.b = str;
            jVar.f7307h = this.C;
            jVar.f7308i = this.f6697m;
            jVar.f7309j = this.f6705u;
            jVar.f7306g = aiVar.d();
            m mVarN2 = aiVar.N();
            jVar.f7310k = mVarN2 != null ? mVarN2.f7342g : "";
            jVar.f7311l = mVarN2 != null ? mVarN2.f7343h : "";
            if (aiVar.c() == 35) {
                jVar.f7312m = this.T;
            } else {
                jVar.f7312m = ab.c(this.aF);
            }
            k kVar = jVar.f7312m;
            if (kVar != null) {
                kVar.q(this.f6705u);
            }
            jVar.f7313n = mVarN2 != null ? mVarN2.f7341f : 0L;
            mapC.put(g.k.a, jVar);
        }
        if (aiVar.ai()) {
            mapC.put(g.k.f6899i, this.ar);
        }
        if (aiVar.c() == 50 && this.aB == 1) {
            mapC.put(g.k.f6907q, str2);
        }
        if (aiVar.c() == 46) {
            ATAdConst.CURRENCY currency = ATAdConst.CURRENCY.RMB;
            if (TextUtils.equals(aiVar.ah(), "USD")) {
                currency = ATAdConst.CURRENCY.USD;
            }
            mapC.put(g.k.f6908r, currency);
        }
        return mapC;
    }
}
