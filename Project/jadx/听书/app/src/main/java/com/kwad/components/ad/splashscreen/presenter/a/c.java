package com.kwad.components.ad.splashscreen.presenter.a;

import android.app.Activity;
import com.kwad.components.ad.splashscreen.presenter.e;
import com.kwad.components.core.webview.jshandler.a;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.g;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends e implements j {
    private b Jk;

    public void a(az azVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(WebCloseStatus webCloseStatus) {
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aA() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aB() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public String getRegisterViewKey() {
        return null;
    }

    protected int nf() {
        return 1000;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        int iNf = nf();
        b bVar = new b(getContext(), iNf, iNf);
        this.Jk = bVar;
        bVar.a((Activity) null, this.Gf.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.Jk.kz();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.Gf.mRootContainer;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0354a c0354a) {
        String str = c0354a.acf;
        str.hashCode();
        switch (str) {
            case "adShowCallback":
                this.Gf.lJ();
                break;
            case "adDownloadConfirmTipCancel":
                this.Gf.lO();
                break;
            case "adCloseCallback":
                this.Gf.lL();
                break;
            case "adDownloadConfirmTipShow":
                this.Gf.lN();
                break;
            case "adDownloadConfirmTipDismiss":
                this.Gf.lP();
                break;
            case "adAutoCloseCallback":
                this.Gf.lK();
                break;
            case "adShowErrorCallback":
                this.Gf.lI();
                break;
            case "adClickCallback":
                this.Gf.lM();
                break;
        }
    }
}
