package com.kwad.components.offline.a;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public final class b extends com.kwad.components.core.o.b.a<IAdLiveOfflineCompo> {
    @Override // com.kwad.components.core.o.b.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qA() {
        return "3.3.76";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qB() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.76-089e702802-65.zip";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qC() {
        return "611820df0455699043f4a75e86ea0e69";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qD() {
        return "ks_live_3376";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qE() {
        return IAdLiveOfflineCompo.IMPL;
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qy() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.o.b.a
    public final String qz() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    /* synthetic */ b(byte b) {
        this();
    }

    @Override // com.kwad.components.core.o.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z, IOfflineCompo iOfflineCompo) {
        a(context, (IAdLiveOfflineCompo) iOfflineCompo);
    }

    static final class a {
        private static final b ajw = new b(0);
    }

    private static b wq() {
        return a.ajw;
    }

    private b() {
    }

    public static void aF(Context context) {
        wq().init(context);
    }

    @Override // com.kwad.components.core.o.b.a
    public final boolean isEnabled() {
        return ((Boolean) e.b(com.kwad.sdk.core.config.c.azT)).booleanValue();
    }

    private void a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    d.a(com.kwad.components.core.o.a.b.a.class, new com.kwad.components.offline.a.a(iAdLiveOfflineCompo));
                    b.this.qx();
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
