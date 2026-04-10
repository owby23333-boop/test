package com.kwad.components.ad.draw.presenter.c;

import android.widget.FrameLayout;
import com.kwad.components.ad.l.b;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.draw.b.a {
    private com.kwad.components.ad.l.b dF;
    private com.kwad.sdk.core.webview.d.a.a eT = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.draw.presenter.c.b.1
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            if (b.this.dz.dh != null) {
                b.this.dz.dh.onAdClicked();
            }
        }
    };
    private FrameLayout fc;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.fc = (FrameLayout) findViewById(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        com.kwad.components.ad.l.b bVar = this.dz.dF;
        this.dF = bVar;
        if (bVar == null) {
            return;
        }
        bVar.a(this.eT);
        this.dF.a(this.fc, this.dz.mRootContainer, this.dz.mAdTemplate, this.dz.mApkDownloadHelper);
        this.dF.a((b.InterfaceC0290b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.l.b bVar = this.dF;
        if (bVar != null) {
            bVar.ny();
        }
    }
}
