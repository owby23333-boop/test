package com.bytedance.msdk.gc;

import android.text.TextUtils;
import com.bytedance.msdk.gz.js;
import com.bytedance.msdk.gz.l;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m {
    private static int dl;
    private static int g;
    private static int z;

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, int i, String str, long j, int i2, int i3, String str2) {
        com.bytedance.msdk.core.v.dl dlVarG;
        com.bytedance.msdk.core.uy.g gVarZ;
        a aVarG = a.g();
        aVarG.z("media_reward_verify").z("adn_preload", Integer.valueOf((dlVar == null || !dlVar.xl()) ? 0 : 1)).z(MediationConstant.KEY_REASON, Integer.valueOf(i2)).z("play_again", Integer.valueOf(i));
        if (i3 != 0 && i3 != 20000) {
            aVarG.g(i3).uy(str2);
        }
        HashMap map = new HashMap();
        boolean z2 = j >= 0;
        if (dlVar != null && dlVar.jc()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(js.dl()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        if (gVar != null && (dlVarG = com.bytedance.msdk.core.g.g()) != null && (gVarZ = dlVarG.z(gVar.zw(), gVar.iq(), 101)) != null) {
            map.put("reward_callback_type", Integer.valueOf(gVarZ.j()));
            map.put("reward_start_time", Integer.valueOf(gVarZ.xl()));
        }
        if (str != null) {
            aVarG.z("sub_adn_name", str);
        }
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, int i, String str, long j, boolean z2) {
        z(dlVar, gVar, i, str, j, (String) null, z2);
    }

    public static void z() {
        a aVarG = a.g();
        aVarG.z("mediation_sdk_init");
        HashMap map = new HashMap();
        map.put("call_init_time", Long.valueOf(com.bytedance.sdk.gromore.init.gc.z));
        map.put("call_init_csj_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.gc.g));
        map.put("call_init_csj_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.gc.dl));
        map.put("call_init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.gc.g - com.bytedance.sdk.gromore.init.gc.z));
        map.put("init_csj_duration", Long.valueOf(com.bytedance.sdk.gromore.init.gc.dl - com.bytedance.sdk.gromore.init.gc.g));
        map.put("call_init_gromore_start_time", Long.valueOf(com.bytedance.sdk.gromore.init.gc.f870a));
        map.put("call_init_gromore_end_time", Long.valueOf(com.bytedance.sdk.gromore.init.gc.gc));
        map.put("call_init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.gc.f870a - com.bytedance.sdk.gromore.init.gc.z));
        map.put("init_gromore_duration", Long.valueOf(com.bytedance.sdk.gromore.init.gc.gc - com.bytedance.sdk.gromore.init.gc.f870a));
        map.put("init_total_duration", Long.valueOf(com.bytedance.sdk.gromore.init.gc.gc - com.bytedance.sdk.gromore.init.gc.z));
        try {
            z(aVarG, (com.bytedance.msdk.api.z.g) null, (com.bytedance.msdk.core.uy.uy) null, (com.bytedance.msdk.g.dl) null, map);
            dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
        } catch (Throwable th) {
            wp.z(th);
        }
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, int i, String str, long j, String str2, boolean z2) {
        a aVarG = a.g();
        aVarG.z("media_show_listen").z("adn_preload", Integer.valueOf((dlVar == null || !dlVar.xl()) ? 0 : 1)).z("play_again", Integer.valueOf(i)).z("is_repeat", Integer.valueOf(z2 ? 1 : 0));
        if (str != null) {
            aVarG.z("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVarG.z("callstack_message", str2);
        }
        HashMap map = new HashMap();
        map.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.g.g().ti() ? 1 : 0));
        map.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.z.kb().z() ? 1 : 0));
        com.bytedance.msdk.core.g.dl.z(dlVar, gVar, map);
        boolean z3 = j >= 0;
        if (dlVar != null && dlVar.jc()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(js.dl()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z3));
            if (z3) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, String str) {
        a aVarG = a.g();
        aVarG.z("media_show_dislike").uy(str);
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void g(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, int i, String str, long j, boolean z2) {
        g(dlVar, gVar, i, str, j, null, z2);
    }

    public static void g(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, int i, String str, long j, String str2, boolean z2) {
        a aVarG = a.g();
        aVarG.z("media_click_listen").z("adn_preload", Integer.valueOf((dlVar == null || !dlVar.xl()) ? 0 : 1)).z("play_again", Integer.valueOf(i)).z("is_repeat", Integer.valueOf(z2 ? 1 : 0));
        if (str != null) {
            aVarG.z("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVarG.z("callstack_message", str2);
        }
        HashMap map = new HashMap();
        boolean z3 = j >= 0;
        if (dlVar != null && dlVar.jc()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(js.dl()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z3));
            if (z3) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, boolean z2, int i) {
        z(dlVar, gVar, z2, i, (Map<String, Object>) null);
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, boolean z2, int i, Map<String, Object> map) {
        a aVarG = a.g();
        aVarG.z("media_show").z("adn_preload", Integer.valueOf((dlVar == null || !dlVar.xl()) ? 0 : 1)).z("play_again", Integer.valueOf(i)).z("is_repeat", Integer.valueOf(z2 ? 1 : 0));
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map2);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map2);
    }

    public static void z(List<com.bytedance.msdk.g.dl> list, List<com.bytedance.msdk.g.dl> list2, List<com.bytedance.msdk.g.dl> list3, com.bytedance.msdk.api.z.g gVar, int i) {
        boolean zUn;
        ArrayList<com.bytedance.msdk.g.dl> arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
        }
        if (list2 != null && list2.size() > 0) {
            arrayList.addAll(list2);
        }
        if (list3 != null && list3.size() > 0) {
            arrayList.addAll(list3);
        }
        int i2 = 0;
        com.bytedance.msdk.g.dl dlVar = arrayList.size() > 0 ? (com.bytedance.msdk.g.dl) arrayList.get(0) : null;
        a aVarG = a.g();
        aVarG.z("media_show_is_ready");
        if (i == 0) {
            try {
                JSONArray jSONArray = new JSONArray();
                loop0: while (true) {
                    zUn = false;
                    for (com.bytedance.msdk.g.dl dlVar2 : arrayList) {
                        if (dlVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", dlVar2.zx());
                            jSONObject.put("type", com.bytedance.msdk.g.z.z(dlVar2.hy(), dlVar2.j()));
                            jSONObject.put("adnSlotId", dlVar2.yz());
                            jSONObject.put("loadSort", dlVar2.xo());
                            jSONObject.put("showSort", dlVar2.dt());
                            if (gVar != null) {
                                jSONObject.put("isReady", dlVar2.un(gVar.zw()) ? 1 : 0);
                            }
                            jSONObject.put("hasShown", dlVar2.jq() ? 1 : 0);
                            if (dlVar2.bb()) {
                                jSONObject.put("is_video_cache_success", dlVar2.by() ? 1 : 0);
                            }
                            jSONObject.put("mediationrit_req_type", dlVar2.gz(gVar != null ? gVar.z() : null));
                            jSONObject.put("mediationrit_req_type_src", dlVar2.fo(gVar != null ? gVar.z() : null));
                            jSONArray.put(jSONObject);
                            if (!zUn && gVar != null) {
                                if (gVar.iq() == 5) {
                                    zUn = dlVar2.un(gVar.zw());
                                } else if (!dlVar2.un(gVar.zw()) || dlVar2.jq()) {
                                    break;
                                } else {
                                    zUn = true;
                                }
                            }
                        }
                    }
                }
                if (!zUn) {
                    i2 = -1;
                }
                aVarG.g(i2);
                aVarG.uy(jSONArray.toString());
            } catch (JSONException e) {
                wp.z(e);
            }
        } else {
            aVarG.g(2);
            aVarG.uy(com.bytedance.msdk.api.z.z(i));
        }
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(List<com.bytedance.msdk.g.dl> list, com.bytedance.msdk.api.z.g gVar, int i) {
        com.bytedance.msdk.g.dl dlVar = (list == null || list.size() <= 0) ? null : list.get(0);
        a aVarG = a.g();
        aVarG.z("media_show_fail");
        if (i == 0) {
            aVarG.g(40052);
            if (dlVar != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (com.bytedance.msdk.g.dl dlVar2 : list) {
                        if (dlVar2 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("adn", dlVar2.zx());
                            jSONObject.put("type", com.bytedance.msdk.g.z.z(dlVar2.hy(), dlVar2.j()));
                            jSONObject.put("adnSlotId", dlVar2.yz());
                            jSONObject.put("loadSort", dlVar2.xo());
                            jSONObject.put("showSort", dlVar2.dt());
                            int i2 = 1;
                            if (gVar != null) {
                                jSONObject.put("isReady", dlVar2.un(gVar.zw()) ? 1 : 0);
                            }
                            if (!dlVar2.jq()) {
                                i2 = 0;
                            }
                            jSONObject.put("hasShown", i2);
                            jSONArray.put(jSONObject);
                        }
                    }
                    aVarG.uy(jSONArray.toString());
                } catch (JSONException e) {
                    wp.z(e);
                }
            }
        } else {
            aVarG.g(i);
            aVarG.uy(com.bytedance.msdk.api.z.z(i));
        }
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        aVarG.z("is_video_cache_success", 0);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.api.z.g gVar, int i) {
        a aVarG = a.g();
        aVarG.z("media_carousel_fail").g(i).uy(com.bytedance.msdk.api.z.z(i));
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, (com.bytedance.msdk.g.dl) null, map);
        aVarG.z("is_video_cache_success", 0);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(final int i, final int i2, final long j, final String str, final String str2) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.1
            @Override // java.lang.Runnable
            public void run() {
                aVarDl.z("rit_map_query").setResult(i2).z(j).gc(i);
                HashMap map = new HashMap();
                if (!TextUtils.isEmpty(str)) {
                    aVarDl.gz(str);
                    map.put("origin_rit", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    aVarDl.g(str2);
                    map.put(MediationConstant.KEY_GM_PRIME_RIT, str2);
                }
                dl.z(com.bytedance.msdk.core.g.getContext(), aVarDl, map);
            }
        });
    }

    public static void z(final com.bytedance.msdk.core.uy.uy uyVar, final com.bytedance.msdk.api.z.g gVar, final String str, final boolean z2, final int i, final int i2, final int i3, final int i4, final com.bytedance.msdk.api.z zVar, final long j, final boolean z3, final boolean z4) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.12
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, uyVar, gVar, str, z2, i, i2, i3, i4, zVar, j, z3, z4, null);
            }
        });
    }

    public static void z(final com.bytedance.msdk.core.uy.uy uyVar, final com.bytedance.msdk.api.z.g gVar, final String str, final boolean z2, final int i, final int i2, final int i3, final int i4, final com.bytedance.msdk.api.z zVar, final long j, final boolean z3, final boolean z4, final String str2) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.16
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, uyVar, gVar, str, z2, i, i2, i3, i4, zVar, j, z3, z4, str2);
            }
        });
    }

    public static void z(com.bytedance.msdk.core.uy.uy uyVar, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.g.dl dlVar, int i, String str) {
        a aVarG = a.g();
        a aVarZ = aVarG.z("bidding_info_invalid").g(i).uy(str).z("ad_count", Integer.valueOf(gVar != null ? gVar.hh() : 0));
        com.bytedance.msdk.core.v.g.z(com.bytedance.msdk.core.g.g());
        aVarZ.z("grouping_params", com.bytedance.msdk.core.v.g.g()).z("log_source", 2);
        HashMap map = new HashMap();
        z(aVarG, gVar, uyVar, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(final com.bytedance.msdk.g.dl dlVar, final int i, final String str, final long j, final com.bytedance.msdk.api.z.g gVar, final int i2, final int i3, final int i4, final String str2, final long j2, final long j3) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.17
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, dlVar, i, str, j, gVar, i2, i3, i4, str2, j2, j3);
            }
        });
    }

    public static void z(final com.bytedance.msdk.api.z zVar, final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.core.uy.uy uyVar, final int i, final int i2, final int i3, final String str, final long j, final String str2, final String str3, final String str4, final long j2) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.18
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, zVar, gVar, uyVar, i, i2, i3, str, j, str2, str3, str4, j2);
            }
        });
    }

    public static void z(com.bytedance.msdk.api.z zVar, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.uy.uy uyVar, int i, int i2, int i3, String str, long j) {
        a aVarG = a.g();
        aVarG.z("bidding_adm_load_fail").z(j).m(str).g(zVar != null ? zVar.dl : -1).uy(zVar != null ? zVar.f366a : "unknown error").z("adn_count", Integer.valueOf(i)).z("adn_preload", 0).z("mediationrit_req_type", Integer.valueOf(i2)).z("mediationrit_req_type_src", Integer.valueOf(i3));
        if (zVar instanceof com.bytedance.msdk.api.g.z) {
            aVarG.v = zVar.z;
            aVarG.kb = zVar.g;
        }
        HashMap map = new HashMap();
        z(aVarG, gVar, uyVar, (com.bytedance.msdk.g.dl) null, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.api.z zVar, final String str) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.19
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, zVar, str);
            }
        });
    }

    public static void z(final com.bytedance.msdk.core.uy.uy uyVar, final com.bytedance.msdk.api.z.g gVar, final int i, final int i2) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.20
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, uyVar, gVar, i, i2);
            }
        });
    }

    public static void z(final com.bytedance.msdk.api.z.g gVar, final String str, final boolean z2, final String str2, final int i, final Map<String, Object> map) {
        if (gVar != null) {
            com.bytedance.sdk.gromore.g.z.z().z(gVar.z(), z.dl);
        }
        final a aVarDl = a.dl();
        final long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.21
            @Override // java.lang.Runnable
            public void run() {
                aVarDl.z(System.currentTimeMillis() - jCurrentTimeMillis);
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, str, z2, str2, i, map);
            }
        });
    }

    public static void z(Map<String, Object> map, final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.g.dl dlVar, final long j, final int i, final int i2, final int i3, final String str, final int i4, final int i5, final com.bytedance.msdk.core.uy.g gVar2) {
        final JSONObject jSONObject;
        int i6;
        final a aVarDl = a.dl();
        if (map != null) {
            int iIntValue = map.get("group_type") instanceof Integer ? ((Integer) map.get("group_type")).intValue() : 0;
            double dDoubleValue = map.get(MediationConstant.KEY_ECPM) instanceof Double ? ((Double) map.get(MediationConstant.KEY_ECPM)).doubleValue() : 0.0d;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("price_from", map.get("price_from"));
                jSONObject2.put("grout_type", iIntValue);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("target_ecpm_origin", dDoubleValue);
                jSONObject3.put("target_ecpm_upper", map.get("upper_cpm_x"));
                jSONObject2.put("price", jSONObject3);
                if (map.get("price_source") != null) {
                    jSONObject2.put("price_source", map.get("price_source"));
                }
                int iIntValue2 = map.get("rule_in_use") instanceof Integer ? ((Integer) map.get("rule_in_use")).intValue() : 0;
                boolean zBooleanValue = map.get("has_serverBidding") instanceof Boolean ? ((Boolean) map.get("has_serverBidding")).booleanValue() : false;
                if (iIntValue != 3 && iIntValue != 4) {
                    i6 = 0;
                } else if (!zBooleanValue) {
                    i6 = 1;
                } else if (dDoubleValue == 0.0d) {
                    i6 = 2;
                } else if (iIntValue2 == 0) {
                    i6 = 5;
                } else {
                    i6 = (iIntValue != 4 || (map.get("serverBidding_timeout") instanceof Boolean ? ((Boolean) map.get("serverBidding_timeout")).booleanValue() : false)) ? 4 : 3;
                }
                jSONObject2.put("pos_state", i6);
                jSONObject2.put("rule_id", map.get("rule_id"));
                jSONObject2.put("rule_inuse", iIntValue2);
            } catch (JSONException unused) {
            }
            jSONObject = jSONObject2;
        } else {
            jSONObject = null;
        }
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.22
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, dlVar, j, i, i2, i3, str, i4, i5, gVar2, jSONObject);
            }
        });
    }

    public static void z(final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.g.dl dlVar, final long j) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, dlVar, j);
            }
        });
    }

    public static void z(final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.g.dl dlVar, final com.bytedance.msdk.core.uy.uy uyVar) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, dlVar, uyVar);
            }
        });
    }

    public static void z(final com.bytedance.msdk.g.dl dlVar, final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.core.uy.g gVar2, final long j, final String str, final boolean z2, final int i, final boolean z3, final boolean z4) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, dlVar, gVar, gVar2, j, str, z2, i, z3, z4);
            }
        });
    }

    public static void g(final com.bytedance.msdk.api.z.g gVar, final int i) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, i);
            }
        });
    }

    public static void z(final boolean z2) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.6
            @Override // java.lang.Runnable
            public void run() {
                aVarDl.z("get_config_start").z(MediationConstant.KEY_REASON, Integer.valueOf(z2 ? com.bytedance.msdk.e.z.z().gc("is_config_from_assert") ? 2 : 1 : 0));
                dl.z(com.bytedance.msdk.core.g.getContext(), aVarDl, (Map<String, Object>) null);
            }
        });
    }

    public static void g() {
        a aVarG = a.g();
        aVarG.z("start_up");
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, (Map<String, Object>) null);
    }

    public static void z(long j) {
        String str;
        a aVarG = a.g();
        aVarG.z("sdk_init").dl(j);
        l lVarM = com.bytedance.msdk.e.z.m();
        boolean zGc = lVarM.gc("check_unity3d");
        long jA = lVarM.a("check_unity3d_time");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (zGc && jCurrentTimeMillis - jA > 2592000000L) {
            try {
                Class.forName("com.unity3d.player.UnityPlayer");
                str = "unity_pure";
                try {
                    Class.forName("com.bytedance.android.NativeAdManager");
                    str = MediationConstant.ADN_UNITY;
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                str = null;
            }
            if (str != null) {
                aVarG.z("develop_type", str);
            }
            lVarM.z("check_unity3d", true);
            lVarM.z("check_unity3d_time", jCurrentTimeMillis);
        }
        HashMap map = new HashMap();
        int iA = com.bytedance.msdk.e.g.z.z().a();
        if (iA > 0) {
            com.bytedance.msdk.e.g.z.z().gc();
            map.put("discard_num", Integer.valueOf(iA));
        }
        map.put("csj_plugin_version", com.bytedance.msdk.m.dl.dl());
        JSONObject jSONObjectGc = l.gc();
        if (jSONObjectGc != null) {
            map.put("init_time", jSONObjectGc);
        }
        l.z(map);
        l.g(map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void g(long j) {
        a aVarG = a.g();
        aVarG.z("sdk_backstage").z(j);
        HashMap map = new HashMap();
        if (com.bytedance.msdk.e.g.z.z().kb()) {
            if (com.bytedance.msdk.e.g.z.z().gz() > 0) {
                com.bytedance.msdk.e.g.z.z().z(z.dl);
                map.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.e.g.z.z().gz()));
            }
        } else if (com.bytedance.msdk.e.g.z.z().wp()) {
            map.put("call_init_method_duration", Long.valueOf(com.bytedance.msdk.e.g.z.z().gz()));
        }
        map.put("v3", l.e("v3"));
        map.put("v1", l.e("v1"));
        map.put("v2Enc_config", l.e("v2Enc_config"));
        map.put("v4Enc_config", l.e("v4Enc_config"));
        map.put("v2Enc_exchange", l.e("v2Enc_exchange"));
        map.put("v4Enc_exchange", l.e("v4Enc_exchange"));
        map.put("v2Enc_reward", l.e("v2Enc_reward"));
        map.put("v4Enc_reward", l.e("v4Enc_reward"));
        map.put("enable_label_return", Integer.valueOf(com.bytedance.msdk.core.g.g().ti() ? 1 : 0));
        map.put("if_labelapi_call", Integer.valueOf(com.bytedance.msdk.core.z.kb().z() ? 1 : 0));
        map.put("adn_init_duration", com.bytedance.msdk.m.g.gc.g());
        com.bytedance.msdk.core.z.z.gc.z(map);
        JSONArray jSONArrayA = l.a();
        if (jSONArrayA != null) {
            jSONArrayA.length();
            map.put("sp_v3_bug", jSONArrayA);
        }
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.7
            @Override // java.lang.Runnable
            public void run() {
                aVarDl.z("callstack_dynamic");
                aVarDl.z("callstack_message", str);
                aVarDl.z("callstack_report_time", 1);
                dl.z(com.bytedance.msdk.core.g.getContext(), aVarDl, (Map<String, Object>) null);
            }
        });
    }

    public static void z(final com.bytedance.msdk.g.dl dlVar, final com.bytedance.msdk.api.z.g gVar, final String str, final int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.8
            @Override // java.lang.Runnable
            public void run() {
                aVarDl.z("callstack_static").z("callstack_message", str).z("callstack_report_time", Integer.valueOf(i));
                HashMap map = new HashMap();
                m.z(aVarDl, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
                dl.z(com.bytedance.msdk.core.g.getContext(), aVarDl, map);
            }
        });
    }

    public static void z(long j, int i, int i2, long j2, JSONObject jSONObject, Map<String, Object> map) {
        a aVarG = a.g();
        aVarG.z("sdk_init_end");
        aVarG.z(j);
        aVarG.dl(j2);
        aVarG.z("adn_count", Integer.valueOf(i));
        HashMap map2 = new HashMap();
        if (map != null && map.size() > 0) {
            map2.putAll(map);
        }
        map2.put("is_from_local_config", Integer.valueOf(i2));
        map2.put("adapter_version_list", com.bytedance.msdk.gz.e.z());
        if (jSONObject != null) {
            map2.put("local_init_time", jSONObject);
        }
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map2);
    }

    public static void z(int i, int i2, long j, boolean z2, boolean z3, JSONObject jSONObject, long j2, JSONObject jSONObject2) {
        a aVarG = a.g();
        boolean zGc = com.bytedance.msdk.e.z.z().gc("is_config_from_assert");
        if (i != 1) {
            i = (z2 || (i == 0 && zGc)) ? 2 : 0;
        }
        aVarG.setResult(i).z(j).z("get_config_final").m(i2).g(i2).z("transparent_params", com.bytedance.msdk.core.g.g().fo());
        HashMap map = new HashMap();
        com.bytedance.msdk.core.fo.a.z(z3, aVarG, jSONObject, map);
        if (jSONObject2 != null) {
            map.put("cfg_handle_time", jSONObject2);
        }
        map.put("config_size", Long.valueOf(j2));
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(final com.bytedance.msdk.api.z.g gVar, final JSONObject jSONObject) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.9
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, jSONObject);
            }
        });
    }

    public static void z(final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.core.a.g gVar2, final int i) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.10
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, gVar, gVar2, i);
            }
        });
    }

    public static void z(final com.bytedance.msdk.g.dl dlVar, final com.bytedance.msdk.api.z.g gVar, final List<com.bytedance.msdk.g.dl> list, final List<com.bytedance.msdk.g.dl> list2) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.11
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, dlVar, gVar, list, list2);
            }
        });
    }

    public static void z(final com.bytedance.msdk.core.uy.uy uyVar, final com.bytedance.msdk.api.z.g gVar, final String str) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.13
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, uyVar, gVar, str);
            }
        });
    }

    public static void z(final com.bytedance.msdk.g.dl dlVar, final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.core.uy.uy uyVar, final long j) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.14
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, dlVar, gVar, uyVar, j);
            }
        });
    }

    public static void z(final com.bytedance.msdk.g.dl dlVar, final com.bytedance.msdk.api.z.g gVar, final com.bytedance.msdk.core.uy.uy uyVar) {
        final a aVarDl = a.dl();
        com.bytedance.msdk.z.gc.m.a(new Runnable() { // from class: com.bytedance.msdk.gc.m.15
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.msdk.gc.dl.z.z().z(aVarDl, dlVar, gVar, uyVar);
            }
        });
    }

    public static void z(com.bytedance.msdk.api.z.g gVar, String str) {
        a aVarG = a.g();
        aVarG.z("cache_cannot_use").z("cache_invalid_info", str);
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, (com.bytedance.msdk.g.dl) null, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.g.dl dlVar, String str) {
        a aVarG = a.g();
        aVarG.z("rit_cache_cannot_use").z("cache_invalid_info", str);
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        aVarG.z("mediationrit_req_type", 2);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.api.z.g gVar) {
        a aVarG = a.g();
        aVarG.z("media_will_show");
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, (com.bytedance.msdk.g.dl) null, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.z zVar, int i, int i2, String str, long j) {
        z(dlVar, gVar, zVar, i, i2, str, j, (String) null);
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.api.z zVar, int i, int i2, String str, long j, String str2) {
        a aVarG = a.g();
        aVarG.setResult(i).g(zVar != null ? zVar.dl : 0).uy(zVar != null ? zVar.f366a : null).z("media_show_fail_listen").z("play_again", Integer.valueOf(i2));
        if (str != null) {
            aVarG.z("sub_adn_name", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            aVarG.z("callstack_message", str2);
        }
        HashMap map = new HashMap();
        boolean z2 = j >= 0;
        if (dlVar != null && dlVar.jc()) {
            map.put("custom_adn_sample_ratio", Double.valueOf(js.dl()));
            map.put("custom_adn_sample_ratio_result", Boolean.valueOf(z2));
            if (z2) {
                map.put("custom_adn_rec_time", Long.valueOf(j));
            }
        }
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, int i, int i2, int i3, String str) {
        a aVarG = a.g();
        aVarG.setResult(i2).z("media_show_after").z("play_again", Integer.valueOf(i3)).z(MediationConstant.KEY_REASON, Integer.valueOf(i));
        if (!TextUtils.isEmpty(str)) {
            aVarG.z("callstack_message", str);
        }
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(String str, com.bytedance.msdk.g.dl dlVar, com.bytedance.msdk.api.z.g gVar, com.bytedance.msdk.core.uy.uy uyVar, com.bytedance.msdk.api.z zVar) {
        a aVarG = a.g();
        a aVarUy = aVarG.g(zVar != null ? zVar.z : 0).uy(zVar != null ? zVar.g : null);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        aVarUy.gc(str).z("custom_adn_init_fail");
        HashMap map = new HashMap();
        z(aVarG, gVar, uyVar, dlVar, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void z(com.bytedance.msdk.api.z.g gVar, int i, int i2) {
        a aVarG = a.g();
        aVarG.z("mt_ra_s").g(i);
        HashMap map = new HashMap();
        map.put("pre_req", Integer.valueOf(i2));
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, (com.bytedance.msdk.g.dl) null, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void dl(com.bytedance.msdk.api.z.g gVar, int i) {
        a aVarG = a.g();
        aVarG.z("mt_ra_c").g(i);
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, (com.bytedance.msdk.g.dl) null, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    public static void g(com.bytedance.msdk.api.z.g gVar) {
        a aVarG = a.g();
        aVarG.z("mt_ra_cc");
        HashMap map = new HashMap();
        z(aVarG, gVar, (com.bytedance.msdk.core.uy.uy) null, (com.bytedance.msdk.g.dl) null, map);
        dl.z(com.bytedance.msdk.core.g.getContext(), aVarG, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012c  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v39 */
    /* JADX WARN: Type inference failed for: r0v40, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r20v0, types: [java.util.Map, java.util.Map<java.lang.String, java.lang.Object>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void z(com.bytedance.msdk.gc.a r16, com.bytedance.msdk.api.z.g r17, com.bytedance.msdk.core.uy.uy r18, com.bytedance.msdk.g.dl r19, java.util.Map<java.lang.String, java.lang.Object> r20) {
        /*
            Method dump skipped, instruction units count: 1295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.gc.m.z(com.bytedance.msdk.gc.a, com.bytedance.msdk.api.z.g, com.bytedance.msdk.core.uy.uy, com.bytedance.msdk.g.dl, java.util.Map):void");
    }
}
