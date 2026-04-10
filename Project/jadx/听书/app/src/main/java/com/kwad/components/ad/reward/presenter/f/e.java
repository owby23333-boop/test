package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.ad.reward.g;
import com.kwad.components.core.webview.jshandler.az;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements g.a {
    private az cX;
    private boolean zU;
    private boolean zV;

    private void ki() {
        az azVar = this.cX;
        if (azVar == null || !this.zV) {
            return;
        }
        if (!this.zU) {
            azVar.uF();
            this.cX.uG();
            this.zU = true;
            return;
        }
        azVar.uJ();
    }

    public final void b(az azVar) {
        this.cX = azVar;
    }

    public final void A(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void B(com.kwad.components.ad.reward.g gVar) {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
        gVar.b(this);
    }

    public final void az() {
        ki();
    }

    public final void kj() {
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uH();
            this.cX.uI();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hd() {
        this.zV = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void he() {
        this.zV = true;
        ki();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hf() {
        this.zV = false;
        az azVar = this.cX;
        if (azVar != null) {
            azVar.uK();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hg() {
        this.zV = false;
    }
}
