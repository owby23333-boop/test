package com.anythink.network.mobrain;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.MediationInitCallback;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter;
import com.anythink.rewardvideo.unitgroup.api.CustomRewardedVideoEventListener;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardAd;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class MobrainATRewardedVideoAdapter extends CustomRewardVideoAdapter {
    private GMRewardAd a;
    private boolean b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MobrainConfig f12563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Object> f12564e;

    /* JADX INFO: renamed from: com.anythink.network.mobrain.MobrainATRewardedVideoAdapter$1, reason: invalid class name */
    final class AnonymousClass1 implements GMRewardedAdLoadCallback {
        AnonymousClass1() {
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public final void onRewardVideoAdLoad() {
            if (((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener.onAdDataLoaded();
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public final void onRewardVideoCached() {
            if (((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener.onAdCacheLoaded(new BaseAd[0]);
            }
        }

        @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdLoadCallback
        public final void onRewardVideoLoadFail(AdError adError) {
            if (((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener != null) {
                ((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener.onAdLoadError(String.valueOf(adError.code), adError.toString());
            }
        }
    }

    static /* synthetic */ int O(MobrainATRewardedVideoAdapter mobrainATRewardedVideoAdapter) {
        mobrainATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    static /* synthetic */ boolean x(MobrainATRewardedVideoAdapter mobrainATRewardedVideoAdapter) {
        mobrainATRewardedVideoAdapter.b = true;
        return true;
    }

    static /* synthetic */ int z(MobrainATRewardedVideoAdapter mobrainATRewardedVideoAdapter) {
        mobrainATRewardedVideoAdapter.mDismissType = 2;
        return 2;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        GMRewardAd gMRewardAd = this.a;
        if (gMRewardAd != null) {
            gMRewardAd.destroy();
            this.a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public Map<String, Object> getNetworkInfoMap() {
        return this.f12564e;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return MobrainATInitManager.getInstance().getNetworkName();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f12562c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return MobrainATInitManager.getInstance().getNetworkVersion();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean isAdReady() {
        GMRewardAd gMRewardAd = this.a;
        return gMRewardAd != null && gMRewardAd.isReady();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(final Context context, Map<String, Object> map, Map<String, Object> map2) {
        String str = (String) map.get("slot_id");
        if (TextUtils.isEmpty(str)) {
            ATCustomLoadListener aTCustomLoadListener = this.mLoadListener;
            if (aTCustomLoadListener != null) {
                aTCustomLoadListener.onAdLoadError("", "Gromore: pl_id is empty!");
                return;
            }
            return;
        }
        this.f12562c = str;
        this.f12563d = new MobrainConfig(context, 1);
        this.f12563d.a(map);
        MobrainConfig mobrainConfig = this.f12563d;
        String string = map2.get("reward_name") != null ? map2.get("reward_name").toString() : "";
        String string2 = map2.get("reward_amount") != null ? map2.get("reward_amount").toString() : "";
        String string3 = map2.get("user_id") != null ? map2.get("user_id").toString() : "";
        String string4 = map2.get(ATAdConst.KEY.USER_CUSTOM_DATA) != null ? map2.get(ATAdConst.KEY.USER_CUSTOM_DATA).toString() : "";
        if (!TextUtils.isEmpty(string)) {
            mobrainConfig.mRewardName = string;
        }
        try {
            if (!TextUtils.isEmpty(string2)) {
                mobrainConfig.mRewardAmount = Integer.parseInt(string2);
            }
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(string3)) {
            mobrainConfig.mUserId = string3;
        }
        if (!TextUtils.isEmpty(string4)) {
            mobrainConfig.mUserData = string4;
        }
        try {
            if (map2.containsKey(ATAdConst.KEY.AD_SOUND)) {
                mobrainConfig.f12575f = Integer.parseInt(map2.get(ATAdConst.KEY.AD_SOUND).toString());
            }
        } catch (Throwable unused2) {
        }
        MobrainATInitManager.getInstance().initSDK(context, map, new MediationInitCallback() { // from class: com.anythink.network.mobrain.MobrainATRewardedVideoAdapter.2
            @Override // com.anythink.core.api.MediationInitCallback
            public final void onFail(String str2) {
                if (((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener != null) {
                    ((ATBaseAdAdapter) MobrainATRewardedVideoAdapter.this).mLoadListener.onAdLoadError("", "Gromore: ".concat(String.valueOf(str2)));
                }
            }

            @Override // com.anythink.core.api.MediationInitCallback
            public final void onSuccess() {
                MobrainATRewardedVideoAdapter.a(MobrainATRewardedVideoAdapter.this, context);
            }
        });
    }

    @Override // com.anythink.rewardvideo.unitgroup.api.CustomRewardVideoAdapter
    public void show(Activity activity) {
        if (isAdReady()) {
            this.a.setRewardAdListener(new GMRewardedAdListener() { // from class: com.anythink.network.mobrain.MobrainATRewardedVideoAdapter.3
                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardClick() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayClicked();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardVerify(RewardItem rewardItem) {
                    if (MobrainATRewardedVideoAdapter.this.b || ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener == null) {
                        return;
                    }
                    MobrainATRewardedVideoAdapter.x(MobrainATRewardedVideoAdapter.this);
                    ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onReward();
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardedAdClosed() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardedAdShow() {
                    MobrainATRewardedVideoAdapter mobrainATRewardedVideoAdapter = MobrainATRewardedVideoAdapter.this;
                    mobrainATRewardedVideoAdapter.f12564e = MobrainATConst.a(mobrainATRewardedVideoAdapter.a);
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayStart();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardedAdShowFail(AdError adError) {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        CustomRewardedVideoEventListener customRewardedVideoEventListener = ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(adError.code);
                        customRewardedVideoEventListener.onRewardedVideoAdPlayFailed(sb.toString(), "Gromore: " + adError.toString());
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onSkippedVideo() {
                    MobrainATRewardedVideoAdapter.z(MobrainATRewardedVideoAdapter.this);
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onVideoComplete() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayEnd();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onVideoError() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdPlayFailed("", "Gromore: callback onVideoError()");
                    }
                }
            });
            this.a.setRewardPlayAgainListener(new GMRewardedAdListener() { // from class: com.anythink.network.mobrain.MobrainATRewardedVideoAdapter.4
                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardClick() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayClicked();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardVerify(RewardItem rewardItem) {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onAgainReward();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardedAdClosed() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdClosed();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardedAdShow() {
                    MobrainATRewardedVideoAdapter mobrainATRewardedVideoAdapter = MobrainATRewardedVideoAdapter.this;
                    mobrainATRewardedVideoAdapter.f12564e = MobrainATConst.a(mobrainATRewardedVideoAdapter.a);
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayStart();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onRewardedAdShowFail(AdError adError) {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        CustomRewardedVideoEventListener customRewardedVideoEventListener = ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener;
                        StringBuilder sb = new StringBuilder();
                        sb.append(adError.code);
                        customRewardedVideoEventListener.onRewardedVideoAdAgainPlayFailed(sb.toString(), adError.toString());
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onSkippedVideo() {
                    MobrainATRewardedVideoAdapter.O(MobrainATRewardedVideoAdapter.this);
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onVideoComplete() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayEnd();
                    }
                }

                @Override // com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener
                public final void onVideoError() {
                    if (((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener != null) {
                        ((CustomRewardVideoAdapter) MobrainATRewardedVideoAdapter.this).mImpressionListener.onRewardedVideoAdAgainPlayFailed("", "GM:onVideoError");
                    }
                }
            });
            this.a.showRewardAd(activity);
        }
    }

    private void a(Context context) {
        if (!(context instanceof Activity)) {
            this.mLoadListener.onAdLoadError("", "must set context instanceof Activity in MobrainATRewardedVideoAdapter");
            return;
        }
        this.a = new GMRewardAd((Activity) context, this.f12562c);
        HashMap map = new HashMap();
        map.put("pangle", this.mUserData);
        map.put("baidu", this.mUserData);
        map.put("gdt", this.mUserData);
        map.put("sigmob", this.mUserData);
        map.put("mintegral", this.mUserData);
        map.put("ks", this.mUserData);
        GMAdSlotRewardVideo.Builder orientation = new GMAdSlotRewardVideo.Builder().setRewardName(this.f12563d.mRewardName).setRewardAmount(this.f12563d.mRewardAmount).setUserID(this.f12563d.mUserId).setCustomData(map).setMuted(this.f12563d.f12575f == 0).setOrientation(this.f12563d.mOrientation);
        int i2 = this.f12563d.mDownloadType;
        if (i2 != -1) {
            orientation.setDownloadType(i2);
        }
        this.a.loadAd(orientation.build(), new AnonymousClass1());
    }

    static /* synthetic */ void a(MobrainATRewardedVideoAdapter mobrainATRewardedVideoAdapter, Context context) {
        if (!(context instanceof Activity)) {
            mobrainATRewardedVideoAdapter.mLoadListener.onAdLoadError("", "must set context instanceof Activity in MobrainATRewardedVideoAdapter");
            return;
        }
        mobrainATRewardedVideoAdapter.a = new GMRewardAd((Activity) context, mobrainATRewardedVideoAdapter.f12562c);
        HashMap map = new HashMap();
        map.put("pangle", mobrainATRewardedVideoAdapter.mUserData);
        map.put("baidu", mobrainATRewardedVideoAdapter.mUserData);
        map.put("gdt", mobrainATRewardedVideoAdapter.mUserData);
        map.put("sigmob", mobrainATRewardedVideoAdapter.mUserData);
        map.put("mintegral", mobrainATRewardedVideoAdapter.mUserData);
        map.put("ks", mobrainATRewardedVideoAdapter.mUserData);
        GMAdSlotRewardVideo.Builder orientation = new GMAdSlotRewardVideo.Builder().setRewardName(mobrainATRewardedVideoAdapter.f12563d.mRewardName).setRewardAmount(mobrainATRewardedVideoAdapter.f12563d.mRewardAmount).setUserID(mobrainATRewardedVideoAdapter.f12563d.mUserId).setCustomData(map).setMuted(mobrainATRewardedVideoAdapter.f12563d.f12575f == 0).setOrientation(mobrainATRewardedVideoAdapter.f12563d.mOrientation);
        int i2 = mobrainATRewardedVideoAdapter.f12563d.mDownloadType;
        if (i2 != -1) {
            orientation.setDownloadType(i2);
        }
        mobrainATRewardedVideoAdapter.a.loadAd(orientation.build(), mobrainATRewardedVideoAdapter.new AnonymousClass1());
    }
}
