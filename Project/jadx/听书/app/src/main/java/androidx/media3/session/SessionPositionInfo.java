package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;

/* JADX INFO: loaded from: classes.dex */
final class SessionPositionInfo implements Bundleable {
    public static final Bundleable.Creator<SessionPositionInfo> CREATOR;
    public static final SessionPositionInfo DEFAULT;
    public static final Player.PositionInfo DEFAULT_POSITION_INFO;
    private static final String FIELD_BUFFERED_PERCENTAGE;
    private static final String FIELD_BUFFERED_POSITION_MS;
    private static final String FIELD_CONTENT_BUFFERED_POSITION_MS;
    private static final String FIELD_CONTENT_DURATION_MS;
    private static final String FIELD_CURRENT_LIVE_OFFSET_MS;
    private static final String FIELD_DURATION_MS;
    private static final String FIELD_EVENT_TIME_MS;
    private static final String FIELD_IS_PLAYING_AD;
    private static final String FIELD_POSITION_INFO;
    private static final String FIELD_TOTAL_BUFFERED_DURATION_MS;
    public final int bufferedPercentage;
    public final long bufferedPositionMs;
    public final long contentBufferedPositionMs;
    public final long contentDurationMs;
    public final long currentLiveOffsetMs;
    public final long durationMs;
    public final long eventTimeMs;
    public final boolean isPlayingAd;
    public final Player.PositionInfo positionInfo;
    public final long totalBufferedDurationMs;

