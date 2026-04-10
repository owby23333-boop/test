package com.kwad.components.core.m;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.l.kwai.b;
import com.kwad.sdk.collector.f;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.report.h;
import com.kwad.sdk.core.report.q;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.l;
import com.kwad.sdk.utils.s;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static boolean Of = false;

    /* JADX INFO: renamed from: com.kwad.components.core.m.a$a, reason: collision with other inner class name */
    static final class C0402a {
        private static final a Oh = new a();
    }

    protected a() {
    }

    private static q a(long j2, AdTemplate adTemplate, String str) {
        return new q(j2, adTemplate, str);
    }

    private static q b(long j2, AdTemplate adTemplate) {
        return new q(j2, adTemplate);
    }

    public static a pr() {
        return C0402a.Oh;
    }

    public static q t(long j2) {
        return new q(j2);
    }

    public final void O(@NonNull AdTemplate adTemplate) {
        h.a(b(10007L, adTemplate));
    }

    public final void P(@NonNull AdTemplate adTemplate) {
        h.a(b(10208L, adTemplate));
    }

    public final void Q(@NonNull AdTemplate adTemplate) {
        h.a(b(10209L, adTemplate));
    }

    public final void a(int i2, @NonNull AdTemplate adTemplate, String str) {
        h.a(a(i2, adTemplate, str));
    }

    public final void a(long j2, int i2) {
        if (d.vb()) {
            q qVarT = t(20000L);
            qVarT.timestamp = System.currentTimeMillis();
            qVarT.ajm = i2;
            qVarT.posId = j2;
            qVarT.ajn = 3033800;
            h.a(qVarT);
        }
    }

    public final void a(b bVar) {
        q qVarT = t(10215L);
        qVarT.NW = bVar.NW;
        qVarT.Oc = bVar.Oc;
        qVarT.Od = bVar.Od;
        qVarT.Oe = bVar.Oe;
        h.a(qVarT);
    }

    public final void a(@NonNull AdTemplate adTemplate, int i2, int i3) {
        q qVarB = b(12006L, adTemplate);
        qVarB.Tp = i2;
        qVarB.ait = i3;
        h.a(qVarB);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j2, int i2) {
        q qVarB = b(104L, adTemplate);
        qVarB.clickTime = l.cv(adTemplate);
        qVarB.aiR = j2;
        qVarB.aiS = i2;
        h.a(qVarB);
    }

    public final void a(@NonNull AdTemplate adTemplate, long j2, long j3, int i2) {
        q qVarB = b(10203L, adTemplate);
        qVarB.Vc = j2;
        qVarB.blockDuration = j3;
        qVarB.ais = i2;
        h.a(qVarB);
    }

    public final void a(@NonNull AdTemplate adTemplate, String str, String str2) {
        q qVarB = b(10003L, adTemplate);
        qVarB.failUrl = str;
        qVarB.errorMsg = str2;
        h.a(qVarB);
    }

    public final void a(SceneImpl sceneImpl, boolean z2, String str) {
        q qVarT = t(10216L);
        qVarT.aiN = z2;
        qVarT.aiO = str;
        qVarT.Ot = sceneImpl;
        h.a(qVarT);
    }

    public final void a(boolean z2, List<Integer> list) {
        q qVarT = t(10204L);
        qVarT.aiN = z2;
        if (list.size() > 0) {
            JSONArray jSONArray = new JSONArray();
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
            qVarT.aiM = jSONArray;
        }
        h.a(qVarT);
    }

    public final void aA(int i2) {
        q qVarT = t(10107L);
        qVarT.aiE = i2;
        h.a(qVarT);
    }

    public final void ao(Context context) {
        q qVarT = t(11L);
        JSONArray[] jSONArrayArrC = InstalledAppInfoManager.c(context, d.sS());
        qVarT.aiw = jSONArrayArrC[0];
        qVarT.aix = jSONArrayArrC[1];
        h.a(qVarT);
    }

    public final void az(int i2) {
        q qVarT = t(10104L);
        qVarT.aiD = i2;
        h.a(qVarT);
    }

    public final void b(@NonNull AdTemplate adTemplate, int i2, int i3) {
        q qVarB = b(10002L, adTemplate);
        qVarB.xo();
        qVarB.failUrl = com.kwad.sdk.core.response.a.d.bT(adTemplate) ? com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : com.kwad.sdk.core.response.a.d.cd(adTemplate);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("what", i2);
            jSONObject.put("extra", i3);
            qVarB.errorMsg = jSONObject.toString();
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
        }
        h.a(qVarB);
    }

    public final void b(AdTemplate adTemplate, int i2, String str) {
        q qVarB = b(adTemplate.isPlayAgainData ? 12300 : 10109, adTemplate);
        qVarB.aiE = 1;
        qVarB.aiF = str;
        h.a(qVarB);
    }

    public final void b(@NonNull AdTemplate adTemplate, String str, String str2) {
        q qVarB = b(10005L, adTemplate);
        qVarB.failUrl = com.kwad.sdk.core.response.a.d.bT(adTemplate) ? com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)) : com.kwad.sdk.core.response.a.d.cd(adTemplate);
        qVarB.failUrl = str;
        qVarB.errorMsg = str2;
        h.a(qVarB);
    }

    public final void c(@NonNull AdTemplate adTemplate, int i2, String str) {
        q qVarB = b(107L, adTemplate);
        qVarB.errorCode = i2;
        qVarB.errorMsg = str;
        h.a(qVarB);
    }

    public final void c(@NonNull JSONArray jSONArray) {
        q qVarT = t(10200L);
        qVarT.aiH = jSONArray;
        h.a(qVarT);
    }

    public final void d(@NonNull AdTemplate adTemplate, long j2) {
        q qVarB = b(10202L, adTemplate);
        qVarB.aiL = j2;
        h.a(qVarB);
    }

    public final void e(AdTemplate adTemplate, int i2) {
        q qVarB = b(10108L, adTemplate);
        qVarB.aiE = i2;
        h.a(qVarB);
    }

    public final void e(AdTemplate adTemplate, long j2) {
        q qVarB = b(10206L, adTemplate);
        qVarB.ajb = j2;
        h.a(qVarB);
    }

    public final void e(String str, String str2, boolean z2) {
        q qVarT = t(12200L);
        qVarT.ajk = str;
        qVarT.ajl = str2;
        h.a(qVarT, z2);
    }

    public final void e(@NonNull JSONObject jSONObject, int i2) {
        q qVarT = t(10201L);
        s.putValue(jSONObject, "appChangeType", i2);
        qVarT.aiG = jSONObject;
        h.a(qVarT);
    }

    public final void f(@NonNull AdTemplate adTemplate, int i2) {
        if (d.vb()) {
            AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
            q qVarT = t(20000L);
            qVarT.timestamp = System.currentTimeMillis();
            qVarT.ajm = i2;
            qVarT.trace = adInfoCb.trace;
            qVarT.ajn = 3033800;
            qVarT.posId = com.kwad.sdk.core.response.a.d.bU(adTemplate);
            h.a(qVarT);
        }
    }

    public final void f(AdTemplate adTemplate, long j2) {
        q qVarB = b(10207L, adTemplate);
        qVarB.ajc = j2;
        h.a(qVarB);
    }

    public final void ps() {
        if (Of) {
            return;
        }
        Of = true;
        g.execute(new av() { // from class: com.kwad.components.core.m.a.1
            @Override // com.kwad.sdk.utils.av
            public final void doTask() {
                q qVarT = a.t(8L);
                qVarT.ajd = f.tR();
                h.a(qVarT);
            }
        });
    }

    public final void pt() {
        h.a(t(10101L));
    }

    public final void pu() {
        h.a(t(10106L));
    }
}
