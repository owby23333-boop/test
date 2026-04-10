package com.kwad.sdk.commercial.d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class d {
    private static void a(final SceneImpl sceneImpl, final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.sdk.commercial.d.d.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.APM_LOG).i(0.001d).b(com.kwad.sdk.commercial.d.ct(sceneImpl.getAdStyle())).O("ad_convert_method_call", "method_name").z(aVar));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    public static void c(SceneImpl sceneImpl) {
        try {
            a(sceneImpl, b.DV().cJ("loadRequest").cB(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(SceneImpl sceneImpl, String str) {
        try {
            a(sceneImpl, b.DV().cJ("requestStart").cB(sceneImpl.getAdNum()).cK(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, String str, String str2) {
        try {
            a(sceneImpl, b.DV().cJ("requestFinish").cB(sceneImpl.getAdNum()).cK(str).cL(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, int i) {
        try {
            a(sceneImpl, b.DV().cJ("dataReady").cB(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(int i, int i2, String str, String str2) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.DS().cF(ILoggerReporter.Category.ERROR_LOG).i(1.0d).b(com.kwad.sdk.commercial.d.ct(i)).O("ad_convert_method_call", "method_name").z(b.DV().cJ("requestError").cK(str2).setErrorCode(com.kwad.sdk.commercial.d.cu(i2)).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
