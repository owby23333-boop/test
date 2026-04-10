package com.kwad.components.core.o.b.c;

import android.content.Context;
import android.view.Surface;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.components.offline.api.core.video.IKsMediaPlayer;
import com.kwad.components.offline.api.core.video.IKsMediaPlayerView;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.listener.OfflineVideoPlayStateListener;
import com.kwad.components.offline.api.core.video.listener.ReleaseCallback;
import com.kwad.components.offline.api.core.video.listener.VideoMuteStateChangeListener;
import com.kwad.components.offline.api.core.video.mdoel.KsPlayerLogParams;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;

/* JADX INFO: loaded from: classes3.dex */
final class a implements IKsMediaPlayer {
    private boolean Bj;
    private OfflineOnAudioConflictListener Bm;
    private com.kwad.components.core.video.b Su;
    private c Sv;
    private VideoMuteStateChangeListener Sw;
    private boolean Sx;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private boolean pW = true;
    private int Sy = -1;

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMaxVolume() {
        return 0;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVolume() {
        return 0;
    }

    a() {
    }

    static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.pW = false;
        return false;
    }

    public final a a(com.kwad.components.core.video.b bVar) {
        ax.checkNotNull(bVar);
        this.Su = bVar;
        return this;
    }

    public final com.kwad.components.core.video.b qG() {
        return this.Su;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final IMediaPlayer getMediaPlayer() {
        com.kwad.sdk.core.video.a.c cVarTz = this.Su.tz();
        if (cVarTz == null) {
            return null;
        }
        c cVar = this.Sv;
        if (cVar == null || cVar.qJ() != cVarTz) {
            this.Sv = new c().b(cVarTz);
        }
        return this.Sv;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSurface(Surface surface) {
        this.Su.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(PlayVideoInfo playVideoInfo, IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
            return;
        }
        DetailVideoView detailVideoViewQI = ((b) iKsMediaPlayerView).qI();
        this.mDetailVideoView = detailVideoViewQI;
        this.mContext = detailVideoViewQI.getContext().getApplicationContext();
        this.Su.a(d.a(playVideoInfo), this.mDetailVideoView);
        int i = this.Sy;
        if (i != -1) {
            setVideoAdaptStrategy(i);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void initMediaPlayer(PlayVideoInfo playVideoInfo, boolean z, boolean z2, IKsMediaPlayerView iKsMediaPlayerView) {
        if (!(iKsMediaPlayerView instanceof b)) {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.Su.a(d.a(playVideoInfo), z, z2, ((b) iKsMediaPlayerView).qI());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getMediaPlayerType() {
        return this.Su.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.Su.a(d.a(getMediaPlayer(), onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void addOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Su.a(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void removeInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.Su.b(d.a(getMediaPlayer(), onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void notifyOnInfoListener(IMediaPlayer iMediaPlayer, int i, int i2) {
        if (!(iMediaPlayer instanceof c)) {
            com.kwad.sdk.core.d.c.e("KsMediaPlayer", "videoView not instanceof KsMediaPlayerView");
        } else {
            this.Su.a(((c) iMediaPlayer).qJ(), i, i2);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setRadius(float f, float f2, float f3, float f4) {
        this.Su.setRadius(f, f2, f3, f4);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPreparing() {
        return this.Su.isPreparing();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPrepared() {
        return this.Su.isPrepared();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean isPlaying() {
        return this.Su.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setDataSource(PlayVideoInfo playVideoInfo) {
        this.Su.b(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void prepareAsync() {
        this.Su.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start() {
        this.Su.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void start(long j) {
        this.Su.start(j);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void restart() {
        this.Su.restart();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resetAndPlay(PlayVideoInfo playVideoInfo) {
        com.kwad.components.core.video.b bVar = this.Su;
        d.a(playVideoInfo);
        bVar.tC();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void resume() {
        this.Su.resume();
        if (this.pW || (this.Sx && this.Bj)) {
            Context context = this.mContext;
            if (context != null) {
                com.kwad.components.core.t.a.aC(context).aQ(this.Sx);
            }
            if (this.Sx && this.Bj) {
                this.Bj = false;
                setAudioEnabled(true);
                this.pW = true;
            } else if (this.Bj) {
                setAudioEnabled(false);
            }
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void stopAndPrepareAsync() {
        this.Su.stopAndPrepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean pause() {
        return this.Su.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback, boolean z) {
        this.Su.a(d.a(releaseCallback), z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release(ReleaseCallback releaseCallback) {
        this.Su.a(d.a(releaseCallback));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void release() {
        this.Su.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void releaseAsync() {
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.t.a.aC(context).b(this.Bm);
        }
        this.Su.releaseAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void seekTo(long j) {
        this.Su.seekTo(j);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVolume(float f, float f2) {
        this.Su.setVolume(f, f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setAudioEnabled(final boolean z) {
        Context context;
        if (z && (context = this.mContext) != null) {
            com.kwad.components.core.t.a.aC(context).aQ(true);
        }
        if (z == this.pW) {
            com.kwad.sdk.core.video.a.a.a.eE("autoVoice");
        } else {
            this.pW = z;
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.o.b.c.a.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    a.this.Su.setAudioEnabled(z);
                    if (a.this.Sw != null) {
                        a.this.Sw.onMuteStateChanged(!z);
                    }
                }
            });
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setSpeed(float f) {
        this.Su.setSpeed(f);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoWidth() {
        return this.Su.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getVideoHeight() {
        return this.Su.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getDuration() {
        return this.Su.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getPlayDuration() {
        return this.Su.getPlayDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final long getCurrentPosition() {
        return this.Su.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final int getBufferPercentage() {
        return this.Su.getBufferPercentage();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Su.c(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void unRegisterVideoPlayStateListener(OfflineVideoPlayStateListener offlineVideoPlayStateListener) {
        this.Su.d(d.a(offlineVideoPlayStateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void registerVideoMuteStateListener(VideoMuteStateChangeListener videoMuteStateChangeListener) {
        this.Sw = videoMuteStateChangeListener;
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void clear() {
        this.Su.clear();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void onPlayStateChanged(int i) {
        this.Su.onPlayStateChanged(i);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getStateString(int i) {
        return com.kwad.components.core.video.b.getStateString(i);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void updateKsPlayLogParam(KsPlayerLogParams ksPlayerLogParams) {
        this.Su.a(d.a(ksPlayerLogParams));
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.Su.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setForceGetAudioFocus(boolean z) {
        this.Sx = z;
        Context context = this.mContext;
        if (context != null) {
            com.kwad.components.core.t.a.aC(context).a(qH());
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setVideoAdaptStrategy(int i) {
        this.Sy = i;
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.g(true, i);
        }
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setIsAlphaVideoPlayer(boolean z) {
        this.Su.setIsAlphaVideoPlayer(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final boolean getAlphaVideoValid() {
        return this.Su.getAlphaVideoValid();
    }

    @Override // com.kwad.components.offline.api.core.video.IKsMediaPlayer
    public final void setTKPlayer() {
        this.Su.setTKPlayer();
    }

    private OfflineOnAudioConflictListener qH() {
        if (this.Bm == null) {
            this.Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.o.b.c.a.2
                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeOccupied() {
                    if (a.this.pW) {
                        a.this.Bj = true;
                        a.b(a.this, false);
                    }
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.o.b.c.a.2.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.this.Su.setAudioEnabled(false);
                            if (a.this.Sw != null) {
                                a.this.Sw.onMuteStateChanged(true);
                            }
                        }
                    });
                }

                @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
                public final void onAudioBeReleased() {
                    a.this.Bj = false;
                }
            };
        }
        return this.Bm;
    }
}
