package com.kwad.components.offline.b;

import android.content.Context;
import com.kwad.components.core.o.b.a.l;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompoInitConfig;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.core.soloader.ISoLoader;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements IAdWaynePlayerOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new l(IAdWaynePlayerOfflineCompo.PACKAGE_NAME);
    }

    @Override // com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompoInitConfig
    public final ISoLoader soLoader() {
        return new ISoLoader() { // from class: com.kwad.components.offline.b.c.1
            @Override // com.kwad.components.offline.api.core.soloader.ISoLoader
            public final void loadSo(Context context, SoLoadListener soLoadListener) {
                com.kwad.components.offline.b.a.a.a(context, soLoadListener);
            }
        };
    }
}
