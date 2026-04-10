package com.bytedance.msdk.gc.dl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.msdk.api.z.g;
import com.bytedance.msdk.core.uy.uy;
import com.bytedance.msdk.gc.a;
import com.bytedance.msdk.gc.gz;
import com.bytedance.msdk.gc.m;
import com.bytedance.msdk.gz.h;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.m.dl;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static volatile z z;

    public static z z() {
        if (z == null) {
            synchronized (z.class) {
                if (z == null) {
                    z = new z();
                }
            }
        }
        return z;
    }

    public void z(a aVar, g gVar, String str, boolean z2, String str2, int i, Map<String, Object> map) {
        String strZ;
        if (i > 0) {
            strZ = com.bytedance.msdk.api.z.z(i);
        } else {
            strZ = "";
            i = 0;
        }
        aVar.z("mediation_request").z("server_bidding_extra", str2).z("mediation_req_type", Integer.valueOf(i != 0 ? z2 ? 2 : 3 : !z2 ? 1 : 0)).z("ad_count", Integer.valueOf(gVar != null ? gVar.hh() : 0)).g(i).uy(strZ);
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        if (gVar != null && gVar.dl() == 5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("parallel_num", com.bytedance.msdk.core.gc.g.a.z().dl());
                jSONObject.put(an.aU, com.bytedance.msdk.core.gc.g.a.z().a());
                jSONObject.put("primerit_list", com.bytedance.msdk.core.gc.g.a.z().g());
                map2.put("preload_info", jSONObject);
            } catch (JSONException e) {
                wp.z(e);
            }
        }
        if (gVar != null && gVar.iq() == 3 && (com.bytedance.msdk.e.g.z.z().kb() || com.bytedance.msdk.e.g.z.z().wp())) {
            map2.put("init_splash_request_duration", Long.valueOf(com.bytedance.msdk.e.g.z.z().fo()));
        }
        map2.put("csj_plugin_version", dl.dl());
        m.z(aVar, gVar, (uy) null, (com.bytedance.msdk.g.dl) null, map2);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map2);
    }

    public void z(a aVar, com.bytedance.msdk.g.dl dlVar, g gVar, com.bytedance.msdk.core.uy.g gVar2, long j, String str, boolean z2, int i, boolean z3, boolean z4) {
        aVar.z("mediation_fill").z(j).z("server_bidding_extra", str).z("mediation_req_type", Integer.valueOf(!z2 ? 1 : 0)).z("ad_count", Integer.valueOf(i)).g(0).uy("");
        HashMap map = new HashMap();
        if (gVar != null && gVar.iq() == 3) {
            if (com.bytedance.msdk.e.g.z.z().kb()) {
                com.bytedance.msdk.e.g.z.z().z(com.bytedance.msdk.gc.z.dl);
                map.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.e.g.z.z().uy()));
            } else if (com.bytedance.msdk.e.g.z.z().wp()) {
                map.put("init_splash_fill_duration", Long.valueOf(com.bytedance.msdk.e.g.z.z().uy()));
            }
        }
        m.z(aVar, gVar, (uy) null, dlVar, map);
        map.put("timeout_req", Integer.valueOf(z3 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z4 ? 1 : 0));
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, g gVar, com.bytedance.msdk.g.dl dlVar, long j, int i, int i2, int i3, String str, int i4, int i5, com.bytedance.msdk.core.uy.g gVar2, JSONObject jSONObject) {
        JSONObject jSONObjectUy;
        aVar.z("mediation_request_end").z(j).z("ad_count", Integer.valueOf(i4)).z(MediationConstant.KEY_REASON, Integer.valueOf(i5)).g(i3);
        HashMap map = new HashMap();
        m.z(aVar, gVar, (uy) null, dlVar, map);
        map.put("requested_adn_count", Integer.valueOf(i));
        map.put("requested_level_count", Integer.valueOf(i2));
        if (jSONObject != null) {
            map.put("auto_detail", jSONObject);
        }
        if (gVar2 != null) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("layer_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(gVar2.dl())));
                jSONObject2.putOpt("req_interval", Long.valueOf(gVar2.gc()));
                jSONObject2.putOpt("total_time_rate", String.format(Locale.getDefault(), "%.2f", Double.valueOf(gVar2.a())));
                map.put("preload_req", jSONObject2);
            } catch (Throwable th) {
                wp.z(th);
            }
        }
        if (gVar != null && (jSONObjectUy = gVar.uy()) != null) {
            map.put("behavior", jSONObjectUy);
        }
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, g gVar, com.bytedance.msdk.api.z zVar, String str) {
        JSONObject jSONObjectUy;
        aVar.z("total_load_fail").z("server_bidding_extra", str);
        if (zVar.z == 10003) {
            aVar.g(10010).uy("延长瀑布流总超时时长或者缩短层超时并添加兜底代码位");
            z(aVar);
        } else if (zVar.z == 810085) {
            aVar.g(zVar.z).uy(zVar.g);
            z(aVar);
        } else if (zVar instanceof com.bytedance.msdk.api.g.dl) {
            com.bytedance.msdk.api.g.dl dlVar = (com.bytedance.msdk.api.g.dl) zVar;
            aVar.g(zVar.z).uy(zVar.g);
            aVar.z("block_pacing", dlVar.z());
            aVar.z("waterfall_show_rule_id", dlVar.g());
        } else if (zVar instanceof com.bytedance.msdk.api.g.g) {
            com.bytedance.msdk.api.g.g gVar2 = (com.bytedance.msdk.api.g.g) zVar;
            aVar.g(zVar.z).uy(zVar.g);
            aVar.z("block_show_count", gVar2.z());
            aVar.z("waterfall_show_rule_id", gVar2.g());
        } else if (zVar instanceof com.bytedance.msdk.api.g.z) {
            aVar.g(zVar.z).uy(zVar.g);
            z(aVar);
        } else {
            aVar.g(10086).uy("Ad load fail all loadsorts! ");
            z(aVar);
        }
        HashMap map = new HashMap();
        if (gVar != null && (jSONObjectUy = gVar.uy()) != null) {
            map.put("behavior", jSONObjectUy);
        }
        aVar.z("ad_count", Integer.valueOf(gVar != null ? gVar.hh() : 0));
        m.z(aVar, gVar, (uy) null, (com.bytedance.msdk.g.dl) null, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, uy uyVar, g gVar, String str, boolean z2, int i, int i2, int i3, int i4, com.bytedance.msdk.api.z zVar, long j, boolean z3, boolean z4, String str2) {
        int iG;
        if ((zVar instanceof com.bytedance.msdk.api.g.dl) || (zVar instanceof com.bytedance.msdk.api.g.g) || (zVar instanceof com.bytedance.msdk.api.g.z)) {
            aVar.g(zVar.z).uy(zVar.g);
        }
        aVar.z("media_request").m(str).z("ad_count", Integer.valueOf(gVar != null ? gVar.hh() : 0)).z("adn_count", Integer.valueOf(i2)).z("mediationrit_req_type", Integer.valueOf(i3)).z("mediationrit_req_type_src", Integer.valueOf(i4)).z("mediation_req_type", Integer.valueOf(!z2 ? 1 : 0)).z("media_req_type", Integer.valueOf(i));
        HashMap map = new HashMap();
        map.put("timeout_req", Integer.valueOf(z3 ? 1 : 0));
        map.put("is_callback", Integer.valueOf(z4 ? 1 : 0));
        if (gVar != null && gVar.f() && !TextUtils.isEmpty(str2)) {
            map.put("origin_link_id", str2);
        }
        if (gVar != null && gVar.na() != null && uyVar != null && MediationConstant.ADN_PANGLE.equals(uyVar.pf()) && uyVar.i() == 5 && (iG = gVar.na().g()) == 1) {
            map.put("support_render_control", Integer.valueOf(iG));
        }
        if (j != -1) {
            map.put(d.p, Long.valueOf(SystemClock.elapsedRealtime() - j));
        }
        m.z(aVar, gVar, uyVar, (com.bytedance.msdk.g.dl) null, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, com.bytedance.msdk.g.dl dlVar, int i, String str, long j, g gVar, int i2, int i3, int i4, String str2, long j2, long j3) {
        aVar.z("media_fill").z(j).g(i).uy(str).z("adn_count", Integer.valueOf(i2)).z("adn_preload", Integer.valueOf((dlVar == null || !dlVar.xl()) ? 0 : 1)).z("ad_count", Integer.valueOf(i3));
        aVar.z("fill_type", Integer.valueOf(i4));
        if (str2 != null) {
            aVar.z("sub_adn_name", str2);
        }
        HashMap map = new HashMap();
        boolean z2 = j2 >= 0;
        if (dlVar != null && dlVar.jc()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(js.dl()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        if (j3 != -1) {
            map.put(d.q, Long.valueOf(j3));
        }
        if (dlVar != null && MediationConstant.ADN_PANGLE.equals(dlVar.zx()) && dlVar.hy() == 5 && dlVar.uf() == 1) {
            map.put("if_to_express", Integer.valueOf(dlVar.uf()));
        }
        if (com.bytedance.msdk.core.g.g().t() && dlVar != null && 5 == dlVar.hy()) {
            aVar.z("ex_info", gz.z().z(dlVar));
        }
        m.z(aVar, gVar, (uy) null, dlVar, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, com.bytedance.msdk.api.z zVar, g gVar, uy uyVar, int i, int i2, int i3, String str, long j, String str2, String str3, String str4, long j2) {
        if (zVar instanceof com.bytedance.msdk.api.g.dl) {
            com.bytedance.msdk.api.g.dl dlVar = (com.bytedance.msdk.api.g.dl) zVar;
            aVar.g(zVar.z).uy(zVar.g);
            aVar.z("block_pacing", dlVar.z());
            aVar.z("adn_rit_show_rule_id", dlVar.g());
        } else if (zVar instanceof com.bytedance.msdk.api.g.g) {
            com.bytedance.msdk.api.g.g gVar2 = (com.bytedance.msdk.api.g.g) zVar;
            aVar.g(zVar.z).uy(zVar.g);
            aVar.z("block_show_count", gVar2.z());
            aVar.z("adn_rit_show_rule_id", gVar2.g());
        } else if (zVar instanceof com.bytedance.msdk.api.g.z) {
            aVar.g(zVar.z);
            aVar.uy(zVar.g);
            g(aVar);
        } else {
            aVar.g(zVar != null ? zVar.dl : -1).uy(zVar != null ? zVar.f366a : "unknown error");
            g(aVar);
        }
        aVar.z("media_fill_fail").z(j).m(str).z("adn_count", Integer.valueOf(i)).z("adn_preload", 0).z("mediationrit_req_type", Integer.valueOf(i2)).z("mediationrit_req_type_src", Integer.valueOf(i3));
        HashMap map = new HashMap();
        boolean z2 = j2 >= 0;
        if (uyVar != null && uyVar.oq()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(js.dl()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                map.put("custom_adn_rec_time", Long.valueOf(j2));
            }
        }
        m.z(aVar, gVar, uyVar, (com.bytedance.msdk.g.dl) null, map);
        if (!TextUtils.isEmpty(str2)) {
            aVar.fo(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            aVar.z("level_tag", str3);
        }
        if (str4 != null) {
            aVar.z("sub_adn_name", str4);
        }
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, uy uyVar, g gVar, int i, int i2) {
        aVar.z("adapter_request_fail").z(0L).m((String) null).g(-99999).uy("adapter create fail !").z("mediationrit_req_type", Integer.valueOf(i)).z("mediationrit_req_type_src", Integer.valueOf(i2));
        HashMap map = new HashMap();
        m.z(aVar, gVar, uyVar, (com.bytedance.msdk.g.dl) null, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, g gVar, int i) {
        aVar.z("get_config_error").g(i);
        HashMap map = new HashMap();
        m.z(aVar, gVar, (uy) null, (com.bytedance.msdk.g.dl) null, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, com.bytedance.msdk.g.dl dlVar, g gVar, List<com.bytedance.msdk.g.dl> list, List<com.bytedance.msdk.g.dl> list2) {
        Iterator<com.bytedance.msdk.g.dl> it;
        HashMap map;
        Iterator<com.bytedance.msdk.g.dl> it2;
        aVar.z("bidding_win_event");
        HashMap map2 = new HashMap();
        m.z(aVar, gVar, (uy) null, dlVar, map2);
        JSONArray jSONArray = new JSONArray();
        if (!h.z(list)) {
            Iterator<com.bytedance.msdk.g.dl> it3 = list.iterator();
            while (it3.hasNext()) {
                com.bytedance.msdk.g.dl next = it3.next();
                if (next != null) {
                    it2 = it3;
                    try {
                        JSONObject jSONObject = new JSONObject();
                        map = map2;
                        try {
                            jSONObject.putOpt("mediation_rit", next.yz());
                            jSONObject.putOpt(MediationConstant.EXTRA_ADN_NAME, next.zx());
                            jSONObject.putOpt("load_sort", Integer.valueOf(next.xo()));
                            jSONObject.putOpt("show_sort", Integer.valueOf(next.dt()));
                            jSONObject.putOpt("exchange_rate", next.qd());
                            jSONObject.putOpt("rit_cpm", Double.valueOf(next.u()));
                            jSONObject.putOpt("m_aid", next.wj());
                            jSONObject.putOpt("req_bidding_type", Integer.valueOf(next.yt()));
                            jSONObject.putOpt("win_state", 1);
                            jSONObject.putOpt("ad_extra", next.na());
                            jSONObject.putOpt("win_callback", next.eo());
                            jSONObject.putOpt("loss_callback", next.oq());
                            if (next.hn()) {
                                jSONObject.putOpt("pricing_type", Integer.valueOf(next.un()));
                            }
                            jSONArray.put(jSONObject);
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                        map = map2;
                    }
                } else {
                    map = map2;
                    it2 = it3;
                }
                it3 = it2;
                map2 = map;
            }
        }
        HashMap map3 = map2;
        if (!h.z(list2)) {
            Iterator<com.bytedance.msdk.g.dl> it4 = list2.iterator();
            while (it4.hasNext()) {
                com.bytedance.msdk.g.dl next2 = it4.next();
                if (next2 != null) {
                    it = it4;
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = jSONArray;
                        try {
                            jSONObject2.putOpt("mediation_rit", next2.yz());
                            jSONObject2.putOpt(MediationConstant.EXTRA_ADN_NAME, next2.zx());
                            jSONObject2.putOpt("load_sort", Integer.valueOf(next2.xo()));
                            jSONObject2.putOpt("show_sort", Integer.valueOf(next2.dt()));
                            jSONObject2.putOpt("exchange_rate", next2.qd());
                            jSONObject2.putOpt("rit_cpm", Double.valueOf(next2.u()));
                            jSONObject2.putOpt("m_aid", next2.wj());
                            jSONObject2.putOpt("req_bidding_type", Integer.valueOf(next2.yt()));
                            jSONObject2.putOpt("win_state", 0);
                            jSONObject2.putOpt("ad_extra", next2.na());
                            jSONObject2.putOpt("win_callback", next2.eo());
                            jSONObject2.putOpt("loss_callback", next2.oq());
                            if (next2.hn()) {
                                jSONObject2.putOpt("pricing_type", Integer.valueOf(next2.un()));
                            }
                            jSONArray = jSONArray2;
                            jSONArray.put(jSONObject2);
                        } catch (Exception unused3) {
                            jSONArray = jSONArray2;
                        }
                    } catch (Exception unused4) {
                    }
                } else {
                    it = it4;
                }
                it4 = it;
            }
        }
        map3.put("others", jSONArray);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map3);
    }

    public void z(a aVar, g gVar, JSONObject jSONObject) {
        aVar.z("start_bidding_request").z(2).z("ad_count", Integer.valueOf(gVar != null ? gVar.hh() : 0));
        HashMap map = new HashMap();
        if (jSONObject != null) {
            map.put("token_time", jSONObject);
        }
        m.z(aVar, gVar, (uy) null, (com.bytedance.msdk.g.dl) null, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, g gVar, com.bytedance.msdk.core.a.g gVar2, int i) {
        if (gVar2 == null) {
            return;
        }
        aVar.z("return_bidding_result").z(gVar2.e).setResult(gVar2.m).g(gVar2.gz == null ? 0 : gVar2.gz.z).uy(gVar2.gz == null ? "" : gVar2.gz.g).z(2).z("fill_type", Integer.valueOf(i)).z("server_bidding_extra", gVar2.f371a).z("ad_count", Integer.valueOf(gVar2.fo));
        HashMap map = new HashMap();
        com.bytedance.msdk.core.fo.a.z(gVar2.uy, gVar2.z, map);
        if (gVar2.kb != null) {
            map.put("token_time", gVar2.kb);
        }
        m.z(aVar, gVar, (uy) null, (com.bytedance.msdk.g.dl) null, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, uy uyVar, g gVar, String str) {
        aVar.z("get_bidding_adm_to_adn").m(str);
        HashMap map = new HashMap();
        m.z(aVar, gVar, uyVar, (com.bytedance.msdk.g.dl) null, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, com.bytedance.msdk.g.dl dlVar, g gVar, uy uyVar, long j) {
        aVar.z("bidding_adm_load").z(j);
        HashMap map = new HashMap();
        if (com.bytedance.msdk.core.g.g().t() && dlVar != null && 5 == dlVar.hy()) {
            aVar.z("ex_info", gz.z().z(dlVar));
        }
        m.z(aVar, gVar, uyVar, dlVar, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, com.bytedance.msdk.g.dl dlVar, g gVar, uy uyVar) {
        aVar.z("bidding_adm_cache");
        HashMap map = new HashMap();
        m.z(aVar, gVar, uyVar, dlVar, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, g gVar, com.bytedance.msdk.g.dl dlVar, uy uyVar) {
        aVar.z("media_cache_success");
        HashMap map = new HashMap();
        m.z(aVar, gVar, uyVar, dlVar, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    public void z(a aVar, g gVar, com.bytedance.msdk.g.dl dlVar, long j) {
        aVar.z("mediation_video_cached").z(j);
        HashMap map = new HashMap();
        m.z(aVar, gVar, (uy) null, dlVar, map);
        com.bytedance.msdk.gc.dl.z(com.bytedance.msdk.core.g.getContext(), aVar, map);
    }

    private static void z(a aVar) {
        aVar.z("block_pacing", "-1");
        aVar.z("waterfall_show_rule_id", "-1");
        aVar.z("block_show_count", "-1");
    }

    private static void g(a aVar) {
        aVar.z("block_pacing", "-1");
        aVar.z("rit_adn_show_rule_id", "-1");
        aVar.z("block_show_count", "-1");
    }
}
