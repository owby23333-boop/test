package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.request.model.a;
import com.kwad.components.core.t.n;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.bw;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final Handler iK = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    static class C0308b {
        private volatile boolean Fb;

        private C0308b() {
            this.Fb = false;
        }

        /* synthetic */ C0308b(byte b) {
            this();
        }

        static /* synthetic */ boolean a(C0308b c0308b, boolean z) {
            c0308b.Fb = true;
            return true;
        }
    }

    static class a {
        private volatile boolean Fa;

        private a() {
            this.Fa = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void loadSplashScreenAd(KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.d.d.c(sceneImplCovert);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.u(sceneImplCovert.getPosId());
        boolean zB = n.tn().b(sceneImplCovert, "loadSplashScreenAd");
        sceneImplCovert.setAdStyle(4);
        sceneImplCovert.setAdNum(1);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b = 0;
        final a aVar = new a(b);
        aVar.Fa = false;
        final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(sceneImplCovert);
        final C0308b c0308b = new C0308b(b);
        com.kwad.components.core.p.a.se().sg();
        Handler handler = iK;
        handler.postDelayed(new bg() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                b.a(impInfo);
            }
        }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        final bg bgVar = new bg() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                C0308b.a(c0308b, true);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                splashScreenAdListener.onError(com.kwad.sdk.core.network.e.aEs.errorCode, com.kwad.sdk.core.network.e.aEs.msg);
                com.kwad.components.ad.splashscreen.monitor.b.lZ();
                com.kwad.components.ad.splashscreen.monitor.b.c(false, com.kwad.sdk.core.network.e.aEs.errorCode, com.kwad.sdk.core.network.e.aEs.msg, sceneImplCovert.getPosId());
                com.kwad.components.core.p.a.se().aS(4);
            }
        };
        int iA = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.FM);
        if (iA < 0) {
            iA = 5000;
        }
        handler.postDelayed(bgVar, iA);
        final long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.f(sceneImplCovert.getPosId(), jElapsedRealtime3);
        SplashPreloadManager.lD().a(sceneImplCovert.getPosId(), 2);
        List<String> listLE = SplashPreloadManager.lD().lE();
        List<Integer> listI = SplashPreloadManager.lD().i(listLE);
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.a(sceneImplCovert.getPosId(), listLE, listI);
        KsAdLoadManager.M().a(new a.C0351a().e(impInfo).aL(true).aM(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i, final String str, boolean z) {
                if (!c0308b.Fb) {
                    b.iK.removeCallbacks(bgVar);
                    if (!aVar.Fa && i != com.kwad.sdk.core.network.e.aEq.errorCode) {
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.b(z, i, str, sceneImplCovert.getPosId());
                        com.kwad.components.ad.splashscreen.monitor.b.lZ();
                        com.kwad.components.ad.splashscreen.monitor.b.c(z, i, str, sceneImplCovert.getPosId());
                    }
                    bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                            splashScreenAdListener.onError(i, str);
                            if (i == com.kwad.sdk.core.network.e.aEt.errorCode) {
                                com.kwad.components.core.p.a.se().aS(0);
                            } else {
                                com.kwad.components.core.p.a.se().aS(3);
                            }
                        }
                    });
                    return;
                }
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onError isTimeOut return " + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00e3 A[Catch: all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:9:0x0061, B:11:0x006a, B:14:0x0080, B:16:0x008f, B:18:0x00a9, B:20:0x00b5, B:22:0x00cb, B:24:0x00d7, B:26:0x00e3, B:29:0x00ed, B:32:0x00fc, B:33:0x011c, B:35:0x0138, B:38:0x0147, B:39:0x0165, B:41:0x016e, B:45:0x018d, B:46:0x01a9), top: B:65:0x0061 }] */
            /* JADX WARN: Removed duplicated region for block: B:35:0x0138 A[Catch: all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:9:0x0061, B:11:0x006a, B:14:0x0080, B:16:0x008f, B:18:0x00a9, B:20:0x00b5, B:22:0x00cb, B:24:0x00d7, B:26:0x00e3, B:29:0x00ed, B:32:0x00fc, B:33:0x011c, B:35:0x0138, B:38:0x0147, B:39:0x0165, B:41:0x016e, B:45:0x018d, B:46:0x01a9), top: B:65:0x0061 }] */
            /* JADX WARN: Removed duplicated region for block: B:39:0x0165 A[Catch: all -> 0x020b, TryCatch #1 {all -> 0x020b, blocks: (B:9:0x0061, B:11:0x006a, B:14:0x0080, B:16:0x008f, B:18:0x00a9, B:20:0x00b5, B:22:0x00cb, B:24:0x00d7, B:26:0x00e3, B:29:0x00ed, B:32:0x00fc, B:33:0x011c, B:35:0x0138, B:38:0x0147, B:39:0x0165, B:41:0x016e, B:45:0x018d, B:46:0x01a9), top: B:65:0x0061 }] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v9, types: [com.kwad.components.ad.splashscreen.KsSplashScreenAdControl, com.kwad.sdk.api.KsSplashScreenAd] */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final void a(final com.kwad.sdk.core.response.model.AdResultData r19, boolean r20) {
                /*
                    Method dump skipped, instruction units count: 544
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.splashscreen.b.AnonymousClass3.a(com.kwad.sdk.core.response.model.AdResultData, boolean):void");
            }
        }).sw());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0308b c0308b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (c0308b.Fb) {
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j, j2);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        iK.removeCallbacks(runnable);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate) {
        bw.runOnUiThread(new bg() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() {
                try {
                    KsAdLoadManager.M().a(ksSplashScreenAd);
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    com.kwad.components.ad.splashscreen.monitor.a.lX().af(adTemplate);
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTrace(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z, long j) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.lZ();
        com.kwad.components.ad.splashscreen.monitor.b.c(z, com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg, j);
        aVar.Fa = true;
        dVar.a(com.kwad.sdk.core.network.e.aEq.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aEq.msg : adResultData.testErrorMsg, z);
        com.kwad.components.core.p.a.se().aS(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.p.a.se().sh();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.lZ();
            com.kwad.components.ad.splashscreen.monitor.b.v(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.M().a(new a.C0351a().e(impInfo2).aM(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void onError(int i, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.lZ();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i, str, sceneImpl.getPosId());
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void b(AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.lD().a(adResultData, false, 2));
                            com.kwad.components.ad.splashscreen.monitor.b.lZ();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - jElapsedRealtime, sceneImpl.getPosId());
                            com.kwad.components.core.p.a.se().aT(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            }).sw());
        }
    }
}
