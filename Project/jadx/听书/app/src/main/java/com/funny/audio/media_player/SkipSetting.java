package com.funny.audio.media_player;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PlaySetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/funny/audio/media_player/SkipSetting;", "", "skipStart", "", "skipEnd", "(JJ)V", "getSkipEnd", "()J", "setSkipEnd", "(J)V", "getSkipStart", "setSkipStart", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SkipSetting {
    private long skipEnd;
    private long skipStart;

    public SkipSetting() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ SkipSetting copy$default(SkipSetting skipSetting, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = skipSetting.skipStart;
        }
        if ((i & 2) != 0) {
            j2 = skipSetting.skipEnd;
        }
        return skipSetting.copy(j, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getSkipStart() {
        return this.skipStart;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getSkipEnd() {
        return this.skipEnd;
    }

    public final SkipSetting copy(long skipStart, long skipEnd) {
        return new SkipSetting(skipStart, skipEnd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkipSetting)) {
            return false;
        }
        SkipSetting skipSetting = (SkipSetting) other;
        return this.skipStart == skipSetting.skipStart && this.skipEnd == skipSetting.skipEnd;
    }

    public int hashCode() {
        return (Long.hashCode(this.skipStart) * 31) + Long.hashCode(this.skipEnd);
    }

    public String toString() {
        return "SkipSetting(skipStart=" + this.skipStart + ", skipEnd=" + this.skipEnd + ")";
    }

    public SkipSetting(long j, long j2) {
        this.skipStart = j;
        this.skipEnd = j2;
    }

    public /* synthetic */ SkipSetting(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }

    public final long getSkipStart() {
        return this.skipStart;
    }

    public final void setSkipStart(long j) {
        this.skipStart = j;
    }

    public final long getSkipEnd() {
        return this.skipEnd;
    }

    public final void setSkipEnd(long j) {
        this.skipEnd = j;
    }
}
