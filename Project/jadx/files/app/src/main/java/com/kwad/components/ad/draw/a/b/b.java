package com.kwad.components.ad.draw.a.b;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.i.b;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends com.kwad.components.ad.draw.kwai.a {
    private com.kwad.sdk.core.webview.c.kwai.a cV = new com.kwad.sdk.core.webview.c.kwai.a() { // from class: com.kwad.components.ad.draw.a.b.b.1
        @Override // com.kwad.sdk.core.webview.c.kwai.a
        public final void onAdClicked(com.kwad.sdk.core.webview.c.a.a aVar) {
            if (b.this.bW.bV != null) {
                b.this.bW.bV.onAdClicked();
            }
        }
    };

    @Nullable
    private com.kwad.components.ad.i.b cp;
    private FrameLayout de;

    @Override // com.kwad.components.ad.draw.kwai.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        this.cp = this.bW.cp;
        com.kwad.components.ad.i.b bVar = this.cp;
        if (bVar == null) {
            return;
        }
        bVar.a(this.cV);
        com.kwad.components.ad.i.b bVar2 = this.cp;
        FrameLayout frameLayout = this.de;
        com.kwad.components.ad.draw.kwai.b bVar3 = this.bW;
        bVar2.a(frameLayout, bVar3.mRootContainer, bVar3.mAdTemplate, bVar3.mApkDownloadHelper);
        this.cp.a((b.InterfaceC0353b) null);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.de = (FrameLayout) findViewById(R.id.ksad_play_end_web_card_container);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.i.b bVar = this.cp;
        if (bVar != null) {
            bVar.ko();
        }
    }
}
