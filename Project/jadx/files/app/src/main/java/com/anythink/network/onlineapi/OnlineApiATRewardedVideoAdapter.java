package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.f;
import com.anythink.basead.e.c;
import com.anythink.basead.e.g;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.d;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineApiATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    j a;
    f b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, Object> f12601d;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        f fVar = this.b;
        if (fVar != null) {
            fVar.b();
            this.b = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12601d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12600c;
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
        if (z2 && this.f12601d == null) {
            this.f12601d = b.a(this.b);
        }
        return z2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        a(context, map);
        this.b.a(new c() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.2
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                OnlineApiATRewardedVideoAdapter onlineApiATRewardedVideoAdapter = OnlineApiATRewardedVideoAdapter.this;
                onlineApiATRewardedVideoAdapter.f12601d = b.a(onlineApiATRewardedVideoAdapter.b);
                if (((ATBaseAdAdapter) OnlineApiATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) OnlineApiATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) OnlineApiATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATRewardedVideoAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
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
        this.b.a(new g() { // from class: com.anythink.network.onlineapi.OnlineApiATRewardedVideoAdapter.1
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                com.anythink.core.common.e.e trackingInfo = OnlineApiATRewardedVideoAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i2);
                }
                if (((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                if (((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                if (((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z2) {
                if (((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener.onDeeplinkCallback(z2);
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onRewarded() {
                if (((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener.onReward();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(e eVar) {
                if (((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed(eVar.a(), eVar.b());
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayEnd() {
                if (((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener != null) {
                    ((CustomRewardVideoAdapter) OnlineApiATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
                }
            }

            @Override // com.anythink.basead.e.g
            public final void onVideoAdPlayStart() {
            }
        });
        f fVar = this.b;
        if (fVar != null) {
            fVar.a(activity, map);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        this.f12600c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i2 = 0;
        int i3 = -1;
        if (map.containsKey("v_m") && (obj2 = map.get("v_m")) != null) {
            i2 = Integer.parseInt(obj2.toString());
        }
        if (map.containsKey("s_c_t") && (obj = map.get("s_c_t")) != null) {
            i3 = Integer.parseInt(obj.toString());
        }
        this.a = (j) map.get(g.k.a);
        this.b = new f(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.b.a(new c.a().a(i2).b(i3).a());
    }
}
