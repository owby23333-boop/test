package com.kwad.components.core.e.a;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends KSFrameLayout {
    private final d Ol;
    private a Ou;
    private final d Ow;
    private final com.kwad.components.core.widget.a.b fg;
    private final AdTemplate mAdTemplate;
    private Presenter mPresenter;
    private boolean qU;

    public g(Context context, AdTemplate adTemplate, d dVar) {
        super(context);
        this.Ow = new d() { // from class: com.kwad.components.core.e.a.g.1
            @Override // com.kwad.components.core.e.a.d
            public final void oJ() {
                g.this.eL();
            }
        };
        this.mAdTemplate = adTemplate;
        this.Ol = dVar;
        this.fg = new com.kwad.components.core.widget.a.b(this, 70);
        initMVP();
    }

    private void initMVP() {
        this.Ou = oQ();
        Presenter presenterOnCreatePresenter = onCreatePresenter();
        this.mPresenter = presenterOnCreatePresenter;
        presenterOnCreatePresenter.K(this);
        this.mPresenter.n(this.Ou);
    }

    private a oQ() {
        a aVar = new a();
        aVar.Oj = this;
        aVar.mAdTemplate = this.mAdTemplate;
        aVar.Ok = this.fg;
        aVar.Ol = this.Ow;
        return aVar;
    }

    private static Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new f());
        return presenter;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewAttached");
        this.fg.wi();
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ab() {
        super.ab();
        com.kwad.sdk.core.d.c.d("InstalledActivateView", "onViewDetached");
        this.fg.release();
        this.mPresenter.destroy();
        this.Ou.release();
        eL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL() {
        if (this.qU) {
            return;
        }
        this.qU = true;
        this.Ol.oJ();
    }
}
