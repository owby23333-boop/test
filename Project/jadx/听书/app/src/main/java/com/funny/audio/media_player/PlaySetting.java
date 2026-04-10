package com.funny.audio.media_player;

import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PlaySetting.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/funny/audio/media_player/PlaySetting;", "", "playSpeed", "", "skip", "Lcom/funny/audio/media_player/SkipSetting;", "(FLcom/funny/audio/media_player/SkipSetting;)V", "getPlaySpeed", "()F", "setPlaySpeed", "(F)V", "getSkip", "()Lcom/funny/audio/media_player/SkipSetting;", "setSkip", "(Lcom/funny/audio/media_player/SkipSetting;)V", "component1", "component2", "copy", "equals", "", AdnName.OTHER, "hashCode", "", "toString", "", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class PlaySetting {
    private float playSpeed;
    private SkipSetting skip;

    public PlaySetting() {
        this(0.0f, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PlaySetting copy$default(PlaySetting playSetting, float f, SkipSetting skipSetting, int i, Object obj) {
        if ((i & 1) != 0) {
            f = playSetting.playSpeed;
        }
        if ((i & 2) != 0) {
            skipSetting = playSetting.skip;
        }
        return playSetting.copy(f, skipSetting);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final float getPlaySpeed() {
        return this.playSpeed;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final SkipSetting getSkip() {
        return this.skip;
    }

    public final PlaySetting copy(float playSpeed, SkipSetting skip) {
        Intrinsics.checkNotNullParameter(skip, "skip");
        return new PlaySetting(playSpeed, skip);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaySetting)) {
            return false;
        }
        PlaySetting playSetting = (PlaySetting) other;
        return Float.compare(this.playSpeed, playSetting.playSpeed) == 0 && Intrinsics.areEqual(this.skip, playSetting.skip);
    }

    public int hashCode() {
        return (Float.hashCode(this.playSpeed) * 31) + this.skip.hashCode();
    }

    public String toString() {
        return "PlaySetting(playSpeed=" + this.playSpeed + ", skip=" + this.skip + ")";
    }

    public PlaySetting(float f, SkipSetting skip) {
        Intrinsics.checkNotNullParameter(skip, "skip");
        this.playSpeed = f;
        this.skip = skip;
    }

    public final float getPlaySpeed() {
        return this.playSpeed;
    }

    public final void setPlaySpeed(float f) {
        this.playSpeed = f;
    }

    public /* synthetic */ PlaySetting(float f, SkipSetting skipSetting, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 1.0f : f, (i & 2) != 0 ? new SkipSetting(0L, 0L, 3, null) : skipSetting);
    }

    public final SkipSetting getSkip() {
        return this.skip;
    }

    public final void setSkip(SkipSetting skipSetting) {
        Intrinsics.checkNotNullParameter(skipSetting, "<set-?>");
        this.skip = skipSetting;
    }
}
