package com.anythink.expressad.d;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.common.b.n;
import com.anythink.expressad.foundation.h.h;
import com.anythink.expressad.foundation.h.i;
import com.anythink.expressad.foundation.h.j;
import com.anythink.expressad.foundation.h.o;
import com.anythink.expressad.foundation.h.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private int A;
    private String B;
    private long C;
    private int D;
    private long E;
    private long F;
    private int G;
    private int H;
    private int I;
    private String J;
    private String K;
    private int L;
    private List<com.anythink.expressad.foundation.d.c> M;
    private List<com.anythink.expressad.foundation.d.b> N;
    private int R;
    private LinkedList<String> S;
    private int Y;
    private List<String> Z;
    private int aE;
    private long aG;
    private long aH;
    private int aI;
    private int aJ;
    private long aK;
    private int aM;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private String ae;
    private String af;
    private String ao;
    private String b;
    private Map<String, C0179a> be;
    private b bg;
    private String bl;
    private String bm;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8350d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8352f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f8353g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Map<String, String> f8354h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f8355i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f8356j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List<c> f8358l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f8359m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f8360n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f8361o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f8362p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8363q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f8364r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8365s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8366t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private long f8367u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private List<String> f8368v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8369w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f8370x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f8371y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f8372z;
    private int a = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8351e = 86400;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f8357k = "";
    private boolean O = false;
    private int P = 3;
    private boolean Q = true;
    private int T = 0;
    private int U = 3600;
    private int V = 10;
    private int W = 120;
    private String X = "";
    private int ag = 1;
    private int ah = 1;
    private int ai = 1;
    private int aj = 0;
    private int ak = 1;
    private String al = "";
    private int am = 0;
    private int an = 2;
    private int ap = 86400;
    private String aq = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKAJ7eXHM==";
    private String ar = "LdxThdi1WBK\\/WgfPhbxQYkeXHBPwHZKsYFh=";
    private int as = 1;
    private int at = 30;
    private int au = 5;
    private int av = 0;
    private int aw = 0;
    private int ax = 9377;
    private int ay = 0;
    private int az = 0;
    private int aA = 0;
    private int aB = 2;
    private int aC = 10;
    private List<Integer> aD = new ArrayList();
    private int aF = 1;
    private int aL = 3;
    private String aN = "";
    private String aO = "";
    private String aP = "";
    private String aQ = "";
    private String aR = "";
    private int aS = 0;
    private int aT = 21600;
    private int aU = 2;
    private int aV = 0;
    private int aW = 0;
    private int aX = 604800;
    private int aY = 0;
    private String aZ = "";
    private String ba = "";
    private String bb = "";
    private String bc = "";
    private String bd = "";
    private int bf = 0;
    private int bh = 0;
    private String bi = "";
    private int bj = 2;
    private int bk = 7200;
    private int bn = 0;
    private boolean bo = false;
    private int bp = 1;
    private int bq = 0;
    private int br = 0;
    private int bs = 0;
    private int bt = 3;
    private int bu = 600;
    private int bv = 10;

    /* JADX INFO: renamed from: com.anythink.expressad.d.a$a, reason: collision with other inner class name */
    public static class C0179a {
        private List<String> a;
        private List<String> b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<String> f8373c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private List<String> f8374d;

        private List<String> a() {
            return this.a;
        }

        private List<String> b() {
            return this.b;
        }

        private List<String> c() {
            return this.f8373c;
        }

        private List<String> d() {
            return this.f8374d;
        }

        private void a(List<String> list) {
            this.a = list;
        }

        private void b(List<String> list) {
            this.b = list;
        }

        private void c(List<String> list) {
            this.f8373c = list;
        }

        private void d(List<String> list) {
            this.f8374d = list;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("x");
                if (jSONArrayOptJSONArray != null) {
                    this.a = h.a(jSONArrayOptJSONArray);
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("y");
                if (jSONArrayOptJSONArray2 != null) {
                    this.b = h.a(jSONArrayOptJSONArray2);
                }
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("width");
                if (jSONArrayOptJSONArray3 != null) {
                    this.f8373c = h.a(jSONArrayOptJSONArray3);
                }
                JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray("height");
                if (jSONArrayOptJSONArray4 != null) {
                    this.f8374d = h.a(jSONArrayOptJSONArray4);
                }
            } catch (Exception e2) {
                if (com.anythink.expressad.a.a) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static class b {
        private String a;
        private String b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f8375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private JSONArray f8376d;

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            b bVar = new b();
            Context contextG = n.a().g();
            bVar.a = jSONObject.optString("title", contextG.getString(i.a(contextG, "anythink_cm_feedback_dialog_title", i.f10649g)));
            bVar.b = jSONObject.optString(com.anythink.expressad.d.a.b.dO, contextG.getString(i.a(contextG, "anythink_cm_feedback_dialog_close_close", i.f10649g)));
            bVar.f8375c = jSONObject.optString(com.anythink.expressad.d.a.b.dP, contextG.getString(i.a(contextG, "anythink_cm_feedback_dialog_close_submit", i.f10649g)));
            bVar.f8376d = jSONObject.optJSONArray("content");
            if (bVar.f8376d == null) {
                bVar.f8376d = new JSONArray();
                bVar.f8376d.put(contextG.getString(i.a(contextG, "anythink_cm_feedback_dialog_content_stuck", i.f10649g)));
                bVar.f8376d.put(contextG.getString(i.a(contextG, "anythink_cm_feedback_dialog_content_cnr", i.f10649g)));
                bVar.f8376d.put(contextG.getString(i.a(contextG, "anythink_cm_feedback_dialog_content_balck_screen", i.f10649g)));
                bVar.f8376d.put(contextG.getString(i.a(contextG, "anythink_cm_feedback_dialog_content_other", i.f10649g)));
            }
            return bVar;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.f8375c;
        }

        public final JSONArray d() {
            return this.f8376d;
        }

        private void b(String str) {
            this.b = str;
        }

        private void c(String str) {
            this.f8375c = str;
        }

        public final String a() {
            return this.a;
        }

        private void a(String str) {
            this.a = str;
        }

        private void a(JSONArray jSONArray) {
            this.f8376d = jSONArray;
        }
    }

    private void A(int i2) {
        this.f8366t = i2;
    }

    private void B(int i2) {
        this.A = i2;
    }

    private void C(int i2) {
        this.f8370x = i2;
    }

    private void D(int i2) {
        this.f8371y = i2;
    }

    private void E(int i2) {
        this.f8372z = i2;
    }

    private void F(int i2) {
        this.aL = i2;
    }

    private void G(int i2) {
        this.aI = i2;
    }

    private void H(int i2) {
        this.aJ = i2;
    }

    private void I(int i2) {
        this.f8352f = i2;
    }

    private void J(int i2) {
        this.f8364r = i2;
    }

    private void K(int i2) {
        this.f8365s = i2;
    }

    private void L(int i2) {
        this.aY = i2;
    }

    private void M(int i2) {
        this.aS = i2;
    }

    private void N(int i2) {
        this.aT = i2;
    }

    private void O(int i2) {
        this.aU = i2;
    }

    private void P(int i2) {
        this.aV = i2;
    }

    private void Q(int i2) {
        this.aW = i2;
    }

    private void R(int i2) {
        this.aX = i2;
    }

    private void S(int i2) {
        this.at = i2;
    }

    private void T(int i2) {
        this.au = i2;
    }

    private void U(int i2) {
        this.av = i2;
    }

    private void V(int i2) {
        this.aw = i2;
    }

    private void W(int i2) {
        this.ax = i2;
    }

    private int X() {
        return this.R;
    }

    private List<com.anythink.expressad.foundation.d.b> Y() {
        return this.N;
    }

    private String Z() {
        return this.X;
    }

    private int aA() {
        return this.aE;
    }

    private int aB() {
        return this.Y;
    }

    private List<String> aC() {
        return this.Z;
    }

    private int aD() {
        return this.aa;
    }

    private int aE() {
        return this.ab;
    }

    private int aF() {
        return this.ac;
    }

    private int aG() {
        return this.ad;
    }

    private String aH() {
        return this.ae;
    }

    private int aI() {
        return this.G;
    }

    private int aJ() {
        return this.H;
    }

    private List<com.anythink.expressad.foundation.d.c> aK() {
        return this.M;
    }

    private int aL() {
        return this.I;
    }

    private String aM() {
        return this.J;
    }

    private int aN() {
        return this.D;
    }

    private long aO() {
        return this.E;
    }

    private long aP() {
        return this.F;
    }

    private long aQ() {
        return this.C * 1000;
    }

    private int aR() {
        return this.f8366t;
    }

    private String aS() {
        return this.B;
    }

    private int aT() {
        return this.f8370x;
    }

    private int aU() {
        return this.f8371y;
    }

    private int aV() {
        return this.f8372z;
    }

    private int aW() {
        return this.aL;
    }

    private long aX() {
        return this.aK;
    }

    private int aY() {
        return this.aI;
    }

    private int aZ() {
        return this.aJ;
    }

    private int aa() {
        return this.V;
    }

    private LinkedList<String> ab() {
        return this.S;
    }

    private int ac() {
        return this.a;
    }

    private int ad() {
        return this.T;
    }

    private int ae() {
        return this.U * 1000;
    }

    private int af() {
        return this.aC;
    }

    private int ag() {
        return this.ay;
    }

    private int ah() {
        return this.az;
    }

    private int ai() {
        return this.aA;
    }

    private int aj() {
        return this.aB;
    }

    private int ak() {
        return this.as;
    }

    private String al() {
        return this.aq;
    }

    private String am() {
        return this.ar;
    }

    private int an() {
        return this.ap;
    }

    private int ao() {
        return this.an;
    }

    private String ap() {
        return this.ao;
    }

    private int aq() {
        return this.ag;
    }

    private int ar() {
        return this.ah;
    }

    private int as() {
        return this.ai;
    }

    private int at() {
        return this.aj;
    }

    private int au() {
        return this.ak;
    }

    private String av() {
        return this.al;
    }

    private int aw() {
        return this.am;
    }

    private int ax() {
        return this.L;
    }

    private String ay() {
        return this.K;
    }

    private int az() {
        return this.aF;
    }

    private int bA() {
        return this.aX;
    }

    private String bB() {
        return this.bc;
    }

    private String bC() {
        return this.bd;
    }

    private Map<String, C0179a> bD() {
        return this.be;
    }

    private boolean bE() {
        return (TextUtils.isEmpty(this.aZ) || TextUtils.isEmpty(this.bb) || TextUtils.isEmpty(this.ba)) ? false : true;
    }

    private int bF() {
        return this.at;
    }

    private int bG() {
        return this.au;
    }

    private int bH() {
        return this.av;
    }

    private int bI() {
        return this.aw;
    }

    private int bJ() {
        return this.ax;
    }

    private boolean bK() {
        return this.O;
    }

    private int bL() {
        return this.P;
    }

    private boolean bM() {
        return this.Q;
    }

    private int bN() {
        return this.bh;
    }

    private String bO() {
        return this.bi;
    }

    private int bP() {
        return this.bj;
    }

    private int bQ() {
        return this.bk;
    }

    private String bR() {
        return this.bm;
    }

    private int bS() {
        return this.bn;
    }

    private boolean bT() {
        return this.bo;
    }

    private int bU() {
        return this.bq;
    }

    private long ba() {
        return this.f8362p;
    }

    private long bb() {
        return this.f8361o;
    }

    private String bc() {
        return this.b;
    }

    private long bd() {
        return this.f8349c;
    }

    private int be() {
        return this.f8350d;
    }

    private long bf() {
        return this.f8351e;
    }

    private int bg() {
        return this.f8352f;
    }

    private List<c> bh() {
        return this.f8358l;
    }

    private String bi() {
        return this.af;
    }

    private String bj() {
        return this.f8357k;
    }

    private long bk() {
        return this.f8356j;
    }

    private Map<String, String> bl() {
        return this.f8354h;
    }

    private boolean bm() {
        return this.f8353g;
    }

    private boolean bn() {
        return this.f8355i;
    }

    private int bo() {
        return this.f8364r;
    }

    private int bp() {
        return this.f8365s;
    }

    private static boolean bq() {
        try {
            com.anythink.expressad.d.b.a();
            com.anythink.expressad.foundation.b.a.b().e();
            a aVarB = com.anythink.expressad.d.b.b();
            if (aVarB != null) {
                return aVarB.f8353g;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return true;
        }
    }

    private String br() {
        return this.aQ;
    }

    private boolean bs() {
        return (TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aQ)) ? false : true;
    }

    private boolean bt() {
        return (TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aR)) ? false : true;
    }

    private int bu() {
        return this.aY;
    }

    private int bv() {
        return this.aS;
    }

    private int bw() {
        return this.aT;
    }

    private int bx() {
        return this.aU;
    }

    private int by() {
        return this.aV;
    }

    private int bz() {
        return this.aW;
    }

    private void d(String str) {
        this.X = str;
    }

    private void g(int i2) {
        this.V = i2;
    }

    private void h(int i2) {
        this.T = i2;
    }

    private void i(int i2) {
        this.U = i2;
    }

    private void j(int i2) {
        this.aD.add(Integer.valueOf(i2));
    }

    private boolean k(int i2) {
        return this.aD.contains(Integer.valueOf(i2));
    }

    private void l(int i2) {
        this.as = i2;
    }

    private void m(int i2) {
        this.ap = i2;
    }

    private void n(int i2) {
        this.an = i2;
    }

    private void o(int i2) {
        this.aF = i2;
    }

    private void p(int i2) {
        this.aE = i2;
    }

    private void q(int i2) {
        this.Y = i2;
    }

    private void r(int i2) {
        this.aa = i2;
    }

    private void s(int i2) {
        this.ab = i2;
    }

    private void t(int i2) {
        this.ac = i2;
    }

    private void u(int i2) {
        this.ad = i2;
    }

    private void v(int i2) {
        this.G = i2;
    }

    private void w(int i2) {
        this.H = i2;
    }

    private void x(int i2) {
        this.I = i2;
    }

    private void y(int i2) {
        this.D = i2;
    }

    private void z(int i2) {
        this.F = i2;
    }

    public final void a() {
        this.R = 10;
    }

    public final int b() {
        return this.W;
    }

    public final void c() {
        this.a = 0;
    }

    public final void e(int i2) {
        this.aA = i2;
    }

    public final void f(int i2) {
        this.aB = i2;
    }

    public final String toString() {
        return "cc=" + this.b + " upal=" + this.f8349c + " cfc=" + this.f8350d + " getpf=" + this.f8351e + " uplc=" + this.f8352f + " rurl=" + this.f8359m;
    }

    private void X(int i2) {
        this.P = i2;
    }

    private void Y(int i2) {
        this.bf = i2;
    }

    private void Z(int i2) {
        this.bh = i2;
    }

    private void aa(int i2) {
        this.bj = i2;
    }

    private void ab(int i2) {
        this.bk = i2;
    }

    private void ac(int i2) {
        this.bp = i2;
    }

    private void ad(int i2) {
        this.br = i2;
    }

    private void ae(int i2) {
        this.bs = i2;
    }

    private void af(int i2) {
        this.bt = i2;
    }

    private void ag(int i2) {
        this.bu = i2;
    }

    private void ah(int i2) {
        this.bv = i2;
    }

    private void e(String str) {
        this.aq = str;
    }

    private void f(String str) {
        this.ar = str;
    }

    private void g(String str) {
        this.ao = str;
    }

    private void k(String str) {
        this.B = str;
    }

    public final void A() {
        this.f8350d = 1;
    }

    public final void B() {
        this.f8355i = true;
    }

    public final String C() {
        return this.aN;
    }

    public final String D() {
        return this.aO;
    }

    public final String E() {
        return this.aP;
    }

    public final String F() {
        return this.aR;
    }

    public final void G() {
        String language = Locale.getDefault().getLanguage();
        if (!((TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aQ)) ? false : true)) {
            if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
                this.aN = "Confirm to close? ";
                this.aO = "You will not be rewarded after closing the window";
                this.aP = "Close it";
                this.aQ = "Continue";
            } else {
                this.aN = "确认关闭？";
                this.aO = "关闭后您将不会获得任何奖励噢~ ";
                this.aP = "确认关闭";
                this.aQ = "继续观看";
            }
        }
        if ((TextUtils.isEmpty(this.aN) || TextUtils.isEmpty(this.aO) || TextUtils.isEmpty(this.aP) || TextUtils.isEmpty(this.aR)) ? false : true) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals(com.anythink.expressad.video.dynview.a.a.V)) {
            this.aN = "Confirm to close? ";
            this.aO = "You will not be rewarded after closing the window";
            this.aP = "Close it";
            this.aR = "Continue";
            return;
        }
        this.aN = "确认关闭？";
        this.aO = "关闭后您将不会获得任何奖励噢~ ";
        this.aP = "确认关闭";
        this.aR = "继续试玩";
    }

    public final String H() {
        return this.aZ;
    }

    public final String I() {
        return this.ba;
    }

    public final String J() {
        return this.bb;
    }

    public final int K() {
        return this.bf;
    }

    public final b L() {
        return this.bg;
    }

    public final String M() {
        return this.bl;
    }

    public final void N() {
        this.bn = 0;
    }

    public final void O() {
        this.bo = false;
    }

    public final int P() {
        return this.bp;
    }

    public final void Q() {
        this.bq = 1;
    }

    public final String R() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.anythink.expressad.d.a.b.f8383h, this.b);
            jSONObject.put(com.anythink.expressad.d.a.b.f8387l, this.f8349c);
            jSONObject.put(com.anythink.expressad.d.a.b.f8388m, this.f8350d);
            jSONObject.put(com.anythink.expressad.d.a.b.f8391p, this.f8352f);
            jSONObject.put(com.anythink.expressad.d.a.b.f8398w, this.f8353g);
            jSONObject.put(com.anythink.expressad.d.a.b.f8390o, this.f8355i);
            jSONObject.put("plct", this.f8360n);
            jSONObject.put(com.anythink.expressad.d.a.b.B, this.f8361o);
            jSONObject.put(com.anythink.expressad.d.a.b.C, this.f8359m);
            jSONObject.put(com.anythink.expressad.d.a.b.G, this.f8363q);
            jSONObject.put("plctb", this.f8367u);
            jSONObject.put(com.anythink.expressad.d.a.b.ab, this.aG);
            jSONObject.put(com.anythink.expressad.d.a.b.ac, this.aH);
            jSONObject.put(com.anythink.expressad.d.a.b.af, this.f8371y);
            jSONObject.put(com.anythink.expressad.d.a.b.ag, this.f8372z);
            jSONObject.put(com.anythink.expressad.d.a.b.f8384i, this.J);
            jSONObject.put(com.anythink.expressad.d.a.b.f8385j, this.K);
            jSONObject.put(com.anythink.expressad.d.a.b.f8386k, this.L);
            jSONObject.put(com.anythink.expressad.d.a.b.ai, this.aK);
            jSONObject.put(com.anythink.expressad.d.a.b.aa, this.f8370x);
            jSONObject.put(com.anythink.expressad.d.a.b.aG, this.F);
            jSONObject.put(com.anythink.expressad.d.a.b.aE, this.D);
            jSONObject.put(com.anythink.expressad.d.a.b.aF, this.E);
            jSONObject.put(com.anythink.expressad.d.a.b.ae, this.aJ);
            jSONObject.put(com.anythink.expressad.d.a.b.bn, this.aL);
            jSONObject.put(com.anythink.expressad.d.a.b.bv, this.aF);
            jSONObject.put("iex", this.I);
            jSONObject.put(com.anythink.expressad.d.a.b.ao, this.G);
            jSONObject.put(com.anythink.expressad.d.a.b.ap, this.H);
            jSONObject.put(com.anythink.expressad.d.a.b.at, this.aM);
            jSONObject.put(com.anythink.expressad.d.a.b.al, this.aE);
            jSONObject.put("pf", this.Y);
            jSONObject.put(com.anythink.expressad.d.a.b.aA, this.aa);
            jSONObject.put(com.anythink.expressad.d.a.b.aB, this.ae);
            jSONObject.put(com.anythink.expressad.d.a.b.ax, this.ab);
            jSONObject.put(com.anythink.expressad.d.a.b.ay, this.ac);
            jSONObject.put(com.anythink.expressad.d.a.b.az, this.ad);
            jSONObject.put(com.anythink.expressad.d.a.b.ad, this.aI);
            jSONObject.put(com.anythink.expressad.d.a.b.bE, this.ah);
            jSONObject.put(com.anythink.expressad.d.a.b.bF, this.ag);
            jSONObject.put(com.anythink.expressad.d.a.b.bG, this.ai);
            jSONObject.put(com.anythink.expressad.d.a.b.bH, this.aj);
            jSONObject.put(com.anythink.expressad.d.a.b.bI, this.ak);
            jSONObject.put(com.anythink.expressad.d.a.b.bK, this.am);
            jSONObject.put(com.anythink.expressad.d.a.b.bJ, this.al);
            jSONObject.put(com.anythink.expressad.d.a.b.bV, this.an);
            jSONObject.put(com.anythink.expressad.d.a.b.bY, this.ap);
            jSONObject.put(com.anythink.expressad.d.a.b.cO, this.a);
            jSONObject.put(com.anythink.expressad.d.a.b.cT, this.bi);
            jSONObject.put(com.anythink.expressad.d.a.b.di, this.W);
            jSONObject.put(com.anythink.expressad.d.a.b.dg, this.V);
            jSONObject.put(com.anythink.expressad.d.a.b.dw, this.bo);
            jSONObject.put(com.anythink.expressad.d.a.b.dt, this.bn);
            jSONObject.put("isDefault", this.bq);
            return jSONObject.toString();
        } catch (Throwable th) {
            o.d("Setting", th.getMessage());
            return null;
        }
    }

    public final int S() {
        return this.br;
    }

    public final int T() {
        return this.bs;
    }

    public final int U() {
        return this.bt;
    }

    public final int V() {
        return this.bu;
    }

    public final int W() {
        return this.bv;
    }

    public final void a(int i2) {
        this.W = i2;
    }

    public final void b(int i2) {
        if (i2 > 0) {
            this.aC = i2;
        }
    }

    public final void c(int i2) {
        this.ay = i2;
    }

    public final void d(int i2) {
        this.az = i2;
    }

    public final void h() {
        this.ak = 1;
    }

    public final void i() {
        this.am = -1;
    }

    public final void j() {
        this.L = 1;
    }

    public final long l() {
        if (this.f8367u <= 0) {
            this.f8367u = com.anythink.expressad.d.a.b.Q;
        }
        return this.f8367u;
    }

    public final void m() {
        this.f8367u = com.anythink.expressad.d.a.b.Q;
    }

    public final int n() {
        return this.aM;
    }

    public final void o() {
        this.aM = com.anythink.expressad.d.a.b.bx;
    }

    public final void p() {
        this.aK = com.anythink.expressad.d.a.b.aC;
    }

    public final long q() {
        return this.aG * 1000;
    }

    public final long r() {
        return this.aH * 1000;
    }

    public final void s() {
        this.aH = 10L;
    }

    public final boolean t() {
        return this.f8363q;
    }

    public final void u() {
        this.f8363q = false;
    }

    public final boolean v() {
        return this.f8359m;
    }

    public final void w() {
        this.f8359m = false;
    }

    public final long x() {
        return this.f8360n;
    }

    public final void y() {
        this.f8360n = com.anythink.expressad.d.a.b.P;
    }

    public final void z() {
        this.f8361o = 0L;
    }

    private void A(String str) {
        this.bm = str;
    }

    private void a(LinkedList<String> linkedList) {
        this.S = linkedList;
    }

    private void b(List<String> list) {
        this.Z = list;
    }

    private void c(List<com.anythink.expressad.foundation.d.c> list) {
        this.M = list;
    }

    private void h(String str) {
        this.al = str;
    }

    private void i(String str) {
        this.ae = str;
    }

    private void j(String str) {
        this.J = str;
    }

    private void m(String str) {
        this.af = str;
    }

    private void n(String str) {
        this.f8357k = str;
    }

    private void o(String str) {
        this.aN = str;
    }

    private void p(String str) {
        this.aO = str;
    }

    private void q(String str) {
        this.aP = str;
    }

    private void r(String str) {
        this.aQ = str;
    }

    private void s(String str) {
        this.aR = str;
    }

    private void t(String str) {
        this.aZ = str;
    }

    private void u(String str) {
        this.ba = str;
    }

    private void v(String str) {
        this.bb = str;
    }

    private void w(String str) {
        this.bc = str;
    }

    private void x(String str) {
        this.bd = str;
    }

    private static Map<String, C0179a> y(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap map = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                C0179a c0179a = new C0179a();
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                if (jSONObjectOptJSONObject != null) {
                    c0179a.a(jSONObjectOptJSONObject);
                }
                map.put(next, c0179a);
            }
            return map;
        } catch (JSONException e2) {
            if (com.anythink.expressad.a.a) {
                e2.printStackTrace();
            }
            return null;
        } catch (Exception e3) {
            if (com.anythink.expressad.a.a) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    private void z(String str) {
        this.bl = str;
    }

    public final void d() {
        this.ag = 1;
    }

    public final void e() {
        this.ah = 1;
    }

    public final void f() {
        this.ai = 1;
    }

    public final void g() {
        this.aj = 0;
    }

    public final int k() {
        return this.A;
    }

    private void a(List<com.anythink.expressad.foundation.d.b> list) {
        this.N = list;
    }

    private void b(long j2) {
        this.C = j2;
    }

    private void c(long j2) {
        this.aG = j2;
    }

    private void d(long j2) {
        this.f8362p = j2;
    }

    private void e(long j2) {
        this.f8349c = j2;
    }

    private void f(long j2) {
        this.f8351e = j2;
    }

    private void g(long j2) {
        this.f8356j = j2;
    }

    public static a b(String str) {
        a aVar;
        ArrayList arrayList;
        ArrayList arrayList2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            aVar = new a();
            try {
                aVar.b = jSONObject.optString(com.anythink.expressad.d.a.b.f8383h);
                aVar.K = jSONObject.optString(com.anythink.expressad.d.a.b.f8385j, "anythink");
                aVar.f8349c = jSONObject.optLong(com.anythink.expressad.d.a.b.f8387l);
                aVar.f8350d = jSONObject.optInt(com.anythink.expressad.d.a.b.f8388m);
                aVar.f8351e = jSONObject.optLong("getpf");
                aVar.f8352f = jSONObject.optInt(com.anythink.expressad.d.a.b.f8391p);
                aVar.f8353g = jSONObject.optBoolean(com.anythink.expressad.d.a.b.f8398w);
                aVar.f8356j = jSONObject.optLong("current_time");
                aVar.f8355i = jSONObject.optBoolean(com.anythink.expressad.d.a.b.f8390o);
                aVar.f8361o = jSONObject.optLong(com.anythink.expressad.d.a.b.B);
                aVar.f8360n = jSONObject.optLong("plct") == 0 ? com.anythink.expressad.d.a.b.P : jSONObject.optLong("plct");
                aVar.f8359m = jSONObject.optBoolean(com.anythink.expressad.d.a.b.C);
                aVar.f8362p = jSONObject.optLong(com.anythink.expressad.d.a.b.F);
                aVar.f8363q = jSONObject.optBoolean(com.anythink.expressad.d.a.b.G);
                aVar.f8364r = jSONObject.optInt(com.anythink.expressad.d.a.b.X);
                aVar.f8365s = jSONObject.optInt(com.anythink.expressad.d.a.b.Y);
                aVar.L = jSONObject.optInt(com.anythink.expressad.d.a.b.f8386k);
                aVar.f8366t = jSONObject.optInt(com.anythink.expressad.d.a.b.Z, 1800);
                aVar.f8370x = jSONObject.optInt(com.anythink.expressad.d.a.b.aa);
                aVar.f8367u = jSONObject.optLong("plctb") == 0 ? com.anythink.expressad.d.a.b.Q : jSONObject.optLong("plctb");
                aVar.aI = jSONObject.optInt(com.anythink.expressad.d.a.b.ad);
                aVar.aJ = jSONObject.optInt(com.anythink.expressad.d.a.b.ae);
                aVar.f8370x = jSONObject.optInt(com.anythink.expressad.d.a.b.aa, 100);
                aVar.f8371y = jSONObject.optInt(com.anythink.expressad.d.a.b.af, 2);
                aVar.f8372z = jSONObject.optInt(com.anythink.expressad.d.a.b.ag, 2);
                boolean z2 = true;
                aVar.A = jSONObject.optInt(com.anythink.expressad.d.a.b.ah, 1);
                aVar.aK = jSONObject.optLong(com.anythink.expressad.d.a.b.ai, com.anythink.expressad.d.a.b.aC);
                aVar.B = jSONObject.optString(com.anythink.expressad.d.a.b.aj);
                aVar.C = jSONObject.optLong(com.anythink.expressad.d.a.b.ak, com.anythink.expressad.d.a.b.aD);
                aVar.D = jSONObject.optInt(com.anythink.expressad.d.a.b.aE, 1);
                aVar.E = jSONObject.optInt(com.anythink.expressad.d.a.b.aF, 604800);
                aVar.F = jSONObject.optInt(com.anythink.expressad.d.a.b.aG, com.anythink.expressad.d.a.b.aK);
                aVar.aL = jSONObject.optInt(com.anythink.expressad.d.a.b.bn, 3);
                aVar.aF = jSONObject.optInt(com.anythink.expressad.d.a.b.bv, 1);
                aVar.af = jSONObject.optString(com.anythink.expressad.d.a.b.aH, "");
                aVar.aE = jSONObject.optInt(com.anythink.expressad.d.a.b.al, 1);
                aVar.ah = jSONObject.optInt(com.anythink.expressad.d.a.b.bE, 1);
                aVar.ag = jSONObject.optInt(com.anythink.expressad.d.a.b.bF, 1);
                aVar.ai = jSONObject.optInt(com.anythink.expressad.d.a.b.bG, 1);
                aVar.aj = jSONObject.optInt(com.anythink.expressad.d.a.b.bH, 0);
                aVar.ak = jSONObject.optInt(com.anythink.expressad.d.a.b.bI, 1);
                aVar.am = jSONObject.optInt(com.anythink.expressad.d.a.b.bK, -1);
                aVar.an = jSONObject.optInt(com.anythink.expressad.d.a.b.bV, 2);
                aVar.ap = jSONObject.optInt(com.anythink.expressad.d.a.b.bY, 86400);
                aVar.ao = jSONObject.optString(com.anythink.expressad.d.a.b.bW);
                aVar.ar = jSONObject.optString(com.anythink.expressad.d.a.b.cG);
                aVar.aq = jSONObject.optString(com.anythink.expressad.d.a.b.cF);
                aVar.as = jSONObject.optInt(com.anythink.expressad.d.a.b.cN);
                aVar.U = jSONObject.optInt(com.anythink.expressad.d.a.b.ci, 3600);
                aVar.T = jSONObject.optInt(com.anythink.expressad.d.a.b.ch, 0);
                try {
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.cg);
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        LinkedList<String> linkedList = new LinkedList<>();
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            linkedList.add(jSONArrayOptJSONArray.optString(i2));
                        }
                        aVar.S = linkedList;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                long jOptLong = jSONObject.optLong(com.anythink.expressad.d.a.b.ab);
                if (jOptLong == 0) {
                    aVar.aG = 20L;
                } else {
                    aVar.aG = jOptLong;
                }
                long jOptLong2 = jSONObject.optLong(com.anythink.expressad.d.a.b.ac);
                if (jOptLong2 == 0) {
                    aVar.aH = 10L;
                } else {
                    aVar.aH = jOptLong2;
                    JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.f8397v);
                    if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                        HashMap map = new HashMap();
                        for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i3);
                            map.put(jSONObjectOptJSONObject.optString("domain"), jSONObjectOptJSONObject.optString("format"));
                        }
                        aVar.f8354h = map;
                    }
                }
                aVar.G = jSONObject.optInt(com.anythink.expressad.d.a.b.ao, 3);
                aVar.H = jSONObject.optInt(com.anythink.expressad.d.a.b.ap, 86400);
                aVar.I = jSONObject.optInt("iex", 1);
                JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.ar);
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                        String strOptString = jSONArrayOptJSONArray3.optString(i4);
                        if (w.b(strOptString)) {
                            arrayList.add(com.anythink.expressad.foundation.d.c.a(new JSONObject(strOptString)));
                        }
                    }
                }
                if (arrayList != null) {
                    aVar.M = arrayList;
                }
                try {
                    JSONArray jSONArrayOptJSONArray4 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.as);
                    if (jSONArrayOptJSONArray4 != null && jSONArrayOptJSONArray4.length() > 0) {
                        arrayList2 = new ArrayList();
                        for (int i5 = 0; i5 < jSONArrayOptJSONArray4.length(); i5++) {
                            String strOptString2 = jSONArrayOptJSONArray4.optString(i5);
                            if (w.b(strOptString2)) {
                                JSONObject jSONObject2 = new JSONObject(strOptString2);
                                arrayList2.add(new com.anythink.expressad.foundation.d.b(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            }
                        }
                    }
                    if (arrayList2 != null) {
                        aVar.N = arrayList2;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                aVar.aM = jSONObject.optInt(com.anythink.expressad.d.a.b.at, com.anythink.expressad.d.a.b.bx);
                aVar.Y = jSONObject.optInt("pf", 900);
                aVar.aa = jSONObject.optInt(com.anythink.expressad.d.a.b.aA, 20);
                aVar.ae = jSONObject.optString(com.anythink.expressad.d.a.b.aB);
                JSONArray jSONArrayOptJSONArray5 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.av);
                if (jSONArrayOptJSONArray5 != null && jSONArrayOptJSONArray5.length() > 0) {
                    ArrayList arrayList3 = new ArrayList();
                    for (int i6 = 0; i6 < jSONArrayOptJSONArray5.length(); i6++) {
                        arrayList3.add(jSONArrayOptJSONArray5.optString(i6));
                    }
                    aVar.Z = arrayList3;
                }
                JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject(com.anythink.expressad.d.a.b.aw);
                if (jSONObjectOptJSONObject2 != null) {
                    aVar.ab = jSONObjectOptJSONObject2.optInt(com.anythink.expressad.d.a.b.ax, 1);
                    aVar.ac = jSONObjectOptJSONObject2.optInt(com.anythink.expressad.d.a.b.ay, 1);
                    aVar.ad = jSONObjectOptJSONObject2.optInt(com.anythink.expressad.d.a.b.az, 1);
                }
                aVar.aN = jSONObject.optString(com.anythink.expressad.d.a.b.ct, "");
                aVar.aO = jSONObject.optString(com.anythink.expressad.d.a.b.cu, "");
                aVar.aP = jSONObject.optString(com.anythink.expressad.d.a.b.cv, "");
                aVar.aQ = jSONObject.optString(com.anythink.expressad.d.a.b.cw, "");
                aVar.aR = jSONObject.optString(com.anythink.expressad.d.a.b.cx, "");
                aVar.aS = jSONObject.optInt(com.anythink.expressad.d.a.b.cy, 0);
                aVar.aT = jSONObject.optInt(com.anythink.expressad.d.a.b.cz, 21600);
                aVar.aU = jSONObject.optInt(com.anythink.expressad.d.a.b.cA, 2);
                aVar.aV = jSONObject.optInt(com.anythink.expressad.d.a.b.cB, 0);
                aVar.aW = jSONObject.optInt(com.anythink.expressad.d.a.b.cC, 0);
                aVar.aX = jSONObject.optInt(com.anythink.expressad.d.a.b.cD, 604800);
                aVar.aY = jSONObject.optInt(com.anythink.expressad.d.a.b.cE, 0);
                aVar.aZ = jSONObject.optString("adchoice_icon", "");
                aVar.bb = jSONObject.optString("adchoice_link", "");
                aVar.ba = jSONObject.optString("adchoice_size", "");
                aVar.bd = jSONObject.optString("platform_logo", "");
                aVar.bc = jSONObject.optString("platform_name", "");
                aVar.be = y(jSONObject.optString(com.anythink.expressad.d.a.b.cM, ""));
                aVar.a = jSONObject.optInt(com.anythink.expressad.d.a.b.cO, 0);
                aVar.bh = jSONObject.optInt(com.anythink.expressad.d.a.b.cQ, 0);
                aVar.W = jSONObject.optInt(com.anythink.expressad.d.a.b.di, 120);
                aVar.V = jSONObject.optInt(com.anythink.expressad.d.a.b.dg, 10);
                aVar.X = jSONObject.optString(com.anythink.expressad.d.a.b.dI, "");
                aVar.bi = jSONObject.optString(com.anythink.expressad.d.a.b.cT, "");
                aVar.bj = jSONObject.optInt(com.anythink.expressad.d.a.b.cU, 2);
                aVar.bk = jSONObject.optInt(com.anythink.expressad.d.a.b.cV, 7200);
                aVar.bm = jSONObject.optString(com.anythink.expressad.d.a.b.ds);
                aVar.bl = jSONObject.optString(com.anythink.expressad.d.a.b.dA);
                int iOptInt = jSONObject.optInt(com.anythink.expressad.d.a.b.dt, 0);
                if (iOptInt > 2 || iOptInt < 0) {
                    iOptInt = 0;
                }
                aVar.bn = iOptInt;
                aVar.bo = jSONObject.optBoolean(com.anythink.expressad.d.a.b.dw, false);
                JSONArray jSONArrayOptJSONArray6 = jSONObject.optJSONArray(com.anythink.expressad.d.a.b.dr);
                if (jSONArrayOptJSONArray6 != null && jSONArrayOptJSONArray6.length() > 0) {
                    for (int i7 = 0; i7 < jSONArrayOptJSONArray6.length(); i7++) {
                        JSONObject jSONObject3 = jSONArrayOptJSONArray6.getJSONObject(i7);
                        Iterator<String> itKeys = jSONObject3.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            if (!TextUtils.isEmpty(next) && jSONObject3.getBoolean(next)) {
                                aVar.aD.add(Integer.valueOf(Integer.parseInt(next)));
                            }
                        }
                    }
                }
                try {
                    int iOptInt2 = jSONObject.optInt("lqcnt", 30);
                    int iOptInt3 = jSONObject.optInt("lqto", 5);
                    int iOptInt4 = jSONObject.optInt("lqswt", 0);
                    int iOptInt5 = jSONObject.optInt("lqtype", 0);
                    aVar.au = iOptInt3;
                    aVar.at = iOptInt2;
                    aVar.av = iOptInt4;
                    aVar.aw = iOptInt5;
                    int i8 = Integer.parseInt(j.b(jSONObject.optString("lqpt")));
                    if (i8 > 0 && i8 < 65535) {
                        aVar.ax = i8;
                    }
                } catch (Exception unused) {
                }
                aVar.bp = jSONObject.optInt(com.anythink.expressad.d.a.b.dB, 0);
                try {
                    int iOptInt6 = jSONObject.optInt("l", 3);
                    boolean z3 = jSONObject.optInt("k", 0) == 1;
                    if (jSONObject.optInt("m", 1) != 1) {
                        z2 = false;
                    }
                    aVar.P = iOptInt6;
                    aVar.O = z3;
                    aVar.Q = z2;
                } catch (Exception e3) {
                    o.d("Setting", e3.getMessage());
                }
                aVar.bf = jSONObject.optInt(com.anythink.expressad.d.a.b.dK, 0);
                aVar.bg = b.a(jSONObject.optJSONObject(com.anythink.expressad.d.a.b.dL));
                try {
                    int iOptInt7 = jSONObject.optInt(com.anythink.expressad.d.a.b.dQ, com.anythink.expressad.foundation.g.a.cH);
                    int iOptInt8 = jSONObject.optInt(com.anythink.expressad.d.a.b.dR, com.anythink.expressad.foundation.g.a.cI);
                    int iOptInt9 = jSONObject.optInt(com.anythink.expressad.d.a.b.dS, com.anythink.expressad.foundation.g.a.cJ);
                    int iOptInt10 = jSONObject.optInt(com.anythink.expressad.d.a.b.dU, com.anythink.expressad.foundation.g.a.cO);
                    if (iOptInt7 <= 0) {
                        iOptInt7 = com.anythink.expressad.foundation.g.a.cH;
                    }
                    if (iOptInt8 <= 0) {
                        iOptInt8 = com.anythink.expressad.foundation.g.a.cI;
                    }
                    if (iOptInt9 <= 0) {
                        iOptInt9 = com.anythink.expressad.foundation.g.a.cJ;
                    }
                    if (iOptInt10 < 0) {
                        iOptInt10 = com.anythink.expressad.foundation.g.a.cO;
                    }
                    aVar.aA = iOptInt7;
                    aVar.ay = iOptInt8;
                    aVar.az = iOptInt9;
                    aVar.aB = iOptInt10;
                    int iOptInt11 = jSONObject.optInt(com.anythink.expressad.d.a.b.dT, 0);
                    if (iOptInt11 < 0) {
                        iOptInt11 = 0;
                    }
                    aVar.R = iOptInt11;
                    aVar.b(jSONObject.optInt(com.anythink.expressad.d.a.b.dV, 10));
                    return aVar;
                } catch (Exception unused2) {
                    return aVar;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            aVar = null;
        }
        e.printStackTrace();
        return aVar;
    }

    private void c(boolean z2) {
        this.Q = z2;
    }

    private void d(List<c> list) {
        this.f8358l = list;
    }

    private void l(String str) {
        this.b = str;
    }

    public final void a(String str) {
        this.K = str;
    }

    private void a(long j2) {
        this.E = j2;
    }

    public final void c(String str) {
        this.bi = str;
    }

    private void a(Map<String, String> map) {
        this.f8354h = map;
    }

    private void a(boolean z2) {
        this.f8353g = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            java.lang.String r0 = "{android_id_md5_upper}"
            java.lang.String r1 = "{android_id}"
            java.lang.String r2 = ""
            com.anythink.expressad.d.b.a()     // Catch: java.lang.Throwable -> L90
            com.anythink.expressad.foundation.b.a r3 = com.anythink.expressad.foundation.b.a.b()     // Catch: java.lang.Throwable -> L90
            r3.e()     // Catch: java.lang.Throwable -> L90
            com.anythink.expressad.d.a r3 = com.anythink.expressad.d.b.b()     // Catch: java.lang.Throwable -> L90
            if (r3 == 0) goto L90
            java.util.Map<java.lang.String, java.lang.String> r4 = r3.f8354h     // Catch: java.lang.Throwable -> L90
            if (r4 != 0) goto L1c
            goto L90
        L1c:
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch: java.lang.Throwable -> L90
            java.lang.String r8 = r8.getHost()     // Catch: java.lang.Throwable -> L90
            java.util.Map<java.lang.String, java.lang.String> r4 = r3.f8354h     // Catch: java.lang.Throwable -> L90
            java.util.Set r4 = r4.entrySet()     // Catch: java.lang.Throwable -> L90
            java.util.Iterator r4 = r4.iterator()     // Catch: java.lang.Throwable -> L90
        L2e:
            boolean r5 = r4.hasNext()     // Catch: java.lang.Throwable -> L90
            if (r5 == 0) goto L90
            java.lang.Object r5 = r4.next()     // Catch: java.lang.Throwable -> L90
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5     // Catch: java.lang.Throwable -> L90
            java.lang.Object r5 = r5.getKey()     // Catch: java.lang.Throwable -> L90
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L90
            boolean r6 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L90
            if (r6 != 0) goto L2e
            boolean r6 = r8.contains(r5)     // Catch: java.lang.Throwable -> L90
            if (r6 == 0) goto L2e
            java.util.Map<java.lang.String, java.lang.String> r8 = r3.f8354h     // Catch: java.lang.Throwable -> L90
            java.lang.Object r8 = r8.get(r5)     // Catch: java.lang.Throwable -> L90
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L90
            boolean r3 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L90
            if (r3 == 0) goto L5b
            return r2
        L5b:
            java.lang.String r3 = "{gaid}"
            java.lang.String r4 = com.anythink.core.common.k.d.f()     // Catch: java.lang.Throwable -> L90
            java.lang.String r8 = r8.replace(r3, r4)     // Catch: java.lang.Throwable -> L90
            boolean r3 = r8.contains(r1)     // Catch: java.lang.Throwable -> L90
            if (r3 == 0) goto L7a
            java.lang.String r0 = com.anythink.core.common.k.d.d(r7)     // Catch: java.lang.Throwable -> L90
            if (r0 == 0) goto L8f
            java.lang.String r7 = com.anythink.core.common.k.d.d(r7)     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = r8.replace(r1, r7)     // Catch: java.lang.Throwable -> L90
            goto L90
        L7a:
            boolean r1 = r8.contains(r0)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            java.lang.String r1 = com.anythink.core.common.k.d.e(r7)     // Catch: java.lang.Throwable -> L90
            if (r1 == 0) goto L8f
            java.lang.String r7 = com.anythink.core.common.k.d.e(r7)     // Catch: java.lang.Throwable -> L90
            java.lang.String r2 = r8.replace(r0, r7)     // Catch: java.lang.Throwable -> L90
            goto L90
        L8f:
            r2 = r8
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.d.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    private void a(b bVar) {
        this.bg = bVar;
    }

    private void b(Map<String, C0179a> map) {
        this.be = map;
    }

    private void b(boolean z2) {
        this.O = z2;
    }
}
