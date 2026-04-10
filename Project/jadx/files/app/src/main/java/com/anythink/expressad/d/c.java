package com.anythink.expressad.d;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final int a = 1;
    public static final int b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8414c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8415d = 3;
    private String A;
    private int B;
    private long C;
    private long D;
    private int F;
    private int G;
    private int H;
    private int N;
    private int P;
    private int Q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8418g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8420i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f8421j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Integer> f8422k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f8423l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f8425n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private List<Integer> f8426o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8427p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8428q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f8429r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8430s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f8431t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f8432u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f8435x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f8436y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f8437z;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f8419h = 30;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8424m = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f8433v = 1;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f8434w = 5000;
    private int E = 60;
    private String I = "";
    private int J = 10;
    private int K = 60;
    private double L = 1.0d;
    private int M = 1;
    private int O = 0;

    private int A() {
        return this.H;
    }

    private int B() {
        return this.M;
    }

    private int C() {
        return this.Q;
    }

    private String D() {
        return this.f8431t;
    }

    private int E() {
        return this.f8432u;
    }

    private int F() {
        return this.P;
    }

    private long G() {
        return this.C;
    }

    private long H() {
        return this.D;
    }

    private String I() {
        return this.A;
    }

    private int J() {
        return this.B;
    }

    private int K() {
        return this.f8416e;
    }

    private int L() {
        return this.f8417f;
    }

    private int M() {
        return this.f8418g;
    }

    private int N() {
        int i2 = this.f8419h;
        if (i2 <= 0 || i2 > 100) {
            this.f8419h = 30;
        }
        return this.f8419h;
    }

    private static c O() {
        return new c();
    }

    private int P() {
        return this.f8430s;
    }

    private int Q() {
        return this.f8433v;
    }

    private int R() {
        return this.f8434w;
    }

    private int S() {
        return this.f8427p;
    }

    private int T() {
        return this.f8428q;
    }

    private int U() {
        return this.f8429r;
    }

    private String V() {
        return this.f8420i;
    }

    private List<Integer> W() {
        return this.f8422k;
    }

    private List<Integer> X() {
        return this.f8426o;
    }

    private long Y() {
        return this.f8423l;
    }

    private int Z() {
        return this.f8425n;
    }

    private String aa() {
        return this.I;
    }

    private int ab() {
        return this.J;
    }

    private int ac() {
        return this.K;
    }

    private void e(int i2) {
        this.M = i2;
    }

    private void f(int i2) {
        this.F = i2;
    }

    private void g(int i2) {
        this.f8432u = i2;
    }

    public static c y() {
        c cVar = new c();
        cVar.f8435x = 0;
        return cVar;
    }

    private int z() {
        return this.G;
    }

    public final double a() {
        return this.L;
    }

    public final void b(int i2) {
        this.H = i2;
    }

    public final void c() {
        this.E = 60;
    }

    public final int d() {
        return this.F;
    }

    public final void h() {
        this.P = 1;
    }

    public final long i() {
        return this.f8437z;
    }

    public final void j() {
        this.f8436y = 2;
    }

    public final int k() {
        return this.f8435x;
    }

    public final void l() {
        this.f8435x = 1;
    }

    public final int m() {
        return this.f8436y;
    }

    public final void n() {
        this.f8437z = com.anythink.expressad.d.a.b.P;
    }

    public final void o() {
        this.f8430s = 5;
    }

    public final void p() {
        this.f8427p = 1;
    }

    public final void q() {
        this.f8428q = -2;
    }

    public final void r() {
        this.f8429r = -2;
    }

    public final JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f8422k != null && this.f8422k.size() > 0) {
                int size = this.f8422k.size();
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < size; i2++) {
                    jSONArray.put(this.f8422k.get(i2));
                }
                jSONObject.put("adSourceList", jSONArray);
            }
            if (this.f8426o != null && this.f8426o.size() > 0) {
                int size2 = this.f8426o.size();
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < size2; i3++) {
                    jSONArray2.put(this.f8426o.get(i3));
                }
                jSONObject.put("ad_source_timeout", jSONArray2);
            }
            jSONObject.put(com.anythink.expressad.d.a.b.J, this.f8427p);
            jSONObject.put("aqn", this.f8428q);
            jSONObject.put("acn", this.f8429r);
            jSONObject.put(com.anythink.expressad.d.a.b.R, this.f8430s);
            jSONObject.put("current_time", this.f8423l);
            jSONObject.put("offset", this.f8424m);
            jSONObject.put("dlct", this.f8437z);
            jSONObject.put(com.anythink.expressad.d.a.b.aX, this.f8435x);
            jSONObject.put("dlnet", this.f8436y);
            jSONObject.put(com.anythink.expressad.d.a.b.aL, this.A);
            jSONObject.put(com.anythink.expressad.d.a.b.aM, this.B);
            jSONObject.put(com.anythink.expressad.d.a.b.aN, this.C);
            jSONObject.put(com.anythink.expressad.d.a.b.aO, this.D);
            jSONObject.put("ready_rate", this.N);
            jSONObject.put("content", this.P);
            jSONObject.put(com.anythink.expressad.d.a.b.bC, this.Q);
            jSONObject.put(com.anythink.expressad.d.a.b.cf, this.f8432u);
            jSONObject.put(com.anythink.expressad.d.a.b.cd, this.f8431t);
            jSONObject.put("playclosebtn_tm", this.f8416e);
            jSONObject.put("play_ctdown", this.f8417f);
            jSONObject.put("close_alert", this.f8418g);
            jSONObject.put(com.anythink.expressad.d.a.b.dd, this.F);
            jSONObject.put(com.anythink.expressad.d.a.b.db, this.E);
            jSONObject.put(com.anythink.expressad.d.a.b.dk, this.H);
            jSONObject.put(com.anythink.expressad.d.a.b.dm, this.G);
            jSONObject.put("tmorl", this.M);
            jSONObject.put("unitId", this.f8420i);
            jSONObject.put("placementid", this.I);
            jSONObject.put("ltafemty", this.J);
            jSONObject.put("ltorwc", this.K);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public final int t() {
        return this.f8424m;
    }

    public final String toString() {
        List<Integer> list = this.f8422k;
        String str = "";
        if (list != null && list.size() > 0) {
            Iterator<Integer> it = this.f8422k.iterator();
            while (it.hasNext()) {
                str = str + it.next() + ",";
            }
        }
        return "offset = " + this.f8424m + " unitId = " + this.f8420i + " fbPlacementId = " + this.f8421j + str;
    }

    public final void u() {
        this.f8424m = 1;
    }

    public final void v() {
        this.f8425n = 2;
    }

    public final void w() {
        this.J = 10;
    }

    public final void x() {
        this.K = 60;
    }

    private void a(double d2) {
        this.L = d2;
    }

    private void f(String str) {
        this.f8431t = str;
    }

    private void h(int i2) {
        this.B = i2;
    }

    private void i(int i2) {
        this.f8416e = i2;
    }

    private void j(int i2) {
        this.f8417f = i2;
    }

    private void k(int i2) {
        this.f8418g = i2;
    }

    private void l(int i2) {
        this.f8419h = i2;
    }

    private void m(int i2) {
        this.f8433v = i2;
    }

    private void n(int i2) {
        this.f8434w = i2;
    }

    public final int b() {
        return this.E;
    }

    public final void c(int i2) {
        try {
            this.N = i2;
        } catch (Exception unused) {
            this.N = 100;
        }
    }

    public final void d(int i2) {
        try {
            this.O = i2;
        } catch (Exception unused) {
            this.O = 0;
        }
    }

    public final void e() {
        this.Q = 0;
    }

    public final int g() {
        return this.O;
    }

    private void b(long j2) {
        this.D = j2;
    }

    private void g(String str) {
        this.A = str;
    }

    public final void a(int i2) {
        this.G = i2;
    }

    public final void e(String str) {
        this.I = str;
    }

    public final int f() {
        return this.N;
    }

    private void a(long j2) {
        this.C = j2;
    }

    private void c(long j2) {
        this.f8423l = j2;
    }

    public static c d(String str) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(1);
            cVar.f8422k = arrayList;
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(30);
            cVar.f8426o = arrayList2;
            cVar.f8420i = str;
            cVar.f8424m = 1;
            cVar.f8427p = 1;
            cVar.f8429r = -2;
            cVar.f8428q = -2;
            cVar.f8430s = 5;
            cVar.f8437z = com.anythink.expressad.d.a.b.P;
            cVar.f8436y = 2;
            cVar.f8435x = 3;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return cVar;
    }

    public final void b(List<Integer> list) {
        this.f8426o = list;
    }

    public static c b(String str) {
        c cVar = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            c cVar2 = new c();
            try {
                JSONObject jSONObject = new JSONObject(str);
                cVar2.f8420i = jSONObject.optString("unitId");
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("adSourceList");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        arrayList.add(Integer.valueOf(jSONArrayOptJSONArray.optInt(i2)));
                    }
                    cVar2.f8422k = arrayList;
                }
                JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("ad_source_timeout");
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                        arrayList2.add(Integer.valueOf(jSONArrayOptJSONArray2.optInt(i3)));
                    }
                    cVar2.f8426o = arrayList2;
                }
                cVar2.f8427p = jSONObject.optInt(com.anythink.expressad.d.a.b.J);
                cVar2.f8428q = jSONObject.optInt("aqn");
                cVar2.f8429r = jSONObject.optInt("acn");
                cVar2.f8430s = jSONObject.optInt(com.anythink.expressad.d.a.b.R);
                cVar2.f8433v = jSONObject.optInt(com.anythink.expressad.d.a.b.S, 1);
                cVar2.f8434w = jSONObject.optInt(com.anythink.expressad.d.a.b.T, 5000);
                cVar2.f8423l = jSONObject.optLong("current_time");
                cVar2.f8424m = jSONObject.optInt("offset");
                cVar2.f8437z = jSONObject.optLong("dlct", com.anythink.expressad.d.a.b.P);
                cVar2.f8435x = jSONObject.optInt(com.anythink.expressad.d.a.b.aX, 0);
                cVar2.f8436y = jSONObject.optInt("dlnet", 2);
                cVar2.A = jSONObject.optString(com.anythink.expressad.d.a.b.aL);
                cVar2.B = jSONObject.optInt(com.anythink.expressad.d.a.b.aM);
                cVar2.C = jSONObject.optLong(com.anythink.expressad.d.a.b.aN, 86400L);
                cVar2.D = jSONObject.optLong(com.anythink.expressad.d.a.b.aO, 300L);
                cVar2.c(jSONObject.optInt("ready_rate", 100));
                cVar2.d(jSONObject.optInt("cd_rate", 0));
                cVar2.P = jSONObject.optInt("content", 1);
                cVar2.Q = jSONObject.optInt(com.anythink.expressad.d.a.b.bC, 0);
                cVar2.f8432u = jSONObject.optInt(com.anythink.expressad.d.a.b.cf, 1);
                cVar2.f8431t = jSONObject.optString(com.anythink.expressad.d.a.b.cd, "");
                cVar2.f8416e = jSONObject.optInt("playclosebtn_tm", -1);
                cVar2.f8417f = jSONObject.optInt("play_ctdown", 0);
                cVar2.f8418g = jSONObject.optInt("close_alert", 0);
                cVar2.f8419h = jSONObject.optInt(com.anythink.expressad.d.a.b.cr, 30);
                cVar2.E = jSONObject.optInt(com.anythink.expressad.d.a.b.db, 60);
                cVar2.F = jSONObject.optInt(com.anythink.expressad.d.a.b.dd, 0);
                int iOptInt = jSONObject.optInt("tmorl", 1);
                if (iOptInt > 2 || iOptInt <= 0) {
                    iOptInt = 1;
                }
                cVar2.M = iOptInt;
                cVar2.I = jSONObject.optString("placementid", "");
                cVar2.J = jSONObject.optInt("ltafemty", 10);
                cVar2.K = jSONObject.optInt("ltorwc", 60);
                return cVar2;
            } catch (Exception e2) {
                e = e2;
                cVar = cVar2;
            }
        } catch (Exception e3) {
            e = e3;
        }
        e.printStackTrace();
        return cVar;
    }

    public static c c(String str) {
        c cVar = new c();
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(8);
        arrayList2.add(8);
        cVar.f8424m = 1;
        cVar.f8420i = str;
        cVar.f8422k = arrayList;
        cVar.f8426o = arrayList2;
        cVar.f8427p = 1;
        cVar.f8429r = -2;
        cVar.f8428q = -2;
        cVar.f8430s = 5;
        cVar.f8437z = com.anythink.expressad.d.a.b.P;
        cVar.f8436y = 2;
        cVar.f8435x = 1;
        cVar.c(100);
        cVar.d(0);
        cVar.P = 1;
        cVar.Q = 0;
        cVar.E = 60;
        cVar.J = 10;
        cVar.K = 60;
        return cVar;
    }

    public final void a(String str) {
        this.f8420i = str;
    }

    public final void a(List<Integer> list) {
        this.f8422k = list;
    }

    private Queue<Integer> d(List<Integer> list) {
        LinkedList linkedList = new LinkedList();
        try {
            if (this.f8422k != null && this.f8422k.size() > 0) {
                for (Integer num : list) {
                    if (num != null) {
                        linkedList.add(Integer.valueOf(num.intValue() * 1000));
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return linkedList;
    }

    private static Queue<Integer> c(List<Integer> list) {
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            try {
                if (list.size() > 0) {
                    for (Integer num : list) {
                        if (num != null) {
                            linkedList.add(num);
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return linkedList;
    }
}
