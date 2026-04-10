package com.kwad.components.core.o.b.c;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.ax;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class c implements IMediaPlayer {
    private com.kwad.sdk.core.video.a.c SE;

    c() {
    }

    public final c b(com.kwad.sdk.core.video.a.c cVar) {
        ax.checkNotNull(cVar);
        this.SE = cVar;
        return this;
    }

    public final com.kwad.sdk.core.video.a.c qJ() {
        return this.SE;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        this.SE.setDisplay(surfaceHolder);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(Context context, Uri uri) {
        this.SE.setDataSource(context, uri);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.SE.setDataSource(context, uri, map);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.SE.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(String str) {
        this.SE.setDataSource(str);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(PlayVideoInfo playVideoInfo) {
        this.SE.b(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final String getDataSource() {
        return this.SE.getDataSource();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean prepareAsync() {
        return this.SE.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void start() {
        this.SE.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void stop() {
        this.SE.stop();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void pause() {
        this.SE.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setScreenOnWhilePlaying(boolean z) {
        this.SE.setScreenOnWhilePlaying(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getVideoWidth() {
        return this.SE.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getVideoHeight() {
        return this.SE.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.SE.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean isPlaying() {
        return this.SE.isPlaying();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void seekTo(long j) {
        this.SE.seekTo(j);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final long getCurrentPosition() {
        return this.SE.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final long getDuration() {
        return this.SE.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void release() {
        this.SE.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void reset() {
        this.SE.reset();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setVolume(float f, float f2) {
        this.SE.setVolume(f, f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setSpeed(float f) {
        this.SE.setSpeed(f);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getAudioSessionId() {
        return this.SE.getAudioSessionId();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setLooping(boolean z) {
        this.SE.setLooping(z);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean isLooping() {
        return this.SE.isLooping();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setSurface(Surface surface) {
        this.SE.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setAudioStreamType(int i) {
        this.SE.setAudioStreamType(i);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.SE.b(d.a(this, onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.SE.a(d.a(this, onCompletionListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.SE.a(d.a(this, onBufferingUpdateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.SE.a(d.a(this, onSeekCompleteListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.SE.a(d.a(this, onVideoSizeChangedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.SE.a(d.a(this, onErrorListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.SE.c(d.a(this, onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        this.SE.a(d.a(this, onTimedTextListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getMediaPlayerType() {
        return this.SE.getMediaPlayerType();
    }
}
