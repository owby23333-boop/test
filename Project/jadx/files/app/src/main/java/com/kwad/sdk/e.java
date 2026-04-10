package com.kwad.sdk;

import android.content.Context;
import com.kwad.components.core.d.b.a;
import com.kwad.sdk.core.config.item.n;
import com.kwad.sdk.core.imageloader.ImageLoaderProxy;
import com.kwad.sdk.core.network.j;
import com.kwad.sdk.core.network.k;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.report.KSLoggerReporter;
import com.kwad.sdk.core.report.v;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.h;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    static class a implements com.kwad.sdk.service.kwai.a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.a
        public final int g(Context context, String str) {
            return com.kwad.sdk.core.download.kwai.b.g(context, str);
        }

        @Override // com.kwad.sdk.service.kwai.a
        public final void g(Context context, AdTemplate adTemplate) {
            com.kwad.components.core.d.b.a.a(new a.C0395a(context).J(adTemplate).an(true));
        }
    }

    static class b implements com.kwad.sdk.core.download.b {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.download.b
        public final void b(int i2, AdTemplate adTemplate) {
            if (i2 != 1) {
                return;
            }
            com.kwad.sdk.core.report.a.f(adTemplate, (JSONObject) null);
        }
    }

    static class c implements com.kwad.sdk.service.kwai.e {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean Z(AdTemplate adTemplate) {
            com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            return aVar != null && aVar.sa();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getApiVersion() {
            return KsAdSDKImpl.get().getApiVersion();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final int getApiVersionCode() {
            return KsAdSDKImpl.get().getApiVersionCode();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getAppName() {
            return KsAdSDKImpl.get().getAppName();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final Context getContext() {
            return KsAdSDKImpl.get().getContext();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean getIsExternal() {
            return KsAdSDKImpl.get().getIsExternal();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final String getSDKVersion() {
            return KsAdSDKImpl.get().getSDKVersion();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean hasInitFinish() {
            return KsAdSDKImpl.get().hasInitFinish();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean hasLiveCompoReady() {
            com.kwad.components.core.offline.api.kwai.a aVar = (com.kwad.components.core.offline.api.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.core.offline.api.kwai.a.class);
            if (aVar != null) {
                return aVar.hasLiveCompoReady();
            }
            return false;
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean isPersonalRecommend() {
            return KsAdSDKImpl.get().isPersonalRecommend();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final boolean isProgrammaticRecommend() {
            return KsAdSDKImpl.get().isProgrammaticRecommend();
        }

        @Override // com.kwad.sdk.service.kwai.e
        public final com.kwad.sdk.core.response.a.e sb() {
            com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
            if (aVar != null) {
                return aVar.sb();
            }
            return null;
        }
    }

    static class d implements com.kwad.sdk.service.kwai.f {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean D(long j2) {
            return com.kwad.sdk.core.config.d.D(j2);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean aO(String str) {
            return com.kwad.sdk.core.config.a.aO(str);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int av(Context context) {
            return com.kwad.sdk.core.config.item.c.aS(context);
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getAppId() {
            return KsAdSDKImpl.get().getAppId();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String getUserAgent() {
            return com.kwad.sdk.core.config.d.getUserAgent();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sM() {
            return com.kwad.sdk.core.config.d.sM();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sN() {
            return com.kwad.sdk.core.config.d.sN();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sO() {
            return com.kwad.sdk.core.config.d.sO();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sP() {
            return com.kwad.sdk.core.config.d.sP();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String sQ() {
            return com.kwad.sdk.core.config.d.sQ();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final String sR() {
            return com.kwad.sdk.core.config.d.sR();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final List<String> sS() {
            return com.kwad.sdk.core.config.d.sS();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sT() {
            return com.kwad.sdk.core.config.d.sT();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sU() {
            return com.kwad.sdk.core.config.d.sU();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sV() {
            return com.kwad.sdk.core.config.d.uL();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sW() {
            return com.kwad.sdk.core.config.d.sW();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean sX() {
            return com.kwad.sdk.core.config.d.sX();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int sY() {
            return com.kwad.sdk.core.config.d.sY();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final int sZ() {
            return com.kwad.sdk.core.config.d.sZ();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean ta() {
            return com.kwad.sdk.core.config.d.ta();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final double tb() {
            return com.kwad.sdk.core.config.d.tb();
        }

        @Override // com.kwad.sdk.service.kwai.f
        public final boolean tc() {
            return com.kwad.sdk.core.config.d.tc();
        }
    }

    public static void sH() {
        byte b2 = 0;
        ServiceProvider.put(com.kwad.sdk.service.kwai.e.class, new c(b2));
        ServiceProvider.put(com.kwad.sdk.service.kwai.f.class, new d(b2));
        ServiceProvider.put(com.kwad.sdk.service.kwai.d.class, new com.kwad.sdk.service.kwai.d() { // from class: com.kwad.sdk.e.1
            @Override // com.kwad.sdk.service.kwai.d
            public final void gatherException(Throwable th) {
                com.kwad.components.core.c.a.b(th);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.kwai.c.class, new com.kwad.sdk.service.kwai.c() { // from class: com.kwad.sdk.e.2
            @Override // com.kwad.sdk.service.kwai.c
            public final void a(boolean z2, String str, String str2, String str3) {
                com.kwad.sdk.core.diskcache.a.a.vE().bt(str);
            }

            @Override // com.kwad.sdk.service.kwai.c
            public final File aN(String str) {
                return com.kwad.sdk.core.diskcache.a.a.vE().aN(str);
            }
        });
        ServiceProvider.put(h.class, new h() { // from class: com.kwad.sdk.e.3
            @Override // com.kwad.sdk.service.kwai.h
            public final boolean pD() {
                com.kwad.components.core.o.b.pC();
                return com.kwad.components.core.o.b.pD();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final int pE() {
                com.kwad.components.core.o.b.pC();
                return com.kwad.components.core.o.b.pE();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final int pF() {
                return com.kwad.components.core.o.b.pC().pF();
            }

            @Override // com.kwad.sdk.service.kwai.h
            public final InputStream wrapInputStream(InputStream inputStream) {
                com.kwad.components.core.o.b.pC();
                return com.kwad.components.core.o.b.wrapInputStream(inputStream);
            }
        });
        ServiceProvider.put(l.class, new l() { // from class: com.kwad.sdk.e.4
            @Override // com.kwad.sdk.core.network.l
            public final void a(j jVar) {
                KSLoggerReporter.c(jVar);
            }

            @Override // com.kwad.sdk.core.network.l
            public final void a(k kVar) {
                KSLoggerReporter.c(kVar);
            }

            @Override // com.kwad.sdk.core.network.l
            public final com.kwad.sdk.core.b sI() {
                return com.kwad.components.core.n.kwai.c.pB();
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.kwai.g.class, ImageLoaderProxy.INSTANCE);
        ServiceProvider.put(com.kwad.sdk.service.kwai.b.class, new com.kwad.sdk.service.kwai.b() { // from class: com.kwad.sdk.e.5
            @Override // com.kwad.sdk.service.kwai.b
            public final void Y(AdTemplate adTemplate) {
                com.kwad.components.core.m.a.pr().f(adTemplate, 21007);
            }

            @Override // com.kwad.sdk.service.kwai.b
            public final void n(String str, String str2) {
                com.kwad.sdk.core.d.b.e("image_load_failed_info", "errorMsg:" + str2 + "\nurl:" + str);
            }
        });
        ServiceProvider.put(v.class, new v() { // from class: com.kwad.sdk.e.6
            @Override // com.kwad.sdk.core.report.v
            public final boolean C(long j2) {
                n nVar = com.kwad.sdk.core.config.c.abU;
                return n.C(j2);
            }

            @Override // com.kwad.sdk.core.report.v
            public final int rY() {
                com.kwad.components.kwai.kwai.a aVar = (com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class);
                if (aVar != null) {
                    return aVar.rY();
                }
                return 0;
            }

            @Override // com.kwad.sdk.core.report.v
            public final int sJ() {
                return com.kwad.sdk.core.config.d.sJ();
            }
        });
        ServiceProvider.put(com.kwad.sdk.core.download.b.class, new b(b2));
        ServiceProvider.put(com.kwad.sdk.core.video.kwai.f.class, new com.kwad.sdk.core.video.kwai.f() { // from class: com.kwad.sdk.e.7
            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean rZ() {
                return ((com.kwad.components.kwai.kwai.a) com.kwad.sdk.components.c.f(com.kwad.components.kwai.kwai.a.class)).rZ();
            }

            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean sK() {
                return com.kwad.sdk.core.config.d.sK();
            }

            @Override // com.kwad.sdk.core.video.kwai.f
            public final boolean sL() {
                return com.kwad.sdk.core.config.d.sL();
            }
        });
        ServiceProvider.put(com.kwad.sdk.utils.a.b.class, new com.kwad.sdk.utils.a.b() { // from class: com.kwad.sdk.e.8
            @Override // com.kwad.sdk.utils.a.b
            public final void a(com.kwad.sdk.utils.a.a aVar) {
                if (aVar == null) {
                    return;
                }
                KSLoggerReporter.b(aVar);
            }
        });
        ServiceProvider.put(com.kwad.sdk.service.kwai.a.class, new a(b2));
    }
}
