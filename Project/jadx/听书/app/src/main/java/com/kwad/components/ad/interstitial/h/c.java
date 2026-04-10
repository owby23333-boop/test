package com.kwad.components.ad.interstitial.h;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.ad.interstitial.f.f;
import com.kwad.components.ad.interstitial.h.d;
import com.kwad.components.core.webview.tachikoma.f.g;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o.m;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.widget.KSFrameLayout;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends a {
    private KsAdVideoPlayConfig bU;
    protected KsInterstitialAd.AdInteractionListener kQ;
    private com.kwad.components.ad.interstitial.d kW;
    protected AdInfo mAdInfo;
    protected AdResultData mAdResultData;
    protected AdTemplate mAdTemplate;
    protected com.kwad.components.ad.interstitial.f.c mj;
    private boolean mn;
    private c.a mo;
    private g mq;
    private int mx;
    protected com.kwad.components.ad.interstitial.f.b nW;
    private boolean nX;
    protected ViewGroup nY;

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.nX = false;
        return false;
    }

    public c(Context context) {
        this(context, null);
    }

    private c(Context context, AttributeSet attributeSet) {
        super(context, null);
        this.mx = -1;
        this.mq = new g() { // from class: com.kwad.components.ad.interstitial.h.c.1
            @Override // com.kwad.components.core.webview.tachikoma.f.b
            public final void v(String str) {
                if ("tk_interstitial".equals(str)) {
                    c.a(c.this, false);
                    if (c.this.nW != null) {
                        c.this.nW.ny();
                    }
                    c cVar = c.this;
                    cVar.nW = cVar.eZ();
                    c.this.nW.K(c.this.nY);
                    c.this.nW.n(c.this.mj);
                }
            }

            @Override // com.kwad.components.core.webview.tachikoma.f.g
            public final void a(String str, long j, long j2, long j3) {
                c.this.mj.mw = true;
            }
        };
        this.nY = (ViewGroup) m.inflate(context, getLayoutId(), this);
    }

    protected final int getLayoutId() {
        return R.layout.ksad_interstitial;
    }

    private com.kwad.components.ad.interstitial.f.c eY() {
        com.kwad.components.ad.interstitial.f.c cVar = new com.kwad.components.ad.interstitial.f.c();
        cVar.a(this.mAdResultData);
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.kQ = this.kQ;
        cVar.kW = this.kW;
        cVar.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
        cVar.bU = this.bU;
        cVar.cq = new com.kwad.sdk.core.video.videoview.a(this.mContext);
        cVar.fV = (KSFrameLayout) this.nY.findViewById(R.id.ksad_container);
        cVar.kO = new com.kwad.components.ad.interstitial.g.b(cVar.fV, com.kwad.sdk.core.config.e.Fb());
        cVar.kO.wi();
        cVar.mx = this.mx;
        cVar.mn = this.mn;
        cVar.mo = this.mo;
        cVar.mq = this.mq;
        cVar.mk = a(this.mContext, com.kwad.sdk.core.response.b.e.el(this.mAdTemplate), cVar);
        return cVar;
    }

    private d a(Context context, AdInfo adInfo, com.kwad.components.ad.interstitial.f.c cVar) {
        boolean zA = com.kwad.components.ad.interstitial.f.c.a(this.mContext, adInfo);
        d.a aVar = new d.a();
        aVar.w(zA);
        boolean z = true;
        aVar.x(!cVar.M(context) && com.kwad.components.ad.interstitial.b.b.dI());
        aVar.R(com.kwad.components.ad.interstitial.b.b.dJ());
        if (com.kwad.sdk.core.response.b.a.aW(adInfo) && aq.QW()) {
            z = false;
        }
        aVar.y(z);
        return new d(context, aVar);
    }

    public final com.kwad.components.ad.interstitial.f.b eZ() {
        com.kwad.components.ad.interstitial.f.b bVar = new com.kwad.components.ad.interstitial.f.b();
        if (this.nX) {
            bVar.a(new com.kwad.components.ad.interstitial.f.a.b());
        } else {
            if (com.kwad.sdk.core.response.b.a.bc(this.mAdInfo)) {
                bVar.a(new f());
            }
            bVar.a(new com.kwad.components.ad.interstitial.f.g());
            bVar.a(new com.kwad.components.ad.interstitial.f.d());
            if (com.kwad.sdk.core.response.b.a.aP(this.mAdInfo)) {
                bVar.a(new com.kwad.components.ad.interstitial.f.a());
            }
            if (this.mj.M(getContext())) {
                bVar.a(new com.kwad.components.ad.interstitial.f.e());
            }
        }
        return bVar;
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.kQ = adInteractionListener;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.kQ = adInteractionListener;
        }
    }

    public final void setAggregateAdView(boolean z) {
        this.mn = z;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.mn = z;
        }
    }

    public final void setAdAggregateClickActionListener(c.a aVar) {
        this.mo = aVar;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.mo = aVar;
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void a(AdResultData adResultData, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener, int i) {
        List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
        if (adTemplateList != null && i < adTemplateList.size()) {
            this.mAdTemplate = adTemplateList.get(i);
        } else {
            this.mAdTemplate = com.kwad.sdk.core.response.b.c.r(adResultData);
        }
        this.mAdResultData = com.kwad.sdk.core.response.b.c.a(adResultData, this.mAdTemplate);
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.mAdTemplate.realShowType = 2;
        this.bU = ksAdVideoPlayConfig;
        this.kW = dVar;
        this.nX = com.kwad.sdk.core.response.b.b.di(this.mAdTemplate);
        this.kQ = adInteractionListener;
        this.mj = eY();
        if (this.nW == null) {
            this.nW = eZ();
        }
        this.nW.K(this.nY);
        this.nW.n(this.mj);
    }

    public final void setAggregateShowTriggerType(int i) {
        this.mx = i;
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.mx = i;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            cVar.release();
        }
        com.kwad.components.ad.interstitial.f.b bVar = this.nW;
        if (bVar != null) {
            bVar.destroy();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dA() {
        com.kwad.components.ad.interstitial.f.b bVar = this.nW;
        if (bVar != null) {
            bVar.dR();
        }
    }

    @Override // com.kwad.components.ad.interstitial.h.a
    public final void dB() {
        com.kwad.components.ad.interstitial.f.b bVar = this.nW;
        if (bVar != null) {
            bVar.dS();
        }
    }

    public final void fa() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar == null || !cVar.mv) {
            return;
        }
        this.mj.dT();
    }

    public final void fb() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            if (this.nX || cVar.mv) {
                this.mj.dU();
            }
        }
    }

    public final void fc() {
        if (this.mj != null) {
            this.mj.a(new c.C0284c(this.mContext).l(true).M(1).n(true).L(2));
        }
    }

    public final boolean fd() {
        com.kwad.components.ad.interstitial.f.c cVar = this.mj;
        if (cVar != null) {
            return cVar.mw;
        }
        return false;
    }
}
