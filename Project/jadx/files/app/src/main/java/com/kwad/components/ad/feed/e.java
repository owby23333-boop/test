package com.kwad.components.ad.feed;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.feed.c;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.logger.model.BusinessType;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: com.kwad.components.ad.feed.e$2, reason: invalid class name */
    static class AnonymousClass2 extends com.kwad.components.core.n.c {
        final /* synthetic */ KsLoadManager.FeedAdListener ej;
        final /* synthetic */ SceneImpl ek;
        final /* synthetic */ boolean el;
        final /* synthetic */ long em;

        AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z2, long j2) {
            this.ej = feedAdListener;
            this.ek = sceneImpl;
            this.el = z2;
            this.em = j2;
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
        public final void a(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adResultData.getAdTemplateList().size());
            String str = null;
            for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                if (adTemplate != null) {
                    AdInfo adInfoCb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        adTemplate.mAdScene = this.ek;
                        arrayList.add(new c(adTemplate, this.el));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.a.a.aX(adInfoCb)), FeedType.fromInt(adTemplate.type));
                    }
                }
            }
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.a.x(arrayList.size());
            if (!arrayList.isEmpty()) {
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_FEED, "dataReady").b(com.anythink.expressad.a.f7963g, Integer.valueOf(arrayList.size())).report();
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        final c.a aVar = new c.a(arrayList.size());
                        for (final KsFeedAd ksFeedAd : arrayList) {
                            final c cVar = (c) ksFeedAd;
                            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                            final long jElapsedRealtime = SystemClock.elapsedRealtime();
                            cVar.a(ServiceProvider.getContext(), new c.b() { // from class: com.kwad.components.ad.feed.e.2.2.1
                                @Override // com.kwad.components.ad.feed.c.b
                                public final void c(int i2, String str2) {
                                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar + " cnt: " + aVar.aZ());
                                    com.kwad.components.ad.feed.monitor.a.a(((c) ksFeedAd).getAdTemplate(), i2, SystemClock.elapsedRealtime() - jElapsedRealtime, str2);
                                    if (aVar.ba()) {
                                        com.kwad.components.ad.feed.monitor.a.a(aVar.aZ(), SystemClock.elapsedRealtime() - AnonymousClass2.this.em);
                                        KsAdLoadManager.ac().b(arrayList);
                                        RunnableC03482 runnableC03482 = RunnableC03482.this;
                                        AnonymousClass2.this.ej.onFeedAdLoad(arrayList);
                                    }
                                }
                            });
                        }
                    }
                });
                return;
            }
            com.kwad.components.ad.feed.monitor.a.d(com.kwad.sdk.core.network.f.afS.errorCode, com.kwad.sdk.core.network.f.afS.msg + str);
            onError(com.kwad.sdk.core.network.f.afS.errorCode, com.kwad.sdk.core.network.f.afS.msg + str);
            com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onError");
        }

        @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
        public final void onError(final int i2, final String str) {
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    com.kwad.sdk.core.d.b.d("KsAdFeedLoadManager", "loadFeedAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                    com.kwad.components.ad.feed.monitor.a.d(i2, str);
                    AnonymousClass2.this.ej.onError(i2, str);
                }
            });
        }
    }

    public static void a(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener, boolean z2) {
        if (!KsAdSDKImpl.get().hasInitFinish()) {
            com.kwad.sdk.core.d.b.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.feed.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    feedAdListener.onError(com.kwad.sdk.core.network.f.afS.errorCode, com.kwad.sdk.core.network.f.afS.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.a.w(sceneImplCovert.getAdNum());
        boolean zA = n.qi().a(sceneImplCovert, "loadConfigFeedAd");
        sceneImplCovert.setAdStyle(1);
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0403a().e(new com.kwad.components.core.n.kwai.b(sceneImplCovert)).aE(zA).a(new AnonymousClass2(feedAdListener, sceneImplCovert, z2, jElapsedRealtime)).pz());
    }
}
