package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TabInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J;\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/funny/audio/models/TabInfo;", "", "id", "", "name", "desc", "sort", "", "updateTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJ)V", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "getId", "setId", "getName", "setName", "getSort", "()I", "setSort", "(I)V", "getUpdateTime", "()J", "setUpdateTime", "(J)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class TabInfo {
    private String desc;
    private String id;
    private String name;
    private int sort;
    private long updateTime;

    public TabInfo() {
        this(null, null, null, 0, 0L, 31, null);
    }

    public static /* synthetic */ TabInfo copy$default(TabInfo tabInfo, String str, String str2, String str3, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tabInfo.id;
        }
        if ((i2 & 2) != 0) {
            str2 = tabInfo.name;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            str3 = tabInfo.desc;
        }
        String str5 = str3;
        if ((i2 & 8) != 0) {
            i = tabInfo.sort;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            j = tabInfo.updateTime;
        }
        return tabInfo.copy(str, str4, str5, i3, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final TabInfo copy(String id, String name, String desc, int sort, long updateTime) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        return new TabInfo(id, name, desc, sort, updateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TabInfo)) {
            return false;
        }
        TabInfo tabInfo = (TabInfo) other;
        return Intrinsics.areEqual(this.id, tabInfo.id) && Intrinsics.areEqual(this.name, tabInfo.name) && Intrinsics.areEqual(this.desc, tabInfo.desc) && this.sort == tabInfo.sort && this.updateTime == tabInfo.updateTime;
    }

    public int hashCode() {
        return (((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.desc.hashCode()) * 31) + Integer.hashCode(this.sort)) * 31) + Long.hashCode(this.updateTime);
    }

    public String toString() {
        return "TabInfo(id=" + this.id + ", name=" + this.name + ", desc=" + this.desc + ", sort=" + this.sort + ", updateTime=" + this.updateTime + ")";
    }

    public TabInfo(String id, String name, String desc, int i, long j) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.sort = i;
        this.updateTime = j;
    }

    public /* synthetic */ TabInfo(String str, String str2, String str3, int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) == 0 ? str3 : "", (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? 0L : j);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
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
