package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.content.Context;
import com.kwad.components.ad.reward.j;
import com.kwad.components.core.webview.a.i;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends com.kwad.components.ad.reward.presenter.a implements com.kwad.components.core.webview.a.d.b {
    private AdTemplate mAdTemplate;
    private Context mContext;

    public c() {
        a(new f());
        a(new b());
        a(new com.kwad.components.ad.reward.presenter.e.f());
    }

    private void ix() {
        if (j.d(this.qS)) {
            com.kwad.components.core.webview.a.c.a.rE().a(this);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        j jVar = this.qS;
        this.mAdTemplate = jVar.mAdTemplate;
        this.mContext = jVar.mContext;
        ix();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this);
    }

    @Override // com.kwad.components.core.webview.a.d.b
    public final void u(String str) {
        if (i.b("ksad-video-bottom-card-v2", this.qS.mAdTemplate).equals(str) || i.b("ksad-fullscreen-video-card", this.qS.mAdTemplate).equals(str)) {
            j jVar = this.qS;
            jVar.ql = true;
            jVar.pz.S(true);
        }
    }
}
