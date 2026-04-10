package com.kwad.components.ad.splashscreen.presenter.endcard;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.ad.splashscreen.presenter.e {
    com.kwad.components.ad.splashscreen.f Ix = new com.kwad.components.ad.splashscreen.f() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.f.1
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lC() {
            f.this.a(new e(), true);
            f.this.a(new h(), true);
        }
    };

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.Gf.a(this.Ix);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Gf.b(this.Ix);
    }
}
