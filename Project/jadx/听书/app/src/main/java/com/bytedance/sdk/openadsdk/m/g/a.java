package com.bytedance.sdk.openadsdk.m.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.bytedance.sdk.openadsdk.core.iq.js;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.sy.v;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.hh.fo;
import com.bytedance.sdk.openadsdk.hh.uy;
import com.bytedance.sdk.openadsdk.m.dl.e;
import com.bytedance.sdk.openadsdk.m.dl.gc;
import com.bytedance.sdk.openadsdk.m.dl.gz;
import com.bytedance.sdk.openadsdk.m.dl.i;
import com.bytedance.sdk.openadsdk.m.dl.kb;
import com.bytedance.sdk.openadsdk.m.dl.ls;
import com.bytedance.sdk.openadsdk.m.dl.m;
import com.bytedance.sdk.openadsdk.m.dl.p;
import com.bytedance.sdk.openadsdk.m.dl.pf;
import com.bytedance.sdk.openadsdk.m.dl.wp;
import java.io.File;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static final Map<com.bykv.vk.openvk.component.video.api.g.z, p> z = Collections.synchronizedMap(new WeakHashMap());

    public static JSONObject z(com.bykv.vk.openvk.component.video.api.dl.a aVar, String str, int i, int i2, na naVar, long j) {
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarZw;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("session_id", str);
            }
            if (i > 0) {
                jSONObject.put("play_type", String.valueOf(i));
            }
            if (uy.z(naVar)) {
                jSONObject.put("is_audio", 1);
            }
            if (aVar != null) {
                if (aVar.v()) {
                    dlVarZw = aVar.io();
                    jSONObject.put("codec", "h265");
                } else {
                    dlVarZw = aVar.zw();
                }
                if (dlVarZw != null) {
                    jSONObject.put("video_resolution", dlVarZw.fo());
                    jSONObject.put("video_size", Long.valueOf(dlVarZw.gc()));
                    String strWp = dlVarZw.wp();
                    jSONObject.put("video_url", strWp);
                    jSONObject.put("is_expired", eo.wp(strWp));
                    jSONObject.put("send_duration", Math.floor(System.currentTimeMillis() - (eo.wp(naVar) * 1000.0d)));
                    jSONObject.put("start_duration", j);
                    jSONObject.put("player_type", i2);
                    jSONObject.put("play_speed_ratio", dlVarZw.gz());
                    if (dlVarZw.e() > 0.0d) {
                        jSONObject.put(TtmlNode.START, dlVarZw.e());
                    }
                }
            }
            if (naVar != null) {
                jSONObject.put("dynamic_join_type", naVar.pc());
            }
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static void z(com.bytedance.sdk.openadsdk.m.dl.g<wp> gVar) {
        g(gVar, "load_video_start");
    }

    public static void g(com.bytedance.sdk.openadsdk.m.dl.g<i> gVar) {
        g(gVar, "load_video_success");
    }

    public static void dl(com.bytedance.sdk.openadsdk.m.dl.g<kb> gVar) {
        g(gVar, "load_video_error");
    }

    public static void a(com.bytedance.sdk.openadsdk.m.dl.g<com.bytedance.sdk.openadsdk.m.dl.uy> gVar) {
        g(gVar, "load_video_cancel");
    }

    public static boolean z(na naVar, com.bykv.vk.openvk.component.video.api.g.z zVar, com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        int iSu = naVar.su();
        com.bykv.vk.openvk.component.video.api.z.g gVarZ = fo.z(iSu);
        if (iSu != 0) {
            if (iSu == 1) {
                return gVarZ.z(aVar);
            }
            return false;
        }
        long jG = gVarZ.g(aVar);
        boolean zI = aVar.i();
        int iM = aVar.m();
        if (zI) {
            iM = (int) aVar.wp();
        }
        int iG = aVar.g();
        if (iG > 0) {
            iM = iG;
        }
        return jG >= ((long) iM);
    }

    public static void z(final na naVar, final com.bykv.vk.openvk.component.video.api.g.z zVar, final com.bykv.vk.openvk.component.video.api.dl.a aVar, final boolean z2) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (naVar == null || zVar == null || aVar == null) {
                    return;
                }
                String string = UUID.randomUUID().toString();
                com.bykv.vk.openvk.component.video.api.z.g gVarZ = fo.z(naVar.su());
                int i = a.z(naVar, zVar, aVar) ? 1 : 2;
                a.z.put(zVar, new p(SystemClock.elapsedRealtime(), string, i, aVar, naVar));
                long jG = gVarZ.g(aVar);
                ls lsVar = new ls();
                if (jG > 0) {
                    lsVar.z(jG);
                }
                lsVar.z(z2);
                v.z(i, jG, naVar, aVar);
                com.bykv.vk.openvk.component.video.api.dl.a aVar2 = aVar;
                JSONObject jSONObjectZ = a.z(aVar2, string, i, aVar2.fv(), naVar, 0L);
                a.z(jSONObjectZ, aVar.gc("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVar, eo.g(naVar), jSONObjectZ, lsVar);
                gVar.z(aVar.fv() == -1);
                a.g(gVar, "play_start");
            }
        });
    }

    public static void z(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.4
            @Override // java.lang.Runnable
            public void run() {
                p pVar;
                if (zVar == null || zVar2 == null || (pVar = (p) a.z.get(zVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                na naVarGc = pVar.gc();
                if (aVarA == null || naVarGc == null) {
                    return;
                }
                if (!uy.z(naVarGc) || js.g(naVarGc)) {
                    if (!zVar2.i()) {
                        a.g(naVarGc, aVarA, zVar2);
                    }
                    com.bytedance.sdk.openadsdk.m.dl.fo foVar = new com.bytedance.sdk.openadsdk.m.dl.fo();
                    foVar.g(zVar2.v() ? 1 : 0);
                    foVar.z(zVar2.pf() ? 1 : 0);
                    foVar.g(fo.z(naVarGc.su()).g(aVarA));
                    long jElapsedRealtime = SystemClock.elapsedRealtime() - pVar.z();
                    foVar.z(jElapsedRealtime);
                    JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, jElapsedRealtime);
                    a.z(jSONObjectZ, aVarA.gc("EXTRA_PLAY_START"));
                    com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, foVar);
                    gVar.z(zVar2.i());
                    a.g(gVar, a.g(naVarGc, "feed_play"));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(na naVar, String str) {
        if (naVar == null || !eo.m(naVar) || !eo.e(naVar)) {
            return str;
        }
        str.hashCode();
        switch (str) {
        }
        return str;
    }

    public static String z(com.bykv.vk.openvk.component.video.api.g.z zVar) {
        p pVar;
        if (zVar == null || (pVar = z.get(zVar)) == null) {
            return "empty";
        }
        String strG = pVar.g();
        return TextUtils.isEmpty(strG) ? "empty" : strG;
    }

    public static void z(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2, final int i) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.5
            @Override // java.lang.Runnable
            public void run() {
                p pVar;
                if (zVar == null || zVar2 == null || (pVar = (p) a.z.get(zVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                na naVarGc = pVar.gc();
                if (aVarA == null || naVarGc == null) {
                    return;
                }
                long jG = zVar2.g();
                long jA = zVar2.a();
                if (jA <= 0 || jG <= 0) {
                    return;
                }
                gz gzVar = new gz();
                gzVar.z(zVar2.dl());
                gzVar.g(jA);
                gzVar.z(i);
                gzVar.z(zVar2.ls());
                JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, SystemClock.elapsedRealtime() - pVar.z());
                a.z(jSONObjectZ, aVarA.gc("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, gzVar);
                gVar.z(zVar2.i());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jG);
                    jSONObject.put("percent", zVar2.fo());
                    a.g(gVar, "feed_pause", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    public static void g(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.6
            @Override // java.lang.Runnable
            public void run() {
                p pVar;
                if (zVar == null || zVar2 == null || (pVar = (p) a.z.get(zVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                na naVarGc = pVar.gc();
                if (aVarA == null || naVarGc == null) {
                    return;
                }
                long jG = zVar2.g();
                long jA = zVar2.a();
                if (jA <= 0 || jG <= 0) {
                    return;
                }
                m mVar = new m();
                mVar.z(zVar2.dl());
                mVar.g(jA);
                JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, SystemClock.elapsedRealtime() - pVar.z());
                a.z(jSONObjectZ, aVarA.gc("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, mVar);
                gVar.z(zVar2.i());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jG);
                    jSONObject.put("percent", zVar2.fo());
                    a.g(gVar, "feed_continue", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    public static void z(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2, final String str, final int i, final boolean z2) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.7
            @Override // java.lang.Runnable
            public void run() {
                p pVar;
                if (zVar == null || zVar2 == null || (pVar = (p) a.z.get(zVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                na naVarGc = pVar.gc();
                if (aVarA == null || naVarGc == null) {
                    return;
                }
                long jG = zVar2.g();
                long jA = zVar2.a();
                if (jA < 0) {
                    return;
                }
                pf pfVar = new pf();
                pfVar.dl(zVar2.dl());
                pfVar.a(jA);
                pfVar.dl(zVar2.gc());
                pfVar.a(zVar2.m());
                pfVar.g(i);
                pfVar.g(fo.z(naVarGc.su()).g(aVarA));
                pfVar.z(str);
                JSONArray jSONArrayZ = zVar2.z();
                if (jSONArrayZ != null) {
                    pfVar.z(jSONArrayZ);
                }
                pfVar.z(jG);
                pfVar.z(zVar2.fo());
                pfVar.z(z2);
                JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, SystemClock.elapsedRealtime() - pVar.z());
                a.z(jSONObjectZ, aVarA.gc("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, pfVar);
                gVar.z(zVar2.i());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jG);
                    jSONObject.put("percent", zVar2.fo());
                    a.g(gVar, "play_error", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.z.remove(zVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void dl(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.8
            @Override // java.lang.Runnable
            public void run() {
                p pVar;
                if (zVar == null || zVar2 == null || (pVar = (p) a.z.get(zVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                na naVarGc = pVar.gc();
                if (aVarA == null || naVarGc == null) {
                    return;
                }
                long jG = zVar2.g();
                long jA = zVar2.a();
                com.bytedance.sdk.openadsdk.m.dl.dl dlVar = new com.bytedance.sdk.openadsdk.m.dl.dl();
                dlVar.dl(zVar2.dl());
                dlVar.a(jA);
                dlVar.g(zVar2.e());
                dlVar.dl(zVar2.gz());
                dlVar.g(fo.z(naVarGc.su()).g(aVarA));
                dlVar.z(jG);
                dlVar.z(zVar2.fo());
                JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, SystemClock.elapsedRealtime() - pVar.z());
                a.z(jSONObjectZ, aVarA.gc("EXTRA_PLAY_START"));
                com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, dlVar);
                gVar.z(zVar2.i());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jG);
                    jSONObject.put("percent", zVar2.fo());
                    a.g(gVar, "endcard_skip", jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.z.remove(zVar);
                    }
                }, 1000L);
            }
        });
    }

    public static void z(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2, final Map<String, Object> map, final int i) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.9
            @Override // java.lang.Runnable
            public void run() {
                p pVar;
                if (zVar == null || zVar2 == null || (pVar = (p) a.z.get(zVar)) == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                na naVarGc = pVar.gc();
                if (aVarA == null || naVarGc == null) {
                    return;
                }
                long jG = zVar2.g();
                long jA = zVar2.a();
                if (jA <= 0) {
                    return;
                }
                gc gcVar = new gc();
                gcVar.g(zVar2.dl());
                gcVar.z(jA);
                gcVar.g(zVar2.uy());
                gcVar.dl(zVar2.kb());
                gcVar.z(i);
                JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, SystemClock.elapsedRealtime() - pVar.z());
                a.z(jSONObjectZ, map);
                com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, gcVar);
                gVar.z(zVar2.i());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jG);
                    jSONObject.put("percent", zVar2.fo());
                    v.z(jG, naVarGc, aVarA);
                    a.g(gVar, a.g(naVarGc, "feed_break"), jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                a.z.remove(zVar);
            }
        });
    }

    public static void a(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.10
            @Override // java.lang.Runnable
            public void run() {
                p.z zVar3;
                com.bykv.vk.openvk.component.video.api.g.z zVar4 = zVar;
                if (zVar4 == null || (zVar3 = zVar2) == null) {
                    return;
                }
                a.gc(zVar4, zVar3);
                p pVar = (p) a.z.get(zVar);
                if (pVar == null) {
                    return;
                }
                com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                na naVarGc = pVar.gc();
                if (aVarA == null || naVarGc == null) {
                    return;
                }
                long jG = zVar2.g();
                long jA = zVar2.a();
                if (jA <= 0) {
                    return;
                }
                e eVar = new e();
                eVar.g(zVar2.dl());
                eVar.z(jA);
                eVar.z(zVar2.kb());
                JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, SystemClock.elapsedRealtime() - pVar.z());
                a.z(jSONObjectZ, aVarA.gc("EXTRA_PLAY_ACTION"));
                com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, eVar);
                gVar.z(zVar2.i());
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("duration", jG);
                    jSONObject.put("percent", zVar2.fo());
                    v.z(jG, naVarGc, aVarA);
                    a.g(gVar, a.g(naVarGc, "feed_over"), jSONObject);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
                a.z.remove(zVar);
            }
        });
    }

    public static void gc(final com.bykv.vk.openvk.component.video.api.g.z zVar, final p.z zVar2) {
        dl.z().z(new Runnable() { // from class: com.bytedance.sdk.openadsdk.m.g.a.11
            @Override // java.lang.Runnable
            public void run() {
                p.z zVar3;
                if (zVar == null || (zVar3 = zVar2) == null) {
                    return;
                }
                if (zVar3.wp() > 0) {
                    p pVar = (p) a.z.get(zVar);
                    if (pVar == null) {
                        return;
                    }
                    com.bykv.vk.openvk.component.video.api.dl.a aVarA = pVar.a();
                    na naVarGc = pVar.gc();
                    if (aVarA == null || naVarGc == null) {
                        return;
                    }
                    long jA = zVar2.a();
                    if (jA <= 0) {
                        return;
                    }
                    com.bytedance.sdk.openadsdk.m.dl.v vVar = new com.bytedance.sdk.openadsdk.m.dl.v();
                    vVar.z(zVar2.dl());
                    vVar.g(jA);
                    vVar.z(zVar2.wp());
                    JSONObject jSONObjectZ = a.z(aVarA, pVar.g(), pVar.dl(), aVarA.fv(), naVarGc, SystemClock.elapsedRealtime() - pVar.z());
                    a.z(jSONObjectZ, aVarA.gc("EXTRA_PLAY_ACTION"));
                    com.bytedance.sdk.openadsdk.m.dl.g gVar = new com.bytedance.sdk.openadsdk.m.dl.g(naVarGc, eo.g(naVarGc), jSONObjectZ, vVar);
                    gVar.z(zVar2.i());
                    a.g(gVar, "play_buffer");
                    return;
                }
                com.bytedance.sdk.component.utils.wp.z("VideoEventManager", "Cancel log report when buffer count is 0");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(com.bytedance.sdk.openadsdk.m.dl.g gVar, String str) {
        g(gVar, str, (JSONObject) null);
    }

    private static boolean gc(com.bytedance.sdk.openadsdk.m.dl.g gVar) {
        na naVarZ;
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw;
        if (gVar == null || !gVar.gc() || (naVarZ = gVar.z()) == null || (gVarLw = naVarZ.lw()) == null) {
            return false;
        }
        String strIq = gVarLw.iq();
        if (TextUtils.isEmpty(strIq)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(strIq);
            int length = jSONArray.length();
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            for (int i = 0; i < length; i++) {
                String strOptString = jSONArray.getJSONObject(i).optString("name");
                if ("content_did".equalsIgnoreCase(strOptString)) {
                    z2 = true;
                } else if ("content_utmsource".equalsIgnoreCase(strOptString)) {
                    z3 = true;
                } else if ("content_sdk_version".equalsIgnoreCase(strOptString)) {
                    z4 = true;
                }
            }
            return z2 && z3 && z4;
        } catch (JSONException e) {
            e.getMessage();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final com.bytedance.sdk.openadsdk.m.dl.g gVar, String str, JSONObject jSONObject) {
        if (gVar == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (gVar.gc() && !TextUtils.isEmpty(gVar.g()) && !gc(gVar)) {
            String strG = gVar.g();
            strG.hashCode();
            switch (strG) {
                case "stream":
                case "embeded_ad":
                case "draw_ad":
                    str = "customer_".concat(String.valueOf(str));
                    break;
            }
        }
        g.z(str, gVar.z());
        com.bytedance.sdk.openadsdk.core.i.a.z(gVar.z(), gVar.g(), str, jSONObject, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.m.g.a.2
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObjectDl = gVar.dl();
                if (gVar.a() != null) {
                    gVar.a().a_(jSONObjectDl);
                }
                jSONObject2.put("ad_extra_data", jSONObjectDl.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final na naVar, final com.bykv.vk.openvk.component.video.api.dl.a aVar, final p.z zVar) {
        com.bytedance.sdk.openadsdk.core.q.v.z().g(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.m.g.a.3
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("service_duration", a.dl(aVar));
                jSONObject.put("player_duration", zVar.a());
                jSONObject.put("cache_path_type", fo.a());
                jSONObject.put("url", aVar.ls());
                jSONObject.put("path", a.a(aVar));
                jSONObject.put("player_type", aVar.fv());
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("pangle_video_play_state").z(eo.gz(naVar)).g(jSONObject.toString());
            }
        }, "pangle_video_play_state");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long dl(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        if (aVar == null) {
            return 0L;
        }
        com.bykv.vk.openvk.component.video.api.dl.dl dlVarIo = aVar.v() ? aVar.io() : aVar.zw();
        if (dlVarIo != null) {
            return Double.valueOf(dlVarIo.m() * 1000.0d).longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(com.bykv.vk.openvk.component.video.api.dl.a aVar) {
        return new File(aVar.gc(), aVar.p()).getAbsolutePath();
    }

    public static synchronized com.bykv.vk.openvk.component.video.api.dl.a g(com.bykv.vk.openvk.component.video.api.g.z zVar) {
        if (zVar == null) {
            return null;
        }
        p pVar = z.get(zVar);
        if (pVar == null) {
            return null;
        }
        return pVar.a();
    }

    public static void z(JSONObject jSONObject, Object obj) {
        if (jSONObject == null) {
            return;
        }
        Map map = null;
        try {
            if (obj instanceof Map) {
                map = (Map) obj;
            }
        } catch (Exception unused) {
        }
        if (map != null) {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            } catch (JSONException e) {
                com.bytedance.sdk.component.utils.wp.z(e);
            }
        }
    }
}
