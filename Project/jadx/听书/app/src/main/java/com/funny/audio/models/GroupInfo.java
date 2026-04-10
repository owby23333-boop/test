package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GroupInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/funny/audio/models/GroupInfo;", "", "groupId", "", "groupName", "albums", "", "Lcom/funny/audio/models/AlbumInfo;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAlbums", "()Ljava/util/List;", "setAlbums", "(Ljava/util/List;)V", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "getGroupName", "setGroupName", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class GroupInfo {
    private List<AlbumInfo> albums;
    private String groupId;
    private String groupName;

    public GroupInfo() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupInfo copy$default(GroupInfo groupInfo, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = groupInfo.groupId;
        }
        if ((i & 2) != 0) {
            str2 = groupInfo.groupName;
        }
        if ((i & 4) != 0) {
            list = groupInfo.albums;
        }
        return groupInfo.copy(str, str2, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    public final List<AlbumInfo> component3() {
        return this.albums;
    }

    public final GroupInfo copy(String groupId, String groupName, List<AlbumInfo> albums) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(albums, "albums");
        return new GroupInfo(groupId, groupName, albums);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupInfo)) {
            return false;
        }
        GroupInfo groupInfo = (GroupInfo) other;
        return Intrinsics.areEqual(this.groupId, groupInfo.groupId) && Intrinsics.areEqual(this.groupName, groupInfo.groupName) && Intrinsics.areEqual(this.albums, groupInfo.albums);
    }

    public int hashCode() {
        return (((this.groupId.hashCode() * 31) + this.groupName.hashCode()) * 31) + this.albums.hashCode();
    }

    public String toString() {
        return "GroupInfo(groupId=" + this.groupId + ", groupName=" + this.groupName + ", albums=" + this.albums + ")";
    }

    public GroupInfo(String groupId, String groupName, List<AlbumInfo> albums) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(albums, "albums");
        this.groupId = groupId;
        this.groupName = groupName;
        this.albums = albums;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final void setGroupId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupId = str;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final void setGroupName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.groupName = str;
    }

    public /* synthetic */ GroupInfo(String str, String str2, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? new ArrayList() : arrayList);
    }

    public final List<AlbumInfo> getAlbums() {
        return this.albums;
    }

    public final void setAlbums(List<AlbumInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.albums = list;
    }
}
