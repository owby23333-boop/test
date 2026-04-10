package com.kwad.components.ad.reward.presenter.a;

import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends g implements j {
    private i fU;
    private AdInfo mAdInfo;
    private long xc;
    private long xd;
    private boolean xe;
    private boolean xf;
    private g.b xg = new g.b() { // from class: com.kwad.components.ad.reward.presenter.a.a.1
        @Override // com.kwad.components.ad.reward.g.b
        public final boolean interceptPlayCardResume() {
            return a.this.zX != null && a.this.zX.getVisibility() == 0;
        }
    };
    private final m jE = new m() { // from class: com.kwad.components.ad.reward.presenter.a.a.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            long jA = com.kwad.components.ad.reward.g.a(j, a.this.mAdInfo);
            if (j2 <= a.this.xc || jA - j2 <= a.this.xd || a.this.xe) {
                return;
            }
            a.a(a.this, true);
            a.this.fU.a(a.this.tm.getActivity(), a.this.tm.mAdResultData, a.this);
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_reward_interact_card";
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.xe = true;
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        if (this.fU == null) {
            this.fU = iY();
        }
        AdInfo adInfoEl = e.el(this.tm.mAdTemplate);
        this.mAdInfo = adInfoEl;
        this.xc = ((long) com.kwad.sdk.core.response.b.a.aJ(adInfoEl)) * 1000;
        this.xd = ((long) com.kwad.sdk.core.response.b.a.aK(this.mAdInfo)) * 1000;
        this.tm.rE.a(this.jE);
        this.tm.a(this.xg);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.rE.b(this.jE);
        this.tm.b(this.xg);
        this.fU.kz();
        this.fU = null;
        this.zX.setVisibility(8);
        this.xe = false;
        this.xf = false;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dR(this.tm.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.tm.mRootContainer;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int iX() {
        return R.id.ksad_js_interact;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        c.d("TkRewardInteractPresenter", "onTkLoadFailed: ");
        this.zX.setVisibility(8);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        c.d("TkRewardInteractPresenter", "onTkLoadSuccess: ");
        getContext();
        if (aq.QW()) {
            this.zX.setVisibility(0);
            com.kwad.components.ad.reward.d.a.S(this.tm.mContext);
            this.tm.rE.pause();
            this.xf = true;
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        tVar.c(new q(bVar, this.tm.mApkDownloadHelper, this.tm, -1L, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.a.a.3
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (a.this.tm.rD != null) {
                    a.this.tm.rD.cW();
                }
            }
        }, null));
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBj = com.kwad.sdk.c.a.a.bj(getContext());
        aVar.width = (int) ((br.getScreenWidth(getContext()) / fBj) + 0.5f);
        aVar.height = (int) ((br.getScreenHeight(getContext()) / fBj) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.tm.rV = webCloseStatus != null && webCloseStatus.interactSuccess;
        if (this.tm.rV) {
            this.tm.rE.kT();
        }
        if (this.xf && bz.o(this.zX, 30)) {
            this.tm.rE.resume();
        }
        this.zX.setVisibility(8);
    }

    private i iY() {
        return new i(-1L, getContext());
    }
}
