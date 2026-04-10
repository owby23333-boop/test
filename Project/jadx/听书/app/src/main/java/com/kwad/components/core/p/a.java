package com.kwad.components.core.p;

import android.content.Context;
import com.kwad.components.core.proxy.a.b;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.p;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.report.g;
import com.kwad.sdk.core.report.n;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean WR;

    /* JADX INFO: renamed from: com.kwad.components.core.p.a$a, reason: collision with other inner class name */
    static final class C0343a {
        private static final a WT = new a();
    }

    protected a() {
    }

    public static a se() {
        return C0343a.WT;
    }

    public static n M(long j) {
        return new n(j);
    }

    private static n b(long j, AdTemplate adTemplate) {
        return new n(j, adTemplate);
    }

    private static n a(long j, AdTemplate adTemplate, String str) {
        return new n(j, adTemplate, str);
    }

    public final void sf() {
        if (WR) {
            return;
        }
        WR = true;
        h.execute(new bg() { // from class: com.kwad.components.core.p.a.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                n nVarM = a.M(8L);
                nVarM.aHy = f.DI();
                g.a(nVarM);
            }
        });
    }

    public final void az(Context context) {
        n nVarM = M(11L);
        p pVar = (p) d.f(p.class);
        if (pVar != null) {
            JSONArray[] jSONArrayArrB = pVar.b(context, e.BB());
            nVarM.aGQ = jSONArrayArrB[0];
            nVarM.aGR = jSONArrayArrB[1];
            g.a(nVarM);
        }
    }

    public final void f(AdTemplate adTemplate, int i, int i2) {
        n nVarB = b(12006L, adTemplate);
        nVarB.adE = i;
        nVarB.aye = i2;
        g.a(nVarB);
    }

    public final void a(AdTemplate adTemplate, String str, String str2) {
        n nVarB = b(10003L, adTemplate);
        nVarB.aGX = str;
        nVarB.errorMsg = str2;
        g.a(nVarB);
    }

    public final void g(AdTemplate adTemplate, int i, int i2) {
        n nVarB = b(10002L, adTemplate);
        nVarB.Iw();
        if (com.kwad.sdk.core.response.b.e.ed(adTemplate)) {
            nVarB.aGX = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate));
        } else {
            nVarB.aGX = com.kwad.sdk.core.response.b.e.en(adTemplate);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i);
            jSONObject.put("extra", i2);
            nVarB.errorMsg = jSONObject.toString();
        } catch (JSONException e) {
            c.printStackTraceOnly(e);
        }
        g.a(nVarB);
    }

    public final void b(AdTemplate adTemplate, String str, String str2) {
        n nVarB = b(10005L, adTemplate);
        if (com.kwad.sdk.core.response.b.e.ed(adTemplate)) {
            nVarB.aGX = com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.el(adTemplate));
        } else {
            nVarB.aGX = com.kwad.sdk.core.response.b.e.en(adTemplate);
        }
        nVarB.aGX = str;
        nVarB.errorMsg = str2;
        g.a(nVarB);
    }

    public final void aI(AdTemplate adTemplate) {
        g.a(b(10007L, adTemplate));
    }

    public final void c(JSONArray jSONArray) {
        n nVarM = M(10200L);
        nVarM.aHc = jSONArray;
        g.a(nVarM);
    }

    public final void e(JSONObject jSONObject, int i) {
        n nVarM = M(10201L);
        aa.putValue(jSONObject, "appChangeType", i);
        nVarM.aHb = jSONObject;
        g.a(nVarM);
    }

    public final void sg() {
        g.a(M(10101L));
    }

    public final void aS(int i) {
        n nVarM = M(10104L);
        nVarM.aGY = i;
        g.a(nVarM);
    }

    public final void a(int i, AdTemplate adTemplate, String str) {
        g.a(a(i, adTemplate, str));
    }

    public final void sh() {
        g.a(M(10106L));
    }

    public final void aT(int i) {
        n nVarM = M(10107L);
        nVarM.aGZ = i;
        g.a(nVarM);
    }

    public final void e(AdTemplate adTemplate, int i) {
        n nVarB = b(10108L, adTemplate);
        nVarB.aGZ = i;
        g.a(nVarB);
    }

    public final void f(AdTemplate adTemplate, int i, String str) {
        n nVarB = b(10109L, adTemplate);
        nVarB.aGZ = 1;
        nVarB.aHa = str;
        g.a(nVarB);
    }

    public final void a(AdTemplate adTemplate, long j, long j2, int i) {
        n nVarB = b(10203L, adTemplate);
        nVarB.aci = j;
        nVarB.blockDuration = j2;
        nVarB.aGN = i;
        g.a(nVarB);
    }

    public final void h(AdTemplate adTemplate, long j) {
        n nVarB = b(10202L, adTemplate);
        nVarB.aHg = j;
        g.a(nVarB);
    }

    public final void a(boolean z, List<Integer> list) {
        n nVarM = M(10204L);
        nVarM.aHi = z;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            nVarM.aHh = jSONArray;
        }
        g.a(nVarM);
    }

    public final void a(SceneImpl sceneImpl, boolean z, String str) {
        n nVarM = M(10216L);
        nVarM.aHi = z;
        nVarM.aHj = str;
        nVarM.adScene = sceneImpl;
        g.a(nVarM);
    }

    public final void i(AdTemplate adTemplate, long j) {
        n nVarB = b(10206L, adTemplate);
        nVarB.aHw = j;
        g.a(nVarB);
    }

    public final void j(AdTemplate adTemplate, long j) {
        n nVarB = b(10207L, adTemplate);
        nVarB.aHx = j;
        g.a(nVarB);
    }

    public final void aJ(AdTemplate adTemplate) {
        g.a(b(10208L, adTemplate));
    }

    public final void aK(AdTemplate adTemplate) {
        g.a(b(10209L, adTemplate));
    }

    public final void g(AdTemplate adTemplate, int i, String str) {
        n nVarB = b(107L, adTemplate);
        nVarB.errorCode = i;
        nVarB.errorMsg = str;
        g.a(nVarB);
    }

    public final void a(AdTemplate adTemplate, long j, int i) {
        n nVarB = b(104L, adTemplate);
        nVarB.clickTime = com.kwad.sdk.utils.n.eN(adTemplate);
        nVarB.aHm = j;
        nVarB.aHn = i;
        g.a(nVarB);
    }

    public final void a(b bVar) {
        n nVarM = M(10215L);
        nVarM.WH = bVar.WH;
        nVarM.WO = bVar.WO;
        nVarM.WP = bVar.WP;
        nVarM.WQ = bVar.WQ;
        g.a(nVarM);
    }

    public final void e(String str, String str2, boolean z) {
        g.a(m(str, str2), z);
    }

    public final n m(String str, String str2) {
        n nVarM = M(12200L);
        nVarM.aHF = str;
        nVarM.aHG = str2;
        return nVarM;
    }

    public final void c(long j, int i) {
        if (e.FU()) {
            n nVarM = M(20000L);
            nVarM.timestamp = System.currentTimeMillis();
            nVarM.aHH = i;
            nVarM.posId = j;
            nVarM.aHI = BuildConfig.VERSION_CODE;
            g.a(nVarM);
        }
    }

    public final void f(AdTemplate adTemplate, int i) {
        if (e.FU()) {
            AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
            n nVarM = M(20000L);
            nVarM.timestamp = System.currentTimeMillis();
            nVarM.aHH = i;
            nVarM.trace = adInfoEl.trace;
            nVarM.aHI = BuildConfig.VERSION_CODE;
            nVarM.posId = com.kwad.sdk.core.response.b.e.ee(adTemplate);
            g.a(nVarM);
        }
    }
}
