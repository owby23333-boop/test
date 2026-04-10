package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.media.MediaDataSource;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.ServiceProvider;
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

/* JADX INFO: loaded from: classes4.dex */
public final class d extends com.kwad.sdk.core.video.a.a {
    private static volatile boolean aKq;
    private static final Queue<d> aKr = new ConcurrentLinkedQueue();
    private final String TAG;
    private com.kwad.sdk.contentalliance.a.a.b ZN;
    private MediaDataSource aKm;
    private final KSVodPlayerWrapper aKn;
    private final a aKo;
    private boolean aKp;
    private boolean aKs;
    private final Object aaK;
    private String aaL;
    private boolean aaQ;
    private boolean aaR;
    private int mSarDen;
    private int mSarNum;

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 2;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(FileDescriptor fileDescriptor) {
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setScreenOnWhilePlaying(boolean z) {
    }

    static /* synthetic */ boolean a(d dVar, boolean z) {
        dVar.aaR = false;
        return false;
    }

    public d(int i) {
        Object obj = new Object();
        this.aaK = obj;
        this.aaR = false;
        this.aKs = true;
        synchronized (obj) {
            this.aKn = new KSVodPlayerWrapper(m.Ta());
        }
        String str = "KSMediaPlayer[" + i + "]";
        this.TAG = str;
        this.aKo = new a(this, str);
        tX();
        setLooping(false);
        com.kwad.sdk.core.d.c.i(str, "create KwaiMediaPlayer");
    }

    public final void bu(boolean z) {
        this.aKs = z;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        synchronized (this.aaK) {
            if (!this.aaQ) {
                this.aKn.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        setDataSource(str, (Map<String, String>) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(com.kwad.sdk.contentalliance.a.a.b bVar) {
        this.ZN = bVar;
        a(bVar.awz);
        f fVar = (f) ServiceProvider.get(f.class);
        if (!TextUtils.isEmpty(bVar.manifest) && fVar != null && fVar.wn()) {
            setDataSource(bVar.manifest, (Map<String, String>) null);
        } else {
            setDataSource(bVar.videoUrl, (Map<String, String>) null);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        if (this.aKn == null || aVar == null) {
            return;
        }
        KSVodVideoContext kSVodVideoContext = new KSVodVideoContext();
        kSVodVideoContext.mVideoId = String.valueOf(aVar.photoId);
        kSVodVideoContext.mClickTime = aVar.clickTime;
        kSVodVideoContext.mExtra = aVar.Ek();
        this.aKn.updateVideoContext(kSVodVideoContext);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSurface(Surface surface) {
        this.aKn.setSurface(surface);
    }

    private void setDataSource(String str, Map<String, String> map) {
        this.aaL = str;
        this.aKn.setDataSource(str, (Map) null);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aaL;
    }

    private void JW() {
        MediaDataSource mediaDataSource = this.aKm;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.aKm = null;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        if (this.aKs) {
            Queue<d> queue = aKr;
            if (!queue.contains(this)) {
                queue.offer(this);
            }
            int size = queue.size();
            if (size == 1) {
                com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync first");
                JX();
                return true;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync pending size: " + size);
            return false;
        }
        JX();
        return true;
    }

    private void JX() {
        com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare hasCallPrepare: " + this.aaR);
        if (this.aaR) {
            return;
        }
        try {
            this.aaR = true;
            int iPrepareAsync = this.aKn.prepareAsync();
            JV();
            com.kwad.sdk.core.d.c.i(this.TAG, "realPrepare result: " + iPrepareAsync);
        } catch (IllegalStateException e) {
            com.kwad.sdk.core.d.c.e(this.TAG, "realPrepare failed ", e);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean tW() {
        com.kwad.sdk.core.d.c.i(this.TAG, "forcePrepareAsync");
        JX();
        return true;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        com.kwad.sdk.core.d.c.i(this.TAG, TtmlNode.START);
        this.aKn.start();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        this.aKn.stop();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        this.aKn.pause();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        return this.aKn.getKwaiMediaPlayer().getVideoWidth();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        return this.aKn.getKwaiMediaPlayer().getVideoHeight();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        KSVodPlayerWrapper kSVodPlayerWrapper = this.aKn;
        return kSVodPlayerWrapper == null ? "" : kSVodPlayerWrapper.getCurrentPlayUrl();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        try {
            return this.aKn.isPlaying();
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        this.aKn.seekTo((int) j);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        try {
            return this.aKn.getCurrentPosition();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        try {
            return this.aKn.getDuration();
        } catch (IllegalStateException unused) {
            return 0L;
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        Queue<d> queue = aKr;
        com.kwad.sdk.core.d.c.i(this.TAG, "release remote player ret: " + queue.remove(this) + ", player list size: " + queue.size());
        this.aaQ = true;
        this.aKn.releaseAsync(new IKSVodPlayer.OnVodPlayerReleaseListener() { // from class: com.kwad.sdk.core.video.a.d.1
            public final void onPlayerRelease() {
                com.kwad.sdk.core.d.c.i(d.this.TAG, "onPlayerRelease");
            }
        });
        try {
            JW();
            resetListeners();
            tY();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aaR = false;
        try {
            IKwaiMediaPlayer kwaiMediaPlayer = this.aKn.getKwaiMediaPlayer();
            if (kwaiMediaPlayer != null) {
                kwaiMediaPlayer.reset();
            }
        } catch (IllegalStateException unused) {
        }
        JW();
        resetListeners();
        tX();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        this.aKp = z;
        this.aKn.setLooping(z);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        return this.aKp;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        this.aKn.setVolume(f, f2);
        h(f);
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        return this.aKn.getKwaiMediaPlayer().getAudioSessionId();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        this.aKn.setSpeed(f);
    }

    private void tX() {
        this.aKn.setOnPreparedListener(this.aKo);
        this.aKn.setBufferingUpdateListener(this.aKo);
        this.aKn.setOnEventListener(this.aKo);
        this.aKn.setVideoSizeChangedListener(this.aKo);
        this.aKn.setOnErrorListener(this.aKo);
    }

    private void tY() {
        this.aKn.setOnPreparedListener((IKSVodPlayer.OnPreparedListener) null);
        this.aKn.setBufferingUpdateListener((IKSVodPlayer.OnBufferingUpdateListener) null);
        this.aKn.setOnEventListener((IKSVodPlayer.OnEventListener) null);
        this.aKn.setVideoSizeChangedListener((IKSVodPlayer.OnVideoSizeChangedListener) null);
        this.aKn.setOnErrorListener((IKSVodPlayer.OnErrorListener) null);
    }

    static class a implements IKSVodPlayer.OnBufferingUpdateListener, IKSVodPlayer.OnErrorListener, IKSVodPlayer.OnEventListener, IKSVodPlayer.OnPreparedListener, IKSVodPlayer.OnVideoSizeChangedListener, IKSVodPlayer.OnVodPlayerReleaseListener {
        final String TAG;
        final WeakReference<d> mWeakMediaPlayer;

        a(d dVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(dVar);
            this.TAG = str;
        }

        private d JZ() {
            return this.mWeakMediaPlayer.get();
        }

        public final void onEvent(int i, int i2) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onEvent, what: " + i);
            try {
                d dVarJZ = JZ();
                if (dVarJZ != null) {
                    if (i == 10100) {
                        dVarJZ.notifyOnSeekComplete();
                    } else {
                        if (i == 10101) {
                            dVarJZ.notifyOnCompletion();
                            return;
                        }
                        if (i == 10209) {
                            dVarJZ.JY();
                        }
                        dVarJZ.notifyOnInfo(i, i2);
                    }
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }

        public final void onBufferingUpdate(int i) {
            d dVarJZ = JZ();
            if (dVarJZ != null) {
                dVarJZ.notifyOnBufferingUpdate(i);
            }
        }

        public final void onError(int i, int i2) {
            d dVarJZ = JZ();
            if (dVarJZ != null) {
                d.a(dVarJZ, false);
                dVarJZ.notifyOnError(i, i2);
            }
        }

        public final void onPrepared() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPrepared");
            d dVarJZ = JZ();
            if (dVarJZ != null) {
                dVarJZ.notifyOnPrepared();
            }
        }

        public final void onVideoSizeChanged(int i, int i2, int i3, int i4) {
            com.kwad.sdk.core.d.c.i(this.TAG, "onVideoSizeChanged width: " + i + ", height: " + i2 + ", sarNum:" + i3 + ", sarDen:" + i4);
            d dVarJZ = JZ();
            if (dVarJZ != null) {
                dVarJZ.x(i, i2);
                dVarJZ.mSarNum = i3;
                dVarJZ.mSarDen = i4;
            }
        }

        public final void onPlayerRelease() {
            com.kwad.sdk.core.d.c.i(this.TAG, "onPlayerRelease");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JY() {
        Iterator<d> it = aKr.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = 0;
                break;
            } else if (it.next() == this) {
                break;
            } else {
                i++;
            }
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "preloadNextPlayer next player index: " + i);
        int i2 = i + 1;
        if (i2 < aKr.size()) {
            com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepare next player----------------");
            for (int i3 = 0; i3 < i2; i3++) {
                aKr.poll();
            }
            Queue<d> queue = aKr;
            d dVarPoll = queue.poll();
            queue.clear();
            if (dVarPoll != null) {
                dVarPoll.prepareAsync();
            } else {
                com.kwad.sdk.core.d.c.i(this.TAG, "----------------preloadNextPlayer prepareAsync next player is null----------------");
            }
        }
    }
}
