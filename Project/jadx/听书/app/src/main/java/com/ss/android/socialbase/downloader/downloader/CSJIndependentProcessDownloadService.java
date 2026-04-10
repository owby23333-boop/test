package com.ss.android.socialbase.downloader.downloader;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes4.dex */
public class CSJIndependentProcessDownloadService extends CSJDownloadService {
    @Override // com.ss.android.socialbase.downloader.downloader.CSJDownloadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        dl.z(this);
        if (dl.ec() == null) {
            dl.z(new zw());
        }
        this.z = dl.sy();
        this.z.z(new WeakReference(this));
    }
}
