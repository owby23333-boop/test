package com.duokan.bean;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.dangdang.common.PubReadConstant;
import com.yuewen.so2;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/duokan/bean/VipPopConfig;", "Ljava/io/Serializable;", PubReadConstant.JSONK_READ_START_TIME, "", PubReadConstant.JSONK_READ_END_TIME, "isShow", "", "(JJZ)V", "getEndTime", "()J", "setEndTime", "(J)V", "()Z", "setShow", "(Z)V", "getStartTime", "setStartTime", "component1", "component2", "component3", so2.od, "equals", "other", "", TTDownloadField.TT_HASHCODE, "", "toString", "", "network_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class VipPopConfig implements Serializable {
    private long endTime;
    private boolean isShow;
    private long startTime;

    public VipPopConfig() {
        this(0L, 0L, false, 7, null);
    }

    public static /* synthetic */ VipPopConfig copy$default(VipPopConfig vipPopConfig, long j, long j2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            j = vipPopConfig.startTime;
        }
        long j3 = j;
        if ((i & 2) != 0) {
            j2 = vipPopConfig.endTime;
        }
        long j4 = j2;
        if ((i & 4) != 0) {
            z = vipPopConfig.isShow;
        }
        return vipPopConfig.copy(j3, j4, z);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    @NotNull
    public final VipPopConfig copy(long startTime, long endTime, boolean isShow) {
        return new VipPopConfig(startTime, endTime, isShow);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VipPopConfig)) {
            return false;
        }
        VipPopConfig vipPopConfig = (VipPopConfig) other;
        return this.startTime == vipPopConfig.startTime && this.endTime == vipPopConfig.endTime && this.isShow == vipPopConfig.isShow;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((Long.hashCode(this.startTime) * 31) + Long.hashCode(this.endTime)) * 31;
        boolean z = this.isShow;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setEndTime(long j) {
        this.endTime = j;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void setStartTime(long j) {
        this.startTime = j;
    }

    @NotNull
    public String toString() {
        return "VipPopConfig(startTime=" + this.startTime + ", endTime=" + this.endTime + ", isShow=" + this.isShow + ")";
    }

    public VipPopConfig(long j, long j2, boolean z) {
        this.startTime = j;
        this.endTime = j2;
        this.isShow = z;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ VipPopConfig(long j, long j2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        long j3 = (i & 1) != 0 ? 0L : j;
        long j4 = (i & 2) == 0 ? j2 : 0L;
        if ((i & 4) != 0) {
            long j5 = 1 + j3;
            long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
            z = j5 <= jCurrentTimeMillis && jCurrentTimeMillis < j4;
        }
        this(j3, j4, z);
    }
}
