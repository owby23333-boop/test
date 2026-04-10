package com.kwad.components.ad.splashscreen.d;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.d.b;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.ad.h.a implements c {
    private boolean Er;
    private Context mContext;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nG;
    private String xP;
    private final List<h.a> xT;
    private OfflineOnAudioConflictListener xV;

    public a(@NonNull AdTemplate adTemplate, @NonNull final DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.xT = new ArrayList();
        this.xV = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.splashscreen.d.a.1
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                synchronized (a.this.xT) {
                    Iterator it = a.this.xT.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeOccupied();
                    }
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
                synchronized (a.this.xT) {
                    Iterator it = a.this.xT.iterator();
                    while (it.hasNext()) {
                        ((h.a) it.next()).onAudioBeReleased();
                    }
                }
            }
        };
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        String strAT = com.kwad.sdk.core.response.a.a.aT(d.cb(adTemplate));
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(strAT);
        if (fileAN != null && fileAN.exists()) {
            this.xP = fileAN.getAbsolutePath();
        }
        this.Gw.a(new c.e() { // from class: com.kwad.components.ad.splashscreen.d.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                boolean zA = com.kwad.sdk.b.kwai.a.a((View) detailVideoView, 50, true);
                b.d("SplashPlayModule", " onPrepared" + zA);
                if (zA) {
                    a.this.Gw.start();
                }
            }
        });
        com.kwad.components.core.r.b.ar(this.mContext).a(this.xV);
    }

    private void aR() {
        this.Gw.a(new b.a(this.mAdTemplate).a(this.mVideoPlayerStatus).bd(this.xP).be(f.b(d.cc(this.mAdTemplate))).b(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate)).uc(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Gw.prepareAsync();
    }

    private void resume() {
        this.Gw.resume();
        if (this.nG && this.Er) {
            com.kwad.components.core.r.b.ar(this.mContext).aI(false);
            if (com.kwad.components.core.r.b.ar(this.mContext).pY()) {
                this.nG = false;
                setAudioEnabled(this.nG, false);
            }
        }
    }

    @MainThread
    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.c(iVar);
    }

    public final void a(h.a aVar) {
        this.xT.add(aVar);
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aS() {
        resume();
    }

    @Override // com.kwad.sdk.core.g.c
    public final void aT() {
        pause();
    }

    public final void ag(boolean z2) {
        this.Er = true;
    }

    @MainThread
    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.d(iVar);
    }

    public final void b(h.a aVar) {
        this.xT.remove(aVar);
    }

    public final long getCurrentPosition() {
        return this.Gw.getCurrentPosition();
    }

    public final void lL() {
        if (this.Gw.qw() == null) {
            aR();
        }
        this.Gw.start();
    }

    public final void pause() {
        this.Gw.pause();
    }

    @Override // com.kwad.components.ad.h.a
    public final void release() {
        super.release();
        com.kwad.components.core.video.b bVar = this.Gw;
        if (bVar != null) {
            bVar.clear();
            this.Gw.release();
        }
        com.kwad.components.core.r.b.ar(this.mContext).b(this.xV);
    }

    public final void setAudioEnabled(boolean z2, boolean z3) {
        this.nG = z2;
        if (z2 && z3) {
            com.kwad.components.core.r.b.ar(this.mContext).aI(true);
        }
        this.Gw.setAudioEnabled(z2);
    }
}
