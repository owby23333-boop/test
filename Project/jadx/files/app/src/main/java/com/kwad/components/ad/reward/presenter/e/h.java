package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.d.l;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.j.a;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.l;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends c implements com.kwad.components.ad.reward.d.h {
    private FrameLayout ht;
    private com.kwad.components.core.webview.a.d wM;
    private a.InterfaceC0370a wN = new a.InterfaceC0370a() { // from class: com.kwad.components.ad.reward.presenter.e.h.1
        @Override // com.kwad.components.ad.reward.j.a.InterfaceC0370a
        public final void jp() {
            if (h.this.wM != null) {
                com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(h.this.qS.mAdTemplate);
                int iAF = com.kwad.sdk.core.response.a.a.aH(adInfoCb) && com.kwad.components.core.p.a.pJ().pK() == 0 ? com.kwad.sdk.core.response.a.a.aF(adInfoCb) : com.kwad.sdk.core.response.a.a.aD(adInfoCb);
                if (!h.this.qS.pQ) {
                    iAF = 0;
                }
                iVar.rewardTime = iAF;
                h.this.wM.b(iVar);
            }
        }
    };
    private com.kwad.components.ad.reward.d.f mPlayEndPageListener = new com.kwad.components.ad.reward.d.a() { // from class: com.kwad.components.ad.reward.presenter.e.h.2
        @Override // com.kwad.components.ad.reward.d.f
        public final void bM() {
            if (com.kwad.sdk.core.response.a.a.ak(com.kwad.sdk.core.response.a.d.cb(h.this.qS.mAdTemplate))) {
                h.this.ht.setVisibility(8);
            }
        }
    };

    private com.kwad.components.core.webview.a.d jn() {
        return new com.kwad.components.core.webview.a.d() { // from class: com.kwad.components.ad.reward.presenter.e.h.3
            @Override // com.kwad.components.core.webview.a.d, com.kwad.sdk.core.webview.b.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.b.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.a.a.i iVar = new com.kwad.components.core.webview.a.a.i();
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(h.this.qS.mAdTemplate);
                int iAF = com.kwad.sdk.core.response.a.a.aH(adInfoCb) && com.kwad.components.core.p.a.pJ().pK() == 0 ? com.kwad.sdk.core.response.a.a.aF(adInfoCb) : com.kwad.sdk.core.response.a.a.aD(adInfoCb);
                if (!h.this.qS.pQ) {
                    iAF = 0;
                }
                iVar.rewardTime = iAF;
                cVar.a(iVar);
            }
        };
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void a(PlayableSource playableSource, @Nullable l lVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        if (ck() && !this.qS.pw.jY()) {
            this.qS.b(this.mPlayEndPageListener);
            this.qS.pw.ka().a(this.wN);
            com.kwad.components.ad.reward.b.fz().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void ca() {
        if (this.qS.pP) {
            this.ht.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.d.h
    public final void cb() {
        AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(this.qS.mAdTemplate);
        if (!this.qS.pP || com.kwad.sdk.core.response.a.a.ak(adInfoCb)) {
            return;
        }
        this.ht.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c
    protected final boolean ck() {
        return j.b(this.qS) && !this.qS.pw.jY();
    }

    @Override // com.kwad.components.core.webview.a.h
    public final FrameLayout getTKContainer() {
        return this.ht;
    }

    @Override // com.kwad.components.core.webview.a.h
    public final String getTkTemplateId() {
        return com.kwad.components.core.webview.a.i.b("ksad-video-top-bar", this.qS.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ht = (FrameLayout) findViewById(R.id.ksad_js_top);
        this.ht.setVisibility(0);
    }

    @Override // com.kwad.components.core.webview.a.h
    public final void onGetContainerLimited(l.a aVar) {
        aVar.width = (int) ((com.kwad.sdk.b.kwai.a.getScreenWidth(getContext()) / com.kwad.sdk.b.kwai.a.aG(getContext())) + 0.5f);
        aVar.height = 44;
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onRegisterWebCardHandler(com.kwad.sdk.components.l lVar, com.kwad.sdk.core.webview.b bVar) {
        super.onRegisterWebCardHandler(lVar, bVar);
        this.wM = jn();
        lVar.c(this.wM);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.components.core.webview.a.h
    public final void onTkLoadFailed() {
        super.onTkLoadFailed();
        j jVar = this.qS;
        jVar.pP = false;
        jVar.F(false);
        this.ht.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        if (ck()) {
            this.qS.c(this.mPlayEndPageListener);
            this.qS.pw.ka().b(this.wN);
            com.kwad.components.ad.reward.b.fz().b(this);
        }
    }
}
