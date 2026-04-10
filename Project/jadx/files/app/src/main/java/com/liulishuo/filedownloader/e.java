package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;

/* JADX INFO: compiled from: FileDownloadConnectListener.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends com.liulishuo.filedownloader.event.d {
    private DownloadServiceConnectChangedEvent.ConnectStatus a;

    public abstract void a();

    @Override // com.liulishuo.filedownloader.event.d
    public boolean a(com.liulishuo.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        this.a = ((DownloadServiceConnectChangedEvent) bVar).b();
        if (this.a == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            a();
            return false;
        }
        b();
        return false;
    }

    public abstract void b();

    public DownloadServiceConnectChangedEvent.ConnectStatus c() {
        return this.a;
    }
}
