package com.kwad.components.offline.c;

import android.content.Context;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends com.kwad.components.core.o.b.a<IObiwanOfflineCompo> {
    @Override // com.kwad.components.core.o.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qA() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qB() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qC() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qD() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qE() {
        return IObiwanOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qy() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qz() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.kwad.components.core.o.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IObiwanOfflineCompo) iOfflineCompo);
    }

    static final class a {
        private static final b akc = new b(0);
    }

    private static b wv() {
        return a.akc;
    }

    private b() {
    }

    public static void aF(Context context) {
        wv().init(context);
    }

    @Override // com.kwad.components.core.o.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.aAw)).booleanValue();
    }

    private void a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.c.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    final com.kwad.components.offline.c.a aVar = new com.kwad.components.offline.c.a(iObiwanOfflineCompo);
                    com.kwad.sdk.components.d.a(com.kwad.components.core.o.a.d.a.class, aVar);
                    com.kwad.sdk.core.d.c.a(new c(aVar.getLog()));
                    b.this.qx();
                    h.b(new h.a() { // from class: com.kwad.components.offline.c.b.1.1
                        @Override // com.kwad.components.core.request.h.a
                        public final void ss() {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.h.a
                        public final void d(SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        private void updateConfigs() {
                            com.kwad.sdk.core.d.c.a(e.a(com.kwad.sdk.core.config.c.aAw) ? new c(aVar.getLog()) : null);
                            aVar.updateConfigs();
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                b.this.aJ(i);
            }
        });
    }
}
