package com.kwad.framework.filedownloader.event;

/* JADX INFO: loaded from: classes4.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus aoy;
    private final Class<?> aoz;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.aoy = connectStatus;
        this.aoz = cls;
    }

    public final ConnectStatus yH() {
        return this.aoy;
    }
}
