package com.ss.android.downloadlib.addownload.ox;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.downloadlib.utils.x;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceCallback;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
public class mb implements IDownloadDiskSpaceHandler {
    private int mb;

    private long ox(DownloadSetting downloadSetting) {
        long jOptLong = downloadSetting.optLong("clear_space_sleep_time", 0L);
        if (jOptLong <= 0) {
            return 0L;
        }
        long j2 = jOptLong <= 5000 ? jOptLong : 5000L;
        x.ox("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + j2, null);
        try {
            Thread.sleep(j2);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        x.ox("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return j2;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceHandler
    public boolean cleanUpDisk(long j2, long j3, IDownloadDiskSpaceCallback iDownloadDiskSpaceCallback) throws Throwable {
        long j4;
        DownloadSetting downloadSettingObtain = DownloadSetting.obtain(this.mb);
        if (!mb(downloadSettingObtain)) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        hj.mb().b();
        long jMb = jb.mb(0L);
        mb();
        long jMb2 = jb.mb(0L);
        long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
        if (jMb2 < j3) {
            long jOx = ox(downloadSettingObtain);
            if (jOx > 0) {
                j4 = jOx;
                jMb2 = jb.mb(0L);
            } else {
                j4 = jOx;
            }
        } else {
            j4 = 0;
        }
        x.ox("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j3 + ", byteAvailableAfter = " + jMb2 + ", cleaned = " + (jMb2 - jMb), null);
        long j5 = jMb2;
        mb(jMb, jMb2, j3, jCurrentTimeMillis2, j4);
        if (j5 < j3) {
            return false;
        }
        if (iDownloadDiskSpaceCallback == null) {
            return true;
        }
        iDownloadDiskSpaceCallback.onDiskCleaned();
        return true;
    }

    public void mb(int i2) {
        this.mb = i2;
    }

    private boolean mb(DownloadSetting downloadSetting) {
        if (downloadSetting.optInt("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - hj.mb().ox() >= downloadSetting.optLong("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
    }

    private void mb() throws Throwable {
        com.ss.android.download.api.config.h hVarLc = com.ss.android.downloadlib.addownload.x.lc();
        if (hVarLc != null) {
            hVarLc.mb();
        }
        b.mb();
        b.ox();
    }

    private void mb(long j2, long j3, long j4, long j5, long j6) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.x.getContext()).getDownloadInfo(this.mb);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.mb.mb().mb(downloadInfo, j2, j3, j4, j5, j6, j3 > j4);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
