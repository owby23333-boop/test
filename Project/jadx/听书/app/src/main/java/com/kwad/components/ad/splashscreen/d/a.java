package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.os.SystemClock;
import com.kwad.components.ad.k.b;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.a.a.b;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.a.c;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.utils.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends b implements c {
    private String Bh;
    private final List<i.a> Bk;
    private OfflineOnAudioConflictListener Bm;
    public int Gl;
    private boolean Jl;
    public long Jm;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean pW;

    public a(AdTemplate adTemplate, final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.Bk = new ArrayList();
        this.Bm = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (a.this.Bk) {
                    Iterator it = a.this.Bk.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.Bk) {
                    Iterator it = a.this.Bk.iterator();
                    while (it.hasNext()) {
                        ((i.a) it.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String strAZ = com.kwad.sdk.core.response.b.a.aZ(e.el(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        e.el(adTemplate);
        this.Gl = h.ac(adTemplate) ? 2 : 1;
        File fileCf = com.kwad.sdk.core.diskcache.b.a.GP().cf(strAZ);
        if (fileCf != null && fileCf.exists()) {
            this.Bh = fileCf.getAbsolutePath();
        }
        this.LU.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            @Override // com.kwad.sdk.core.video.a.c.e
            public final void a(com.kwad.sdk.core.video.a.c cVar) {
                com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared");
                detailVideoView.post(new bg() { // from class: com.kwad.components.ad.splashscreen.d.a.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.a(a.this.mAdTemplate, 1, a.this.Gl, 2, jElapsedRealtime - a.this.Jm, jElapsedRealtime - a.this.mAdTemplate.showTime);
                        boolean zA = bz.a(detailVideoView, 50, true);
                        com.kwad.sdk.core.d.c.d("SplashPlayModule", " onPrepared" + zA);
                        if (zA) {
                            a.this.LU.start();
                        }
                    }
                });
            }
        });
        com.kwad.components.core.t.a.aC(this.mContext).a(this.Bm);
    }

    public final long getCurrentPosition() {
        return this.LU.getCurrentPosition();
    }

    private void bs() {
        com.kwad.sdk.contentalliance.a.a.b bVarEl = new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).dg(this.Bh).dh(com.kwad.sdk.core.response.b.h.b(e.em(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.a.a.a.bQ(this.mAdTemplate)).El();
        this.Jm = SystemClock.elapsedRealtime();
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.e(this.mAdTemplate, 1, this.Gl);
        this.LU.a(bVarEl, this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.LU.prepareAsync();
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void resume() {
        super.resume();
        if (this.pW && this.Jl) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(false);
            if (com.kwad.components.core.t.a.aC(this.mContext).sW()) {
                this.pW = false;
                setAudioEnabled(false, false);
            }
        }
    }

    @Override // com.kwad.components.ad.k.b, com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        com.kwad.components.core.t.a.aC(this.mContext).b(this.Bm);
    }

    public final void ag(boolean z) {
        this.Jl = true;
    }

    public final void nk() {
        if (this.LU.tz() == null) {
            bs();
        }
        this.LU.start();
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.pW = z;
        if (z && z2) {
            com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        this.LU.setAudioEnabled(z);
    }

    public final void a(i.a aVar) {
        this.Bk.add(aVar);
    }

    public final void b(i.a aVar) {
        this.Bk.remove(aVar);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bt() {
        resume();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bu() {
        pause();
    }
}
