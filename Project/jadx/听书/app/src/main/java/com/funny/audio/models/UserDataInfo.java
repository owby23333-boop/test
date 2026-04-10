package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserDataInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003JE\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000e¨\u0006("}, d2 = {"Lcom/funny/audio/models/UserDataInfo;", "", "dataId", "", "userId", "content", "dataType", "createTime", "", "updateTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()J", "setCreateTime", "(J)V", "getDataId", "setDataId", "getDataType", "setDataType", "getUpdateTime", "setUpdateTime", "getUserId", "setUserId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class UserDataInfo {
    private String content;
    private long createTime;
    private String dataId;
    private String dataType;
    private long updateTime;
    private String userId;

    public UserDataInfo() {
        this(null, null, null, null, 0L, 0L, 63, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDataId() {
        return this.dataId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDataType() {
        return this.dataType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final UserDataInfo copy(String dataId, String userId, String content, String dataType, long createTime, long updateTime) {
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        return new UserDataInfo(dataId, userId, content, dataType, createTime, updateTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserDataInfo)) {
            return false;
        }
        UserDataInfo userDataInfo = (UserDataInfo) other;
        return Intrinsics.areEqual(this.dataId, userDataInfo.dataId) && Intrinsics.areEqual(this.userId, userDataInfo.userId) && Intrinsics.areEqual(this.content, userDataInfo.content) && Intrinsics.areEqual(this.dataType, userDataInfo.dataType) && this.createTime == userDataInfo.createTime && this.updateTime == userDataInfo.updateTime;
    }

    public int hashCode() {
        return (((((((((this.dataId.hashCode() * 31) + this.userId.hashCode()) * 31) + this.content.hashCode()) * 31) + this.dataType.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.updateTime);
    }

    public String toString() {
        return "UserDataInfo(dataId=" + this.dataId + ", userId=" + this.userId + ", content=" + this.content + ", dataType=" + this.dataType + ", createTime=" + this.createTime + ", updateTime=" + this.updateTime + ")";
    }

    public UserDataInfo(String dataId, String userId, String content, String dataType, long j, long j2) {
        Intrinsics.checkNotNullParameter(dataId, "dataId");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(dataType, "dataType");
        this.dataId = dataId;
        this.userId = userId;
        this.content = content;
        this.dataType = dataType;
        this.createTime = j;
        this.updateTime = j2;
    }

    public /* synthetic */ UserDataInfo(String str, String str2, String str3, String str4, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) == 0 ? str4 : "", (i & 16) != 0 ? 0L : j, (i & 32) != 0 ? 0L : j2);
    }

    public final String getDataId() {
        return this.dataId;
    }

    public final void setDataId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataId = str;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.userId = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final void setDataType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataType = str;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(long j) {
        this.createTime = j;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(long j) {
        this.updateTime = j;
    }
}
