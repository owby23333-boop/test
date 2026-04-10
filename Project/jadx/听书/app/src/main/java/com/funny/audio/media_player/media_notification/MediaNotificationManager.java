package com.funny.audio.media_player.media_notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import androidx.media3.ui.PlayerNotificationManager;
import com.funny.audio.R;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaNotificationManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\b\u0010\r\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/funny/audio/media_player/media_notification/MediaNotificationManager;", "", d.R, "Landroid/content/Context;", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "(Landroid/content/Context;Landroidx/media3/exoplayer/ExoPlayer;)V", "mediaNotificationManager", "Landroidx/core/app/NotificationManagerCompat;", "buildMediaNotification", "", "mediaSession", "Landroidx/media3/session/MediaSession;", "createMediaNotificationChannel", "startForegroundMediaService", "mediaSessionService", "Landroidx/media3/session/MediaSessionService;", "startMediaNotificationService", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MediaNotificationManager {
    private final Context context;
    private final ExoPlayer exoPlayer;
    private final NotificationManagerCompat mediaNotificationManager;

    public MediaNotificationManager(Context context, ExoPlayer exoPlayer) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
        this.context = context;
        this.exoPlayer = exoPlayer;
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(context);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(context)");
        this.mediaNotificationManager = notificationManagerCompatFrom;
        createMediaNotificationChannel();
    }

    private final void createMediaNotificationChannel() {
        this.mediaNotificationManager.createNotificationChannel(new NotificationChannel(Constants.NOTIFICATION_CHANNEL_ID, Constants.NOTIFICATION_CHANNEL_NAME, 0));
    }

    private final void buildMediaNotification(MediaSession mediaSession) {
        PlayerNotificationManager playerNotificationManagerBuild = new PlayerNotificationManager.Builder(this.context, 1, Constants.NOTIFICATION_CHANNEL_ID).setMediaDescriptionAdapter(new MediaNotificationDescriptorAdapter(this.context, mediaSession.getSessionActivity())).setSmallIconResourceId(R.mipmap.ic_logo).build();
        playerNotificationManagerBuild.setMediaSessionToken(mediaSession.getSessionCompatToken());
        playerNotificationManagerBuild.setUseFastForwardActionInCompactView(true);
        playerNotificationManagerBuild.setUseRewindActionInCompactView(true);
        playerNotificationManagerBuild.setUseNextActionInCompactView(true);
        playerNotificationManagerBuild.setUsePreviousActionInCompactView(true);
        playerNotificationManagerBuild.setPriority(0);
        playerNotificationManagerBuild.setPlayer(this.exoPlayer);
    }

    private final void startForegroundMediaService(MediaSessionService mediaSessionService) {
        Notification notificationBuild = new Notification.Builder(this.context, Constants.NOTIFICATION_CHANNEL_ID).setCategory(NotificationCompat.CATEGORY_SERVICE).build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "Builder(context, Constan…ICE)\n            .build()");
        mediaSessionService.startForeground(1, notificationBuild);
    }

    public final void startMediaNotificationService(MediaSessionService mediaSessionService, MediaSession mediaSession) {
        Intrinsics.checkNotNullParameter(mediaSessionService, "mediaSessionService");
        Intrinsics.checkNotNullParameter(mediaSession, "mediaSession");
        buildMediaNotification(mediaSession);
        startForegroundMediaService(mediaSessionService);
    }
}
