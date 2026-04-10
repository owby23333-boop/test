package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import cn.bmob.v3.util.BmobDbOpenHelper;
import com.anythink.expressad.exoplayer.k.o;
import com.kwad.sdk.service.ServiceProvider;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.sdk.core.video.kwai.a {
    private final MediaPlayer amn;
    private final a amo;
    private String amp;
    private MediaDataSource amq;
    private final Object amr = new Object();
    private boolean ams;

    static class a implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnTimedTextListener, MediaPlayer.OnVideoSizeChangedListener {
        final WeakReference<b> mWeakMediaPlayer;

        a(b bVar) {
            this.mWeakMediaPlayer = new WeakReference<>(bVar);
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnBufferingUpdate(i2);
            }
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public final void onCompletion(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnCompletion();
            }
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnError(i2, i3);
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.mWeakMediaPlayer.get();
            return bVar != null && bVar.notifyOnInfo(i2, i3);
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnPrepared();
            }
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(MediaPlayer mediaPlayer) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.notifyOnSeekComplete();
            }
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public final void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.b(timedText);
            }
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            b bVar = this.mWeakMediaPlayer.get();
            if (bVar != null) {
                bVar.q(i2, i3);
            }
        }
    }

    public b() {
        synchronized (this.amr) {
            this.amn = new MediaPlayer();
        }
        this.amn.setAudioStreamType(3);
        this.amo = new a(this);
        yt();
        setLooping(false);
    }

    private void ys() {
        MediaDataSource mediaDataSource = this.amq;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.amq = null;
        }
    }

    private void yt() {
        this.amn.setOnPreparedListener(this.amo);
        this.amn.setOnBufferingUpdateListener(this.amo);
        this.amn.setOnCompletionListener(this.amo);
        this.amn.setOnSeekCompleteListener(this.amo);
        this.amn.setOnVideoSizeChangedListener(this.amo);
        this.amn.setOnErrorListener(this.amo);
        this.amn.setOnInfoListener(this.amo);
        this.amn.setOnTimedTextListener(this.amo);
    }

    private void yu() {
        this.amn.setOnPreparedListener(null);
        this.amn.setOnBufferingUpdateListener(null);
        this.amn.setOnCompletionListener(null);
        this.amn.setOnSeekCompleteListener(null);
        this.amn.setOnVideoSizeChangedListener(null);
        this.amn.setOnErrorListener(null);
        this.amn.setOnInfoListener(null);
        this.amn.setOnTimedTextListener(null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) throws IOException {
        if (!bVar.isNoCache) {
            setDataSource(bVar.videoUrl);
            return;
        }
        HashMap map = new HashMap();
        map.put("Content-Type", o.f9860e);
        map.put(DownloadUtils.ACCEPT_RANGES, "bytes");
        map.put("Status", "206");
        map.put("Cache-control", "no-cache");
        setDataSource(((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getContext(), Uri.parse(bVar.videoUrl), map);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getAudioSessionId() {
        return this.amn.getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getCurrentPlayingUrl() {
        return "";
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getCurrentPosition() {
        try {
            return this.amn.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getDataSource() {
        return this.amp;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getDuration() {
        try {
            return this.amn.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getMediaPlayerType() {
        return 1;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoHeight() {
        return this.amn.getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoWidth() {
        return this.amn.getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isLooping() {
        return this.amn.isLooping();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isPlaying() {
        try {
            return this.amn.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void pause() {
        this.amn.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean prepareAsync() {
        this.amn.prepareAsync();
        return true;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void release() {
        try {
            this.ams = true;
            this.amn.release();
            ys();
            resetListeners();
            yu();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void reset() {
        try {
            this.amn.reset();
        } catch (IllegalStateException unused) {
        }
        ys();
        resetListeners();
        yt();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void seekTo(long j2) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.amn.seekTo((int) j2, 3);
        } else {
            this.amn.seekTo((int) j2);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setAudioStreamType(int i2) {
        this.amn.setAudioStreamType(i2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri) throws IOException {
        this.amn.setDataSource(context, uri);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) throws IOException {
        this.amn.setDataSource(context, uri, map);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        this.amn.setDataSource(fileDescriptor);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(String str) throws IOException {
        this.amp = str;
        Uri uri = Uri.parse(str);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || !scheme.equalsIgnoreCase(BmobDbOpenHelper.FILE)) {
            this.amn.setDataSource(str);
        } else {
            this.amn.setDataSource(uri.getPath());
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.amr) {
            if (!this.ams) {
                this.amn.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setLooping(boolean z2) {
        this.amn.setLooping(z2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setScreenOnWhilePlaying(boolean z2) {
        this.amn.setScreenOnWhilePlaying(z2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setSpeed(float f2) {
        if (Build.VERSION.SDK_INT >= 23) {
            PlaybackParams playbackParams = this.amn.getPlaybackParams();
            if (playbackParams == null) {
                playbackParams = new PlaybackParams();
            }
            playbackParams.setSpeed(f2);
            this.amn.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.amn.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setVolume(float f2, float f3) {
        this.amn.setVolume(f2, f3);
        com.kwad.sdk.core.video.kwai.a.f(f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void start() {
        this.amn.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void stop() {
        this.amn.stop();
    }
}
