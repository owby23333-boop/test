package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.e.c;
import com.anythink.basead.e.g;
import com.anythink.basead.f.d;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.s;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MyOfferATInterstitialAdapter extends CustomInterstitialAdapter {
    j a;
    Map<String, Object> b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f12583d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12582c = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12584e = false;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        d dVar = this.f12583d;
        if (dVar != null) {
            dVar.a((g) null);
            this.f12583d = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12582c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return com.anythink.core.common.k.g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f12582c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.a = (j) map.get(g.k.a);
        }
        if (map.containsKey(s.b)) {
            this.f12584e = ((Boolean) map.get(s.b)).booleanValue();
        }
        a(context);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        d dVar = this.f12583d;
        boolean z2 = dVar != null && dVar.a();
        if (z2 && this.b == null) {
            this.b = b.a(this.f12583d);
        }
        return z2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f12582c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.a = (j) map.get(g.k.a);
        }
        a(context);
        this.f12583d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATInterstitialAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                MyOfferATInterstitialAdapter myOfferATInterstitialAdapter = MyOfferATInterstitialAdapter.this;
                myOfferATInterstitialAdapter.b = b.a(myOfferATInterstitialAdapter.f12583d);
                if (((ATBaseAdAdapter) MyOfferATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) MyOfferATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATInterstitialAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        if (isAdReady()) {
            HashMap map = new HashMap(1);
            int iG = com.anythink.core.common.k.d.g(activity);
            map.put(com.anythink.basead.f.c.f6030h, this.a.f7303d);
            map.put("extra_scenario", this.mScenario);
            map.put(com.anythink.basead.f.c.f6032j, Integer.valueOf(iG));
            this.f12583d.a(new com.anythink.basead.e.g() { // from class: com.anythink.network.myoffer.MyOfferATInterstitialAdapter.2
                @Override // com.anythink.basead.e.a
                public final void onAdClick(int i2) {
                    com.anythink.core.common.e.e trackingInfo = MyOfferATInterstitialAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i2);
                    }
                    if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdClosed() {
                    if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdShow() {
                    if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onDeeplinkCallback(boolean z2) {
                }

                @Override // com.anythink.basead.e.g
                public final void onRewarded() {
                }

                @Override // com.anythink.basead.e.a
                public final void onShowFailed(e eVar) {
                    if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
                    }
                }

                @Override // com.anythink.basead.e.g
                public final void onVideoAdPlayEnd() {
                    if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                    }
                }

                @Override // com.anythink.basead.e.g
                public final void onVideoAdPlayStart() {
                    if (((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener != null) {
                        ((CustomInterstitialAdapter) MyOfferATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
                    }
                }
            });
            this.f12583d.a(activity, map);
        }
    }

    private void a(Context context) {
        this.f12583d = new d(context, this.a, this.f12582c, this.f12584e);
    }
}
