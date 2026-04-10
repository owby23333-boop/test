package com.kwad.components.core.webview.tachikoma.d;

import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends Presenter implements j {
    protected b ahp;
    protected i fU;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(u uVar) {
    }

    protected void a(b bVar) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        b bVar = (b) NN();
        this.ahp = bVar;
        a(bVar);
        if (this.fU == null) {
            this.fU = iY();
        }
        if (this.ahp.Yf != null) {
            this.fU.a(this.ahp.Yf);
        }
        this.fU.a(this.ahp.mActivity, this.ahp.mAdResultData, this);
    }

    protected i iY() {
        return new i(this.ahp.AO, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.fU.kz();
        this.fU = null;
    }

    public void a(WebCloseStatus webCloseStatus) {
        if (this.ahp.afi != null) {
            this.ahp.afi.dismiss();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.ahp.ahq;
    }
}
