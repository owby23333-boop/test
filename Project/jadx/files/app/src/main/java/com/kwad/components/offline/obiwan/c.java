package com.kwad.components.offline.obiwan;

import com.kwad.components.core.offline.init.kwai.i;
import com.kwad.components.offline.api.core.api.IOfflineCompoWrapper;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.utils.au;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements IObiwanOfflineCompoInitConfig {
    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final String getLogDirPath() {
        return au.cT(KsAdSDKImpl.get().getContext()).getAbsolutePath();
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final String getLogObiwanData() {
        return d.getLogObiwanData();
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final long getLogObiwanStorageQuota() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return d.a(com.kwad.sdk.core.config.c.acW);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final boolean isLogObiwanEnableNow() {
        return d.a(com.kwad.sdk.core.config.c.acU);
    }

    @Override // com.kwad.components.offline.api.obiwan.IObiwanOfflineCompoInitConfig
    public final boolean isLogObiwanRecordAll() {
        return d.a(com.kwad.sdk.core.config.c.acV);
    }

    @Override // com.kwad.components.offline.api.IOfflineCompoInitConfig
    public final IOfflineCompoWrapper wrapper() {
        return new i(IObiwanOfflineCompo.PACKAGE_NAME);
    }
}
