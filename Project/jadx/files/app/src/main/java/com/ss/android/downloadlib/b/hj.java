package com.ss.android.downloadlib.b;

import androidx.annotation.WorkerThread;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class hj implements com.ss.android.socialbase.appdownloader.b.ko, IDownloadCacheSyncStatusListener {
    @Override // com.ss.android.socialbase.appdownloader.b.ko
    public void mb(DownloadInfo downloadInfo, boolean z2) {
        if (downloadInfo == null) {
            return;
        }
        mb(downloadInfo, downloadInfo.getRealStatus(), z2);
    }

    @Override // com.ss.android.socialbase.appdownloader.b.ko
    public void mb(List<DownloadInfo> list) {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onStart() {
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCacheSyncStatusListener
    public void onSuccess() {
        com.ss.android.downloadlib.hj.mb().mb(new Runnable() { // from class: com.ss.android.downloadlib.b.hj.1
            @Override // java.lang.Runnable
            public void run() {
                DownloadInfo downloadInfo;
                int spIntVal;
                com.ss.android.downloadlib.addownload.model.u.mb().ox();
                for (com.ss.android.downloadad.api.mb.ox oxVar : com.ss.android.downloadlib.addownload.model.u.mb().b().values()) {
                    int iM = oxVar.m();
                    if (iM != 0) {
                        DownloadSetting downloadSettingObtain = DownloadSetting.obtain(iM);
                        if (downloadSettingObtain.optInt("notification_opt_2") == 1 && (downloadInfo = Downloader.getInstance(x.getContext()).getDownloadInfo(iM)) != null) {
                            if (jb.ox(oxVar) && !jb.b(oxVar.h())) {
                                int spIntVal2 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT);
                                if (spIntVal2 < downloadSettingObtain.optInt("noti_open_restart_times", 1)) {
                                    ww.mb().h(oxVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_OPEN_APP_COUNT, String.valueOf(spIntVal2 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -2) {
                                int spIntVal3 = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT);
                                if (spIntVal3 < downloadSettingObtain.optInt("noti_continue_restart_times", 1)) {
                                    ww.mb().mb(oxVar);
                                    downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_CONTINUE_COUNT, String.valueOf(spIntVal3 + 1));
                                }
                            } else if (downloadInfo.getRealStatus() == -3 && DownloadUtils.isFileDownloaded(downloadInfo) && !jb.ox(oxVar) && (spIntVal = downloadInfo.getSpIntVal(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT)) < downloadSettingObtain.optInt("noti_install_restart_times", 1)) {
                                ww.mb().b(oxVar);
                                downloadInfo.setSpValue(SpJsonConstants.RESTART_NOTIFY_INSTALL_COUNT, String.valueOf(spIntVal + 1));
                            }
                        }
                    }
                }
            }
        }, 5000L);
    }

    @WorkerThread
    public void mb(DownloadInfo downloadInfo, int i2, boolean z2) {
        com.ss.android.downloadlib.addownload.model.u.mb().ox();
        com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        if (oxVarMb == null) {
            return;
        }
        try {
            if (z2) {
                oxVarMb.b(downloadInfo.getFailedResumeCount());
            } else if (oxVarMb.nf() == -1) {
                return;
            } else {
                oxVarMb.b(-1);
            }
            com.ss.android.downloadlib.addownload.model.ww.mb().mb(oxVarMb);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ID, downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
            jSONObject.put("url", downloadInfo.getUrl());
            jSONObject.put("download_time", downloadInfo.getDownloadTime());
            jSONObject.put("download_status", i2);
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            int i3 = 1;
            jSONObject.put(MonitorConstants.EXTRA_DOWNLOAD_ONLY_WIFI, downloadInfo.isOnlyWifi() ? 1 : 0);
            jSONObject.put("chunk_count", downloadInfo.getChunkCount());
            if (!z2) {
                i3 = 2;
            }
            jSONObject.put(EventConstants.ExtraJson.KEY_LAUNCH_RESUMED, i3);
            jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
            AdEventHandler.mb().mb(EventConstants.Tag.EMBEDED_AD, EventConstants.Label.DOWNLOAD_UNCOMPLETED, jSONObject, oxVarMb);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
