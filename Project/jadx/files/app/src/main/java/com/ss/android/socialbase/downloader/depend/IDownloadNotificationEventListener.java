package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadNotificationEventListener {
    String getNotifyProcessName();

    boolean interceptAfterNotificationSuccess(boolean z2);

    void onNotificationEvent(int i2, DownloadInfo downloadInfo, String str, String str2);
}
