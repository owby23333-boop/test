package com.funny.audio.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: SystemNoticeInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/funny/audio/models/SystemNoticeTypes;", "", "()V", "CONTENT", "", "getCONTENT", "()I", "setCONTENT", "(I)V", "H5", "getH5", "setH5", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SystemNoticeTypes {
    private static int CONTENT;
    public static final SystemNoticeTypes INSTANCE = new SystemNoticeTypes();
    private static int H5 = 1;

    private SystemNoticeTypes() {
    }

    public final int getCONTENT() {
        return CONTENT;
    }

    public final void setCONTENT(int i) {
        CONTENT = i;
    }

    public final int getH5() {
        return H5;
    }

    public final void setH5(int i) {
        H5 = i;
    }
}
