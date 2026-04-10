package com.kwad.components.ad.splashscreen.b.kwai;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends com.kwad.components.ad.splashscreen.b.e {
    com.kwad.components.ad.splashscreen.f Ej = new com.kwad.components.ad.splashscreen.f() { // from class: com.kwad.components.ad.splashscreen.b.kwai.f.1
        @Override // com.kwad.components.ad.splashscreen.f
        public final void kK() {
            com.kwad.components.ad.splashscreen.local.b.U(f.this.getContext());
            f.this.a(new e(), true);
            f.this.a(new g(), true);
        }
    };

    @Override // com.kwad.components.ad.splashscreen.b.e, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.Cx.a(this.Ej);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.Cx.b(this.Ej);
    }
}
