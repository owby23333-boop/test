package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.e.c;
import com.anythink.basead.e.g;
import com.anythink.basead.f.f;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.d;
import com.anythink.core.common.s;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MyOfferATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    j a;
    Map<String, Object> b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f12587d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12586c = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12588e = false;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        f fVar = this.f12587d;
        if (fVar != null) {
            fVar.a((g) null);
            this.f12587d = null;
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
        return this.f12586c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return com.anythink.core.common.k.g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f12586c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.a = (j) map.get(g.k.a);
        }
        if (map.containsKey(s.b)) {
            this.f12588e = ((Boolean) map.get(s.b)).booleanValue();
        }
        a(context);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        f fVar = this.f12587d;
        boolean z2 = fVar != null && fVar.a();
        if (z2 && this.b == null) {
            this.b = b.a(this.f12587d);
        }
        return z2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f12586c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.a = (j) map.get(g.k.a);
        }
        a(context);
        this.f12587d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATRewardedVideoAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                MyOfferATRewardedVideoAdapter myOfferATRewardedVideoAdapter = MyOfferATRewardedVideoAdapter.this;
                myOfferATRewardedVideoAdapter.b = b.a(myOfferATRewardedVideoAdapter.f12587d);
                if (((ATBaseAdAdapter) MyOfferATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) MyOfferATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATRewardedVideoAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        int iG = d.g(activity);
        if (isAdReady()) {
            HashMap map = new HashMap(1);
            map.put(com.anythink.basead.f.c.f6030h, this.a.f7303d);
            map.put("extra_scenario", this.mScenario);
            map.put(com.anythink.basead.f.c.f6032j, Integer.valueOf(iG));
            this.f12587d.a(new com.anythink.basead.e.g() { // from class: com.anythink.network.myoffer.MyOfferATRewardedVideoAdapter.2
                @Override // com.anythink.basead.e.a
                public final void onAdClick(int i2) {
                    com.anythink.core.common.e.e trackingInfo = MyOfferATRewardedVideoAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i2);
                    }
                    if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdClosed() {
                    if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdShow() {
                    if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onDeeplinkCallback(boolean z2) {
                }

                @Override // com.anythink.basead.e.g
                public final void onRewarded() {
                    if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onReward();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onShowFailed(e eVar) {
                    if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(eVar.a(), eVar.b());
                    }
                }

                @Override // com.anythink.basead.e.g
                public final void onVideoAdPlayEnd() {
                    if (((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MyOfferATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                @Override // com.anythink.basead.e.g
                public final void onVideoAdPlayStart() {
                }
            });
            this.f12587d.a(activity, map);
        }
    }

    private void a(Context context) {
        this.f12587d = new f(context, this.a, this.f12586c, this.f12588e);
    }
}
