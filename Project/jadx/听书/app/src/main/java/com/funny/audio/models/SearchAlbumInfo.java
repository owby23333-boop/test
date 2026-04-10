package com.funny.audio.models;

import com.google.gson.annotations.SerializedName;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchAlbumInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003Jc\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u00063"}, d2 = {"Lcom/funny/audio/models/SearchAlbumInfo;", "", "albumId", "", "title", "subTitle", "announcerName", "category", "tag", "coverPath", "finishStatus", "", "desc", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", "getAnnouncerName", "setAnnouncerName", "getCategory", "setCategory", "getCoverPath", "setCoverPath", "getDesc", "setDesc", "getFinishStatus", "()I", "setFinishStatus", "(I)V", "getSubTitle", "setSubTitle", "getTag", "setTag", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SearchAlbumInfo {

    @SerializedName("albumId")
    private String albumId;

    @SerializedName("announcerName")
    private String announcerName;

    @SerializedName("category")
    private String category;

    @SerializedName("coverPath")
    private String coverPath;

    @SerializedName("desc")
    private String desc;

    @SerializedName("finishStatus")
    private int finishStatus;

    @SerializedName("subTitle")
    private String subTitle;

    @SerializedName("tag")
    private String tag;

    @SerializedName("title")
    private String title;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAlbumId() {
        return this.albumId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSubTitle() {
        return this.subTitle;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getAnnouncerName() {
        return this.announcerName;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getFinishStatus() {
        return this.finishStatus;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    public final SearchAlbumInfo copy(String albumId, String title, String subTitle, String announcerName, String category, String tag, String coverPath, int finishStatus, String desc) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(announcerName, "announcerName");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new SearchAlbumInfo(albumId, title, subTitle, announcerName, category, tag, coverPath, finishStatus, desc);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchAlbumInfo)) {
            return false;
        }
        SearchAlbumInfo searchAlbumInfo = (SearchAlbumInfo) other;
        return Intrinsics.areEqual(this.albumId, searchAlbumInfo.albumId) && Intrinsics.areEqual(this.title, searchAlbumInfo.title) && Intrinsics.areEqual(this.subTitle, searchAlbumInfo.subTitle) && Intrinsics.areEqual(this.announcerName, searchAlbumInfo.announcerName) && Intrinsics.areEqual(this.category, searchAlbumInfo.category) && Intrinsics.areEqual(this.tag, searchAlbumInfo.tag) && Intrinsics.areEqual(this.coverPath, searchAlbumInfo.coverPath) && this.finishStatus == searchAlbumInfo.finishStatus && Intrinsics.areEqual(this.desc, searchAlbumInfo.desc);
    }

    public int hashCode() {
        return (((((((((((((((this.albumId.hashCode() * 31) + this.title.hashCode()) * 31) + this.subTitle.hashCode()) * 31) + this.announcerName.hashCode()) * 31) + this.category.hashCode()) * 31) + this.tag.hashCode()) * 31) + this.coverPath.hashCode()) * 31) + Integer.hashCode(this.finishStatus)) * 31) + this.desc.hashCode();
    }

    public String toString() {
        return "SearchAlbumInfo(albumId=" + this.albumId + ", title=" + this.title + ", subTitle=" + this.subTitle + ", announcerName=" + this.announcerName + ", category=" + this.category + ", tag=" + this.tag + ", coverPath=" + this.coverPath + ", finishStatus=" + this.finishStatus + ", desc=" + this.desc + ")";
    }

    public SearchAlbumInfo(String albumId, String title, String subTitle, String announcerName, String category, String tag, String coverPath, int i, String desc) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subTitle, "subTitle");
        Intrinsics.checkNotNullParameter(announcerName, "announcerName");
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.albumId = albumId;
        this.title = title;
        this.subTitle = subTitle;
        this.announcerName = announcerName;
        this.category = category;
        this.tag = tag;
        this.coverPath = coverPath;
        this.finishStatus = i;
        this.desc = desc;
    }

    public /* synthetic */ SearchAlbumInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, String str8, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? "" : str8);
    }

    public final String getAlbumId() {
        return this.albumId;
    }

    public final void setAlbumId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumId = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.subTitle = str;
    }

    public final String getAnnouncerName() {
        return this.announcerName;
    }

    public final void setAnnouncerName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.announcerName = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.category = str;
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tag = str;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }

    public final int getFinishStatus() {
        return this.finishStatus;
    }

    public final void setFinishStatus(int i) {
        this.finishStatus = i;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final void setDesc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.desc = str;
    }
}
