package com.kwad.components.core.page.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.b;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.VideoPlayerStatus;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.h;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements com.kwad.components.core.j.kwai.a {
    private b Gw;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private DetailVideoView mDetailVideoView;
    private KsVideoPlayConfig mVideoPlayConfig;
    private VideoPlayerStatus mVideoPlayerStatus;
    private boolean nG;
    private j nI;
    private String xP;
    private boolean xS = false;
    private final List<h.a> xT = new ArrayList();
    private OfflineOnAudioConflictListener xV = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.core.page.b.a.1
        @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
        public final void onAudioBeOccupied() {
            a.a(a.this, true);
            if (a.this.Gw != null) {
                a.this.Gw.setAudioEnabled(false);
            }
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

    public a(@NonNull final AdTemplate adTemplate, @NonNull DetailVideoView detailVideoView, KsVideoPlayConfig ksVideoPlayConfig) {
        this.mVideoPlayConfig = ksVideoPlayConfig;
        this.mAdTemplate = adTemplate;
        this.mContext = detailVideoView.getContext();
        this.mVideoPlayerStatus = adTemplate.mVideoPlayerStatus;
        String strE = com.kwad.sdk.core.response.a.a.E(d.cb(adTemplate));
        int iUJ = com.kwad.sdk.core.config.d.uJ();
        if (iUJ < 0) {
            File fileAN = com.kwad.sdk.core.diskcache.a.a.vE().aN(strE);
            if (fileAN != null && fileAN.exists()) {
                strE = fileAN.getAbsolutePath();
            }
            this.mDetailVideoView = detailVideoView;
            this.Gw = new b(detailVideoView);
            aR();
            this.nI = new j() { // from class: com.kwad.components.core.page.b.a.2
                @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
                public final void onVideoPlayError(int i2, int i3) {
                    super.onVideoPlayError(i2, i3);
                    com.kwad.components.core.m.a.pr().b(adTemplate, i2, i3);
                }
            };
            this.Gw.c(this.nI);
            this.Gw.a(new c.e() { // from class: com.kwad.components.core.page.b.a.3
                @Override // com.kwad.sdk.core.video.kwai.c.e
                public final void a(c cVar) {
                    a.this.Gw.start();
                }
            });
            com.kwad.components.core.r.b.ar(this.mContext).a(this.xV);
        }
        if (iUJ != 0) {
            strE = com.kwad.sdk.core.videocache.b.a.bl(detailVideoView.getContext()).cz(strE);
        }
        this.xP = strE;
        this.mDetailVideoView = detailVideoView;
        this.Gw = new b(detailVideoView);
        aR();
        this.nI = new j() { // from class: com.kwad.components.core.page.b.a.2
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                super.onVideoPlayError(i2, i3);
                com.kwad.components.core.m.a.pr().b(adTemplate, i2, i3);
            }
        };
        this.Gw.c(this.nI);
        this.Gw.a(new c.e() { // from class: com.kwad.components.core.page.b.a.3
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(c cVar) {
                a.this.Gw.start();
            }
        });
        com.kwad.components.core.r.b.ar(this.mContext).a(this.xV);
    }

    static /* synthetic */ boolean a(a aVar, boolean z2) {
        aVar.xS = true;
        return true;
    }

    private void aR() {
        this.Gw.a(new b.a(this.mAdTemplate).bd(this.xP).be(f.b(d.cc(this.mAdTemplate))).a(this.mVideoPlayerStatus).b(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate)).uc(), this.mDetailVideoView);
        KsVideoPlayConfig ksVideoPlayConfig = this.mVideoPlayConfig;
        if (ksVideoPlayConfig != null) {
            setAudioEnabled(ksVideoPlayConfig.isVideoSoundEnable(), false);
        }
        this.Gw.prepareAsync();
    }

    private void pause() {
        SceneImpl sceneImpl;
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.mXiaomiAppStoreDetailViewOpen && (sceneImpl = adTemplate.mAdScene) != null && sceneImpl.getAdStyle() == 2) {
            return;
        }
        this.Gw.pause();
    }

    private void resume() {
        this.Gw.resume();
    }

    private void setAudioEnabled(boolean z2, boolean z3) {
        this.nG = z2;
        this.Gw.setAudioEnabled(z2);
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void a(com.kwad.components.core.l.d dVar) {
        resume();
    }

    @MainThread
    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.c(iVar);
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void b(com.kwad.components.core.l.d dVar) {
        pause();
    }

    @MainThread
    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.d(iVar);
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void c(com.kwad.components.core.l.d dVar) {
        this.xS = false;
        com.kwad.components.core.video.b bVar = this.Gw;
        if (bVar != null) {
            bVar.d(this.nI);
            this.Gw.release();
        }
    }

    @Override // com.kwad.components.core.j.kwai.a
    public final void gq() {
        this.xS = false;
        if (this.Gw.qw() == null) {
            aR();
        }
    }

    @MainThread
    public final void release() {
        com.kwad.components.core.video.b bVar = this.Gw;
        if (bVar != null) {
            bVar.clear();
            this.Gw.release();
        }
        com.kwad.components.core.r.b.ar(this.mContext).b(this.xV);
    }
}
