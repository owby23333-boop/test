package com.ss.android.downloadlib;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.e;
import com.ss.android.download.api.config.g;
import com.ss.android.download.api.config.je;
import com.ss.android.download.api.config.lz;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.appdownloader.DownloadHandlerService;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.depend.INotificationClickCallback;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.DownloaderBuilder;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;

/* JADX INFO: loaded from: classes3.dex */
class h implements com.ss.android.download.api.mb {
    h() {
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(@NonNull lz lzVar) {
        x.mb(lzVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(@NonNull com.ss.android.download.api.config.ko koVar) {
        x.mb(koVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(@NonNull je jeVar) {
        x.mb(jeVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(@NonNull com.ss.android.download.api.config.ww wwVar) {
        x.mb(wwVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(@NonNull com.ss.android.download.api.config.x xVar) {
        x.mb(xVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(@NonNull com.ss.android.download.api.model.mb mbVar) {
        x.mb(mbVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(String str) {
        x.mb(str);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(@NonNull final com.ss.android.download.api.config.ox oxVar) {
        x.mb(oxVar);
        AppStatusManager.getInstance().setInnerAppStatusChangeCaller(new AppStatusManager.InnerAppStatusChangeCaller() { // from class: com.ss.android.downloadlib.h.1
            @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.InnerAppStatusChangeCaller
            public boolean isAppInBackground() {
                return oxVar.mb();
            }
        });
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder.getNotificationClickCallback() == null) {
            downloaderBuilder.notificationClickCallback(new INotificationClickCallback() { // from class: com.ss.android.downloadlib.h.2
                private boolean mb(DownloadInfo downloadInfo) {
                    g gVarL = x.l();
                    if (gVarL == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
                    String strMb = (oxVarMb == null || !oxVarMb.b()) ? com.ss.android.downloadlib.addownload.ww.mb(downloadInfo) : DownloadSetting.obtain(downloadInfo.getId()).optString("ad_notification_jump_url", null);
                    if (TextUtils.isEmpty(strMb)) {
                        return false;
                    }
                    return gVarL.mb(x.getContext(), strMb);
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenInstalled(DownloadInfo downloadInfo) {
                    if (downloadInfo == null) {
                        return false;
                    }
                    com.ss.android.downloadad.api.mb.ox oxVarMb = com.ss.android.downloadlib.addownload.model.u.mb().mb(downloadInfo);
                    if (oxVarMb != null) {
                        com.ss.android.downloadlib.ox.mb.mb(oxVarMb);
                    } else {
                        com.ss.android.downloadlib.utils.ww.ox(x.getContext(), downloadInfo.getPackageName());
                    }
                    DownloadNotificationManager.getInstance().cancelNotification(downloadInfo.getId());
                    return true;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenSuccess(DownloadInfo downloadInfo) {
                    return false;
                }

                @Override // com.ss.android.socialbase.downloader.depend.INotificationClickCallback
                public boolean onClickWhenUnSuccess(DownloadInfo downloadInfo) {
                    DownloadSetting downloadSettingObtain = DownloadSetting.obtain(downloadInfo.getId());
                    if (downloadSettingObtain.optInt("notification_opt_2") != 1) {
                        boolean zMb = mb(downloadInfo);
                        if (downloadSettingObtain.optInt("disable_delete_dialog", 0) == 1) {
                            return true;
                        }
                        return zMb;
                    }
                    if (downloadInfo.getStatus() == -2) {
                        DownloadHandlerService.mb(x.getContext(), downloadInfo, com.ss.android.socialbase.appdownloader.hj.x().ox(), Downloader.getInstance(x.getContext()).getDownloadNotificationEventListener(downloadInfo.getId()));
                    }
                    return true;
                }
            });
        }
        downloaderBuilder.addDownloadCompleteHandler(new com.ss.android.downloadlib.b.b());
        Downloader.initOrCover(downloaderBuilder, true);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public com.ss.android.download.api.mb mb(e eVar) {
        x.mb(eVar);
        return this;
    }

    @Override // com.ss.android.download.api.mb
    public void mb() {
        if (!x.df()) {
            com.ss.android.downloadlib.exception.b.mb().mb("ttdownloader init error");
        }
        x.mb(com.ss.android.downloadlib.exception.b.mb());
        try {
            com.ss.android.socialbase.appdownloader.hj.x().ox(x.g());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.ss.android.socialbase.appdownloader.hj.x().mb(mb.mb());
        hj.mb().ox(new Runnable() { // from class: com.ss.android.downloadlib.h.3
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.u.hj.mb("");
                if (com.ss.android.socialbase.appdownloader.u.hj.o()) {
                    DownloadComponentManager.setNotAutoRebootService(true);
                }
                if (DownloadSetting.obtainGlobal().optInt("disable_security_init", 1) == 1) {
                    com.ss.android.socialbase.appdownloader.u.h.mb(x.getContext());
                }
            }
        });
    }
}
