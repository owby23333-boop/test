package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.b.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.br;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    private AdMatrixInfo.PreLandingPageTKInfo zt;
    private az zu;
    private boolean qS = false;
    private com.kwad.components.ad.reward.e.g zv = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void cX() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.tm.rX);
            if (a.this.tm.rX) {
                return;
            }
            a.this.jS();
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.zt = b.dB(this.tm.mAdTemplate);
        this.tm.b(this.zv);
        this.tm.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.tm.c(this.zv);
        this.tm.b((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.dT(this.tm.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int iX() {
        return R.id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBj = com.kwad.sdk.c.a.a.bj(getContext());
        aVar.width = (int) ((br.getScreenWidth(getContext()) / fBj) + 0.5f);
        aVar.height = (int) ((br.getScreenHeight(getContext()) / fBj) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.zu = azVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jS() {
        if (!this.qS || this.zt == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.zt.isPlayEndShow());
        if (this.zt.isPlayEndShow()) {
            T(true);
        }
    }

    private void jT() {
        if (!this.qS || this.zt == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.zt.isSkipShow());
        if (this.zt.isSkipShow()) {
            T(true);
        }
    }

    public final BackPressHandleResult hx() {
        if (this.zF == null || this.zX == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        if (this.zX.getVisibility() == 0) {
            return this.zF.hx();
        }
        return BackPressHandleResult.NOT_HANDLED;
    }

    private void T(final boolean z) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z);
        this.zX.post(new bg() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                a.this.zX.setVisibility(z ? 0 : 4);
                a.this.zX.setClickable(z);
                if (a.this.zu != null) {
                    if (z) {
                        a.this.zu.uF();
                        a.this.zu.uG();
                    } else {
                        a.this.zu.uH();
                        a.this.zu.uI();
                    }
                }
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void az() {
        super.az();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.qS = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.qS = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        T(false);
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jU() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        jS();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void jV() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        jT();
    }
}
