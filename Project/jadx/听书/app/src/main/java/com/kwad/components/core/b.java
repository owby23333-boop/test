package com.kwad.components.core;

import android.app.Activity;
import com.kwad.components.ad.b.c;
import com.kwad.components.ad.b.e;
import com.kwad.components.ad.b.f;
import com.kwad.components.ad.b.g;
import com.kwad.components.ad.b.h;
import com.kwad.components.ad.b.i;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.KsExitInstallListener;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.components.d;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements KsLoadManager {
    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestToken(KsScene ksScene) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        return bVar != null ? bVar.getBidRequestToken(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final String getBidRequestTokenV2(KsScene ksScene) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        return bVar != null ? bVar.getBidRequestTokenV2(ksScene) : "";
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final boolean showInstallDialog(Activity activity, KsExitInstallListener ksExitInstallListener) {
        com.kwad.components.ad.b.b bVar = (com.kwad.components.ad.b.b) d.f(com.kwad.components.ad.b.b.class);
        if (bVar != null) {
            return bVar.showInstallDialog(activity, ksExitInstallListener);
        }
        return false;
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFullScreenVideoAd(KsScene ksScene, final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        e eVar = (e) d.f(e.class);
        if (eVar != null) {
            eVar.loadFullScreenVideoAd(ksScene, new KsLoadManager.FullScreenVideoAdListener() { // from class: com.kwad.components.core.b.1
                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onError(int i, String str) {
                    fullScreenVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoResult(List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoResult(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
                public final void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list) {
                    fullScreenVideoAdListener.onFullScreenVideoAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aEn;
            fullScreenVideoAdListener.onError(eVar2.errorCode, eVar2.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadRewardVideoAd(KsScene ksScene, final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        h hVar = (h) d.f(h.class);
        if (hVar != null) {
            hVar.loadRewardVideoAd(ksScene, new KsLoadManager.RewardVideoAdListener() { // from class: com.kwad.components.core.b.2
                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onError(int i, String str) {
                    rewardVideoAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoResult(List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoResult(list);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
                public final void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
                    rewardVideoAdListener.onRewardVideoAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
            rewardVideoAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
        if (dVar != null) {
            dVar.loadFeedAd(ksScene, feedAdListener);
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadConfigFeedAd(KsScene ksScene, KsLoadManager.FeedAdListener feedAdListener) {
        com.kwad.components.ad.b.d dVar = (com.kwad.components.ad.b.d) d.f(com.kwad.components.ad.b.d.class);
        if (dVar != null) {
            dVar.loadConfigFeedAd(ksScene, feedAdListener);
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
            feedAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadDrawAd(KsScene ksScene, final KsLoadManager.DrawAdListener drawAdListener) {
        c cVar = (c) d.f(c.class);
        if (cVar != null) {
            cVar.loadDrawAd(ksScene, new KsLoadManager.DrawAdListener() { // from class: com.kwad.components.core.b.3
                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onError(int i, String str) {
                    drawAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.DrawAdListener
                public final void onDrawAdLoad(List<KsDrawAd> list) {
                    drawAdListener.onDrawAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
            drawAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(KsScene ksScene, final KsLoadManager.NativeAdListener nativeAdListener) {
        g gVar = (g) d.f(g.class);
        if (gVar != null) {
            gVar.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.kwad.components.core.b.4
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onError(int i, String str) {
                    nativeAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public final void onNativeAdLoad(List<KsNativeAd> list) {
                    nativeAdListener.onNativeAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadNativeAd(String str, KsLoadManager.NativeAdListener nativeAdListener) {
        g gVar = (g) d.f(g.class);
        if (gVar != null) {
            gVar.loadNativeAd(str, nativeAdListener);
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
            nativeAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadBannerAd(KsScene ksScene, KsLoadManager.BannerAdListener bannerAdListener) {
        try {
            com.kwad.components.ad.b.a aVar = (com.kwad.components.ad.b.a) d.f(com.kwad.components.ad.b.a.class);
            if (aVar != null) {
                aVar.loadBannerAd(ksScene, bannerAdListener);
            } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
                bannerAdListener.onError(eVar.errorCode, eVar.msg);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            bannerAdListener.onError(com.kwad.sdk.core.network.e.aEv.errorCode, com.kwad.sdk.core.network.e.aEv.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadSplashScreenAd(KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        try {
            i iVar = (i) d.f(i.class);
            if (iVar != null) {
                iVar.loadSplashScreenAd(ksScene, new KsLoadManager.SplashScreenAdListener() { // from class: com.kwad.components.core.b.5
                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onError(int i, String str) {
                        splashScreenAdListener.onError(i, str);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onRequestResult(int i) {
                        splashScreenAdListener.onRequestResult(i);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public final void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    }
                });
            } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
                splashScreenAdListener.onError(eVar.errorCode, eVar.msg);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            splashScreenAdListener.onError(com.kwad.sdk.core.network.e.aEv.errorCode, com.kwad.sdk.core.network.e.aEv.msg);
        }
    }

    @Override // com.kwad.sdk.api.KsLoadManager
    public final void loadInterstitialAd(KsScene ksScene, final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        f fVar = (f) d.f(f.class);
        if (fVar != null) {
            fVar.loadInterstitialAd(ksScene, new KsLoadManager.InterstitialAdListener() { // from class: com.kwad.components.core.b.6
                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onError(int i, String str) {
                    interstitialAdListener.onError(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onRequestResult(int i) {
                    interstitialAdListener.onRequestResult(i);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
                public final void onInterstitialAdLoad(List<KsInterstitialAd> list) {
                    interstitialAdListener.onInterstitialAdLoad(list);
                }
            });
        } else if (com.kwad.components.ad.f.a.oz.booleanValue()) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEn;
            interstitialAdListener.onError(eVar.errorCode, eVar.msg);
        }
    }
}
