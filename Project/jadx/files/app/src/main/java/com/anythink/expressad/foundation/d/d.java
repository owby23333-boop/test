package com.anythink.expressad.foundation.d;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.anythink.core.api.IExHandler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements com.anythink.expressad.e.b, Serializable {
    public static final String A = "cam_tpl_url";
    public static final String B = "cam_html";
    public static final String C = "cam_tpl_url";
    public static final String D = "cam_html";
    public static final String E = "nscpt";
    public static final String F = "mof_template_url";
    public static final String G = "mof_tplid";
    public static final String H = "req_ext_data";
    public static final String I = "replace_tmp";
    private static final String K = d.class.getSimpleName();
    private static final long L = 1;
    public static final String a = "a";
    public static final String b = "pv_urls";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10213c = "parent_session_id";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10214d = "ad_type";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10215e = "unit_size";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f10216f = "html_url";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f10217g = "only_impression_url";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f10218h = "ads";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f10219i = "template";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f10220j = "frames";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f10221k = "end_screen_url";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f10222l = "jm_do";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f10223m = "rks";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f10224n = "vcn";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f10225o = "token_r";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f10226p = "encrypt_p";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f10227q = "irlfa";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f10228r = "csp";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f10229s = "do";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f10230t = "sh";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f10231u = "ia_icon";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f10232v = "ia_rst";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f10233w = "ia_url";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f10234x = "ia_ori";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f10235y = "ia_all_ext1";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f10236z = "ia_all_ext2";
    public ArrayList<c> J;
    private String N;
    private String O;
    private String P;
    private String Q;
    private String R;
    private int S;
    private String T;
    private int U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private int Z;
    private String aa;
    private String ab;
    private String ac;
    private int ad;
    private List<com.anythink.expressad.out.l> ae;
    private HashMap<String, String> ag;
    private HashMap<String, String> ah;
    private String ai;
    private String aj;
    private String ak;
    private int al;
    private int am;
    private int ao;
    private String ap;
    private String M = "";
    private StringBuffer af = new StringBuffer();
    private String an = "";

    private String A() {
        return this.aa;
    }

    private String B() {
        return this.ab;
    }

    private String C() {
        return this.ac;
    }

    private ArrayList<c> D() {
        return this.J;
    }

    private int E() {
        return this.ad;
    }

    private static Object a(Object obj) {
        return obj == null ? "" : obj;
    }

    private void a(int i2) {
        this.S = i2;
    }

    private void b(String str) {
        this.M = str;
    }

    private void c(String str) {
        this.N = str;
    }

    private void d(String str) {
        this.O = str;
    }

    private void e(String str) {
        this.P = str;
    }

    private void f(String str) {
        this.Q = str;
    }

    private String g() {
        return this.M;
    }

    private String h() {
        return this.N;
    }

    private String i() {
        return this.O;
    }

    private String j() {
        return this.P;
    }

    private String k() {
        return this.Q;
    }

    private String l() {
        return this.R;
    }

    private int m() {
        return this.S;
    }

    private String n() {
        return this.T;
    }

    private int o() {
        return this.U;
    }

    private String p() {
        return this.V;
    }

    private String q() {
        return this.W;
    }

    private String r() {
        return this.an;
    }

    private int s() {
        int i2 = this.al;
        if (i2 > 1) {
            return i2;
        }
        return 1;
    }

    private int t() {
        int i2 = this.am;
        if (i2 == 1) {
            return i2;
        }
        return 0;
    }

    private String u() {
        return this.ai;
    }

    private String v() {
        return this.aj;
    }

    private String w() {
        return this.ak;
    }

    private int x() {
        return this.ao;
    }

    private List<com.anythink.expressad.out.l> y() {
        return this.ae;
    }

    private String z() {
        return this.Y;
    }

    private void b(int i2) {
        this.U = i2;
    }

    private void c(int i2) {
        this.al = i2;
    }

    private void d(int i2) {
        this.am = i2;
    }

    private void e(int i2) {
        this.ao = i2;
    }

    private void f(int i2) {
        this.Z = i2;
    }

    private void g(String str) {
        this.R = str;
    }

    private void h(String str) {
        this.T = str;
    }

    private void i(String str) {
        this.V = str;
    }

    private void j(String str) {
        this.W = str;
    }

    private void k(String str) {
        this.an = str;
    }

    private void l(String str) {
        this.ai = str;
    }

    private void m(String str) {
        this.aj = str;
    }

    private void n(String str) {
        this.ak = str;
    }

    private void o(String str) {
        this.X = str;
    }

    private void p(String str) {
        this.Y = str;
    }

    private void q(String str) {
        this.aa = str;
    }

    private void r(String str) {
        this.ab = str;
    }

    private void s(String str) {
        this.ac = str;
    }

    public final HashMap<String, String> a() {
        return this.ag;
    }

    private void a(HashMap<String, String> map) {
        this.ag = map;
    }

    private void g(int i2) {
        this.ad = i2;
    }

    public final HashMap<String, String> b() {
        return this.ah;
    }

    public final String c() {
        return this.X;
    }

    public final int d() {
        return this.Z;
    }

    public final String e() {
        StringBuffer stringBuffer = this.af;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.af.toString();
        }
        try {
            String strF = com.anythink.core.common.k.d.f();
            String strC = com.anythink.core.common.k.d.c(com.anythink.core.common.b.n.a().g());
            String strB = com.anythink.core.common.k.d.b(com.anythink.core.common.b.n.a().g());
            com.anythink.core.common.b.n.a().g();
            String strValueOf = String.valueOf(com.anythink.expressad.foundation.h.k.a());
            String str = com.anythink.expressad.foundation.h.k.e(com.anythink.core.common.b.n.a().g()) + "x" + com.anythink.expressad.foundation.h.k.f(com.anythink.core.common.b.n.a().g());
            StringBuffer stringBuffer2 = this.af;
            stringBuffer2.append(this.Z);
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) "1"));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) Build.VERSION.RELEASE));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) com.anythink.expressad.out.b.a));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) com.anythink.core.common.k.d.a()));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) str));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a(Integer.valueOf(com.anythink.expressad.foundation.h.k.b(com.anythink.expressad.foundation.b.a.b().d()))));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) com.anythink.core.common.k.d.f(com.anythink.expressad.foundation.b.a.b().d())));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) strValueOf));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) strB));
            stringBuffer2.append(a((Object) strC));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) "at_device1"));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) "at_device2"));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) com.anythink.core.common.k.d.d(com.anythink.core.common.b.n.a().g())));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) strF));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) ""));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) com.anythink.core.common.k.d.b()));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) ""));
            stringBuffer2.append("||");
            stringBuffer2.append(a((Object) ""));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            stringBuffer2.append(a((Object) (com.anythink.core.common.b.n.a().y() + "," + com.anythink.core.common.b.n.a().z())));
            stringBuffer2.append(com.anythink.expressad.foundation.g.a.bQ);
            this.af = stringBuffer2;
            IExHandler iExHandlerB = com.anythink.core.common.b.n.a().b();
            if (iExHandlerB != null) {
                return iExHandlerB.fillCDataParam(this.af.toString());
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b(K, th.getMessage(), th);
        }
        String string = this.af.toString();
        string.replaceAll("at_device1", "");
        string.replaceAll("at_device2", "");
        return string;
    }

    public final String f() {
        try {
            if (!TextUtils.isEmpty(this.ap)) {
                return this.ap;
            }
            if (TextUtils.isEmpty(this.ac)) {
                return "";
            }
            Uri uri = Uri.parse(this.ac);
            if (uri != null) {
                this.ap = uri.getQueryParameter("k");
            }
            return this.ap;
        } catch (Exception unused) {
            return "";
        }
    }

    private void a(List<com.anythink.expressad.out.l> list) {
        this.ae = list;
    }

    private void b(HashMap<String, String> map) {
        this.ah = map;
    }

    private void a(ArrayList<c> arrayList) {
        this.J = arrayList;
    }

    private static d b(JSONObject jSONObject) {
        return b(jSONObject, "");
    }

    private static d a(JSONObject jSONObject, String str) {
        return b(jSONObject, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [com.anythink.expressad.foundation.d.d] */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r25v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r25v2 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private static d b(JSONObject jSONObject, String str) {
        ?? r15;
        int iOptInt;
        String strOptString;
        String str2;
        int i2;
        ArrayList arrayList;
        JSONArray jSONArrayOptJSONArray;
        JSONArray jSONArrayOptJSONArray2;
        String str3;
        d dVar;
        String str4;
        String str5;
        int i3;
        String str6;
        ?? r02 = jSONObject;
        String str7 = f10218h;
        String str8 = "template";
        Object obj = "a";
        String str9 = f10217g;
        String str10 = f10216f;
        if (r02 == 0) {
            return null;
        }
        try {
            d dVar2 = new d();
            try {
                String strOptString2 = r02.optString(f10223m);
                if (!TextUtils.isEmpty(strOptString2)) {
                    JSONObject jSONObject2 = new JSONObject(strOptString2);
                    Iterator<String> itKeys = jSONObject2.keys();
                    HashMap<String, String> map = new HashMap<>();
                    while (itKeys != null && itKeys.hasNext()) {
                        String next = itKeys.next();
                        map.put(next, jSONObject2.optString(next));
                    }
                    dVar2.ag = map;
                }
                if (!TextUtils.isEmpty(str)) {
                    HashMap<String, String> map2 = new HashMap<>();
                    map2.put("encrypt_p", "");
                    map2.put(f10227q, "");
                    dVar2.ah = map2;
                }
                JSONObject jSONObjectOptJSONObject = r02.optJSONObject(H);
                iOptInt = r02.optInt(E, 1);
                strOptString = r02.optString(F, "");
                int iOptInt2 = r02.optInt(G, 0);
                String string = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : "";
                new JSONArray();
                JSONArray jSONArrayOptJSONArray3 = r02.optJSONArray("pv_urls");
                if (jSONArrayOptJSONArray3 == null || jSONArrayOptJSONArray3.length() <= 0) {
                    str2 = string;
                    i2 = iOptInt2;
                    arrayList = null;
                } else {
                    str2 = string;
                    arrayList = new ArrayList(jSONArrayOptJSONArray3.length());
                    i2 = iOptInt2;
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray3.length(); i4++) {
                        arrayList.add(jSONArrayOptJSONArray3.getString(i4));
                    }
                }
                com.anythink.expressad.foundation.c.a.a.a().a(r02.optJSONObject(I));
                dVar2.X = r02.optString("a");
                dVar2.Y = r02.optString("parent_session_id");
                dVar2.Z = r02.optInt("ad_type");
                dVar2.aa = r02.optString(f10215e);
                dVar2.ab = r02.optString(f10216f);
                dVar2.ac = r02.optString(f10217g);
                dVar2.ad = r02.optInt("template");
                dVar2.ao = r02.optInt(f10222l);
                dVar2.R = r02.optString("ia_icon");
                dVar2.S = r02.optInt("ia_rst");
                dVar2.T = r02.optString("ia_url");
                dVar2.U = r02.optInt("ia_ori");
                dVar2.V = r02.optString(f10235y);
                dVar2.W = r02.optString(f10236z);
                dVar2.al = r02.optInt("vcn");
                dVar2.am = r02.optInt("token_r");
                dVar2.an = r02.optString("encrypt_p");
                jSONArrayOptJSONArray = r02.optJSONArray(f10218h);
                jSONArrayOptJSONArray2 = r02.optJSONArray(f10220j);
                str3 = f10221k;
            } catch (Exception unused) {
                obj = dVar2;
            }
            try {
                if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    String str11 = "parse campaign error ,campaign is null";
                    String str12 = strOptString;
                    int i5 = 0;
                    ?? r5 = obj;
                    while (i5 < jSONArrayOptJSONArray2.length()) {
                        JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray2.optJSONObject(i5);
                        int i6 = i5;
                        JSONArray jSONArray = jSONObjectOptJSONObject2.getJSONArray(str7);
                        String str13 = str7;
                        ArrayList arrayList3 = new ArrayList();
                        String str14 = str8;
                        JSONObject jSONObject3 = jSONObjectOptJSONObject2;
                        int i7 = 0;
                        ?? r52 = r5;
                        while (i7 < jSONArray.length()) {
                            JSONObject jSONObjectOptJSONObject3 = jSONArray.optJSONObject(i7);
                            String strOptString3 = r02.optString(str9);
                            String strOptString4 = r02.optString(str10);
                            String str15 = str3;
                            String str16 = str11;
                            JSONObject jSONObject4 = jSONObject3;
                            JSONArray jSONArray2 = jSONArrayOptJSONArray2;
                            String str17 = str2;
                            String str18 = str10;
                            int i8 = i2;
                            String str19 = str9;
                            ArrayList arrayList4 = arrayList2;
                            String str20 = str12;
                            int i9 = i6;
                            JSONArray jSONArray3 = jSONArray;
                            int i10 = iOptInt;
                            ?? r25 = r52;
                            d dVar3 = dVar2;
                            c cVarA = c.a(jSONObjectOptJSONObject3, strOptString3, strOptString4, r02.optString(str3), false, dVar2, str);
                            if (cVarA != null) {
                                cVarA.i(dVar3.T);
                                cVarA.h(dVar3.U);
                                cVarA.g(dVar3.S);
                                cVarA.h(dVar3.R);
                                cVarA.f(r02.optInt("ad_type"));
                                cVarA.f(r02.optString(c.aS));
                                cVarA.g(r02.optString(c.aT));
                                cVarA.d(dVar3.s());
                                cVarA.c(dVar3.t());
                                cVarA.c(dVar3.an);
                                cVarA.k(i8);
                                cVarA.r(str20);
                                i3 = i10;
                                cVarA.j(i3);
                                cVarA.a((List<String>) arrayList);
                                str5 = str17;
                                cVarA.s(str5);
                                arrayList3.add(cVarA);
                                str6 = str16;
                            } else {
                                str5 = str17;
                                i3 = i10;
                                str6 = str16;
                                dVar3.M = str6;
                            }
                            i7++;
                            jSONArrayOptJSONArray2 = jSONArray2;
                            arrayList2 = arrayList4;
                            str3 = str15;
                            jSONObject3 = jSONObject4;
                            str11 = str6;
                            jSONArray = jSONArray3;
                            i6 = i9;
                            str12 = str20;
                            str9 = str19;
                            i2 = i8;
                            str10 = str18;
                            str2 = str5;
                            iOptInt = i3;
                            dVar2 = dVar3;
                            r52 = r25;
                        }
                        ?? r252 = r52;
                        d dVar4 = dVar2;
                        JSONObject jSONObject5 = jSONObject3;
                        ArrayList arrayList5 = arrayList2;
                        int i11 = iOptInt;
                        String str21 = str2;
                        String str22 = str10;
                        int i12 = i2;
                        com.anythink.expressad.out.l lVar = new com.anythink.expressad.out.l();
                        lVar.b(r02.optString("parent_session_id"));
                        lVar.a(r02.optString(r252));
                        lVar.a(arrayList3);
                        lVar.a(jSONObject5.optInt(str14));
                        arrayList5.add(lVar);
                        arrayList2 = arrayList5;
                        str12 = str12;
                        jSONArrayOptJSONArray2 = jSONArrayOptJSONArray2;
                        str9 = str9;
                        str7 = str13;
                        i2 = i12;
                        str11 = str11;
                        str10 = str22;
                        i5 = i6 + 1;
                        str8 = str14;
                        str2 = str21;
                        iOptInt = i11;
                        dVar2 = dVar4;
                        r5 = r252;
                        str3 = str3;
                    }
                    dVar = dVar2;
                    dVar.ae = arrayList2;
                } else {
                    String str23 = f10221k;
                    dVar = dVar2;
                    int i13 = iOptInt;
                    String str24 = str2;
                    String str25 = f10216f;
                    int i14 = i2;
                    String str26 = f10217g;
                    String str27 = "parse campaign error ,campaign is null";
                    if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
                        ArrayList<c> arrayList6 = new ArrayList<>();
                        int i15 = 0;
                        ?? r03 = r02;
                        while (i15 < jSONArrayOptJSONArray.length()) {
                            String str28 = str26;
                            String str29 = str25;
                            String str30 = str27;
                            String str31 = str23;
                            JSONArray jSONArray4 = jSONArrayOptJSONArray;
                            String str32 = str24;
                            str26 = str28;
                            int i16 = i13;
                            c cVarA2 = c.a(jSONArrayOptJSONArray.optJSONObject(i15), r03.optString(str28), r03.optString(str29), r03.optString(str31), false, dVar, str);
                            if (cVarA2 != null) {
                                cVarA2.k(i14);
                                cVarA2.r(strOptString);
                                cVarA2.j(i16);
                                cVarA2.a((List<String>) arrayList);
                                str4 = str32;
                                cVarA2.s(str4);
                                cVarA2.d(dVar.s());
                                cVarA2.c(dVar.t());
                                cVarA2.c(dVar.an);
                                arrayList6.add(cVarA2);
                            } else {
                                str4 = str32;
                                dVar.M = str30;
                            }
                            i15++;
                            str27 = str30;
                            i13 = i16;
                            str24 = str4;
                            str23 = str31;
                            jSONArrayOptJSONArray = jSONArray4;
                            r03 = jSONObject;
                            str25 = str29;
                        }
                        dVar.J = arrayList6;
                    }
                }
                return dVar;
            } catch (Exception unused2) {
                r15 = obj;
                com.anythink.expressad.foundation.h.o.d(K, "parse campaign unit exception");
                return r15;
            }
        } catch (Exception unused3) {
            r15 = 0;
        }
    }

    public static d a(String str) {
        try {
            return b(new JSONObject(str), "");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static d a(JSONObject jSONObject) {
        return b(jSONObject, "");
    }
}
