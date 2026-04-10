package com.kwad.components.ad.fullscreen.c.c;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.reward.presenter.f.a {
    private FrameLayout dm;
    private j kG = new j() { // from class: com.kwad.components.ad.fullscreen.c.c.b.1
        @Override // com.kwad.components.ad.reward.e.j
        public final void a(PlayableSource playableSource, n nVar) {
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void dk() {
            b.this.dm.setVisibility(0);
        }

        @Override // com.kwad.components.ad.reward.e.j
        public final void dl() {
            b.this.dm.setVisibility(4);
        }
    };

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_fullscreen";
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dm = (FrameLayout) findViewById(R.id.ksad_js_full_card);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.tm.rT = true;
        com.kwad.components.ad.reward.a.gg().a(this.kG);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.a.gg().b(this.kG);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        com.kwad.components.ad.reward.monitor.b.a(this.mAdTemplate, tKRenderFailReason);
        this.dm.setVisibility(8);
        this.tm.rT = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.b.b.dI(this.tm.mAdTemplate);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dm;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBj = com.kwad.sdk.c.a.a.bj(getContext());
        FrameLayout frameLayout = this.dm;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.dm.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height == 0.0f || width == 0.0f) {
            super.a(aVar);
        } else {
            aVar.width = (int) ((width / fBj) + 0.5f);
            aVar.height = (int) ((height / fBj) + 0.5f);
        }
    }
}
