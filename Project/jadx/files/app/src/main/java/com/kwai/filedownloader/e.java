package com.kwai.filedownloader;

import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends com.kwai.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus aEh;

    public abstract void GF();

    public abstract void GG();

    public final DownloadServiceConnectChangedEvent.ConnectStatus GH() {
        return this.aEh;
    }

    @Override // com.kwai.filedownloader.event.c
    public final boolean a(com.kwai.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        this.aEh = ((DownloadServiceConnectChangedEvent) bVar).HX();
        if (this.aEh == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            GF();
            return false;
        }
        GG();
        return false;
    }
}
