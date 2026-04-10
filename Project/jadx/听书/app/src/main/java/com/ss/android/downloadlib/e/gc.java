package com.ss.android.downloadlib.e;

import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.umeng.analytics.pro.an;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class gc {
    public static JSONObject z() {
        return com.ss.android.downloadlib.addownload.wp.fo().optJSONObject(an.aw);
    }

    public static JSONObject z(com.ss.android.z.z.dl.dl dlVar) {
        if (dlVar == null) {
            return null;
        }
        return dlVar.io() ? i.z(com.ss.android.downloadlib.addownload.wp.fo(), dlVar.fv()) : dlVar.fv();
    }

    public static com.ss.android.socialbase.downloader.i.z g(com.ss.android.z.z.dl.dl dlVar) {
        return com.ss.android.socialbase.downloader.i.z.z(z(dlVar));
    }

    public static com.ss.android.socialbase.downloader.i.z z(com.ss.android.g.z.g.z zVar) {
        if (zVar == null) {
            return com.ss.android.socialbase.downloader.i.z.dl();
        }
        if (zVar.js() != 0) {
            return com.ss.android.socialbase.downloader.i.z.z(zVar.js());
        }
        if (zVar.dl()) {
            return com.ss.android.socialbase.downloader.i.z.z(z());
        }
        if (zVar.fv() != null) {
            return com.ss.android.socialbase.downloader.i.z.z(zVar.fv());
        }
        return com.ss.android.socialbase.downloader.i.z.dl();
    }

    public static int z(com.ss.android.socialbase.downloader.i.z zVar) {
        return zVar.z("external_storage_permission_path_type", 0);
    }

    public static int dl(com.ss.android.z.z.dl.dl dlVar) {
        return z(g(dlVar));
    }

    public static boolean g(com.ss.android.g.z.g.z zVar) {
        return z(zVar).z("pause_reserve_on_wifi", 0) == 1 && zVar.p();
    }

    public static boolean dl(com.ss.android.g.z.g.z zVar) {
        return z(zVar).z("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && zVar.p();
    }

    public static double z(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("clean_min_install_size", 0.0d);
    }

    public static long g(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("storage_min_size", 0L);
    }

    public static long dl(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean a(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean gc(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean m(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("clean_space_switch", 0) == 1;
    }

    public static boolean e(int i) {
        return com.ss.android.socialbase.downloader.i.z.z(i).z("clean_app_cache_dir", 0) == 1;
    }

    public static boolean g(com.ss.android.socialbase.downloader.i.z zVar) {
        return zVar != null && zVar.z("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean g() {
        return com.ss.android.socialbase.downloader.i.z.dl().z("fix_notification_anr");
    }

    public static boolean dl() {
        return com.ss.android.downloadlib.addownload.wp.fo().optInt("is_enable_start_install_again") == 1;
    }

    public static long a() {
        long jOptLong = com.ss.android.downloadlib.addownload.wp.fo().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static long gc() {
        long jOptLong = com.ss.android.downloadlib.addownload.wp.fo().optLong("next_install_min_interval");
        return jOptLong == 0 ? ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT : jOptLong;
    }

    public static int z(com.ss.android.g.z.g.g gVar) {
        return z((com.ss.android.g.z.g.z) gVar).z("ttdownloader_app_install_detect_count", 15);
    }

    public static int g(com.ss.android.g.z.g.g gVar) {
        return z((com.ss.android.g.z.g.z) gVar).z("ttdownloader_app_install_detect_interval_ms", 20000);
    }

    public static boolean dl(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.addownload.wp.fo().optInt("market_install_finish_opt_switch", 0) == 1 || z((com.ss.android.g.z.g.z) gVar).z("market_install_finish_opt_switch", 0) == 1;
    }

    public static boolean a(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.addownload.wp.fo().optInt("market_install_finish_opt_broadcast", 0) == 1 || z((com.ss.android.g.z.g.z) gVar).z("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean gc(com.ss.android.g.z.g.g gVar) {
        return com.ss.android.downloadlib.addownload.wp.fo().optInt("market_install_finish_opt_polling_thread", 0) == 1 || z((com.ss.android.g.z.g.z) gVar).z("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static int m(com.ss.android.g.z.g.g gVar) {
        return z((com.ss.android.g.z.g.z) gVar).z("app_install_keep_receiver_time_s", 60);
    }

    public static long e(com.ss.android.g.z.g.g gVar) {
        return z((com.ss.android.g.z.g.z) gVar).z("ttdownloader_app_install_detect_sum_timestamp", TTAdConstant.AD_MAX_EVENT_TIME);
    }
}
