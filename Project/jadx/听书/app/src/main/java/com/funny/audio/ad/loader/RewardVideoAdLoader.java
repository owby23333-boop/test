package com.funny.audio.ad.loader;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.database.entities.AdSettingEntity;
import com.funny.audio.user.UserManager;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RewardVideoAdLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010)\u001a\u00020*2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J\u001a\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/J\u001a\u00100\u001a\u00020*2\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u000101R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00062"}, d2 = {"Lcom/funny/audio/ad/loader/RewardVideoAdLoader;", "", "()V", "adEntity", "Lcom/funny/audio/database/entities/AdSettingEntity;", "getAdEntity", "()Lcom/funny/audio/database/entities/AdSettingEntity;", "setAdEntity", "(Lcom/funny/audio/database/entities/AdSettingEntity;)V", d.R, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isLoading", "", "()Z", "setLoading", "(Z)V", "lastLoadedTime", "", "getLastLoadedTime", "()J", "setLastLoadedTime", "(J)V", "loaded", "getLoaded", "setLoaded", "rewardVideoAd", "Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "getRewardVideoAd", "()Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;", "setRewardVideoAd", "(Lcom/bytedance/sdk/openadsdk/TTRewardVideoAd;)V", "tagName", "", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "init", "", "load", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "listener", "Lcom/funny/audio/ad/loader/RewardVideoAdLoadListener;", "show", "Lcom/funny/audio/ad/loader/RewardVideoAdListener;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RewardVideoAdLoader {
    private AdSettingEntity adEntity;
    private Context context;
    private boolean isLoading;
    private long lastLoadedTime;
    private boolean loaded;
    private TTRewardVideoAd rewardVideoAd;
    private String tagName = "RewardVideoAdLoader";

    public final String getTagName() {
        return this.tagName;
    }

    public final void setTagName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tagName = str;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    /* JADX INFO: renamed from: isLoading, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    public final boolean getLoaded() {
        return this.loaded;
    }

    public final void setLoaded(boolean z) {
        this.loaded = z;
    }

    public final AdSettingEntity getAdEntity() {
        return this.adEntity;
    }

    public final void setAdEntity(AdSettingEntity adSettingEntity) {
        this.adEntity = adSettingEntity;
    }

    public final long getLastLoadedTime() {
        return this.lastLoadedTime;
    }

    public final void setLastLoadedTime(long j) {
        this.lastLoadedTime = j;
    }

    public final TTRewardVideoAd getRewardVideoAd() {
        return this.rewardVideoAd;
    }

    public final void setRewardVideoAd(TTRewardVideoAd tTRewardVideoAd) {
        this.rewardVideoAd = tTRewardVideoAd;
    }

    public final void init(Context context, AdSettingEntity adEntity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adEntity, "adEntity");
        this.context = context;
        this.adEntity = adEntity;
    }

    public static /* synthetic */ void load$default(RewardVideoAdLoader rewardVideoAdLoader, Activity activity, RewardVideoAdLoadListener rewardVideoAdLoadListener, int i, Object obj) {
        if ((i & 2) != 0) {
            rewardVideoAdLoadListener = null;
        }
        rewardVideoAdLoader.load(activity, rewardVideoAdLoadListener);
    }

    public final void load(Activity activity, final RewardVideoAdLoadListener listener) {
        String deviceUUID;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isLoading || this.loaded) {
            return;
        }
        if (UserManager.INSTANCE.isLogin()) {
            deviceUUID = UserManager.INSTANCE.getUserId();
        } else {
            deviceUUID = DeviceUtils.INSTANCE.getDeviceUUID(this.context);
        }
        AdSettingEntity adSettingEntity = this.adEntity;
        Intrinsics.checkNotNull(adSettingEntity);
        final String codeId = adSettingEntity.getCodeId();
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(codeId).setOrientation(1).setUserID(deviceUUID).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(false).build()).build();
        Intrinsics.checkNotNullExpressionValue(adSlotBuild, "Builder()\n            .s…d())\n            .build()");
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        if (tTAdNativeCreateAdNative != null) {
            tTAdNativeCreateAdNative.loadRewardVideoAd(adSlotBuild, new TTAdNative.RewardVideoAdListener() { // from class: com.funny.audio.ad.loader.RewardVideoAdLoader.load.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
                public void onError(int code, String msg) {
                    RewardVideoAdLoader.this.setLoading(false);
                    Log.i(RewardVideoAdLoader.this.getTagName(), "激励广告加载失败(" + codeId + "):" + code + "," + msg);
                    RewardVideoAdLoader.this.setLoaded(false);
                    RewardVideoAdLoadListener rewardVideoAdLoadListener = listener;
                    if (rewardVideoAdLoadListener != null) {
                        rewardVideoAdLoadListener.onRewardVideoLoadFail(code, msg);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
                public void onRewardVideoAdLoad(TTRewardVideoAd ad) {
                    RewardVideoAdLoader.this.setRewardVideoAd(ad);
                    RewardVideoAdLoader.this.setLoading(false);
                    RewardVideoAdLoader.this.setLoaded(true);
                    RewardVideoAdLoader.this.setLastLoadedTime(System.currentTimeMillis());
                    RewardVideoAdLoadListener rewardVideoAdLoadListener = listener;
                    if (rewardVideoAdLoadListener != null) {
                        rewardVideoAdLoadListener.onRewardVideoAdLoad();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
                public void onRewardVideoCached() {
                    RewardVideoAdLoader.this.setLoading(false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
                public void onRewardVideoCached(TTRewardVideoAd ad) {
                    RewardVideoAdLoader.this.setLoading(false);
                }
            });
        }
    }

    public static /* synthetic */ void show$default(RewardVideoAdLoader rewardVideoAdLoader, Activity activity, RewardVideoAdListener rewardVideoAdListener, int i, Object obj) {
        if ((i & 2) != 0) {
            rewardVideoAdListener = null;
        }
        rewardVideoAdLoader.show(activity, rewardVideoAdListener);
    }

    public final void show(Activity activity, final RewardVideoAdListener listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.loaded) {
            AdSettingEntity adSettingEntity = this.adEntity;
            Intrinsics.checkNotNull(adSettingEntity);
            String codeId = adSettingEntity.getCodeId();
            try {
                TTRewardVideoAd tTRewardVideoAd = this.rewardVideoAd;
                Intrinsics.checkNotNull(tTRewardVideoAd);
                tTRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener() { // from class: com.funny.audio.ad.loader.RewardVideoAdLoader.show.1
                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean rewardVerify, int rewardAmount, String rewardName, int errorCode, String errorMsg) {
                        Intrinsics.checkNotNullParameter(rewardName, "rewardName");
                        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        Log.i(RewardVideoAdLoader.this.getTagName(), "激励广告展示...");
                        RewardVideoAdListener rewardVideoAdListener = listener;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onAdShow();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        RewardVideoAdListener rewardVideoAdListener = listener;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onAdClose();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(boolean isRewardValid, int rewardType, Bundle extraInfo) {
                        RewardVideoAdListener rewardVideoAdListener;
                        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
                        if (!isRewardValid || (rewardVideoAdListener = listener) == null) {
                            return;
                        }
                        rewardVideoAdListener.onRewardVerify();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                        RewardVideoAdListener rewardVideoAdListener = listener;
                        if (rewardVideoAdListener != null) {
                            rewardVideoAdListener.onAdSkip();
                        }
                    }
                });
                TTRewardVideoAd tTRewardVideoAd2 = this.rewardVideoAd;
                Intrinsics.checkNotNull(tTRewardVideoAd2);
                tTRewardVideoAd2.showRewardVideoAd(activity);
                this.loaded = false;
                this.rewardVideoAd = null;
            } catch (Exception e) {
                Log.e(this.tagName, "展示激励视频广告(" + codeId + ")出错:" + e.getMessage());
            }
        }
    }
}
