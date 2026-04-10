package com.kwad.components.ad.reward.presenter.e;

import com.kwad.components.core.webview.a.a.w;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.jshandler.l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends c {
    private o wd;

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ck() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ja() {
        return true;
    }

    public final boolean jb() {
        e eVar = this.wo;
        if (eVar != null) {
            return eVar.jb();
        }
        return false;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        float screenHeight = com.kwad.sdk.b.kwai.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((screenHeight / fAG) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public void onRegisterVideoMuteStateListener(o oVar) {
        this.wd = oVar;
        this.wd.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
            @Override // com.kwad.components.core.webview.a.kwai.o.a
            public final boolean isMuted() {
                return !a.this.qS.mVideoPlayConfig.isVideoSoundEnable() || com.kwad.components.core.r.b.ar(a.this.getContext()).pY();
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        lVar.c(new com.kwad.components.core.webview.jshandler.e() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.components.core.webview.jshandler.e
            public final void a(w wVar) {
                super.a(wVar);
                a.this.qS.mAdOpenInteractionListener.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.a.b(a.this.qS.pN, a.this.qS.mAdTemplate, a.this.qS.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.e
            public final void b(w wVar) {
                super.b(wVar);
                a.this.qS.mAdOpenInteractionListener.onVideoPlayEnd();
                com.kwad.components.ad.reward.presenter.e.q(a.this.qS);
            }

            @Override // com.kwad.components.core.webview.jshandler.e
            public final void c(w wVar) {
                super.c(wVar);
                long jRA = wVar.rA();
                a.this.qS.mAdOpenInteractionListener.onVideoPlayError(wVar.errorCode, (int) jRA);
                com.kwad.components.ad.reward.monitor.a.a(a.this.qS.pN, a.this.qS.mAdTemplate, a.this.qS.qh, wVar.errorCode, jRA);
            }
        });
    }
}
