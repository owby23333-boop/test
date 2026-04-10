package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlbumUpdateInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/funny/audio/models/AlbumUpdateInfo;", "", "latestTrackId", "", "latestTrackTime", "", "latestTrackTitle", "trackCount", "", "(Ljava/lang/String;JLjava/lang/String;I)V", "getLatestTrackId", "()Ljava/lang/String;", "setLatestTrackId", "(Ljava/lang/String;)V", "getLatestTrackTime", "()J", "setLatestTrackTime", "(J)V", "getLatestTrackTitle", "setLatestTrackTitle", "getTrackCount", "()I", "setTrackCount", "(I)V", "component1", "component2", "component3", "component4", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AlbumUpdateInfo {
    private String latestTrackId;
    private long latestTrackTime;
    private String latestTrackTitle;
    private int trackCount;

    public AlbumUpdateInfo() {
        this(null, 0L, null, 0, 15, null);
    }

    public static /* synthetic */ AlbumUpdateInfo copy$default(AlbumUpdateInfo albumUpdateInfo, String str, long j, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = albumUpdateInfo.latestTrackId;
        }
        if ((i2 & 2) != 0) {
            j = albumUpdateInfo.latestTrackTime;
        }
        long j2 = j;
        if ((i2 & 4) != 0) {
            str2 = albumUpdateInfo.latestTrackTitle;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            i = albumUpdateInfo.trackCount;
        }
        return albumUpdateInfo.copy(str, j2, str3, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLatestTrackId() {
        return this.latestTrackId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getLatestTrackTime() {
        return this.latestTrackTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLatestTrackTitle() {
        return this.latestTrackTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getTrackCount() {
        return this.trackCount;
    }

    public final AlbumUpdateInfo copy(String latestTrackId, long latestTrackTime, String latestTrackTitle, int trackCount) {
        Intrinsics.checkNotNullParameter(latestTrackId, "latestTrackId");
        Intrinsics.checkNotNullParameter(latestTrackTitle, "latestTrackTitle");
        return new AlbumUpdateInfo(latestTrackId, latestTrackTime, latestTrackTitle, trackCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumUpdateInfo)) {
            return false;
        }
        AlbumUpdateInfo albumUpdateInfo = (AlbumUpdateInfo) other;
        return Intrinsics.areEqual(this.latestTrackId, albumUpdateInfo.latestTrackId) && this.latestTrackTime == albumUpdateInfo.latestTrackTime && Intrinsics.areEqual(this.latestTrackTitle, albumUpdateInfo.latestTrackTitle) && this.trackCount == albumUpdateInfo.trackCount;
    }

    public int hashCode() {
        return (((((this.latestTrackId.hashCode() * 31) + Long.hashCode(this.latestTrackTime)) * 31) + this.latestTrackTitle.hashCode()) * 31) + Integer.hashCode(this.trackCount);
    }

    public String toString() {
        return "AlbumUpdateInfo(latestTrackId=" + this.latestTrackId + ", latestTrackTime=" + this.latestTrackTime + ", latestTrackTitle=" + this.latestTrackTitle + ", trackCount=" + this.trackCount + ")";
    }

    public AlbumUpdateInfo(String latestTrackId, long j, String latestTrackTitle, int i) {
        Intrinsics.checkNotNullParameter(latestTrackId, "latestTrackId");
        Intrinsics.checkNotNullParameter(latestTrackTitle, "latestTrackTitle");
        this.latestTrackId = latestTrackId;
        this.latestTrackTime = j;
        this.latestTrackTitle = latestTrackTitle;
        this.trackCount = i;
    }

    public /* synthetic */ AlbumUpdateInfo(String str, long j, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0L : j, (i2 & 4) == 0 ? str2 : "", (i2 & 8) != 0 ? 0 : i);
    }

    public final String getLatestTrackId() {
        return this.latestTrackId;
    }

    public final void setLatestTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestTrackId = str;
    }

    public final long getLatestTrackTime() {
        return this.latestTrackTime;
    }

    public final void setLatestTrackTime(long j) {
        this.latestTrackTime = j;
    }

    public final String getLatestTrackTitle() {
        return this.latestTrackTitle;
    }

    public final void setLatestTrackTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestTrackTitle = str;
    }

    public final int getTrackCount() {
        return this.trackCount;
    }

    public final void setTrackCount(int i) {
        this.trackCount = i;
    }
}
