package com.kwad.components.core.request;

import android.content.Context;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bg;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class h {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean WZ = false;
    private static final List<a> Xa = new CopyOnWriteArrayList();

    public interface a {
        void d(SdkConfigData sdkConfigData);

        void ss();
    }

    public interface b extends a {
        void st();
    }

    static /* synthetic */ boolean access$102(boolean z) {
        WZ = true;
        return true;
    }

    public static synchronized void a(a aVar) {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "init config");
        if (sHasInit.get()) {
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "config request manager has init");
        } else {
            Xa.add(aVar);
            com.kwad.sdk.utils.h.execute(new bg() { // from class: com.kwad.components.core.request.h.1
                @Override // com.kwad.sdk.utils.bg
                public final void doTask() {
                    Context contextPp = ServiceProvider.Pp();
                    ag.l(contextPp, ag.cV(contextPp) + 1);
                    com.kwad.sdk.core.config.e.bs(contextPp);
                    h.so();
                    h.sn();
                }
            });
        }
    }

    public static void b(a aVar) {
        try {
            Xa.add(aVar);
            if (com.kwad.sdk.core.config.e.isLoaded()) {
                aVar.ss();
            }
            if (WZ) {
                aVar.d(com.kwad.sdk.core.config.e.Fw());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void sn() {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "requestConfig");
        new com.kwad.sdk.core.network.l<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.2
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return aD(str);
            }

            private static SdkConfigData aD(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    ag.am(ServiceProvider.Pp(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return sdkConfigData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: sr, reason: merged with bridge method [inline-methods] */
            public g createRequest() {
                GlobalThreadPools.Jy().execute(new Runnable() { // from class: com.kwad.components.core.request.h.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.core.request.model.e.IO();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return new g();
            }
        }.request(new o<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }

            private static void c(SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.d.c.T("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bq(ServiceProvider.Pp());
                    com.kwad.sdk.core.config.e.f(sdkConfigData);
                    h.access$102(true);
                    h.a(sdkConfigData);
                    af.Qm();
                    af.Qg();
                    ag.l(ServiceProvider.Pp(), 0);
                    if (ag.Qr() != com.kwad.sdk.core.config.e.Gk()) {
                        ag.f(ServiceProvider.Pp(), com.kwad.sdk.core.config.e.Gk());
                    }
                    h.sHasInit.set(true);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(g gVar, int i, String str) {
                super.onError(gVar, i, str);
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                h.m(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void so() {
        Iterator<a> it = Xa.iterator();
        while (it.hasNext()) {
            try {
                it.next().ss();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(SdkConfigData sdkConfigData) {
        Iterator<a> it = Xa.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m(int i, String str) {
        for (a aVar : Xa) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).st();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
