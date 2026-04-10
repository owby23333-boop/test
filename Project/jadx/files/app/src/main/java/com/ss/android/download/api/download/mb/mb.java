package com.ss.android.download.api.download.mb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes3.dex */
public interface mb {
    void mb(@NonNull DownloadModel downloadModel, @Nullable DownloadController downloadController, @Nullable DownloadEventConfig downloadEventConfig);

    void mb(@NonNull DownloadInfo downloadInfo);

    void mb(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str);

    void mb(@NonNull DownloadInfo downloadInfo, String str);

    void ox(@Nullable DownloadInfo downloadInfo, String str);
}
