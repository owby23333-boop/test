package com.kwad.components.ad.interstitial.c.kwai;

import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.video.i;
import com.kwad.components.core.webview.a.a.k;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.a.g;
import com.kwad.components.core.webview.a.h;
import com.kwad.components.core.webview.a.kwai.i;
import com.kwad.components.core.webview.a.kwai.o;
import com.kwad.components.core.webview.a.kwai.p;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.l;
import com.kwad.sdk.widget.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.kwad.components.ad.interstitial.c.b implements h {
    private g mTKLoadController;

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public void ar() {
        super.ar();
        this.mTKLoadController.bind(getActivity(), this.jq.mAdTemplate, this);
    }

    @Override // com.kwad.components.core.webview.a.h
    public e getTouchCoordsView() {
        return this.jq.jA;
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onAdClicked(@Nullable com.kwad.sdk.core.webview.c.a.a aVar) {
        c cVar = this.jq;
        cVar.jt = true;
        cVar.hK.onAdClicked();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        this.mTKLoadController = new g(-1L, getContext());
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterLifecycleLisener(ae aeVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoMuteStateListener(o oVar) {
        k kVar = new k();
        kVar.UW = !this.jq.dY.isVideoSoundEnable();
        oVar.b(kVar);
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterVideoProgressListener(p pVar, i iVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onRegisterWebCardHandler(l lVar, com.kwad.sdk.core.webview.b bVar) {
        lVar.c(new com.kwad.components.core.webview.a.kwai.i(new i.a() { // from class: com.kwad.components.ad.interstitial.c.kwai.a.1
            @Override // com.kwad.components.core.webview.a.kwai.i.a
            public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
                a.this.onAdClicked(aVar);
            }
        }));
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onSkipClick(s sVar) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.mTKLoadController.unBind();
    }

    @Override // com.kwad.components.core.webview.a.h
    public void onUpdateMuteStatus(k kVar) {
    }

    @Override // com.kwad.components.core.webview.a.h
    public void pageClose(WebCloseStatus webCloseStatus) {
    }
}
