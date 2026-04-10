package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateAlbumInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003Jw\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010<\u001a\u00020\tHÖ\u0001J\t\u0010=\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0012\"\u0004\b(\u0010\u0014R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0012\"\u0004\b*\u0010\u0014R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0012\"\u0004\b,\u0010\u0014¨\u0006>"}, d2 = {"Lcom/funny/audio/models/UpdateAlbumInfo;", "", "id", "", "title", "coverPath", "categories", "announcers", "finishStatus", "", "tags", "desc", "latestTrackTime", "", "latestTrackId", "latestTrackTitle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;)V", "getAnnouncers", "()Ljava/lang/String;", "setAnnouncers", "(Ljava/lang/String;)V", "getCategories", "setCategories", "getCoverPath", "setCoverPath", "getDesc", "setDesc", "getFinishStatus", "()I", "setFinishStatus", "(I)V", "getId", "setId", "getLatestTrackId", "setLatestTrackId", "getLatestTrackTime", "()J", "setLatestTrackTime", "(J)V", "getLatestTrackTitle", "setLatestTrackTitle", "getTags", "setTags", "getTitle", "setTitle", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UpdateAlbumInfo {
    private String announcers;
    private String categories;
    private String coverPath;
    private String desc;
    private int finishStatus;
    private String id;
    private String latestTrackId;
    private long latestTrackTime;
    private String latestTrackTitle;
    private String tags;
    private String title;

    public UpdateAlbumInfo() {
        this(null, null, null, null, null, 0, null, null, 0L, null, null, 2047, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getLatestTrackId() {
        return this.latestTrackId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getLatestTrackTitle() {
        return this.latestTrackTitle;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCategories() {
        return this.categories;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnnouncers() {
        return this.announcers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getFinishStatus() {
        return this.finishStatus;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getTags() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final long getLatestTrackTime() {
        return this.latestTrackTime;
    }

    public final UpdateAlbumInfo copy(String id, String title, String coverPath, String categories, String announcers, int finishStatus, String tags, String desc, long latestTrackTime, String latestTrackId, String latestTrackTitle) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(announcers, "announcers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(latestTrackId, "latestTrackId");
        Intrinsics.checkNotNullParameter(latestTrackTitle, "latestTrackTitle");
        return new UpdateAlbumInfo(id, title, coverPath, categories, announcers, finishStatus, tags, desc, latestTrackTime, latestTrackId, latestTrackTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateAlbumInfo)) {
            return false;
        }
        UpdateAlbumInfo updateAlbumInfo = (UpdateAlbumInfo) other;
        return Intrinsics.areEqual(this.id, updateAlbumInfo.id) && Intrinsics.areEqual(this.title, updateAlbumInfo.title) && Intrinsics.areEqual(this.coverPath, updateAlbumInfo.coverPath) && Intrinsics.areEqual(this.categories, updateAlbumInfo.categories) && Intrinsics.areEqual(this.announcers, updateAlbumInfo.announcers) && this.finishStatus == updateAlbumInfo.finishStatus && Intrinsics.areEqual(this.tags, updateAlbumInfo.tags) && Intrinsics.areEqual(this.desc, updateAlbumInfo.desc) && this.latestTrackTime == updateAlbumInfo.latestTrackTime && Intrinsics.areEqual(this.latestTrackId, updateAlbumInfo.latestTrackId) && Intrinsics.areEqual(this.latestTrackTitle, updateAlbumInfo.latestTrackTitle);
    }

    public int hashCode() {
        return (((((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.coverPath.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.announcers.hashCode()) * 31) + Integer.hashCode(this.finishStatus)) * 31) + this.tags.hashCode()) * 31) + this.desc.hashCode()) * 31) + Long.hashCode(this.latestTrackTime)) * 31) + this.latestTrackId.hashCode()) * 31) + this.latestTrackTitle.hashCode();
    }

    public String toString() {
        return "UpdateAlbumInfo(id=" + this.id + ", title=" + this.title + ", coverPath=" + this.coverPath + ", categories=" + this.categories + ", announcers=" + this.announcers + ", finishStatus=" + this.finishStatus + ", tags=" + this.tags + ", desc=" + this.desc + ", latestTrackTime=" + this.latestTrackTime + ", latestTrackId=" + this.latestTrackId + ", latestTrackTitle=" + this.latestTrackTitle + ")";
    }

    public UpdateAlbumInfo(String id, String title, String coverPath, String categories, String announcers, int i, String tags, String desc, long j, String latestTrackId, String latestTrackTitle) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(announcers, "announcers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(latestTrackId, "latestTrackId");
        Intrinsics.checkNotNullParameter(latestTrackTitle, "latestTrackTitle");
        this.id = id;
        this.title = title;
        this.coverPath = coverPath;
        this.categories = categories;
        this.announcers = announcers;
        this.finishStatus = i;
        this.tags = tags;
        this.desc = desc;
        this.latestTrackTime = j;
        this.latestTrackId = latestTrackId;
        this.latestTrackTitle = latestTrackTitle;
    }

    public /* synthetic */ UpdateAlbumInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, long j, String str8, String str9, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? 0 : i, (i2 & 64) != 0 ? "" : str6, (i2 & 128) != 0 ? "" : str7, (i2 & 256) != 0 ? 0L : j, (i2 & 512) != 0 ? "" : str8, (i2 & 1024) == 0 ? str9 : "");
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

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }

    public final String getCategories() {
        return this.categories;
    }

    public final void setCategories(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.categories = str;
    }

    public final String getAnnouncers() {
        return this.announcers;
    }

    public final void setAnnouncers(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.announcers = str;
    }

    public final int getFinishStatus() {
        return this.finishStatus;
    }

    public final void setFinishStatus(int i) {
        this.finishStatus = i;
    }

    public final String getTags() {
        return this.tags;
    }

    public final void setTags(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tags = str;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }

    public final long getLatestTrackTime() {
        return this.latestTrackTime;
    }

    public final void setLatestTrackTime(long j) {
        this.latestTrackTime = j;
    }

    public final String getLatestTrackId() {
        return this.latestTrackId;
    }

    public final void setLatestTrackId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestTrackId = str;
    }

    public final String getLatestTrackTitle() {
        return this.latestTrackTitle;
    }

    public final void setLatestTrackTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.latestTrackTitle = str;
    }
}
