package com.kwad.components.ad.splashscreen.b.kwai;

import com.kwad.components.core.webview.a.i;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends com.kwad.components.ad.splashscreen.b.e implements com.kwad.components.core.webview.a.d.b {
    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.core.webview.a.c.a.rE().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-splash-end-card", this.Cx.mAdTemplate).equals(str)) {
            a(new d(), true);
            a(new a(), true);
            a(new b(), true);
            a(new c(), true);
        }
    }
}
