package com.anythink.network.onlineapi;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.b;
import com.anythink.basead.d.a;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineApiATBannerAdapter extends CustomBannerAdapter {
    j a;
    String b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Object> f12594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f12595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f12596e;

    /* JADX INFO: renamed from: com.anythink.network.onlineapi.OnlineApiATBannerAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements com.anythink.basead.e.a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(int i2) {
            e trackingInfo = OnlineApiATBannerAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i2);
            }
            if (((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener.onBannerAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow() {
            if (((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener.onBannerAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z2) {
            if (((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener != null) {
                ((CustomBannerAdapter) OnlineApiATBannerAdapter.this).mImpressionEventListener.onDeeplinkCallback(z2);
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.f12596e = null;
        a aVar = this.f12595d;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.f12595d.b();
            this.f12595d = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        a aVar;
        if (this.f12596e == null && (aVar = this.f12595d) != null && aVar.c()) {
            this.f12596e = this.f12595d.a();
        }
        if (this.f12594c == null) {
            this.f12594c = b.a(this.f12595d);
        }
        return this.f12596e;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12594c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.b;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i2 = 0;
        if (map.containsKey("close_button") && (obj2 = map.get("close_button")) != null) {
            i2 = Integer.parseInt(obj2.toString());
        }
        String string = (!map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE) || (obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) == null) ? k.a : obj.toString();
        this.a = (j) map.get(g.k.a);
        this.f12595d = new a(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.f12595d.a(new c.a().c(i2).b(string).a());
        this.f12595d.a(new AnonymousClass2());
        this.f12595d.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATBannerAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                OnlineApiATBannerAdapter onlineApiATBannerAdapter = OnlineApiATBannerAdapter.this;
                onlineApiATBannerAdapter.f12596e = onlineApiATBannerAdapter.f12595d.a();
                if (((ATBaseAdAdapter) OnlineApiATBannerAdapter.this).mLoadListener != null) {
                    if (OnlineApiATBannerAdapter.this.f12596e != null) {
                        ((ATBaseAdAdapter) OnlineApiATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    } else {
                        ((ATBaseAdAdapter) OnlineApiATBannerAdapter.this).mLoadListener.onAdLoadError("", "Online bannerView = null");
                    }
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) OnlineApiATBannerAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATBannerAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (((ATBaseAdAdapter) OnlineApiATBannerAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATBannerAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        Object obj2;
        this.b = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i2 = 0;
        if (map.containsKey("close_button") && (obj2 = map.get("close_button")) != null) {
            i2 = Integer.parseInt(obj2.toString());
        }
        String string = (!map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE) || (obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) == null) ? k.a : obj.toString();
        this.a = (j) map.get(g.k.a);
        this.f12595d = new a(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.a);
        this.f12595d.a(new c.a().c(i2).b(string).a());
        this.f12595d.a(new AnonymousClass2());
    }
}
