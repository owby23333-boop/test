package com.anythink.network.adx;

import android.content.Context;
import android.view.View;
import com.anythink.banner.unitgroup.api.CustomBannerAdapter;
import com.anythink.basead.d.a;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.e.e;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.e.k;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxATBannerAdapter extends CustomBannerAdapter {
    j a;
    Map<String, Object> b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f12322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private View f12323d;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        this.f12323d = null;
        a aVar = this.f12322c;
        if (aVar != null) {
            aVar.a((com.anythink.basead.e.a) null);
            this.f12322c.b();
            this.f12322c = null;
        }
    }

    @Override // com.anythink.banner.unitgroup.api.CustomBannerAdapter
    public View getBannerView() {
        return this.f12323d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get(g.k.a);
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillBannerData(map);
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.b;
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
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        int i2 = 0;
        int i3 = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : Integer.parseInt(obj2.toString());
        String string = (!map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE) || (obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) == null) ? k.a : obj.toString();
        if (map2 != null && map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
            try {
                i2 = (int) Double.parseDouble(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.a = (j) map.get(g.k.a);
        this.f12322c = new a(context, b.a.ADX_OFFER_REQUEST_TYPE, this.a);
        this.f12322c.a(new c.a().c(i3).b(string).g(i2).a());
        this.f12322c.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.adx.AdxATBannerAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                if (AdxATBannerAdapter.this.f12322c == null || ((ATBaseAdAdapter) AdxATBannerAdapter.this).mLoadListener == null) {
                    return;
                }
                AdxATBannerAdapter adxATBannerAdapter = AdxATBannerAdapter.this;
                adxATBannerAdapter.b = com.anythink.basead.b.a(adxATBannerAdapter.f12322c);
                AdxATBannerAdapter.this.f12322c.a(new e(AdxATBannerAdapter.this.f12322c.d()) { // from class: com.anythink.network.adx.AdxATBannerAdapter.1.1
                    @Override // com.anythink.basead.e.a
                    public final void onAdClick(int i4) {
                        com.anythink.core.common.e.e trackingInfo = AdxATBannerAdapter.this.getTrackingInfo();
                        if (trackingInfo != null) {
                            trackingInfo.x(i4);
                        }
                        if (((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener != null) {
                            ((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener.onBannerAdClicked();
                        }
                    }

                    @Override // com.anythink.basead.e.a
                    public final void onAdClosed() {
                        if (((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener != null) {
                            ((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener.onBannerAdClose();
                        }
                    }

                    @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
                    public final void onAdShow() {
                        super.onAdShow();
                        if (((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener != null) {
                            ((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener.onBannerAdShow();
                        }
                    }

                    @Override // com.anythink.basead.e.a
                    public final void onDeeplinkCallback(boolean z2) {
                        if (((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener != null) {
                            ((CustomBannerAdapter) AdxATBannerAdapter.this).mImpressionEventListener.onDeeplinkCallback(z2);
                        }
                    }

                    @Override // com.anythink.basead.e.a
                    public final void onShowFailed(com.anythink.basead.c.e eVar) {
                    }
                });
                AdxATBannerAdapter adxATBannerAdapter2 = AdxATBannerAdapter.this;
                adxATBannerAdapter2.f12323d = adxATBannerAdapter2.f12322c.a();
                if (AdxATBannerAdapter.this.f12323d != null) {
                    ((ATBaseAdAdapter) AdxATBannerAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                } else {
                    ((ATBaseAdAdapter) AdxATBannerAdapter.this).mLoadListener.onAdLoadError("", "Adx bannerView = null");
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) AdxATBannerAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATBannerAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (((ATBaseAdAdapter) AdxATBannerAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATBannerAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    private void a(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        Object obj2;
        int i2 = 0;
        int i3 = (!map.containsKey("close_button") || (obj2 = map.get("close_button")) == null) ? 0 : Integer.parseInt(obj2.toString());
        String string = (!map.containsKey(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE) || (obj = map.get(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.BANNER_SIZE)) == null) ? k.a : obj.toString();
        if (map2 != null && map2.containsKey(ATAdConst.KEY.AD_HEIGHT)) {
            try {
                i2 = (int) Double.parseDouble(map2.get(ATAdConst.KEY.AD_HEIGHT).toString());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.a = (j) map.get(g.k.a);
        this.f12322c = new a(context, b.a.ADX_OFFER_REQUEST_TYPE, this.a);
        this.f12322c.a(new c.a().c(i3).b(string).g(i2).a());
    }
}
