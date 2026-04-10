package com.ss.android.socialbase.downloader.downloader;

import android.os.IBinder;

/* JADX INFO: loaded from: classes3.dex */
public interface IDownloadServiceConnectionListener {
    void onServiceConnection(IBinder iBinder);

    void onServiceDisConnection();
}
