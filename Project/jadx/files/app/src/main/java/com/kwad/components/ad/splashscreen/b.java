package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.n.kwai.a;
import com.kwad.components.core.r.n;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.components.splash.SplashPreloadManager;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bh;
import com.kwai.adclient.logger.model.BusinessType;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final Handler mHandler = new Handler(Looper.getMainLooper());

    static class a {
        private volatile boolean BK;

        private a() {
            this.BK = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    static class C0376b {
        private volatile boolean BL;

        private C0376b() {
            this.BL = false;
        }

        /* synthetic */ C0376b(byte b) {
            this();
        }

        static /* synthetic */ boolean a(C0376b c0376b, boolean z2) {
            c0376b.BL = true;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(com.kwad.components.core.n.kwai.b bVar) {
        final SceneImpl sceneImpl = bVar.Ot;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.m.a.pr().pu();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.splash.monitor.a.sp();
            com.kwad.components.splash.monitor.a.B(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.ac();
            KsAdLoadManager.a(new a.C0403a().e(bVar).aE(false).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.splashscreen.b.4
                @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
                public final void a(@NonNull AdResultData adResultData) {
                    if (adResultData.getAdTemplateList().size() > 0) {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.sm().b(adResultData, false));
                        com.kwad.components.splash.monitor.a.sp();
                        com.kwad.components.splash.monitor.a.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - jElapsedRealtime, sceneImpl.getPosId());
                        com.kwad.components.core.m.a.pr().aA(adResultData.getAdTemplateList().size());
                    }
                }

                @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.h
                public final void onError(int i2, String str) {
                    com.kwad.components.splash.monitor.a.sp();
                    com.kwad.components.splash.monitor.a.b(i2, str, sceneImpl.getPosId());
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                }
            }).pz());
        }
    }

    public static void loadSplashScreenAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        boolean zA = n.qi().a(sceneImplCovert, "loadSplashScreenAd");
        sceneImplCovert.setAdStyle(4);
        sceneImplCovert.setAdNum(1);
        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b = 0;
        final a aVar = new a(b);
        aVar.BK = false;
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final com.kwad.components.core.n.kwai.b bVar = new com.kwad.components.core.n.kwai.b(sceneImplCovert);
        final C0376b c0376b = new C0376b(b);
        com.kwad.components.core.m.a.pr().pt();
        mHandler.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b.a(bVar);
            }
        }, 15000L);
        final Runnable runnable = new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // java.lang.Runnable
            public final void run() {
                C0376b.a(c0376b, true);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                KsLoadManager.SplashScreenAdListener splashScreenAdListener2 = splashScreenAdListener;
                com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.afU;
                splashScreenAdListener2.onError(fVar.errorCode, fVar.msg);
                com.kwad.components.splash.monitor.a.sp();
                com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.afU;
                com.kwad.components.splash.monitor.a.a("", false, fVar2.errorCode, fVar2.msg, sceneImplCovert.getPosId());
                com.kwad.components.core.m.a.pr().az(4);
            }
        };
        mHandler.postDelayed(runnable, com.kwad.components.ad.splashscreen.a.b.kU());
        com.kwad.components.splash.monitor.a.sp();
        com.kwad.components.splash.monitor.a.A(sceneImplCovert.getPosId());
        KsAdLoadManager.ac();
        KsAdLoadManager.a(new a.C0403a().e(bVar).aD(true).aE(zA).a(new com.kwad.components.core.n.c() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(final int i2, final String str, boolean z2) {
                if (c0376b.BL) {
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                } else {
                    b.mHandler.removeCallbacks(runnable);
                    if (!aVar.BK) {
                        com.kwad.components.splash.monitor.a.sp();
                        com.kwad.components.splash.monitor.a.a("", z2, i2, str, sceneImplCovert.getPosId());
                    }
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i2), str));
                            splashScreenAdListener.onError(i2, str);
                            if (i2 == com.kwad.sdk.core.network.f.afV.errorCode) {
                                com.kwad.components.core.m.a.pr().az(0);
                            } else {
                                com.kwad.components.core.m.a.pr().az(3);
                            }
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.n.c, com.kwad.components.core.n.b
            public final void a(@NonNull final AdResultData adResultData, boolean z2) {
                bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
                        }
                    }
                });
                if (adResultData.getAdTemplateList().size() <= 0) {
                    if (c0376b.BL) {
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                        return;
                    }
                    b.mHandler.removeCallbacks(runnable);
                    com.kwad.components.splash.monitor.a.sp();
                    com.kwad.sdk.core.network.f fVar = com.kwad.sdk.core.network.f.afS;
                    com.kwad.components.splash.monitor.a.a("", z2, fVar.errorCode, fVar.msg, sceneImplCovert.getPosId());
                    aVar.BK = true;
                    com.kwad.sdk.core.network.f fVar2 = com.kwad.sdk.core.network.f.afS;
                    a(fVar2.errorCode, fVar2.msg, z2);
                    com.kwad.components.core.m.a.pr().az(3);
                    return;
                }
                AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                adTemplate.loadDataTime = SystemClock.elapsedRealtime() - jElapsedRealtime;
                adTemplate.notNetworkRequest = z2;
                com.kwad.sdk.core.response.a.d.cb(adTemplate);
                com.kwad.components.splash.monitor.a.sp();
                com.kwad.components.splash.monitor.a.V(adTemplate);
                KSLoggerReporter.ReportClient.CORE_CONVERT.buildMethodCheck(BusinessType.AD_SPLASH, "dataReady").report();
                long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                final KsSplashScreenAdControl ksSplashScreenAdControl = new KsSplashScreenAdControl(sceneImplCovert, adResultData);
                boolean zF = SplashPreloadManager.sm().f(adResultData);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + zF);
                if (!zF) {
                    SplashPreloadManager.sm();
                    if (!SplashPreloadManager.g(adResultData)) {
                        if (c0376b.BL) {
                            com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                            return;
                        }
                        b.mHandler.removeCallbacks(runnable);
                        com.kwad.components.splash.monitor.a.sp();
                        com.kwad.components.splash.monitor.a.c(adTemplate, 5, jElapsedRealtime2);
                        aVar.BK = true;
                        a(com.kwad.sdk.core.network.f.afT.errorCode, "请求成功，但缓存未命中", z2);
                        com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                        com.kwad.components.core.m.a.pr().az(3);
                        return;
                    }
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                    int iB = SplashPreloadManager.sm().b(adResultData, true);
                    if (!c0376b.BL) {
                        b.mHandler.removeCallbacks(runnable);
                        if (iB > 0) {
                            bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.4
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        KsAdLoadManager.ac().a(ksSplashScreenAdControl);
                                        splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                                    } catch (Throwable th) {
                                        com.kwad.sdk.core.d.b.printStackTrace(th);
                                    }
                                }
                            });
                            com.kwad.components.splash.monitor.a.sp();
                            com.kwad.components.splash.monitor.a.b(adTemplate, 3, jElapsedRealtime2);
                            com.kwad.components.core.m.a.pr().az(2);
                            return;
                        }
                        com.kwad.components.splash.monitor.a.sp();
                        com.kwad.components.splash.monitor.a.c(adTemplate, 4, jElapsedRealtime2);
                        aVar.BK = true;
                        com.kwad.sdk.core.network.f fVar3 = com.kwad.sdk.core.network.f.afV;
                        a(fVar3.errorCode, fVar3.msg, z2);
                        return;
                    }
                } else if (!c0376b.BL) {
                    b.mHandler.removeCallbacks(runnable);
                    bh.runOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.b.3.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                KsAdLoadManager.ac().a(ksSplashScreenAdControl);
                                splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAdControl);
                            } catch (Throwable th) {
                                com.kwad.sdk.core.d.b.printStackTrace(th);
                            }
                        }
                    });
                    com.kwad.components.splash.monitor.a.sp();
                    com.kwad.components.splash.monitor.a.b(adTemplate, 2, jElapsedRealtime2);
                    com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                    com.kwad.components.core.m.a.pr().az(1);
                    return;
                }
                com.kwad.components.splash.monitor.a.sp();
                com.kwad.components.splash.monitor.a.c(adTemplate, 7, jElapsedRealtime2);
                com.kwad.sdk.core.d.b.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            }
        }).pz());
    }
}
