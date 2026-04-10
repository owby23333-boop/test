package com.ss.android.downloadlib.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.pangle.PangleAdapterUtils;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hj {
    public static int b(@NonNull DownloadModel downloadModel) {
        return mb(ox(downloadModel));
    }

    public static boolean h(int i2) {
        return DownloadSetting.obtain(i2).optLong("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean hj(int i2) {
        return DownloadSetting.obtain(i2).optLong("clean_fetch_apk_switch", 0L) == 1;
    }

    public static boolean ko(int i2) {
        return DownloadSetting.obtain(i2).optInt("clean_app_cache_dir", 0) == 1;
    }

    @Nullable
    public static JSONObject mb() {
        return com.ss.android.downloadlib.addownload.x.lz().optJSONObject("ad");
    }

    @NonNull
    public static DownloadSetting ox(DownloadModel downloadModel) {
        return DownloadSetting.obtain(mb(downloadModel));
    }

    public static boolean u(int i2) {
        return DownloadSetting.obtain(i2).optInt("clean_space_switch", 0) == 1;
    }

    public static long h() {
        long jOptLong = com.ss.android.downloadlib.addownload.x.lz().optLong("next_install_min_interval");
        if (jOptLong == 0) {
            return 10000L;
        }
        return jOptLong;
    }

    public static long hj() {
        long jOptLong = com.ss.android.downloadlib.addownload.x.lz().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static JSONObject mb(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? mb() : downloadModel.getDownloadSettings();
    }

    public static boolean ox(com.ss.android.downloadad.api.mb.mb mbVar) {
        return mb(mbVar).optInt("pause_reserve_on_wifi", 0) == 1 && mbVar.e();
    }

    public static long b(int i2) {
        return DownloadSetting.obtain(i2).optLong("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean b() {
        return com.ss.android.downloadlib.addownload.x.lz().optInt("is_enable_start_install_again") == 1;
    }

    public static long ox(int i2) {
        return DownloadSetting.obtain(i2).optLong("storage_min_size", 0L);
    }

    @NonNull
    public static DownloadSetting mb(com.ss.android.downloadad.api.mb.mb mbVar) {
        if (mbVar == null) {
            return DownloadSetting.obtainGlobal();
        }
        if (mbVar.m() != 0) {
            return DownloadSetting.obtain(mbVar.m());
        }
        if (mbVar.b()) {
            return DownloadSetting.obtain(mb());
        }
        if (mbVar.l() != null) {
            return DownloadSetting.obtain(mbVar.l());
        }
        return DownloadSetting.obtainGlobal();
    }

    public static boolean ox(DownloadSetting downloadSetting) {
        return downloadSetting != null && downloadSetting.optInt("kllk_need_rename_apk", 0) == 1;
    }

    public static boolean ox() {
        return DownloadSetting.obtainGlobal().optBugFix("fix_notification_anr");
    }

    public static int mb(@NonNull DownloadSetting downloadSetting) {
        return downloadSetting.optInt("external_storage_permission_path_type", 0);
    }

    public static double mb(int i2) {
        return DownloadSetting.obtain(i2).optDouble("clean_min_install_size", PangleAdapterUtils.CPM_DEFLAUT_VALUE);
    }
}
