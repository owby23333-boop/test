package com.kwad.sdk.core.video.kwai;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bo;
import com.kwai.video.ksvodplayerkit.IKSVodPlayer;
import com.kwai.video.ksvodplayerkit.KSVodPlayerWrapper;
import com.kwai.video.ksvodplayerkit.KSVodVideoContext;
import com.kwai.video.player.IKwaiMediaPlayer;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.kwad.sdk.core.video.kwai.a {
    private static volatile boolean amx = false;
    private static final Queue<d> amy = new ConcurrentLinkedQueue();
    private com.kwad.sdk.contentalliance.kwai.kwai.b QI;
    private String amp;
    private MediaDataSource amq;
    private boolean ams;
    private final KSVodPlayerWrapper amt;
    private final a amu;
    private boolean amv;
    private int mSarDen;
    private int mSarNum;
    private final Object amr = new Object();
    private boolean amw = false;
    private boolean amz = true;

    static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final WeakReference<d> mWeakMediaPlayer;

        a(d dVar) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
        }

        private d yx() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onBufferingUpdate(int i2) {
            d dVarYx = yx();
            if (dVarYx != null) {
                dVarYx.notifyOnBufferingUpdate(i2);
            }
        }

        public final void onError(int i2, int i3) {
            d dVarYx = yx();
            if (dVarYx != null) {
                d.a(dVarYx, false);
                dVarYx.notifyOnError(i2, i3);
            }
        }

        public final void onEvent(int i2, int i3) {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onEvent, what: " + i2);
            d dVarYx = yx();
            if (dVarYx != null) {
                if (i2 == 10100) {
                    dVarYx.notifyOnSeekComplete();
                } else {
                    if (i2 == 10101) {
                        dVarYx.notifyOnCompletion();
                        return;
                    }
                    if (i2 == 10209) {
                        dVarYx.yw();
                    }
                    dVarYx.notifyOnInfo(i2, i3);
                }
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onPlayerRelease");
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onPrepared");
            d dVarYx = yx();
            if (dVarYx != null) {
                dVarYx.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onVideoSizeChanged width: " + i2 + ", height: " + i3 + ", sarNum:" + i4 + ", sarDen:" + i5);
            d dVarYx = yx();
            if (dVarYx != null) {
                dVarYx.q(i2, i3);
                dVarYx.mSarNum = i4;
                dVarYx.mSarDen = i5;
            }
        }
    }

    public d(@NonNull Context context) {
        synchronized (this.amr) {
            this.amt = new KSVodPlayerWrapper(bo.dt(context));
        }
        this.amu = new a(this);
        yt();
        setLooping(false);
    }

    static /* synthetic */ boolean a(d dVar, boolean z2) {
        dVar.amw = false;
        return false;
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.amp = str;
        this.amt.setDataSource(str, (Map) null);
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
        this.amt.setOnPreparedListener(this.amu);
        this.amt.setBufferingUpdateListener(this.amu);
        this.amt.setOnEventListener(this.amu);
        this.amt.setVideoSizeChangedListener(this.amu);
        this.amt.setOnErrorListener(this.amu);
    }

    private void yu() {
        this.amt.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.amt.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.amt.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.amt.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.amt.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    private void yv() {
        if (this.amw) {
            return;
        }
        try {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "realPrepare: ret: " + this.amt.prepareAsync());
        } catch (IllegalStateException e2) {
            com.kwad.sdk.core.d.b.e("KwaiMediaPlayer", "realPrepare failed", e2);
        }
        this.amw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw() {
        Queue<d> queue;
        Iterator<d> it = amy.iterator();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i3++;
            }
        }
        com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "preloadNextPlayer next player index: " + i3);
        int i4 = i3 + 1;
        if (i4 < amy.size()) {
            com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "----------------preloadNextPlayer prepare next player----------------");
            while (true) {
                queue = amy;
                if (i2 >= i4) {
                    break;
                }
                queue.poll();
                i2++;
            }
            d dVarPoll = queue.poll();
            amy.clear();
            if (dVarPoll != null) {
                dVarPoll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }

    public final void a(com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        if (this.amt == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.ub();
        this.amt.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar) {
        this.QI = bVar;
        a(this.QI.abe);
        f fVar = (f) ServiceProvider.get(f.class);
        setDataSource((TextUtils.isEmpty(bVar.manifest) || fVar == null || !fVar.rZ()) ? bVar.videoUrl : bVar.manifest, (Map<String, String>) null);
    }

    public final void aT(boolean z2) {
        this.amz = z2;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getAudioSessionId() {
        return this.amt.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.amt;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final long getCurrentPosition() {
        try {
            return this.amt.getCurrentPosition();
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
            return this.amt.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoHeight() {
        return this.amt.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final int getVideoWidth() {
        return this.amt.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isLooping() {
        return this.amv;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean isPlaying() {
        try {
            return this.amt.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void pause() {
        this.amt.pause();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final boolean prepareAsync() {
        if (!this.amz) {
            yv();
            return true;
        }
        if (!amy.contains(this)) {
            amy.offer(this);
        }
        if (amy.size() != 1) {
            return false;
        }
        yv();
        com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "prepareAsync first");
        return true;
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void release() {
        com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "release remote player ret: " + amy.remove(this) + ", player list size: " + amy.size());
        this.ams = true;
        this.amt.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.kwai.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", "onPlayerRelease");
            }
        });
        ys();
        resetListeners();
        yu();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void reset() {
        this.amw = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.amt.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        ys();
        resetListeners();
        yt();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void seekTo(long j2) {
        this.amt.seekTo((int) j2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setAudioStreamType(int i2) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.amr) {
            if (!this.ams) {
                this.amt.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setLooping(boolean z2) {
        this.amv = z2;
        this.amt.setLooping(z2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setScreenOnWhilePlaying(boolean z2) {
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setSpeed(float f2) {
        this.amt.setSpeed(f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    @TargetApi(14)
    public final void setSurface(Surface surface) {
        this.amt.setSurface(surface);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void setVolume(float f2, float f3) {
        this.amt.setVolume(f2, f3);
        com.kwad.sdk.core.video.kwai.a.f(f2);
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void start() {
        com.kwad.sdk.core.d.b.i("KwaiMediaPlayer", com.anythink.expressad.foundation.d.c.bT);
        yv();
        this.amt.start();
    }

    @Override // com.kwad.sdk.core.video.kwai.c
    public final void stop() {
        this.amt.stop();
    }
}
