package com.kwad.components.core.offline.init.b;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.video.IMediaPlayer;
import com.kwad.components.offline.api.core.video.mdoel.PlayVideoInfo;
import com.kwad.sdk.utils.an;
import java.io.FileDescriptor;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class c implements IMediaPlayer {
    private com.kwad.sdk.core.video.kwai.c KU;

    c() {
    }

    public final c b(@NonNull com.kwad.sdk.core.video.kwai.c cVar) {
        an.checkNotNull(cVar);
        this.KU = cVar;
        return this;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getAudioSessionId() {
        return this.KU.getAudioSessionId();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final String getCurrentPlayingUrl() {
        return this.KU.getCurrentPlayingUrl();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final long getCurrentPosition() {
        return this.KU.getCurrentPosition();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final String getDataSource() {
        return this.KU.getDataSource();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final long getDuration() {
        return this.KU.getDuration();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getMediaPlayerType() {
        return this.KU.getMediaPlayerType();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getVideoHeight() {
        return this.KU.getVideoHeight();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final int getVideoWidth() {
        return this.KU.getVideoWidth();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean isLooping() {
        return this.KU.isLooping();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean isPlaying() {
        return this.KU.isPlaying();
    }

    public final com.kwad.sdk.core.video.kwai.c om() {
        return this.KU;
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void pause() {
        this.KU.pause();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final boolean prepareAsync() {
        return this.KU.prepareAsync();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void release() {
        this.KU.release();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void reset() {
        this.KU.reset();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void seekTo(long j2) {
        this.KU.seekTo(j2);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setAudioStreamType(int i2) {
        this.KU.setAudioStreamType(i2);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(Context context, Uri uri) {
        this.KU.setDataSource(context, uri);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        this.KU.setDataSource(context, uri, map);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(@NonNull PlayVideoInfo playVideoInfo) {
        this.KU.a(d.a(playVideoInfo));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(FileDescriptor fileDescriptor) {
        this.KU.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDataSource(String str) {
        this.KU.setDataSource(str);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        this.KU.setDisplay(surfaceHolder);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setLooping(boolean z2) {
        this.KU.setLooping(z2);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnBufferingUpdateListener(IMediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.KU.a(d.a(this, onBufferingUpdateListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnCompletionListener(IMediaPlayer.OnCompletionListener onCompletionListener) {
        this.KU.a(d.a(this, onCompletionListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnErrorListener(IMediaPlayer.OnErrorListener onErrorListener) {
        this.KU.a(d.a(this, onErrorListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnInfoListener(IMediaPlayer.OnInfoListener onInfoListener) {
        this.KU.c(d.a(this, onInfoListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnPreparedListener(IMediaPlayer.OnPreparedListener onPreparedListener) {
        this.KU.b(d.a(this, onPreparedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnSeekCompleteListener(IMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.KU.a(d.a(this, onSeekCompleteListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnTimedTextListener(IMediaPlayer.OnTimedTextListener onTimedTextListener) {
        this.KU.a(d.a(this, onTimedTextListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setOnVideoSizeChangedListener(IMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.KU.a(d.a(this, onVideoSizeChangedListener));
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setScreenOnWhilePlaying(boolean z2) {
        this.KU.setScreenOnWhilePlaying(z2);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setSpeed(float f2) {
        this.KU.setSpeed(f2);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setSurface(Surface surface) {
        this.KU.setSurface(surface);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void setVolume(float f2, float f3) {
        this.KU.setVolume(f2, f3);
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void start() {
        this.KU.start();
    }

    @Override // com.kwad.components.offline.api.core.video.IMediaPlayer
    public final void stop() {
        this.KU.stop();
    }
}
