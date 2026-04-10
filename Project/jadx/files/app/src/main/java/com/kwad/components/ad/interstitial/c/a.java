package com.kwad.components.ad.interstitial.c;

import android.view.OrientationEventListener;
import android.view.View;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.utils.ah;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends b {
    private ComplianceTextView jl;
    private OrientationEventListener jm;
    private KsAutoCloseView jn;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final c cVar) {
        this.jm = new OrientationEventListener(cVar.hR.getContext()) { // from class: com.kwad.components.ad.interstitial.c.a.2
            @Override // android.view.OrientationEventListener
            public final void onOrientationChanged(int i2) {
                a.this.b(cVar);
            }
        };
        if (this.jm.canDetectOrientation()) {
            this.jm.enable();
        } else {
            this.jm.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar) {
        h(this.jl);
        if (ah.DI()) {
            com.kwad.sdk.b.kwai.a.b(this.jn, 0, com.kwad.sdk.b.kwai.a.a(getContext(), 25.0f), 0, 0);
        } else {
            com.kwad.sdk.b.kwai.a.b(this.jn, 0, 0, 0, 0);
        }
        this.jl.setVisibility(0);
        this.jl.setAdTemplate(cVar.mAdTemplate);
    }

    private void h(View view) {
        int iA = com.kwad.sdk.b.kwai.a.a(getContext(), 4.0f);
        int iA2 = com.kwad.sdk.b.kwai.a.a(getContext(), 4.0f);
        com.kwad.sdk.b.kwai.a.b(view, iA2, iA, iA2, 0);
    }

    @Override // com.kwad.components.ad.interstitial.c.b, com.kwad.sdk.mvp.Presenter
    public final void ar() {
        super.ar();
        final c cVar = (c) Bs();
        cVar.a(new c.e() { // from class: com.kwad.components.ad.interstitial.c.a.1
            @Override // com.kwad.components.ad.interstitial.c.c.e
            public final void onError() {
                a.this.b(cVar);
                a.this.a(cVar);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.jl = (ComplianceTextView) findViewById(R.id.ksad_compliance_view);
        this.jn = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        OrientationEventListener orientationEventListener = this.jm;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }
}
