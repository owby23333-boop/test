package androidx.media3.session;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.Bundleable;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.PlayerInfo;
import com.google.common.base.Objects;

/* JADX INFO: loaded from: classes.dex */
class PlayerInfo implements Bundleable {
    public static final int DISCONTINUITY_REASON_DEFAULT = 0;
    public static final int MEDIA_ITEM_TRANSITION_REASON_DEFAULT = 0;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_DEFAULT = 1;
    public static final int TIMELINE_CHANGE_REASON_DEFAULT = 0;
    public final AudioAttributes audioAttributes;
    public final CueGroup cueGroup;
    public final Tracks currentTracks;
    public final DeviceInfo deviceInfo;
    public final boolean deviceMuted;
    public final int deviceVolume;
    public final int discontinuityReason;
    public final boolean isLoading;
    public final boolean isPlaying;
    public final long maxSeekToPreviousPositionMs;
    public final int mediaItemTransitionReason;
    public final MediaMetadata mediaMetadata;
    public final Player.PositionInfo newPositionInfo;
    public final Player.PositionInfo oldPositionInfo;
    public final boolean playWhenReady;
    public final int playWhenReadyChangeReason;
    public final PlaybackParameters playbackParameters;
    public final int playbackState;
    public final int playbackSuppressionReason;
    public final PlaybackException playerError;
    public final MediaMetadata playlistMetadata;
    public final int repeatMode;
    public final long seekBackIncrementMs;
    public final long seekForwardIncrementMs;
    public final SessionPositionInfo sessionPositionInfo;
    public final boolean shuffleModeEnabled;
    public final Timeline timeline;
    public final int timelineChangeReason;
    public final TrackSelectionParameters trackSelectionParameters;
    public final VideoSize videoSize;
    public final float volume;
    public static final PlayerInfo DEFAULT = new PlayerInfo(null, 0, SessionPositionInfo.DEFAULT, SessionPositionInfo.DEFAULT_POSITION_INFO, SessionPositionInfo.DEFAULT_POSITION_INFO, 0, PlaybackParameters.DEFAULT, 0, false, VideoSize.UNKNOWN, Timeline.EMPTY, 0, MediaMetadata.EMPTY, 1.0f, AudioAttributes.DEFAULT, CueGroup.EMPTY_TIME_ZERO, DeviceInfo.UNKNOWN, 0, false, false, 1, 0, 1, false, false, MediaMetadata.EMPTY, 0, 0, 0, Tracks.EMPTY, TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT);
    private static final String FIELD_PLAYBACK_PARAMETERS = Util.intToStringMaxRadix(1);
    private static final String FIELD_REPEAT_MODE = Util.intToStringMaxRadix(2);
    private static final String FIELD_SHUFFLE_MODE_ENABLED = Util.intToStringMaxRadix(3);
    private static final String FIELD_TIMELINE = Util.intToStringMaxRadix(4);
    private static final String FIELD_VIDEO_SIZE = Util.intToStringMaxRadix(5);
    private static final String FIELD_PLAYLIST_METADATA = Util.intToStringMaxRadix(6);
    private static final String FIELD_VOLUME = Util.intToStringMaxRadix(7);
    private static final String FIELD_AUDIO_ATTRIBUTES = Util.intToStringMaxRadix(8);
    private static final String FIELD_DEVICE_INFO = Util.intToStringMaxRadix(9);
    private static final String FIELD_DEVICE_VOLUME = Util.intToStringMaxRadix(10);
    private static final String FIELD_DEVICE_MUTED = Util.intToStringMaxRadix(11);
    private static final String FIELD_PLAY_WHEN_READY = Util.intToStringMaxRadix(12);
    private static final String FIELD_PLAY_WHEN_READY_CHANGE_REASON = Util.intToStringMaxRadix(13);
    private static final String FIELD_PLAYBACK_SUPPRESSION_REASON = Util.intToStringMaxRadix(14);
    private static final String FIELD_PLAYBACK_STATE = Util.intToStringMaxRadix(15);
    private static final String FIELD_IS_PLAYING = Util.intToStringMaxRadix(16);
    private static final String FIELD_IS_LOADING = Util.intToStringMaxRadix(17);
    private static final String FIELD_PLAYBACK_ERROR = Util.intToStringMaxRadix(18);
    private static final String FIELD_SESSION_POSITION_INFO = Util.intToStringMaxRadix(19);
    private static final String FIELD_MEDIA_ITEM_TRANSITION_REASON = Util.intToStringMaxRadix(20);
    private static final String FIELD_OLD_POSITION_INFO = Util.intToStringMaxRadix(21);
    private static final String FIELD_NEW_POSITION_INFO = Util.intToStringMaxRadix(22);
    private static final String FIELD_DISCONTINUITY_REASON = Util.intToStringMaxRadix(23);
    private static final String FIELD_CUE_GROUP = Util.intToStringMaxRadix(24);
    private static final String FIELD_MEDIA_METADATA = Util.intToStringMaxRadix(25);
    private static final String FIELD_SEEK_BACK_INCREMENT_MS = Util.intToStringMaxRadix(26);
    private static final String FIELD_SEEK_FORWARD_INCREMENT_MS = Util.intToStringMaxRadix(27);
    private static final String FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS = Util.intToStringMaxRadix(28);
    private static final String FIELD_TRACK_SELECTION_PARAMETERS = Util.intToStringMaxRadix(29);
    private static final String FIELD_CURRENT_TRACKS = Util.intToStringMaxRadix(30);
    private static final String FIELD_TIMELINE_CHANGE_REASON = Util.intToStringMaxRadix(31);
    public static final Bundleable.Creator<PlayerInfo> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.PlayerInfo$$ExternalSyntheticLambda0
        @Override // androidx.media3.common.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return PlayerInfo.fromBundle(bundle);
        }
    };

    private boolean isPlaying(int i, boolean z, int i2) {
        return i == 3 && z && i2 == 0;
    }

    public static class BundlingExclusions implements Bundleable {
        public final boolean areCurrentTracksExcluded;
        public final boolean isTimelineExcluded;
        public static final BundlingExclusions NONE = new BundlingExclusions(false, false);
        private static final String FIELD_IS_TIMELINE_EXCLUDED = Util.intToStringMaxRadix(0);
        private static final String FIELD_ARE_CURRENT_TRACKS_EXCLUDED = Util.intToStringMaxRadix(1);
        public static final Bundleable.Creator<BundlingExclusions> CREATOR = new Bundleable.Creator() { // from class: androidx.media3.session.PlayerInfo$BundlingExclusions$$ExternalSyntheticLambda0
            @Override // androidx.media3.common.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                return PlayerInfo.BundlingExclusions.lambda$static$0(bundle);
            }
        };

        public BundlingExclusions(boolean z, boolean z2) {
            this.isTimelineExcluded = z;
            this.areCurrentTracksExcluded = z2;
        }

        @Override // androidx.media3.common.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBoolean(FIELD_IS_TIMELINE_EXCLUDED, this.isTimelineExcluded);
            bundle.putBoolean(FIELD_ARE_CURRENT_TRACKS_EXCLUDED, this.areCurrentTracksExcluded);
            return bundle;
        }

        static /* synthetic */ BundlingExclusions lambda$static$0(Bundle bundle) {
            return new BundlingExclusions(bundle.getBoolean(FIELD_IS_TIMELINE_EXCLUDED, false), bundle.getBoolean(FIELD_ARE_CURRENT_TRACKS_EXCLUDED, false));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BundlingExclusions)) {
                return false;
            }
            BundlingExclusions bundlingExclusions = (BundlingExclusions) obj;
            return this.isTimelineExcluded == bundlingExclusions.isTimelineExcluded && this.areCurrentTracksExcluded == bundlingExclusions.areCurrentTracksExcluded;
        }

        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.isTimelineExcluded), Boolean.valueOf(this.areCurrentTracksExcluded));
        }
    }

    public static class Builder {
        private AudioAttributes audioAttributes;
        private CueGroup cueGroup;
        private Tracks currentTracks;
        private DeviceInfo deviceInfo;
        private boolean deviceMuted;
        private int deviceVolume;
        private int discontinuityReason;
        private boolean isLoading;
        private boolean isPlaying;
        private long maxSeekToPreviousPositionMs;
        private int mediaItemTransitionReason;
        private MediaMetadata mediaMetadata;
        private Player.PositionInfo newPositionInfo;
        private Player.PositionInfo oldPositionInfo;
        private boolean playWhenReady;
        private int playWhenReadyChangeReason;
        private PlaybackParameters playbackParameters;
        private int playbackState;
        private int playbackSuppressionReason;
        private PlaybackException playerError;
        private MediaMetadata playlistMetadata;
        private int repeatMode;
        private long seekBackIncrementMs;
        private long seekForwardIncrementMs;
        private SessionPositionInfo sessionPositionInfo;
        private boolean shuffleModeEnabled;
        private Timeline timeline;
        private int timelineChangeReason;
        private TrackSelectionParameters trackSelectionParameters;
        private VideoSize videoSize;
        private float volume;

        public Builder(PlayerInfo playerInfo) {
            this.playerError = playerInfo.playerError;
            this.mediaItemTransitionReason = playerInfo.mediaItemTransitionReason;
            this.sessionPositionInfo = playerInfo.sessionPositionInfo;
            this.oldPositionInfo = playerInfo.oldPositionInfo;
            this.newPositionInfo = playerInfo.newPositionInfo;
            this.discontinuityReason = playerInfo.discontinuityReason;
            this.playbackParameters = playerInfo.playbackParameters;
            this.repeatMode = playerInfo.repeatMode;
            this.shuffleModeEnabled = playerInfo.shuffleModeEnabled;
            this.timeline = playerInfo.timeline;
            this.timelineChangeReason = playerInfo.timelineChangeReason;
            this.videoSize = playerInfo.videoSize;
            this.playlistMetadata = playerInfo.playlistMetadata;
            this.volume = playerInfo.volume;
            this.audioAttributes = playerInfo.audioAttributes;
            this.cueGroup = playerInfo.cueGroup;
            this.deviceInfo = playerInfo.deviceInfo;
            this.deviceVolume = playerInfo.deviceVolume;
            this.deviceMuted = playerInfo.deviceMuted;
            this.playWhenReady = playerInfo.playWhenReady;
            this.playWhenReadyChangeReason = playerInfo.playWhenReadyChangeReason;
            this.isPlaying = playerInfo.isPlaying;
            this.isLoading = playerInfo.isLoading;
            this.playbackSuppressionReason = playerInfo.playbackSuppressionReason;
            this.playbackState = playerInfo.playbackState;
            this.mediaMetadata = playerInfo.mediaMetadata;
            this.seekBackIncrementMs = playerInfo.seekBackIncrementMs;
            this.seekForwardIncrementMs = playerInfo.seekForwardIncrementMs;
            this.maxSeekToPreviousPositionMs = playerInfo.maxSeekToPreviousPositionMs;
            this.currentTracks = playerInfo.currentTracks;
            this.trackSelectionParameters = playerInfo.trackSelectionParameters;
        }

        public Builder setPlayerError(PlaybackException playbackException) {
            this.playerError = playbackException;
            return this;
        }

        public Builder setMediaItemTransitionReason(int i) {
            this.mediaItemTransitionReason = i;
            return this;
        }

        public Builder setSessionPositionInfo(SessionPositionInfo sessionPositionInfo) {
            this.sessionPositionInfo = sessionPositionInfo;
            return this;
        }

        public Builder setOldPositionInfo(Player.PositionInfo positionInfo) {
            this.oldPositionInfo = positionInfo;
            return this;
        }

        public Builder setNewPositionInfo(Player.PositionInfo positionInfo) {
            this.newPositionInfo = positionInfo;
            return this;
        }

        public Builder setDiscontinuityReason(int i) {
            this.discontinuityReason = i;
            return this;
        }

        public Builder setPlaybackParameters(PlaybackParameters playbackParameters) {
            this.playbackParameters = playbackParameters;
            return this;
        }

        public Builder setRepeatMode(int i) {
            this.repeatMode = i;
            return this;
        }

        public Builder setShuffleModeEnabled(boolean z) {
            this.shuffleModeEnabled = z;
            return this;
        }

        public Builder setTimeline(Timeline timeline) {
            this.timeline = timeline;
            return this;
        }

        public Builder setTimelineChangeReason(int i) {
            this.timelineChangeReason = i;
            return this;
        }

        public Builder setVideoSize(VideoSize videoSize) {
            this.videoSize = videoSize;
            return this;
        }

        public Builder setPlaylistMetadata(MediaMetadata mediaMetadata) {
            this.playlistMetadata = mediaMetadata;
            return this;
        }

        public Builder setVolume(float f) {
            this.volume = f;
            return this;
        }

        public Builder setAudioAttributes(AudioAttributes audioAttributes) {
            this.audioAttributes = audioAttributes;
            return this;
        }

        public Builder setCues(CueGroup cueGroup) {
            this.cueGroup = cueGroup;
            return this;
        }

        public Builder setDeviceInfo(DeviceInfo deviceInfo) {
            this.deviceInfo = deviceInfo;
            return this;
        }

        public Builder setDeviceVolume(int i) {
            this.deviceVolume = i;
            return this;
        }

        public Builder setDeviceMuted(boolean z) {
            this.deviceMuted = z;
            return this;
        }

        public Builder setPlayWhenReady(boolean z) {
            this.playWhenReady = z;
            return this;
        }

        public Builder setPlayWhenReadyChangeReason(int i) {
            this.playWhenReadyChangeReason = i;
            return this;
        }

        public Builder setIsPlaying(boolean z) {
            this.isPlaying = z;
            return this;
        }

        public Builder setIsLoading(boolean z) {
            this.isLoading = z;
            return this;
        }

        public Builder setPlaybackSuppressionReason(int i) {
            this.playbackSuppressionReason = i;
            return this;
        }

        public Builder setPlaybackState(int i) {
            this.playbackState = i;
            return this;
        }

        public Builder setMediaMetadata(MediaMetadata mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
            return this;
        }

        public Builder setSeekBackIncrement(long j) {
            this.seekBackIncrementMs = j;
            return this;
        }

        public Builder setSeekForwardIncrement(long j) {
            this.seekForwardIncrementMs = j;
            return this;
        }

        public Builder setMaxSeekToPreviousPositionMs(long j) {
            this.maxSeekToPreviousPositionMs = j;
            return this;
        }

        public Builder setCurrentTracks(Tracks tracks) {
            this.currentTracks = tracks;
            return this;
        }

        public Builder setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
            this.trackSelectionParameters = trackSelectionParameters;
            return this;
        }

        public PlayerInfo build() {
            Assertions.checkState(this.timeline.isEmpty() || this.sessionPositionInfo.positionInfo.mediaItemIndex < this.timeline.getWindowCount());
            return new PlayerInfo(this.playerError, this.mediaItemTransitionReason, this.sessionPositionInfo, this.oldPositionInfo, this.newPositionInfo, this.discontinuityReason, this.playbackParameters, this.repeatMode, this.shuffleModeEnabled, this.videoSize, this.timeline, this.timelineChangeReason, this.playlistMetadata, this.volume, this.audioAttributes, this.cueGroup, this.deviceInfo, this.deviceVolume, this.deviceMuted, this.playWhenReady, this.playWhenReadyChangeReason, this.playbackSuppressionReason, this.playbackState, this.isPlaying, this.isLoading, this.mediaMetadata, this.seekBackIncrementMs, this.seekForwardIncrementMs, this.maxSeekToPreviousPositionMs, this.currentTracks, this.trackSelectionParameters);
        }
    }

    public PlayerInfo copyWithPlayWhenReady(boolean z, int i, int i2) {
        return new Builder(this).setPlayWhenReady(z).setPlayWhenReadyChangeReason(i).setPlaybackSuppressionReason(i2).setIsPlaying(isPlaying(this.playbackState, z, i2)).build();
    }

    public PlayerInfo copyWithMediaItemTransitionReason(int i) {
        return new Builder(this).setMediaItemTransitionReason(i).build();
    }

    public PlayerInfo copyWithPlayerError(PlaybackException playbackException) {
        return new Builder(this).setPlayerError(playbackException).build();
    }

    public PlayerInfo copyWithPlaybackState(int i, PlaybackException playbackException) {
        return new Builder(this).setPlayerError(playbackException).setPlaybackState(i).setIsPlaying(isPlaying(i, this.playWhenReady, this.playbackSuppressionReason)).build();
    }

    public PlayerInfo copyWithIsPlaying(boolean z) {
        return new Builder(this).setIsPlaying(z).build();
    }

    public PlayerInfo copyWithIsLoading(boolean z) {
        return new Builder(this).setIsLoading(z).build();
    }

    public PlayerInfo copyWithPlaybackParameters(PlaybackParameters playbackParameters) {
        return new Builder(this).setPlaybackParameters(playbackParameters).build();
    }

    public PlayerInfo copyWithPositionInfos(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        return new Builder(this).setOldPositionInfo(positionInfo).setNewPositionInfo(positionInfo2).setDiscontinuityReason(i).build();
    }

    public PlayerInfo copyWithSessionPositionInfo(SessionPositionInfo sessionPositionInfo) {
        return new Builder(this).setSessionPositionInfo(sessionPositionInfo).build();
    }

    public PlayerInfo copyWithTimeline(Timeline timeline) {
        return new Builder(this).setTimeline(timeline).build();
    }

    public PlayerInfo copyWithTimelineAndSessionPositionInfo(Timeline timeline, SessionPositionInfo sessionPositionInfo, int i) {
        return new Builder(this).setTimeline(timeline).setSessionPositionInfo(sessionPositionInfo).setTimelineChangeReason(i).build();
    }

    public PlayerInfo copyWithTimelineAndMediaItemIndex(Timeline timeline, int i, int i2) {
        return new Builder(this).setTimeline(timeline).setTimelineChangeReason(i2).setSessionPositionInfo(new SessionPositionInfo(new Player.PositionInfo(this.sessionPositionInfo.positionInfo.windowUid, i, this.sessionPositionInfo.positionInfo.mediaItem, this.sessionPositionInfo.positionInfo.periodUid, this.sessionPositionInfo.positionInfo.periodIndex, this.sessionPositionInfo.positionInfo.positionMs, this.sessionPositionInfo.positionInfo.contentPositionMs, this.sessionPositionInfo.positionInfo.adGroupIndex, this.sessionPositionInfo.positionInfo.adIndexInAdGroup), this.sessionPositionInfo.isPlayingAd, SystemClock.elapsedRealtime(), this.sessionPositionInfo.durationMs, this.sessionPositionInfo.bufferedPositionMs, this.sessionPositionInfo.bufferedPercentage, this.sessionPositionInfo.totalBufferedDurationMs, this.sessionPositionInfo.currentLiveOffsetMs, this.sessionPositionInfo.contentDurationMs, this.sessionPositionInfo.contentBufferedPositionMs)).build();
    }

    public PlayerInfo copyWithPlaylistMetadata(MediaMetadata mediaMetadata) {
        return new Builder(this).setPlaylistMetadata(mediaMetadata).build();
    }

    public PlayerInfo copyWithRepeatMode(int i) {
        return new Builder(this).setRepeatMode(i).build();
    }

    public PlayerInfo copyWithShuffleModeEnabled(boolean z) {
        return new Builder(this).setShuffleModeEnabled(z).build();
    }

    public PlayerInfo copyWithAudioAttributes(AudioAttributes audioAttributes) {
        return new Builder(this).setAudioAttributes(audioAttributes).build();
    }

    public PlayerInfo copyWithVideoSize(VideoSize videoSize) {
        return new Builder(this).setVideoSize(videoSize).build();
    }

    public PlayerInfo copyWithVolume(float f) {
        return new Builder(this).setVolume(f).build();
    }

    public PlayerInfo copyWithDeviceInfo(DeviceInfo deviceInfo) {
        return new Builder(this).setDeviceInfo(deviceInfo).build();
    }

    public PlayerInfo copyWithDeviceVolume(int i, boolean z) {
        return new Builder(this).setDeviceVolume(i).setDeviceMuted(z).build();
    }

    public PlayerInfo copyWithMediaMetadata(MediaMetadata mediaMetadata) {
        return new Builder(this).setMediaMetadata(mediaMetadata).build();
    }

    public PlayerInfo copyWithSeekBackIncrement(long j) {
        return new Builder(this).setSeekBackIncrement(j).build();
    }

    public PlayerInfo copyWithSeekForwardIncrement(long j) {
        return new Builder(this).setSeekForwardIncrement(j).build();
    }

    public PlayerInfo copyWithMaxSeekToPreviousPositionMs(long j) {
        return new Builder(this).setMaxSeekToPreviousPositionMs(j).build();
    }

    public PlayerInfo copyWithCurrentTracks(Tracks tracks) {
        return new Builder(this).setCurrentTracks(tracks).build();
    }

    public PlayerInfo copyWithTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        return new Builder(this).setTrackSelectionParameters(trackSelectionParameters).build();
    }

    public PlayerInfo(PlaybackException playbackException, int i, SessionPositionInfo sessionPositionInfo, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2, PlaybackParameters playbackParameters, int i3, boolean z, VideoSize videoSize, Timeline timeline, int i4, MediaMetadata mediaMetadata, float f, AudioAttributes audioAttributes, CueGroup cueGroup, DeviceInfo deviceInfo, int i5, boolean z2, boolean z3, int i6, int i7, int i8, boolean z4, boolean z5, MediaMetadata mediaMetadata2, long j, long j2, long j3, Tracks tracks, TrackSelectionParameters trackSelectionParameters) {
        this.playerError = playbackException;
        this.mediaItemTransitionReason = i;
        this.sessionPositionInfo = sessionPositionInfo;
        this.oldPositionInfo = positionInfo;
        this.newPositionInfo = positionInfo2;
        this.discontinuityReason = i2;
        this.playbackParameters = playbackParameters;
        this.repeatMode = i3;
        this.shuffleModeEnabled = z;
        this.videoSize = videoSize;
        this.timeline = timeline;
        this.timelineChangeReason = i4;
        this.playlistMetadata = mediaMetadata;
        this.volume = f;
        this.audioAttributes = audioAttributes;
        this.cueGroup = cueGroup;
        this.deviceInfo = deviceInfo;
        this.deviceVolume = i5;
        this.deviceMuted = z2;
        this.playWhenReady = z3;
        this.playWhenReadyChangeReason = i6;
        this.playbackSuppressionReason = i7;
        this.playbackState = i8;
        this.isPlaying = z4;
        this.isLoading = z5;
        this.mediaMetadata = mediaMetadata2;
        this.seekBackIncrementMs = j;
        this.seekForwardIncrementMs = j2;
        this.maxSeekToPreviousPositionMs = j3;
        this.currentTracks = tracks;
        this.trackSelectionParameters = trackSelectionParameters;
    }

    public MediaItem getCurrentMediaItem() {
        if (this.timeline.isEmpty()) {
            return null;
        }
        return this.timeline.getWindow(this.sessionPositionInfo.positionInfo.mediaItemIndex, new Timeline.Window()).mediaItem;
    }

    public Bundle toBundle(Player.Commands commands, boolean z, boolean z2) {
        Bundle bundle = new Bundle();
        boolean zContains = commands.contains(16);
        boolean zContains2 = commands.contains(17);
        PlaybackException playbackException = this.playerError;
        if (playbackException != null) {
            bundle.putBundle(FIELD_PLAYBACK_ERROR, playbackException.toBundle());
        }
        bundle.putInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, this.mediaItemTransitionReason);
        bundle.putBundle(FIELD_SESSION_POSITION_INFO, this.sessionPositionInfo.toBundle(zContains, zContains2));
        bundle.putBundle(FIELD_OLD_POSITION_INFO, this.oldPositionInfo.toBundle(zContains, zContains2));
        bundle.putBundle(FIELD_NEW_POSITION_INFO, this.newPositionInfo.toBundle(zContains, zContains2));
        bundle.putInt(FIELD_DISCONTINUITY_REASON, this.discontinuityReason);
        bundle.putBundle(FIELD_PLAYBACK_PARAMETERS, this.playbackParameters.toBundle());
        bundle.putInt(FIELD_REPEAT_MODE, this.repeatMode);
        bundle.putBoolean(FIELD_SHUFFLE_MODE_ENABLED, this.shuffleModeEnabled);
        if (!z && zContains2) {
            bundle.putBundle(FIELD_TIMELINE, this.timeline.toBundle());
        } else if (!zContains2 && zContains && !this.timeline.isEmpty()) {
            bundle.putBundle(FIELD_TIMELINE, this.timeline.toBundleWithOneWindowOnly(this.sessionPositionInfo.positionInfo.mediaItemIndex));
        }
        bundle.putInt(FIELD_TIMELINE_CHANGE_REASON, this.timelineChangeReason);
        bundle.putBundle(FIELD_VIDEO_SIZE, this.videoSize.toBundle());
        if (commands.contains(18)) {
            bundle.putBundle(FIELD_PLAYLIST_METADATA, this.playlistMetadata.toBundle());
        }
        if (commands.contains(22)) {
            bundle.putFloat(FIELD_VOLUME, this.volume);
        }
        if (commands.contains(21)) {
            bundle.putBundle(FIELD_AUDIO_ATTRIBUTES, this.audioAttributes.toBundle());
        }
        if (commands.contains(28)) {
            bundle.putBundle(FIELD_CUE_GROUP, this.cueGroup.toBundle());
        }
        bundle.putBundle(FIELD_DEVICE_INFO, this.deviceInfo.toBundle());
        if (commands.contains(23)) {
            bundle.putInt(FIELD_DEVICE_VOLUME, this.deviceVolume);
            bundle.putBoolean(FIELD_DEVICE_MUTED, this.deviceMuted);
        }
        bundle.putBoolean(FIELD_PLAY_WHEN_READY, this.playWhenReady);
        bundle.putInt(FIELD_PLAYBACK_SUPPRESSION_REASON, this.playbackSuppressionReason);
        bundle.putInt(FIELD_PLAYBACK_STATE, this.playbackState);
        bundle.putBoolean(FIELD_IS_PLAYING, this.isPlaying);
        bundle.putBoolean(FIELD_IS_LOADING, this.isLoading);
        if (commands.contains(18)) {
            bundle.putBundle(FIELD_MEDIA_METADATA, this.mediaMetadata.toBundle());
        }
        bundle.putLong(FIELD_SEEK_BACK_INCREMENT_MS, this.seekBackIncrementMs);
        bundle.putLong(FIELD_SEEK_FORWARD_INCREMENT_MS, this.seekForwardIncrementMs);
        bundle.putLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, this.maxSeekToPreviousPositionMs);
        if (!z2 && commands.contains(30)) {
            bundle.putBundle(FIELD_CURRENT_TRACKS, this.currentTracks.toBundle());
        }
        bundle.putBundle(FIELD_TRACK_SELECTION_PARAMETERS, this.trackSelectionParameters.toBundle());
        return bundle;
    }

    @Override // androidx.media3.common.Bundleable
    public Bundle toBundle() {
        return toBundle(new Player.Commands.Builder().addAllCommands().build(), false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static PlayerInfo fromBundle(Bundle bundle) {
        SessionPositionInfo sessionPositionInfo;
        Player.PositionInfo positionInfo;
        Player.PositionInfo positionInfo2;
        PlaybackParameters playbackParameters;
        MediaMetadata mediaMetadata;
        float f;
        AudioAttributes audioAttributes;
        AudioAttributes audioAttributes2;
        CueGroup cueGroup;
        CueGroup cueGroup2;
        DeviceInfo deviceInfo;
        boolean z;
        MediaMetadata mediaMetadata2;
        TrackSelectionParameters trackSelectionParametersFromBundle;
        Bundle bundle2 = bundle.getBundle(FIELD_PLAYBACK_ERROR);
        PlaybackException playbackException = bundle2 == null ? null : (PlaybackException) PlaybackException.CREATOR.fromBundle(bundle2);
        int i = bundle.getInt(FIELD_MEDIA_ITEM_TRANSITION_REASON, 0);
        Bundle bundle3 = bundle.getBundle(FIELD_SESSION_POSITION_INFO);
        if (bundle3 == null) {
            sessionPositionInfo = SessionPositionInfo.DEFAULT;
        } else {
            sessionPositionInfo = (SessionPositionInfo) SessionPositionInfo.CREATOR.fromBundle(bundle3);
        }
        SessionPositionInfo sessionPositionInfo2 = sessionPositionInfo;
        Bundle bundle4 = bundle.getBundle(FIELD_OLD_POSITION_INFO);
        if (bundle4 == null) {
            positionInfo = SessionPositionInfo.DEFAULT_POSITION_INFO;
        } else {
            positionInfo = (Player.PositionInfo) Player.PositionInfo.CREATOR.fromBundle(bundle4);
        }
        Player.PositionInfo positionInfo3 = positionInfo;
        Bundle bundle5 = bundle.getBundle(FIELD_NEW_POSITION_INFO);
        if (bundle5 == null) {
            positionInfo2 = SessionPositionInfo.DEFAULT_POSITION_INFO;
        } else {
            positionInfo2 = (Player.PositionInfo) Player.PositionInfo.CREATOR.fromBundle(bundle5);
        }
        Player.PositionInfo positionInfo4 = positionInfo2;
        int i2 = bundle.getInt(FIELD_DISCONTINUITY_REASON, 0);
        Bundle bundle6 = bundle.getBundle(FIELD_PLAYBACK_PARAMETERS);
        if (bundle6 == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        } else {
            playbackParameters = (PlaybackParameters) PlaybackParameters.CREATOR.fromBundle(bundle6);
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        int i3 = bundle.getInt(FIELD_REPEAT_MODE, 0);
        boolean z2 = bundle.getBoolean(FIELD_SHUFFLE_MODE_ENABLED, false);
        Bundle bundle7 = bundle.getBundle(FIELD_TIMELINE);
        Timeline timeline = bundle7 == null ? Timeline.EMPTY : (Timeline) Timeline.CREATOR.fromBundle(bundle7);
        int i4 = bundle.getInt(FIELD_TIMELINE_CHANGE_REASON, 0);
        Bundle bundle8 = bundle.getBundle(FIELD_VIDEO_SIZE);
        VideoSize videoSize = bundle8 == null ? VideoSize.UNKNOWN : (VideoSize) VideoSize.CREATOR.fromBundle(bundle8);
        Bundle bundle9 = bundle.getBundle(FIELD_PLAYLIST_METADATA);
        if (bundle9 == null) {
            mediaMetadata = MediaMetadata.EMPTY;
        } else {
            mediaMetadata = (MediaMetadata) MediaMetadata.CREATOR.fromBundle(bundle9);
        }
        MediaMetadata mediaMetadata3 = mediaMetadata;
        float f2 = bundle.getFloat(FIELD_VOLUME, 1.0f);
        Bundle bundle10 = bundle.getBundle(FIELD_AUDIO_ATTRIBUTES);
        if (bundle10 == null) {
            f = f2;
            audioAttributes = AudioAttributes.DEFAULT;
        } else {
            f = f2;
            audioAttributes = (AudioAttributes) AudioAttributes.CREATOR.fromBundle(bundle10);
        }
        Bundle bundle11 = bundle.getBundle(FIELD_CUE_GROUP);
        if (bundle11 == null) {
            audioAttributes2 = audioAttributes;
            cueGroup = CueGroup.EMPTY_TIME_ZERO;
        } else {
            audioAttributes2 = audioAttributes;
            cueGroup = (CueGroup) CueGroup.CREATOR.fromBundle(bundle11);
        }
        Bundle bundle12 = bundle.getBundle(FIELD_DEVICE_INFO);
        if (bundle12 == null) {
            cueGroup2 = cueGroup;
            deviceInfo = DeviceInfo.UNKNOWN;
        } else {
            cueGroup2 = cueGroup;
            deviceInfo = (DeviceInfo) DeviceInfo.CREATOR.fromBundle(bundle12);
        }
        DeviceInfo deviceInfo2 = deviceInfo;
        int i5 = bundle.getInt(FIELD_DEVICE_VOLUME, 0);
        boolean z3 = bundle.getBoolean(FIELD_DEVICE_MUTED, false);
        boolean z4 = bundle.getBoolean(FIELD_PLAY_WHEN_READY, false);
        int i6 = bundle.getInt(FIELD_PLAY_WHEN_READY_CHANGE_REASON, 1);
        int i7 = bundle.getInt(FIELD_PLAYBACK_SUPPRESSION_REASON, 0);
        int i8 = bundle.getInt(FIELD_PLAYBACK_STATE, 1);
        boolean z5 = bundle.getBoolean(FIELD_IS_PLAYING, false);
        boolean z6 = bundle.getBoolean(FIELD_IS_LOADING, false);
        Bundle bundle13 = bundle.getBundle(FIELD_MEDIA_METADATA);
        if (bundle13 == null) {
            z = z6;
            mediaMetadata2 = MediaMetadata.EMPTY;
        } else {
            z = z6;
            mediaMetadata2 = (MediaMetadata) MediaMetadata.CREATOR.fromBundle(bundle13);
        }
        long j = bundle.getLong(FIELD_SEEK_BACK_INCREMENT_MS, 0L);
        long j2 = bundle.getLong(FIELD_SEEK_FORWARD_INCREMENT_MS, 0L);
        long j3 = bundle.getLong(FIELD_MAX_SEEK_TO_PREVIOUS_POSITION_MS, 0L);
        Bundle bundle14 = bundle.getBundle(FIELD_CURRENT_TRACKS);
        Tracks tracks = bundle14 == null ? Tracks.EMPTY : (Tracks) Tracks.CREATOR.fromBundle(bundle14);
        Bundle bundle15 = bundle.getBundle(FIELD_TRACK_SELECTION_PARAMETERS);
        if (bundle15 == null) {
            trackSelectionParametersFromBundle = TrackSelectionParameters.DEFAULT_WITHOUT_CONTEXT;
        } else {
            trackSelectionParametersFromBundle = TrackSelectionParameters.fromBundle(bundle15);
        }
        return new PlayerInfo(playbackException, i, sessionPositionInfo2, positionInfo3, positionInfo4, i2, playbackParameters2, i3, z2, videoSize, timeline, i4, mediaMetadata3, f, audioAttributes2, cueGroup2, deviceInfo2, i5, z3, z4, i6, i7, i8, z5, z, mediaMetadata2, j, j2, j3, tracks, trackSelectionParametersFromBundle);
    }
}
