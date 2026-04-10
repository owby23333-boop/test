package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.d;
import com.anythink.basead.e.c;
import com.anythink.basead.e.g;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineApiATInterstitialAdapter extends CustomInterstitialAdapter {
    j a;
    d b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, Object> f12598d;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12598d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12597c;
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
        if (z2 && this.f12598d == null) {
            this.f12598d = b.a(this.b);
        }
        return z2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new c() { // from class: com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.2
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                OnlineApiATInterstitialAdapter onlineApiATInterstitialAdapter = OnlineApiATInterstitialAdapter.this;
                onlineApiATInterstitialAdapter.f12598d = b.a(onlineApiATInterstitialAdapter.b);
                if (((ATBaseAdAdapter) OnlineApiATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) OnlineApiATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) OnlineApiATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATInterstitialAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
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
        this.b.a(new g() { // from class: com.anythink.network.onlineapi.OnlineApiATInterstitialAdapter.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                com.anythink.core.common.e.e trackingInfo = OnlineApiATInterstitialAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i2);
                }
                if (((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                if (((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                if (((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z2) {
                if (((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener.onDeeplinkCallback(z2);
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onRewarded() {
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(e eVar) {
                if (((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError(eVar.a(), eVar.b());
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayEnd() {
                if (((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayStart() {
                if (((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener != null) {
                    ((CustomInterstitialAdapter) OnlineApiATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoStart();
                }
            }
        });
        d dVar = this.b;
        if (dVar != null) {
            dVar.a(activity, map);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        this.f12597c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i2 = 0;
        int i3 = -1;
        if (map.containsKey("v_m") && (obj2 = map.get("v_m")) != null) {
            i2 = Integer.parseInt(obj2.toString());
        }
        if (map.containsKey("s_c_t") && (obj = map.get("s_c_t")) != null) {
            i3 = Integer.parseInt(obj.toString());
        }
        this.a = (j) map.get(g.k.a);
        this.b = new d(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.b.a(new c.a().a(i2).b(i3).a());
        String stringFromMap = ATInitMediation.getStringFromMap(map, "unit_type");
        if (TextUtils.isEmpty(stringFromMap)) {
            return;
        }
        this.b.a(stringFromMap);
    }
}
