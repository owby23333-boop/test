package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.core.webview.a.a.s;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {
    private FrameLayout wf;
    private boolean wg = false;

    private void X(boolean z2) {
        this.wf.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (this.wg) {
            return;
        }
        X(true);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ck() {
        return true;
    }

    public final BackPressHandleResult gI() {
        com.kwad.components.ad.reward.h.kwai.d dVar = this.wh;
        return dVar == null ? BackPressHandleResult.NOT_HANDLED : dVar.gI();
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.wf;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-live-video-card", this.qS.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ja() {
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wf = (FrameLayout) findViewById(R.id.ksad_js_live_card);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        float fAG = com.kwad.sdk.b.kwai.a.aG(getContext());
        float screenHeight = com.kwad.sdk.b.kwai.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / fAG) + 0.5f);
        aVar.height = (int) ((screenHeight / fAG) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onSkipClick(s sVar) {
        com.kwad.components.ad.reward.d.b bVar;
        com.kwad.sdk.core.d.b.d("TKLivePresenter", "onSkipClick: " + sVar.Vc);
        j jVar = this.qS;
        if (jVar != null && (bVar = jVar.mAdOpenInteractionListener) != null) {
            bVar.onVideoSkipToEnd(sVar.Vc * 1000);
        }
        com.kwad.components.ad.reward.presenter.e.q(this.qS);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        this.wg = true;
        X(false);
    }
}
