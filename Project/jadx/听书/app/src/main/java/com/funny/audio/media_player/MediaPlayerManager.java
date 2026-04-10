package com.funny.audio.media_player;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.session.MediaSession;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.funny.audio.UpdatePlayerEvent;
import com.funny.audio.api.AddressSetting;
import com.funny.audio.api.ApiManager;
import com.funny.audio.core.net.AppBody;
import com.funny.audio.core.net.NetModelsKt;
import com.funny.audio.database.DbContext;
import com.funny.audio.database.entities.PlayHistoryEntity;
import com.funny.audio.database.entities.PlayProgressEntity;
import com.funny.audio.media_player.analysis.AnalysisResult;
import com.funny.audio.media_player.analysis.LanrenAnalysisUtil;
import com.funny.audio.media_player.analysis.PlayTypes;
import com.funny.audio.media_player.analysis.SelfAnalysisUtil;
import com.funny.audio.media_player.media_notification.MediaNotificationManager;
import com.funny.audio.media_player.service.MediaService;
import com.funny.audio.models.AlbumDetailInfo;
import com.funny.audio.models.AlbumTrackAnalysisInfo;
import com.funny.audio.models.AlbumTrackInfo;
import com.funny.audio.models.AnnouncerItem;
import com.funny.audio.user.UserManager;
import com.funny.audio.view.DialogUtils;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: compiled from: MediaPlayerManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010h\u001a\u00020i2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010j\u001a\u00020iH\u0002J\b\u0010k\u001a\u00020iH\u0002J\u0010\u0010l\u001a\u00020i2\u0006\u0010@\u001a\u00020AH\u0016J\u0010\u0010m\u001a\u00020i2\u0006\u0010E\u001a\u00020AH\u0016J\u0010\u0010n\u001a\u00020i2\u0006\u0010o\u001a\u00020pH\u0016J\u0010\u0010q\u001a\u00020i2\u0006\u0010r\u001a\u00020sH\u0016J \u0010t\u001a\u00020i2\u0006\u0010u\u001a\u00020v2\u0006\u0010w\u001a\u00020v2\u0006\u0010x\u001a\u00020pH\u0016J\u001c\u0010y\u001a\b\u0012\u0004\u0012\u00020z0*2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020$0|H\u0002JE\u0010}\u001a\u00020i2\u0006\u0010~\u001a\u00020\u001e2\f\u0010{\u001a\b\u0012\u0004\u0012\u00020$0*2\u0006\u0010\u007f\u001a\u00020p2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0081\u0001\u001a\u00020A2\t\b\u0002\u0010\u0082\u0001\u001a\u00020AJ\u0007\u0010\u0083\u0001\u001a\u00020iJ\t\u0010\u0084\u0001\u001a\u00020iH\u0002J\u0007\u0010\u0085\u0001\u001a\u00020iJ\u0010\u0010\u0086\u0001\u001a\u00020i2\u0007\u0010\u0080\u0001\u001a\u00020\fJ\u0007\u0010\u0087\u0001\u001a\u00020iJ\u0007\u0010\u0088\u0001\u001a\u00020iJ\u0010\u0010\u0089\u0001\u001a\u00020i2\u0007\u0010\u008a\u0001\u001a\u00020_J\u0011\u0010\u008b\u0001\u001a\u00020i2\b\u0010\u008c\u0001\u001a\u00030\u008d\u0001J\t\u0010\u008e\u0001\u001a\u00020iH\u0002J\t\u0010\u008f\u0001\u001a\u00020iH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010)\u001a\b\u0012\u0004\u0012\u00020$0*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u000e\"\u0004\b7\u0010\u0010R\u0016\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010;\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b<\u0010=R\u001a\u0010@\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR\u001b\u0010G\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010?\u001a\u0004\bH\u0010IR\u001b\u0010K\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bN\u0010?\u001a\u0004\bL\u0010MR\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010Q\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bT\u0010?\u001a\u0004\bR\u0010SR*\u0010U\u001a\u001e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020W0Vj\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020W`XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010:09X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010Z\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000e\"\u0004\b\\\u0010\u0010R\u000e\u0010]\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010`\u001a\u00020\u0012X\u0086D¢\u0006\b\n\u0000\u001a\u0004\ba\u0010\u0014R\u001a\u0010b\u001a\u00020cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g¨\u0006\u0090\u0001"}, d2 = {"Lcom/funny/audio/media_player/MediaPlayerManager;", "Landroidx/media3/common/Player$Listener;", "()V", "_exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "_mediaClient", "Lokhttp3/OkHttpClient;", "_mediaNotificationManager", "Lcom/funny/audio/media_player/media_notification/MediaNotificationManager;", "_mediaSession", "Landroidx/media3/session/MediaSession;", "buffering", "", "getBuffering", "()J", "setBuffering", "(J)V", "cacheDir", "", "getCacheDir", "()Ljava/lang/String;", "setCacheDir", "(Ljava/lang/String;)V", d.R, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "currentAlbumDetailInfo", "Lcom/funny/audio/models/AlbumDetailInfo;", "getCurrentAlbumDetailInfo", "()Lcom/funny/audio/models/AlbumDetailInfo;", "setCurrentAlbumDetailInfo", "(Lcom/funny/audio/models/AlbumDetailInfo;)V", "currentAlbumTrackInfo", "Lcom/funny/audio/models/AlbumTrackInfo;", "getCurrentAlbumTrackInfo", "()Lcom/funny/audio/models/AlbumTrackInfo;", "setCurrentAlbumTrackInfo", "(Lcom/funny/audio/models/AlbumTrackInfo;)V", "currentAlbumTracks", "", "getCurrentAlbumTracks", "()Ljava/util/List;", "setCurrentAlbumTracks", "(Ljava/util/List;)V", "currentPlaySetting", "Lcom/funny/audio/media_player/PlaySetting;", "getCurrentPlaySetting", "()Lcom/funny/audio/media_player/PlaySetting;", "setCurrentPlaySetting", "(Lcom/funny/audio/media_player/PlaySetting;)V", "duration", "getDuration", "setDuration", "emitMediaStateJobRef", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/Job;", "exoPlayer", "getExoPlayer", "()Landroidx/media3/exoplayer/ExoPlayer;", "exoPlayer$delegate", "Lkotlin/Lazy;", "isLoading", "", "()Z", "setLoading", "(Z)V", "isPlaying", "setPlaying", "mediaClient", "getMediaClient", "()Lokhttp3/OkHttpClient;", "mediaClient$delegate", "mediaNotificationManager", "getMediaNotificationManager", "()Lcom/funny/audio/media_player/media_notification/MediaNotificationManager;", "mediaNotificationManager$delegate", "mediaRequestInterceptor", "Lokhttp3/Interceptor;", "mediaSession", "getMediaSession", "()Landroidx/media3/session/MediaSession;", "mediaSession$delegate", "pathMap", "Ljava/util/HashMap;", "Lcom/funny/audio/media_player/analysis/AnalysisResult;", "Lkotlin/collections/HashMap;", "playProgressJobRef", "progress", "getProgress", "setProgress", "retryRequestInterceptor", "speed", "", "tagName", "getTagName", "timePauseSetting", "Lcom/funny/audio/media_player/TimePauseSetting;", "getTimePauseSetting", "()Lcom/funny/audio/media_player/TimePauseSetting;", "setTimePauseSetting", "(Lcom/funny/audio/media_player/TimePauseSetting;)V", "init", "", "initPlayList", "loadPlaySetting", "onIsLoadingChanged", "onIsPlayingChanged", "onPlaybackStateChanged", "playbackState", "", "onPlayerError", "error", "Landroidx/media3/common/PlaybackException;", "onPositionDiscontinuity", "oldPosition", "Landroidx/media3/common/Player$PositionInfo;", "newPosition", MediationConstant.KEY_REASON, "parseMediaItems", "Landroidx/media3/common/MediaItem;", "albumTracks", "", "playAlbumTrack", "albumDetailInfo", "index", "positionMs", "playWhenReady", "jumpTrackPlayer", "playPause", "savePlaySetting", "savePlaySpeed", "seekToMs", "seekToNext", "seekToPrevious", "setPlaySpeed", "playSpeed", "setSkipSetting", "skipSetting", "Lcom/funny/audio/media_player/SkipSetting;", "startJobs", "startMediaService", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MediaPlayerManager implements Player.Listener {
    private static ExoPlayer _exoPlayer;
    private static OkHttpClient _mediaClient;
    private static MediaNotificationManager _mediaNotificationManager;
    private static MediaSession _mediaSession;
    private static long buffering;
    private static Application context;
    private static AlbumDetailInfo currentAlbumDetailInfo;
    private static AlbumTrackInfo currentAlbumTrackInfo;
    private static long duration;
    private static boolean isLoading;
    private static boolean isPlaying;
    private static long progress;
    public static final MediaPlayerManager INSTANCE = new MediaPlayerManager();
    private static final String tagName = "MEDIA";
    private static String cacheDir = "mediaCaches";

    /* JADX INFO: renamed from: exoPlayer$delegate, reason: from kotlin metadata */
    private static final Lazy exoPlayer = LazyKt.lazy(new Function0<ExoPlayer>() { // from class: com.funny.audio.media_player.MediaPlayerManager$exoPlayer$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ExoPlayer invoke() {
            ExoPlayer exoPlayer2 = MediaPlayerManager._exoPlayer;
            Intrinsics.checkNotNull(exoPlayer2);
            return exoPlayer2;
        }
    });

    /* JADX INFO: renamed from: mediaSession$delegate, reason: from kotlin metadata */
    private static final Lazy mediaSession = LazyKt.lazy(new Function0<MediaSession>() { // from class: com.funny.audio.media_player.MediaPlayerManager$mediaSession$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MediaSession invoke() {
            MediaSession mediaSession2 = MediaPlayerManager._mediaSession;
            Intrinsics.checkNotNull(mediaSession2);
            return mediaSession2;
        }
    });

    /* JADX INFO: renamed from: mediaNotificationManager$delegate, reason: from kotlin metadata */
    private static final Lazy mediaNotificationManager = LazyKt.lazy(new Function0<MediaNotificationManager>() { // from class: com.funny.audio.media_player.MediaPlayerManager$mediaNotificationManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MediaNotificationManager invoke() {
            MediaNotificationManager mediaNotificationManager2 = MediaPlayerManager._mediaNotificationManager;
            Intrinsics.checkNotNull(mediaNotificationManager2);
            return mediaNotificationManager2;
        }
    });
    private static final AtomicReference<Job> emitMediaStateJobRef = new AtomicReference<>(null);
    private static final AtomicReference<Job> playProgressJobRef = new AtomicReference<>(null);
    private static HashMap<String, AnalysisResult> pathMap = new HashMap<>();
    private static List<AlbumTrackInfo> currentAlbumTracks = new ArrayList();
    private static PlaySetting currentPlaySetting = new PlaySetting(0.0f, null, 3, null);
    private static TimePauseSetting timePauseSetting = new TimePauseSetting(false, 0, 0, 0, 15, null);
    private static float speed = 1.0f;

    /* JADX INFO: renamed from: mediaClient$delegate, reason: from kotlin metadata */
    private static final Lazy mediaClient = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: com.funny.audio.media_player.MediaPlayerManager$mediaClient$2
        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            if (MediaPlayerManager._mediaClient != null) {
                Intrinsics.checkNotNull(MediaPlayerManager._mediaClient);
            }
            synchronized (MediaPlayerManager.INSTANCE) {
                Application context2 = MediaPlayerManager.INSTANCE.getContext();
                Intrinsics.checkNotNull(context2);
                Cache cache = new Cache(new File(context2.getCacheDir(), MediaPlayerManager.INSTANCE.getCacheDir()), 1073741824L);
                MediaPlayerManager mediaPlayerManager = MediaPlayerManager.INSTANCE;
                MediaPlayerManager._mediaClient = new OkHttpClient.Builder().addInterceptor(MediaPlayerManager.retryRequestInterceptor).addInterceptor(MediaPlayerManager.mediaRequestInterceptor).connectTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).readTimeout(ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, TimeUnit.MILLISECONDS).retryOnConnectionFailure(true).cache(cache).build();
                Unit unit = Unit.INSTANCE;
            }
            OkHttpClient okHttpClient = MediaPlayerManager._mediaClient;
            Intrinsics.checkNotNull(okHttpClient);
            return okHttpClient;
        }
    });
    private static final Interceptor retryRequestInterceptor = new Interceptor() { // from class: com.funny.audio.media_player.MediaPlayerManager$$ExternalSyntheticLambda0
        @Override // okhttp3.Interceptor
        public final Response intercept(Interceptor.Chain chain) {
            return MediaPlayerManager.retryRequestInterceptor$lambda$0(chain);
        }
    };
    private static final Interceptor mediaRequestInterceptor = new Interceptor() { // from class: com.funny.audio.media_player.MediaPlayerManager$$ExternalSyntheticLambda1
        @Override // okhttp3.Interceptor
        public final Response intercept(Interceptor.Chain chain) {
            return MediaPlayerManager.mediaRequestInterceptor$lambda$2(chain);
        }
    };

    private MediaPlayerManager() {
    }

    public final String getTagName() {
        return tagName;
    }

    public final Application getContext() {
        return context;
    }

    public final void setContext(Application application) {
        context = application;
    }

    public final String getCacheDir() {
        return cacheDir;
    }

    public final void setCacheDir(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        cacheDir = str;
    }

    public final ExoPlayer getExoPlayer() {
        return (ExoPlayer) exoPlayer.getValue();
    }

    public final MediaSession getMediaSession() {
        return (MediaSession) mediaSession.getValue();
    }

    public final MediaNotificationManager getMediaNotificationManager() {
        return (MediaNotificationManager) mediaNotificationManager.getValue();
    }

    public final AlbumDetailInfo getCurrentAlbumDetailInfo() {
        return currentAlbumDetailInfo;
    }

    public final void setCurrentAlbumDetailInfo(AlbumDetailInfo albumDetailInfo) {
        currentAlbumDetailInfo = albumDetailInfo;
    }

    public final List<AlbumTrackInfo> getCurrentAlbumTracks() {
        return currentAlbumTracks;
    }

    public final void setCurrentAlbumTracks(List<AlbumTrackInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        currentAlbumTracks = list;
    }

    public final AlbumTrackInfo getCurrentAlbumTrackInfo() {
        return currentAlbumTrackInfo;
    }

    public final void setCurrentAlbumTrackInfo(AlbumTrackInfo albumTrackInfo) {
        currentAlbumTrackInfo = albumTrackInfo;
    }

    public final PlaySetting getCurrentPlaySetting() {
        return currentPlaySetting;
    }

    public final void setCurrentPlaySetting(PlaySetting playSetting) {
        Intrinsics.checkNotNullParameter(playSetting, "<set-?>");
        currentPlaySetting = playSetting;
    }

    public final TimePauseSetting getTimePauseSetting() {
        return timePauseSetting;
    }

    public final void setTimePauseSetting(TimePauseSetting timePauseSetting2) {
        Intrinsics.checkNotNullParameter(timePauseSetting2, "<set-?>");
        timePauseSetting = timePauseSetting2;
    }

    public final boolean isLoading() {
        return isLoading;
    }

    public final void setLoading(boolean z) {
        isLoading = z;
    }

    public final long getBuffering() {
        return buffering;
    }

    public final void setBuffering(long j) {
        buffering = j;
    }

    public final long getDuration() {
        return duration;
    }

    public final void setDuration(long j) {
        duration = j;
    }

    public final long getProgress() {
        return progress;
    }

    public final void setProgress(long j) {
        progress = j;
    }

    public final boolean isPlaying() {
        return isPlaying;
    }

    public final void setPlaying(boolean z) {
        isPlaying = z;
    }

    public final OkHttpClient getMediaClient() {
        return (OkHttpClient) mediaClient.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response retryRequestInterceptor$lambda$0(Interceptor.Chain chain) throws InterruptedException {
        Response responseProceed;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        int i = 0;
        while (i < 3) {
            try {
                responseProceed = chain.proceed(request);
            } catch (Exception unused) {
                Log.e(tagName, "解析发生错误第" + (i + 1) + "次");
            }
            if (responseProceed.isSuccessful()) {
                return responseProceed;
            }
            i++;
            Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        }
        Log.e(tagName, "3次解析错误，返回空音频");
        return new Response.Builder().code(200).request(request).protocol(Protocol.HTTP_1_1).message("Empty Audio File").body(ResponseBody.INSTANCE.create(new byte[0], MediaType.INSTANCE.parse(MimeTypes.AUDIO_MPEG))).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response mediaRequestInterceptor$lambda$2(Interceptor.Chain chain) throws Exception {
        AnalysisResult analysisResultAnalysis;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String strTrimStart = StringsKt.trimStart(request.url().encodedPath(), '/');
        if (pathMap.containsKey(strTrimStart)) {
            analysisResultAnalysis = pathMap.get(strTrimStart);
        } else {
            List listSplit$default = StringsKt.split$default((CharSequence) strTrimStart, new String[]{"/"}, false, 0, 6, (Object) null);
            AppBody<AlbumTrackAnalysisInfo> body = ApiManager.INSTANCE.getBusiness().analysisAlbumTrack((String) listSplit$default.get(0), (String) listSplit$default.get(1)).getBody();
            Intrinsics.checkNotNull(body);
            AlbumTrackAnalysisInfo data = body.getData();
            Intrinsics.checkNotNull(data);
            AlbumTrackAnalysisInfo albumTrackAnalysisInfo = data;
            String playType = albumTrackAnalysisInfo.getPlayType();
            if (Intrinsics.areEqual(playType, PlayTypes.INSTANCE.getSELF())) {
                analysisResultAnalysis = SelfAnalysisUtil.INSTANCE.analysis(albumTrackAnalysisInfo);
            } else {
                analysisResultAnalysis = Intrinsics.areEqual(playType, PlayTypes.INSTANCE.getLANREN()) ? LanrenAnalysisUtil.INSTANCE.analysis(albumTrackAnalysisInfo) : null;
            }
        }
        if (analysisResultAnalysis == null || !analysisResultAnalysis.getSuccess()) {
            throw new Exception();
        }
        pathMap.put(strTrimStart, analysisResultAnalysis);
        Request.Builder builderUrl = request.newBuilder().url(analysisResultAnalysis.getUrl());
        Map<String, String> headers = analysisResultAnalysis.getHeaders();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                builderUrl.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return chain.proceed(builderUrl.build());
    }

    public final void init(Application context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        context = context2;
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setContentType(2).setUsage(1).build();
        Intrinsics.checkNotNullExpressionValue(audioAttributesBuild, "Builder()\n            .s…DIA)\n            .build()");
        Application application = context2;
        ExoPlayer.Builder builder = new ExoPlayer.Builder(application);
        Intrinsics.checkNotNull(UserManager.INSTANCE.getSetting());
        _exoPlayer = builder.setAudioAttributes(audioAttributesBuild, !r3.getAudioTop()).setHandleAudioBecomingNoisy(true).setMediaSourceFactory(new DefaultMediaSourceFactory(new OkHttpDataSource.Factory(getMediaClient()))).setTrackSelector(new DefaultTrackSelector(application)).build();
        _mediaSession = new MediaSession.Builder(application, getExoPlayer()).setId("audio-" + UUID.randomUUID()).build();
        getExoPlayer().addListener(this);
        _mediaNotificationManager = new MediaNotificationManager(application, getExoPlayer());
        startMediaService();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.funny.audio.media_player.MediaPlayerManager$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: MediaPlayerManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.media_player.MediaPlayerManager$init$1", f = "MediaPlayerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                MediaPlayerManager.INSTANCE.initPlayList();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initPlayList() {
        try {
            PlayHistoryEntity playHistoryEntityLatest = DbContext.INSTANCE.getCurrent().playHistory().latest();
            if (playHistoryEntityLatest == null) {
                return;
            }
            com.funny.audio.core.net.Response<AlbumDetailInfo> albumDetailInfo = ApiManager.INSTANCE.getBusiness().getAlbumDetailInfo(playHistoryEntityLatest.getAlbumId());
            if (NetModelsKt.successWithData(albumDetailInfo)) {
                AppBody<AlbumDetailInfo> body = albumDetailInfo.getBody();
                Intrinsics.checkNotNull(body);
                AlbumDetailInfo data = body.getData();
                Intrinsics.checkNotNull(data);
                currentAlbumDetailInfo = data;
            }
            com.funny.audio.core.net.Response<List<AlbumTrackInfo>> albumTrackList = ApiManager.INSTANCE.getBusiness().getAlbumTrackList(playHistoryEntityLatest.getAlbumId());
            if (NetModelsKt.successWithData(albumTrackList)) {
                AppBody<List<AlbumTrackInfo>> body2 = albumTrackList.getBody();
                Intrinsics.checkNotNull(body2);
                List<AlbumTrackInfo> data2 = body2.getData();
                Intrinsics.checkNotNull(data2);
                currentAlbumTracks = data2;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new C05631(parseMediaItems(currentAlbumTracks), DbContext.INSTANCE.getCurrent().playProgress().latest(playHistoryEntityLatest.getAlbumId()), null), 3, null);
            loadPlaySetting();
            startJobs();
        } catch (Exception unused) {
            currentAlbumDetailInfo = null;
            currentAlbumTracks = new ArrayList();
        }
    }

    /* JADX INFO: renamed from: com.funny.audio.media_player.MediaPlayerManager$initPlayList$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MediaPlayerManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.funny.audio.media_player.MediaPlayerManager$initPlayList$1", f = "MediaPlayerManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C05631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<MediaItem> $mediaItems;
        final /* synthetic */ PlayProgressEntity $playProgress;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C05631(List<MediaItem> list, PlayProgressEntity playProgressEntity, Continuation<? super C05631> continuation) {
            super(2, continuation);
            this.$mediaItems = list;
            this.$playProgress = playProgressEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C05631(this.$mediaItems, this.$playProgress, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C05631) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int trackIndex;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MediaPlayerManager.INSTANCE.getExoPlayer().setMediaItems(this.$mediaItems);
            PlayProgressEntity playProgressEntity = this.$playProgress;
            if (playProgressEntity != null) {
                if (playProgressEntity.getTrackIndex() >= this.$mediaItems.size()) {
                    trackIndex = this.$mediaItems.size() - 1;
                } else {
                    trackIndex = this.$playProgress.getTrackIndex();
                }
                MediaPlayerManager.INSTANCE.getExoPlayer().seekTo(trackIndex, this.$playProgress.getDuration());
            } else {
                MediaPlayerManager.INSTANCE.getExoPlayer().seekTo(0, 0L);
            }
            MediaPlayerManager.INSTANCE.getExoPlayer().prepare();
            MediaPlayerManager.INSTANCE.getExoPlayer().setPlayWhenReady(false);
            return Unit.INSTANCE;
        }
    }

    private final void startMediaService() {
        Intent intent = new Intent(context, (Class<?>) MediaService.class);
        Application application = context;
        if (application != null) {
            application.startForegroundService(intent);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0014, B:13:0x003c, B:15:0x0044, B:17:0x004c, B:23:0x0073, B:22:0x0056, B:12:0x001f), top: B:29:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0044 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0014, B:13:0x003c, B:15:0x0044, B:17:0x004c, B:23:0x0073, B:22:0x0056, B:12:0x001f), top: B:29:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0056 A[Catch: all -> 0x0077, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0014, B:13:0x003c, B:15:0x0044, B:17:0x004c, B:23:0x0073, B:22:0x0056, B:12:0x001f), top: B:29:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void startJobs() {
        /*
            r11 = this;
            monitor-enter(r11)
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = com.funny.audio.media_player.MediaPlayerManager.emitMediaStateJobRef     // Catch: java.lang.Throwable -> L77
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L77
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L1f
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L77
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L1c
            boolean r1 = r1.isCompleted()     // Catch: java.lang.Throwable -> L77
            if (r1 != r3) goto L1c
            r1 = r3
            goto L1d
        L1c:
            r1 = r4
        L1d:
            if (r1 == 0) goto L3c
        L1f:
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L77
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Throwable -> L77
            kotlinx.coroutines.CoroutineScope r5 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r1)     // Catch: java.lang.Throwable -> L77
            r6 = 0
            r7 = 0
            com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$1 r1 = new com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$1     // Catch: java.lang.Throwable -> L77
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L77
            r8 = r1
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Throwable -> L77
            r9 = 3
            r10 = 0
            kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L77
            r0.set(r1)     // Catch: java.lang.Throwable -> L77
        L3c:
            java.util.concurrent.atomic.AtomicReference<kotlinx.coroutines.Job> r0 = com.funny.audio.media_player.MediaPlayerManager.playProgressJobRef     // Catch: java.lang.Throwable -> L77
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L56
            java.lang.Object r1 = r0.get()     // Catch: java.lang.Throwable -> L77
            kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1     // Catch: java.lang.Throwable -> L77
            if (r1 == 0) goto L53
            boolean r1 = r1.isCompleted()     // Catch: java.lang.Throwable -> L77
            if (r1 != r3) goto L53
            goto L54
        L53:
            r3 = r4
        L54:
            if (r3 == 0) goto L73
        L56:
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Throwable -> L77
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch: java.lang.Throwable -> L77
            kotlinx.coroutines.CoroutineScope r3 = kotlinx.coroutines.CoroutineScopeKt.CoroutineScope(r1)     // Catch: java.lang.Throwable -> L77
            r4 = 0
            r5 = 0
            com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$2 r1 = new com.funny.audio.media_player.MediaPlayerManager$startJobs$1$newJob$2     // Catch: java.lang.Throwable -> L77
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L77
            r6 = r1
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch: java.lang.Throwable -> L77
            r7 = 3
            r8 = 0
            kotlinx.coroutines.Job r1 = kotlinx.coroutines.BuildersKt.launch$default(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L77
            r0.set(r1)     // Catch: java.lang.Throwable -> L77
        L73:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L77
            monitor-exit(r11)
            return
        L77:
            r0 = move-exception
            monitor-exit(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.media_player.MediaPlayerManager.startJobs():void");
    }

    private final List<MediaItem> parseMediaItems(List<AlbumTrackInfo> albumTracks) {
        String string;
        List<AnnouncerItem> announcers;
        AnnouncerItem announcerItem;
        ArrayList arrayList = new ArrayList();
        for (AlbumTrackInfo albumTrackInfo : albumTracks) {
            AlbumDetailInfo albumDetailInfo = currentAlbumDetailInfo;
            Intrinsics.checkNotNull(albumDetailInfo);
            String announcerName = null;
            if (StringsKt.startsWith$default(albumDetailInfo.getCoverPath(), "http", false, 2, (Object) null)) {
                AlbumDetailInfo albumDetailInfo2 = currentAlbumDetailInfo;
                Intrinsics.checkNotNull(albumDetailInfo2);
                string = albumDetailInfo2.getCoverPath();
            } else {
                URI uri = new URI(AddressSetting.INSTANCE.getCurrent().getStaticResource().getValue());
                AlbumDetailInfo albumDetailInfo3 = currentAlbumDetailInfo;
                Intrinsics.checkNotNull(albumDetailInfo3);
                string = uri.resolve(albumDetailInfo3.getCoverPath()).toString();
                Intrinsics.checkNotNullExpressionValue(string, "{\n                    va…tring()\n                }");
            }
            MediaItem.Builder uri2 = new MediaItem.Builder().setUri("https://www.baidu.com/" + albumTrackInfo.getAlbumId() + "/" + albumTrackInfo.getId());
            MediaMetadata.Builder albumTitle = new MediaMetadata.Builder().setAlbumTitle(albumTrackInfo.getTitle());
            AlbumDetailInfo albumDetailInfo4 = currentAlbumDetailInfo;
            if (albumDetailInfo4 != null && (announcers = albumDetailInfo4.getAnnouncers()) != null && (announcerItem = (AnnouncerItem) CollectionsKt.firstOrNull((List) announcers)) != null) {
                announcerName = announcerItem.getAnnouncerName();
            }
            MediaItem mediaItemBuild = uri2.setMediaMetadata(albumTitle.setArtist(announcerName).setArtworkUri(Uri.parse(string)).build()).build();
            Intrinsics.checkNotNullExpressionValue(mediaItemBuild, "Builder()\n              …\n                .build()");
            arrayList.add(mediaItemBuild);
        }
        return arrayList;
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlaybackStateChanged(int playbackState) {
        if (playbackState != 2) {
            return;
        }
        buffering = getExoPlayer().getBufferedPosition();
        duration = getExoPlayer().getDuration();
        EventBus.getDefault().post(new UpdatePlayerEvent());
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        super.onPlayerError(error);
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsPlayingChanged(boolean isPlaying2) {
        isPlaying = isPlaying2;
        EventBus.getDefault().post(new UpdatePlayerEvent());
    }

    @Override // androidx.media3.common.Player.Listener
    public void onIsLoadingChanged(boolean isLoading2) {
        isLoading = isLoading2;
        EventBus.getDefault().post(new UpdatePlayerEvent());
    }

    @Override // androidx.media3.common.Player.Listener
    public void onPositionDiscontinuity(Player.PositionInfo oldPosition, Player.PositionInfo newPosition, int reason) {
        Intrinsics.checkNotNullParameter(oldPosition, "oldPosition");
        Intrinsics.checkNotNullParameter(newPosition, "newPosition");
        super.onPositionDiscontinuity(oldPosition, newPosition, reason);
        if (newPosition.mediaItemIndex == oldPosition.mediaItemIndex) {
            return;
        }
        if (timePauseSetting.getEnable() && timePauseSetting.getType() == TimePauseType.INSTANCE.getEPISODES()) {
            if (timePauseSetting.getValue() > 1) {
                TimePauseSetting timePauseSetting2 = timePauseSetting;
                timePauseSetting2.setValue(timePauseSetting2.getValue() - 1);
            } else {
                timePauseSetting = new TimePauseSetting(false, 0, 0L, 0L, 15, null);
                getExoPlayer().pause();
            }
        }
        EventBus.getDefault().post(new UpdatePlayerEvent());
    }

    public final void playPause() {
        int playbackState = getExoPlayer().getPlaybackState();
        if (getExoPlayer().isPlaying()) {
            getExoPlayer().pause();
            isPlaying = false;
            EventBus.getDefault().post(new UpdatePlayerEvent());
        } else {
            if (playbackState == 1) {
                getExoPlayer().prepare();
                getExoPlayer().setPlayWhenReady(true);
            } else {
                getExoPlayer().play();
            }
            startJobs();
        }
    }

    public final void seekToMs(long positionMs) {
        getExoPlayer().seekTo(positionMs);
    }

    public final void seekToPrevious() {
        if (!currentAlbumTracks.isEmpty()) {
            if (getExoPlayer().getCurrentMediaItemIndex() <= 0) {
                DialogUtils.INSTANCE.tip("没有上一集数据");
                return;
            }
            getExoPlayer().seekTo(getExoPlayer().getCurrentMediaItemIndex() - 1, 0L);
            getExoPlayer().prepare();
            getExoPlayer().setPlayWhenReady(true);
        }
    }

    public final void seekToNext() {
        if (!currentAlbumTracks.isEmpty()) {
            if (getExoPlayer().getCurrentMediaItemIndex() >= currentAlbumTracks.size() - 1) {
                DialogUtils.INSTANCE.tip("没有下一集数据");
                return;
            }
            getExoPlayer().seekTo(getExoPlayer().getCurrentMediaItemIndex() + 1, 0L);
            getExoPlayer().prepare();
            getExoPlayer().setPlayWhenReady(true);
        }
    }

    public final void setSkipSetting(SkipSetting skipSetting) {
        Intrinsics.checkNotNullParameter(skipSetting, "skipSetting");
        currentPlaySetting.setSkip(skipSetting);
        savePlaySetting();
    }

    public final void setPlaySpeed(float playSpeed) {
        currentPlaySetting.setPlaySpeed(playSpeed);
        getExoPlayer().setPlaybackSpeed(playSpeed);
    }

    public final void savePlaySpeed() {
        savePlaySetting();
    }

    private final void savePlaySetting() {
        AlbumDetailInfo albumDetailInfo = currentAlbumDetailInfo;
        if (albumDetailInfo != null) {
            try {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MediaPlayerManager$savePlaySetting$1$1(albumDetailInfo, this, null), 3, null);
            } catch (Exception unused) {
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void loadPlaySetting() {
        AlbumDetailInfo albumDetailInfo = currentAlbumDetailInfo;
        if (albumDetailInfo != null) {
            try {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new MediaPlayerManager$loadPlaySetting$1$1(albumDetailInfo, this, null), 3, null);
            } catch (Exception unused) {
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void playAlbumTrack(com.funny.audio.models.AlbumDetailInfo r4, java.util.List<com.funny.audio.models.AlbumTrackInfo> r5, int r6, long r7, boolean r9, boolean r10) {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.funny.audio.media_player.MediaPlayerManager.playAlbumTrack(com.funny.audio.models.AlbumDetailInfo, java.util.List, int, long, boolean, boolean):void");
    }
}
