package com.ss.android.socialbase.downloader.depend;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface INotificationClickCallback {
    boolean onClickWhenInstalled(DownloadInfo downloadInfo);

    boolean onClickWhenSuccess(DownloadInfo downloadInfo);

    boolean onClickWhenUnSuccess(DownloadInfo downloadInfo);
}
