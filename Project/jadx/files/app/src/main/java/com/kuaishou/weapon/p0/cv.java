package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.y;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class cv implements Runnable {
    private Context a;

    public cv(Context context) {
        this.a = context;
    }

    private y b(String str) {
        try {
            y yVar = new y();
            JSONObject jSONObject = new JSONObject(str);
            yVar.e(jSONObject.optInt("status", 1));
            if (yVar.z() != 1) {
                return null;
            }
            yVar.f(jSONObject.optInt("bwc", 3));
            yVar.g(jSONObject.optInt("blpc", 3));
            yVar.h(jSONObject.optInt("scc", 0));
            yVar.j(jSONObject.optString("dpver"));
            yVar.k(jSONObject.optString("bver"));
            yVar.d(jSONObject.optInt("dpd", 12));
            try {
                yVar.b(jSONObject.optInt("aar", 30));
                yVar.e(jSONObject.optString("dir"));
                yVar.f(jSONObject.optString(com.umeng.analytics.pro.am.ae));
                yVar.a(jSONObject.optInt("ii"));
                yVar.c(jSONObject.optInt("act", 0));
                try {
                    yVar.h(jSONObject.optString("aver"));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("a");
                    if (jSONObject2 != null) {
                        y.a aVar = new y.a();
                        aVar.c(jSONObject2.optInt("as", 0));
                        aVar.d(jSONObject2.optInt(com.anythink.expressad.d.a.b.da, 3));
                        aVar.e(jSONObject2.optInt(com.anythink.expressad.d.a.b.cZ, 8));
                        aVar.b(jSONObject2.optInt("ab", 0));
                        aVar.a(jSONObject2.optInt("am", 0));
                        yVar.a(aVar);
                    }
                } catch (Exception unused) {
                }
                try {
                    yVar.b(jSONObject.optString("acver"));
                    JSONObject jSONObject3 = jSONObject.getJSONObject(com.anythink.expressad.d.a.b.da);
                    if (jSONObject3 != null) {
                        y.b bVar = new y.b();
                        bVar.a(jSONObject3.optInt(ConnType.PK_ACS, 1));
                        bVar.b(jSONObject3.optInt("acc", 3));
                        bVar.c(jSONObject3.optInt("aci", 8));
                        yVar.a(bVar);
                    }
                } catch (Exception unused2) {
                }
                try {
                    yVar.a(jSONObject.optString("rver"));
                    y.g gVar = new y.g();
                    JSONObject jSONObject4 = jSONObject.getJSONObject("r");
                    if (jSONObject4 != null) {
                        gVar.b(jSONObject4.optInt("rs", 1));
                        gVar.c(jSONObject4.optInt(com.anythink.core.common.g.c.R, 6));
                        gVar.d(jSONObject4.optInt("ri", 4));
                        gVar.e(jSONObject4.optInt("ro", 5));
                        gVar.a(jSONObject4.optInt("rb", 0));
                        JSONObject jSONObject5 = jSONObject4.getJSONObject("rcl");
                        y.g.a aVar2 = new y.g.a();
                        aVar2.l(jSONObject5.optInt("da", 1));
                        aVar2.b(jSONObject5.optInt("em", 1));
                        aVar2.m(jSONObject5.optInt("li", 1));
                        aVar2.f(jSONObject5.optInt("rcd", 1));
                        aVar2.g(jSONObject5.optInt("dv", 1));
                        aVar2.h(jSONObject5.optInt("re", 1));
                        aVar2.c(jSONObject5.optInt(com.anythink.expressad.video.dynview.a.a.Z, 1));
                        aVar2.a(jSONObject5.optInt("hk", 0));
                        aVar2.k(jSONObject5.optInt("vp", 0));
                        aVar2.i(jSONObject5.optInt("mc", 0));
                        aVar2.e(jSONObject5.optInt(com.anythink.expressad.d.a.b.bH, 1));
                        aVar2.d(jSONObject5.optInt("ud", 1));
                        aVar2.j(jSONObject5.optInt("xp", 1));
                        aVar2.n(jSONObject5.optInt("vl", 0));
                        gVar.a(aVar2);
                        yVar.a(gVar);
                    }
                } catch (Exception unused3) {
                }
                try {
                    y.c cVar = new y.c();
                    JSONObject jSONObject6 = jSONObject.getJSONObject("b");
                    cVar.b(jSONObject6.optInt("bc", 2));
                    cVar.c(jSONObject6.optInt("bi", 12));
                    cVar.a(jSONObject6.optInt("bs", 1));
                    try {
                        JSONObject jSONObject7 = jSONObject6.getJSONObject("pry");
                        y.c.b bVar2 = new y.c.b();
                        bVar2.e(jSONObject7.optInt("gifa", 1));
                        bVar2.d(jSONObject7.optInt("gnci", 1));
                        bVar2.f(jSONObject7.optInt("gsl", 1));
                        bVar2.c(jSONObject7.optInt("gso", 1));
                        bVar2.a(jSONObject7.optInt("gno", 1));
                        bVar2.b(jSONObject7.optInt("gnon", 1));
                        bVar2.g(jSONObject7.optInt("rl", 1));
                        bVar2.i(jSONObject7.optInt("grs", 1));
                        bVar2.h(jSONObject7.optInt("grt", 1));
                        cVar.a(bVar2);
                    } catch (Exception unused4) {
                    }
                    JSONObject jSONObject8 = jSONObject6.getJSONObject("bcl");
                    y.c.a aVar3 = new y.c.a();
                    aVar3.a(jSONObject8.optInt("a", 1));
                    aVar3.i(jSONObject8.optInt("r", 1));
                    aVar3.b(jSONObject8.optInt("c", 1));
                    aVar3.j(jSONObject8.optInt("s", 1));
                    aVar3.d(jSONObject8.optInt("d", 1));
                    aVar3.k(jSONObject8.optInt("u", 1));
                    aVar3.m(jSONObject8.optInt(IAdInterListener.AdReqParam.WIDTH, 0));
                    aVar3.f(jSONObject8.optInt("n", 0));
                    aVar3.p(jSONObject8.optInt("ie", 1));
                    aVar3.e(jSONObject8.optInt(com.umeng.analytics.pro.am.ae, 0));
                    aVar3.n(jSONObject8.optInt("ic", 1));
                    aVar3.o(jSONObject8.optInt("btm", 1));
                    aVar3.l(jSONObject8.optInt("mc", 1));
                    aVar3.q(jSONObject8.optInt("rp", 1));
                    aVar3.g(jSONObject8.optInt("tc", 1));
                    aVar3.c(jSONObject8.optInt("il", 1));
                    aVar3.h(jSONObject8.optInt("p", 1));
                    aVar3.r(jSONObject8.optInt("l", 1));
                    cVar.a(aVar3);
                    yVar.a(cVar);
                } catch (Exception unused5) {
                }
                try {
                    yVar.g(jSONObject.optString("cver"));
                    y.d dVar = new y.d();
                    JSONObject jSONObject9 = jSONObject.getJSONObject("c");
                    dVar.b(jSONObject9.optInt(com.anythink.expressad.d.a.b.f8383h, 2));
                    dVar.c(jSONObject9.optInt("ci", 12));
                    dVar.a(jSONObject9.optInt("cs", 1));
                    dVar.d(jSONObject9.optInt("cb", 0));
                    JSONObject jSONObject10 = jSONObject9.getJSONObject("ccl");
                    y.d.a aVar4 = new y.d.a();
                    aVar4.a(jSONObject10.optInt("d", 1));
                    aVar4.b(jSONObject10.optInt("mc", 1));
                    aVar4.c(jSONObject10.optInt(IAdInterListener.AdReqParam.WIDTH, 0));
                    aVar4.d(jSONObject10.optInt(com.umeng.analytics.pro.am.ae, 1));
                    aVar4.e(jSONObject10.optInt("ic", 1));
                    aVar4.f(jSONObject10.optInt("btm", 1));
                    aVar4.g(jSONObject10.optInt("ie", 1));
                    aVar4.h(jSONObject10.optInt("n", 0));
                    dVar.a(aVar4);
                    yVar.a(dVar);
                } catch (Exception unused6) {
                }
                try {
                    yVar.i(jSONObject.optString("pgver"));
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("p");
                    if (jSONObjectOptJSONObject != null) {
                        y.f fVar = new y.f();
                        fVar.a(jSONObjectOptJSONObject.optInt("ps", 1));
                        fVar.b(jSONObjectOptJSONObject.optInt(t.f16817x, 2));
                        fVar.c(jSONObjectOptJSONObject.optInt("pi", 12));
                        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("pcl");
                        if (jSONObjectOptJSONObject2 != null) {
                            y.f.a aVar5 = new y.f.a();
                            aVar5.d(jSONObjectOptJSONObject2.optInt("cp", 1));
                            aVar5.c(jSONObjectOptJSONObject2.optInt("gc", 1));
                            aVar5.b(jSONObjectOptJSONObject2.optInt("pke", 1));
                            aVar5.e(jSONObjectOptJSONObject2.optInt("pds", 1));
                            aVar5.a(jSONObjectOptJSONObject2.optInt("pam", 1));
                            fVar.a(aVar5);
                        }
                        yVar.a(fVar);
                    }
                } catch (Exception unused7) {
                }
                try {
                    yVar.m(jSONObject.optString("socver"));
                    JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("soc");
                    if (jSONObjectOptJSONObject3 != null) {
                        y.h hVar = new y.h();
                        hVar.c(jSONObjectOptJSONObject3.optInt("socs", 0));
                        hVar.d(jSONObjectOptJSONObject3.optInt("socc", 2));
                        hVar.b(jSONObjectOptJSONObject3.optInt("soci", 12));
                        hVar.a(jSONObjectOptJSONObject3.optInt("snack", 0));
                        yVar.a(hVar);
                    }
                } catch (Exception unused8) {
                }
                try {
                    yVar.d(jSONObject.optString("hver"));
                    JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("h");
                    if (jSONObjectOptJSONObject4 != null) {
                        y.e eVar = new y.e();
                        eVar.b(jSONObjectOptJSONObject4.optInt("hs", 1));
                        eVar.c(jSONObjectOptJSONObject4.optInt("hc", 2));
                        eVar.a(jSONObjectOptJSONObject4.optInt("hi", 12));
                        eVar.d(jSONObjectOptJSONObject4.optInt("hsdc", 1));
                        eVar.e(jSONObjectOptJSONObject4.optInt("hlbr", 1));
                        eVar.a(jSONObjectOptJSONObject4.optString(com.umeng.analytics.pro.am.ay));
                        yVar.a(eVar);
                    }
                } catch (Exception unused9) {
                }
                return yVar;
            } catch (Exception unused10) {
                return null;
            }
        } catch (Exception unused11) {
            return null;
        }
    }

    public void a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("result", 0) == 1) {
                String strA = new bm(this.a).a(jSONObject.getString("antispamPluginRsp"));
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                y yVarB = b(strA);
                if (yVarB != null) {
                    de.a(this.a).a(str, yVarB);
                } else {
                    de.a(this.a).b(System.currentTimeMillis());
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        try {
            String str = ct.a + ct.f16669d;
            String strA = cu.a(this.a);
            if (!TextUtils.isEmpty(strA)) {
                str = str + "?" + strA;
            }
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObjectB = cu.b(this.a);
            if (jSONObjectB != null) {
                jSONObject.put("data", new bm(this.a).c(jSONObjectB.toString()));
            }
            l lVarA = l.a(this.a);
            m mVar = new m(str, jSONObject);
            mVar.a(WeaponHI.cookieData);
            mVar.b(WeaponHI.encryENV);
            lVarA.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.cv.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str2) {
                    try {
                        cv.this.a(str2);
                    } catch (Exception unused) {
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str2) {
                }
            });
        } catch (Exception unused) {
        }
    }
}
