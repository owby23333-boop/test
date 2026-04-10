package com.kwad.components.core.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    private static boolean ZG;
    private static final AtomicInteger ZH = new AtomicInteger(0);
    private final String TAG;
    private volatile int ZI;
    private com.kwad.sdk.core.video.a.c ZJ;
    private int ZK;
    private long ZL;
    private Runnable ZM;
    private com.kwad.sdk.contentalliance.a.a.b ZN;
    private int ZO;
    private List<c.d> ZP;
    private final AtomicBoolean ZQ;
    private boolean ZR;
    private boolean ZS;
    private final int ZU;
    private boolean ZV;
    private volatile List<l> ZW;
    private volatile List<com.kwad.components.core.video.a.c> ZX;
    private volatile List<c.e> ZY;
    private final c.f ZZ;
    private int Zo;
    private int Zp;
    private c.e aaa;
    private c.i aab;
    private c.b aac;
    private c.InterfaceC0408c aad;
    private c.d aae;
    private c.a aaf;
    private Handler iK;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private float mSpeed;
    private long mStartTime;

    /* JADX INFO: loaded from: classes3.dex */
    public interface a {
        void onReleaseSuccess();
    }

    public static String getStateString(int i) {
        switch (i) {
            case -1:
                return "STATE_ERROR";
            case 0:
                return "STATE_IDLE";
            case 1:
                return "STATE_PREPARING";
            case 2:
                return "STATE_PREPARED";
            case 3:
                return "STATE_STARTED";
            case 4:
                return "STATE_PLAYING";
            case 5:
                return "STATE_PAUSED";
            case 6:
                return "STATE_BUFFERING_PLAYING";
            case 7:
                return "STATE_BUFFERING_PAUSED";
            case 8:
                return "PLAYER_STATE_STOPPED";
            case 9:
                return "STATE_COMPLETED";
            default:
                return "STATE_UNKNOWN";
        }
    }

    public b(DetailVideoView detailVideoView) {
        this(detailVideoView, 0);
    }

    private b(DetailVideoView detailVideoView, int i) {
        this.ZI = 0;
        this.iK = new Handler(Looper.getMainLooper());
        this.mStartTime = 0L;
        this.ZO = 0;
        this.ZP = new CopyOnWriteArrayList();
        this.ZQ = new AtomicBoolean(false);
        this.ZR = false;
        this.ZS = false;
        this.ZV = false;
        this.mSpeed = 1.0f;
        this.ZW = new CopyOnWriteArrayList();
        this.ZX = new CopyOnWriteArrayList();
        this.ZY = new CopyOnWriteArrayList();
        this.ZZ = new c.f() { // from class: com.kwad.components.core.video.b.1
            @Override // com.kwad.sdk.core.video.a.c.f
            public final void tG() {
                b.this.ZI = 1;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.ZI);
            }
        };
        this.aaa = new c.e() { // from class: com.kwad.components.core.video.b.4
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                try {
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onPrepared:" + b.getStateString(b.this.ZI) + "->STATE_PREPARED");
                    b.this.ZI = 2;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.ZI);
                    Iterator it = b.this.ZY.iterator();
                    while (it.hasNext()) {
                        ((c.e) it.next()).a(b.this.ZJ);
                    }
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        };
        this.aab = new c.i() { // from class: com.kwad.components.core.video.b.5
            @Override // com.kwad.sdk.core.video.a.c.i
            public final void l(int i2, int i3) {
                if (b.this.mDetailVideoView != null) {
                    b.this.mDetailVideoView.adaptVideoSize(i2, i3);
                }
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onVideoSizeChanged ——> width：" + i2 + "， height：" + i3);
            }
        };
        this.aac = new c.b() { // from class: com.kwad.components.core.video.b.6
            @Override // com.kwad.sdk.core.video.a.c.b
            public final void qK() {
                b.this.ZI = 9;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.ZI);
                com.kwad.sdk.core.video.a.a.a.eE("videoFinishPlay");
            }
        };
        this.aad = new c.InterfaceC0408c() { // from class: com.kwad.components.core.video.b.7
            @Override // com.kwad.sdk.core.video.a.c.InterfaceC0408c
            public final boolean m(int i2, int i3) {
                if (i2 == -38) {
                    return true;
                }
                b.this.ZI = -1;
                b.this.Zo = i2;
                b.this.Zp = i3;
                b bVar = b.this;
                bVar.onPlayStateChanged(bVar.ZI);
                com.kwad.sdk.core.d.c.i(b.this.TAG, "onError ——> STATE_ERROR ———— what：" + i2 + ", extra: " + i3);
                return true;
            }
        };
        this.aae = new c.d() { // from class: com.kwad.components.core.video.b.8
            @Override // com.kwad.sdk.core.video.a.c.d
            public final boolean n(int i2, int i3) {
                if (i2 == 3) {
                    b.this.ZI = 4;
                    b bVar = b.this;
                    bVar.onPlayStateChanged(bVar.ZI);
                    com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo:" + b.getStateString(b.this.ZI) + "->STATE_PLAYING, time: " + (System.currentTimeMillis() - b.this.mStartTime));
                } else if (i2 == 701) {
                    if (b.this.ZI == 5 || b.this.ZI == 7) {
                        b.this.ZI = 7;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PAUSED");
                    } else {
                        b.this.ZI = 6;
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_START：STATE_BUFFERING_PLAYING");
                    }
                    b bVar2 = b.this;
                    bVar2.onPlayStateChanged(bVar2.ZI);
                } else if (i2 == 702) {
                    if (b.this.ZI == 6) {
                        b.this.ZI = 4;
                        b bVar3 = b.this;
                        bVar3.onPlayStateChanged(bVar3.ZI);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PLAYING");
                    }
                    if (b.this.ZI == 7) {
                        b.this.ZI = 5;
                        b bVar4 = b.this;
                        bVar4.onPlayStateChanged(bVar4.ZI);
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> MEDIA_INFO_BUFFERING_END： STATE_PAUSED");
                    }
                } else if (i2 != 10001) {
                    if (i2 == 801) {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "视频不能seekTo，为直播视频");
                    } else {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "onInfo ——> what：" + i2);
                    }
                }
                b bVar5 = b.this;
                bVar5.a(bVar5.ZJ, i2, i3);
                return true;
            }
        };
        this.aaf = new c.a() { // from class: com.kwad.components.core.video.b.9
            @Override // com.kwad.sdk.core.video.a.c.a
            public final void aK(int i2) {
                b.this.ZK = i2;
            }
        };
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView != null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.ZU = 0;
        this.TAG = "DetailMediaPlayerImpl[0]";
        com.kwad.sdk.core.d.c.i("DetailMediaPlayerImpl[0]", "create DetailMediaPlayerImpl");
    }

    public b(DetailVideoView detailVideoView, AdTemplate adTemplate) {
        this(detailVideoView);
        this.mAdTemplate = adTemplate;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        this.mDetailVideoView.setRadius(f, f2, f3, f4);
    }

    public final com.kwad.sdk.core.video.a.c tz() {
        return this.ZJ;
    }

    public final void setSurface(Surface surface) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.setSurface(surface);
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar, DetailVideoView detailVideoView) {
        a(bVar, true, false, detailVideoView);
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, boolean z2, DetailVideoView detailVideoView) {
        Throwable th;
        g gVar;
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer enablePreLoad:" + z);
        if (bVar == null || detailVideoView == null) {
            return;
        }
        com.kwad.sdk.core.config.e.Bi();
        com.kwad.sdk.core.video.a.c cVarA = null;
        if (tF()) {
            try {
                gVar = new g(bVar, this.mAdTemplate);
            } catch (Throwable th2) {
                th = th2;
                gVar = null;
            }
            if (g.isWaynePlayerReady()) {
                try {
                    com.kwad.sdk.core.d.c.i(this.TAG, "constructPlayer KwaiWaynePlayer");
                } catch (Throwable th3) {
                    th = th3;
                    ServiceProvider.reportSdkCaughtException(th);
                }
                cVarA = gVar;
            }
        }
        if (cVarA == null) {
            cVarA = com.kwad.sdk.core.video.a.e.a(this.mContext, z, com.kwad.sdk.core.config.e.Bi(), com.kwad.sdk.core.config.e.Bj(), this.ZU);
        }
        if (cVarA != null) {
            try {
                DetailVideoView detailVideoView2 = this.mDetailVideoView;
                if (detailVideoView2 != null) {
                    detailVideoView2.bc(cVarA.getMediaPlayerType());
                }
                com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + cVarA.getClass().getName());
            } catch (Throwable th4) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(th4);
            }
        }
        cVarA.setLooping(false);
        a(bVar, z2, detailVideoView, cVarA);
    }

    private void a(com.kwad.sdk.contentalliance.a.a.b bVar, boolean z, DetailVideoView detailVideoView, com.kwad.sdk.core.video.a.c cVar) {
        com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer " + this.ZJ);
        if (bVar == null || detailVideoView == null || cVar == null) {
            return;
        }
        if (this.mContext == null) {
            this.mContext = detailVideoView.getContext().getApplicationContext();
        }
        this.ZR = z;
        this.ZN = bVar;
        com.kwad.components.core.video.a.a aVarA = com.kwad.components.core.video.a.d.a(bVar.adTemplate, this.mAdTemplate, bVar.videoUrl, cVar.getMediaPlayerType(), this.ZV);
        c(aVarA);
        a(aVarA);
        DetailVideoView detailVideoView2 = this.mDetailVideoView;
        if (detailVideoView2 != detailVideoView) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer videoView changed");
            if (detailVideoView2 != null) {
                detailVideoView2.setMediaPlayer(null);
                detailVideoView.setKeepScreenOn(detailVideoView2.getKeepScreenOn());
                detailVideoView2.setKeepScreenOn(false);
            }
            this.mDetailVideoView = detailVideoView;
        }
        detailVideoView.setMediaPlayer(this);
        if (this.ZJ != cVar) {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer changed");
            com.kwad.sdk.core.video.a.c cVar2 = this.ZJ;
            if (cVar2 != null) {
                cVar.setLooping(cVar2.isLooping());
                tB();
                this.ZJ.release();
            }
            this.ZJ = cVar;
            reset();
            tA();
            cVar.setAudioStreamType(3);
        } else {
            com.kwad.sdk.core.d.c.i(this.TAG, "initMediaPlayer mediaPlayer not changed");
            reset();
            tB();
            tA();
        }
        this.ZJ.setSurface(detailVideoView.aap);
    }

    public final int getMediaPlayerType() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getMediaPlayerType();
        }
        return 0;
    }

    private void tA() {
        this.ZJ.a(this.ZZ);
        this.ZJ.b(this.aaa);
        this.ZJ.a(this.aab);
        this.ZJ.a(this.aac);
        this.ZJ.a(this.aad);
        this.ZJ.c(this.aae);
        this.ZJ.a(this.aaf);
    }

    private void tB() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            return;
        }
        cVar.a((c.InterfaceC0408c) null);
        this.ZJ.a((c.b) null);
        this.ZJ.b((c.e) null);
        this.ZJ.a((c.i) null);
        this.ZJ.c(null);
        this.ZJ.a((c.g) null);
        this.ZJ.a((c.a) null);
    }

    public final void a(c.e eVar) {
        this.ZY.add(eVar);
    }

    public final void a(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.ZP.add(dVar);
    }

    public final void b(c.d dVar) {
        if (dVar == null) {
            return;
        }
        this.ZP.remove(dVar);
    }

    public final void a(com.kwad.sdk.core.video.a.c cVar, int i, int i2) {
        Iterator<c.d> it = this.ZP.iterator();
        while (it.hasNext()) {
            c.d next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.n(i, i2);
            }
        }
    }

    @Deprecated
    public final boolean isPreparing() {
        return this.ZI == 1;
    }

    @Deprecated
    public final boolean isPrepared() {
        return this.ZI == 2 || this.ZI == 3 || this.ZI == 5 || this.ZI == 8 || this.ZI == 9;
    }

    public final void b(com.kwad.sdk.contentalliance.a.a.b bVar) {
        try {
            if (!TextUtils.isEmpty(bVar.videoUrl)) {
                com.kwad.sdk.core.d.c.d(this.TAG, "videoUrl=" + bVar.videoUrl);
                this.ZJ.b(bVar);
            } else {
                com.kwad.sdk.core.d.c.e(this.TAG, "videoUrl is null");
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public final void prepareAsync() {
        aS(false);
    }

    private void aS(final boolean z) {
        if (this.ZJ == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "start prepareAsync");
        if (this.ZR) {
            if (this.ZQ.compareAndSet(false, true)) {
                com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.video.b.10
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.i(b.this.TAG, "prepareAsync now:" + b.getStateString(b.this.ZI));
                        if (b.this.ZJ == null) {
                            return;
                        }
                        try {
                            synchronized (b.this.ZJ) {
                                b.this.aT(z);
                            }
                        } finally {
                            try {
                            } finally {
                            }
                        }
                        try {
                            synchronized (b.this.ZQ) {
                                b.this.ZQ.notifyAll();
                            }
                        } catch (Exception e) {
                            com.kwad.sdk.core.d.c.printStackTrace(e);
                        }
                    }
                });
                return;
            }
            return;
        }
        try {
            aT(z);
        } catch (Throwable th) {
            if (getMediaPlayerType() != 2) {
                int i = this.ZO;
                this.ZO = i + 1;
                if (i <= 4) {
                    tC();
                }
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync Exception:" + getStateString(this.ZI));
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(boolean z) {
        boolean zPrepareAsync;
        b(this.ZN);
        if (z) {
            zPrepareAsync = this.ZJ.tW();
        } else {
            zPrepareAsync = this.ZJ.prepareAsync();
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "prepareAsync forcePrepare: " + z + ", result: " + zPrepareAsync);
    }

    public final void start() {
        try {
            if (this.ZJ == null) {
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "start state: " + getStateString(this.ZI));
            bb(0);
            if (this.ZI == 0) {
                com.kwad.sdk.core.d.c.i(this.TAG, "start still not prepared well forcePrepare");
                aS(true);
                return;
            }
            if (this.ZI != 2 && this.ZI != 9) {
                if (this.ZI == 3) {
                    this.ZJ.start();
                    return;
                } else {
                    if (this.ZI == 5) {
                        resume();
                        return;
                    }
                    return;
                }
            }
            this.mStartTime = System.currentTimeMillis();
            if (this.ZL != 0) {
                this.ZJ.seekTo((int) r5);
            }
            this.ZJ.start();
            com.kwad.sdk.core.video.a.a.a.eE("videoStartPlay");
            com.kwad.sdk.core.d.c.i(this.TAG, "start:" + getStateString(this.ZI) + "->STATE_STARTED");
            com.kwad.sdk.contentalliance.a.a.b bVar = this.ZN;
            if (bVar != null && bVar.videoPlayerStatus != null) {
                if (this.ZI == 2) {
                    if (this.ZN.videoPlayerStatus.mVideoPlayerType == 0) {
                        setPlayType(1);
                    } else {
                        setPlayType(3);
                    }
                } else if (this.ZI == 9) {
                    setPlayType(3);
                }
            }
            this.ZI = 3;
            onPlayStateChanged(this.ZI);
            tD();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void start(long j) {
        this.ZL = j;
        start();
    }

    private void setPlayType(int i) {
        com.kwad.sdk.contentalliance.a.a.b bVar = this.ZN;
        if (bVar == null || bVar.videoPlayerStatus == null) {
            return;
        }
        this.ZN.videoPlayerStatus.mVideoPlayerType = i;
    }

    public final void restart() {
        if (this.ZJ != null && this.ZI == 9) {
            start();
        }
        setPlayType(3);
    }

    public final void complete() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.pause();
            this.ZJ.seekTo(0L);
        }
        this.ZI = 9;
        onPlayStateChanged(this.ZI);
        com.kwad.sdk.core.video.a.a.a.eE("videoFinishPlay");
    }

    public final void tC() {
        if (this.ZJ == null) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "mMediaPlayer is null");
            return;
        }
        if (this.ZI == 2 || this.ZI == 3 || this.ZI == 4 || this.ZI == 5) {
            com.kwad.sdk.core.d.c.w("resetAndPlay", "can not resetAndPlay in state:");
            return;
        }
        reset();
        tB();
        tA();
        prepareAsync();
    }

    public final void resume() {
        try {
            if (this.ZJ == null) {
                com.kwad.sdk.core.d.c.e(this.TAG, "resume but mMediaPlayer is null");
                return;
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume state: " + getStateString(this.ZI));
            if (this.ZI != 2 && this.ZI != 3 && this.ZI != 0) {
                if (this.ZI == 5) {
                    this.ZJ.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.ZI) + "->STATE_PLAYING");
                    this.ZI = 4;
                    onPlayStateChanged(this.ZI);
                    setPlayType(2);
                    com.kwad.sdk.core.video.a.a.a.eE("videoResumePlay");
                    return;
                }
                if (this.ZI == 7) {
                    this.ZJ.start();
                    com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.ZI) + "->STATE_BUFFERING_PLAYING");
                    this.ZI = 6;
                    onPlayStateChanged(this.ZI);
                    return;
                }
                if (this.ZI == 9) {
                    start();
                    return;
                } else {
                    if (this.ZI != 1) {
                        com.kwad.sdk.core.d.c.w(this.TAG, "resume: " + getStateString(this.ZI) + " 此时不能调用resume()方法.");
                        return;
                    }
                    return;
                }
            }
            com.kwad.sdk.core.d.c.i(this.TAG, "resume:" + getStateString(this.ZI) + "->start()");
            start();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void stopAndPrepareAsync() {
        com.kwad.sdk.core.d.c.i(this.TAG, "stopAndPrepareAsync state: " + getStateString(this.ZI));
        if (this.ZI == 1 || this.ZI == 2) {
            return;
        }
        if (this.ZI == 3 || this.ZI == 4 || this.ZI == 5 || this.ZI == 6 || this.ZI == 7 || this.ZI == 8 || this.ZI == 9) {
            try {
                this.ZJ.stop();
                this.ZI = 8;
                onPlayStateChanged(this.ZI);
                prepareAsync();
                return;
            } catch (Exception unused) {
            }
        }
        release();
    }

    private void reset() {
        com.kwad.sdk.core.d.c.i(this.TAG, "reset:" + getStateString(this.ZI) + "->STATE_IDLE");
        bb(1);
        this.ZJ.reset();
        this.ZI = 0;
    }

    public final boolean isPlaying() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.isPlaying();
        }
        return false;
    }

    public final boolean pause() {
        boolean z;
        com.kwad.sdk.core.d.c.i(this.TAG, "pause mCurrentState: " + getStateString(this.ZI));
        if (this.ZI == 4) {
            this.ZJ.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_PLAYING->STATE_PAUSED");
            this.ZI = 5;
            onPlayStateChanged(this.ZI);
            com.kwad.sdk.core.video.a.a.a.eE("videoPausePlay");
            z = true;
        } else {
            z = false;
        }
        if (this.ZI == 6) {
            this.ZJ.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_BUFFERING_PLAYING->STATE_PAUSED");
            this.ZI = 7;
            onPlayStateChanged(this.ZI);
            z = true;
        }
        if (this.ZI == 3) {
            this.ZJ.pause();
            com.kwad.sdk.core.d.c.i(this.TAG, "pause STATE_STARTED->STATE_PAUSED");
            this.ZI = 5;
            onPlayStateChanged(this.ZI);
            com.kwad.sdk.core.video.a.a.a.eE("videoPausePlay");
            z = true;
        }
        if (this.ZI != 9 || !this.ZJ.isLooping()) {
            return z;
        }
        this.ZJ.pause();
        com.kwad.sdk.core.d.c.i(this.TAG, "pause " + getStateString(this.ZI) + "->STATE_PAUSED");
        this.ZI = 5;
        onPlayStateChanged(this.ZI);
        return true;
    }

    public final void a(final a aVar, boolean z) {
        if (this.ZJ == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "release:" + getStateString(this.ZI) + "->STATE_IDLE");
        setKeepScreenOn(false);
        this.iK.removeCallbacksAndMessages(null);
        tE();
        tB();
        this.mDetailVideoView = null;
        final com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            if (z) {
                com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.video.b.11
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        b.this.a(cVar, aVar);
                    }
                });
            } else {
                a(cVar, aVar);
            }
            this.ZJ = null;
        }
        this.ZI = 0;
        this.ZO = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.kwad.sdk.core.video.a.c cVar, a aVar) {
        if (cVar == null) {
            return;
        }
        com.kwad.sdk.core.d.c.i(this.TAG, "releaseMediaPlayer:" + getStateString(this.ZI) + "->STATE_IDLE");
        try {
            bb(2);
            cVar.release();
            if (aVar != null) {
                aVar.onReleaseSuccess();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public final void a(a aVar) {
        a(aVar, true);
    }

    public final void release() {
        a((a) null);
    }

    public final void releaseAsync() {
        a((a) null, true);
    }

    public final void seekTo(long j) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            cVar.seekTo(j);
        }
    }

    public final void setVolume(float f, float f2) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            return;
        }
        try {
            cVar.setVolume(f, f2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final void setAudioEnabled(boolean z) {
        if (z) {
            setVolume(1.0f, 1.0f);
        } else {
            setVolume(0.0f, 0.0f);
        }
    }

    public final void setSpeed(float f) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar == null) {
            return;
        }
        if (f > 0.0f) {
            this.mSpeed = f;
        }
        cVar.setSpeed(f);
    }

    public final int getVideoWidth() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getVideoWidth();
        }
        return 0;
    }

    public final int getVideoHeight() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getVideoHeight();
        }
        return 0;
    }

    public final long getDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getDuration();
        }
        return 0L;
    }

    public final long getPlayDuration() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final long getCurrentPosition() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar.getCurrentPosition();
        }
        return 0L;
    }

    public final int getBufferPercentage() {
        return this.ZK;
    }

    public final void c(l lVar) {
        this.ZW.add(lVar);
    }

    private void a(com.kwad.components.core.video.a.c cVar) {
        this.ZX.add(cVar);
    }

    public final void d(l lVar) {
        this.ZW.remove(lVar);
    }

    public final void clear() {
        this.ZW.clear();
        this.ZX.clear();
    }

    public final void onPlayStateChanged(final int i) {
        if (this.ZW == null) {
            return;
        }
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.core.video.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                for (l lVar : b.this.ZW) {
                    switch (i) {
                        case -1:
                            b.this.setKeepScreenOn(false);
                            b.this.tE();
                            lVar.onMediaPlayError(b.this.Zo, b.this.Zp);
                            break;
                        case 1:
                            lVar.onMediaPreparing();
                            break;
                        case 2:
                            lVar.onMediaPrepared();
                            break;
                        case 3:
                            b.this.setKeepScreenOn(true);
                            lVar.onMediaPlayStart();
                            break;
                        case 4:
                            b.this.setKeepScreenOn(true);
                            lVar.onMediaPlaying();
                            break;
                        case 5:
                            b.this.setKeepScreenOn(false);
                            lVar.onMediaPlayPaused();
                            break;
                        case 6:
                            lVar.onVideoPlayBufferingPlaying();
                            break;
                        case 7:
                            lVar.onVideoPlayBufferingPaused();
                            break;
                        case 9:
                            if (b.this.ZJ != null && !b.this.ZJ.isLooping()) {
                                b.this.setKeepScreenOn(false);
                                b.this.tE();
                            }
                            lVar.onMediaPlayCompleted();
                            break;
                    }
                }
            }
        });
    }

    private void bb(int i) {
        for (com.kwad.components.core.video.a.c cVar : this.ZX) {
            if (i == 0) {
                cVar.onStart();
            } else if (i == 1) {
                cVar.onReset();
            } else if (i == 2) {
                try {
                    cVar.onRelease();
                } catch (Exception e) {
                    com.kwad.sdk.core.d.c.printStackTrace(e);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeepScreenOn(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setKeepScreenOn(z);
        }
    }

    private void tD() {
        tE();
        if (this.ZM == null) {
            this.ZM = new bg() { // from class: com.kwad.components.core.video.b.3
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    b.this.tx();
                    if (b.this.ZM != null) {
                        b.this.iK.postDelayed(b.this.ZM, (long) (500.0f / b.this.mSpeed));
                    }
                }
            };
        }
        this.iK.post(this.ZM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tE() {
        Runnable runnable = this.ZM;
        if (runnable != null) {
            this.iK.removeCallbacks(runnable);
            this.ZM = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tx() {
        long currentPosition = getCurrentPosition();
        long duration = getDuration();
        if (this.ZW != null) {
            Iterator<l> it = this.ZW.iterator();
            while (it.hasNext()) {
                it.next().onMediaPlayProgress(duration, currentPosition);
            }
        }
    }

    public final void a(com.kwad.sdk.contentalliance.a.a.a aVar) {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar instanceof com.kwad.sdk.core.video.a.d) {
            ((com.kwad.sdk.core.video.a.d) cVar).a(aVar);
        }
    }

    public final String getCurrentPlayingUrl() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        return cVar == null ? "" : cVar.getCurrentPlayingUrl();
    }

    public final void setIsAlphaVideoPlayer(boolean z) {
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            detailVideoView.setIsAlphaVideoView(z);
        }
        this.ZS = z;
    }

    public final boolean getAlphaVideoValid() {
        com.kwad.sdk.core.video.a.c cVar = this.ZJ;
        if (cVar != null) {
            return cVar instanceof g;
        }
        return false;
    }

    private boolean tF() {
        if (this.ZS && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue()) {
            return true;
        }
        return ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBS)).booleanValue() && ((Boolean) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aBT)).booleanValue();
    }

    public final void setTKPlayer() {
        this.ZV = true;
    }
}
