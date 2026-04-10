package com.anythink.network.onlineapi;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.anythink.basead.b;
import com.anythink.basead.d.b;
import com.anythink.basead.d.c;
import com.anythink.basead.d.g;
import com.anythink.basead.e.a;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.e;
import com.anythink.core.common.e.j;
import com.anythink.splashad.unitgroup.api.CustomSplashAdapter;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class OnlineApiATSplashAdapter extends CustomSplashAdapter {
    g a;
    j b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    String f12602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Map<String, Object> f12603d;

    /* JADX INFO: renamed from: com.anythink.network.onlineapi.OnlineApiATSplashAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements a {
        AnonymousClass2() {
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClick(int i2) {
            e trackingInfo = OnlineApiATSplashAdapter.this.getTrackingInfo();
            if (trackingInfo != null) {
                trackingInfo.x(i2);
            }
            if (((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdClicked();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdClosed() {
            if (((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdDismiss();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onAdShow() {
            if (((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdShow();
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onDeeplinkCallback(boolean z2) {
            if (((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener.onDeeplinkCallback(z2);
            }
        }

        @Override // com.anythink.basead.e.a
        public final void onShowFailed(com.anythink.basead.c.e eVar) {
            if (((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener != null) {
                ((CustomSplashAdapter) OnlineApiATSplashAdapter.this).mImpressionListener.onSplashAdShowFail(ErrorCode.getErrorCode(ErrorCode.adShowError, eVar.a(), eVar.b()));
            }
        }
    }

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
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12603d;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12602c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return "";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        g gVar = this.a;
        boolean z2 = gVar != null && gVar.c();
        if (z2 && this.f12603d == null) {
            this.f12603d = b.a(this.a);
        }
        return z2;
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public boolean isSupportCustomSkipView() {
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        Object obj;
        int i2;
        Object obj2;
        Object obj3;
        this.f12602c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i3 = 5;
        int i4 = 1;
        int i5 = (!map.containsKey("orientation") || (obj3 = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj3.toString());
        if (map.containsKey(com.anythink.expressad.d.a.b.dk) && (obj2 = map.get(com.anythink.expressad.d.a.b.dk)) != null) {
            i3 = Integer.parseInt(obj2.toString()) * 1000;
        }
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (i2 = Integer.parseInt(obj.toString())) != 0) {
            i4 = i2 == 1 ? 0 : i2;
        }
        this.b = (j) map.get(g.k.a);
        this.a = new com.anythink.basead.d.g(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
        this.a.a(new c.a().d(i5).e(i3).f(i4).a());
        this.a.a(new AnonymousClass2());
        this.a.a(new com.anythink.basead.e.c() { // from class: com.anythink.network.onlineapi.OnlineApiATSplashAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                OnlineApiATSplashAdapter onlineApiATSplashAdapter = OnlineApiATSplashAdapter.this;
                onlineApiATSplashAdapter.f12603d = com.anythink.basead.b.a(onlineApiATSplashAdapter.a);
                if (((ATBaseAdAdapter) OnlineApiATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATSplashAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
                if (((ATBaseAdAdapter) OnlineApiATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATSplashAdapter.this).mLoadListener.onAdDataLoaded();
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (((ATBaseAdAdapter) OnlineApiATSplashAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) OnlineApiATSplashAdapter.this).mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }

    @Override // com.anythink.splashad.unitgroup.api.CustomSplashAdapter
    public void show(Activity activity, ViewGroup viewGroup) {
        if (this.a != null) {
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
        this.f12602c = map.get("unit_id") != null ? map.get("unit_id").toString() : "";
        int i3 = 5;
        int i4 = 1;
        int i5 = (!map.containsKey("orientation") || (obj3 = map.get("orientation")) == null) ? 1 : Integer.parseInt(obj3.toString());
        if (map.containsKey(com.anythink.expressad.d.a.b.dk) && (obj2 = map.get(com.anythink.expressad.d.a.b.dk)) != null) {
            i3 = Integer.parseInt(obj2.toString()) * 1000;
        }
        if (map.containsKey("allows_skip") && (obj = map.get("allows_skip")) != null && (i2 = Integer.parseInt(obj.toString())) != 0) {
            i4 = i2 == 1 ? 0 : i2;
        }
        this.b = (j) map.get(g.k.a);
        this.a = new com.anythink.basead.d.g(context, b.a.ONLINE_API_OFFER_REQUEST_TYPE, this.b);
        this.a.a(new c.a().d(i5).e(i3).f(i4).a());
        this.a.a(new AnonymousClass2());
    }
}
