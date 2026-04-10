package com.kwad.components.offline.adLive;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.e;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.c;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.core.offline.init.a {

    /* JADX INFO: renamed from: com.kwad.components.offline.adLive.a$a, reason: collision with other inner class name */
    static final class C0423a {
        private static final a WY = new a(0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static void au(Context context) {
        sc().init(context);
    }

    private static a sc() {
        return C0423a.WY;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(final Context context, ClassLoader classLoader) {
        IAdLiveOfflineCompo iAdLiveOfflineCompo = (IAdLiveOfflineCompo) a(classLoader, IAdLiveOfflineCompo.IMPL);
        if (iAdLiveOfflineCompo == null) {
            com.kwad.sdk.core.d.b.d("AdLiveInitModule", "onPluginLoaded components is null");
            return false;
        }
        com.kwad.sdk.core.d.b.d(getTag(), "onOfflineComponentsLoaded components classLoader: " + iAdLiveOfflineCompo.getClass().getClassLoader());
        final AdLiveCompoImpl adLiveCompoImpl = new AdLiveCompoImpl(iAdLiveOfflineCompo);
        c.a(com.kwad.components.core.offline.api.kwai.a.class, adLiveCompoImpl);
        iAdLiveOfflineCompo.initReal(context, ServiceProvider.CF(), new b());
        final SdkConfigData sdkConfigDataUG = d.uG();
        if (sdkConfigDataUG != null) {
            adLiveCompoImpl.onConfigRefresh(context, sdkConfigDataUG.toJson());
        }
        e.a(new e.a() { // from class: com.kwad.components.offline.adLive.a.1
            @Override // com.kwad.components.core.n.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
            }

            @Override // com.kwad.components.core.n.e.a
            public final void oi() {
                SdkConfigData sdkConfigData = sdkConfigDataUG;
                if (sdkConfigData != null) {
                    adLiveCompoImpl.onConfigRefresh(context, sdkConfigData.toJson());
                }
            }
        });
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        String str = "isEnabled: " + d.uB();
        return d.uB();
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String od() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String oe() {
        return "3.3.38";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String of() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.38-9333b7551-254.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String og() {
        return "a09a59fe64b891242b89622bced8933b";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String oh() {
        return "ks_live_ed677b1b2";
    }
}
