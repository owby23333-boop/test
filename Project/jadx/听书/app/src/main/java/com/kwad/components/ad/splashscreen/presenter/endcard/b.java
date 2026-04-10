package com.kwad.components.ad.splashscreen.presenter.endcard;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.kwad.components.ad.splashscreen.presenter.e {
    private ComplianceTextView dI;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        mF();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    private void mF() {
        if (com.kwad.sdk.core.response.b.a.aP(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate))) {
            ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_splash_endcard);
            this.dI = complianceTextView;
            complianceTextView.setBackgroundColor(0);
            this.dI.setVisibility(0);
            this.dI.setAdTemplate(this.Gf.mAdTemplate);
        }
    }
}
