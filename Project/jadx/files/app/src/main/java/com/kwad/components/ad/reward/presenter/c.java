package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    private ComplianceTextView cq;
    private com.kwad.components.core.webview.a.d.b jz = new com.kwad.components.core.webview.a.d.b() { // from class: com.kwad.components.ad.reward.presenter.c.1
        @Override // com.kwad.components.core.webview.a.d.b
        public final void u(String str) {
            if (com.kwad.components.core.webview.a.i.b("ksad-video-top-bar", c.this.qS.mAdTemplate).equals(str)) {
                c.this.cq.setVisibility(0);
                c.this.cq.setAdTemplate(c.this.qS.mAdTemplate);
            }
        }
    };

    private boolean hK() {
        com.kwad.components.ad.reward.j jVar = this.qS;
        return jVar.pN ? com.kwad.components.ad.reward.j.b(jVar) : com.kwad.components.ad.reward.j.c(jVar);
    }

    @Override // com.kwad.components.ad.reward.presenter.a, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        com.kwad.components.core.webview.a.c.a.rE().a(this.jz);
        if (hK()) {
            return;
        }
        this.cq.setVisibility(0);
        this.cq.setAdTemplate(this.qS.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.cq = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.webview.a.c.a.rE().b(this.jz);
    }
}
