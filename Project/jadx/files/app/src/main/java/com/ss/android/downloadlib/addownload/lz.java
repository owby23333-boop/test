package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
public class lz {
    public static int mb(int i2, int i3) {
        return (i3 <= 0 || i3 >= 100 || !mb(i2)) ? i3 : (int) (Math.sqrt(i3) * 10.0d);
    }

    public static long mb(int i2, long j2, long j3) {
        if (!mb(i2)) {
            return j2;
        }
        if (j2 <= 0) {
            return 0L;
        }
        return j3 <= 0 ? j2 : (j3 * ((long) mb(i2, (int) ((j2 * 100) / j3)))) / 100;
    }

    public static DownloadShortInfo mb(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && mb((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = mb((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean mb(int i2) {
        return DownloadSetting.obtain(i2).optInt("pause_optimise_pretend_download_percent_switch", 0) == 1 && DownloadSetting.obtain(i2).optInt("pause_optimise_switch", 0) == 1;
    }
}
