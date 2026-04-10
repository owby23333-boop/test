package com.kwad.components.ad.c.d;

import android.app.Activity;
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
public abstract class c extends com.kwad.components.ad.c.c.a implements j {
    private b db;

    public void a(az azVar) {
    }

    public void a(o oVar) {
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
    public String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return null;
    }

    @Override // com.kwad.components.ad.c.c.a, com.kwad.sdk.mvp.Presenter
    public void at() {
        super.at();
        b bVar = new b(getContext(), -1, -1);
        this.db = bVar;
        bVar.a((Activity) null, this.cD.mAdResultData, this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        this.db.kz();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(a.C0354a c0354a) {
        String str = c0354a.acf;
        str.hashCode();
        if (str.equals("adShowCallback")) {
            this.cD.W();
        } else if (str.equals("adShowErrorCallback")) {
            this.cD.c(0, "onMediaPlayError");
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void f(AdTemplate adTemplate) {
        this.cD.b(adTemplate);
    }
}
