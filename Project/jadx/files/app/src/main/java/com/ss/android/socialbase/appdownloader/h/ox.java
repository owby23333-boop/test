package com.ss.android.socialbase.appdownloader.h;

import android.content.Context;
import com.ss.android.socialbase.downloader.depend.AbsNotificationListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.AbsNotificationItem;

/* JADX INFO: loaded from: classes3.dex */
public class ox extends AbsNotificationListener {
    private String b;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f18056h;
    private String hj;
    private AbsNotificationItem ko;
    private Context mb;
    private int ox;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f18057u;

    public ox(Context context, int i2, String str, String str2, String str3, String str4) {
        if (context != null) {
            this.mb = context.getApplicationContext();
        } else {
            this.mb = DownloadComponentManager.getAppContext();
        }
        this.ox = i2;
        this.b = str;
        this.hj = str2;
        this.f18056h = str3;
        this.f18057u = str4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener
    public AbsNotificationItem createNotificationItem() {
        Context context;
        return (this.ko != null || (context = this.mb) == null) ? this.ko : new mb(context, this.ox, this.b, this.hj, this.f18056h, this.f18057u);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
        if (downloadInfo == null || this.mb == null || !downloadInfo.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onFailed(downloadInfo, baseException);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPause(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPause(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onPrepare(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onPrepare(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onProgress(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onProgress(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onStart(DownloadInfo downloadInfo) {
        if (downloadInfo == null || downloadInfo.isAutoInstallWithoutNotification()) {
            return;
        }
        super.onStart(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.AbsNotificationListener, com.ss.android.socialbase.downloader.depend.AbsDownloadListener, com.ss.android.socialbase.downloader.depend.IDownloadListener
    public void onSuccessed(DownloadInfo downloadInfo) {
        if (downloadInfo == null || this.mb == null) {
            return;
        }
        if (downloadInfo.canShowNotification() && (!downloadInfo.isAutoInstallWithoutNotification() || !downloadInfo.isAutoInstall())) {
            super.onSuccessed(downloadInfo);
        }
        if (downloadInfo.isAutoInstall()) {
            com.ss.android.socialbase.appdownloader.u.ox.mb(downloadInfo);
        }
    }

    public ox(AbsNotificationItem absNotificationItem) {
        this.mb = DownloadComponentManager.getAppContext();
        this.ko = absNotificationItem;
    }
}
