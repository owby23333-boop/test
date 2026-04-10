package com.funny.audio.models;

import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HotSearchAlbumInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003Jm\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\tHÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006:"}, d2 = {"Lcom/funny/audio/models/HotSearchAlbumInfo;", "", "id", "", "title", "coverPath", "categories", "announcers", "finishStatus", "", "tags", "desc", "sort", "updateTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IJ)V", "getAnnouncers", "()Ljava/lang/String;", "setAnnouncers", "(Ljava/lang/String;)V", "getCategories", "setCategories", "getCoverPath", "setCoverPath", "getDesc", "setDesc", "getFinishStatus", "()I", "setFinishStatus", "(I)V", "getId", "setId", "getSort", "setSort", "getTags", "setTags", "getTitle", "setTitle", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class HotSearchAlbumInfo {
    private String announcers;
    private String categories;
    private String coverPath;
    private String desc;
    private int finishStatus;
    private String id;
    private int sort;
    private String tags;
    private String title;
    private long updateTime;

    public HotSearchAlbumInfo() {
        this(null, null, null, null, null, 0, null, null, 0, 0L, AnalyticsListener.EVENT_DRM_KEYS_LOADED, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
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
    public final int getSort() {
        return this.sort;
    }

    public final HotSearchAlbumInfo copy(String id, String title, String coverPath, String categories, String announcers, int finishStatus, String tags, String desc, int sort, long updateTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(announcers, "announcers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new HotSearchAlbumInfo(id, title, coverPath, categories, announcers, finishStatus, tags, desc, sort, updateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HotSearchAlbumInfo)) {
            return false;
        }
        HotSearchAlbumInfo hotSearchAlbumInfo = (HotSearchAlbumInfo) other;
        return Intrinsics.areEqual(this.id, hotSearchAlbumInfo.id) && Intrinsics.areEqual(this.title, hotSearchAlbumInfo.title) && Intrinsics.areEqual(this.coverPath, hotSearchAlbumInfo.coverPath) && Intrinsics.areEqual(this.categories, hotSearchAlbumInfo.categories) && Intrinsics.areEqual(this.announcers, hotSearchAlbumInfo.announcers) && this.finishStatus == hotSearchAlbumInfo.finishStatus && Intrinsics.areEqual(this.tags, hotSearchAlbumInfo.tags) && Intrinsics.areEqual(this.desc, hotSearchAlbumInfo.desc) && this.sort == hotSearchAlbumInfo.sort && this.updateTime == hotSearchAlbumInfo.updateTime;
    }

    public int hashCode() {
        return (((((((((((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.coverPath.hashCode()) * 31) + this.categories.hashCode()) * 31) + this.announcers.hashCode()) * 31) + Integer.hashCode(this.finishStatus)) * 31) + this.tags.hashCode()) * 31) + this.desc.hashCode()) * 31) + Integer.hashCode(this.sort)) * 31) + Long.hashCode(this.updateTime);
    }

    public String toString() {
        return "HotSearchAlbumInfo(id=" + this.id + ", title=" + this.title + ", coverPath=" + this.coverPath + ", categories=" + this.categories + ", announcers=" + this.announcers + ", finishStatus=" + this.finishStatus + ", tags=" + this.tags + ", desc=" + this.desc + ", sort=" + this.sort + ", updateTime=" + this.updateTime + ")";
    }

    public HotSearchAlbumInfo(String id, String title, String coverPath, String categories, String announcers, int i, String tags, String desc, int i2, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(announcers, "announcers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.id = id;
        this.title = title;
        this.coverPath = coverPath;
        this.categories = categories;
        this.announcers = announcers;
        this.finishStatus = i;
        this.tags = tags;
        this.desc = desc;
        this.sort = i2;
        this.updateTime = j;
    }

    public /* synthetic */ HotSearchAlbumInfo(String str, String str2, String str3, String str4, String str5, int i, String str6, String str7, int i2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? 0 : i, (i3 & 64) != 0 ? "" : str6, (i3 & 128) == 0 ? str7 : "", (i3 & 256) == 0 ? i2 : 0, (i3 & 512) != 0 ? 0L : j);
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

    public final int getSort() {
        return this.sort;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
