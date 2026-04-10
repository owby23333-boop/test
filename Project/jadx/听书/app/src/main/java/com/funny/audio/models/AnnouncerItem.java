package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AlbumDetailInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/funny/audio/models/AnnouncerItem;", "", "id", "", "announcerName", "coverPath", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAnnouncerName", "()Ljava/lang/String;", "setAnnouncerName", "(Ljava/lang/String;)V", "getCoverPath", "setCoverPath", "getId", "setId", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AnnouncerItem {
    private String announcerName;
    private String coverPath;
    private String id;

    public AnnouncerItem() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AnnouncerItem copy$default(AnnouncerItem announcerItem, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = announcerItem.id;
        }
        if ((i & 2) != 0) {
            str2 = announcerItem.announcerName;
        }
        if ((i & 4) != 0) {
            str3 = announcerItem.coverPath;
        }
        return announcerItem.copy(str, str2, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAnnouncerName() {
        return this.announcerName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getCoverPath() {
        return this.coverPath;
    }

    public final AnnouncerItem copy(String id, String announcerName, String coverPath) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(announcerName, "announcerName");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        return new AnnouncerItem(id, announcerName, coverPath);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnouncerItem)) {
            return false;
        }
        AnnouncerItem announcerItem = (AnnouncerItem) other;
        return Intrinsics.areEqual(this.id, announcerItem.id) && Intrinsics.areEqual(this.announcerName, announcerItem.announcerName) && Intrinsics.areEqual(this.coverPath, announcerItem.coverPath);
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.announcerName.hashCode()) * 31) + this.coverPath.hashCode();
    }

    public String toString() {
        return "AnnouncerItem(id=" + this.id + ", announcerName=" + this.announcerName + ", coverPath=" + this.coverPath + ")";
    }

    public AnnouncerItem(String id, String announcerName, String coverPath) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(announcerName, "announcerName");
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        this.id = id;
        this.announcerName = announcerName;
        this.coverPath = coverPath;
    }

    public /* synthetic */ AnnouncerItem(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getAnnouncerName() {
        return this.announcerName;
    }

    public final void setAnnouncerName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.announcerName = str;
    }

    public final String getCoverPath() {
        return this.coverPath;
    }

    public final void setCoverPath(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.coverPath = str;
    }
}
