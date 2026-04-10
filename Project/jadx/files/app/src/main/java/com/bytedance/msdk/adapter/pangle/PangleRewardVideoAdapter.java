package com.bytedance.msdk.adapter.pangle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter;
import com.bytedance.msdk.adapter.ad.GMRewardBaseAdapter;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.AdError;
import com.bytedance.msdk.api.TTAdConstant;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMAdConstant;
import com.bytedance.msdk.api.v2.ad.reward.GMRewardedAdListener;
import com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo;
import com.bytedance.msdk.base.TTBaseAd;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class PangleRewardVideoAdapter extends GMRewardBaseAdapter {
    public static final String TAG = "PgRewardVideoAdapter";
    public static final String VERSION_00 = "0.0";
    public static final String VERSION_4400 = "4.4.0.0";
    private PangleRewardVideo a;
    private Context b;

    class PangleRewardVideo extends TTBaseAd {
        private TTRewardVideoAd a;
        private boolean b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f13985c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        TTAdNative.RewardVideoAdListener f13986d = new AnonymousClass1();

        /* JADX INFO: renamed from: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter$PangleRewardVideo$1, reason: invalid class name */
        class AnonymousClass1 implements TTAdNative.RewardVideoAdListener {
            AnonymousClass1() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.common.CommonListener
            public void onError(int i2, String str) {
                Logger.e("TTMediationSDK", "pangle_reward_onError code:" + i2 + "  message:" + str);
                PangleRewardVideo.this.b = false;
                PangleRewardVideoAdapter.this.notifyAdFailed(new AdError(i2, str));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoAdLoad");
                if (tTRewardVideoAd == null) {
                    PangleRewardVideoAdapter.this.notifyAdFailed(new AdError(AdError.ERROR_MEDIA_REQUEST_SUCCESS_NO_ADS_MSG));
                    return;
                }
                PangleRewardVideo.this.a = tTRewardVideoAd;
                PangleRewardVideo.this.setExpressAd(true);
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                pangleRewardVideo.setInteractionType(pangleRewardVideo.a.getInteractionType());
                Map<String, Object> mediaExtraInfo = PangleRewardVideo.this.a.getMediaExtraInfo();
                if (PangleRewardVideoAdapter.this.isClientBidding() && mediaExtraInfo != null) {
                    double value = PangleAdapterUtils.getValue(mediaExtraInfo.get("price"));
                    Logger.d("TTMediationSDK_ECMP", TTLogUtil.getTagThirdLevelById(PangleRewardVideoAdapter.this.getAdapterRit(), PangleRewardVideoAdapter.this.getAdSlotId()) + "pangle reward 返回的 cpm价格：" + value);
                    PangleRewardVideo pangleRewardVideo2 = PangleRewardVideo.this;
                    if (value <= PangleAdapterUtils.CPM_DEFLAUT_VALUE) {
                        value = 0.0d;
                    }
                    pangleRewardVideo2.setCpm(value);
                }
                if (mediaExtraInfo != null) {
                    Object obj = mediaExtraInfo.get("materialMetaIsFromPreload");
                    if (obj instanceof Boolean) {
                        PangleRewardVideo.this.f13985c = ((Boolean) obj).booleanValue();
                        Logger.d("TTMediationSDK", "pangle 激励 返回的adnPreload：" + PangleRewardVideo.this.f13985c);
                    }
                }
                PangleRewardVideo.this.b = true;
                PangleRewardVideo.this.a.setRewardPlayAgainInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdClose-----------2");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.b().onRewardedAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdShow-----------2");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.b().onRewardedAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdVideoBarClick---------2");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.b().onRewardClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(final boolean z2, final int i2, final Bundle bundle) {
                        if (PangleRewardVideo.this.d()) {
                            return;
                        }
                        Logger.e("TTMediationSDK", "pangle_reward:onRewardArrived-------------2");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.b().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1.2
                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public float getAmount() {
                                    float f2 = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                    if (f2 >= 0.0f) {
                                        return f2;
                                    }
                                    if (PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo != null) {
                                        return r0.getRewardAmount();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public Map<String, Object> getCustomData() {
                                    HashMap map = new HashMap();
                                    map.put(RewardItem.KEY_EXTRA_INFO, bundle);
                                    map.put(RewardItem.KEY_REWARD_TYPE, Integer.valueOf(i2));
                                    return map;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public String getRewardName() {
                                    Bundle bundle2 = bundle;
                                    String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                    if (!TextUtils.isEmpty(string)) {
                                        return string;
                                    }
                                    GMAdSlotRewardVideo gMAdSlotRewardVideo = PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                                    return gMAdSlotRewardVideo != null ? gMAdSlotRewardVideo.getRewardName() : "";
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public boolean rewardVerify() {
                                    return z2;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    @Deprecated
                    public void onRewardVerify(final boolean z2, final int i2, final String str, int i3, String str2) {
                        if (PangleRewardVideo.this.d()) {
                            Logger.e("TTMediationSDK", "pangle_reward:onRewardVerify-------------2");
                            if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                                PangleRewardVideo.this.b().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.1.1
                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public float getAmount() {
                                        int i4 = i2;
                                        if (i4 >= 0) {
                                            return i4;
                                        }
                                        if (((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot != null) {
                                            return ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardAmount();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public Map<String, Object> getCustomData() {
                                        return null;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public String getRewardName() {
                                        return !TextUtils.isEmpty(str) ? str : ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot != null ? ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardName() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public boolean rewardVerify() {
                                        return z2;
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Logger.e("TTMediationSDK", "pangle_reward:onSkippedVideo-------------2");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.b().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoComplete----------2");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.b().onVideoComplete();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoError-----------2");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperRewardPlayAgainCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.b().onVideoError();
                        }
                    }
                });
                PangleRewardVideo.this.a.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.2
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdClose");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardedAdClosed();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdShow");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardedAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        Logger.e("TTMediationSDK", "pangle_reward:onAdVideoBarClick");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardClick();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(final boolean z2, final int i2, final Bundle bundle) {
                        if (PangleRewardVideo.this.d()) {
                            return;
                        }
                        Logger.e("TTMediationSDK", "pangle_reward:onRewardArrived");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.2.2
                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public float getAmount() {
                                    float f2 = bundle != null ? r0.getInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT) : 0.0f;
                                    if (f2 >= 0.0f) {
                                        return f2;
                                    }
                                    if (PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo != null) {
                                        return r0.getRewardAmount();
                                    }
                                    return 0.0f;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public Map<String, Object> getCustomData() {
                                    HashMap map = new HashMap();
                                    map.put(RewardItem.KEY_EXTRA_INFO, bundle);
                                    map.put(RewardItem.KEY_REWARD_TYPE, Integer.valueOf(i2));
                                    return map;
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public String getRewardName() {
                                    Bundle bundle2 = bundle;
                                    String string = bundle2 != null ? bundle2.getString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME) : "";
                                    if (!TextUtils.isEmpty(string)) {
                                        return string;
                                    }
                                    GMAdSlotRewardVideo gMAdSlotRewardVideo = PangleRewardVideoAdapter.this.mGMAdSlotRewardVideo;
                                    return gMAdSlotRewardVideo != null ? gMAdSlotRewardVideo.getRewardName() : "";
                                }

                                @Override // com.bytedance.msdk.api.reward.RewardItem
                                public boolean rewardVerify() {
                                    return z2;
                                }
                            });
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    @Deprecated
                    public void onRewardVerify(final boolean z2, final int i2, final String str, int i3, String str2) {
                        if (PangleRewardVideo.this.d()) {
                            Logger.e("TTMediationSDK", "pangle_reward:onRewardVerify");
                            if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                                PangleRewardVideo.this.a().onRewardVerify(new RewardItem() { // from class: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.1.2.1
                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public float getAmount() {
                                        int i4 = i2;
                                        if (i4 >= 0) {
                                            return i4;
                                        }
                                        if (((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot != null) {
                                            return ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardAmount();
                                        }
                                        return 0.0f;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public Map<String, Object> getCustomData() {
                                        return null;
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public String getRewardName() {
                                        return !TextUtils.isEmpty(str) ? str : ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot != null ? ((TTAbsAdLoaderAdapter) PangleRewardVideoAdapter.this).mAdSlot.getRewardName() : "";
                                    }

                                    @Override // com.bytedance.msdk.api.reward.RewardItem
                                    public boolean rewardVerify() {
                                        return z2;
                                    }
                                });
                            }
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        Logger.e("TTMediationSDK", "pangle_reward:onSkippedVideo");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onSkippedVideo();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoComplete");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onVideoComplete();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                        Logger.e("TTMediationSDK", "pangle_reward:onVideoError");
                        if (((TTBaseAd) PangleRewardVideo.this).mTTAdatperCallback instanceof GMRewardedAdListener) {
                            PangleRewardVideo.this.a().onVideoError();
                        }
                    }
                });
                PangleRewardVideo pangleRewardVideo3 = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdLoaded(pangleRewardVideo3);
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached() {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
            public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
                Logger.e("TTMediationSDK", "pangle_reward_onRewardVideoCached");
                PangleRewardVideo pangleRewardVideo = PangleRewardVideo.this;
                PangleRewardVideoAdapter.this.notifyAdVideoCache(pangleRewardVideo, (AdError) null);
            }
        }

        PangleRewardVideo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GMRewardedAdListener a() {
            while (true) {
                char c2 = ']';
                char c3 = ']';
                while (true) {
                    switch (c2) {
                        case '\\':
                            switch (c3) {
                                case 21:
                                    c2 = '^';
                                    c3 = 'K';
                                    break;
                            }
                        case ']':
                            while (true) {
                                switch (c3) {
                                    case '[':
                                    case '\\':
                                    case ']':
                                        break;
                                    default:
                                        c3 = '[';
                                        break;
                                }
                            }
                            c2 = '^';
                            c3 = 'K';
                            break;
                        case '^':
                            if (c3 > 4) {
                            }
                            break;
                    }
                }
            }
            return (GMRewardedAdListener) this.mTTAdatperCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public GMRewardedAdListener b() {
            return (GMRewardedAdListener) this.mTTAdatperRewardPlayAgainCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
        
            continue;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void c() {
            /*
                r10 = this;
                com.bytedance.sdk.openadsdk.TTAdManager r0 = com.bytedance.sdk.openadsdk.TTAdSdk.getAdManager()
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                android.content.Context r1 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.a(r1)
                com.bytedance.sdk.openadsdk.TTAdNative r0 = r0.createAdNative(r1)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r1 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r1 = r1.mGMAdSlotRewardVideo
                java.util.Map r1 = r1.getCustomData()
                if (r1 == 0) goto L27
                java.lang.String r2 = "pangle"
                java.lang.Object r1 = r1.get(r2)
                java.lang.String r1 = (java.lang.String) r1
                boolean r2 = android.text.TextUtils.isEmpty(r1)
                if (r2 != 0) goto L27
                goto L29
            L27:
                java.lang.String r1 = ""
            L29:
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.AdSlot r3 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.f(r2)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r4 = r2.mGMAdSlotRewardVideo
                java.lang.String r5 = r2.getAdSlotId()
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                java.lang.String r6 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.i(r2)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                java.lang.String r7 = r2.getClientReqId()
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r2 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                java.lang.String r8 = r2.getAdm()
                r9 = 0
                com.bytedance.sdk.openadsdk.AdSlot$Builder r2 = com.bytedance.msdk.adapter.pangle.PangleAdapterUtils.buildPangleAdSlot(r3, r4, r5, r6, r7, r8, r9)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r3 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r3 = r3.mGMAdSlotRewardVideo
                java.lang.String r3 = r3.getUserID()
                com.bytedance.sdk.openadsdk.AdSlot$Builder r3 = r2.setUserID(r3)
                com.bytedance.sdk.openadsdk.AdSlot$Builder r1 = r3.setMediaExtra(r1)
                r3 = 1080(0x438, float:1.513E-42)
                r4 = 1920(0x780, float:2.69E-42)
                com.bytedance.sdk.openadsdk.AdSlot$Builder r1 = r1.setImageAcceptedSize(r3, r4)
                com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter r3 = com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.this
                com.bytedance.msdk.api.v2.slot.GMAdSlotRewardVideo r3 = r3.mGMAdSlotRewardVideo
                int r3 = r3.getOrientation()
                r1.setOrientation(r3)
                com.bytedance.sdk.openadsdk.AdSlot r1 = r2.build()
                com.bytedance.sdk.openadsdk.TTAdNative$RewardVideoAdListener r2 = r10.f13986d
                r0.loadRewardVideoAd(r1, r2)
            L7a:
                r0 = 19
            L7c:
                switch(r0) {
                    case 18: goto La4;
                    case 19: goto La5;
                    case 20: goto L80;
                    default: goto L7f;
                }
            L7f:
                goto La5
            L80:
                r0 = 45
                switch(r0) {
                    case 8: goto L7a;
                    case 9: goto L86;
                    case 10: goto L96;
                    default: goto L85;
                }
            L85:
                goto L7a
            L86:
                r0 = 51
                int r1 = r0 * r0
                r2 = 29
                int r3 = r2 * r2
                int r1 = r1 + r3
                int r0 = r0 * 29
                int r0 = r0 * 2
                int r1 = r1 - r0
                if (r1 >= 0) goto L7a
            L96:
                r0 = 33
                int r0 = r0 * r0
                r1 = 32
                int r1 = r1 * r1
                int r1 = r1 * 34
                int r0 = r0 - r1
                r1 = -1
                if (r0 != r1) goto La5
            La4:
                return
            La5:
                r0 = 18
                goto L7c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.PangleRewardVideo.c():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return !"0.0".equals(PangleRewardVideoAdapter.this.getSdkVersion()) && PangleRewardVideoAdapter.VERSION_4400.compareTo(PangleRewardVideoAdapter.this.getSdkVersion()) > 0;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean adnHasAdVideoCachedApi() {
            return true;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getAdId() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return tTRewardVideoAd != null ? PangleAdapterUtils.getAdId(tTRewardVideoAd.getMediaExtraInfo()) : super.getAdId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public long getCreativeId() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return tTRewardVideoAd != null ? PangleAdapterUtils.getCreativeId(tTRewardVideoAd.getMediaExtraInfo()) : super.getCreativeId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public Map<String, Object> getMediaExtraInfo() {
            Map<String, Object> mediaExtraInfo;
            TTRewardVideoAd tTRewardVideoAd = this.a;
            if (tTRewardVideoAd == null || (mediaExtraInfo = tTRewardVideoAd.getMediaExtraInfo()) == null) {
                return super.getMediaExtraInfo();
            }
            HashMap map = new HashMap();
            map.put(PangleAdapterUtils.MEDIA_EXTRA_COUPON, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_COUPON));
            map.put(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_LIVE_ROOM));
            map.put(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT, mediaExtraInfo.get(PangleAdapterUtils.MEDIA_EXTRA_PRODUCT));
            return map;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public String getReqId() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return tTRewardVideoAd != null ? PangleAdapterUtils.getReqId(tTRewardVideoAd.getMediaExtraInfo()) : super.getReqId();
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean hasDestroyed() {
            return this.a == null;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public boolean isAdnPreload() {
            return this.f13985c;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public GMAdConstant.AdIsReadyStatus isReadyStatus() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            return (tTRewardVideoAd == null || tTRewardVideoAd.getExpirationTimestamp() <= System.currentTimeMillis()) ? GMAdConstant.AdIsReadyStatus.AD_IS_EXPIRED : GMAdConstant.AdIsReadyStatus.AD_IS_READY;
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void onDestroy() {
            TTRewardVideoAd tTRewardVideoAd = this.a;
            if (tTRewardVideoAd != null) {
                tTRewardVideoAd.setDownloadListener(null);
                this.a.setRewardAdInteractionListener(null);
                this.a = null;
            }
        }

        @Override // com.bytedance.msdk.base.TTBaseAd
        public void showAd(Activity activity, Map<TTAdConstant.GroMoreExtraKey, Object> map) {
            if (this.a != null) {
                TTAdConstant.RitScenes ritScenes = PangleAdapterUtils.getRitScenes(map);
                String customRitScenes = PangleAdapterUtils.getCustomRitScenes(map);
                if (ritScenes != null) {
                    this.a.showRewardVideoAd(activity, ritScenes, customRitScenes);
                } else {
                    this.a.showRewardVideoAd(activity);
                }
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public void destroy() {
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getAdNetWorkName() {
        return "pangle";
    }

    @Override // com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    public String getSdkVersion() {
        try {
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Exception unused) {
            return "0.0";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ae A[LOOP:1: B:22:0x0060->B:37:0x00ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0030 -> B:16:0x003c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // com.bytedance.msdk.adapter.ad.GMRewardBaseAdapter, com.bytedance.msdk.adapter.TTAbsAdLoaderAdapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadAd(android.content.Context r9, java.util.Map<java.lang.String, java.lang.Object> r10) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.msdk.adapter.pangle.PangleRewardVideoAdapter.loadAd(android.content.Context, java.util.Map):void");
    }
}
