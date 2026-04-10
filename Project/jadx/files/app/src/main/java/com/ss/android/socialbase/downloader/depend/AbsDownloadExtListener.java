package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsDownloadExtListener extends AbsDownloadListener implements IDownloadExtListener {
    private static final String TAG = "AbsDownloadExtListener";

    public void onWaitingDownloadCompleteHandler(DownloadInfo downloadInfo) {
        if (!Logger.debug() || downloadInfo == null) {
            return;
        }
        Logger.d(TAG, " onWaitingDownloadCompleteHandler -- " + downloadInfo.getName());
    }
}
