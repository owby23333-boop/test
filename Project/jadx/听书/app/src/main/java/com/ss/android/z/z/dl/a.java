package com.ss.android.z.z.dl;

/* JADX INFO: loaded from: classes4.dex */
public interface a {
    void onDownloadActive(com.ss.android.z.z.gc.gc gcVar, int i);

    void onDownloadFailed(com.ss.android.z.z.gc.gc gcVar);

    void onDownloadFinished(com.ss.android.z.z.gc.gc gcVar);

    void onDownloadPaused(com.ss.android.z.z.gc.gc gcVar, int i);

    void onDownloadStart(dl dlVar, z zVar);

    void onInstalled(com.ss.android.z.z.gc.gc gcVar);

    void z();
}
