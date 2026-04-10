package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlbumTrackInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0002\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J`\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\f2\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\t\u00103\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0017\"\u0004\b\u001a\u0010\u0019R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012¨\u00064"}, d2 = {"Lcom/funny/audio/models/AlbumTrackInfo;", "", "id", "", "title", "albumId", "publishTime", "", "sort", "", "coverPath", "isPlaying", "", "isCurrent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;ZZ)V", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "getCoverPath", "setCoverPath", "getId", "setId", "()Z", "setCurrent", "(Z)V", "setPlaying", "getPublishTime", "()Ljava/lang/Long;", "setPublishTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSort", "()I", "setSort", "(I)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;ILjava/lang/String;ZZ)Lcom/funny/audio/models/AlbumTrackInfo;", "equals", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AlbumTrackInfo {
    private String albumId;
    private String coverPath;
    private String id;
    private boolean isCurrent;
    private boolean isPlaying;
    private Long publishTime;
    private int sort;
    private String title;

    public AlbumTrackInfo() {
        this(null, null, null, null, 0, null, false, false, 255, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Long getPublishTime() {
        return this.publishTime;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsCurrent() {
        return this.isCurrent;
    }

    public final AlbumTrackInfo copy(String id, String title, String albumId, Long publishTime, int sort, String coverPath, boolean isPlaying, boolean isCurrent) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        return new AlbumTrackInfo(id, title, albumId, publishTime, sort, coverPath, isPlaying, isCurrent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlbumTrackInfo)) {
            return false;
        }
        AlbumTrackInfo albumTrackInfo = (AlbumTrackInfo) other;
        return Intrinsics.areEqual(this.id, albumTrackInfo.id) && Intrinsics.areEqual(this.title, albumTrackInfo.title) && Intrinsics.areEqual(this.albumId, albumTrackInfo.albumId) && Intrinsics.areEqual(this.publishTime, albumTrackInfo.publishTime) && this.sort == albumTrackInfo.sort && Intrinsics.areEqual(this.coverPath, albumTrackInfo.coverPath) && this.isPlaying == albumTrackInfo.isPlaying && this.isCurrent == albumTrackInfo.isCurrent;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.albumId.hashCode()) * 31;
        Long l = this.publishTime;
        int iHashCode2 = (((((iHashCode + (l == null ? 0 : l.hashCode())) * 31) + Integer.hashCode(this.sort)) * 31) + this.coverPath.hashCode()) * 31;
        boolean z = this.isPlaying;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i = (iHashCode2 + r1) * 31;
        boolean z2 = this.isCurrent;
        return i + (z2 ? 1 : z2);
    }

    public String toString() {
        return "AlbumTrackInfo(id=" + this.id + ", title=" + this.title + ", albumId=" + this.albumId + ", publishTime=" + this.publishTime + ", sort=" + this.sort + ", coverPath=" + this.coverPath + ", isPlaying=" + this.isPlaying + ", isCurrent=" + this.isCurrent + ")";
    }

    public AlbumTrackInfo(String id, String title, String albumId, Long l, int i, String coverPath, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        this.id = id;
        this.title = title;
        this.albumId = albumId;
        this.publishTime = l;
        this.sort = i;
        this.coverPath = coverPath;
        this.isPlaying = z;
        this.isCurrent = z2;
    }

    public /* synthetic */ AlbumTrackInfo(String str, String str2, String str3, Long l, int i, String str4, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? null : l, (i2 & 16) != 0 ? 0 : i, (i2 & 32) == 0 ? str4 : "", (i2 & 64) != 0 ? false : z, (i2 & 128) == 0 ? z2 : false);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final Long getPublishTime() {
        return this.publishTime;
    }

    public final void setPublishTime(Long l) {
        this.publishTime = l;
    }

    public final int getSort() {
        return this.sort;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }

    public final boolean isPlaying() {
        return this.isPlaying;
    }

    public final void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    public final boolean isCurrent() {
        return this.isCurrent;
    }

    public final void setCurrent(boolean z) {
        this.isCurrent = z;
    }
}
