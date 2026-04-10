package com.funny.audio.models;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AdInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b:\b\u0086\b\u0018\u00002\u00020\u0001B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003¢\u0006\u0002\u0010\u0013J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\bHÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u000eHÆ\u0003J\u008b\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u0003HÆ\u0001J\u0013\u0010D\u001a\u00020\b2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020\u000eHÖ\u0001J\t\u0010G\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0015\"\u0004\b-\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001d\"\u0004\b/\u0010\u001fR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0010\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001d\"\u0004\b5\u0010\u001f¨\u0006H"}, d2 = {"Lcom/funny/audio/models/AdInfo;", "", "id", "", "key", "name", "psign", "show", "", "freeTime", "", "rewardDuration", "adType", "maxShowCount", "", "preloadInterval", "showInterval", "codeId", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJLjava/lang/String;IJJLjava/lang/String;Ljava/lang/String;)V", "getAdType", "()Ljava/lang/String;", "setAdType", "(Ljava/lang/String;)V", "getCodeId", "setCodeId", "getDescription", "setDescription", "getFreeTime", "()J", "setFreeTime", "(J)V", "getId", "setId", "getKey", "setKey", "getMaxShowCount", "()I", "setMaxShowCount", "(I)V", "getName", "setName", "getPreloadInterval", "setPreloadInterval", "getPsign", "setPsign", "getRewardDuration", "setRewardDuration", "getShow", "()Z", "setShow", "(Z)V", "getShowInterval", "setShowInterval", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", AdnName.OTHER, "hashCode", "toString", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class AdInfo {
    private String adType;
    private String codeId;
    private String description;
    private long freeTime;
    private String id;
    private String key;
    private int maxShowCount;
    private String name;
    private long preloadInterval;
    private String psign;
    private long rewardDuration;
    private boolean show;
    private long showInterval;

    public AdInfo() {
        this(null, null, null, null, false, 0L, 0L, null, 0, 0L, 0L, null, null, 8191, null);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getPreloadInterval() {
        return this.preloadInterval;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getShowInterval() {
        return this.showInterval;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getCodeId() {
        return this.codeId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getPsign() {
        return this.psign;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getShow() {
        return this.show;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final long getFreeTime() {
        return this.freeTime;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getRewardDuration() {
        return this.rewardDuration;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getAdType() {
        return this.adType;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getMaxShowCount() {
        return this.maxShowCount;
    }

    public final AdInfo copy(String id, String key, String name, String psign, boolean show, long freeTime, long rewardDuration, String adType, int maxShowCount, long preloadInterval, long showInterval, String codeId, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(psign, "psign");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(codeId, "codeId");
        Intrinsics.checkNotNullParameter(description, "description");
        return new AdInfo(id, key, name, psign, show, freeTime, rewardDuration, adType, maxShowCount, preloadInterval, showInterval, codeId, description);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AdInfo)) {
            return false;
        }
        AdInfo adInfo = (AdInfo) other;
        return Intrinsics.areEqual(this.id, adInfo.id) && Intrinsics.areEqual(this.key, adInfo.key) && Intrinsics.areEqual(this.name, adInfo.name) && Intrinsics.areEqual(this.psign, adInfo.psign) && this.show == adInfo.show && this.freeTime == adInfo.freeTime && this.rewardDuration == adInfo.rewardDuration && Intrinsics.areEqual(this.adType, adInfo.adType) && this.maxShowCount == adInfo.maxShowCount && this.preloadInterval == adInfo.preloadInterval && this.showInterval == adInfo.showInterval && Intrinsics.areEqual(this.codeId, adInfo.codeId) && Intrinsics.areEqual(this.description, adInfo.description);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    public int hashCode() {
        int iHashCode = ((((((this.id.hashCode() * 31) + this.key.hashCode()) * 31) + this.name.hashCode()) * 31) + this.psign.hashCode()) * 31;
        boolean z = this.show;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return ((((((((((((((((iHashCode + r1) * 31) + Long.hashCode(this.freeTime)) * 31) + Long.hashCode(this.rewardDuration)) * 31) + this.adType.hashCode()) * 31) + Integer.hashCode(this.maxShowCount)) * 31) + Long.hashCode(this.preloadInterval)) * 31) + Long.hashCode(this.showInterval)) * 31) + this.codeId.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        return "AdInfo(id=" + this.id + ", key=" + this.key + ", name=" + this.name + ", psign=" + this.psign + ", show=" + this.show + ", freeTime=" + this.freeTime + ", rewardDuration=" + this.rewardDuration + ", adType=" + this.adType + ", maxShowCount=" + this.maxShowCount + ", preloadInterval=" + this.preloadInterval + ", showInterval=" + this.showInterval + ", codeId=" + this.codeId + ", description=" + this.description + ")";
    }

    public AdInfo(String id, String key, String name, String psign, boolean z, long j, long j2, String adType, int i, long j3, long j4, String codeId, String description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(psign, "psign");
        Intrinsics.checkNotNullParameter(adType, "adType");
        Intrinsics.checkNotNullParameter(codeId, "codeId");
        Intrinsics.checkNotNullParameter(description, "description");
        this.id = id;
        this.key = key;
        this.name = name;
        this.psign = psign;
        this.show = z;
        this.freeTime = j;
        this.rewardDuration = j2;
        this.adType = adType;
        this.maxShowCount = i;
        this.preloadInterval = j3;
        this.showInterval = j4;
        this.codeId = codeId;
        this.description = description;
    }

    public /* synthetic */ AdInfo(String str, String str2, String str3, String str4, boolean z, long j, long j2, String str5, int i, long j3, long j4, String str6, String str7, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? 0L : j, (i2 & 64) != 0 ? 0L : j2, (i2 & 128) != 0 ? "default" : str5, (i2 & 256) == 0 ? i : 0, (i2 & 512) != 0 ? 0L : j3, (i2 & 1024) != 0 ? 0L : j4, (i2 & 2048) != 0 ? "" : str6, (i2 & 4096) != 0 ? "" : str7);
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getPsign() {
        return this.psign;
    }

    public final void setPsign(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.psign = str;
    }

    public final boolean getShow() {
        return this.show;
    }

    public final void setShow(boolean z) {
        this.show = z;
    }

    public final long getFreeTime() {
        return this.freeTime;
    }

    public final void setFreeTime(long j) {
        this.freeTime = j;
    }

    public final long getRewardDuration() {
        return this.rewardDuration;
    }

    public final void setRewardDuration(long j) {
        this.rewardDuration = j;
    }

    public final String getAdType() {
        return this.adType;
    }

    public final void setAdType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adType = str;
    }

    public final int getMaxShowCount() {
        return this.maxShowCount;
    }

    public final void setMaxShowCount(int i) {
        this.maxShowCount = i;
    }

    public final long getPreloadInterval() {
        return this.preloadInterval;
    }

    public final void setPreloadInterval(long j) {
        this.preloadInterval = j;
    }

    public final long getShowInterval() {
        return this.showInterval;
    }

    public final void setShowInterval(long j) {
        this.showInterval = j;
    }

    public final String getCodeId() {
        return this.codeId;
    }

    public final void setCodeId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.codeId = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }
}
