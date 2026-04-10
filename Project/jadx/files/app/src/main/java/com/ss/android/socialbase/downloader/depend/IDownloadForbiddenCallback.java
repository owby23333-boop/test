package com.ss.android.socialbase.downloader.depend;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadForbiddenCallback {
    boolean hasCallback();

    void onCallback(List<String> list);
}
