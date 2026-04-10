package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.i;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    interstitialAdListener.onError(f.afS.errorCode, f.afS.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        boolean zA = n.qi().a(sceneImplCovert, "loadInterstitialAd");
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        sceneImplCovert.setAdStyle(13);
        com.kwad.components.ad.interstitial.monitor.b.cR();
        com.kwad.components.ad.interstitial.monitor.b.g(sceneImplCovert.getPosId());
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0403a().e(new com.kwad.components.core.n.kwai.b(sceneImplCovert)).aE(zA).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.interstitial.e.2
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull AdResultData adResultData, boolean z2) {
                b bVar;
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    f fVar = f.afS;
                    onError(fVar.errorCode, fVar.msg);
                    i.W("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(adTemplateList.get(0), jElapsedRealtime, z2);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_INTERSTITIAL, "dataReady").report();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = sceneImplCovert;
                        }
                        if (TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(com.kwad.sdk.core.response.a.d.cb(adTemplate)))) {
                            bVar = new b(sceneImplCovert, adTemplate);
                        } else if (com.kwad.components.ad.interstitial.monitor.a.f(adTemplate)) {
                            bVar = new b(sceneImplCovert, adTemplate);
                        }
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() == 0) {
                    f fVar2 = f.afS;
                    onError(fVar2.errorCode, fVar2.msg);
                    i.W("insertAd_", "onInterstitialAdCacheFailed");
                } else {
                    com.kwad.components.ad.interstitial.monitor.b.cR();
                    com.kwad.components.ad.interstitial.monitor.b.b(adTemplateList.get(0), jElapsedRealtime2, z2);
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            KsAdLoadManager.ac().b(arrayList);
                            i.W("insertAd_", "onInterstitialAdCacheSuccess");
                            interstitialAdListener.onInterstitialAdLoad(arrayList);
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
            public final void onError(final int i2, final String str) {
                com.kwad.components.ad.interstitial.monitor.b.cR();
                com.kwad.components.ad.interstitial.monitor.b.a(i2, str, sceneImplCovert.getPosId());
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.interstitial.e.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        interstitialAdListener.onError(i2, str);
                    }
                });
            }
        }).pz());
    }
}
