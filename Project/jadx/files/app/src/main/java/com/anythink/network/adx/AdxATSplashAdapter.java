package com.anythink.network.adx;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.b;
import com.anythink.basead.c.e;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.g;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class AdxATSplashAdapter extends CustomSplashAdapter {
    g a;
    j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Map<String, Object> f12330c;

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        g gVar = this.a;
        if (gVar != null) {
            gVar.b();
            this.a = null;
        }
        this.b = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get(g.k.a);
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        adxBidRequestInfo.fillSplashData();
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12330c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        j jVar = this.b;
        return jVar != null ? jVar.b : "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        com.anythink.basead.d.g gVar = this.a;
        boolean z2 = gVar != null && gVar.c();
        if (z2 && this.f12330c == null) {
            this.f12330c = b.a(this.a);
        }
        return z2;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        com.anythink.basead.d.g gVar = this.a;
        return gVar != null && gVar.e();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        int i2;
        Object obj2;
        Object obj3;
        int i3 = 1;
        int i4 = (!map.containsKey("orientation") || (obj3 = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj3.toString());
        int i5 = (!map.containsKey(com.anythink.expressad.d.a.b.dk) || (obj2 = map.get(com.anythink.expressad.d.a.b.dk)) == null) ? 5 : Integer.parseInt(obj2.toString()) * 1000;
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (i2 = Integer.parseInt(obj.toString())) != 0) {
            i3 = i2 == 1 ? 0 : i2;
        }
        this.b = (j) map.get(g.k.a);
        this.a = new com.anythink.basead.d.g(context, b.a.ADX_OFFER_REQUEST_TYPE, this.b);
        this.a.a(new c.a().d(i4).e(i5).f(i3).a());
        this.a.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.adx.AdxATSplashAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                AdxATSplashAdapter adxATSplashAdapter = AdxATSplashAdapter.this;
                adxATSplashAdapter.f12330c = com.anythink.basead.b.a(adxATSplashAdapter.a);
                if (((ATBaseAdAdapter) AdxATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) AdxATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATSplashAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(e eVar) {
                if (((ATBaseAdAdapter) AdxATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) AdxATSplashAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        com.anythink.basead.d.g gVar = this.a;
        if (gVar != null) {
            gVar.a(new com.anythink.basead.e.e(gVar.d()) { // from class: com.anythink.network.adx.AdxATSplashAdapter.2
                @Override // com.anythink.basead.e.a
                public final void onAdClick(int i2) {
                    com.anythink.core.common.e.e trackingInfo = AdxATSplashAdapter.this.getTrackingInfo();
                    if (trackingInfo != null) {
                        trackingInfo.x(i2);
                    }
                    if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                        ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onAdClosed() {
                    if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                        ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
                    }
                }

                @Override // com.anythink.basead.e.e, com.anythink.basead.e.a
                public final void onAdShow() {
                    super.onAdShow();
                    if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                        ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdShow();
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onDeeplinkCallback(boolean z2) {
                    if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                        ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onDeeplinkCallback(z2);
                    }
                }

                @Override // com.anythink.basead.e.a
                public final void onShowFailed(e eVar) {
                    if (((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener != null) {
                        ((CustomSplashAdapter) AdxATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, eVar.a(), eVar.b()));
                    }
                }
            });
            if (isCustomSkipView()) {
                this.a.a();
            }
            this.a.a(viewGroup);
        }
    }

    private void a(Context context, Map<String, Object> map) {
        Object obj;
        int i2;
        Object obj2;
        Object obj3;
        int i3 = 1;
        int i4 = (!map.containsKey("orientation") || (obj3 = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj3.toString());
        int i5 = (!map.containsKey(com.anythink.expressad.d.a.b.dk) || (obj2 = map.get(com.anythink.expressad.d.a.b.dk)) == null) ? 5 : Integer.parseInt(obj2.toString()) * 1000;
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (i2 = Integer.parseInt(obj.toString())) != 0) {
            i3 = i2 == 1 ? 0 : i2;
        }
        this.b = (j) map.get(g.k.a);
        this.a = new com.anythink.basead.d.g(context, b.a.ADX_OFFER_REQUEST_TYPE, this.b);
        this.a.a(new c.a().d(i4).e(i5).f(i3).a());
    }
}
