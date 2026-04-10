package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.d;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.ad.interstitial.h.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends PagerAdapter {
    private final KsAdVideoPlayConfig bU;
    private final KsInterstitialAd.AdInteractionListener kQ;
    private final d kW;
    private final boolean kX;
    private b kY;
    private InterfaceC0280a kZ;
    private AdResultData mAdResultData;
    private final List<AdTemplate> mAdTemplateList = new ArrayList();

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.aggregate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0280a {
        void dz();
    }

    public interface b {
        void a(c cVar, int i);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    public a(AdResultData adResultData, d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mAdResultData = adResultData;
        this.kW = dVar;
        this.bU = ksAdVideoPlayConfig;
        this.kQ = adInteractionListener;
        this.kX = com.kwad.sdk.core.response.b.a.cA(e.el(com.kwad.sdk.core.response.b.c.r(adResultData))) == 1;
    }

    public final void d(List<AdTemplate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(list);
    }

    public final void a(b bVar) {
        this.kY = bVar;
    }

    public final void a(InterfaceC0280a interfaceC0280a) {
        this.kZ = interfaceC0280a;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.mAdTemplateList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final Object instantiateItem(ViewGroup viewGroup, final int i) {
        c cVar = new c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i > 0);
        cVar.setAdAggregateClickActionListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
            @Override // com.kwad.components.ad.interstitial.f.c.a
            public final void a(long j, long j2, boolean z) {
                AdTemplate adTemplate = (AdTemplate) a.this.mAdTemplateList.get(i);
                if (adTemplate == null) {
                    return;
                }
                if (i == 0 && z) {
                    com.kwad.components.ad.interstitial.report.a.eO().b(adTemplate, j, j2);
                }
                if (a.this.kZ != null) {
                    a.this.kZ.dz();
                }
            }
        });
        if (i > 0) {
            cVar.setAggregateShowTriggerType(8);
        }
        cVar.a(this.mAdResultData, this.kW, this.bU, this.kQ, i);
        b bVar = this.kY;
        if (bVar != null) {
            bVar.a(cVar, i);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }
}
