package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.d;
import com.anythink.basead.e.c;
import com.anythink.basead.e.f;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxATInterstitialAdapter extends CustomInterstitialAdapter {
    protected j a;
    protected d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Object> f12324c;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get(g.k.a);
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillInterstitial(map);
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12324c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        j jVar = this.a;
        return jVar != null ? jVar.b : "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        d dVar = this.b;
        boolean z2 = dVar != null && dVar.c();
        if (z2 && this.f12324c == null) {
            this.f12324c = b.a(this.b);
        }
        return z2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new c() { // from class: com.anythink.network.adx.AdxATInterstitialAdapter.2
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                AdxATInterstitialAdapter adxATInterstitialAdapter = AdxATInterstitialAdapter.this;
                adxATInterstitialAdapter.f12324c = b.a(adxATInterstitialAdapter.b);
                if (((ATBaseAdAdapter) AdxATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) AdxATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) AdxATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATInterstitialAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        int iG = com.anythink.core.common.k.d.g(activity);
        HashMap map = new HashMap(1);
        map.put("extra_scenario", this.mScenario);
        map.put(com.anythink.basead.f.c.f6032j, Integer.valueOf(iG));
        d dVar = this.b;
        dVar.a(new f(dVar.d()) { // from class: com.anythink.network.adx.AdxATInterstitialAdapter.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                com.anythink.core.common.e.e trackingInfo = AdxATInterstitialAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i2);
                }
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.anythink.basead.e.f, com.anythink.basead.e.a
            public final void onAdShow() {
                super.onAdShow();
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z2) {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onDeeplinkCallback(z2);
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onRewarded() {
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(e eVar) {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayEnd() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayStart() {
                if (((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) AdxATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
                }
            }
        });
        d dVar2 = this.b;
        if (dVar2 != null) {
            dVar2.a(activity, map);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        Object obj3;
        int i2 = (!map.containsKey("v_m") || (obj3 = map.get("v_m")) == null) ? 0 : Integer.parseInt(obj3.toString());
        int i3 = (!map.containsKey("s_c_t") || (obj2 = map.get("s_c_t")) == null) ? -1 : Integer.parseInt(obj2.toString());
        this.a = (j) map.get(g.k.a);
        this.b = new d(context, b.a.ADX_OFFER_REQUEST_TYPE, this.a);
        this.b.a(new c.a().a((!map.containsKey("inter_type") || (obj = map.get("inter_type")) == null) ? "1" : obj.toString()).a(i2).b(i3).a());
    }
}
