package bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.GMAdEcpmInfo;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAd;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import java.util.HashMap;

/* JADX INFO: compiled from: TTFullAdLoad.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends g {
    private GMFullVideoAd a;
    private bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f2094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f2095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RewardItem f2096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private GMFullVideoAdListener f2097f = new b();

    /* JADX INFO: compiled from: TTFullAdLoad.java */
    class a implements GMFullVideoAdLoadCallback {
        a() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback
        public void onFullVideoAdLoad() {
            f.this.f2094c = true;
            if (f.this.b == null) {
                return;
            }
            f.this.b.b("onFullVideoAdLoad", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback
        public void onFullVideoCached() {
            f.this.f2094c = true;
            if (f.this.b == null) {
                return;
            }
            f.this.b.b("onFullVideoCached", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback
        public void onFullVideoLoadFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onFullVideoLoadFail", adError);
            f.this.f2094c = false;
            if (f.this.b == null) {
                return;
            }
            f.this.b.b("onFullVideoLoadFail", adError);
        }
    }

    /* JADX INFO: compiled from: TTFullAdLoad.java */
    class b implements GMFullVideoAdListener {
        b() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdClick() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onFullVideoAdClick", f.this.f2095d, f.this.a.getShowEcpm(), f.this.f2096e);
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onFullVideoAdClick", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdClosed() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onFullVideoAdClosed", f.this.f2095d, f.this.a.getShowEcpm(), f.this.f2096e);
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onFullVideoAdClosed", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdShow() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onFullVideoAdShow", f.this.f2095d, f.this.a.getShowEcpm(), f.this.f2096e);
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onFullVideoAdShow", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onFullVideoAdShowFail(AdError adError) {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onFullVideoAdShowFail", adError);
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onFullVideoAdShowFail", adError);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
            f.this.f2096e = rewardItem;
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onRewardVerify", f.this.f2095d, f.this.a.getShowEcpm(), f.this.f2096e);
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onRewardVerify", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onSkippedVideo() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onSkippedVideo", f.this.f2095d, f.this.a.getShowEcpm(), f.this.f2096e);
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onSkippedVideo", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onVideoComplete() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onVideoComplete", f.this.f2095d, f.this.a.getShowEcpm(), f.this.f2096e);
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onVideoComplete", null);
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
        public void onVideoError() {
            bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.b.a("onVideoError", new AdError());
            if (f.this.b == null) {
                return;
            }
            f.this.b.a("onVideoError", new AdError());
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public RewardItem e() {
        return this.f2096e;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String f() {
        return this.f2095d;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public boolean g() {
        GMFullVideoAd gMFullVideoAd;
        return this.f2094c && (gMFullVideoAd = this.a) != null && gMFullVideoAd.isReady();
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public GMAdEcpmInfo c() {
        GMFullVideoAd gMFullVideoAd = this.a;
        if (gMFullVideoAd != null) {
            return gMFullVideoAd.getShowEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String d() {
        GMFullVideoAd gMFullVideoAd = this.a;
        if (gMFullVideoAd != null) {
            return gMFullVideoAd.getPreEcpm();
        }
        return null;
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_int108.e eVar, int i2, int i3, bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.a aVar) {
        this.b = aVar;
        this.a = new GMFullVideoAd(activity, eVar.i());
        HashMap map = new HashMap();
        map.put("gdt", "gdt custom data");
        this.f2095d = eVar.i();
        this.a.loadAd(new GMAdSlotFullVideo.Builder().setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setUserID("user123").setTestSlotId("gm_test_slot_" + eVar.c()).setOrientation(i3).setRewardName("金币").setRewardAmount(3).setCustomData(map).build(), new a());
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public void a(Activity activity, ViewGroup viewGroup) {
        GMFullVideoAd gMFullVideoAd;
        if (this.f2094c && (gMFullVideoAd = this.a) != null && gMFullVideoAd.isReady()) {
            this.a.setFullVideoAdListener(this.f2097f);
            this.a.showFullAd(activity);
        }
    }

    @Override // bykvmt_19do.bykvmt_19do.bykvmt_19do.bykvmt_19do.g
    public String a() {
        GMFullVideoAd gMFullVideoAd = this.a;
        if (gMFullVideoAd != null) {
            return gMFullVideoAd.getAdNetworkRitId();
        }
        return null;
    }
}
