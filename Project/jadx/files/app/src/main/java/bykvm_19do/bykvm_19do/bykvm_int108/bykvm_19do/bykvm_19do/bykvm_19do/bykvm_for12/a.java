package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final LinkedList<String> a;
    private static final LinkedList<String> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LinkedList<String> f1842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HashMap<String, Integer> f1843d;

    static {
        new LinkedList();
        a = new LinkedList<>();
        b = new LinkedList<>();
        f1842c = new LinkedList<>();
        new HashMap();
        f1843d = null;
    }

    private static String a() {
        String string;
        synchronized (a.class) {
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = f1842c.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            string = sb.toString();
        }
        return string;
    }

    public static String a(int i2) {
        switch (i2) {
            case 1:
                return "flush once";
            case 2:
                return "flush memory db";
            case 3:
                return "flush memory";
            case 4:
                return "new event";
            case 5:
                return "server busy";
            case 6:
                return "empty message";
            case 7:
                return "net error";
            default:
                return "default";
        }
    }

    public static void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, long j2) {
        if (j.l().b().e()) {
            long jCurrentTimeMillis = System.currentTimeMillis() - j2;
            c.a("uploadCost:" + jCurrentTimeMillis);
            if (i2 == 200) {
                d.f1895h.b0().getAndAdd(jCurrentTimeMillis);
                d.f1895h.M().incrementAndGet();
                d.f1895h.T().getAndAdd(list.size());
                d.f1895h.Q().getAndAdd(list.size());
                return;
            }
            c.b("-------AdThread code is " + i2 + " error  ------------");
            (i2 == -1 ? d.f1895h.S() : d.f1895h.R()).getAndAdd(list.size());
            d.f1895h.x().getAndAdd(jCurrentTimeMillis);
            d.f1895h.L().incrementAndGet();
        }
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        String string;
        try {
            if (aVar.b() == 0 && j.l().b() != null && j.l().b().f()) {
                JSONObject jSONObjectD = aVar.d();
                String strC = c(aVar);
                if (a(strC)) {
                    return;
                }
                e(aVar);
                String strOptString = jSONObjectD.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(strOptString)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("will_send_labels", d(strC + "_" + g(aVar)));
                    jSONObject.put("send_success_valid_labels", a());
                    string = jSONObject.toString();
                } else {
                    JSONObject jSONObject2 = new JSONObject(strOptString);
                    if (TextUtils.isEmpty(jSONObject2.optString("will_send_labels"))) {
                        jSONObject2.put("will_send_labels", d(strC + "_" + g(aVar)));
                        jSONObject2.put("send_success_valid_labels", a());
                    }
                    string = jSONObject2.toString();
                }
                jSONObjectD.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, string);
            }
        } catch (Exception e2) {
            c.b(e2.getMessage());
        }
    }

    private static void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, String str, g gVar) {
        String strC = c(aVar);
        if (a(strC)) {
            return;
        }
        String strE = e(aVar);
        if (aVar.b() == 0 && gVar.f()) {
            b(strC + "_" + g(aVar) + "_" + strE + "_" + str);
        }
    }

    public static void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, int i2) {
        try {
            if (j.l().b().e()) {
                for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
                    if (aVar != null && aVar.h() != 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jH = aVar.h();
                        d.f1895h.g0().incrementAndGet();
                        d.f1895h.P().getAndAdd(jCurrentTimeMillis - jH);
                        aVar.a(System.currentTimeMillis());
                    }
                    if (aVar != null) {
                        a(aVar);
                    }
                }
                d.f1895h.t().getAndAdd(list.size());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, int i2, String str) {
        StringBuilder sb;
        String str2;
        g gVarB = j.l().b();
        if (gVarB == null || !gVarB.c() || list == null || d()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
            if (aVar.b() == 0) {
                JSONObject jSONObjectD = aVar.d();
                String strC = c(aVar);
                if (aVar.c() == 3) {
                    if (jSONObjectD != null) {
                        strC = jSONObjectD.optString("event");
                    }
                    sb2.append(" [v3:");
                    sb2.append(strC);
                } else {
                    long jF = f(aVar);
                    long jG = g(aVar);
                    int iD = d(aVar);
                    sb2.append(" [");
                    sb2.append(jF);
                    sb2.append("_");
                    sb2.append(strC);
                    if (jG != 0) {
                        sb2.append("_");
                        sb2.append(jG);
                    }
                    if (iD != 0) {
                        sb2.append("_");
                        sb2.append(iD);
                    }
                }
                sb2.append("] ");
                z2 = true;
            } else if (aVar.b() == 1) {
                String strJ = j(aVar);
                int i3 = i(aVar);
                sb2.append(" [");
                sb2.append(i3);
                sb2.append("_");
                sb2.append(strJ);
                sb2.append("] ");
            }
        }
        if (z2) {
            sb = new StringBuilder();
            str2 = "ads:";
        } else {
            sb = new StringBuilder();
            str2 = "stats:";
        }
        sb.append(str2);
        sb.append((Object) sb2);
        sb.append(a(i2));
        sb.append(",");
        sb.append(str);
        sb.append(",total:");
        sb.append(list.size());
        c.c("_upload", sb.toString());
    }

    public static void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, String str) {
        try {
            g gVarB = j.l().b();
            if (gVarB == null || !gVarB.e() || list == null) {
                return;
            }
            for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
                if (aVar != null) {
                    a(aVar, str, gVarB);
                }
            }
        } catch (Exception e2) {
            c.b(e2.getMessage());
        }
    }

    public static void a(JSONObject jSONObject, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a aVar) {
        g gVarB = j.l().b();
        if (gVarB != null && gVarB.c() && c()) {
            c.a("log_show_query :" + jSONObject.optString("label") + " " + ((int) aVar.e()));
        }
    }

    public static void a(boolean z2, int i2, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        g gVarB = j.l().b();
        if (d() || gVarB == null || !gVarB.c()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("needUpload:");
        sb.append(z2);
        sb.append(",message:");
        sb.append(a(i2));
        String strJ = j(aVar);
        if (!TextUtils.isEmpty(strJ)) {
            sb.append(",type:");
            sb.append(strJ);
        }
        String strC = c(aVar);
        if (!TextUtils.isEmpty(strC)) {
            sb.append(",label:");
            sb.append(strC);
        }
        c.c("_save", sb.toString());
    }

    public static boolean a(String str) {
        HashMap<String, Integer> map = f1843d;
        if (map == null || str == null) {
            return false;
        }
        return map.containsKey(str);
    }

    public static void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        String strC;
        String string;
        try {
            if (b()) {
                g gVarB = j.l().b();
                if (!TextUtils.isEmpty(aVar.i())) {
                    b.a(d.f1895h.a0(), 1);
                }
                if (gVarB == null || !gVarB.c()) {
                    return;
                }
                if (aVar.b() == 1) {
                    string = "stats,[type:" + j(aVar) + ",index:" + i(aVar) + ",localId:" + aVar.i() + ",sessionId:" + h(aVar) + "]";
                } else {
                    if (aVar.b() != 0) {
                        return;
                    }
                    if (aVar.c() != 3) {
                        StringBuilder sb = new StringBuilder();
                        long jG = g(aVar);
                        if (jG != 0) {
                            sb.append("v1_core [");
                            sb.append("label:");
                            strC = c(aVar);
                        } else {
                            sb.append("v1_debug [");
                            sb.append("label:");
                            strC = c(aVar);
                        }
                        sb.append(strC);
                        long jF = f(aVar);
                        if (jF != 0) {
                            sb.append(", index:");
                            sb.append(jF);
                        }
                        if (jG != 0) {
                            sb.append(", validIndex:");
                            sb.append(jG);
                        }
                        sb.append(", localId:");
                        sb.append(aVar.i());
                        sb.append(", sessionId:");
                        sb.append(h(aVar));
                        sb.append("]");
                        string = sb.toString();
                    } else if (aVar.d() != null) {
                        String strOptString = aVar.d().optString("event");
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("v3,[");
                        sb2.append("label:");
                        sb2.append(strOptString);
                        long jF2 = f(aVar);
                        if (jF2 != 0) {
                            sb2.append(", index:");
                            sb2.append(jF2);
                        }
                        long jG2 = g(aVar);
                        if (jG2 != 0) {
                            sb2.append(", validIndex:");
                            sb2.append(jG2);
                        }
                        sb2.append(", localId:");
                        sb2.append(aVar.i());
                        sb2.append(", sessionId:");
                        sb2.append(h(aVar));
                        sb2.append("]");
                        string = sb2.toString();
                    } else {
                        string = "v3_error";
                    }
                }
                c.c("_delete", string);
            }
        } catch (Exception e2) {
            c.b(e2.getMessage());
        }
    }

    private static void b(String str) {
        LinkedList<String> linkedList;
        synchronized (a.class) {
            if (f1842c.size() >= 10) {
                f1842c.removeFirst();
                linkedList = f1842c;
            } else {
                linkedList = f1842c;
            }
            linkedList.add(str);
        }
    }

    private static boolean b() {
        g gVarB = j.l().b();
        return gVarB != null && gVarB.d() == 0;
    }

    public static String c(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null || aVar.d() == null || d()) {
            return null;
        }
        return aVar.d().optString(aVar.c() == 3 ? "event" : "label");
    }

    private static String c(String str) {
        LinkedList<String> linkedList;
        String string;
        synchronized (a.class) {
            if (a.size() >= 10) {
                a.removeFirst();
                linkedList = a;
            } else {
                linkedList = a;
            }
            linkedList.add(str);
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            string = sb.toString();
        }
        return string;
    }

    public static boolean c() {
        return b() || e();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a r2) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a> r0 = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.class
            monitor-enter(r0)
            if (r2 == 0) goto L30
            org.json.JSONObject r1 = r2.d()     // Catch: java.lang.Throwable -> L2d
            if (r1 != 0) goto Lc
            goto L30
        Lc:
            boolean r1 = b()     // Catch: java.lang.Throwable -> L2d
            if (r1 == 0) goto L30
            org.json.JSONObject r2 = r2.d()     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L2d
            java.lang.String r1 = "ad_extra_data"
            java.lang.String r2 = r2.optString(r1)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L2d
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L2d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L2d
            java.lang.String r2 = "sdk_event_self_count"
            int r2 = r1.optInt(r2)     // Catch: java.lang.Exception -> L28 java.lang.Throwable -> L2d
            goto L31
        L28:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L2d
            goto L30
        L2d:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        L30:
            r2 = 0
        L31:
            monitor-exit(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.d(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a):int");
    }

    private static String d(String str) {
        LinkedList<String> linkedList;
        String string;
        synchronized (a.class) {
            if (b.size() >= 10) {
                b.removeFirst();
                linkedList = b;
            } else {
                linkedList = b;
            }
            linkedList.add(str);
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = b.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(",");
            }
            string = sb.toString();
        }
        return string;
    }

    public static boolean d() {
        g gVarB = j.l().b();
        return gVarB != null && gVarB.d() == 2;
    }

    public static String e(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && !d()) {
            String strOptString = aVar.d().optString("log_extra");
            if (!TextUtils.isEmpty(strOptString)) {
                try {
                    return new JSONObject(strOptString).optString("req_id");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    private static boolean e() {
        g gVarB = j.l().b();
        return gVarB != null && gVarB.d() == 1;
    }

    public static long f(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optLong("sdk_event_index");
            } catch (Exception e2) {
                c.b(e2.getMessage());
            }
        }
        return 0L;
    }

    public static void f() {
        if (f1843d != null) {
            return;
        }
        String[] strArr = {"first_view", "open_splash", "ad_landing_webview_init", "show_failed_topview", "adstyle_template_show", "splash_init_monitor_first", "download_video_succeed", "shake_skip", "receive", "video_over_auto", "render_time", "splash_ad", "preload_start", "mute", "covered", "download_image_failed", "splash_init_monitor_all", "preload_success_time", "download_video_start_sdk", "download_video_count", "not_showing_reason", "download_image_succeed", "load_video_success", "launch_covered", "download_video_prepare", "download_video_start", "boarding", "ad_wap_stat", "splash_pick", "preload_fail", "should_show", "adstyle_template_fill", com.anythink.expressad.foundation.d.c.bZ, "preload_success", "show_failed", "stop_showing_monitor", "download_video_no_download", "track_url", "download_creative_duration", "adstyle_template_render", "download_video_count_splash_sdk", "landing_preload_finish", "adstyle_template_load", "load_ad_duration", "client_false_show", "client_false", "download_video_failed", "data_invalid", "topview_boarding", "topview_start_download", "topview_show_confirmed", "splash_start_download", "topview_show_rejected", "splash_no_download", "redownload_video_count", "topview_other_show", "topview_no_download", "ad_selected", "invalid_model", "topview_deliver", "ad_no_selected", "topview_ad_download_retry_label", TTLogUtil.TAG_EVENT_REQUEST, "response", "parse_finished", "front_performance", "ad_resp", "ad_resp_nodata", "preload_finish", "transit_show", "splash_switch", "block_splash_F2", "render_picture_time", "network_type", "play_start_error", "load_video_error", "render_picture_timeout", "py_loading_success", "download_status", "first_screen_load_finish", "landing_preload_failed", "data_received", "preload_result", "show_result", "reponse", "valid_time", "brand_satefy_context", "topview_ad_link_fail_label", "end_feed_request", "start_feed_request", "set_feed_data", EventConstants.Label.DELAY_INSTALL_CONFLICT, "clean_fetch_apk_head_failed", EventConstants.UnityLabel.DOWNLOAD_AFTER_QUITE_CLEAN, "fps_too_low", "open_policy", "landing_perf_stats", "preload_topview", "show_effect_start", "dislike_monitor", "hour_show", "hour_skip", "triggered", "click_sound_switch", "enter_loft", EventConstants.Label.DOWNLOAD_RESUME, MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, "contiguous_ad_event", "contiguous_ad_remove_event", "report_monitor", "open_landing_blank", "dynamic_ad", "report_load_failed", "ad_download_failed", "download_video_start_first_sdk", "splash_receive", "video_play", "clean_fetch_apk_head_switch_close", EventConstants.UnityLabel.LABEL_EXTERNAL_PERMISSION, EventConstants.UnityLabel.PAUSE_RESERVE_WIFI_SWITCH_STATUS, EventConstants.Label.LP_DOWNLOAD_DIALOG_SHOW, MonitorConstants.DOWNLOAD_CONNECT, EventConstants.Label.DOWNLOAD_UNCOMPLETED, EventConstants.Label.PAUSE_RESERVE_WIFI_DIALOG_SHOW, MonitorConstants.DOWNLOAD_IO, EventConstants.Label.PAUSE_RESERVE_WIFI_CONFIRM, "skvc_load_time", MonitorConstants.SEGMENT_IO, "click_no", EventConstants.Label.PAUSE_RESERVE_WIFI_CANCEL_ON_WIFI, "udp_stop", "mma_url", "error_save_sp", EventConstants.Label.NOTIFICATION_TRY_SHOW, EventConstants.UnityLabel.TTD_PREF_MONITOR, "item_above_the_fold_stay_time", EventConstants.Label.UNITY, "bdad_query_log", "bdad_load_finish", "bdad_load", "bdad_load_fail", "undefined", "valid_stock", "show_filter", "splash_pk_result", "endcard_page_info", "page_on_create", "statistics_feed_docker", "show_search_card_word", "ad_new_video_render_start_label", "ad_new_video_play_start_label", "ad_new_video_ad_patch_data_set_null_label", "ad_new_video_ad_patch_play_label", "ad_new_video_ad_patch_render_label", "debug_touch_start", "try_second_request", "egg_unzip_success", "tap_2", "anti_0_result", "anti_2_result", "egg_unzip_no_start", "preload_no_start", "bind_impression_212202", MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, "show_im_entry", "sub_reco_impression_v2", "sync_request_log_mask", "no_send_sync_request", "load_timeout", "send_sync_request", "sync_request_not_show", "show_subv_tt_video_food", "track", "custom_event", "rd_landing_page_stat", "update_local_data", "showlimit", "upload_result", "debug_othershow", "debug_otherclick", "ad_show_time", "push_launch", "union_send_duplicate", "mnpl_js_finish_load", "mnpl_resource_finish_load", "mnpl_material_render_timeout", "mnpl_render_timing", "mnpl_vedio_interactive_timegap", "click_non_rectify_area", "start_impression", "end_impression", "picture_render_time", "splash_stop_show", "skip_post", "skan_show_start", "skan_show_end", "load_video_start", "rifle_ad_monitor", "download_video_redownload", "splash_video_quality", "splash_video_end", "splash_video_pause", "splash_video_failed", "adtrace_start_clear", "adtrace_clear_past_data", "adtrace_end_clear", "adtrace_write_success", "adtrace_write_failed", "adtrace_read_result", "adtrace_read_success", "adtrace_read_failed", "pick_model", "cache_model", "adtrace_reparse_file", "deeplink_failed_all", "ad_live_degenerate", "ad_live_miss", "live_play_fail", "sko_show_success", "sko_show_fail", "commerce_apps_open", "commerce_apps_jump", "pic_card_show", "live_ad_card_render_finish", "adtrace_select", "received_card_status", "live_ad_page_load_success", "mp_download_result", "download_video_cancel", "jump_count", "adtrace_try_show", "show_cart_entrance", "live_ad_page_load_fail", "click_interacted", "pop_up", "pop_up_cancel", "stream_loadtime", "mnpl_guide_comp_render", "thirdquartile", "customer_feed_pause", "customer_play_start", "customer_feed_break", "click_area_log", "customer_feed_continue", "customer_feed_play", "mnpl_resource_start_preload", "mnpl_resource_finish_preload", "customer_feed_over", "get_preload_ad", "web_inspect_status", "web_report_status", "preload_begin", "preload_end", "open_begin", "open_end", "pangle_live_sdk_monitor", "success", "rifle_load_state", "rifle_uri_load_state", "component_init", "component_release", "ad_lynx_download_sendAdLog", "dynamic2_render", "lynx_card_show", "pop_up_download", "live_shelf_commodity_show", "unity_fe_click", "enter_ads_explain", "adx_ads_switch", "personal_ads_switch", "qc_product_picture_cancel", "qc_product_picture_save", "qc_product_picture_press", "qc_product_detail_show", "qc_price_instruction_click", "qc_edit_sku_num_click", "service_description_page_duration", "enter_business_qualification_page ", "service_description_page_show", "order_words_fe", "qc_payment_mode_show", "qc_click_ali_pay", "qc_district_addr_click", "qc_auto_information_add", "qc_dial_consult_cancel_btn_click", "qc_dial_consult_show", "qc_maomadeng_click", "qc_maomadeng_show", "slide_product_big_picture", "qc_service_description_close", "appstore_manager_request", "preload_video_result", "preload_video_start", "adtrace_bind", "topview_ad_link_match_event", "skip_leisure_interact_render", "click_start_download", "ad_lynx_landing_page_exception", "lynx_page_res_download_monitor_event", "live_fail", "live_over", "render_live_picture_success", "render_live_picture_fail", "live_play_success", "live_play_close", "item_play_pver", "ad_gap_info", "item_play_over", "has_period_first_chance", "enter_live_auto", "mnpl_material_video_scene_show", "ad_rerank", "in_web_click", "post_request_failed", "destroy", "bidding_load", "bidding_receive", "in_web_scroll", "tobsdk_livesdk_live_show", "xigua_ad_rerank", "applink_unity", "top_ad_show", "top_button_show", "skip_button_show", "skip_click", "shake_show", "skip_result", "show_personal_compliance_button_click", "personal_compliance_click", "ad_click_result", "ad_preload_video", "popup_show", "topview_feed_down", "qr_scan", "qr_show", "topview_popup_show", "topview_feed_over", "topview_feed_show", "feed_down", "engine_ad_send", "permission_click", "policy_click", "download_start_click", "mini_playable_style_report", "load_detect", "aweme_show_info", "click_convert_anchor_detail_page", "click_anchor_gift_button", "show_anchor_gift_page", "click_anchor_gift_card", "show_anchor_gift_card", "anchor_convert_button", "show_anchor_page", "search_result_click", "sdk_session_launch", "not_use_app_link_sdk", "click_ios_check", "auto_open", "bind_click_area", "page_load", "show_finish", "next_fresh", "play_ready", "splash_pk_time", "unshow", "feed_show_failed", "othershow_cancel", "lu_cache", "realtime_splash_result", "channel_override_result", "internal_jump_live_status", "mnpl_video_play_backward", "splash_enter_foreground", "splash_enter_background", "button_light", "long_press", "webview_material_missing_key_error", "live_life_project_click_card", "mnpl_click_event", "show_anchor_convert_button", "bdar_log_info", "bdar_ad_request", "bdar_lynx_template_load_time", "bdar_lynx_fallback", "bdar_fetch_template_data", "bdar_lynx_render_time", "bdar_video_play_effective", "bdar_video_first_frame", "bdar_lynx_jsb_error", "invalidate_back_url_monitor_event", "lynx_page_plugin_exception_event", "live_custom_interaction", "pinch", "if_splash_card", "splash_card_show", "card_show_fail", "splash_card_click", "splash_card_close", "wind_icon_click", "excluded", "show_error", "toutiao_ad_receive", "show_ad", "toutiao_ad_excluded", "close_card", "lynx_status", "qpon_join", "apk_download_user", "comment_key_word_show", "v3_show_ad", "show_wish_button", "enterSection", "single_comment_show", "enter_product_detail", "xigua_ad_request", "qpon_apply", "splash_total_duration", "splash_render_duration", "download_template_duration", "homepage_hot", "homepage_follow", "homepage_fresh", "video_play_success", "general_search", "video_render_cost", "single_ad_render_cost", "unexpected_accurate_pause", "mnpl_interact_skip", "web_report_request_url", "web_report_init_status", "first_request", "video_ended", "mnpl_script_error", "open_wechat_failed_shake", "open_wechat_shacke", "open_wechat_success_shake", "options_popup", "close_pers_ads_type", "check_closed_type", "ad_guide_panel", "learn_ads", "learn_adx_ads", "learn_pers_ads", "resume_closed_type", "twist", "open_wechat_shake"};
        f1843d = new HashMap<>(strArr.length);
        for (String str : strArr) {
            f1843d.put(str, 1);
        }
    }

    public static long g(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optLong("sdk_event_valid_index");
            } catch (Exception e2) {
                c.b(e2.getMessage());
            }
        }
        return 0L;
    }

    private static String h(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString(aVar.b() == 1 ? "event_extra" : BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optString("sdk_session_id");
            } catch (JSONException e2) {
                c.b(e2.getMessage());
            }
        }
        return null;
    }

    public static int i(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString("event_extra")).optInt("stats_index");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static String j(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null || aVar.d() == null || d()) {
            return null;
        }
        return aVar.d().optString("type");
    }

    public static void k(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        String string;
        try {
            if (j.l().b().e()) {
                d.f1895h.b(System.currentTimeMillis() - aVar.a());
                aVar.b(System.currentTimeMillis());
                if (aVar.b() == 0 && j.l().b() != null && j.l().b().f()) {
                    String strC = c(aVar);
                    if (a(strC)) {
                        return;
                    }
                    JSONObject jSONObjectD = aVar.d();
                    String strOptString = aVar.d().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    if (TextUtils.isEmpty(strOptString)) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("save_success_labels", c(strC + "_" + g(aVar)));
                        string = jSONObject.toString();
                    } else {
                        JSONObject jSONObject2 = new JSONObject(strOptString);
                        if (TextUtils.isEmpty(jSONObject2.optString("save_success_labels"))) {
                            jSONObject2.put("save_success_labels", c(strC + "_" + g(aVar)));
                        }
                        string = jSONObject2.toString();
                    }
                    jSONObjectD.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, string);
                }
            }
        } catch (Exception unused) {
        }
    }
}
