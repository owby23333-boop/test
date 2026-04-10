package com.bytedance.sdk.openadsdk.core.fo.z.a;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.component.fo.g.a;
import com.bytedance.sdk.component.kb.a.dl;
import com.bytedance.sdk.component.kb.z.g;
import com.bytedance.sdk.component.utils.wp;
import com.bytedance.sdk.openadsdk.api.plugin.g;
import com.bytedance.sdk.openadsdk.core.dl.m;
import com.bytedance.sdk.openadsdk.core.gk.uy;
import com.bytedance.sdk.openadsdk.core.io.gc;
import com.bytedance.sdk.openadsdk.core.iq.na;
import com.bytedance.sdk.openadsdk.core.un.eo;
import com.bytedance.sdk.openadsdk.core.zw;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class z {
    private static String e;
    private static long gc;
    private static String gz;
    private static long m;
    private static AtomicInteger z = new AtomicInteger(0);
    private static SharedPreferences g = g.g(zw.getContext(), "uchain_data", 0);
    private static int dl = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f1041a = -1;

    public static void z(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str = "21ea2d6d4f321553dd684e6b864bf0b7";
            str2 = "https://sf3-fe-tos.pglstatp-toutiao.com/obj/csj-sdk-static/uchain/20103/uchain_dsl.bin";
        }
        e = str;
        gz = str2;
        m = System.currentTimeMillis();
        JSONObject jSONObjectG = g(e, gz);
        if (jSONObjectG != null && jSONObjectG.length() > 0) {
            f1041a = 2;
            long jCurrentTimeMillis = System.currentTimeMillis() - m;
            gc = jCurrentTimeMillis;
            g(dl, f1041a, jCurrentTimeMillis);
            g(jSONObjectG);
            return;
        }
        com.bytedance.sdk.component.fo.g.z zVarGc = gc.z().g().gc();
        if (zVarGc == null) {
            z.set(3);
            return;
        }
        zVarGc.z(gz);
        final String str3 = e;
        final String str4 = gz;
        zVarGc.z(new com.bytedance.sdk.component.fo.z.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.a.z.1
            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, com.bytedance.sdk.component.fo.g gVar) {
                int unused = z.f1041a = 1;
                String unused2 = z.e = str3;
                String unused3 = z.gz = str4;
                if (gVar != null) {
                    try {
                        if (gVar.gz()) {
                            JSONObject jSONObjectZ = m.z(gVar.uy(), "uchain_dsl");
                            long unused4 = z.gc = System.currentTimeMillis() - z.m;
                            if (jSONObjectZ != null && jSONObjectZ.length() > 0) {
                                z.g(z.dl, z.f1041a, z.gc);
                                z.g(jSONObjectZ);
                                z.g.edit().putString(str3, com.bytedance.sdk.component.utils.z.g(jSONObjectZ.toString())).apply();
                                return;
                            }
                            z.g(z.dl, z.f1041a, z.gc);
                            z.uy();
                            return;
                        }
                    } catch (Throwable unused5) {
                        z.uy();
                        return;
                    }
                }
                z.uy();
            }

            @Override // com.bytedance.sdk.component.fo.z.z
            public void z(a aVar, IOException iOException) {
                int unused = z.f1041a = 1;
                z.uy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void uy() {
        dl = 100008;
        long jCurrentTimeMillis = System.currentTimeMillis() - m;
        gc = jCurrentTimeMillis;
        g(dl, f1041a, jCurrentTimeMillis);
        kb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            jSONObject = z();
        }
        if (jSONObject == null || jSONObject.length() <= 0) {
            z.set(3);
            return;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("event_template");
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.length() <= 0) {
            z.set(3);
        } else {
            com.bytedance.sdk.component.kb.dl.g.INSTANCE.z(jSONObjectOptJSONObject);
            z.set(2);
        }
    }

    private static void kb() {
        String strCt;
        String strW;
        JSONObject jSONObjectG;
        dl = -1;
        uy uyVarG = zw.g();
        if (uyVarG != null && (jSONObjectG = g((strCt = uyVarG.ct()), (strW = uyVarG.w()))) != null && jSONObjectG.length() > 0) {
            f1041a = 2;
            e = strCt;
            gz = strW;
            long jCurrentTimeMillis = System.currentTimeMillis() - m;
            gc = jCurrentTimeMillis;
            g(dl, f1041a, jCurrentTimeMillis);
            g(jSONObjectG);
            return;
        }
        JSONObject jSONObjectZ = z();
        if (jSONObjectZ == null || jSONObjectZ.length() <= 0) {
            z.set(3);
            g(dl, f1041a, gc);
            return;
        }
        f1041a = 0;
        gz = "uc_dsl/uc_dsl.bin";
        long jCurrentTimeMillis2 = System.currentTimeMillis() - m;
        gc = jCurrentTimeMillis2;
        g(dl, f1041a, jCurrentTimeMillis2);
        g(jSONObjectZ);
    }

    public static JSONObject g(String str, String str2) {
        if ((TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String string = g.getString(str, "");
            if (TextUtils.isEmpty(string)) {
                return null;
            }
            String strDl = com.bytedance.sdk.component.utils.z.dl(string);
            f1041a = 2;
            e = str;
            gz = str2;
            return new JSONObject(strDl);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final int i, final int i2, final long j) {
        com.bytedance.sdk.openadsdk.core.q.g.dl().z(new com.bytedance.sdk.openadsdk.kb.z.z() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.a.z.2
            @Override // com.bytedance.sdk.openadsdk.kb.z.z
            public com.bytedance.sdk.openadsdk.core.q.z.z z() {
                JSONObject jSONObject = new JSONObject();
                try {
                    int i3 = i;
                    if (i3 != -1) {
                        jSONObject.put("dsl_error_code", i3);
                    }
                    jSONObject.put("dsl_url", z.gz);
                    jSONObject.put("dsl_md5", z.e);
                    jSONObject.put("dsl_load_type", i2);
                    jSONObject.put("dsl_load_time", j);
                    jSONObject.put("dsl_stats_id", UUID.randomUUID());
                } catch (Throwable unused) {
                }
                return com.bytedance.sdk.openadsdk.core.q.z.g.g().z("uchain_stats_tracker").g(jSONObject.toString());
            }
        }, "uchain_stats_tracker", false);
    }

    public static void z(na naVar, Map<String, Object> map, String str, HashMap<String, Object> map2, String str2, HashMap<String, Object> map3) {
        if (z.get() != 2) {
            m = System.currentTimeMillis();
            kb();
        }
        if (naVar == null) {
            return;
        }
        JSONObject jSONObjectKv = naVar.kv();
        try {
            for (Map.Entry<String, Object> entry : map3.entrySet()) {
                jSONObjectKv.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            wp.z(e2);
        }
        JSONArray jSONArray = new JSONArray();
        new g.z(str).z(jSONObjectKv).z(map2).z(new AnonymousClass3(jSONArray)).z().z();
        JSONObject jSONObject = new JSONObject();
        UUID uuidRandomUUID = UUID.randomUUID();
        if (map != null) {
            map.put("uchain_event_id", uuidRandomUUID);
        }
        try {
            jSONObject.put("uchain_event_id", uuidRandomUUID);
            jSONObject.put(str, jSONArray);
            jSONObject.put("slot_type", eo.gz(naVar));
            com.bytedance.sdk.openadsdk.core.i.a.g(naVar, str2, "uchain_event_tracker", jSONObject);
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.fo.z.a.z$3, reason: invalid class name */
    static class AnonymousClass3 implements dl {
        final /* synthetic */ JSONArray z;

        AnonymousClass3(JSONArray jSONArray) {
            this.z = jSONArray;
        }

        @Override // com.bytedance.sdk.component.kb.a.dl
        public void z(com.bytedance.sdk.component.kb.z.z zVar) {
            zVar.z(new com.bytedance.sdk.component.kb.a.a() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.a.z.3.1
                @Override // com.bytedance.sdk.component.kb.a.a
                public com.bytedance.sdk.component.kb.a.gc g() {
                    return new com.bytedance.sdk.component.kb.a.gc() { // from class: com.bytedance.sdk.openadsdk.core.fo.z.a.z.3.1.1
                        @Override // com.bytedance.sdk.component.kb.a.gc
                        public void z(com.bytedance.sdk.component.kb.z.z zVar2, Map<String, Object> map) {
                            try {
                                String strZ = zVar2.e().z();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(NotificationCompat.CATEGORY_EVENT, strZ);
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, true);
                                AnonymousClass3.this.z.put(jSONObject);
                            } catch (JSONException e) {
                                wp.z(e);
                            }
                        }

                        @Override // com.bytedance.sdk.component.kb.a.gc
                        public void g(com.bytedance.sdk.component.kb.z.z zVar2, Map<String, Object> map) {
                            try {
                                String strZ = zVar2.e().z();
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put(NotificationCompat.CATEGORY_EVENT, strZ);
                                jSONObject.put(NotificationCompat.CATEGORY_STATUS, false);
                                AnonymousClass3.this.z.put(jSONObject);
                            } catch (JSONException e) {
                                wp.z(e);
                            }
                        }
                    };
                }
            });
        }
    }

    public static boolean z(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Object obj = map.get("is_feed_register_direct_download");
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static JSONObject z() {
        try {
            return new JSONObject("{\"template_info\":{\"version\":\"2.1.3\"},\"event_template\":{\"clickEvent\":{\"main\":\"open_sass_live\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_sass_live\",\"scheme\":\"uchain://open_sass_live?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&coupon=${coupon}&ec_schema=${ec_schema}&ecom_live_params=${ecom_live_params}&live_interaction_type=${live_interaction_type}&live_room_id=${live_room_id}&deep_link=${deep_link}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"name\":\"open_miniapp\"}]}},{\"name\":\"open_miniapp\",\"scheme\":\"uchain://open_miniapp?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&wc_miniapp_info=${wc_miniapp_info}&target_url=${target_url}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(is_video_lp==true||if_both_open==1)&&deep_link==null&&ulink==null}\",\"name\":\"open_landing_page\"},{\"condition\":\"${deep_link!=null||ulink!=null||(is_video_lp!=true&&if_both_open==0)}\",\"name\":\"open_scheme\"}]}},{\"name\":\"open_landing_page\",\"scheme\":\"uchain://open_landing_page?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&title=${title!=null?title:'广告'}&url=${target_url}&button_text=${button_text!=null?button_text:'立即下载'}&gecko_id=${gecko_id}&block_auto_open=${block_auto_open}&ugeno=${ugeno}&page_render_type=${page_render_type}&session_params=${session_params}&dylite_info=${dylite_info}&filter_words=${filter_words}&video=${video}&app_info=${app}&use_media_video_player=${use_media_video_player}&source=${source}&title=${title}&image_mode=${image_mode}&landing_page_conf=${landing_page_conf}&image=${image}&landing_scroll_percentage=${landing_scroll_percentage}&sdk_derive_info=${sdk_derive_info}&dynamic_join_type=${dynamic_join_type}&audio=${audio}&disable_video_join=${disable_video_join}&disable_top_bar=${disable_top_bar}&disable_rtn_button=${disable_rtn_button}&disable_safe_area=${disable_safe_area}&gnd_prefetch_timing=${gnd_prefetch_timing}&gnd_prefetch_cache_key=${gnd_prefetch_cache_key}&direct_landing_page_info=${direct_landing_page_info}&reward_browse_type=${reward_browse_type}&voice_control=${voice_control}\",\"params\":{},\"next\":[{\"condition\":\"${if_both_open==1&&(is_video_lp!=true||app.appleid==null||app.appleid=='0')}\",\"name\":\"download\"}],\"callback\":{\"success\":[],\"fail\":[]}},{\"name\":\"open_scheme\",\"scheme\":\"uchain://open_scheme?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&interaction_type=${interaction_type}&deep_link=${deep_link}&ulink=${ulink}&ulink_priority=${ulink_priority}&sub_convert_link=${sub_convert_link}&app_info=${app}&block_auto_open=${block_auto_open}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==1)||(deep_link==null&&(interaction_type==3||ext.interaction_type==3))}\",\"name\":\"open_landing_page\"},{\"condition\":\"${(deep_link!=null&&deep_link.fallback_type==2)||(deep_link==null&&(interaction_type==4||ext.interaction_type==4))}\",\"name\":\"download\"}]}},{\"name\":\"download\",\"scheme\":\"uchain://download?ad_id=${ad_id}&ad_info=${ad_info}&log_extra=${ext}&app_info=${app}&download_conf=${download_conf}&appstore_jump_type=${appstore_jump_type}&market_url=${market_url}&download_sdk_conf=${download_sdk_conf}&icon=${icon}&interaction_type=${interaction_type}&skan=${skan}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[{\"condition\":\"${if_both_open==0}\",\"name\":\"open_landing_page\"}]}}]},\"ugen_view_visibility_tracker\":{\"main\":\"report_event\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"report_event\",\"scheme\":\"uchain://report_event?label=ugen_view_visibility&ad_id=${ad_id}&log_extra=${ext}&ugen_id=${ugen_event_params.ugen_id}&visibility=${ugen_event_params.visibility}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_rate\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=rate&identifier=${ad_info}&rate=1.0\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_pause\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=pause&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_play\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=play&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"video_replay\":{\"main\":\"video\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"video\",\"scheme\":\"uchain://video?action=replay&identifier=${ad_info}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"openPolicy\":{\"main\":\"open_policy\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"open_policy\",\"scheme\":\"uchain://open_policy?ad_info=${ad_info}&adx_name=${adx_name}&filter_words=${filter_words}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"continue_watch\":{\"main\":\"reward_continue\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_continue\",\"scheme\":\"uchain://reward_continue\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"exit_watch\":{\"main\":\"close_reward\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"close_reward\",\"scheme\":\"uchain://close_reward\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]},\"reward_again\":{\"main\":\"reward_again\",\"lazyLoad\":\"0\",\"events\":[{\"name\":\"reward_again\",\"scheme\":\"uchain://reward_again?pression_sessions=${play_again.pression_sessions}&play_again_rit=${play_again.play_again_rit}&log_extra=${ext}\",\"params\":{},\"next\":[],\"callback\":{\"success\":[],\"fail\":[]}}]}}}");
        } catch (Exception unused) {
            return null;
        }
    }
}
