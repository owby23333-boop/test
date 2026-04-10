package com.kwad.components.offline.d.a;

import com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener;
import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.sdk.components.j;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements IOfflineApkLoader {
    j akC;

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void clearFileCache() {
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void uninstallApp() {
    }

    public d(j jVar) {
        this.akC = jVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void setCustomReportParam(String str) {
        this.akC.setCustomReportParam(str);
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void addLoadStatusListener(final IOfflineApkLoadStatusListener iOfflineApkLoadStatusListener) {
        this.akC.a(new com.kwad.sdk.components.i() { // from class: com.kwad.components.offline.d.a.d.1
            @Override // com.kwad.sdk.components.i
            public final void onIdle() {
                iOfflineApkLoadStatusListener.onIdle();
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadStarted() {
                iOfflineApkLoadStatusListener.onDownloadStarted();
            }

            @Override // com.kwad.sdk.components.i
            public final void onProgressUpdate(int i, long j, long j2) {
                iOfflineApkLoadStatusListener.onProgressUpdate(i, j, j2);
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadFinished() {
                iOfflineApkLoadStatusListener.onDownloadFinished();
            }

            @Override // com.kwad.sdk.components.i
            public final void onInstalled() {
                iOfflineApkLoadStatusListener.onInstalled();
            }

            @Override // com.kwad.sdk.components.i
            public final void onDownloadFailed() {
                iOfflineApkLoadStatusListener.onDownloadFailed();
            }

            @Override // com.kwad.sdk.components.i
            public final void onPaused(int i, long j, long j2) {
                iOfflineApkLoadStatusListener.onPaused(i, j, j2);
            }
        });
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void startDownload() {
        this.akC.startDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void pauseDownload() {
        this.akC.pauseDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void resumeDownload() {
        this.akC.resumeDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void stopDownload() {
        this.akC.stopDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void cancelDownload() {
        this.akC.cancelDownload();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void installApp() {
        this.akC.installApp();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineApkLoader
    public final void openApp() {
        this.akC.openApp();
    }
}
