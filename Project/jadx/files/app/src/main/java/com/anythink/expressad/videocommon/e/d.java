package com.anythink.expressad.videocommon.e;

import android.text.TextUtils;
import com.anythink.core.common.b.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    public static final int a = 2;
    private static com.anythink.expressad.foundation.c.c ak = null;
    public static final int b = 4;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12241c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12242d = 6;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12243e = 7;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12244f = -2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12245g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12246h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f12247i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12248j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12249k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12250l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f12251m = 5;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12252n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f12253o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f12254p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f12255q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f12256r = -2;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f12257s = -3;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f12258t = 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f12259u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f12260v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f12261w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f12262x;
    private List<com.anythink.expressad.videocommon.c.b> A;
    private long B;
    private ArrayList<Integer> V;
    private int ai;
    private int al;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private String f12263y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private String f12264z;
    private int C = -1;
    private int D = 0;
    private int E = 0;
    private int F = 1;
    private int G = 1;
    private int H = 1;
    private int I = 1;
    private double J = 1.0d;
    private int K = 2;
    private int L = 5;
    private int M = 1;
    private int N = 3;
    private int O = 80;
    private int P = 100;
    private int Q = 0;
    private double R = 1.0d;
    private int S = -1;
    private int T = 2;
    private double U = 1.0d;
    private int W = 3;
    private int X = 1;
    private int Y = 0;
    private int Z = 10;
    private int aa = 60;
    private String ab = "";
    private int ac = 0;
    private int ad = 70;
    private int ae = 0;
    private int af = -1;
    private int ag = -1;
    private int ah = -1;
    private int aj = 20;
    private int am = 0;
    private int an = 1;
    private String ao = "";
    private int ap = 1;
    private String aq = "";
    private int ar = 1;
    private String as = "Virtual Item";
    private int at = 0;
    private int au = 1;
    private int av = 60;

    public static String J() {
        return f12262x;
    }

    private String W() {
        return this.ab;
    }

    private int X() {
        return this.Z;
    }

    private int Y() {
        return this.aa;
    }

    private ArrayList<Integer> Z() {
        return this.V;
    }

    private int aa() {
        return this.ae;
    }

    private int ab() {
        return this.D;
    }

    private int ac() {
        return this.am;
    }

    private int ad() {
        return this.an;
    }

    private String ae() {
        return this.ao;
    }

    private String af() {
        return this.aq;
    }

    private int ag() {
        return this.ar;
    }

    private int ah() {
        return this.N;
    }

    private int ai() {
        return this.O;
    }

    private int aj() {
        return this.G;
    }

    private int ak() {
        return this.I;
    }

    private double al() {
        return this.J;
    }

    private int am() {
        return this.K;
    }

    private int an() {
        return this.F;
    }

    private long ao() {
        return this.B;
    }

    private String ap() {
        return this.f12263y;
    }

    private double aq() {
        return this.R;
    }

    private int ar() {
        return this.W;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.util.Queue<java.lang.Integer> as() {
        /*
            r4 = this;
            r0 = 0
            java.util.List<com.anythink.expressad.videocommon.c.b> r1 = r4.A     // Catch: java.lang.Exception -> L33
            if (r1 == 0) goto L3f
            java.util.List<com.anythink.expressad.videocommon.c.b> r1 = r4.A     // Catch: java.lang.Exception -> L33
            int r1 = r1.size()     // Catch: java.lang.Exception -> L33
            if (r1 <= 0) goto L3f
            java.util.LinkedList r1 = new java.util.LinkedList     // Catch: java.lang.Exception -> L33
            r1.<init>()     // Catch: java.lang.Exception -> L33
            r0 = 0
        L13:
            java.util.List<com.anythink.expressad.videocommon.c.b> r2 = r4.A     // Catch: java.lang.Exception -> L31
            int r2 = r2.size()     // Catch: java.lang.Exception -> L31
            if (r0 >= r2) goto L3e
            java.util.List<com.anythink.expressad.videocommon.c.b> r2 = r4.A     // Catch: java.lang.Exception -> L31
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Exception -> L31
            com.anythink.expressad.videocommon.c.b r2 = (com.anythink.expressad.videocommon.c.b) r2     // Catch: java.lang.Exception -> L31
            int r2 = r2.a()     // Catch: java.lang.Exception -> L31
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L31
            r1.add(r2)     // Catch: java.lang.Exception -> L31
            int r0 = r0 + 1
            goto L13
        L31:
            r0 = move-exception
            goto L37
        L33:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L37:
            boolean r2 = com.anythink.expressad.a.a
            if (r2 == 0) goto L3e
            r0.printStackTrace()
        L3e:
            r0 = r1
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.videocommon.e.d.as():java.util.Queue");
    }

    private int at() {
        return this.at;
    }

    private void b(int i2) {
        this.Z = i2;
    }

    private void c(int i2) {
        this.aa = i2;
    }

    private void d(String str) {
        this.ab = str;
    }

    public final int A() {
        return this.H;
    }

    public final void B() {
        this.H = 1;
    }

    public final void C() {
        this.I = 1;
    }

    public final int D() {
        return this.L;
    }

    public final void E() {
        this.L = 1;
    }

    public final int F() {
        return this.M;
    }

    public final void G() {
        this.M = 1;
    }

    public final void H() {
        this.F = 1;
    }

    public final List<com.anythink.expressad.videocommon.c.b> I() {
        return this.A;
    }

    public final int K() {
        return this.T;
    }

    public final double L() {
        return this.U;
    }

    public final int M() {
        return this.X;
    }

    public final void N() {
        this.X = 1;
    }

    public final String O() {
        return this.f12264z;
    }

    public final void P() {
        this.W = 3;
    }

    public final Queue<Integer> Q() {
        LinkedList linkedList;
        Exception e2;
        try {
        } catch (Exception e3) {
            linkedList = null;
            e2 = e3;
        }
        if (this.A == null || this.A.size() <= 0) {
            return null;
        }
        linkedList = new LinkedList();
        for (int i2 = 0; i2 < this.A.size(); i2++) {
            try {
                linkedList.add(Integer.valueOf(this.A.get(i2).b()));
            } catch (Exception e4) {
                e2 = e4;
                e2.printStackTrace();
            }
        }
        return linkedList;
        e2.printStackTrace();
        return linkedList;
    }

    public final JSONObject R() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("unitId", this.f12263y);
            jSONObject.put(b.f12217g, this.F);
            if (this.A != null && this.A.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (com.anythink.expressad.videocommon.c.b bVar : this.A) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", bVar.a());
                    jSONObject2.put("timeout", bVar.b());
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            jSONObject.put("aqn", this.G);
            jSONObject.put("acn", this.H);
            jSONObject.put("vcn", this.I);
            jSONObject.put("cbp", this.J);
            jSONObject.put("ttc_type", this.K);
            jSONObject.put("offset", this.L);
            jSONObject.put("dlnet", this.M);
            jSONObject.put(b.J, this.N);
            jSONObject.put(b.K, this.O);
            jSONObject.put("ready_rate", this.P);
            jSONObject.put("endscreen_type", this.al);
            jSONObject.put(b.O, this.ae);
            jSONObject.put(b.P, this.af);
            jSONObject.put(b.Q, this.ag);
            jSONObject.put(b.R, this.ah);
            jSONObject.put("orientation", this.ac);
            jSONObject.put(b.S, this.ai);
            jSONObject.put("playclosebtn_tm", this.C);
            jSONObject.put("play_ctdown", this.D);
            jSONObject.put("close_alert", this.E);
            jSONObject.put(b.ac, this.S);
            jSONObject.put(b.aa, this.R);
            jSONObject.put(b.ar, this.T);
            jSONObject.put(b.as, this.U);
            JSONArray jSONArray2 = new JSONArray();
            if (this.V != null) {
                if (this.V.size() > 0) {
                    Iterator<Integer> it = this.V.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put(it.next());
                    }
                }
                jSONObject.put(b.ao, jSONArray2);
            }
            jSONObject.put(b.ap, this.W);
            jSONObject.put("tmorl", this.X);
            jSONObject.put(b.ax, this.Y);
            jSONObject.put("placementid", this.f12264z);
            jSONObject.put("ltafemty", this.Z);
            jSONObject.put("ltorwc", this.aa);
            jSONObject.put("amount_max", this.am);
            jSONObject.put("callback_rule", this.an);
            jSONObject.put("virtual_currency", this.ao);
            jSONObject.put("amount", this.ap);
            jSONObject.put("icon", this.aq);
            jSONObject.put("currency_id", this.ar);
            jSONObject.put("name", this.as);
            jSONObject.put("isDefault", this.at);
            jSONObject.put(b.aN, this.au);
            jSONObject.put(b.aO, this.av);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final int S() {
        return this.ad;
    }

    public final void T() {
        this.ad = 70;
    }

    public final int U() {
        return this.au;
    }

    public final int V() {
        return this.av;
    }

    public final int a() {
        return this.Y;
    }

    public final int e() {
        return this.af;
    }

    public final int f() {
        return this.ag;
    }

    public final void g() {
        this.ag = 2;
    }

    public final int h() {
        return this.ah;
    }

    public final void i() {
        this.ah = -1;
    }

    public final int j() {
        return this.C;
    }

    public final int k() {
        return this.E;
    }

    public final void l() {
        this.E = 1;
    }

    public final int m() {
        return this.ap;
    }

    public final String n() {
        return this.as;
    }

    public final int o() {
        return this.aj;
    }

    public final int p() {
        return this.ai;
    }

    public final void q() {
        this.ai = 1;
    }

    public final int r() {
        return this.al;
    }

    public final void s() {
        this.al = 2;
    }

    public final void t() {
        this.N = 3;
    }

    public final void u() {
        this.O = 80;
    }

    public final int v() {
        return this.P;
    }

    public final void w() {
        this.P = 100;
    }

    public final int x() {
        return this.Q;
    }

    public final void y() {
        this.Q = 0;
    }

    public final void z() {
        this.G = 1;
    }

    private void d(int i2) {
        this.Y = i2;
    }

    private void e(int i2) {
        this.C = i2;
    }

    private void f(int i2) {
        this.D = i2;
    }

    private void g(int i2) {
        this.am = i2;
    }

    private void h(int i2) {
        this.an = i2;
    }

    private void i(int i2) {
        if (i2 <= 0) {
            this.ap = 1;
        } else {
            this.ap = i2;
        }
    }

    private void j(int i2) {
        this.ar = i2;
    }

    private void k(int i2) {
        this.aj = i2;
    }

    private void l(int i2) {
        this.K = i2;
    }

    private int m(int i2) {
        if (this.S == -1) {
            if (i2 == 94) {
                return 2;
            }
            if (i2 == 287) {
                return 3;
            }
        }
        return this.S;
    }

    private void n(int i2) {
        this.T = i2;
    }

    private boolean o(int i2) {
        ArrayList<Integer> arrayList = this.V;
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        return this.V.contains(Integer.valueOf(i2));
    }

    private void p(int i2) {
        this.S = i2;
    }

    private void q(int i2) {
        this.at = i2;
    }

    private void r(int i2) {
        this.au = i2;
    }

    private void s(int i2) {
        this.av = i2;
    }

    public final void a(ArrayList<Integer> arrayList) {
        this.V = arrayList;
    }

    public final int b() {
        return this.ac;
    }

    public final void c() {
        this.ac = 0;
    }

    private void b(double d2) {
        this.R = d2;
    }

    private void c(double d2) {
        this.U = d2;
    }

    private void e(String str) {
        this.ao = str;
    }

    private void f(String str) {
        this.aq = str;
    }

    private void g(String str) {
        if (TextUtils.isEmpty(str)) {
            this.as = this.ao;
        } else {
            this.as = str;
        }
    }

    private static void h(String str) {
        f12262x = str;
    }

    public final void a(int i2) {
        this.af = i2;
    }

    public final void d() {
        this.ae = 0;
    }

    private void a(double d2) {
        this.J = d2;
    }

    public static d c(String str) {
        JSONObject jSONObjectOptJSONObject;
        if (ak == null) {
            ak = com.anythink.expressad.foundation.c.c.a(n.a().g());
        }
        d dVar = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unitSetting");
                if (jSONArrayOptJSONArray == null || (jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0)) == null) {
                    return null;
                }
                String strOptString = jSONObjectOptJSONObject.optString("unitId");
                if (TextUtils.isEmpty(strOptString)) {
                    return null;
                }
                d dVar2 = new d();
                try {
                    List<com.anythink.expressad.videocommon.c.b> listA = com.anythink.expressad.videocommon.c.b.a(jSONObjectOptJSONObject.optJSONArray("adSourceList"));
                    dVar2.f12263y = strOptString;
                    dVar2.A = listA;
                    dVar2.F = jSONObjectOptJSONObject.optInt(b.f12217g);
                    int iOptInt = jSONObjectOptJSONObject.optInt("aqn", 1);
                    if (iOptInt <= 0) {
                        iOptInt = 1;
                    }
                    dVar2.G = iOptInt;
                    int iOptInt2 = jSONObjectOptJSONObject.optInt("acn", 1);
                    if (iOptInt2 < 0) {
                        iOptInt2 = 1;
                    }
                    dVar2.H = iOptInt2;
                    dVar2.I = jSONObjectOptJSONObject.optInt("vcn", 5);
                    dVar2.J = jSONObjectOptJSONObject.optDouble("cbp", 1.0d);
                    dVar2.K = jSONObjectOptJSONObject.optInt("ttc_type", 2);
                    dVar2.L = jSONObjectOptJSONObject.optInt("offset", 5);
                    dVar2.M = jSONObjectOptJSONObject.optInt("dlnet", 1);
                    dVar2.al = jSONObjectOptJSONObject.optInt("endscreen_type", 2);
                    dVar2.N = jSONObjectOptJSONObject.optInt(b.J, 3);
                    dVar2.O = jSONObjectOptJSONObject.optInt(b.K, 80);
                    dVar2.P = jSONObjectOptJSONObject.optInt("ready_rate", 100);
                    dVar2.Q = jSONObjectOptJSONObject.optInt("cd_rate", 0);
                    dVar2.B = jSONObject.optLong("current_time");
                    dVar2.ac = jSONObjectOptJSONObject.optInt("orientation", 0);
                    dVar2.ae = jSONObjectOptJSONObject.optInt(b.O, 0);
                    dVar2.af = jSONObjectOptJSONObject.optInt(b.P, -1);
                    dVar2.ag = jSONObjectOptJSONObject.optInt(b.Q, 2);
                    dVar2.ah = jSONObjectOptJSONObject.optInt(b.R, -1);
                    dVar2.ai = jSONObjectOptJSONObject.optInt(b.S, 1);
                    dVar2.C = jSONObjectOptJSONObject.optInt("playclosebtn_tm", -1);
                    dVar2.D = jSONObjectOptJSONObject.optInt("play_ctdown", 0);
                    dVar2.E = jSONObjectOptJSONObject.optInt("close_alert", 0);
                    dVar2.aj = jSONObjectOptJSONObject.optInt(b.I, 20);
                    dVar2.ad = jSONObjectOptJSONObject.optInt(b.aC, 70);
                    dVar2.S = jSONObjectOptJSONObject.optInt(b.ac, -1);
                    dVar2.R = jSONObjectOptJSONObject.optDouble(b.aa, 1.0d);
                    dVar2.T = jSONObjectOptJSONObject.optInt(b.ar, 2);
                    dVar2.U = jSONObjectOptJSONObject.optDouble(b.as, 1.0d);
                    f12262x = jSONObjectOptJSONObject.optString("atzu");
                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray(b.ao);
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    try {
                        if (jSONArrayOptJSONArray2 != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                                arrayList.add(Integer.valueOf(jSONArrayOptJSONArray2.getInt(i2)));
                            }
                        } else {
                            arrayList.add(4);
                            arrayList.add(6);
                        }
                        dVar2.V = arrayList;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    int iOptInt3 = jSONObjectOptJSONObject.optInt(b.ap, 0);
                    if (iOptInt3 <= 0) {
                        iOptInt3 = 3;
                    }
                    dVar2.W = iOptInt3;
                    int iOptInt4 = jSONObjectOptJSONObject.optInt("tmorl", 1);
                    if (iOptInt4 > 2 || iOptInt4 <= 0) {
                        iOptInt4 = 1;
                    }
                    dVar2.X = iOptInt4;
                    dVar2.Y = (dVar2.J != 1.0d && new Random().nextDouble() > dVar2.J) ? 1 : 0;
                    dVar2.f12264z = jSONObjectOptJSONObject.optString("placementid");
                    dVar2.Z = jSONObjectOptJSONObject.optInt("ltafemty", 10);
                    dVar2.aa = jSONObjectOptJSONObject.optInt("ltorwc", 60);
                    dVar2.ab = jSONObjectOptJSONObject.optString(com.anythink.expressad.d.a.b.dI);
                    dVar2.am = jSONObjectOptJSONObject.optInt("amount_max", 0);
                    dVar2.an = jSONObjectOptJSONObject.optInt("callback_rule", 1);
                    dVar2.ao = jSONObjectOptJSONObject.optString("virtual_currency", "");
                    dVar2.i(jSONObjectOptJSONObject.optInt("amount", 1));
                    dVar2.aq = jSONObjectOptJSONObject.optString("icon", "");
                    dVar2.ar = jSONObjectOptJSONObject.optInt("currency_id", 1);
                    dVar2.g(jSONObjectOptJSONObject.optString("name", "Virtual Item"));
                    dVar2.au = jSONObjectOptJSONObject.optInt(b.aN, 1);
                    dVar2.av = jSONObjectOptJSONObject.optInt(b.aO, 60);
                    return dVar2;
                } catch (Exception e3) {
                    e = e3;
                    dVar = dVar2;
                }
            } catch (Exception e4) {
                e = e4;
            }
            e.printStackTrace();
        }
        return dVar;
    }

    public final void b(String str) {
        this.f12264z = str;
    }

    private void a(long j2) {
        this.B = j2;
    }

    public final void a(String str) {
        this.f12263y = str;
    }

    public final void a(List<com.anythink.expressad.videocommon.c.b> list) {
        this.A = list;
    }

    public static d a(JSONObject jSONObject) {
        d dVar;
        if (jSONObject == null) {
            return null;
        }
        try {
            dVar = new d();
            try {
                dVar.A = com.anythink.expressad.videocommon.c.b.a(jSONObject.optJSONArray("adSourceList"));
                dVar.F = jSONObject.optInt(b.f12217g);
                int iOptInt = jSONObject.optInt("aqn", 1);
                if (iOptInt <= 0) {
                    iOptInt = 1;
                }
                dVar.G = iOptInt;
                int iOptInt2 = jSONObject.optInt("acn", 1);
                if (iOptInt2 < 0) {
                    iOptInt2 = 1;
                }
                dVar.H = iOptInt2;
                dVar.I = jSONObject.optInt("vcn", 5);
                dVar.J = jSONObject.optDouble("cbp", 1.0d);
                dVar.K = jSONObject.optInt("ttc_type", 2);
                dVar.L = jSONObject.optInt("offset", 5);
                dVar.M = jSONObject.optInt("dlnet", 2);
                dVar.al = jSONObject.optInt("endscreen_type", 2);
                dVar.N = jSONObject.optInt(b.J, 3);
                dVar.O = jSONObject.optInt(b.K, 80);
                dVar.P = jSONObject.optInt("ready_rate", 100);
                dVar.B = jSONObject.optLong("current_time");
                dVar.ac = jSONObject.optInt("orientation", 0);
                dVar.ae = jSONObject.optInt(b.O, 0);
                dVar.af = jSONObject.optInt(b.P, -1);
                dVar.ag = jSONObject.optInt(b.Q, 2);
                dVar.ah = jSONObject.optInt(b.R, -1);
                dVar.ai = jSONObject.optInt(b.S, 1);
                dVar.C = jSONObject.optInt("playclosebtn_tm", -1);
                dVar.D = jSONObject.optInt("play_ctdown", 0);
                dVar.E = jSONObject.optInt("close_alert", 0);
                dVar.aj = jSONObject.optInt(b.I, 20);
                dVar.S = jSONObject.optInt(b.ac, -1);
                dVar.R = jSONObject.optDouble(b.aa, 1.0d);
                dVar.T = jSONObject.optInt(b.ar, 2);
                dVar.U = jSONObject.optDouble(b.as, 1.0d);
                dVar.ad = jSONObject.optInt(b.aC, 70);
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(b.ao);
                ArrayList<Integer> arrayList = new ArrayList<>();
                try {
                    if (jSONArrayOptJSONArray != null) {
                        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                            arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.getInt(i2)));
                        }
                    } else {
                        arrayList.add(4);
                        arrayList.add(6);
                    }
                    dVar.V = arrayList;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                dVar.W = jSONObject.optInt(b.ap, 3);
                int iOptInt3 = jSONObject.optInt("tmorl", 1);
                if (iOptInt3 > 2 || iOptInt3 <= 0) {
                    iOptInt3 = 1;
                }
                dVar.X = iOptInt3;
                dVar.Y = (dVar.J != 1.0d && new Random().nextDouble() > dVar.J) ? 1 : 0;
                dVar.f12264z = jSONObject.optString("placementid");
                dVar.Z = jSONObject.optInt("ltafemty", 10);
                dVar.aa = jSONObject.optInt("ltorwc", 60);
                dVar.ab = jSONObject.optString(com.anythink.expressad.d.a.b.dI);
                dVar.am = jSONObject.optInt("amount_max", 0);
                dVar.an = jSONObject.optInt("callback_rule", 1);
                dVar.ao = jSONObject.optString("virtual_currency", "");
                dVar.i(jSONObject.optInt("amount", 1));
                dVar.aq = jSONObject.optString("icon", "");
                dVar.ar = jSONObject.optInt("currency_id", 1);
                dVar.g(jSONObject.optString("name", "Virtual Item"));
                dVar.au = jSONObject.optInt(b.aN, 1);
                dVar.av = jSONObject.optInt(b.aO, 60);
                return dVar;
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                return dVar;
            }
        } catch (Exception e4) {
            e = e4;
            dVar = null;
        }
    }
}
