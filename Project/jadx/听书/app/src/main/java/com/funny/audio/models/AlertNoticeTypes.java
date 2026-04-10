package com.funny.audio.models;

import kotlin.Metadata;

/* JADX INFO: compiled from: AlertNoticeInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/funny/audio/models/AlertNoticeTypes;", "", "()V", "TEXT", "", "getTEXT", "()I", "setTEXT", "(I)V", "URL", "getURL", "setURL", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AlertNoticeTypes {
    public static final AlertNoticeTypes INSTANCE = new AlertNoticeTypes();
    private static int TEXT = 1;
    private static int URL = 2;

    private AlertNoticeTypes() {
    }

    public final int getTEXT() {
        return TEXT;
    }

    public final void setTEXT(int i) {
        TEXT = i;
    }

    public final int getURL() {
        return URL;
    }

    public final void setURL(int i) {
        URL = i;
    }
}