    static {
        Player.PositionInfo positionInfo = new Player.PositionInfo(null, 0, null, null, 0, 0L, 0L, -1, -1);
        DEFAULT_POSITION_INFO = positionInfo;
        DEFAULT = new SessionPositionInfo(positionInfo, false, -9223372036854775807L, -9223372036854775807L, 0L, 0, 0L, -9223372036854775807L, -9223372036854775807L, 0L);
        FIELD_POSITION_INFO = Util.intToStringMaxRadix(0);
        FIELD_IS_PLAYING_AD = Util.intToStringMaxRadix(1);
        FIELD_EVENT_TIME_MS = Util.intToStringMaxRadix(2);
        FIELD_DURATION_MS = Util.intToStringMaxRadix(3);
        FIELD_BUFFERED_POSITION_MS = Util.intToStringMaxRadix(4);
        FIELD_BUFFERED_PERCENTAGE = Util.intToStringMaxRadix(5);
        FIELD_TOTAL_BUFFERED_DURATION_MS = Util.intToStringMaxRadix(6);
        FIELD_CURRENT_LIVE_OFFSET_MS = Util.intToStringMaxRadix(7);
        FIELD_CONTENT_DURATION_MS = Util.intToStringMaxRadix(8);
        FIELD_CONTENT_BUFFERED_POSITION_MS = Util.intToStringMaxRadix(9);
        CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.SessionPositionInfo$$ExternalSyntheticLambda0
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                return SessionPositionInfo.fromBundle(bundle);
            }
        };
    }

    public SessionPositionInfo(Player.PositionInfo positionInfo, boolean z, long j, long j2, long j3, int i, long j4, long j5, long j6, long j7) {
        Assertions.checkArgument(z == (positionInfo.adGroupIndex != -1));
        this.positionInfo = positionInfo;
        this.isPlayingAd = z;
        this.eventTimeMs = j;
        this.durationMs = j2;
        this.bufferedPositionMs = j3;
        this.bufferedPercentage = i;
        this.totalBufferedDurationMs = j4;
        this.currentLiveOffsetMs = j5;
        this.contentDurationMs = j6;
        this.contentBufferedPositionMs = j7;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SessionPositionInfo sessionPositionInfo = (SessionPositionInfo) obj;
        return this.positionInfo.equals(sessionPositionInfo.positionInfo) && this.isPlayingAd == sessionPositionInfo.isPlayingAd && this.eventTimeMs == sessionPositionInfo.eventTimeMs && this.durationMs == sessionPositionInfo.durationMs && this.bufferedPositionMs == sessionPositionInfo.bufferedPositionMs && this.bufferedPercentage == sessionPositionInfo.bufferedPercentage && this.totalBufferedDurationMs == sessionPositionInfo.totalBufferedDurationMs && this.currentLiveOffsetMs == sessionPositionInfo.currentLiveOffsetMs && this.contentDurationMs == sessionPositionInfo.contentDurationMs && this.contentBufferedPositionMs == sessionPositionInfo.contentBufferedPositionMs;
    }

    public int hashCode() {
        return Objects.hashCode(this.positionInfo, Boolean.valueOf(this.isPlayingAd));
    }

    public String toString() {
        return "SessionPositionInfo {PositionInfo {mediaItemIndex=" + this.positionInfo.mediaItemIndex + ", periodIndex=" + this.positionInfo.periodIndex + ", positionMs=" + this.positionInfo.positionMs + ", contentPositionMs=" + this.positionInfo.contentPositionMs + ", adGroupIndex=" + this.positionInfo.adGroupIndex + ", adIndexInAdGroup=" + this.positionInfo.adIndexInAdGroup + "}, isPlayingAd=" + this.isPlayingAd + ", eventTimeMs=" + this.eventTimeMs + ", durationMs=" + this.durationMs + ", bufferedPositionMs=" + this.bufferedPositionMs + ", bufferedPercentage=" + this.bufferedPercentage + ", totalBufferedDurationMs=" + this.totalBufferedDurationMs + ", currentLiveOffsetMs=" + this.currentLiveOffsetMs + ", contentDurationMs=" + this.contentDurationMs + ", contentBufferedPositionMs=" + this.contentBufferedPositionMs + "}";
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        return toBundle(true, true);
    }

    public Bundle toBundle(boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        bundle.putBundle(FIELD_POSITION_INFO, this.positionInfo.toBundle(z, z2));
        bundle.putBoolean(FIELD_IS_PLAYING_AD, z && this.isPlayingAd);
        bundle.putLong(FIELD_EVENT_TIME_MS, this.eventTimeMs);
        bundle.putLong(FIELD_DURATION_MS, z ? this.durationMs : -9223372036854775807L);
        bundle.putLong(FIELD_BUFFERED_POSITION_MS, z ? this.bufferedPositionMs : 0L);
        bundle.putInt(FIELD_BUFFERED_PERCENTAGE, z ? this.bufferedPercentage : 0);
        bundle.putLong(FIELD_TOTAL_BUFFERED_DURATION_MS, z ? this.totalBufferedDurationMs : 0L);
        bundle.putLong(FIELD_CURRENT_LIVE_OFFSET_MS, z ? this.currentLiveOffsetMs : -9223372036854775807L);
        bundle.putLong(FIELD_CONTENT_DURATION_MS, z ? this.contentDurationMs : -9223372036854775807L);
        bundle.putLong(FIELD_CONTENT_BUFFERED_POSITION_MS, z ? this.contentBufferedPositionMs : 0L);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SessionPositionInfo fromBundle(Bundle bundle) {
        Player.PositionInfo positionInfo;
        Bundle bundle2 = bundle.getBundle(FIELD_POSITION_INFO);
        if (bundle2 == null) {
            positionInfo = DEFAULT_POSITION_INFO;
        } else {
            positionInfo = (Player.PositionInfo) Player.PositionInfo.CREATOR.fromBundle(bundle2);
        }
        return new SessionPositionInfo(positionInfo, bundle.getBoolean(FIELD_IS_PLAYING_AD, false), bundle.getLong(FIELD_EVENT_TIME_MS, -9223372036854775807L), bundle.getLong(FIELD_DURATION_MS, -9223372036854775807L), bundle.getLong(FIELD_BUFFERED_POSITION_MS, 0L), bundle.getInt(FIELD_BUFFERED_PERCENTAGE, 0), bundle.getLong(FIELD_TOTAL_BUFFERED_DURATION_MS, 0L), bundle.getLong(FIELD_CURRENT_LIVE_OFFSET_MS, -9223372036854775807L), bundle.getLong(FIELD_CONTENT_DURATION_MS, -9223372036854775807L), bundle.getLong(FIELD_CONTENT_BUFFERED_POSITION_MS, 0L));
    }
}
