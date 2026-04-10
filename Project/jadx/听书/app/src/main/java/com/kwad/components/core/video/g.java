package com.kwad.components.core.video;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.funny.audio.core.utils.FileUtils;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends com.kwad.sdk.core.video.a.a {
    private static AtomicBoolean aaP = new AtomicBoolean(false);
    private String aaL;
    private com.kwad.components.core.o.a.a.a aaN;
    private IAdWaynePlayerPlayModule aaO;
    private AdTemplate mAdTemplate;
    private final String TAG = "KwaiWaynePlayer";
    private final Object aaK = new Object();
    private boolean aaQ = false;
    private boolean aaR = false;
    private boolean aaS = false;
    private final a aaM = new a(this, "KwaiWaynePlayer");

    @Override // com.kwad.sdk.core.video.a.c
    public final int getMediaPlayerType() {
        return 3;
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

    static /* synthetic */ boolean a(g gVar, boolean z) {
        gVar.aaS = true;
        return true;
    }

    public g(com.kwad.sdk.contentalliance.a.a.b bVar, AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        com.kwad.components.core.o.a.a.a aVar = (com.kwad.components.core.o.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.o.a.a.a.class);
        this.aaN = aVar;
        if (aVar == null || !aVar.qt()) {
            return;
        }
        if (!TextUtils.isEmpty(bVar.manifest)) {
            this.aaL = bVar.manifest;
            this.aaO = this.aaN.getAdWaynePlayerPlayModule(bVar.manifest, true);
        } else {
            this.aaL = bVar.videoUrl;
            this.aaO = this.aaN.getAdWaynePlayerPlayModule(bVar.videoUrl, false);
        }
        if (this.aaO != null) {
            aaP.set(true);
            this.aaO.setLooping(false);
            tX();
        }
    }

    public static boolean isWaynePlayerReady() {
        return aaP.get();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDisplay(SurfaceHolder surfaceHolder) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        synchronized (this.aaK) {
            if (!this.aaQ && (iAdWaynePlayerPlayModule = this.aaO) != null) {
                iAdWaynePlayerPlayModule.setDisplay(surfaceHolder);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setDataSource(String str) {
        if (this.aaO != null) {
            this.aaL = str;
            Uri uri = Uri.parse(str);
            String scheme = uri.getScheme();
            if (!TextUtils.isEmpty(scheme) && scheme.equalsIgnoreCase(FileUtils.URI_TYPE_FILE)) {
                this.aaO.setDataSource(uri.getPath(), false);
            } else {
                this.aaO.setDataSource(str, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void b(com.kwad.sdk.contentalliance.a.a.b bVar) {
        if (this.aaO != null) {
            if (!TextUtils.isEmpty(bVar.manifest)) {
                this.aaL = bVar.manifest;
                this.aaO.setDataSource(bVar.manifest, true);
            } else {
                this.aaL = bVar.videoUrl;
                this.aaO.setDataSource(bVar.videoUrl, false);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getDataSource() {
        return this.aaL;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean prepareAsync() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule;
        if (!this.aaR && (iAdWaynePlayerPlayModule = this.aaO) != null) {
            try {
                this.aaR = true;
                boolean zPrepareAsync = iAdWaynePlayerPlayModule.prepareAsync();
                JV();
                com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "prepareAsync result: " + zPrepareAsync);
                return zPrepareAsync;
            } catch (IllegalStateException e) {
                com.kwad.sdk.core.d.c.e("KwaiWaynePlayer", "prepareAsync failed ", e);
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void start() {
        if (this.aaO != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", TtmlNode.START);
            this.aaO.start();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean tW() {
        return prepareAsync();
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void stop() {
        if (this.aaO != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "stop");
            this.aaO.stop();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void pause() {
        if (this.aaO != null) {
            com.kwad.sdk.core.d.c.i("KwaiWaynePlayer", "pause");
            this.aaO.pause();
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoWidth() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoWidth();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getVideoHeight() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getVideoHeight();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final String getCurrentPlayingUrl() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        return iAdWaynePlayerPlayModule != null ? iAdWaynePlayerPlayModule.getCurrentPlayingUrl() : "";
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isPlaying() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isPlaying();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void seekTo(long j) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.seekTo(j);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getCurrentPosition() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final long getDuration() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getDuration();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void release() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            this.aaQ = true;
            iAdWaynePlayerPlayModule.release();
            try {
                resetListeners();
                tY();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void reset() {
        this.aaR = false;
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.reset();
                resetListeners();
                tX();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setVolume(float f, float f2) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setVolume(f, f2);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSpeed(float f) {
        try {
            IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
            if (iAdWaynePlayerPlayModule != null) {
                iAdWaynePlayerPlayModule.setSpeed(f);
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final int getAudioSessionId() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.getAudioSessionId();
        }
        return 0;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setLooping(boolean z) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setLooping(z);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final boolean isLooping() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            return iAdWaynePlayerPlayModule.isLooping();
        }
        return false;
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setSurface(Surface surface) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setSurface(surface);
        }
    }

    @Override // com.kwad.sdk.core.video.a.c
    public final void setAudioStreamType(int i) {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setAudioStreamType(i);
        }
    }

    private void tX() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(this.aaM);
            this.aaO.setOnCompletionListener(this.aaM);
            this.aaO.setOnBufferingUpdateListener(this.aaM);
            this.aaO.setOnSeekCompleteListener(this.aaM);
            this.aaO.setOnVideoSizeChangedListener(this.aaM);
            this.aaO.setOnErrorListener(this.aaM);
            this.aaO.setOnInfoListener(this.aaM);
            this.aaO.setOnVseReportListener(this.aaM);
        }
    }

    private void tY() {
        IAdWaynePlayerPlayModule iAdWaynePlayerPlayModule = this.aaO;
        if (iAdWaynePlayerPlayModule != null) {
            iAdWaynePlayerPlayModule.setOnPreparedListener(null);
            this.aaO.setOnCompletionListener(null);
            this.aaO.setOnBufferingUpdateListener(null);
            this.aaO.setOnSeekCompleteListener(null);
            this.aaO.setOnVideoSizeChangedListener(null);
            this.aaO.setOnErrorListener(null);
            this.aaO.setOnInfoListener(null);
            this.aaO.setOnVseReportListener(null);
        }
    }

    public final void n(String str, String str2) {
        final com.kwad.components.core.video.a.e eVar = new com.kwad.components.core.video.a.e();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            eVar.setAdTemplate(adTemplate);
        }
        eVar.aN(str);
        eVar.aO(str2);
        com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.video.g.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                com.kwad.sdk.commercial.b.w(eVar);
            }
        });
    }

    static class a implements IAdWaynePlayerPlayModule.OnBufferingUpdateListener, IAdWaynePlayerPlayModule.OnCompletionListener, IAdWaynePlayerPlayModule.OnErrorListener, IAdWaynePlayerPlayModule.OnInfoListener, IAdWaynePlayerPlayModule.OnPreparedListener, IAdWaynePlayerPlayModule.OnSeekCompleteListener, IAdWaynePlayerPlayModule.OnVideoSizeChangedListener, IAdWaynePlayerPlayModule.OnVseReportListener {
        final String TAG;
        final WeakReference<g> mWeakMediaPlayer;

        a(g gVar, String str) {
            this.mWeakMediaPlayer = new WeakReference<>(gVar);
            this.TAG = str;
        }

        private g tZ() {
            return this.mWeakMediaPlayer.get();
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnPreparedListener
        public final void onPrepared() {
            g gVarTZ = tZ();
            if (gVarTZ != null) {
                gVarTZ.notifyOnPrepared();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnInfoListener
        public final boolean onInfo(int i, int i2) {
            g gVarTZ = tZ();
            if (gVarTZ == null) {
                return false;
            }
            if (i == 3) {
                if (gVarTZ.aaS) {
                    return false;
                }
                g.a(gVarTZ, true);
                return gVarTZ.notifyOnInfo(i, i2);
            }
            return gVarTZ.notifyOnInfo(i, i2);
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnErrorListener
        public final boolean onError(int i, int i2) {
            g gVarTZ = tZ();
            if (gVarTZ != null) {
                return gVarTZ.notifyOnError(i, i2);
            }
            return false;
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVideoSizeChangedListener
        public final void onVideoSizeChanged(int i, int i2) {
            g gVarTZ = tZ();
            if (gVarTZ != null) {
                gVarTZ.x(i, i2);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnSeekCompleteListener
        public final void onSeekComplete() {
            g gVarTZ = tZ();
            if (gVarTZ != null) {
                gVarTZ.notifyOnSeekComplete();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnBufferingUpdateListener
        public final void onBufferingUpdate(int i) {
            g gVarTZ = tZ();
            if (gVarTZ != null) {
                gVarTZ.notifyOnBufferingUpdate(i);
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnCompletionListener
        public final void onCompletion() {
            g gVarTZ = tZ();
            if (gVarTZ != null) {
                gVarTZ.notifyOnCompletion();
            }
        }

        @Override // com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule.OnVseReportListener
        public final void onVseReport(String str, String str2) {
            g gVarTZ = tZ();
            if (gVarTZ != null) {
                gVarTZ.n(str, str2);
            }
        }
    }
}
