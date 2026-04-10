package com.kwad.components.core.offline.init.b;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.listener.VideoPlayStateListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bh;

/* JADX INFO: loaded from: classes3.dex */
final class a implements IKsMediaPlayer {
    private com.kwad.components.core.video.b KL;
    private c KM;
    private VideoMuteStateChangeListener KN;
    private boolean KO;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private boolean nG = true;
    private boolean xS;
    private OfflineOnAudioConflictListener xV;

    a() {
    }

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.xS = true;
        return true;
    }

    private OfflineOnAudioConflictListener ok() {
        if (this.xV == null) {
            this.xV = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.offline.init.b.a.2
                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeOccupied() {
                    a.a(a.this, true);
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.init.b.a.2.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.KL.setAudioEnabled(false);
                            if (a.this.KN != null) {
                                a.this.KN.onMuteStateChanged(true);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeReleased() {
                }
            };
        }
        return this.xV;
    }

    public final a a(@NonNull com.kwad.components.core.video.b bVar) {
        an.checkNotNull(bVar);
        this.KL = bVar;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.KL.a(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.KL.a(d.a(getMediaPlayer(), onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void clear() {
        this.KL.clear();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getBufferPercentage() {
        return this.KL.getBufferPercentage();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.KL.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getCurrentPosition() {
        return this.KL.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getDuration() {
        return this.KL.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMaxVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final IMediaPlayer getMediaPlayer() {
        com.kwad.sdk.core.video.kwai.c cVarQw = this.KL.qw();
        if (cVarQw == null) {
            return null;
        }
        c cVar = this.KM;
        if (cVar == null || cVar.om() != cVarQw) {
            this.KM = new c().b(cVarQw);
        }
        return this.KM;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMediaPlayerType() {
        return this.KL.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getPlayDuration() {
        return this.KL.getPlayDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getStateString(int i2) {
        return com.kwad.components.core.video.b.getStateString(i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoHeight() {
        return this.KL.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoWidth() {
        return this.KL.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.b.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
            return;
        }
        this.mDetailVideoView = ((b) iKsMediaPlayerView).ol();
        this.mContext = this.mDetailVideoView.getContext().getApplicationContext();
        this.KL.a(d.a(playVideoInfo), this.mDetailVideoView);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(@NonNull PlayVideoInfo playVideoInfo, boolean z2, boolean z3, @NonNull IKsMediaPlayerView iKsMediaPlayerView) {
        if (iKsMediaPlayerView instanceof b) {
            this.KL.a(d.a(playVideoInfo), z2, z3, ((b) iKsMediaPlayerView).ol());
        } else {
            com.kwad.sdk.core.d.b.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPlaying() {
        return this.KL.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPrepared() {
        return this.KL.isPrepared();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPreparing() {
        return this.KL.isPreparing();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i2, int i3) {
        if (iMediaPlayer instanceof c) {
            this.KL.a(((c) iMediaPlayer).om(), i2, i3);
        } else {
            com.kwad.sdk.core.d.b.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        }
    }

    public final com.kwad.components.core.video.b oj() {
        return this.KL;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void onPlayStateChanged(int i2) {
        this.KL.onPlayStateChanged(i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean pause() {
        return this.KL.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void prepareAsync() {
        this.KL.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener) {
        this.KN = videoMuteStateChangeListener;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoPlayStateListener(VideoPlayStateListener videoPlayStateListener) {
        this.KL.c(d.a(videoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release() {
        this.KL.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback) {
        this.KL.a(d.a(releaseCallback));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback, boolean z2) {
        this.KL.a(d.a(releaseCallback), z2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void releaseSync() {
        this.KL.releaseSync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.KL.b(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resetAndPlay(PlayVideoInfo playVideoInfo) {
        com.kwad.components.core.video.b bVar = this.KL;
        d.a(playVideoInfo);
        bVar.qz();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void restart() {
        this.KL.restart();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resume() {
        this.KL.resume();
        if (this.nG || (this.KO && this.xS)) {
            com.kwad.components.core.r.b.ar(this.mContext).aI(this.KO);
            if (this.KO && this.xS) {
                this.xS = false;
                setAudioEnabled(true);
                this.nG = true;
            } else if (com.kwad.components.core.r.b.ar(this.mContext).pY()) {
                this.nG = false;
                setAudioEnabled(this.nG);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void seekTo(long j2) {
        this.KL.seekTo(j2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setAudioEnabled(final boolean z2) {
        if (z2) {
            com.kwad.components.core.r.b.ar(this.mContext).aI(true);
        }
        if (z2 == this.nG) {
            com.kwad.sdk.core.video.kwai.kwai.a.cu("autoVoice");
        } else {
            this.nG = z2;
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.offline.init.b.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.KL.setAudioEnabled(z2);
                    if (a.this.KN != null) {
                        a.this.KN.onMuteStateChanged(!z2);
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        this.KL.a(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setForceGetAudioFocus(boolean z2) {
        this.KO = z2;
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.r.b.ar(context).a(ok());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setRadius(float f2, float f3, float f4, float f5) {
        this.KL.setRadius(f2, f3, f4, f5);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSpeed(float f2) {
        this.KL.setSpeed(f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSurface(Surface surface) {
        this.KL.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVideoAdaptStrategy(int i2) {
        this.mDetailVideoView.f(true, i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVolume(float f2, float f3) {
        this.KL.setVolume(f2, f3);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start() {
        this.KL.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start(long j2) {
        this.KL.start(j2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void stopAndPrepareAsync() {
        this.KL.stopAndPrepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void unRegisterVideoPlayStateListener(VideoPlayStateListener videoPlayStateListener) {
        this.KL.d(d.a(videoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams) {
        this.KL.a(d.a(ksPlayerLogParams));
    }
}
