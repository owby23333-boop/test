package com.kwad.components.ad.e.b;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.h.a;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.video.i;
import com.kwad.components.core.video.j;
import com.kwad.components.core.widget.kwai.b;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.contentalliance.kwai.kwai.b;
import com.kwad.sdk.core.g.c;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.a.f;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.kwai.c;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.l;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.kwad.components.ad.h.a {
    private b bY;
    private KsAdVideoPlayConfig dY;
    private final c dj;
    private boolean eP;
    private a.b eX;
    private OfflineOnAudioConflictListener eY;
    private boolean hasNoCache;
    private final AdInfo mAdInfo;
    private Context mContext;
    private boolean nG;
    private boolean nH;
    private j nI;

    public a(@NonNull final AdTemplate adTemplate, @NonNull b bVar, @NonNull DetailVideoView detailVideoView, @Nullable KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        super(adTemplate, detailVideoView);
        this.hasNoCache = false;
        this.dj = new c() { // from class: com.kwad.components.ad.e.b.a.3
            @Override // com.kwad.sdk.core.g.c
            public final void aS() {
                com.kwad.components.core.h.a.nX().a(a.this.getCurrentVoiceItem());
                a.this.resume();
            }

            @Override // com.kwad.sdk.core.g.c
            public final void aT() {
                com.kwad.components.core.h.a.nX().c(a.this.eX);
                a.this.pause();
            }
        };
        this.eY = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.e.b.a.5
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.c(a.this, false);
                a.this.setAudioEnabled(false);
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.bY = bVar;
        this.mAdInfo = d.cb(this.mAdTemplate);
        this.nG = (!(ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) ? com.kwad.sdk.core.response.a.a.bF(this.mAdInfo) : ksAdVideoPlayConfig.isVideoSoundEnable();
        this.dY = ksAdVideoPlayConfig;
        this.mContext = detailVideoView.getContext();
        if (ksAdVideoPlayConfig != null) {
            try {
                this.hasNoCache = ksAdVideoPlayConfig.isNoCache();
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTraceOnly(th);
            }
        }
        this.nI = new j() { // from class: com.kwad.components.ad.e.b.a.1
            @Override // com.kwad.components.core.video.j, com.kwad.components.core.video.i
            public final void onVideoPlayError(int i2, int i3) {
                super.onVideoPlayError(i2, i3);
                com.kwad.components.core.m.a.pr().b(adTemplate, i2, i3);
            }
        };
        this.Gw.c(this.nI);
        aR();
        this.Gw.a(new c.e() { // from class: com.kwad.components.ad.e.b.a.2
            @Override // com.kwad.sdk.core.video.kwai.c.e
            public final void a(com.kwad.sdk.core.video.kwai.c cVar) {
                if (a.this.eZ() && a.this.bY.et()) {
                    a.this.Gw.a(com.kwad.sdk.contentalliance.kwai.kwai.a.am(a.this.mAdTemplate));
                    com.kwad.components.core.h.a.nX().a(a.this.getCurrentVoiceItem());
                    a.this.Gw.start();
                }
            }
        });
    }

    private void aR() {
        this.Gw.a(new b.a(this.mAdTemplate).bd(d.cd(this.mAdTemplate)).be(f.b(d.cc(this.mAdTemplate))).a(this.mAdTemplate.mVideoPlayerStatus).aS(this.hasNoCache).b(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate)).uc(), true, true, this.mDetailVideoView);
        setAudioEnabled(g(this.nG));
        if (eZ()) {
            this.Gw.prepareAsync();
            com.kwad.components.core.r.b.ar(this.mContext).a(this.eY);
        }
    }

    static /* synthetic */ boolean c(a aVar, boolean z2) {
        aVar.eP = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eZ() {
        if (this.nH) {
            return true;
        }
        KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dY;
        if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                return af.isNetworkConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                return af.isWifiConnected(this.mContext);
            }
            if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                return false;
            }
            if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                return af.isWifiConnected(this.mContext) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && af.isMobileConnected(this.mContext));
            }
        }
        if (com.kwad.sdk.core.response.a.a.bG(this.mAdInfo) && af.isNetworkConnected(this.mContext)) {
            return true;
        }
        return com.kwad.sdk.core.response.a.a.bH(this.mAdInfo) && af.isWifiConnected(this.mContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(boolean z2) {
        if (!z2) {
            return false;
        }
        if (this.eX != null) {
            com.kwad.components.core.h.a.nX();
            if (!com.kwad.components.core.h.a.b(this.eX)) {
                return false;
            }
        }
        if (!com.kwad.sdk.core.config.d.gR()) {
            return !com.kwad.components.core.r.b.ar(this.mContext).pZ() ? com.kwad.components.core.r.b.ar(this.mContext).aI(false) : !com.kwad.components.core.r.b.ar(this.mContext).pY();
        }
        if (!this.eP) {
            this.eP = com.kwad.components.core.r.b.ar(this.mContext).aI(true);
        }
        return this.eP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public a.b getCurrentVoiceItem() {
        if (this.eX == null) {
            this.eX = new a.b(new a.c() { // from class: com.kwad.components.ad.e.b.a.4
                @Override // com.kwad.components.core.h.a.c
                public final void bs() {
                    a aVar = a.this;
                    aVar.setAudioEnabled(aVar.g(aVar.nG));
                }
            });
        }
        return this.eX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAudioEnabled(boolean z2) {
        this.Gw.setAudioEnabled(z2);
    }

    @MainThread
    public final void a(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.c(iVar);
    }

    public final void aP() {
        l.cu(this.mAdTemplate);
        if (this.Gw.qw() == null) {
            aR();
        }
        if (eZ() && this.bY.et()) {
            this.Gw.a(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate));
            com.kwad.components.core.h.a.nX().a(getCurrentVoiceItem());
            this.Gw.start();
        }
        this.bY.a(this.dj);
    }

    public final void aQ() {
        l.cs(this.mAdTemplate);
        this.bY.b(this.dj);
        this.Gw.release();
        com.kwad.components.core.r.b.ar(this.mContext).b(this.eY);
    }

    @MainThread
    public final void b(i iVar) {
        if (iVar == null) {
            return;
        }
        this.Gw.d(iVar);
    }

    public final void fa() {
        this.nH = true;
        if (this.bY.et()) {
            l.ct(this.mAdTemplate);
            this.Gw.a(com.kwad.sdk.contentalliance.kwai.kwai.a.am(this.mAdTemplate));
            com.kwad.components.core.h.a.nX().a(getCurrentVoiceItem());
            this.Gw.start();
        }
    }

    public final void pause() {
        this.Gw.pause();
    }

    @Override // com.kwad.components.ad.h.a
    @MainThread
    public final void release() {
        super.release();
        com.kwad.components.core.video.b bVar = this.Gw;
        if (bVar != null) {
            bVar.clear();
            this.Gw.release();
        }
    }

    public final void resume() {
        com.kwad.components.core.h.a.nX().a(getCurrentVoiceItem());
        setAudioEnabled(g(this.nG));
        if (eZ()) {
            this.Gw.resume();
        }
    }
}
