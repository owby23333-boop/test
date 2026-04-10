package com.funny.audio.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: CloudUpdateInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/models/UpgradeTypes;", "", "()V", "DOWNLOAD", "", "getDOWNLOAD", "()I", "setDOWNLOAD", "(I)V", "HOT", "getHOT", "setHOT", "LINK", "getLINK", "setLINK", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UpgradeTypes {
    public static final UpgradeTypes INSTANCE = new UpgradeTypes();
    private static int DOWNLOAD = 1;
    private static int LINK = 2;
    private static int HOT = 3;

    private UpgradeTypes() {
    }

    public final int getDOWNLOAD() {
        return DOWNLOAD;
    }

    public final void setDOWNLOAD(int i) {
        DOWNLOAD = i;
    }

    public final int getLINK() {
        return LINK;
    }

    public final void setLINK(int i) {
        LINK = i;
    }

    public final int getHOT() {
        return HOT;
    }

    public final void setHOT(int i) {
        HOT = i;
    }
}
