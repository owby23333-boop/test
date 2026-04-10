package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadLaunchHandler {
    List<String> getResumeMimeTypes();

    void onLaunchResume(List<DownloadInfo> list, int i2);
}
