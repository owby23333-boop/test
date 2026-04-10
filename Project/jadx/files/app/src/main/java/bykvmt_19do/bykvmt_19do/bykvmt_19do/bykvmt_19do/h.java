package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAd;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;

/* JADX INFO: compiled from: TTInterAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends g {
    private GMInterstitialAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    GMInterstitialAdListener f2104e = new b();

    /* JADX INFO: compiled from: TTInterAdLoad.java */
    class a implements GMInterstitialAdLoadCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback
        public void onInterstitialLoad() {
            h.this.f2102c = true;
            if (h.this.b == null) {
                return;
            }
            h.this.b.b("onInterstitialLoad", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback
        public void onInterstitialLoadFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialLoadFail", adError);
            h.this.f2102c = false;
            if (h.this.b == null) {
                return;
            }
            h.this.b.b("onInterstitialLoadFail", adError);
        }
    }

    /* JADX INFO: compiled from: TTInterAdLoad.java */
    class b implements GMInterstitialAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onAdLeftApplication() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdLeftApplication", h.this.f2103d, h.this.a.getShowEcpm(), null);
            if (h.this.b == null) {
                return;
            }
            h.this.b.a("onAdLeftApplication", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onAdOpened() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdOpened", h.this.f2103d, h.this.a.getShowEcpm(), null);
            if (h.this.b == null) {
                return;
            }
            h.this.b.a("onAdOpened", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialAdClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialAdClick", h.this.f2103d, h.this.a.getShowEcpm(), null);
            if (h.this.b == null) {
                return;
            }
            h.this.b.a("onInterstitialAdClick", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialClosed() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialClosed", h.this.f2103d, h.this.a.getShowEcpm(), null);
            if (h.this.b == null) {
                return;
            }
            h.this.b.a("onInterstitialClosed", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialShow", h.this.f2103d, h.this.a.getShowEcpm(), null);
            if (h.this.b == null) {
                return;
            }
            h.this.b.a("onInterstitialShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
        public void onInterstitialShowFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialShowFail", adError);
            if (h.this.b == null) {
                return;
            }
            h.this.b.a("onInterstitialShowFail", adError);
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMInterstitialAd gMInterstitialAd = this.a;
        if (gMInterstitialAd != null) {
            return gMInterstitialAd.getPreEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2103d;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public GMAdEcpmInfo c() {
        GMInterstitialAd gMInterstitialAd = this.a;
        if (gMInterstitialAd != null) {
            return gMInterstitialAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.b = aVar;
        this.a = new GMInterstitialAd(activity, eVar.i());
        this.a.setAdInterstitialListener(this.f2104e);
        this.f2103d = eVar.i();
        this.a.loadAd(new GMAdSlotInterstitial.Builder().setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setTestSlotId("gm_test_slot_" + eVar.c()).setImageAdSize(600, 600).build(), new a());
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        GMInterstitialAd gMInterstitialAd;
        if (!this.f2102c || (gMInterstitialAd = this.a) == null) {
            return;
        }
        gMInterstitialAd.setAdInterstitialListener(this.f2104e);
        this.a.showAd(activity);
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String a() {
        GMInterstitialAd gMInterstitialAd = this.a;
        if (gMInterstitialAd != null) {
            return gMInterstitialAd.getAdNetworkRitId();
        }
        return null;
    }
}
