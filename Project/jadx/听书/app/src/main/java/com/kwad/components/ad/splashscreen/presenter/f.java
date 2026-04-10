package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends e {
    private ComplianceTextView dI;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(com.kwad.components.ad.splashscreen.e.c.z(com.kwad.sdk.core.response.b.e.el(this.Gf.mAdTemplate)) ? R.id.ksad_compliance_right_view : R.id.ksad_compliance_left_view);
        this.dI = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.dI.setVisibility(0);
        this.dI.setAdTemplate(this.Gf.mAdTemplate);
    }
}
