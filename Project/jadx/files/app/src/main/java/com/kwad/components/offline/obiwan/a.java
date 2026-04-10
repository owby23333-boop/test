package com.kwad.components.offline.obiwan;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.core.n.e;
import com.kwad.components.core.offline.api.obiwan.ObiwanComponents;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.kwad.components.core.offline.init.a {

    /* JADX INFO: renamed from: com.kwad.components.offline.obiwan.a$a, reason: collision with other inner class name */
    static final class C0424a {
        private static final a Xk = new a(0);
    }

    private a() {
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static void au(Context context) {
        sf().init(context);
    }

    private static a sf() {
        return C0424a.Xk;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean b(Context context, ClassLoader classLoader) {
        IObiwanOfflineCompo iObiwanOfflineCompo = (IObiwanOfflineCompo) a(classLoader, IObiwanOfflineCompo.IMPL);
        if (iObiwanOfflineCompo == null) {
            return false;
        }
        final ObiwanComponentsImpl obiwanComponentsImpl = new ObiwanComponentsImpl(iObiwanOfflineCompo);
        com.kwad.sdk.components.c.a(ObiwanComponents.class, obiwanComponentsImpl);
        iObiwanOfflineCompo.initReal(context, ServiceProvider.CF(), new c());
        com.kwad.sdk.core.d.b.a(new b(obiwanComponentsImpl.getLog()));
        e.a(new e.a() { // from class: com.kwad.components.offline.obiwan.a.1
            private void updateConfigs() {
                com.kwad.sdk.core.d.b.a(d.a(com.kwad.sdk.core.config.c.acU) ? new b(obiwanComponentsImpl.getLog()) : null);
                obiwanComponentsImpl.updateConfigs();
            }

            @Override // com.kwad.components.core.n.e.a
            public final void a(@NonNull SdkConfigData sdkConfigData) {
                updateConfigs();
            }

            @Override // com.kwad.components.core.n.e.a
            public final void oi() {
                updateConfigs();
            }
        });
        return true;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final boolean isEnabled() {
        return d.a(com.kwad.sdk.core.config.c.acU);
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String od() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String oe() {
        return "3.3.34";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String of() {
        return "https://static.yximgs.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.34-773cd6541-80.zip";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String og() {
        return "9d1492da0ba2fb7f75bd3784f410da4b";
    }

    @Override // com.kwad.components.core.offline.init.a
    public final String oh() {
        return "ks_obiwan_773cd6541";
    }
}
