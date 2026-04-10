package com.kwad.components.ad.reward.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends b {
    private ComplianceTextView dI;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dI = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void at() {
        super.at();
        this.dI.setVisibility(0);
        this.dI.setAdTemplate(this.tm.mAdTemplate);
    }
}
