package com.funny.audio.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PleaseAlbumReq.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/models/PleaseAlbumReq;", "", "()V", "albumTitle", "", "getAlbumTitle", "()Ljava/lang/String;", "setAlbumTitle", "(Ljava/lang/String;)V", "announcer", "getAnnouncer", "setAnnouncer", "content", "getContent", "setContent", "platform", "getPlatform", "setPlatform", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PleaseAlbumReq {
    private String albumTitle = "";
    private String announcer = "";
    private String platform = "";
    private String content = "";

    public final String getAlbumTitle() {
        return this.albumTitle;
    }

    public final void setAlbumTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumTitle = str;
    }

    public final String getAnnouncer() {
        return this.announcer;
    }

    public final void setAnnouncer(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.announcer = str;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final void setPlatform(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platform = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }
}
