package com.bytedance.sdk.openadsdk.core.i;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.bytedance.android.metrics.LiveMetrics;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.gk;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i.z;
import com.bytedance.sdk.openadsdk.core.iq.ec;
import com.bytedance.sdk.openadsdk.core.iq.ja;
import com.bytedance.sdk.openadsdk.core.iq.ls;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.iq.sv;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.sy.wp;
import com.bytedance.sdk.openadsdk.core.tb;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.un.io;
import com.bytedance.sdk.openadsdk.core.un.kb;
import com.bytedance.sdk.openadsdk.core.un.oq;
import com.bytedance.sdk.openadsdk.core.un.sy;
import com.bytedance.sdk.openadsdk.core.uy;
import com.bytedance.sdk.openadsdk.core.zw;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.d;
import com.umeng.umcrash.UMCrash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static int z;

    public static void z(na naVar) {
    }

    public static void z(String str, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.m.z.z zVar) {
        new z.C0178z().gc(str3).a(str4).z(str).g(str2).z(zVar);
    }

    public static void z(na naVar, String str, String str2, com.bytedance.sdk.openadsdk.m.z.z zVar) {
        if (naVar == null) {
            return;
        }
        new z.C0178z().gc(naVar.mj()).a(naVar.vk()).z(str).g(str2).e(naVar.aq()).z(zVar);
    }

    public static void z(na naVar, String str, String str2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.m.z.z zVar) {
        if (naVar == null) {
            return;
        }
        new z.C0178z().gc(naVar.mj()).a(naVar.vk()).z(str).g(str2).z(jSONObject).e(naVar.aq()).z(zVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gc(na naVar, String str, JSONObject jSONObject) throws JSONException {
        com.bytedance.sdk.openadsdk.ls.dl.dl.g gVarLw;
        if (gk.e() && (gVarLw = naVar.lw()) != null) {
            String strI = gVarLw.i();
            if (TextUtils.isEmpty(strI)) {
                return;
            }
            jSONObject.putOpt("media_extra", strI);
        }
    }

    public static void z(final na naVar, String str, String str2, final JSONObject jSONObject) {
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.1
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObject3, naVar);
                    jSONObject2.put("ad_extra_data", jSONObject.toString());
                }
            }
        });
    }

    public static void z(final na naVar, String str, String str2, final Map<String, Object> map) {
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.12
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void z(final na naVar, final String str, final Map<String, Object> map) {
        com.bytedance.sdk.openadsdk.hh.e.z((Runnable) new com.bytedance.sdk.component.uy.fo("repost_show_check") { // from class: com.bytedance.sdk.openadsdk.core.i.a.22
            @Override // java.lang.Runnable
            public void run() {
                if (naVar == null) {
                    return;
                }
                final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - eo.wp(naVar)).floatValue();
                a.z(naVar, str, "show_check", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.22.1
                    @Override // com.bytedance.sdk.openadsdk.m.z.z
                    public void z(JSONObject jSONObject) throws JSONException {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.dl.z.z(zw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.gz.z(str)).toString());
                        jSONObject2.put("is_cache", naVar.xt() ? 1 : 0);
                        jSONObject2.put("cache_type", naVar.zt());
                        jSONObject2.put("correct_action_code", naVar.to());
                        jSONObject2.put("correct_result_code", naVar.lz());
                        if (map != null) {
                            for (Map.Entry entry : map.entrySet()) {
                                jSONObject2.put((String) entry.getKey(), entry.getValue());
                            }
                        }
                        jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - q.gc);
                        jSONObject2.put("start_type", !q.g.get() ? 1 : 0);
                        jSONObject2.put("show_count", a.z);
                        jSONObject2.put("can_use_sensor", uy.ls().m());
                        jSONObject2.put("is_shake_ads", uy.ls().fv());
                        jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.l.z.z().m());
                        a.gc(naVar, str, jSONObject2);
                        com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                        jSONObject.put("ad_extra_data", jSONObject2.toString());
                        float f = fFloatValue;
                        if (f <= 0.0f) {
                            f = 0.0f;
                        }
                        jSONObject.putOpt("show_time", Float.valueOf(f));
                    }
                });
            }
        });
    }

    public static void z(final na naVar, final String str, final Map<String, Object> map, final Double d) {
        com.bytedance.sdk.openadsdk.hh.e.z(new com.bytedance.sdk.component.uy.fo("report_show") { // from class: com.bytedance.sdk.openadsdk.core.i.a.33
            @Override // java.lang.Runnable
            public void run() {
                a.g(naVar, str, (Map<String, Object>) map, d);
            }
        });
    }

    public static void g(final na naVar, final String str, final Map<String, Object> map, final Double d) {
        if (naVar == null) {
            return;
        }
        h.g();
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - eo.wp(naVar)).floatValue();
        final String strZ = io.z(str, kb.g(), eo.fo(naVar), com.bytedance.sdk.openadsdk.core.multipro.g.dl());
        naVar.ac().dl();
        z++;
        z(naVar, str, "show", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.36
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.dl.z.z(zw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.gz.z(str)).toString());
                jSONObject2.put("is_cache", naVar.xt() ? 1 : 0);
                jSONObject2.put("cache_type", naVar.zt());
                jSONObject2.put("correct_action_code", naVar.to());
                jSONObject2.put("correct_result_code", naVar.lz());
                Map map2 = map;
                if (map2 != null) {
                    if (!map2.containsKey("show_send_type")) {
                        map.put("show_send_type", 0);
                    }
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                }
                jSONObject2.put("start2req_time", SystemClock.elapsedRealtime() - q.gc);
                jSONObject2.put("start_type", !q.g.get() ? 1 : 0);
                jSONObject2.put("show_count", a.z);
                String strM = uy.ls().m();
                if (!TextUtils.isEmpty(strM)) {
                    jSONObject2.put("can_use_sensor", strM);
                }
                if (!uy.ls().kb()) {
                    jSONObject2.put("mcod", "0");
                }
                if (!uy.ls().gz()) {
                    jSONObject2.put("od", "0");
                }
                jSONObject2.put("is_shake_ads", uy.ls().fv());
                jSONObject2.put("direction", com.bytedance.sdk.openadsdk.core.l.z.z().m());
                a.gc(naVar, str, jSONObject2);
                String str2 = strZ;
                if (str2 != null) {
                    oq.z(jSONObject2, str2);
                }
                jSONObject2.put("live_sdk_status", com.bytedance.sdk.openadsdk.core.live.g.z().dl());
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject2.put("shakeLiSize", com.bytedance.sdk.component.utils.q.z(zw.getContext()).z());
                a.z(jSONObject2);
                naVar.ac().z(jSONObject2);
                wp.z(naVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
                com.bytedance.sdk.openadsdk.core.v.dl.gc().z(naVar, fFloatValue);
                String strKa = naVar.ka();
                if (!TextUtils.isEmpty(strKa)) {
                    try {
                        double d2 = Double.parseDouble(strKa);
                        if (d2 <= 0.0d) {
                            jSONObject.put("ttdsp_price", 0);
                            return;
                        } else {
                            if (gk.dl < 4400) {
                                d2 *= 100000.0d;
                            }
                            jSONObject.put("ttdsp_price", d2);
                        }
                    } catch (Throwable th) {
                        jSONObject.put("ttdsp_price", 0);
                        com.bytedance.sdk.component.utils.wp.z(th);
                    }
                }
                z(naVar, d, jSONObject);
            }

            public void z(na naVar2, Double d2, JSONObject jSONObject) {
                Object obj;
                Object obj2;
                try {
                    Map<String, Object> mapFq = naVar2.fq();
                    if (mapFq == null || (obj = mapFq.get("sdk_bidding_type")) == null || Integer.parseInt(obj.toString()) != 2) {
                        return;
                    }
                    if (d2 != null) {
                        jSONObject.put("ttdsp_price", d2);
                    } else if (naVar2.rh() && (obj2 = mapFq.get("price")) != null) {
                        jSONObject.put("ttdsp_price", Double.parseDouble(obj2.toString()));
                    }
                } catch (Throwable unused) {
                }
            }
        });
        String strDl = tb.dl();
        List<String> listBb = naVar.bb();
        if (!TextUtils.isEmpty(strDl)) {
            HashMap map2 = new HashMap();
            map2.put("aid", naVar.mk());
            map2.put(CmcdConfiguration.KEY_CONTENT_ID, naVar.mj());
            map2.put("req_id", naVar.aq());
            map2.put("customer_id", eo.kb(naVar));
            com.bytedance.sdk.openadsdk.core.q.g.z(strDl, listBb, true, map2, z(naVar, str, "show"));
        } else if (listBb != null && listBb.size() != 0) {
            z(naVar, listBb, str, "no did", "show");
        }
        if (z % 5 == 0 && com.bytedance.sdk.openadsdk.z.z.z.z() != null) {
            com.bytedance.sdk.openadsdk.z.z.z.z().g("AdShow" + System.currentTimeMillis());
        }
        if (com.bytedance.sdk.openadsdk.core.live.g.z().m(naVar)) {
            com.bytedance.sdk.openadsdk.core.video.dl.z.z(LiveMetrics.EVENT_LIVESDK_LIVE_SHOW, naVar, 0L);
        }
        eo.dl();
        com.bytedance.sdk.openadsdk.pf.g.dl();
        if (naVar != null) {
            com.bytedance.sdk.openadsdk.core.live.g.z().a();
        }
        uy.ls().a().a();
        io.z(z, 1);
        com.bytedance.sdk.openadsdk.core.a.z().dl(naVar.nv());
        com.bytedance.sdk.openadsdk.core.kb.z.z(naVar);
        com.bytedance.sdk.openadsdk.core.v.dl.gc().gz();
    }

    private static void z(na naVar, List<String> list, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("track_type", str3);
            jSONObject.put("error_msg", str2);
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(list.get(i));
                if (i == size - 1) {
                    sb.append("]");
                } else {
                    sb.append(",");
                }
            }
            jSONObject.put("url", sb.toString());
            jSONObject.put("urls_size", size);
        } catch (Exception unused) {
        }
        z(str, naVar.mj(), naVar.vk(), jSONObject);
    }

    public static void z(final na naVar, final String str, final long j) {
        z(naVar, str, "download_creative_duration", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.37
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("device", com.bytedance.sdk.openadsdk.core.dl.z.z(zw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.gz.z(str)).toString());
                jSONObject2.put("download_creative_duration", j);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(final String str, na naVar, String str2, final int i) {
        if (naVar == null) {
            return;
        }
        z(naVar, str2, "ad_show_time", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.38
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("source", Integer.valueOf(i));
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                jSONObject.put("duration", str);
            }
        });
    }

    public static long z(long j, boolean z2, na naVar, String str, int i) {
        if (z2) {
            return System.currentTimeMillis();
        }
        z(new StringBuilder().append(System.currentTimeMillis() - j).toString(), naVar, str, i);
        return 0L;
    }

    public static long z(long j, na naVar, String str, int i) {
        if (j <= 0) {
            return j;
        }
        z(new StringBuilder().append(System.currentTimeMillis() - j).toString(), naVar, str, i);
        return 0L;
    }

    public static void z(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return;
        }
        String strOptString = jSONObject.optString("tag");
        String strOptString2 = jSONObject.optString(MediationConstant.EXTRA_ADID);
        String strOptString3 = jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA);
        if (TextUtils.isEmpty(strOptString3) || TextUtils.isEmpty(strOptString2) || TextUtils.isEmpty(strOptString)) {
            return;
        }
        z(strOptString, strOptString2, strOptString3, jSONObject2);
    }

    public static void z(String str, String str2, String str3, final JSONObject jSONObject) {
        z(str, "show_url", str2, str3, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.39
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject2.put("ad_extra_data", jSONObject3.toString());
                }
            }
        });
    }

    public static void z(final na naVar, final String str) {
        String strG;
        if (naVar == null || str == null || (strG = eo.g(naVar)) == null) {
            return;
        }
        z(naVar, strG, "page_on_create", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.40
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(d.v, str);
                oq.z(jSONObject2, "");
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void z(String str, final na naVar, final com.bytedance.sdk.openadsdk.core.iq.fo foVar, final String str2, final boolean z2, final Map<String, Object> map, final int i, boolean z3) {
        if (naVar == null || z3) {
            return;
        }
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - eo.wp(naVar)).floatValue();
        z(naVar, str2, str, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.2
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                com.bytedance.sdk.openadsdk.core.iq.fo foVar2 = foVar;
                if (foVar2 != null) {
                    JSONObject jSONObjectZ = foVar2.z();
                    jSONObjectZ.put("device", com.bytedance.sdk.openadsdk.core.dl.z.z(zw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.gz.z(str2)).toString());
                    jSONObjectZ.put("is_valid", z2);
                    int i2 = i;
                    if (i2 > 0 && i2 <= 2) {
                        jSONObjectZ.put("user_behavior_type", i2);
                    }
                    oq.z(jSONObjectZ, "");
                    Map map2 = map;
                    if (map2 != null) {
                        for (Map.Entry entry : map2.entrySet()) {
                            jSONObjectZ.put((String) entry.getKey(), entry.getValue());
                        }
                    }
                    a.gc(naVar, str2, jSONObjectZ);
                    jSONObjectZ.putOpt("obm_convert", com.bytedance.sdk.openadsdk.core.iq.tb.dl(naVar));
                    jSONObjectZ.put("can_use_sensor", uy.ls().m());
                    if (!uy.ls().kb()) {
                        jSONObjectZ.put("mcod", "0");
                    }
                    if (!uy.ls().gz()) {
                        jSONObjectZ.put("od", "0");
                    }
                    jSONObjectZ.put("is_shake_ads", uy.ls().fv());
                    jSONObjectZ.put("live_sdk_config", com.bytedance.sdk.openadsdk.core.live.g.z().gz());
                    jSONObjectZ.put("direction", com.bytedance.sdk.openadsdk.core.l.z.z().m());
                    jSONObjectZ.put("is_cache", naVar.xt() ? 1 : 0);
                    jSONObjectZ.put("cache_type", naVar.zt());
                    jSONObjectZ.put("correct_action_code", naVar.to());
                    jSONObjectZ.put("correct_result_code", naVar.lz());
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObjectZ, naVar);
                    a.z(jSONObjectZ);
                    jSONObject.put("ad_extra_data", jSONObjectZ.toString());
                }
                float f = fFloatValue;
                if (f <= 0.0f) {
                    f = 0.0f;
                }
                jSONObject.putOpt("show_time", Float.valueOf(f));
            }
        });
        String strDl = tb.dl();
        List<String> listBy = naVar.by();
        if (!TextUtils.isEmpty(strDl) && "click".equals(str)) {
            HashMap map2 = new HashMap();
            map2.put("aid", naVar.mk());
            map2.put(CmcdConfiguration.KEY_CONTENT_ID, naVar.mj());
            map2.put("req_id", naVar.aq());
            map2.put("customer_id", eo.kb(naVar));
            com.bytedance.sdk.openadsdk.core.q.g.z(strDl, listBy, true, map2, z(naVar, str2, "click"));
        } else if (listBy != null && listBy.size() != 0 && "click".equals(str)) {
            z(naVar, listBy, str2, "no did", "click");
        }
        if (str == "click") {
            if (com.bytedance.sdk.openadsdk.core.video.dl.z.z(naVar)) {
                com.bytedance.sdk.openadsdk.core.video.dl.z.z(LiveMetrics.EVENT_LIVESDK_REC_LIVE_PLAY, naVar, 0L);
            }
            com.bytedance.sdk.openadsdk.core.live.g.z().a(naVar);
        }
        io.z(1, 2);
        if (com.bytedance.sdk.component.utils.wp.dl()) {
            com.bytedance.sdk.component.utils.wp.z("AdEvent", str + " " + naVar.mj());
        }
    }

    public static JSONObject z(na naVar, String str, String str2) {
        return z(naVar.vk(), naVar.mj(), naVar.aq(), str, str2);
    }

    public static JSONObject z(String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(MediationConstant.EXTRA_LOG_EXTRA, str);
            jSONObject.put(MediationConstant.EXTRA_ADID, str2);
            jSONObject.put("req_id", str3);
            jSONObject.put("tag", str4);
            jSONObject.put("track_type", str5);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void g(na naVar, String str, String str2, Map<String, Object> map) {
        z(naVar, str, str2, map);
    }

    public static void z(final na naVar, String str, String str2, final long j) {
        if (naVar == null) {
            return;
        }
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.3
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("duration", j);
                jSONObject2.put("rom_new_version", sy.pf());
                jSONObject2.put("is_background", uy.ls().z());
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(com.bytedance.sdk.openadsdk.core.dislike.dl.g gVar, com.bytedance.sdk.openadsdk.ls.dl.g.m mVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(mVar);
        zw.z().z(gVar, arrayList);
        if (com.bytedance.sdk.component.utils.wp.dl()) {
            com.bytedance.sdk.component.utils.wp.z("AdEvent", "tt_dislike_icon " + gVar.dl());
        }
    }

    public static void g(na naVar, String str) {
        if (naVar != null) {
            com.bytedance.sdk.openadsdk.core.dislike.dl.dl dlVar = new com.bytedance.sdk.openadsdk.core.dislike.dl.dl();
            dlVar.z("0:00");
            dlVar.g(str);
            com.bytedance.sdk.openadsdk.core.v.dl.gc().z("skip", naVar.mj(), naVar.aq(), naVar.en(), (String) null);
            z(naVar.ct(), dlVar);
        }
    }

    public static void z(Context context, na naVar, String str, String str2, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str2) || naVar == null || jSONObject == null) {
            return;
        }
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            objOpt = naVar.mj();
        }
        String strOptString = jSONObject.optString("category");
        if (TextUtils.isEmpty(strOptString)) {
            strOptString = "app_union";
        }
        Object objOpt2 = jSONObject.opt(MediationConstant.EXTRA_LOG_EXTRA);
        if (objOpt2 == null) {
            objOpt2 = naVar.vk();
        }
        try {
            jSONObject.putOpt("nt", Integer.valueOf(v.dl(context)));
            jSONObject.putOpt("scene_tag", "csj_sdk");
            jSONObject.putOpt("tag", "7.1.0.5");
            jSONObject.putOpt("subtag", str);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.wp.dl(e.getMessage());
        }
        new z.C0178z().gc(objOpt == null ? "" : objOpt.toString()).dl(strOptString).a(objOpt2 != null ? objOpt2.toString() : "").z(str).z(jSONObject).g(str2).z(new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.4
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
            }
        });
    }

    public static void z(final long j, final na naVar) {
        if (naVar == null) {
            return;
        }
        z(naVar, "splash_ad", "skip", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.5
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("skip_duration", j);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(final na naVar, String str, final JSONObject jSONObject) {
        z(naVar, eo.g(naVar), str, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.6
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObject3, naVar);
                    jSONObject2.put("ad_extra_data", jSONObject);
                }
            }
        });
    }

    public static void dl(na naVar, String str, String str2, Map<String, Object> map) {
        z(naVar, str, str2, map);
    }

    public static void a(na naVar, String str, String str2, Map<String, Object> map) {
        z(naVar, str, str2, map);
    }

    public static void gc(na naVar, String str, String str2, Map<String, Object> map) {
        z(naVar, str, str2, map);
    }

    public static void z(final na naVar, String str, String str2, final long j, final int i, final Map<String, Object> map) {
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.7
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.put("percent", i);
                if (map != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jSONObject2.put((String) entry.getKey(), entry.getValue());
                    }
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            }
        });
    }

    public static void z(final na naVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (naVar == null || jSONObject == null) {
            return;
        }
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.8
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, naVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void g(na naVar, String str, String str2, final long j) {
        if (naVar == null) {
            return;
        }
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.9
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                jSONObject.put(UMCrash.SP_KEY_TIMESTAMP, j);
            }
        });
    }

    public static void g(final na naVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (naVar == null || jSONObject == null) {
            return;
        }
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.10
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, naVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void dl(final na naVar, String str, String str2, final long j, final JSONObject jSONObject) {
        if (naVar == null) {
            return;
        }
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.11
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("duration", j);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, naVar);
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void m(na naVar, String str, String str2, Map<String, Object> map) {
        z(naVar, str, str2, map);
    }

    public static void z(String str, String str2, String str3, String str4) {
        new z.C0178z().z(str3).g(str4).gc(str).a(str2).z((com.bytedance.sdk.openadsdk.m.z.z) null);
        if (com.bytedance.sdk.component.utils.wp.dl()) {
            com.bytedance.sdk.component.utils.wp.z("AdEvent", "tag: " + str3 + "label: " + str4 + " " + str);
        }
    }

    public static void e(na naVar, String str, String str2, Map<String, Object> map) {
        z(naVar, str, str2, map);
    }

    public static void g(na naVar, String str, String str2) {
        z(naVar, str, str2, (com.bytedance.sdk.openadsdk.m.z.z) null);
    }

    public static void dl(na naVar, String str, String str2) {
        z(naVar, str, str2, (com.bytedance.sdk.openadsdk.m.z.z) null);
    }

    public static void g(na naVar, String str, String str2, JSONObject jSONObject) {
        z(naVar, str, str2, jSONObject);
    }

    public static void z(na naVar, String str, String str2, Throwable th) {
        ja jaVarFx = naVar.fx();
        JSONObject jSONObject = null;
        if (jaVarFx != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("wc_type", jaVarFx.gc());
                } catch (Throwable unused) {
                }
                jSONObject = jSONObject2;
            } catch (Throwable unused2) {
            }
        }
        if (th != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                jSONObject.put("throwable", th.getMessage());
            } catch (Exception unused3) {
            }
        }
        z(naVar, str, str2, jSONObject);
    }

    public static void g(na naVar, String str, long j) {
        String str2;
        if (zw.g().lw()) {
            final long jCurrentTimeMillis = System.currentTimeMillis() - j;
            str.hashCode();
            switch (str) {
                case "banner_ad":
                    str2 = "banner_ad_loadtime";
                    break;
                case "rewarded_video":
                    str2 = "rewarded_video_loadtime";
                    break;
                case "stream":
                    str2 = "stream_loadtime";
                    break;
                case "fullscreen_interstitial_ad":
                    str2 = "fullscreen_interstitial_ad_loadtime";
                    break;
                case "embeded_ad":
                    str2 = "embeded_ad_loadtime";
                    break;
                case "interaction":
                    str2 = "interaction_loadtime";
                    break;
                case "draw_ad":
                    str2 = "draw_ad_loadtime";
                    break;
                default:
                    str2 = "";
                    break;
            }
            z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.13
                @Override // com.bytedance.sdk.openadsdk.m.z.z
                public void z(JSONObject jSONObject) throws JSONException {
                    jSONObject.put("duration", jCurrentTimeMillis);
                }
            });
        }
    }

    public static void gz(na naVar, String str, String str2, Map<String, Object> map) {
        ja jaVarFx = naVar.fx();
        if (map == null) {
            map = new HashMap<>();
        }
        if (jaVarFx != null) {
            map.put("wc_type", Integer.valueOf(jaVarFx.gc()));
        }
        map.put("rom_new_version", sy.pf());
        map.put("is_background", Boolean.valueOf(uy.ls().z()));
        map.put("interaction_type", Integer.valueOf(naVar.lt()));
        z(naVar, str, str2, map);
    }

    public static void z(na naVar, String str, String str2, String str3) {
        final JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("refer", str3);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject, naVar);
            }
        } catch (Throwable unused) {
        }
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.14
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject);
            }
        });
    }

    public static void z(String str, final String str2, final String str3, long j, long j2, JSONObject jSONObject) {
        final float fFloatValue = Double.valueOf((System.currentTimeMillis() / 1000) - eo.m(jSONObject.optString(MediationConstant.EXTRA_LOG_EXTRA))).floatValue();
        new z.C0178z().z(str2).g(str3).dl(str).gc(String.valueOf(j)).m(String.valueOf(j2)).z(jSONObject).z(new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.15
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = new JSONObject();
                String strOptString = jSONObject2.optString("ad_extra_data", null);
                if (strOptString != null) {
                    jSONObject3 = new JSONObject(strOptString);
                }
                jSONObject3.put("device", com.bytedance.sdk.openadsdk.core.dl.z.z(zw.getContext(), com.bytedance.sdk.openadsdk.core.nativeexpress.gz.z(str2)).toString());
                jSONObject3.put("js_event", 1);
                jSONObject2.put("ad_extra_data", jSONObject3.toString());
                jSONObject2.put("tag", str2);
                if ("click".equals(str3)) {
                    float f = fFloatValue;
                    if (f <= 0.0f) {
                        f = 0.0f;
                    }
                    jSONObject2.putOpt("show_time", Float.valueOf(f));
                }
            }
        });
        if (com.bytedance.sdk.component.utils.wp.dl()) {
            com.bytedance.sdk.component.utils.wp.z("AdEvent", "sendJsAdEvent");
        }
    }

    public static void dl(na naVar, String str, String str2, JSONObject jSONObject) {
        if (naVar == null) {
            return;
        }
        new z.C0178z().gc(naVar.mj()).a(naVar.vk()).z(str).g(str2).z(jSONObject).z((com.bytedance.sdk.openadsdk.m.z.z) null);
    }

    public static void g(final na naVar, String str, String str2, final String str3) {
        z(naVar, str, str2, new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.16
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("scheme", str3);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(final long j, String str, String str2) {
        na naVarZ;
        try {
            naVarZ = com.bytedance.sdk.openadsdk.core.z.z(new JSONObject(str2));
        } catch (Throwable unused) {
            naVarZ = null;
        }
        if (naVarZ == null) {
            return;
        }
        z(naVarZ, str, "open_appback", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.17
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
            }
        });
        com.bytedance.sdk.component.a.g.dl dlVarZ = com.bytedance.sdk.openadsdk.core.g.z();
        dlVarZ.put("save_jump_success_time", 0L);
        dlVarZ.put("save_jump_success_ad_tag", "");
    }

    public static void g(final na naVar) {
        z(naVar, "landingpage", "open_url_h5", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.18
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
            }
        });
    }

    public static void dl(final na naVar, String str, final long j) {
        z(naVar, str, "load", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.19
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("render_type", "h5");
                jSONObject2.putOpt("render_type_2", 0);
                com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                jSONObject.putOpt("ad_extra_data", jSONObject2);
                jSONObject.put("duration", Math.min(j, TTAdConstant.AD_MAX_EVENT_TIME));
            }
        });
    }

    public static void a(na naVar, String str, final long j) {
        z(naVar, str, "render_live_picture_success", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.20
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                jSONObject.putOpt("ad_extra_data", new JSONObject().toString());
            }
        });
    }

    public static void z(na naVar, String str, final int i, final String str2) {
        z(naVar, str, "render_live_picture_fail", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.21
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(na naVar, String str, final long j, final String str2) {
        z(naVar, str, "live_play_success", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.23
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                jSONObject.put("duration", j);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("session_id", str2);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(na naVar, String str, final int i, final String str2, final String str3) {
        z(naVar, str, "live_play_fail", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.24
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("error_code", Integer.valueOf(i));
                jSONObject2.putOpt("error_message", str2);
                jSONObject2.putOpt("session_id", str3);
                jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(na naVar, String str, final long j, final JSONObject jSONObject, final String str2) {
        z(naVar, str, "live_play_close", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.25
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                JSONObject jSONObject3 = jSONObject;
                if (jSONObject3 != null) {
                    jSONObject3.putOpt("session_id", str2);
                    jSONObject2.putOpt("ad_extra_data", jSONObject.toString());
                }
                jSONObject2.put("duration", j);
            }
        });
    }

    public static void z(final na naVar, String str, final int i, final int i2, final int i3, final boolean z2) {
        if (naVar != null && naVar.hu() == 1) {
            z(naVar, str, "open_live", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.26
                @Override // com.bytedance.sdk.openadsdk.m.z.z
                public void z(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    int i4 = i3;
                    int iWm = naVar.wm();
                    jSONObject2.put("live_interaction_type", iWm);
                    jSONObject2.put("client_live_interaction_type", i);
                    jSONObject2.put("real_live_interaction_type", i2);
                    jSONObject2.put("reward_live_type", ec.g(naVar));
                    jSONObject2.put("is_inner", z2);
                    sv svVarDz = naVar.dz();
                    if (svVarDz != null) {
                        jSONObject2.putOpt("saas_info", svVarDz.z());
                    }
                    ls lsVarVy = naVar.vy();
                    if (lsVarVy != null) {
                        String strG = lsVarVy.g();
                        if (lsVarVy != null && strG.length() > 500) {
                            strG = strG.substring(0, 500);
                        }
                        jSONObject2.put("deep_link", strG);
                        if (!strG.startsWith("snssdk1128") && !strG.startsWith("snssdk2329") && iWm == 1 && i4 != 0) {
                            i4 = 2;
                        }
                    }
                    jSONObject2.put("live_interaction_status", i4);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static void z(final na naVar, String str, final int i) {
        z(naVar, str, "qpon_join", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.27
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("join_status", i);
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    public static void g(final na naVar, String str, final int i) {
        z(naVar, str, "qpon_apply", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.28
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("qpon_apply_status", i);
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                    jSONObject.putOpt("ad_extra_data", jSONObject2.toString());
                } catch (Exception e) {
                    com.bytedance.sdk.component.utils.wp.z(e);
                }
            }
        });
    }

    public static void g(na naVar, String str, final JSONObject jSONObject) {
        if (naVar == null || jSONObject == null) {
            return;
        }
        z(naVar, str, "cache_correct_details", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.29
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void g(long j, final na naVar) {
        if (naVar != null && na.g(naVar)) {
            final long jCurrentTimeMillis = j > 0 ? System.currentTimeMillis() - j : 0L;
            z(naVar, "splash_ad", "play_duration_sum", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.30
                @Override // com.bytedance.sdk.openadsdk.m.z.z
                public void z(JSONObject jSONObject) throws JSONException {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("skip_duration", jCurrentTimeMillis);
                    com.bytedance.sdk.openadsdk.gc.z.z(jSONObject2, naVar);
                    jSONObject.put("ad_extra_data", jSONObject2.toString());
                }
            });
        }
    }

    public static void z(final int i, String str, final na naVar) {
        if (naVar == null) {
            return;
        }
        z(naVar, str, "saas_auth", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.31
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("saas_auth_status", i);
                sv svVarDz = naVar.dz();
                if (svVarDz != null) {
                    jSONObject2.put("saas_auth_type", svVarDz.g());
                }
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void z(String str, na naVar) {
        if (naVar == null) {
            return;
        }
        z(naVar, str, "ec_mall_task", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.32
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("mall_reward_callback", 1);
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        });
    }

    public static void dl(na naVar, String str, final JSONObject jSONObject) {
        if (naVar == null || jSONObject == null) {
            return;
        }
        z(naVar, str, "splash_ad_showstat", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.34
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject2) throws JSONException {
                jSONObject2.put("ad_extra_data", jSONObject.toString());
            }
        });
    }

    public static void z(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("isCanUseLocation", uy.ls().p().z());
            jSONObject2.put("isCanUsePhoneState", uy.ls().p().dl());
            jSONObject2.put("isCanUseWifiState", uy.ls().p().a());
            jSONObject2.put("isCanUseWriteExternal", uy.ls().p().gc());
            jSONObject2.put("alist", uy.ls().p().g());
            jSONObject2.put("isCanUseAndroidId", uy.ls().p().m());
            jSONObject2.put("isCanUsePermissionRecordAudio", uy.ls().p().e());
            if (uy.ls().p().pf() != null && !uy.ls().p().pf().isEmpty()) {
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry<String, Object> entry : uy.ls().p().pf().entrySet()) {
                    jSONObject3.put(entry.getKey(), entry.getValue());
                }
                jSONObject2.put("update_privacyConfig", jSONObject3);
            }
            jSONObject.put("regulation_data", jSONObject2);
        } catch (JSONException unused) {
        }
    }

    public static void dl(final na naVar, String str) {
        z(naVar, str, "cache_ana_upload", new com.bytedance.sdk.openadsdk.m.z.z() { // from class: com.bytedance.sdk.openadsdk.core.i.a.35
            @Override // com.bytedance.sdk.openadsdk.m.z.z
            public void z(JSONObject jSONObject) throws JSONException {
                JSONObject jSONObject2 = new JSONObject();
                naVar.ac().z(jSONObject2);
                jSONObject.put("ad_extra_data", jSONObject2);
            }
        });
    }
}
