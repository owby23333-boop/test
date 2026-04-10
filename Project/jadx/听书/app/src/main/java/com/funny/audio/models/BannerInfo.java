package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BannerInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\tHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006'"}, d2 = {"Lcom/funny/audio/models/BannerInfo;", "", "id", "", "title", "bannerUrl", "relationType", "relationId", "sort", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getBannerUrl", "()Ljava/lang/String;", "setBannerUrl", "(Ljava/lang/String;)V", "getId", "setId", "getRelationId", "setRelationId", "getRelationType", "setRelationType", "getSort", "()I", "setSort", "(I)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class BannerInfo {
    private String bannerUrl;
    private String id;
    private String relationId;
    private String relationType;
    private int sort;
    private String title;

    public BannerInfo() {
        this(null, null, null, null, null, 0, 63, null);
    }

    public static /* synthetic */ BannerInfo copy$default(BannerInfo bannerInfo, String str, String str2, String str3, String str4, String str5, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bannerInfo.id;
        }
        if ((i2 & 2) != 0) {
            str2 = bannerInfo.title;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = bannerInfo.bannerUrl;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = bannerInfo.relationType;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = bannerInfo.relationId;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            i = bannerInfo.sort;
        }
        return bannerInfo.copy(str, str6, str7, str8, str9, i);
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
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRelationType() {
        return this.relationType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getRelationId() {
        return this.relationId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getSort() {
        return this.sort;
    }

    public final BannerInfo copy(String id, String title, String bannerUrl, String relationType, String relationId, int sort) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bannerUrl, "bannerUrl");
        Intrinsics.checkNotNullParameter(relationType, "relationType");
        Intrinsics.checkNotNullParameter(relationId, "relationId");
        return new BannerInfo(id, title, bannerUrl, relationType, relationId, sort);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BannerInfo)) {
            return false;
        }
        BannerInfo bannerInfo = (BannerInfo) other;
        return Intrinsics.areEqual(this.id, bannerInfo.id) && Intrinsics.areEqual(this.title, bannerInfo.title) && Intrinsics.areEqual(this.bannerUrl, bannerInfo.bannerUrl) && Intrinsics.areEqual(this.relationType, bannerInfo.relationType) && Intrinsics.areEqual(this.relationId, bannerInfo.relationId) && this.sort == bannerInfo.sort;
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.title.hashCode()) * 31) + this.bannerUrl.hashCode()) * 31) + this.relationType.hashCode()) * 31) + this.relationId.hashCode()) * 31) + Integer.hashCode(this.sort);
    }

    public String toString() {
        return "BannerInfo(id=" + this.id + ", title=" + this.title + ", bannerUrl=" + this.bannerUrl + ", relationType=" + this.relationType + ", relationId=" + this.relationId + ", sort=" + this.sort + ")";
    }

    public BannerInfo(String id, String title, String bannerUrl, String relationType, String relationId, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(bannerUrl, "bannerUrl");
        Intrinsics.checkNotNullParameter(relationType, "relationType");
        Intrinsics.checkNotNullParameter(relationId, "relationId");
        this.id = id;
        this.title = title;
        this.bannerUrl = bannerUrl;
        this.relationType = relationType;
        this.relationId = relationId;
        this.sort = i;
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

    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    public final void setBannerUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.bannerUrl = str;
    }

    public /* synthetic */ BannerInfo(String str, String str2, String str3, String str4, String str5, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? BannerRelationTypes.INSTANCE.getALBUM() : str4, (i2 & 16) == 0 ? str5 : "", (i2 & 32) != 0 ? 0 : i);
    }

    public final String getRelationType() {
        return this.relationType;
    }

    public final void setRelationType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.relationType = str;
    }

    public final String getRelationId() {
        return this.relationId;
    }

    public final void setRelationId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.relationId = str;
    }

    public final int getSort() {
        return this.sort;
    }

    public final void setSort(int i) {
        this.sort = i;
    }
}
