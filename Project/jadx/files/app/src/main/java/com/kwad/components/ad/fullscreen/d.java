package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.r;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
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
                if (!TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.E(adInfoCb)) || com.kwad.sdk.core.response.a.a.co(adInfoCb)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadFullScreenVideoAd(KsScene ksScene, @NonNull final KsLoadManager.FullScreenVideoAdListener fullScreenVideoAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.components.ad.reward.monitor.a.a(false, sceneImplCovert.getPosId());
        boolean zA = n.qi().a(sceneImplCovert, "loadFullScreenVideoAd");
        sceneImplCovert.setAdStyle(3);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0403a().e(new com.kwad.components.core.n.kwai.b(sceneImplCovert)).aE(zA).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.fullscreen.d.1
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull AdResultData adResultData, boolean z2) {
                List<AdTemplate> listA = d.a(sceneImplCovert, adResultData.getAdTemplateList());
                if (listA.isEmpty()) {
                    f fVar = f.afS;
                    onError(fVar.errorCode, fVar.msg);
                    i.W("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : listA) {
                    arrayList.add(new e(adTemplate));
                    adTemplate.setLoadDataTime(jElapsedRealtime2);
                    adTemplate.setLoadFromCache(z2);
                }
                com.kwad.components.ad.reward.monitor.a.a(false, (AdTemplate) listA.get(0), listA.size(), jElapsedRealtime);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FULLSCREEN, "dataReady").report();
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            fullScreenVideoAdListener.onFullScreenVideoResult(arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            r.a((Object) fullScreenVideoAdListener, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                for (KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((e) ksFullScreenVideoAd).getAdTemplate();
                    if (com.kwad.components.ad.b.a.a(adTemplate2, false) || com.kwad.sdk.core.response.a.a.co(com.kwad.sdk.core.response.a.d.cb(adTemplate2))) {
                        arrayList2.add(ksFullScreenVideoAd);
                    }
                }
                if (!arrayList2.isEmpty()) {
                    com.kwad.components.ad.reward.monitor.a.b(false, (AdTemplate) listA.get(0), listA.size(), jElapsedRealtime);
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            i.W("fullAd_", "onFullScreenVideoAdCacheFailed");
                            KsAdLoadManager.ac().b(arrayList);
                            fullScreenVideoAdListener.onFullScreenVideoAdLoad(arrayList);
                        }
                    });
                } else {
                    f fVar2 = f.afT;
                    onError(fVar2.errorCode, fVar2.msg);
                    i.W("fullAd_", "onFullScreenVideoAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
            public final void onError(final int i2, final String str) {
                com.kwad.components.ad.reward.monitor.a.a(false, i2, str, sceneImplCovert.getPosId());
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.fullscreen.d.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.b.d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                        fullScreenVideoAdListener.onError(i2, str);
                    }
                });
            }
        }).pz());
    }
}
