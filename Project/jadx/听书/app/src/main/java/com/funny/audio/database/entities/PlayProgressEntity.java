package com.funny.audio.database.entities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlayProgressEntity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/funny/audio/database/entities/PlayProgressEntity;", "", "()V", "albumId", "", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "time", "getTime", "setTime", "totalDuration", "getTotalDuration", "setTotalDuration", "trackId", "getTrackId", "setTrackId", "trackIndex", "", "getTrackIndex", "()I", "setTrackIndex", "(I)V", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlayProgressEntity {
    private long duration;
    private long time;
    private long totalDuration;
    private int trackIndex;
    private String albumId = "";
    private String trackId = "";

    public final String getAlbumId() {
        return this.albumId;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final String getTrackId() {
        return this.trackId;
    }

    public final void setTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.trackId = str;
    }

    public final int getTrackIndex() {
        return this.trackIndex;
    }

    public final void setTrackIndex(int i) {
        this.trackIndex = i;
    }

    public final long getTotalDuration() {
        return this.totalDuration;
    }

    public final void setTotalDuration(long j) {
        this.totalDuration = j;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final long getTime() {
        return this.time;
    }

    public final void setTime(long j) {
        this.time = j;
    }
}
