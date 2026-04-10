package com.ss.android.socialbase.downloader.network;

import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadHeadHttpConnection {
    void cancel();

    int getResponseCode() throws IOException;

    String getResponseHeaderField(String str);
}
