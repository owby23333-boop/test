package com.anythink.core.b;

import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.common.c.k;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.anythink.core.common.e.r;
import com.anythink.core.common.k.s;
import com.anythink.core.common.w;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.anythink.core.common.e.a f6527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected boolean f6528e;
    private final String a = getClass().getSimpleName() + ":";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected AtomicBoolean f6529f = new AtomicBoolean(false);

    public d(com.anythink.core.common.e.a aVar) {
        this.f6527d = aVar;
    }

    protected static JSONArray b(List<JSONObject> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (JSONObject jSONObject : list) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(k.a.f7051d, 67);
                if (jSONObject.has("unit_ids")) {
                    jSONObject2.put("unit_ids", jSONObject.get("unit_ids"));
                }
                jSONArray.put(jSONObject2);
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    protected abstract void a();

    protected abstract void a(com.anythink.core.b.b.a aVar);

    protected abstract void a(ai aiVar, l lVar, long j2);

    protected void a(boolean z2) {
        this.f6528e = z2;
    }

    public final boolean c() {
        return this.f6529f.get();
    }

    protected static JSONArray a(List<ai> list) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (ai aiVar : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(k.a.f7051d, aiVar.c());
                jSONObject.put("ad_source_id", aiVar.t());
                jSONObject.put("content", aiVar.g());
                if (!TextUtils.isEmpty(aiVar.z())) {
                    jSONObject.put("error", aiVar.z());
                }
                jSONArray.put(jSONObject);
            }
        } catch (Exception unused) {
        }
        return jSONArray;
    }

    protected static void a(ai aiVar, String str, long j2, int i2) {
        aiVar.a(j2);
        aiVar.a(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        aiVar.d(PangleAdapterUtils.CPM_DEFLAUT_VALUE);
        aiVar.g(i2);
        aiVar.b();
        if (TextUtils.isEmpty(str)) {
            aiVar.h("bid error");
        } else {
            aiVar.h(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0132  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void a(com.anythink.core.common.e.ai r22, com.anythink.core.common.e.m r23) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.core.b.d.a(com.anythink.core.common.e.ai, com.anythink.core.common.e.m):void");
    }

    protected final boolean a(ai aiVar, String str, int i2) {
        return a(aiVar, str, i2, 0);
    }

    protected final boolean a(ai aiVar, String str, int i2, int i3) {
        m mVarA = f.a().a(aiVar);
        if (mVarA != null && !mVarA.a()) {
            aiVar.a(mVarA, 0, i2, i3);
            aiVar.h(str);
            return true;
        }
        if (mVarA != null) {
            try {
                com.anythink.core.common.e.e eVarA = s.a(this.f6527d.f7080c, this.f6527d.f7081d, "", this.f6527d.f7091n, "", 1, 0, 0, this.f6527d.b != null ? this.f6527d.b.f7586g : null);
                r rVar = new r();
                rVar.a = 1;
                rVar.b = mVarA.getSortPrice();
                rVar.f7378e = eVarA;
                rVar.f7376c = aiVar;
                rVar.f7377d = aiVar;
                mVarA.a(rVar, true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    protected final void a(int i2, l lVar, double d2) {
        if (i2 != 28) {
            return;
        }
        double d3 = 0.95d;
        JSONObject jSONObjectF = this.f6527d.f7091n.f();
        if (jSONObjectF != null) {
            double dOptDouble = jSONObjectF.optDouble(String.valueOf(i2));
            if (dOptDouble > PangleAdapterUtils.CPM_DEFLAUT_VALUE && dOptDouble <= 1.0d) {
                d3 = dOptDouble;
            }
        }
        double dMax = lVar.originPrice * d3;
        ArrayList arrayList = new ArrayList(5);
        w wVarA = w.a();
        com.anythink.core.common.e.a aVar = this.f6527d;
        List<ai> listB = wVarA.b(aVar.f7081d, aVar.f7080c);
        if (listB != null) {
            arrayList.addAll(listB);
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            double dA = com.anythink.core.common.k.g.a((ai) it.next());
            if (dA < lVar.originPrice) {
                dMax = Math.max(dMax, dA);
                break;
            }
        }
        double dMax2 = Math.max(dMax, d2);
        double dRandom = dMax2 + (Math.random() * (lVar.originPrice - dMax2));
        lVar.setPrice(dRandom);
        lVar.setSortPrice(dRandom);
    }

    protected final double a(ai aiVar) {
        if (aiVar.ad() == null) {
            return 1.0d;
        }
        if (aiVar.ad() == ATAdConst.CURRENCY.RMB_CENT) {
            return (1.0d / this.f6527d.f7091n.p()) * 100.0d;
        }
        if (aiVar.ad() == ATAdConst.CURRENCY.RMB) {
            return 1.0d / this.f6527d.f7091n.p();
        }
        return 1.0d;
    }

    protected final double a(double d2, ai aiVar) {
        double dP;
        if (aiVar.ad() == null) {
            return d2;
        }
        if (aiVar.ad() == ATAdConst.CURRENCY.RMB) {
            dP = this.f6527d.f7091n.p();
        } else {
            if (aiVar.ad() != ATAdConst.CURRENCY.RMB_CENT) {
                return d2;
            }
            d2 /= 100.0d;
            dP = this.f6527d.f7091n.p();
        }
        return d2 * dP;
    }
}
