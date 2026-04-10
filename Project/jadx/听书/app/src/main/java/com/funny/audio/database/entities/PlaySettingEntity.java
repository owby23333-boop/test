package com.funny.audio.database.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaySettingEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/database/entities/PlaySettingEntity;", "", "()V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "time", "", "getTime", "()J", "setTime", "(J)V", "value", "getValue", "setValue", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlaySettingEntity {
    private long time;
    private String albumId = "";
    private String value = "";

    public final String getAlbumId() {
        return this.albumId;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}
