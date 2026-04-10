package com.ss.android.downloadlib;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.downloadlib.event.AdEventHandler;
import com.ss.android.downloadlib.utils.jb;
import com.ss.android.downloadlib.utils.x;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class b implements com.ss.android.socialbase.appdownloader.b.ww {
    private static String mb = "b";
    private Handler ox = new Handler(Looper.getMainLooper());

    private void mb(@NonNull DownloadInfo downloadInfo) {
        if (com.ss.android.downloadlib.utils.hj.u(downloadInfo.getId())) {
            hj.mb().ox(new com.ss.android.downloadlib.addownload.ox.ox(downloadInfo));
        }
    }

    private void mb(final DownloadInfo downloadInfo, final com.ss.android.downloadad.api.mb.ox oxVar) {
        final long jMb = jb.mb(Environment.getDataDirectory(), -1L);
        long jMin = Math.min(524288000L, jb.mb(Environment.getDataDirectory()) / 10);
        final long totalBytes = downloadInfo.getTotalBytes();
        double d2 = jMin;
        double d3 = totalBytes;
        Double.isNaN(d3);
        Double.isNaN(d2);
        final double d4 = (d3 * 2.5d) + d2;
        if (jMb > -1 && totalBytes > -1) {
            double d5 = jMb;
            if (d5 < d4) {
                Double.isNaN(d5);
                if (d4 - d5 > com.ss.android.downloadlib.addownload.hj.ox()) {
                    com.ss.android.downloadlib.addownload.hj.mb(downloadInfo.getId());
                }
            }
        }
        AppStatusManager.getInstance().registerAppSwitchListener(new AppStatusManager.AppStatusChangeListener() { // from class: com.ss.android.downloadlib.b.3
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppBackground() {
            }

            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
            public void onAppForeground() {
                if (jb.ox(oxVar)) {
                    AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                    return;
                }
                long j2 = jMb;
                if (j2 <= -1 || totalBytes <= -1 || j2 >= d4) {
                    return;
                }
                AdEventHandler.mb().mb(EventConstants.UnityLabel.CLEAN_SPACE_INSTALL, com.ss.android.downloadlib.addownload.hj.mb("install_no_enough_space"), oxVar);
                if (com.ss.android.downloadlib.addownload.hj.mb(downloadInfo, ((long) d4) - jMb)) {
                    AppStatusManager.getInstance().unregisterAppSwitchListener(this);
                    oxVar.ko(true);
                }
            }
        });
    }

    @Override // com.ss.android.socialbase.appdownloader.b.ww
    public void mb(DownloadInfo downloadInfo, BaseException baseException, int i2) {
        final DownloadModel downloadModelMb;
        if (downloadInfo == null) {
            return;
        }
        if (i2 == -1 && baseException != null) {
            JSONObject jSONObject = new JSONObject();
            com.ss.android.downloadlib.utils.h.b(downloadInfo, jSONObject);
            mb.mb(jSONObject, downloadInfo);
            x.mb(EventConstants.Label.DOWNLOAD_FAILED, jSONObject.toString());
        }
        com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
        if (oxVarMb == null) {
            return;
        }
        try {
            if (i2 != -1) {
                if (i2 == -3) {
                    mb.mb(downloadInfo, oxVarMb);
                    return;
                }
                if (i2 == 2001) {
                    mb.mb().mb(downloadInfo, oxVarMb, 2001);
                    return;
                } else {
                    if (i2 == 11) {
                        mb.mb().mb(downloadInfo, oxVarMb, 2000);
                        if (oxVarMb.fb()) {
                            return;
                        }
                        mb(downloadInfo, oxVarMb);
                        return;
                    }
                    return;
                }
            }
            BaseException baseException2 = null;
            if (baseException != null) {
                if (DownloadSetting.obtain(downloadInfo.getId()).optInt("toast_without_network", 0) == 1 && baseException.getErrorCode() == 1049) {
                    this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.x.b().mb(5, com.ss.android.downloadlib.addownload.x.getContext(), null, "无网络，请检查网络设置", null, 0);
                        }
                    });
                }
                if (DownloadUtils.isInsufficientSpaceError(baseException)) {
                    if (com.ss.android.downloadlib.addownload.x.je() != null) {
                        com.ss.android.downloadlib.addownload.x.je().mb(oxVarMb.ox());
                    }
                    AdEventHandler.mb().mb(EventConstants.UnityLabel.DOWNLOAD_FAILED_FOR_SPACE, oxVarMb);
                    if (!oxVarMb.i()) {
                        AdEventHandler.mb().mb(EventConstants.UnityLabel.DOWNLOAD_CAN_RESTART, oxVarMb);
                        mb(downloadInfo);
                    }
                    if ((com.ss.android.downloadlib.addownload.x.je() == null || !com.ss.android.downloadlib.addownload.x.je().hj()) && (downloadModelMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(oxVarMb.ox())) != null && downloadModelMb.isShowToast()) {
                        final DownloadSetting downloadSettingObtain = DownloadSetting.obtain(downloadInfo.getId());
                        if (downloadSettingObtain.optInt("show_no_enough_space_toast", 0) == 1) {
                            this.ox.post(new Runnable() { // from class: com.ss.android.downloadlib.b.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.ss.android.downloadlib.addownload.x.b().mb(2, com.ss.android.downloadlib.addownload.x.getContext(), downloadModelMb, downloadSettingObtain.optString("no_enough_space_toast_text", "您的存储空间不足，请清理后再试"), null, 0);
                                }
                            });
                        }
                    }
                }
                baseException2 = new BaseException(baseException.getErrorCode(), jb.mb(baseException.getMessage(), com.ss.android.downloadlib.addownload.x.lz().optInt(DownloadSettingKeys.KEY_EXCEPTION_MSG_LENGTH, 500)));
            }
            AdEventHandler.mb().ox(downloadInfo, baseException2);
            ko.mb().mb(downloadInfo, baseException, "");
        } catch (Exception e2) {
            com.ss.android.downloadlib.addownload.x.m().mb(e2, "onAppDownloadMonitorSend");
        }
    }
}
