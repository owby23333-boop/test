package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus alR;

    public abstract void xk();

    public abstract void xl();

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus connectStatusYH = ((DownloadServiceConnectChangedEvent) bVar).yH();
        this.alR = connectStatusYH;
        if (connectStatusYH == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            xk();
            return false;
        }
        xl();
        return false;
    }

    public final DownloadServiceConnectChangedEvent.ConnectStatus xm() {
        return this.alR;
    }
}
