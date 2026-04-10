package com.funny.audio.media_player.service;

import android.content.Intent;
import androidx.media3.session.MediaSession;
import androidx.media3.session.MediaSessionService;
import com.funny.audio.media_player.MediaPlayerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MediaService.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\"\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0017¨\u0006\u000f"}, d2 = {"Lcom/funny/audio/media_player/service/MediaService;", "Landroidx/media3/session/MediaSessionService;", "()V", "onDestroy", "", "onGetSession", "Landroidx/media3/session/MediaSession;", "controllerInfo", "Landroidx/media3/session/MediaSession$ControllerInfo;", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MediaService extends MediaSessionService {
    @Override // androidx.media3.session.MediaSessionService
    public MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo) {
        Intrinsics.checkNotNullParameter(controllerInfo, "controllerInfo");
        return MediaPlayerManager.INSTANCE.getMediaSession();
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        MediaPlayerManager.INSTANCE.getMediaNotificationManager().startMediaNotificationService(this, MediaPlayerManager.INSTANCE.getMediaSession());
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // androidx.media3.session.MediaSessionService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        MediaSession mediaSession = MediaPlayerManager.INSTANCE.getMediaSession();
        mediaSession.release();
        if (mediaSession.getPlayer().getPlaybackState() != 1) {
            mediaSession.getPlayer().seekTo(0L);
            mediaSession.getPlayer().setPlayWhenReady(false);
            mediaSession.getPlayer().stop();
        }
    }
}
