package com.amgcyo.cuttadon.h.d.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAd;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdOptionUtil;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import java.util.HashMap;

/* JADX INFO: compiled from: AdInterstitialFullManager.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: AdInterstitialFullManager.java */
    class a implements GMInterstitialFullAdLoadCallback {
        final /* synthetic */ com.amgcyo.cuttadon.h.f.b a;
        final /* synthetic */ GMInterstitialFullAd b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Activity f3912c;

        a(com.amgcyo.cuttadon.h.f.b bVar, GMInterstitialFullAd gMInterstitialFullAd, Activity activity) {
            this.a = bVar;
            this.b = gMInterstitialFullAd;
            this.f3912c = activity;
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public void onInterstitialFullAdLoad() {
            this.b.showAd(this.f3912c);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public void onInterstitialFullCached() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public void onInterstitialFullLoadFail(@NonNull AdError adError) {
            i.this.a(adError, this.a);
        }
    }

    /* JADX INFO: compiled from: AdInterstitialFullManager.java */
    class b implements GMInterstitialFullAdListener {
        final /* synthetic */ com.amgcyo.cuttadon.h.f.b a;
        final /* synthetic */ GMInterstitialFullAd b;

        b(com.amgcyo.cuttadon.h.f.b bVar, GMInterstitialFullAd gMInterstitialFullAd) {
            this.a = bVar;
            this.b = gMInterstitialFullAd;
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onAdLeftApplication() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onAdOpened() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullClick() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullClosed() {
            this.b.destroy();
            com.amgcyo.cuttadon.h.f.b bVar = this.a;
            if (bVar != null) {
                bVar.goToMainActivity();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullShow() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onInterstitialFullShowFail(@NonNull AdError adError) {
            i.this.a(adError, this.a);
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onRewardVerify(@NonNull RewardItem rewardItem) {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onSkippedVideo() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onVideoComplete() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
        public void onVideoError() {
        }
    }

    public void a(Activity activity, String str, com.amgcyo.cuttadon.h.f.b bVar) {
        GMInterstitialFullAd gMInterstitialFullAd = new GMInterstitialFullAd(activity, str);
        HashMap map = new HashMap();
        map.put("gdt", "gdt custom data");
        gMInterstitialFullAd.loadAd(new GMAdSlotInterstitialFull.Builder().setGMAdSlotBaiduOption(GMAdOptionUtil.getGMAdSlotBaiduOption().build()).setGMAdSlotGDTOption(GMAdOptionUtil.getGMAdSlotGDTOption().build()).setImageAdSize(600, 600).setVolume(0.5f).setUserID("user123").setCustomData(map).setRewardName("金币").setRewardAmount(3).setOrientation(1).setBidNotify(true).build(), new a(bVar, gMInterstitialFullAd, activity));
        gMInterstitialFullAd.setAdInterstitialFullListener(new b(bVar, gMInterstitialFullAd));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull AdError adError, com.amgcyo.cuttadon.h.f.b bVar) {
        int i2 = adError.code;
        String str = adError.message;
        String str2 = "onAdError" + i2 + " msg " + str;
        System.out.println("gromore 插全屏 error " + i2 + str);
        if (bVar != null) {
            bVar.AdError(i2, str, "gm");
        }
    }
}
