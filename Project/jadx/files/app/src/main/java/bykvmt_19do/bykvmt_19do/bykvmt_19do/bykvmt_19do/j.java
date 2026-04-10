package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import android.app.Activity;
import android.view.ViewGroup;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardAd;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import java.util.HashMap;

/* JADX INFO: compiled from: TTRewardAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends g {
    private GMRewardAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RewardItem f2111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GMRewardedAdListener f2112f = new b();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private GMRewardedAdListener f2113g = new c();

    /* JADX INFO: compiled from: TTRewardAdLoad.java */
    class a implements GMRewardedAdLoadCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public void onRewardVideoAdLoad() {
            j.this.f2109c = true;
            if (j.this.b == null) {
                return;
            }
            j.this.b.b("onRewardVideoAdLoad", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public void onRewardVideoCached() {
            j.this.f2109c = true;
            if (j.this.b == null) {
                return;
            }
            j.this.b.b("onRewardVideoCached", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public void onRewardVideoLoadFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardVideoLoadFail", adError);
            j.this.f2109c = false;
            if (j.this.b == null) {
                return;
            }
            j.this.b.b("onRewardVideoLoadFail", adError);
        }
    }

    /* JADX INFO: compiled from: TTRewardAdLoad.java */
    class b implements GMRewardedAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardClick", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardClick", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardVerify(RewardItem rewardItem) {
            j.this.f2111e = rewardItem;
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardVerify", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardVerify", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdClosed() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardedAdClosed", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardedAdClosed", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardedAdShow", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardedAdShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShowFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardedAdShowFail", adError);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardedAdShowFail", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onSkippedVideo() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onSkippedVideo", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onSkippedVideo", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoComplete() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onVideoComplete", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onVideoComplete", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoError() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onVideoError", new AdError());
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onVideoError", new AdError());
        }
    }

    /* JADX INFO: compiled from: TTRewardAdLoad.java */
    class c implements GMRewardedAdListener {
        c() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onRewardClick", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardClick-----2", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardVerify(RewardItem rewardItem) {
            j.this.f2111e = rewardItem;
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onVideoComplete", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardVerify-----2", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdClosed() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onRewardedAdClosed", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardedAdClosed-----2", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onRewardedAdShow", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardedAdShow-----2", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onRewardedAdShowFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onVideoError", adError);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onRewardedAdShowFail-----2", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onSkippedVideo() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onSkippedVideo", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onSkippedVideo-----2", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoComplete() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onVideoComplete", j.this.f2110d, j.this.a.getShowEcpm(), j.this.f2111e);
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onVideoComplete-----2", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
        public void onVideoError() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("在看一次 onVideoError", new AdError());
            if (j.this.b == null) {
                return;
            }
            j.this.b.a("onVideoError-----2", new AdError());
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public RewardItem e() {
        return this.f2111e;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2110d;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public boolean g() {
        GMRewardAd gMRewardAd;
        return this.f2109c && (gMRewardAd = this.a) != null && gMRewardAd.isReady();
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public GMAdEcpmInfo c() {
        GMRewardAd gMRewardAd = this.a;
        if (gMRewardAd != null) {
            return gMRewardAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMRewardAd gMRewardAd = this.a;
        if (gMRewardAd != null) {
            return gMRewardAd.getPreEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.b = aVar;
        this.a = new GMRewardAd(activity, eVar.i());
        HashMap map = new HashMap();
        map.put("pangle", "pangle media_extra");
        map.put("gdt", "gdt custom data");
        this.f2110d = eVar.i();
        this.a.loadAd(new GMAdSlotRewardVideo.Builder().setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setMuted(false).setTestSlotId("gm_test_slot_" + eVar.c()).setRewardName("金币").setRewardAmount(3).setUserID("user123").setCustomData(map).setOrientation(i3).build(), new a());
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        GMRewardAd gMRewardAd = this.a;
        if (gMRewardAd != null) {
            gMRewardAd.setRewardAdListener(this.f2112f);
            this.a.setRewardPlayAgainListener(this.f2113g);
            this.a.showRewardAd(activity);
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String a() {
        GMRewardAd gMRewardAd = this.a;
        if (gMRewardAd != null) {
            return gMRewardAd.getAdNetworkRitId();
        }
        return null;
    }
}
