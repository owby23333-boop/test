package com.kwad.components.core;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.ad.a.d;
import com.kwad.components.ad.a.e;
import com.kwad.components.ad.a.g;
import com.kwad.components.ad.a.h;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        return aVar != null ? aVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.f.a.T(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_REQUEST);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "loadRequest").report();
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.4
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i2, String str) {
                    feedAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.f.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_REQUEST);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.afP;
            feedAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        com.kwad.sdk.f.a.T("draw", TTLogUtil.TAG_EVENT_REQUEST);
        com.kwad.components.ad.a.b bVar = (com.kwad.components.ad.a.b) c.f(com.kwad.components.ad.a.b.class);
        if (bVar != null) {
            bVar.loadDrawAd(ksScene, new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.5
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(@Nullable List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i2, String str) {
                    drawAdListener.onError(i2, str);
                }
            });
            com.kwad.sdk.f.a.U("draw", TTLogUtil.TAG_EVENT_REQUEST);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.afP;
            drawAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.sdk.f.a.T(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_REQUEST);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "loadRequest").report();
        com.kwad.components.ad.a.c cVar = (com.kwad.components.ad.a.c) c.f(com.kwad.components.ad.a.c.class);
        if (cVar != null) {
            cVar.loadFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.kwad.components.core.b.3
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onError(int i2, String str) {
                    feedAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public final void onFeedAdLoad(@Nullable List<KsFeedAd> list) {
                    feedAdListener.onFeedAdLoad(list);
                }
            });
            com.kwad.sdk.f.a.U(IAdInterListener.AdProdType.PRODUCT_FEEDS, TTLogUtil.TAG_EVENT_REQUEST);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.afP;
            feedAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        com.kwad.sdk.f.a.T("fullscreen", TTLogUtil.TAG_EVENT_REQUEST);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "loadRequest").report();
        d dVar = (d) c.f(d.class);
        if (dVar != null) {
            dVar.loadFullScreenVideoAd(ksScene, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i2, String str) {
                    fullScreenVideoAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoAdLoad(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoResult(@Nullable List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoResult(list);
                }
            });
            com.kwad.sdk.f.a.U("fullscreen", TTLogUtil.TAG_EVENT_REQUEST);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.afP;
            fullScreenVideoAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        com.kwad.sdk.f.a.T(com.anythink.expressad.foundation.g.a.f.f10438d, TTLogUtil.TAG_EVENT_REQUEST);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "loadRequest").report();
        e eVar = (e) c.f(e.class);
        if (eVar != null) {
            eVar.loadInterstitialAd(ksScene, new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.8
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i2, String str) {
                    interstitialAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(@Nullable List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i2) {
                    interstitialAdListener.onRequestResult(i2);
                }
            });
            com.kwad.sdk.f.a.U(com.anythink.expressad.foundation.g.a.f.f10438d, TTLogUtil.TAG_EVENT_REQUEST);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.afP;
            interstitialAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        com.kwad.sdk.f.a.T(com.anythink.expressad.foundation.g.a.f.a, TTLogUtil.TAG_EVENT_REQUEST);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "loadRequest").report();
        com.kwad.components.ad.a.f fVar = (com.kwad.components.ad.a.f) c.f(com.kwad.components.ad.a.f.class);
        if (fVar != null) {
            fVar.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.6
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i2, String str) {
                    nativeAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(@Nullable List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            });
            com.kwad.sdk.f.a.U(com.anythink.expressad.foundation.g.a.f.a, TTLogUtil.TAG_EVENT_REQUEST);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar2 = f.afP;
            nativeAdListener.onError(fVar2.errorCode, fVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, @NonNull KsLoadManager.NativeAdListener nativeAdListener) {
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_NATIVE, "loadRequest").report();
        com.kwad.components.ad.a.f fVar = (com.kwad.components.ad.a.f) c.f(com.kwad.components.ad.a.f.class);
        if (fVar != null) {
            fVar.loadNativeAd(str, nativeAdListener);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar2 = f.afP;
            nativeAdListener.onError(fVar2.errorCode, fVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        com.kwad.sdk.f.a.T("reward", TTLogUtil.TAG_EVENT_REQUEST);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "loadRequest").report();
        g gVar = (g) c.f(g.class);
        if (gVar != null) {
            gVar.loadRewardVideoAd(ksScene, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.2
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i2, String str) {
                    rewardVideoAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoAdLoad(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(@Nullable List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoResult(list);
                }
            });
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.afP;
            rewardVideoAdListener.onError(fVar.errorCode, fVar.msg);
        }
        com.kwad.sdk.f.a.U("reward", TTLogUtil.TAG_EVENT_REQUEST);
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        com.kwad.sdk.f.a.T(com.anythink.expressad.foundation.g.a.f.f10440f, TTLogUtil.TAG_EVENT_REQUEST);
        KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "loadRequest").report();
        h hVar = (h) c.f(h.class);
        if (hVar != null) {
            hVar.loadSplashScreenAd(ksScene, new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.7
                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onError(int i2, String str) {
                    splashScreenAdListener.onError(i2, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onRequestResult(int i2) {
                    splashScreenAdListener.onRequestResult(i2);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                public final void onSplashScreenAdLoad(@Nullable KsSplashScreenAd ksSplashScreenAd) {
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                }
            });
            com.kwad.sdk.f.a.U(com.anythink.expressad.foundation.g.a.f.f10440f, TTLogUtil.TAG_EVENT_REQUEST);
        } else if (com.kwad.components.ad.d.a.bI.booleanValue()) {
            f fVar = f.afP;
            splashScreenAdListener.onError(fVar.errorCode, fVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) c.f(com.kwad.components.ad.a.a.class);
        if (aVar != null) {
            return aVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }
}
