package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAd;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import java.util.HashMap;

/* JADX INFO: compiled from: TTInterFullAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends g {
    private GMInterstitialFullAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RewardItem f2107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    GMInterstitialFullAdListener f2108f = new b();

    /* JADX INFO: compiled from: TTInterFullAdLoad.java */
    class a implements GMInterstitialFullAdLoadCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public void onInterstitialFullAdLoad() {
            i.this.f2105c = true;
            if (i.this.b == null) {
                return;
            }
            i.this.b.b("onInterstitialFullAdLoad", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public void onInterstitialFullCached() {
            i.this.f2105c = true;
            if (i.this.b == null) {
                return;
            }
            i.this.b.b("onInterstitialFullCached", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public void onInterstitialFullLoadFail(@NonNull AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialFullLoadFail", adError);
            i.this.f2105c = false;
            if (i.this.b == null) {
                return;
            }
            i.this.b.b("onInterstitialFullLoadFail", adError);
        }
    }

    /* JADX INFO: compiled from: TTInterFullAdLoad.java */
    class b implements GMInterstitialFullAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onAdLeftApplication() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdLeftApplication", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onAdLeftApplication", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onAdOpened() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onAdOpened", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onAdOpened", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialFullClick", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onInterstitialFullClick", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullClosed() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialFullClosed", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onInterstitialFullClosed", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialFullShow", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onInterstitialFullShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullShowFail(@NonNull AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialFullShowFail", adError);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onInterstitialFullShowFail", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
            i.this.f2107e = rewardItem;
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardVerify", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onRewardVerify", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onSkippedVideo() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onSkippedVideo", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onSkippedVideo", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onVideoComplete() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onVideoComplete", i.this.f2106d, i.this.a.getShowEcpm(), i.this.f2107e);
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onVideoComplete", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onVideoError() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onInterstitialFullShowFail", new AdError());
            if (i.this.b == null) {
                return;
            }
            i.this.b.a("onVideoError", new AdError());
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public RewardItem e() {
        return this.f2107e;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2106d;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public GMAdEcpmInfo c() {
        GMInterstitialFullAd gMInterstitialFullAd = this.a;
        if (gMInterstitialFullAd != null) {
            return gMInterstitialFullAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMInterstitialFullAd gMInterstitialFullAd = this.a;
        if (gMInterstitialFullAd != null) {
            return gMInterstitialFullAd.getPreEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.b = aVar;
        this.a = new GMInterstitialFullAd(activity, eVar.i());
        this.a.setAdInterstitialFullListener(this.f2108f);
        HashMap map = new HashMap();
        map.put("gdt", "gdt custom data");
        this.f2106d = eVar.i();
        this.a.loadAd(new GMAdSlotInterstitialFull.Builder().setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setImageAdSize(600, 600).setTestSlotId("gm_test_slot_" + eVar.c()).setVolume(0.5f).setUserID("user123").setOrientation(2).setRewardName("金币").setRewardAmount(3).setCustomData(map).build(), new a());
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        GMInterstitialFullAd gMInterstitialFullAd;
        if (!this.f2105c || (gMInterstitialFullAd = this.a) == null) {
            return;
        }
        gMInterstitialFullAd.setAdInterstitialFullListener(this.f2108f);
        this.a.showAd(activity);
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String a() {
        GMInterstitialFullAd gMInterstitialFullAd = this.a;
        if (gMInterstitialFullAd != null) {
            return gMInterstitialFullAd.getAdNetworkRitId();
        }
        return null;
    }
}
