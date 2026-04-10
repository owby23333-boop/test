package com.funny.audio.ad.loader;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdSlot;
import com.funny.audio.core.utils.DeviceUtils;
import com.funny.audio.database.entities.AdSettingEntity;
import com.funny.audio.user.UserManager;
import com.umeng.analytics.pro.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InterstitialAdLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004J&\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006,"}, d2 = {"Lcom/funny/audio/ad/loader/InterstitialAdLoader;", "", "()V", "adEntity", "Lcom/funny/audio/database/entities/AdSettingEntity;", "getAdEntity", "()Lcom/funny/audio/database/entities/AdSettingEntity;", "setAdEntity", "(Lcom/funny/audio/database/entities/AdSettingEntity;)V", d.R, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "isLoading", "", "()Z", "setLoading", "(Z)V", "lastLoadedTime", "", "getLastLoadedTime", "()J", "setLastLoadedTime", "(J)V", "loaded", "getLoaded", "setLoaded", "tagName", "", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", "init", "", "showWithLoad", TTDownloadField.TT_ACTIVITY, "Landroid/app/Activity;", "loadListener", "Lcom/funny/audio/ad/loader/InterstitialAdLoadListener;", "showListener", "Lcom/funny/audio/ad/loader/InterstitialAdListener;", "app_normalRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InterstitialAdLoader {
    private AdSettingEntity adEntity;
    private Context context;
    private boolean isLoading;
    private long lastLoadedTime;
    private boolean loaded;
    private String tagName = "InterstitialAdLoader";

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

    public final void init(Context context, AdSettingEntity adEntity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adEntity, "adEntity");
        this.context = context;
        this.adEntity = adEntity;
    }

    public static /* synthetic */ void showWithLoad$default(InterstitialAdLoader interstitialAdLoader, Activity activity, InterstitialAdLoadListener interstitialAdLoadListener, InterstitialAdListener interstitialAdListener, int i, Object obj) {
        if ((i & 2) != 0) {
            interstitialAdLoadListener = null;
        }
        if ((i & 4) != 0) {
            interstitialAdListener = null;
        }
        interstitialAdLoader.showWithLoad(activity, interstitialAdLoadListener, interstitialAdListener);
    }

    public final void showWithLoad(final Activity activity, final InterstitialAdLoadListener loadListener, final InterstitialAdListener showListener) {
        String deviceUUID;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (this.isLoading || this.loaded) {
            return;
        }
        this.isLoading = true;
        if (UserManager.INSTANCE.isLogin()) {
            deviceUUID = UserManager.INSTANCE.getUserId();
        } else {
            deviceUUID = DeviceUtils.INSTANCE.getDeviceUUID(this.context);
        }
        AdSettingEntity adSettingEntity = this.adEntity;
        Intrinsics.checkNotNull(adSettingEntity);
        final String codeId = adSettingEntity.getCodeId();
        TTAdNative tTAdNativeCreateAdNative = TTAdSdk.getAdManager().createAdNative(activity);
        AdSlot adSlotBuild = new AdSlot.Builder().setCodeId(codeId).setOrientation(1).setMediationAdSlot(new MediationAdSlot.Builder().setMuted(true).build()).setUserID(deviceUUID).build();
        Intrinsics.checkNotNullExpressionValue(adSlotBuild, "Builder()\n            .s…rId)\n            .build()");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        if (tTAdNativeCreateAdNative != null) {
            tTAdNativeCreateAdNative.loadFullScreenVideoAd(adSlotBuild, new TTAdNative.FullScreenVideoAdListener() { // from class: com.funny.audio.ad.loader.InterstitialAdLoader.showWithLoad.1
                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onFullScreenVideoCached() {
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onError(int code, String msg) {
                    Log.i(InterstitialAdLoader.this.getTagName(), "插屏广告(" + codeId + ")加载失败:" + code + "," + msg);
                    InterstitialAdLoadListener interstitialAdLoadListener = loadListener;
                    if (interstitialAdLoadListener != null) {
                        interstitialAdLoadListener.onLoadFail(code, msg);
                    }
                    InterstitialAdLoader.this.setLoading(false);
                    InterstitialAdLoader.this.setLoaded(false);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onFullScreenVideoAdLoad(TTFullScreenVideoAd ad) {
                    Log.i(InterstitialAdLoader.this.getTagName(), "插屏广告(" + codeId + ")加载耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
                    InterstitialAdLoadListener interstitialAdLoadListener = loadListener;
                    if (interstitialAdLoadListener != null) {
                        interstitialAdLoadListener.onAdLoad();
                    }
                    InterstitialAdLoader.this.setLoading(false);
                    InterstitialAdLoader.this.setLoaded(true);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
                public void onFullScreenVideoCached(TTFullScreenVideoAd ad) {
                    if (ad == null || ad.getMediationManager() == null) {
                        return;
                    }
                    final InterstitialAdListener interstitialAdListener = showListener;
                    final InterstitialAdLoader interstitialAdLoader = InterstitialAdLoader.this;
                    ad.setFullScreenVideoAdInteractionListener(new TTFullScreenVideoAd.FullScreenVideoAdInteractionListener() { // from class: com.funny.audio.ad.loader.InterstitialAdLoader$showWithLoad$1$onFullScreenVideoCached$1
                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdVideoBarClick() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onSkippedVideo() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onVideoComplete() {
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdShow() {
                            InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                            if (interstitialAdListener2 != null) {
                                interstitialAdListener2.onAdShow();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
                        public void onAdClose() {
                            interstitialAdLoader.setLoading(false);
                            interstitialAdLoader.setLoaded(false);
                            InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                            if (interstitialAdListener2 != null) {
                                interstitialAdListener2.onAdClose();
                            }
                        }
                    });
                    ad.showFullScreenVideoAd(activity);
                }
            });
        }
    }
}
