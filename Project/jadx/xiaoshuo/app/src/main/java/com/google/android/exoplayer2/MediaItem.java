package com.google.android.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes7.dex */
public final class MediaItem implements Bundleable {
    public static final Bundleable.Creator<MediaItem> CREATOR = new Bundleable.Creator() { // from class: com.yuewen.vw1
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable fromBundle(Bundle bundle) {
            return MediaItem.fromBundle(bundle);
        }
    };
    public static final String DEFAULT_MEDIA_ID = "";
    private static final int FIELD_CLIPPING_PROPERTIES = 3;
    private static final int FIELD_LIVE_CONFIGURATION = 1;
    private static final int FIELD_MEDIA_ID = 0;
    private static final int FIELD_MEDIA_METADATA = 2;
    public final ClippingProperties clippingProperties;
    public final LiveConfiguration liveConfiguration;
    public final String mediaId;
    public final MediaMetadata mediaMetadata;

    @Nullable
    public final PlaybackProperties playbackProperties;

    public static final class AdsConfiguration {
        public final Uri adTagUri;

        @Nullable
        public final Object adsId;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AdsConfiguration)) {
                return false;
            }
            AdsConfiguration adsConfiguration = (AdsConfiguration) obj;
            return this.adTagUri.equals(adsConfiguration.adTagUri) && Util.areEqual(this.adsId, adsConfiguration.adsId);
        }

        public int hashCode() {
            int iHashCode = this.adTagUri.hashCode() * 31;
            Object obj = this.adsId;
            return iHashCode + (obj != null ? obj.hashCode() : 0);
        }

        private AdsConfiguration(Uri uri, @Nullable Object obj) {
            this.adTagUri = uri;
            this.adsId = obj;
        }
    }

    public static final class Builder {

        @Nullable
        private Uri adTagUri;

        @Nullable
        private Object adsId;
        private long clipEndPositionMs;
        private boolean clipRelativeToDefaultPosition;
        private boolean clipRelativeToLiveWindow;
        private long clipStartPositionMs;
        private boolean clipStartsAtKeyFrame;

        @Nullable
        private String customCacheKey;
        private boolean drmForceDefaultLicenseUri;

        @Nullable
        private byte[] drmKeySetId;
        private Map<String, String> drmLicenseRequestHeaders;

        @Nullable
        private Uri drmLicenseUri;
        private boolean drmMultiSession;
        private boolean drmPlayClearContentWithoutKey;
        private List<Integer> drmSessionForClearTypes;

        @Nullable
        private UUID drmUuid;
        private long liveMaxOffsetMs;
        private float liveMaxPlaybackSpeed;
        private long liveMinOffsetMs;
        private float liveMinPlaybackSpeed;
        private long liveTargetOffsetMs;

        @Nullable
        private String mediaId;

        @Nullable
        private MediaMetadata mediaMetadata;

        @Nullable
        private String mimeType;
        private List<StreamKey> streamKeys;
        private List<Subtitle> subtitles;

        @Nullable
        private Object tag;

        @Nullable
        private Uri uri;

        public MediaItem build() {
            PlaybackProperties playbackProperties;
            Assertions.checkState(this.drmLicenseUri == null || this.drmUuid != null);
            Uri uri = this.uri;
            if (uri != null) {
                String str = this.mimeType;
                UUID uuid = this.drmUuid;
                DrmConfiguration drmConfiguration = uuid != null ? new DrmConfiguration(uuid, this.drmLicenseUri, this.drmLicenseRequestHeaders, this.drmMultiSession, this.drmForceDefaultLicenseUri, this.drmPlayClearContentWithoutKey, this.drmSessionForClearTypes, this.drmKeySetId) : null;
                Uri uri2 = this.adTagUri;
                playbackProperties = new PlaybackProperties(uri, str, drmConfiguration, uri2 != null ? new AdsConfiguration(uri2, this.adsId) : null, this.streamKeys, this.customCacheKey, this.subtitles, this.tag);
            } else {
                playbackProperties = null;
            }
            String str2 = this.mediaId;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            ClippingProperties clippingProperties = new ClippingProperties(this.clipStartPositionMs, this.clipEndPositionMs, this.clipRelativeToLiveWindow, this.clipRelativeToDefaultPosition, this.clipStartsAtKeyFrame);
            LiveConfiguration liveConfiguration = new LiveConfiguration(this.liveTargetOffsetMs, this.liveMinOffsetMs, this.liveMaxOffsetMs, this.liveMinPlaybackSpeed, this.liveMaxPlaybackSpeed);
            MediaMetadata mediaMetadata = this.mediaMetadata;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.EMPTY;
            }
            return new MediaItem(str3, clippingProperties, playbackProperties, liveConfiguration, mediaMetadata);
        }

        public Builder setAdTagUri(@Nullable String str) {
            return setAdTagUri(str != null ? Uri.parse(str) : null);
        }

        public Builder setClipEndPositionMs(long j) {
            Assertions.checkArgument(j == Long.MIN_VALUE || j >= 0);
            this.clipEndPositionMs = j;
            return this;
        }

        public Builder setClipRelativeToDefaultPosition(boolean z) {
            this.clipRelativeToDefaultPosition = z;
            return this;
        }

        public Builder setClipRelativeToLiveWindow(boolean z) {
            this.clipRelativeToLiveWindow = z;
            return this;
        }

        public Builder setClipStartPositionMs(long j) {
            Assertions.checkArgument(j >= 0);
            this.clipStartPositionMs = j;
            return this;
        }

        public Builder setClipStartsAtKeyFrame(boolean z) {
            this.clipStartsAtKeyFrame = z;
            return this;
        }

        public Builder setCustomCacheKey(@Nullable String str) {
            this.customCacheKey = str;
            return this;
        }

        public Builder setDrmForceDefaultLicenseUri(boolean z) {
            this.drmForceDefaultLicenseUri = z;
            return this;
        }

        public Builder setDrmKeySetId(@Nullable byte[] bArr) {
            this.drmKeySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
            return this;
        }

        public Builder setDrmLicenseRequestHeaders(@Nullable Map<String, String> map) {
            this.drmLicenseRequestHeaders = (map == null || map.isEmpty()) ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap(map));
            return this;
        }

        public Builder setDrmLicenseUri(@Nullable Uri uri) {
            this.drmLicenseUri = uri;
            return this;
        }

        public Builder setDrmMultiSession(boolean z) {
            this.drmMultiSession = z;
            return this;
        }

        public Builder setDrmPlayClearContentWithoutKey(boolean z) {
            this.drmPlayClearContentWithoutKey = z;
            return this;
        }

        public Builder setDrmSessionForClearPeriods(boolean z) {
            setDrmSessionForClearTypes(z ? Arrays.asList(2, 1) : Collections.emptyList());
            return this;
        }

        public Builder setDrmSessionForClearTypes(@Nullable List<Integer> list) {
            this.drmSessionForClearTypes = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public Builder setDrmUuid(@Nullable UUID uuid) {
            this.drmUuid = uuid;
            return this;
        }

        public Builder setLiveMaxOffsetMs(long j) {
            this.liveMaxOffsetMs = j;
            return this;
        }

        public Builder setLiveMaxPlaybackSpeed(float f) {
            this.liveMaxPlaybackSpeed = f;
            return this;
        }

        public Builder setLiveMinOffsetMs(long j) {
            this.liveMinOffsetMs = j;
            return this;
        }

        public Builder setLiveMinPlaybackSpeed(float f) {
            this.liveMinPlaybackSpeed = f;
            return this;
        }

        public Builder setLiveTargetOffsetMs(long j) {
            this.liveTargetOffsetMs = j;
            return this;
        }

        public Builder setMediaId(String str) {
            this.mediaId = (String) Assertions.checkNotNull(str);
            return this;
        }

        public Builder setMediaMetadata(MediaMetadata mediaMetadata) {
            this.mediaMetadata = mediaMetadata;
            return this;
        }

        public Builder setMimeType(@Nullable String str) {
            this.mimeType = str;
            return this;
        }

        public Builder setStreamKeys(@Nullable List<StreamKey> list) {
            this.streamKeys = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public Builder setSubtitles(@Nullable List<Subtitle> list) {
            this.subtitles = (list == null || list.isEmpty()) ? Collections.emptyList() : Collections.unmodifiableList(new ArrayList(list));
            return this;
        }

        public Builder setTag(@Nullable Object obj) {
            this.tag = obj;
            return this;
        }

        public Builder setUri(@Nullable String str) {
            return setUri(str == null ? null : Uri.parse(str));
        }

        public Builder() {
            this.clipEndPositionMs = Long.MIN_VALUE;
            this.drmSessionForClearTypes = Collections.emptyList();
            this.drmLicenseRequestHeaders = Collections.emptyMap();
            this.streamKeys = Collections.emptyList();
            this.subtitles = Collections.emptyList();
            this.liveTargetOffsetMs = -9223372036854775807L;
            this.liveMinOffsetMs = -9223372036854775807L;
            this.liveMaxOffsetMs = -9223372036854775807L;
            this.liveMinPlaybackSpeed = -3.4028235E38f;
            this.liveMaxPlaybackSpeed = -3.4028235E38f;
        }

        public Builder setAdTagUri(@Nullable Uri uri) {
            return setAdTagUri(uri, null);
        }

        public Builder setDrmLicenseUri(@Nullable String str) {
            this.drmLicenseUri = str == null ? null : Uri.parse(str);
            return this;
        }

        public Builder setUri(@Nullable Uri uri) {
            this.uri = uri;
            return this;
        }

        public Builder setAdTagUri(@Nullable Uri uri, @Nullable Object obj) {
            this.adTagUri = uri;
            this.adsId = obj;
            return this;
        }

        private Builder(MediaItem mediaItem) {
            this();
            ClippingProperties clippingProperties = mediaItem.clippingProperties;
            this.clipEndPositionMs = clippingProperties.endPositionMs;
            this.clipRelativeToLiveWindow = clippingProperties.relativeToLiveWindow;
            this.clipRelativeToDefaultPosition = clippingProperties.relativeToDefaultPosition;
            this.clipStartPositionMs = clippingProperties.startPositionMs;
            this.clipStartsAtKeyFrame = clippingProperties.startsAtKeyFrame;
            this.mediaId = mediaItem.mediaId;
            this.mediaMetadata = mediaItem.mediaMetadata;
            LiveConfiguration liveConfiguration = mediaItem.liveConfiguration;
            this.liveTargetOffsetMs = liveConfiguration.targetOffsetMs;
            this.liveMinOffsetMs = liveConfiguration.minOffsetMs;
            this.liveMaxOffsetMs = liveConfiguration.maxOffsetMs;
            this.liveMinPlaybackSpeed = liveConfiguration.minPlaybackSpeed;
            this.liveMaxPlaybackSpeed = liveConfiguration.maxPlaybackSpeed;
            PlaybackProperties playbackProperties = mediaItem.playbackProperties;
            if (playbackProperties != null) {
                this.customCacheKey = playbackProperties.customCacheKey;
                this.mimeType = playbackProperties.mimeType;
                this.uri = playbackProperties.uri;
                this.streamKeys = playbackProperties.streamKeys;
                this.subtitles = playbackProperties.subtitles;
                this.tag = playbackProperties.tag;
                DrmConfiguration drmConfiguration = playbackProperties.drmConfiguration;
                if (drmConfiguration != null) {
                    this.drmLicenseUri = drmConfiguration.licenseUri;
                    this.drmLicenseRequestHeaders = drmConfiguration.requestHeaders;
                    this.drmMultiSession = drmConfiguration.multiSession;
                    this.drmForceDefaultLicenseUri = drmConfiguration.forceDefaultLicenseUri;
                    this.drmPlayClearContentWithoutKey = drmConfiguration.playClearContentWithoutKey;
                    this.drmSessionForClearTypes = drmConfiguration.sessionForClearTypes;
                    this.drmUuid = drmConfiguration.uuid;
                    this.drmKeySetId = drmConfiguration.getKeySetId();
                }
                AdsConfiguration adsConfiguration = playbackProperties.adsConfiguration;
                if (adsConfiguration != null) {
                    this.adTagUri = adsConfiguration.adTagUri;
                    this.adsId = adsConfiguration.adsId;
                }
            }
        }
    }

    public static final class ClippingProperties implements Bundleable {
        public static final Bundleable.Creator<ClippingProperties> CREATOR = new Bundleable.Creator() { // from class: com.yuewen.ww1
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                return MediaItem.ClippingProperties.lambda$static$0(bundle);
            }
        };
        private static final int FIELD_END_POSITION_MS = 1;
        private static final int FIELD_RELATIVE_TO_DEFAULT_POSITION = 3;
        private static final int FIELD_RELATIVE_TO_LIVE_WINDOW = 2;
        private static final int FIELD_STARTS_AT_KEY_FRAME = 4;
        private static final int FIELD_START_POSITION_MS = 0;
        public final long endPositionMs;
        public final boolean relativeToDefaultPosition;
        public final boolean relativeToLiveWindow;
        public final long startPositionMs;
        public final boolean startsAtKeyFrame;

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ClippingProperties lambda$static$0(Bundle bundle) {
            return new ClippingProperties(bundle.getLong(keyForField(0), 0L), bundle.getLong(keyForField(1), Long.MIN_VALUE), bundle.getBoolean(keyForField(2), false), bundle.getBoolean(keyForField(3), false), bundle.getBoolean(keyForField(4), false));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClippingProperties)) {
                return false;
            }
            ClippingProperties clippingProperties = (ClippingProperties) obj;
            return this.startPositionMs == clippingProperties.startPositionMs && this.endPositionMs == clippingProperties.endPositionMs && this.relativeToLiveWindow == clippingProperties.relativeToLiveWindow && this.relativeToDefaultPosition == clippingProperties.relativeToDefaultPosition && this.startsAtKeyFrame == clippingProperties.startsAtKeyFrame;
        }

        public int hashCode() {
            long j = this.startPositionMs;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.endPositionMs;
            return ((((((i + ((int) ((j2 >>> 32) ^ j2))) * 31) + (this.relativeToLiveWindow ? 1 : 0)) * 31) + (this.relativeToDefaultPosition ? 1 : 0)) * 31) + (this.startsAtKeyFrame ? 1 : 0);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(keyForField(0), this.startPositionMs);
            bundle.putLong(keyForField(1), this.endPositionMs);
            bundle.putBoolean(keyForField(2), this.relativeToLiveWindow);
            bundle.putBoolean(keyForField(3), this.relativeToDefaultPosition);
            bundle.putBoolean(keyForField(4), this.startsAtKeyFrame);
            return bundle;
        }

        private ClippingProperties(long j, long j2, boolean z, boolean z2, boolean z3) {
            this.startPositionMs = j;
            this.endPositionMs = j2;
            this.relativeToLiveWindow = z;
            this.relativeToDefaultPosition = z2;
            this.startsAtKeyFrame = z3;
        }
    }

    public static final class DrmConfiguration {
        public final boolean forceDefaultLicenseUri;

        @Nullable
        private final byte[] keySetId;

        @Nullable
        public final Uri licenseUri;
        public final boolean multiSession;
        public final boolean playClearContentWithoutKey;
        public final Map<String, String> requestHeaders;
        public final List<Integer> sessionForClearTypes;
        public final UUID uuid;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrmConfiguration)) {
                return false;
            }
            DrmConfiguration drmConfiguration = (DrmConfiguration) obj;
            return this.uuid.equals(drmConfiguration.uuid) && Util.areEqual(this.licenseUri, drmConfiguration.licenseUri) && Util.areEqual(this.requestHeaders, drmConfiguration.requestHeaders) && this.multiSession == drmConfiguration.multiSession && this.forceDefaultLicenseUri == drmConfiguration.forceDefaultLicenseUri && this.playClearContentWithoutKey == drmConfiguration.playClearContentWithoutKey && this.sessionForClearTypes.equals(drmConfiguration.sessionForClearTypes) && Arrays.equals(this.keySetId, drmConfiguration.keySetId);
        }

        @Nullable
        public byte[] getKeySetId() {
            byte[] bArr = this.keySetId;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public int hashCode() {
            int iHashCode = this.uuid.hashCode() * 31;
            Uri uri = this.licenseUri;
            return ((((((((((((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.requestHeaders.hashCode()) * 31) + (this.multiSession ? 1 : 0)) * 31) + (this.forceDefaultLicenseUri ? 1 : 0)) * 31) + (this.playClearContentWithoutKey ? 1 : 0)) * 31) + this.sessionForClearTypes.hashCode()) * 31) + Arrays.hashCode(this.keySetId);
        }

        private DrmConfiguration(UUID uuid, @Nullable Uri uri, Map<String, String> map, boolean z, boolean z2, boolean z3, List<Integer> list, @Nullable byte[] bArr) {
            Assertions.checkArgument((z2 && uri == null) ? false : true);
            this.uuid = uuid;
            this.licenseUri = uri;
            this.requestHeaders = map;
            this.multiSession = z;
            this.forceDefaultLicenseUri = z2;
            this.playClearContentWithoutKey = z3;
            this.sessionForClearTypes = list;
            this.keySetId = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }
    }

    public static final class LiveConfiguration implements Bundleable {
        private static final int FIELD_MAX_OFFSET_MS = 2;
        private static final int FIELD_MAX_PLAYBACK_SPEED = 4;
        private static final int FIELD_MIN_OFFSET_MS = 1;
        private static final int FIELD_MIN_PLAYBACK_SPEED = 3;
        private static final int FIELD_TARGET_OFFSET_MS = 0;
        public final long maxOffsetMs;
        public final float maxPlaybackSpeed;
        public final long minOffsetMs;
        public final float minPlaybackSpeed;
        public final long targetOffsetMs;
        public static final LiveConfiguration UNSET = new LiveConfiguration(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, -3.4028235E38f, -3.4028235E38f);
        public static final Bundleable.Creator<LiveConfiguration> CREATOR = new Bundleable.Creator() { // from class: com.yuewen.xw1
            @Override // com.google.android.exoplayer2.Bundleable.Creator
            public final Bundleable fromBundle(Bundle bundle) {
                return MediaItem.LiveConfiguration.lambda$static$0(bundle);
            }
        };

        public LiveConfiguration(long j, long j2, long j3, float f, float f2) {
            this.targetOffsetMs = j;
            this.minOffsetMs = j2;
            this.maxOffsetMs = j3;
            this.minPlaybackSpeed = f;
            this.maxPlaybackSpeed = f2;
        }

        private static String keyForField(int i) {
            return Integer.toString(i, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ LiveConfiguration lambda$static$0(Bundle bundle) {
            return new LiveConfiguration(bundle.getLong(keyForField(0), -9223372036854775807L), bundle.getLong(keyForField(1), -9223372036854775807L), bundle.getLong(keyForField(2), -9223372036854775807L), bundle.getFloat(keyForField(3), -3.4028235E38f), bundle.getFloat(keyForField(4), -3.4028235E38f));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LiveConfiguration)) {
                return false;
            }
            LiveConfiguration liveConfiguration = (LiveConfiguration) obj;
            return this.targetOffsetMs == liveConfiguration.targetOffsetMs && this.minOffsetMs == liveConfiguration.minOffsetMs && this.maxOffsetMs == liveConfiguration.maxOffsetMs && this.minPlaybackSpeed == liveConfiguration.minPlaybackSpeed && this.maxPlaybackSpeed == liveConfiguration.maxPlaybackSpeed;
        }

        public int hashCode() {
            long j = this.targetOffsetMs;
            long j2 = this.minOffsetMs;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.maxOffsetMs;
            int i2 = (i + ((int) ((j3 >>> 32) ^ j3))) * 31;
            float f = this.minPlaybackSpeed;
            int iFloatToIntBits = (i2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.maxPlaybackSpeed;
            return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
        }

        @Override // com.google.android.exoplayer2.Bundleable
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong(keyForField(0), this.targetOffsetMs);
            bundle.putLong(keyForField(1), this.minOffsetMs);
            bundle.putLong(keyForField(2), this.maxOffsetMs);
            bundle.putFloat(keyForField(3), this.minPlaybackSpeed);
            bundle.putFloat(keyForField(4), this.maxPlaybackSpeed);
            return bundle;
        }
    }

    public static final class PlaybackProperties {

        @Nullable
        public final AdsConfiguration adsConfiguration;

        @Nullable
        public final String customCacheKey;

        @Nullable
        public final DrmConfiguration drmConfiguration;

        @Nullable
        public final String mimeType;
        public final List<StreamKey> streamKeys;
        public final List<Subtitle> subtitles;

        @Nullable
        public final Object tag;
        public final Uri uri;

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackProperties)) {
                return false;
            }
            PlaybackProperties playbackProperties = (PlaybackProperties) obj;
            return this.uri.equals(playbackProperties.uri) && Util.areEqual(this.mimeType, playbackProperties.mimeType) && Util.areEqual(this.drmConfiguration, playbackProperties.drmConfiguration) && Util.areEqual(this.adsConfiguration, playbackProperties.adsConfiguration) && this.streamKeys.equals(playbackProperties.streamKeys) && Util.areEqual(this.customCacheKey, playbackProperties.customCacheKey) && this.subtitles.equals(playbackProperties.subtitles) && Util.areEqual(this.tag, playbackProperties.tag);
        }

        public int hashCode() {
            int iHashCode = this.uri.hashCode() * 31;
            String str = this.mimeType;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            DrmConfiguration drmConfiguration = this.drmConfiguration;
            int iHashCode3 = (iHashCode2 + (drmConfiguration == null ? 0 : drmConfiguration.hashCode())) * 31;
            AdsConfiguration adsConfiguration = this.adsConfiguration;
            int iHashCode4 = (((iHashCode3 + (adsConfiguration == null ? 0 : adsConfiguration.hashCode())) * 31) + this.streamKeys.hashCode()) * 31;
            String str2 = this.customCacheKey;
            int iHashCode5 = (((iHashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.subtitles.hashCode()) * 31;
            Object obj = this.tag;
            return iHashCode5 + (obj != null ? obj.hashCode() : 0);
        }

        private PlaybackProperties(Uri uri, @Nullable String str, @Nullable DrmConfiguration drmConfiguration, @Nullable AdsConfiguration adsConfiguration, List<StreamKey> list, @Nullable String str2, List<Subtitle> list2, @Nullable Object obj) {
            this.uri = uri;
            this.mimeType = str;
            this.drmConfiguration = drmConfiguration;
            this.adsConfiguration = adsConfiguration;
            this.streamKeys = list;
            this.customCacheKey = str2;
            this.subtitles = list2;
            this.tag = obj;
        }
    }

    public static final class Subtitle {

        @Nullable
        public final String label;

        @Nullable
        public final String language;
        public final String mimeType;
        public final int roleFlags;
        public final int selectionFlags;
        public final Uri uri;

        public Subtitle(Uri uri, String str, @Nullable String str2) {
            this(uri, str, str2, 0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Subtitle)) {
                return false;
            }
            Subtitle subtitle = (Subtitle) obj;
            return this.uri.equals(subtitle.uri) && this.mimeType.equals(subtitle.mimeType) && Util.areEqual(this.language, subtitle.language) && this.selectionFlags == subtitle.selectionFlags && this.roleFlags == subtitle.roleFlags && Util.areEqual(this.label, subtitle.label);
        }

        public int hashCode() {
            int iHashCode = ((this.uri.hashCode() * 31) + this.mimeType.hashCode()) * 31;
            String str = this.language;
            int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31;
            String str2 = this.label;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public Subtitle(Uri uri, String str, @Nullable String str2, int i) {
            this(uri, str, str2, i, 0, null);
        }

        public Subtitle(Uri uri, String str, @Nullable String str2, int i, int i2, @Nullable String str3) {
            this.uri = uri;
            this.mimeType = str;
            this.language = str2;
            this.selectionFlags = i;
            this.roleFlags = i2;
            this.label = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static MediaItem fromBundle(Bundle bundle) {
        String str = (String) Assertions.checkNotNull(bundle.getString(keyForField(0), ""));
        Bundle bundle2 = bundle.getBundle(keyForField(1));
        LiveConfiguration liveConfiguration = bundle2 == null ? LiveConfiguration.UNSET : (LiveConfiguration) LiveConfiguration.CREATOR.fromBundle(bundle2);
        Bundle bundle3 = bundle.getBundle(keyForField(2));
        MediaMetadata mediaMetadata = bundle3 == null ? MediaMetadata.EMPTY : (MediaMetadata) MediaMetadata.CREATOR.fromBundle(bundle3);
        Bundle bundle4 = bundle.getBundle(keyForField(3));
        return new MediaItem(str, bundle4 == null ? new ClippingProperties(0L, Long.MIN_VALUE, false, false, false) : (ClippingProperties) ClippingProperties.CREATOR.fromBundle(bundle4), null, liveConfiguration, mediaMetadata);
    }

    public static MediaItem fromUri(String str) {
        return new Builder().setUri(str).build();
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem)) {
            return false;
        }
        MediaItem mediaItem = (MediaItem) obj;
        return Util.areEqual(this.mediaId, mediaItem.mediaId) && this.clippingProperties.equals(mediaItem.clippingProperties) && Util.areEqual(this.playbackProperties, mediaItem.playbackProperties) && Util.areEqual(this.liveConfiguration, mediaItem.liveConfiguration) && Util.areEqual(this.mediaMetadata, mediaItem.mediaMetadata);
    }

    public int hashCode() {
        int iHashCode = this.mediaId.hashCode() * 31;
        PlaybackProperties playbackProperties = this.playbackProperties;
        return ((((((iHashCode + (playbackProperties != null ? playbackProperties.hashCode() : 0)) * 31) + this.liveConfiguration.hashCode()) * 31) + this.clippingProperties.hashCode()) * 31) + this.mediaMetadata.hashCode();
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(keyForField(0), this.mediaId);
        bundle.putBundle(keyForField(1), this.liveConfiguration.toBundle());
        bundle.putBundle(keyForField(2), this.mediaMetadata.toBundle());
        bundle.putBundle(keyForField(3), this.clippingProperties.toBundle());
        return bundle;
    }

    private MediaItem(String str, ClippingProperties clippingProperties, @Nullable PlaybackProperties playbackProperties, LiveConfiguration liveConfiguration, MediaMetadata mediaMetadata) {
        this.mediaId = str;
        this.playbackProperties = playbackProperties;
        this.liveConfiguration = liveConfiguration;
        this.mediaMetadata = mediaMetadata;
        this.clippingProperties = clippingProperties;
    }

    public static MediaItem fromUri(Uri uri) {
        return new Builder().setUri(uri).build();
    }
}
