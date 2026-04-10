package com.kwai.filedownloader.event;

/* JADX INFO: loaded from: classes3.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus aGN;
    private final Class<?> aGO;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.aGN = connectStatus;
        this.aGO = cls;
    }

    public final ConnectStatus HX() {
        return this.aGN;
    }
}
