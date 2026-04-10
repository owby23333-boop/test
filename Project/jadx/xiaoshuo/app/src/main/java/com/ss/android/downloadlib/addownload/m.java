package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.model.DownloadShortInfo;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    public static int e(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !e(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    public static long e(int i, long j, long j2) {
        if (!e(i)) {
            return j;
        }
        if (j <= 0) {
            return 0L;
        }
        return j2 <= 0 ? j : (j2 * ((long) e(i, (int) ((j * 100) / j2)))) / 100;
    }

    public static DownloadShortInfo e(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && e((int) downloadShortInfo.id)) {
            downloadShortInfo.currentBytes = e((int) downloadShortInfo.id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    private static boolean e(int i) {
        return com.ss.android.socialbase.downloader.p.e.e(i).e("pause_optimise_pretend_download_percent_switch", 0) == 1 && com.ss.android.socialbase.downloader.p.e.e(i).e("pause_optimise_switch", 0) == 1;
    }
}
