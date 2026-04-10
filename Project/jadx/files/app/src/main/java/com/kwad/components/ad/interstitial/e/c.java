package com.kwad.components.ad.interstitial.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.components.ad.interstitial.c.k;
import com.kwad.components.ad.interstitial.c.l;
import com.kwad.components.ad.interstitial.e.f;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {
    private KsAdVideoPlayConfig dY;
    protected KsInterstitialAd.AdInteractionListener hK;
    private com.kwad.components.ad.interstitial.d hR;
    private int jG;
    protected com.kwad.components.ad.interstitial.c.c jq;
    private boolean jv;
    private c.a jw;
    private com.kwad.components.core.webview.a.d.b jz;

    @Nullable
    protected com.kwad.components.ad.interstitial.c.b lS;
    private boolean lT;
    protected ViewGroup lU;
    protected AdInfo mAdInfo;

    @NonNull
    protected AdTemplate mAdTemplate;

    public c(@NonNull Context context) {
        this(context, null);
    }

    private c(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, null);
        this.jG = -1;
        this.jz = new com.kwad.components.core.webview.a.d.b() { // from class: com.kwad.components.ad.interstitial.e.c.1
            @Override // com.kwad.components.core.webview.a.d.b
            public final void u(String str) {
                if (com.kwad.components.core.webview.a.i.b("ksad-interstitial-card", c.this.mAdTemplate).equals(str)) {
                    c.a(c.this, false);
                    com.kwad.components.ad.interstitial.c.b bVar = c.this.lS;
                    if (bVar != null) {
                        bVar.ko();
                    }
                    c cVar = c.this;
                    cVar.lS = cVar.ev();
                    c cVar2 = c.this;
                    cVar2.lS.H(cVar2.lU);
                    c cVar3 = c.this;
                    cVar3.lS.f(cVar3.jq);
                }
            }
        };
        this.lU = (ViewGroup) com.kwad.sdk.i.a.inflate(context, getLayoutId(), this);
    }

    private f a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.c.c cVar) {
        boolean zA = com.kwad.components.ad.interstitial.c.c.a(this.mContext, adInfo);
        f.a aVar = new f.a();
        aVar.v(zA);
        boolean z2 = true;
        aVar.w(!cVar.M(context) && com.kwad.components.ad.interstitial.kwai.b.cI());
        aVar.I(com.kwad.components.ad.interstitial.kwai.b.cJ());
        if (com.kwad.sdk.core.response.a.a.aP(adInfo) && ah.cu(context)) {
            z2 = false;
        }
        aVar.x(z2);
        return new f(context, aVar);
    }

    static /* synthetic */ boolean a(c cVar, boolean z2) {
        cVar.lT = false;
        return false;
    }

    private com.kwad.components.ad.interstitial.c.c eu() {
        com.kwad.components.ad.interstitial.c.c cVar = new com.kwad.components.ad.interstitial.c.c();
        AdTemplate adTemplate = this.mAdTemplate;
        cVar.mAdTemplate = adTemplate;
        cVar.hK = this.hK;
        cVar.hR = this.hR;
        cVar.mApkDownloadHelper = new com.kwad.components.core.d.b.c(adTemplate);
        cVar.dY = this.dY;
        cVar.eM = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        cVar.jA = (KSFrameLayout) this.lU.findViewById(R.id.ksad_container);
        cVar.hI = new com.kwad.components.ad.interstitial.d.b(cVar.jA, 100);
        cVar.hI.rU();
        cVar.jG = this.jG;
        cVar.jv = this.jv;
        cVar.jw = this.jw;
        cVar.jz = this.jz;
        cVar.jr = a(this.mContext, com.kwad.sdk.core.response.a.d.cb(this.mAdTemplate), cVar);
        return cVar;
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void a(@NonNull AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, @NonNull KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        adTemplate.realShowType = 2;
        this.dY = ksAdVideoPlayConfig;
        this.hR = dVar;
        this.lT = com.kwad.sdk.core.response.a.b.bv(this.mAdTemplate);
        this.hK = adInteractionListener;
        this.jq = eu();
        if (this.lS == null) {
            this.lS = ev();
        }
        this.lS.H(this.lU);
        this.lS.f(this.jq);
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cu() {
        com.kwad.components.ad.interstitial.c.b bVar = this.lS;
        if (bVar != null) {
            bVar.cT();
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void cv() {
        com.kwad.components.ad.interstitial.c.b bVar = this.lS;
        if (bVar != null) {
            bVar.cU();
        }
    }

    @NonNull
    public final com.kwad.components.ad.interstitial.c.b ev() {
        Presenter hVar;
        com.kwad.components.ad.interstitial.c.b bVar = new com.kwad.components.ad.interstitial.c.b();
        if (!this.lT) {
            bVar.a(new com.kwad.components.ad.interstitial.c.d());
            if (com.kwad.sdk.core.response.a.a.aV(this.mAdInfo)) {
                bVar.a(new k());
            }
            bVar.a(new l());
            bVar.a(new com.kwad.components.ad.interstitial.c.g());
            bVar.a(new com.kwad.components.ad.interstitial.c.e(this.mAdInfo));
            if (com.kwad.sdk.core.response.a.a.aI(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.c.a());
            }
            if (this.jq.M(getContext())) {
                hVar = new com.kwad.components.ad.interstitial.c.h();
            }
            return bVar;
        }
        hVar = new com.kwad.components.ad.interstitial.c.kwai.b();
        bVar.a(hVar);
        return bVar;
    }

    public final void ew() {
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar == null || !cVar.jF) {
            return;
        }
        cVar.cW();
    }

    public final void ex() {
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar != null) {
            if (this.lT || cVar.jF) {
                this.jq.cX();
            }
        }
    }

    public final void ey() {
        if (this.jq != null) {
            this.jq.a(new c.b(this.mContext).k(true).D(1).m(true).C(2));
        }
    }

    protected final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.c.b bVar = this.lS;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    public final void setAdConvertListener(c.a aVar) {
        this.jw = aVar;
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar != null) {
            cVar.jw = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.e.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hK = adInteractionListener;
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar != null) {
            cVar.hK = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z2) {
        this.jv = z2;
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar != null) {
            cVar.jv = z2;
        }
    }

    public final void setAggregateShowTriggerType(int i2) {
        this.jG = i2;
        com.kwad.components.ad.interstitial.c.c cVar = this.jq;
        if (cVar != null) {
            cVar.jG = i2;
        }
    }
}
