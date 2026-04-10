package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.core.video.kwai.e;
import com.kwad.sdk.core.video.kwai.f;
import com.kwad.sdk.core.view.AdBasePvFrameLayout;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.g;
import com.kwad.sdk.utils.x;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class a extends AdBasePvFrameLayout implements TextureView.SurfaceTextureListener, c {
    private static AtomicBoolean amJ = new AtomicBoolean(false);
    private int QD;
    private com.kwad.sdk.core.video.kwai.c QE;
    private int QF;
    private long QG;
    private com.kwad.sdk.contentalliance.kwai.kwai.b QI;
    private c.e QP;
    private c.h QQ;
    private c.b QR;
    private c.InterfaceC0446c QS;
    private c.d QT;
    private c.a QU;
    private SurfaceTexture Rb;
    private Surface Rc;
    private AudioManager amF;
    private com.kwad.sdk.core.video.a amG;
    private b amH;
    private boolean amI;
    private boolean amK;
    private boolean amL;
    private ImageView amM;
    private com.kwad.sdk.contentalliance.kwai.kwai.a dh;
    private FrameLayout hv;
    private Context mContext;
    private Map<String, String> mHeaders;
    private String mUrl;

    public a(Context context) {
        this(context, null);
    }

    private a(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.QD = 0;
        this.amI = false;
        this.amK = false;
        this.amL = false;
        this.QP = new c.e() { // from class: com.kwad.sdk.core.video.videoview.a.1
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                a.this.QD = 2;
                a.this.amH.onPlayStateChanged(a.this.QD);
                com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "onPrepared ——> STATE_PREPARED");
                cVar.start();
                if (a.this.amI) {
                    cVar.seekTo((int) x.K(a.this.mContext, a.this.mUrl));
                }
                if (a.this.QG != 0) {
                    cVar.seekTo((int) a.this.QG);
                }
            }
        };
        this.QQ = new c.h() { // from class: com.kwad.sdk.core.video.videoview.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.h
            public final void i(int i2, int i3) {
                if (!a.this.amL || i3 <= i2) {
                    a.this.amG.adaptVideoSize(i2, i3);
                    com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
                }
            }
        };
        this.QR = new c.b() { // from class: com.kwad.sdk.core.video.videoview.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.b
            public final void on() {
                if (a.this.QD != 9) {
                    a.this.QD = 9;
                    a.this.amH.onPlayStateChanged(a.this.QD);
                    com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "onCompletion ——> STATE_COMPLETED");
                    a.this.hv.setKeepScreenOn(false);
                }
            }
        };
        this.QS = new c.InterfaceC0446c() { // from class: com.kwad.sdk.core.video.videoview.a.4
            @Override // com.kwad.sdk.core.video.kwai.c.InterfaceC0446c
            public final boolean j(int i2, int i3) {
                if (i2 == -38) {
                    return true;
                }
                a.this.QD = -1;
                a.this.amH.l(i2, i3);
                a.this.amH.onPlayStateChanged(a.this.QD);
                com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
        };
        this.QT = new c.d() { // from class: com.kwad.sdk.core.video.videoview.a.5
            @Override // com.kwad.sdk.core.video.kwai.c.d
            public final boolean k(int i2, int i3) {
                String str;
                String str2;
                if (i2 == 3) {
                    a.this.QD = 4;
                    a.this.amH.onPlayStateChanged(a.this.QD);
                    str = "onInfo ——> MEDIA_INFO_VIDEO_RENDERING_START：STATE_PLAYING";
                } else {
                    if (i2 == 701) {
                        if (a.this.QD == 5 || a.this.QD == 7) {
                            a.this.QD = 7;
                            str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED";
                        } else {
                            a.this.QD = 6;
                            str2 = "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING";
                        }
                        com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", str2);
                        a.this.amH.onPlayStateChanged(a.this.QD);
                        return true;
                    }
                    if (i2 == 702) {
                        if (a.this.QD == 6) {
                            a.this.QD = 4;
                            a.this.amH.onPlayStateChanged(a.this.QD);
                            com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                        }
                        if (a.this.QD != 7) {
                            return true;
                        }
                        a.this.QD = 5;
                        a.this.amH.onPlayStateChanged(a.this.QD);
                        str = "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED";
                    } else if (i2 == 10001) {
                        if (a.this.amG == null) {
                            return true;
                        }
                        a.this.amG.setRotation(i3);
                        str = "视频旋转角度：" + i3;
                    } else if (i2 == 801) {
                        str = "视频不能seekTo，为直播视频";
                    } else {
                        str = "onInfo ——> what：" + i2;
                    }
                }
                com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", str);
                return true;
            }
        };
        this.QU = new c.a() { // from class: com.kwad.sdk.core.video.videoview.a.6
            @Override // com.kwad.sdk.core.video.kwai.c.a
            public final void av(int i2) {
                a.this.QF = i2;
            }
        };
        this.mContext = context;
        init();
    }

    private void cq(AdTemplate adTemplate) {
        g gVar = (g) ServiceProvider.get(g.class);
        if (gVar != null) {
            gVar.load(this.amM, d.ce(adTemplate), adTemplate);
        }
    }

    private void init() {
        this.amM = yA();
        this.hv = new FrameLayout(this.mContext);
        addView(this.hv, new FrameLayout.LayoutParams(-1, -1));
    }

    private void qC() {
        if (this.amG == null) {
            this.amG = new com.kwad.sdk.core.video.a(this.mContext);
            this.amG.setSurfaceTextureListener(this);
        }
    }

    private void setPlayType(int i2) {
        VideoPlayerStatus videoPlayerStatus;
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.QI;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        videoPlayerStatus.mVideoPlayerType = i2;
    }

    private ImageView yA() {
        ImageView imageView = new ImageView(this.mContext);
        addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }

    private boolean yB() {
        return this.QD == 6;
    }

    private void yD() {
        if (this.QE == null) {
            f fVar = (f) ServiceProvider.get(f.class);
            this.QE = e.a(this.mContext, false, fVar != null && fVar.sK(), fVar != null && fVar.sL());
            this.QE.setAudioStreamType(3);
            if (this.amK) {
                return;
            }
            this.QE.setVolume(0.0f, 0.0f);
        }
    }

    private void yE() {
        this.hv.removeView(this.amG);
        this.hv.addView(this.amG, 0, new FrameLayout.LayoutParams(-1, -1, 17));
    }

    private void yF() {
        this.hv.setKeepScreenOn(true);
        this.QE.b(this.QP);
        this.QE.a(this.QQ);
        this.QE.a(this.QR);
        this.QE.a(this.QS);
        this.QE.c(this.QT);
        this.QE.a(this.QU);
        try {
            if (this.QI != null && this.dh != null) {
                this.QI.abe = this.dh;
            }
            this.QE.a(this.QI);
            if (this.Rc == null) {
                this.Rc = new Surface(this.Rb);
            }
            this.QE.setSurface(this.Rc);
            if (this.QE.prepareAsync()) {
                this.QD = 1;
                this.amH.onPlayStateChanged(this.QD);
                com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "STATE_PREPARING");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.core.d.b.e("KSVideoPlayerViewView", "打开播放器发生错误", e2);
        }
    }

    private void yG() {
        AudioManager audioManager = this.amF;
        if (audioManager != null) {
            audioManager.abandonAudioFocus(null);
            this.amF = null;
        }
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            cVar.release();
            this.QE = null;
        }
        this.hv.removeView(this.amG);
        Surface surface = this.Rc;
        if (surface != null) {
            surface.release();
            this.Rc = null;
        }
        SurfaceTexture surfaceTexture = this.Rb;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.Rb = null;
        }
        this.QD = 0;
    }

    public final void a(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.b bVar, Map<String, String> map) {
        this.QI = bVar;
        this.mUrl = bVar.videoUrl;
        this.mHeaders = null;
        cq(bVar.adTemplate);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final int getBufferPercentage() {
        return this.QF;
    }

    public final b getController() {
        return this.amH;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final long getDuration() {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final int getMaxVolume() {
        AudioManager audioManager = this.amF;
        if (audioManager != null) {
            return audioManager.getStreamMaxVolume(3);
        }
        return 0;
    }

    public final b getVideoController() {
        return this.amH;
    }

    public final int getVolume() {
        AudioManager audioManager = this.amF;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    public final boolean isCompleted() {
        return this.QD == 9;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isIdle() {
        return this.QD == 0;
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean isPaused() {
        return this.QD == 5;
    }

    public final boolean isPlaying() {
        return this.QD == 4;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        SurfaceTexture surfaceTexture2 = this.Rb;
        if (surfaceTexture2 != null) {
            this.amG.setSurfaceTexture(surfaceTexture2);
        } else {
            this.Rb = surfaceTexture;
            yF();
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void pause() {
        String str;
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar == null) {
            return;
        }
        int i2 = this.QD;
        if (i2 == 4) {
            cVar.pause();
            this.QD = 5;
            this.amH.onPlayStateChanged(this.QD);
            str = "STATE_PAUSED";
        } else {
            if (i2 != 6) {
                return;
            }
            cVar.pause();
            this.QD = 7;
            this.amH.onPlayStateChanged(this.QD);
            str = "STATE_BUFFERING_PAUSED";
        }
        com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", str);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void release() {
        Context context;
        String str;
        long currentPosition;
        if (this.amI) {
            if (isPlaying() || yB() || yC() || isPaused()) {
                context = this.mContext;
                str = this.mUrl;
                currentPosition = getCurrentPosition();
            } else if (isCompleted()) {
                context = this.mContext;
                str = this.mUrl;
                currentPosition = 0;
            }
            x.e(context, str, currentPosition);
        }
        yG();
        b bVar = this.amH;
        if (bVar != null) {
            bVar.reset();
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void restart() {
        int i2 = this.QD;
        if (i2 == 5) {
            this.QE.start();
            this.QD = 4;
            this.amH.onPlayStateChanged(this.QD);
            setPlayType(2);
            com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "STATE_PLAYING");
            return;
        }
        if (i2 == 7) {
            this.QE.start();
            this.QD = 6;
            this.amH.onPlayStateChanged(this.QD);
            com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "STATE_BUFFERING_PLAYING");
            return;
        }
        if (i2 == 9 || i2 == -1) {
            this.QE.reset();
            yF();
            setPlayType(3);
        } else {
            com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "KSVideoPlayer在状态为 " + this.QD + " 时不能调用restart()方法.");
        }
    }

    public final void seekTo(int i2) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            cVar.seekTo(i2);
        }
    }

    public final void setController(b bVar) {
        this.hv.removeView(this.amH);
        this.amH = bVar;
        this.amH.reset();
        this.hv.addView(this.amH, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void setKsPlayLogParam(@NonNull com.kwad.sdk.contentalliance.kwai.kwai.a aVar) {
        this.dh = aVar;
    }

    public final void setLooping(boolean z2) {
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            cVar.setLooping(z2);
        }
    }

    public final void setPortraitFullscreen(boolean z2) {
        this.amL = z2;
    }

    public final void setVideoSoundEnable(boolean z2) {
        this.amK = z2;
        com.kwad.sdk.core.video.kwai.c cVar = this.QE;
        if (cVar != null) {
            if (z2) {
                cVar.setVolume(1.0f, 1.0f);
            } else {
                cVar.setVolume(0.0f, 0.0f);
            }
        }
    }

    public final void setVolume(int i2) {
        AudioManager audioManager = this.amF;
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final void start() {
        VideoPlayerStatus videoPlayerStatus;
        if (this.QD != 0) {
            com.kwad.sdk.core.d.b.i("KSVideoPlayerViewView", "KSVideoPlayer只有在状态为STATE_IDLE时才能调用start方法.");
            return;
        }
        yD();
        qC();
        yE();
        com.kwad.sdk.contentalliance.kwai.kwai.b bVar = this.QI;
        if (bVar == null || (videoPlayerStatus = bVar.videoPlayerStatus) == null) {
            return;
        }
        setPlayType(videoPlayerStatus.mVideoPlayerType == 0 ? 1 : 3);
    }

    @Override // com.kwad.sdk.core.video.videoview.c
    public final boolean yC() {
        return this.QD == 7;
    }
}
