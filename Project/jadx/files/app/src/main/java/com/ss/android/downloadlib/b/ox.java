package com.ss.android.downloadlib.b;

import android.content.pm.PackageInfo;
import com.ss.android.downloadlib.addownload.x;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public class ox implements IDownloadCompleteHandler {
    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        PackageInfo packageInfoMb = com.ss.android.socialbase.appdownloader.b.mb(x.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        if (packageInfoMb != null) {
            downloadInfo.setAppVersionCode(packageInfoMb.versionCode);
        }
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.downloadlib.utils.hj.ox() && downloadInfo.getPackageInfo() == null;
    }
}
