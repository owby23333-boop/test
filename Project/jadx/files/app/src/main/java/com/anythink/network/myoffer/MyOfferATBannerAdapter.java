package com.anythink.network.myoffer;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.c.e;
import com.anythink.basead.e.a;
import com.anythink.basead.e.c;
import com.anythink.basead.f.b;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.g;
import com.anythink.core.common.s;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MyOfferATBannerAdapter extends CustomBannerAdapter {
    String a;
    j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Object> f12578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f12579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private View f12580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12581f = false;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.f12580e = null;
        b bVar = this.f12579d;
        if (bVar != null) {
            bVar.a((a) null);
            this.f12579d.c();
            this.f12579d = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        b bVar;
        if (this.f12580e == null && (bVar = this.f12579d) != null && bVar.a()) {
            this.f12580e = this.f12579d.b();
            if (this.f12578c == null) {
                this.f12578c = com.anythink.basead.b.a(this.f12579d);
            }
        }
        return this.f12580e;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12578c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.a;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.b = (j) map.get(g.k.a);
        }
        if (map.containsKey(s.b)) {
            this.f12581f = ((Boolean) map.get(s.b)).booleanValue();
        }
        a(context);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.b = (j) map.get(g.k.a);
        }
        a(context);
        this.f12579d.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATBannerAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                MyOfferATBannerAdapter myOfferATBannerAdapter = MyOfferATBannerAdapter.this;
                myOfferATBannerAdapter.f12580e = myOfferATBannerAdapter.f12579d.b();
                MyOfferATBannerAdapter myOfferATBannerAdapter2 = MyOfferATBannerAdapter.this;
                myOfferATBannerAdapter2.f12578c = com.anythink.basead.b.a(myOfferATBannerAdapter2.f12579d);
                if (((ATBaseAdAdapter) MyOfferATBannerAdapter.this).mLoadListener != null) {
                    if (MyOfferATBannerAdapter.this.f12580e != null) {
                        ((ATBaseAdAdapter) MyOfferATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                    } else {
                        ((ATBaseAdAdapter) MyOfferATBannerAdapter.this).mLoadListener.onAdLoadError("", "MyOffer bannerView = null");
                    }
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) MyOfferATBannerAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATBannerAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    private void a(Context context) {
        this.f12579d = new b(context, this.b, this.a, this.f12581f);
        this.f12579d.a(new a() { // from class: com.anythink.network.myoffer.MyOfferATBannerAdapter.2
            @Override // com.anythink.basead.e.a
            public final void onAdClick(int i2) {
                com.anythink.core.common.e.e trackingInfo = MyOfferATBannerAdapter.this.getTrackingInfo();
                if (trackingInfo != null) {
                    trackingInfo.x(i2);
                }
                if (((CustomBannerAdapter) MyOfferATBannerAdapter.this).mImpressionEventListener != null) {
                    ((CustomBannerAdapter) MyOfferATBannerAdapter.this).mImpressionEventListener.onBannerAdClicked();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdClosed() {
                if (((CustomBannerAdapter) MyOfferATBannerAdapter.this).mImpressionEventListener != null) {
                    ((CustomBannerAdapter) MyOfferATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onAdShow() {
                if (((CustomBannerAdapter) MyOfferATBannerAdapter.this).mImpressionEventListener != null) {
                    ((CustomBannerAdapter) MyOfferATBannerAdapter.this).mImpressionEventListener.onBannerAdShow();
                }
            }

            @Override // com.anythink.basead.e.a
            public final void onDeeplinkCallback(boolean z2) {
            }

            @Override // com.anythink.basead.e.a
            public final void onShowFailed(e eVar) {
            }
        });
    }
}
