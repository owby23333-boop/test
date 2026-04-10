package com.kwad.components.ad.interstitial.aggregate;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.kwad.components.ad.interstitial.c.c;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends PagerAdapter {
    private final KsAdVideoPlayConfig dY;
    private final KsInterstitialAd.AdInteractionListener hK;
    private final com.kwad.components.ad.interstitial.d hR;
    private final boolean hS;
    private b hT;
    private InterfaceC0354a hU;
    private final List<AdTemplate> mAdTemplateList = new ArrayList();

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.aggregate.a$a, reason: collision with other inner class name */
    public interface InterfaceC0354a {
        void cs();
    }

    public interface b {
        void a(com.kwad.components.ad.interstitial.e.c cVar, int i2);
    }

    public a(AdTemplate adTemplate, com.kwad.components.ad.interstitial.d dVar, KsAdVideoPlayConfig ksAdVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.hR = dVar;
        this.dY = ksAdVideoPlayConfig;
        this.hK = adInteractionListener;
        this.hS = com.kwad.sdk.core.response.a.a.bX(com.kwad.sdk.core.response.a.d.cb(adTemplate)) == 1;
    }

    public final void a(InterfaceC0354a interfaceC0354a) {
        this.hU = interfaceC0354a;
    }

    public final void a(b bVar) {
        this.hT = bVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final void destroyItem(@NonNull ViewGroup viewGroup, int i2, Object obj) {
        if (obj instanceof View) {
            viewGroup.removeView((View) obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final int getCount() {
        return this.mAdTemplateList.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public final Object instantiateItem(@NonNull ViewGroup viewGroup, int i2) {
        com.kwad.components.ad.interstitial.e.c cVar = new com.kwad.components.ad.interstitial.e.c(viewGroup.getContext());
        viewGroup.addView(cVar);
        cVar.setAggregateAdView(i2 > 0);
        if (i2 == 0) {
            cVar.setAdConvertListener(new c.a() { // from class: com.kwad.components.ad.interstitial.aggregate.a.1
                @Override // com.kwad.components.ad.interstitial.c.c.a
                public final void cr() {
                    if (a.this.hU != null) {
                        a.this.hU.cs();
                    }
                }
            });
        }
        if (i2 > 0) {
            int i3 = 7;
            if (i2 == 1 && this.hS) {
                i3 = 8;
            }
            cVar.setAggregateShowTriggerType(i3);
        }
        cVar.a(this.mAdTemplateList.get(i2), this.hR, this.dY, this.hK);
        b bVar = this.hT;
        if (bVar != null) {
            bVar.a(cVar, i2);
        }
        return cVar;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public final boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.mAdTemplateList.clear();
        this.mAdTemplateList.addAll(list);
    }
}
