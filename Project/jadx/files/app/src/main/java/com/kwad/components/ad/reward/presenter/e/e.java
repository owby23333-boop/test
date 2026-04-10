package com.kwad.components.ad.reward.presenter.e;

import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.jshandler.ae;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements j.a {
    private ae wD;
    private boolean wE;
    private boolean wF;

    private void jo() {
        ae aeVar = this.wD;
        if (aeVar == null || !this.wF) {
            return;
        }
        if (this.wE) {
            aeVar.rv();
            return;
        }
        aeVar.rr();
        this.wD.rs();
        this.wE = true;
    }

    public final void a(ae aeVar) {
        this.wD = aeVar;
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gt() {
        this.wF = true;
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gu() {
        this.wF = true;
        jo();
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gv() {
        this.wF = false;
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rw();
        }
    }

    @Override // com.kwad.components.ad.reward.j.a
    public final void gw() {
        this.wF = false;
    }

    public final boolean jb() {
        return this.wF;
    }

    public final void onTkLoadFailed() {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rt();
            this.wD.ru();
        }
    }

    public final void onTkLoadSuccess() {
        jo();
    }

    public final void v(j jVar) {
        jVar.a(this);
    }

    public final void w(j jVar) {
        ae aeVar = this.wD;
        if (aeVar != null) {
            aeVar.rt();
            this.wD.ru();
        }
        jVar.b(this);
    }
}
