package com.kwad.components.ad.reward;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.r;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
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
                AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                if (com.kwad.sdk.core.response.a.a.bI(adInfoCb) || com.kwad.sdk.core.response.a.a.co(adInfoCb) || !TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(adInfoCb))) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadRewardVideoAd(KsScene ksScene, @NonNull final KsLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.a.a(true, sceneImplCovert.getPosId());
        boolean zA = com.kwad.components.core.r.n.qi().a(sceneImplCovert, "loadRewardVideoAd");
        sceneImplCovert.setAdStyle(2);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0403a().e(new com.kwad.components.core.n.kwai.b(sceneImplCovert)).aE(zA).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.reward.e.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull AdResultData adResultData, boolean z2) {
                List<AdTemplate> listA = e.a(sceneImplCovert, adResultData.getProceedTemplateList());
                if (listA.isEmpty()) {
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.afS;
                    onError(fVar.errorCode, fVar.msg);
                    com.kwad.sdk.utils.i.W("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : listA) {
                    arrayList.add(new f(adTemplate));
                    adTemplate.setLoadDataTime(jElapsedRealtime2);
                    adTemplate.setLoadFromCache(z2);
                }
                com.kwad.components.ad.reward.monitor.a.a(true, (AdTemplate) listA.get(0), listA.size(), jElapsedRealtime);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_REWARD, "dataReady").report();
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            KsAdLoadManager.ac().b(arrayList);
                            rewardVideoAdListener.onRewardVideoResult(arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            r.a((Object) rewardVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                final ArrayList arrayList2 = new ArrayList();
                boolean z3 = false;
                for (KsRewardVideoAd ksRewardVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((f) ksRewardVideoAd).getAdTemplate();
                    AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate2);
                    if (com.kwad.sdk.core.response.a.a.bI(adInfoCb) || com.kwad.sdk.core.response.a.a.co(adInfoCb)) {
                        arrayList2.add(ksRewardVideoAd);
                        z3 = true;
                    } else if (com.kwad.components.ad.b.a.a(adTemplate2, true)) {
                        arrayList2.add(ksRewardVideoAd);
                    }
                }
                if (z3 || !arrayList2.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.a.b(true, (AdTemplate) listA.get(0), listA.size(), jElapsedRealtime);
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.utils.i.W("rewardAd_", "onRewardVideoAdCacheSuccess");
                            rewardVideoAdListener.onRewardVideoAdLoad(arrayList2);
                        }
                    });
                } else {
                    com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.afT;
                    onError(fVar2.errorCode, fVar2.msg);
                    com.kwad.sdk.utils.i.W("rewardAd_", "onRewardVideoAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
            public final void onError(final int i2, final String str) {
                com.kwad.components.ad.reward.monitor.a.a(true, i2, str, sceneImplCovert.getPosId());
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.reward.e.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        rewardVideoAdListener.onError(i2, str);
                    }
                });
            }
        }).pz());
    }
}
