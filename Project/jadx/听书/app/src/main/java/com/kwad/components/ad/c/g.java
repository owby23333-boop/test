package com.kwad.components.ad.c;

import android.text.TextUtils;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.l;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import com.kwad.sdk.utils.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    public static KsScene bV;

    public static void loadBannerAd(KsScene ksScene, final KsLoadManager.BannerAdListener bannerAdListener) {
        if (!l.Cf().Bn()) {
            com.kwad.sdk.core.d.c.e("KsAdBannerLoadManager", "loadBannerAd please init sdk first");
            bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    bannerAdListener.onError(com.kwad.sdk.core.network.e.aEq.errorCode, com.kwad.sdk.core.network.e.aEq.msg + "sdk not init");
                }
            });
            return;
        }
        ksScene.setAdNum(com.kwad.sdk.core.config.e.Gj());
        bV = ksScene;
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(sceneImplCovert);
        boolean zB = n.tn().b(sceneImplCovert, "loadBannerAd");
        sceneImplCovert.setAdStyle(5);
        KsAdLoadManager.M().a(new a.C0351a().e(new ImpInfo(sceneImplCovert)).aM(zB).a(new j() { // from class: com.kwad.components.ad.c.g.3
            @Override // com.kwad.components.core.request.j
            public final void ah() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.g.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                if (i != com.kwad.sdk.core.network.e.aEq.errorCode) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aEl;
                }
                bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.2.1
                    @Override // com.kwad.sdk.utils.bg
                    public final void doTask() {
                        com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        bannerAdListener.onError(i, str);
                    }
                });
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(AdResultData adResultData, boolean z) {
                List listA = g.a(sceneImplCovert, adResultData.getAdTemplateList());
                if (listA.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg);
                    k.aq("bannerAd_", "onBannerAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig adVideoPreCacheConfigObtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.BQ());
                final AdTemplate adTemplate = (AdTemplate) listA.get(0);
                new h(adResultData);
                com.kwad.sdk.commercial.d.d.a(sceneImplCovert, listA.size());
                final h hVar = new h(adResultData);
                com.kwad.sdk.core.config.e.Gf();
                AdTemplate adTemplate2 = hVar.getAdTemplate();
                if (com.kwad.sdk.core.response.b.a.bd(com.kwad.sdk.core.response.b.e.el(adTemplate2))) {
                    g.a(bannerAdListener, hVar);
                } else {
                    com.kwad.components.ad.c.a.a.a(adTemplate2, adVideoPreCacheConfigObtainVideoPreCacheConfig, new com.kwad.components.ad.c.a.b() { // from class: com.kwad.components.ad.c.g.2.2
                        @Override // com.kwad.components.ad.c.a.b
                        public final void af() {
                            com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                            AdTemplate adTemplate3 = adTemplate;
                            g.a(bannerAdListener, hVar);
                        }

                        @Override // com.kwad.components.ad.c.a.b
                        public final void ag() {
                            AdTemplate adTemplate3 = adTemplate;
                            g.a(bannerAdListener, hVar);
                        }
                    });
                }
                com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd after cache");
            }
        }).sw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo adInfoEl = com.kwad.sdk.core.response.b.e.el(adTemplate);
                if (1 == com.kwad.sdk.core.response.b.a.be(adInfoEl)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.b.a.bd(adInfoEl)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.BannerAdListener bannerAdListener, final KsBannerAd ksBannerAd) {
        bw.postOnUiThread(new bg() { // from class: com.kwad.components.ad.c.g.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                k.aq("bannerAd_", "onBannerAdCacheSuccess");
                bannerAdListener.onBannerAdLoad(ksBannerAd);
            }
        });
    }
}
