package com.liulishuo.filedownloader.event;

/* JADX INFO: loaded from: classes3.dex */
public class DownloadServiceConnectChangedEvent extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConnectStatus f17193c;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f17193c = connectStatus;
    }

    public ConnectStatus b() {
        return this.f17193c;
    }
}
