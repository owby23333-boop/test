package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.f;
import com.anythink.basead.e.c;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.d;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    j a;
    f b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Object> f12329c;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        f fVar = this.b;
        if (fVar != null) {
            fVar.b();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, ((j) map.get(g.k.a)).b);
        adxBidRequestInfo.fillAdAcceptType();
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12329c;
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
        f fVar = this.b;
        boolean z2 = fVar != null && fVar.c();
        if (z2 && this.f12329c == null) {
            this.f12329c = b.a(this.b);
        }
        return z2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new c() { // from class: com.anythink.network.adx.AdxATRewardedVideoAdapter.2
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                AdxATRewardedVideoAdapter adxATRewardedVideoAdapter = AdxATRewardedVideoAdapter.this;
                adxATRewardedVideoAdapter.f12329c = b.a(adxATRewardedVideoAdapter.b);
                if (((ATBaseAdAdapter) AdxATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) AdxATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) AdxATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATRewardedVideoAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        int iG = d.g(activity);
        HashMap map = new HashMap(1);
        map.put("extra_scenario", this.mScenario);
        map.put(com.anythink.basead.f.c.f6032j, Integer.valueOf(iG));
        f fVar = this.b;
        fVar.a(new com.anythink.basead.e.f(fVar.d()) { // from class: com.anythink.network.adx.AdxATRewardedVideoAdapter.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                com.anythink.core.common.e.e trackingInfo = AdxATRewardedVideoAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i2);
                }
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.anythink.basead.e.f, com.anythink.basead.e.a
            public final void onAdShow() {
                super.onAdShow();
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z2) {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onDeeplinkCallback(z2);
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onRewarded() {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onReward();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(e eVar) {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(eVar.a(), eVar.b());
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayEnd() {
                if (((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) AdxATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayStart() {
            }
        });
        f fVar2 = this.b;
        if (fVar2 != null) {
            fVar2.a(activity, map);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        int i2 = (!map.containsKey("v_m") || (obj2 = map.get("v_m")) == null) ? 0 : Integer.parseInt(obj2.toString());
        int i3 = (!map.containsKey("s_c_t") || (obj = map.get("s_c_t")) == null) ? -1 : Integer.parseInt(obj.toString());
        this.a = (j) map.get(g.k.a);
        this.b = new f(context, b.a.ADX_OFFER_REQUEST_TYPE, this.a);
        this.b.a(new c.a().a(i2).b(i3).a());
    }
}
