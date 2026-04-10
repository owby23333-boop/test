package com.anythink.network.mobrain;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter;
import com.anythink.interstitial.unitgroup.api.CustomInterstitialEventListener;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAd;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener;
import com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAd;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener;
import com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAd;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener;
import com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotFullVideo;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitial;
import com.bytedance.msdk.api.v2.slot.GMAdSlotInterstitialFull;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATInterstitialAdapter extends CustomInterstitialAdapter {
    MobrainConfig a;
    private GMFullVideoAd b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private GMInterstitialAd f12553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private GMInterstitialFullAd f12554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f12556f;

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATInterstitialAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements GMFullVideoAdLoadCallback {
        AnonymousClass1() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback
        public final void onFullVideoAdLoad() {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback
        public final void onFullVideoCached() {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdLoadCallback
        public final void onFullVideoLoadFail(AdError adError) {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdLoadError(String.valueOf(adError.code), "Gromore: " + adError.toString());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATInterstitialAdapter$2, reason: invalid class name */
    final class AnonymousClass2 implements GMInterstitialAdLoadCallback {
        AnonymousClass2() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback
        public final void onInterstitialLoad() {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdLoadCallback
        public final void onInterstitialLoadFail(AdError adError) {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdLoadError(String.valueOf(adError.code), "Gromore: " + adError.toString());
            }
        }
    }

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATInterstitialAdapter$3, reason: invalid class name */
    final class AnonymousClass3 implements GMInterstitialFullAdLoadCallback {
        AnonymousClass3() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public final void onInterstitialFullAdLoad() {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public final void onInterstitialFullCached() {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdLoadCallback
        public final void onInterstitialFullLoadFail(@NonNull AdError adError) {
            if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdLoadError(String.valueOf(adError.code), "Gromore: " + adError.toString());
            }
        }
    }

    static /* synthetic */ int F(MobrainATInterstitialAdapter mobrainATInterstitialAdapter) {
        mobrainATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ int J(MobrainATInterstitialAdapter mobrainATInterstitialAdapter) {
        mobrainATInterstitialAdapter.mDismissType = 99;
        return 99;
    }

    static /* synthetic */ int S(MobrainATInterstitialAdapter mobrainATInterstitialAdapter) {
        mobrainATInterstitialAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        GMFullVideoAd gMFullVideoAd = this.b;
        if (gMFullVideoAd != null) {
            gMFullVideoAd.destroy();
            this.b = null;
        }
        GMInterstitialAd gMInterstitialAd = this.f12553c;
        if (gMInterstitialAd != null) {
            gMInterstitialAd.destroy();
            this.f12553c = null;
        }
        GMInterstitialFullAd gMInterstitialFullAd = this.f12554d;
        if (gMInterstitialFullAd != null) {
            gMInterstitialFullAd.destroy();
            this.f12554d = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12556f;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return MobrainATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12555e;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return MobrainATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        GMInterstitialFullAd gMInterstitialFullAd = this.f12554d;
        if (gMInterstitialFullAd != null) {
            return gMInterstitialFullAd.isReady();
        }
        GMFullVideoAd gMFullVideoAd = this.b;
        if (gMFullVideoAd != null) {
            return gMFullVideoAd.isReady();
        }
        GMInterstitialAd gMInterstitialAd = this.f12553c;
        if (gMInterstitialAd != null) {
            return gMInterstitialAd.isReady();
        }
        return false;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        String[] strArrSplit;
        if (!(context instanceof Activity)) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "Gromore: context must be activity");
                return;
            }
            return;
        }
        String str = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str)) {
            ATCustomLoadListener aTCustomLoadListener2 = this.mLoadListener;
            if (aTCustomLoadListener2 != null) {
                aTCustomLoadListener2.onAdLoadError("", "Gromore: pl_id is empty");
                return;
            }
            return;
        }
        this.f12555e = str;
        this.a = new MobrainConfig(context, 1);
        this.a.a(map);
        MobrainConfig mobrainConfig = this.a;
        String string = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
        String string2 = map2.get(ATAdConst.KEY.AD_WIDTH) != null ? map2.get(ATAdConst.KEY.AD_WIDTH).toString() : "";
        mobrainConfig.mHeight = 0;
        try {
            if (!TextUtils.isEmpty(string2)) {
                mobrainConfig.mWidth = Integer.parseInt(string2);
            }
        } catch (Throwable unused) {
        }
        try {
            if (!TextUtils.isEmpty(mobrainConfig.mRatio) && (strArrSplit = mobrainConfig.mRatio.split(":")) != null && strArrSplit.length == 2) {
                mobrainConfig.mHeight = (mobrainConfig.mWidth / Integer.parseInt(strArrSplit[0])) * Integer.parseInt(strArrSplit[1]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (!TextUtils.isEmpty(string)) {
            mobrainConfig.mUserId = string;
        }
        try {
            if (map2.containsKey(ATAdConst.KEY.AD_SOUND)) {
                mobrainConfig.f12575f = Integer.parseInt(map2.get(ATAdConst.KEY.AD_SOUND).toString());
            }
        } catch (Throwable unused2) {
        }
        MobrainATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.mobrain.MobrainATInterstitialAdapter.4
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str2) {
                if (((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MobrainATInterstitialAdapter.this).mLoadListener.onAdLoadError("", "Gromore: ".concat(String.valueOf(str2)));
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                MobrainATInterstitialAdapter.a(MobrainATInterstitialAdapter.this, (Activity) context);
            }
        });
    }

    @Override // com.anythink.interstitial.unitgroup.api.CustomInterstitialAdapter
    public void show(Activity activity) {
        if (isAdReady()) {
            GMInterstitialFullAd gMInterstitialFullAd = this.f12554d;
            if (gMInterstitialFullAd != null) {
                gMInterstitialFullAd.setAdInterstitialFullListener(new GMInterstitialFullAdListener() { // from class: com.anythink.network.mobrain.MobrainATInterstitialAdapter.5
                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onAdLeftApplication() {
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onAdOpened() {
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onInterstitialFullClick() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onInterstitialFullClosed() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onInterstitialFullShow() {
                        MobrainATInterstitialAdapter mobrainATInterstitialAdapter = MobrainATInterstitialAdapter.this;
                        mobrainATInterstitialAdapter.f12556f = MobrainATConst.a(mobrainATInterstitialAdapter.f12554d);
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onInterstitialFullShowFail(@NonNull AdError adError) {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            CustomInterstitialEventListener customInterstitialEventListener = ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener;
                            StringBuilder sb = new StringBuilder();
                            sb.append(adError.code);
                            customInterstitialEventListener.onInterstitialAdVideoError(sb.toString(), "Gromore: " + adError.toString());
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onRewardVerify(@NonNull RewardItem rewardItem) {
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onSkippedVideo() {
                        MobrainATInterstitialAdapter.F(MobrainATInterstitialAdapter.this);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onVideoComplete() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitialFull.GMInterstitialFullAdListener
                    public final void onVideoError() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError("", "Gromore: callback onVideoError()");
                        }
                    }
                });
                this.f12554d.showAd(activity);
            }
            GMFullVideoAd gMFullVideoAd = this.b;
            if (gMFullVideoAd != null) {
                gMFullVideoAd.setFullVideoAdListener(new GMFullVideoAdListener() { // from class: com.anythink.network.mobrain.MobrainATInterstitialAdapter.6
                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onFullVideoAdClick() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onFullVideoAdClosed() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onFullVideoAdShow() {
                        MobrainATInterstitialAdapter mobrainATInterstitialAdapter = MobrainATInterstitialAdapter.this;
                        mobrainATInterstitialAdapter.f12556f = MobrainATConst.a(mobrainATInterstitialAdapter.b);
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onFullVideoAdShowFail(AdError adError) {
                        MobrainATInterstitialAdapter.J(MobrainATInterstitialAdapter.this);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onRewardVerify(RewardItem rewardItem) {
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onSkippedVideo() {
                        MobrainATInterstitialAdapter.S(MobrainATInterstitialAdapter.this);
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onVideoComplete() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoEnd();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.fullvideo.GMFullVideoAdListener
                    public final void onVideoError() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdVideoError("", "Gromore: callback onVideoError()");
                        }
                    }
                });
                this.b.showFullAd(activity);
            }
            GMInterstitialAd gMInterstitialAd = this.f12553c;
            if (gMInterstitialAd != null) {
                gMInterstitialAd.setAdInterstitialListener(new GMInterstitialAdListener() { // from class: com.anythink.network.mobrain.MobrainATInterstitialAdapter.7
                    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
                    public final void onAdLeftApplication() {
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
                    public final void onAdOpened() {
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
                    public final void onInterstitialAdClick() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdClicked();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
                    public final void onInterstitialClosed() {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdClose();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
                    public final void onInterstitialShow() {
                        MobrainATInterstitialAdapter mobrainATInterstitialAdapter = MobrainATInterstitialAdapter.this;
                        mobrainATInterstitialAdapter.f12556f = MobrainATConst.a(mobrainATInterstitialAdapter.f12553c);
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener.onInterstitialAdShow();
                        }
                    }

                    @Override // com.bytedance.msdk.api.v2.ad.interstitial.GMInterstitialAdListener
                    public final void onInterstitialShowFail(AdError adError) {
                        if (((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener != null) {
                            CustomInterstitialEventListener customInterstitialEventListener = ((CustomInterstitialAdapter) MobrainATInterstitialAdapter.this).mImpressListener;
                            StringBuilder sb = new StringBuilder();
                            sb.append(adError.code);
                            customInterstitialEventListener.onInterstitialAdVideoError(sb.toString(), "Gromore: " + adError.toString());
                        }
                    }
                });
                this.f12553c.showAd(activity);
            }
        }
    }

    private void b(Activity activity) {
        this.b = new GMFullVideoAd(activity, this.f12555e);
        this.b.loadAd(new GMAdSlotFullVideo.Builder().setUserID(this.a.mUserId).setMuted(this.a.f12575f == 0).setOrientation(this.a.mOrientation).build(), new AnonymousClass1());
    }

    private void c(Activity activity) {
        this.f12553c = new GMInterstitialAd(activity, this.f12555e);
        GMAdSlotInterstitial.Builder imageAdSize = new GMAdSlotInterstitial.Builder().setMuted(this.a.f12575f == 0).setImageAdSize(a(activity, this.a.mWidth), a(activity, this.a.mHeight));
        int i2 = this.a.mDownloadType;
        if (i2 != -1) {
            imageAdSize.setDownloadType(i2);
        }
        this.f12553c.loadAd(imageAdSize.build(), new AnonymousClass2());
    }

    private void d(Activity activity) {
        this.f12554d = new GMInterstitialFullAd(activity, this.f12555e);
        GMAdSlotInterstitialFull.Builder orientation = new GMAdSlotInterstitialFull.Builder().setMuted(this.a.f12575f == 0).setImageAdSize(a(activity, this.a.mWidth), a(activity, this.a.mHeight)).setUserID(this.a.mUserId).setOrientation(this.a.mOrientation);
        int i2 = this.a.mDownloadType;
        if (i2 != -1) {
            orientation.setDownloadType(i2);
        }
        this.f12554d.loadAd(orientation.build(), new AnonymousClass3());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.app.Activity r7) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.mobrain.MobrainATInterstitialAdapter.a(android.app.Activity):void");
    }

    private static int a(Context context, float f2) {
        float f3 = context.getResources().getDisplayMetrics().density;
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ void a(com.anythink.network.mobrain.MobrainATInterstitialAdapter r6, android.app.Activity r7) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.network.mobrain.MobrainATInterstitialAdapter.a(com.anythink.network.mobrain.MobrainATInterstitialAdapter, android.app.Activity):void");
    }
}
