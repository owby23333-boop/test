package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public class ox {
    public static void mb(DownloadInfo downloadInfo) {
        ox(downloadInfo);
    }

    private static void ox(final DownloadInfo downloadInfo) {
        final Context appContext = DownloadComponentManager.getAppContext();
        boolean z2 = true;
        if (((downloadInfo.isAutoResumed() && !downloadInfo.isShowNotificationForNetworkResumed()) || com.ss.android.socialbase.appdownloader.b.ox(downloadInfo.getExtra()) || TextUtils.isEmpty(downloadInfo.getMimeType()) || !downloadInfo.getMimeType().equals(AdBaseConstants.MIME_APK)) && DownloadSetting.obtain(downloadInfo.getId()).optInt("auto_install_when_resume", 0) != 1) {
            z2 = false;
        }
        final int iMb = z2 ? com.ss.android.socialbase.appdownloader.b.mb(appContext, downloadInfo.getId(), false) : 2;
        DownloadComponentManager.getCPUThreadExecutor().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.u.ox.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.appdownloader.b.hj hjVarOx = com.ss.android.socialbase.appdownloader.hj.x().ox();
                IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(appContext).getDownloadNotificationEventListener(downloadInfo.getId());
                if (hjVarOx == null && downloadNotificationEventListener == null) {
                    return;
                }
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.exists()) {
                    try {
                        PackageInfo packageInfoMb = com.ss.android.socialbase.appdownloader.b.mb(downloadInfo, file);
                        if (packageInfoMb != null) {
                            String packageName = (iMb == 1 || TextUtils.isEmpty(downloadInfo.getPackageName())) ? packageInfoMb.packageName : downloadInfo.getPackageName();
                            if (hjVarOx != null) {
                                hjVarOx.mb(downloadInfo.getId(), 1, packageName, -3, downloadInfo.getDownloadTime());
                            }
                            if (downloadNotificationEventListener != null) {
                                downloadNotificationEventListener.onNotificationEvent(1, downloadInfo, packageName, "");
                            }
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }
}
