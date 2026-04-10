package com.anythink.network.myoffer;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.b;
import com.anythink.basead.e.a;
import com.anythink.basead.e.c;
import com.anythink.basead.f.g;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MyOfferATSplashAdapter extends CustomSplashAdapter {
    String a;
    g b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    j f12589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, Object> f12590d;

    /* JADX INFO: renamed from: com.anythink.network.myoffer.MyOfferATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(int i2) {
            e trackingInfo = MyOfferATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i2);
            }
            if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow() {
            if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z2) {
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) MyOfferATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, eVar.a(), eVar.b()));
            }
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        g gVar = this.b;
        if (gVar != null) {
            gVar.f();
            this.b = null;
        }
        this.f12589c = null;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12590d;
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
        return com.anythink.core.common.k.g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        g gVar = this.b;
        boolean z2 = gVar != null && gVar.a();
        if (z2 && this.f12590d == null) {
            this.f12590d = b.a(this.b);
        }
        return z2;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.a = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.a)) {
            this.f12589c = (j) map.get(g.k.a);
        }
        this.b = new com.anythink.basead.f.g(context, this.f12589c, this.a);
        this.b.a(new AnonymousClass2());
        this.b.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATSplashAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                if (((ATBaseAdAdapter) MyOfferATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (((ATBaseAdAdapter) MyOfferATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MyOfferATSplashAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.b != null) {
            if (isCustomSkipView()) {
                this.b.b();
            }
            this.b.a(viewGroup);
        }
    }

    private void a(Context context) {
        this.b = new com.anythink.basead.f.g(context, this.f12589c, this.a);
        this.b.a(new AnonymousClass2());
    }
}
