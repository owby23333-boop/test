package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.msdk.adapter.util.UIUtils;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAd;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener;
import com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotSplash;

/* JADX INFO: compiled from: TTSplashAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends g {
    private GMSplashAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f2114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    GMSplashAdListener f2115d = new b();

    /* JADX INFO: compiled from: TTSplashAdLoad.java */
    class a implements GMSplashAdLoadCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onAdLoadTimeout() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onSplashAdLoadFail", adError);
            if (k.this.b != null) {
                k.this.b.b("onSplashAdLoadFail", adError);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdLoadCallback
        public void onSplashAdLoadSuccess() {
            if (k.this.b == null) {
                return;
            }
            k.this.b.b("onSplashAdLoadSuccess", null);
        }
    }

    /* JADX INFO: compiled from: TTSplashAdLoad.java */
    class b implements GMSplashAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdClicked() {
            if (k.this.b == null) {
                return;
            }
            k.this.b.a("onAdClicked", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdDismiss() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdDismiss", k.this.f2114c, k.this.a.getShowEcpm(), null);
            if (k.this.b == null) {
                return;
            }
            k.this.b.a("onAdDismiss", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShow() {
            if (k.this.b == null) {
                return;
            }
            k.this.b.a("onAdShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdShowFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdShowFail", adError);
            if (k.this.b == null) {
                return;
            }
            k.this.b.a("onAdShowFail", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.splash.GMSplashAdListener
        public void onAdSkip() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdSkip", k.this.f2114c, k.this.a.getShowEcpm(), null);
            if (k.this.b == null) {
                return;
            }
            k.this.b.a("onAdSkip", null);
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMSplashAd gMSplashAd = this.a;
        if (gMSplashAd != null) {
            return gMSplashAd.getPreEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2114c;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.b = aVar;
        this.f2114c = eVar.i();
        this.a = new GMSplashAd(activity, eVar.i());
        this.a.setAdSplashListener(this.f2115d);
        this.a.loadAd(new GMAdSlotSplash.Builder().setTestSlotId("gm_test_slot_" + eVar.c()).setImageAdSize(UIUtils.getScreenWidth(activity), UIUtils.getScreenHeight(activity)).setTimeOut(3000).setSplashButtonType(2).setDownloadType(1).setSplashShakeButton(true).build(), null, new a());
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void b(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        a(activity, eVar, i2, i3, aVar);
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public GMAdEcpmInfo c() {
        GMSplashAd gMSplashAd = this.a;
        if (gMSplashAd != null) {
            return gMSplashAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        GMSplashAd gMSplashAd = this.a;
        if (gMSplashAd != null) {
            gMSplashAd.showAd(viewGroup);
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String a() {
        GMSplashAd gMSplashAd = this.a;
        if (gMSplashAd != null) {
            return gMSplashAd.getAdNetworkRitId();
        }
        return null;
    }
}
