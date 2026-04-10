package com.funny.audio.models;

import com.google.gson.annotations.SerializedName;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssociateInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/funny/audio/models/AssociateInfo;", "", "key", "", "relationId", "relationType", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getRelationId", "getRelationType", "()I", "component1", "component2", "component3", "copy", "equals", "", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AssociateInfo {

    @SerializedName("key")
    private final String key;

    @SerializedName("relationId")
    private final String relationId;

    @SerializedName("relationType")
    private final int relationType;

    public AssociateInfo() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ AssociateInfo copy$default(AssociateInfo associateInfo, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = associateInfo.key;
        }
        if ((i2 & 2) != 0) {
            str2 = associateInfo.relationId;
        }
        if ((i2 & 4) != 0) {
            i = associateInfo.relationType;
        }
        return associateInfo.copy(str, str2, i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRelationId() {
        return this.relationId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getRelationType() {
        return this.relationType;
    }

    public final AssociateInfo copy(String key, String relationId, int relationType) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(relationId, "relationId");
        return new AssociateInfo(key, relationId, relationType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AssociateInfo)) {
            return false;
        }
        AssociateInfo associateInfo = (AssociateInfo) other;
        return Intrinsics.areEqual(this.key, associateInfo.key) && Intrinsics.areEqual(this.relationId, associateInfo.relationId) && this.relationType == associateInfo.relationType;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + this.relationId.hashCode()) * 31) + Integer.hashCode(this.relationType);
    }

    public String toString() {
        return "AssociateInfo(key=" + this.key + ", relationId=" + this.relationId + ", relationType=" + this.relationType + ")";
    }

    public AssociateInfo(String key, String relationId, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(relationId, "relationId");
        this.key = key;
        this.relationId = relationId;
        this.relationType = i;
    }

    public /* synthetic */ AssociateInfo(String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 1 : i);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getRelationId() {
        return this.relationId;
    }

    public final int getRelationType() {
        return this.relationType;
    }
}
