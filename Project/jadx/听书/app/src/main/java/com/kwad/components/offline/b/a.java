package com.kwad.components.offline.b;

import android.content.Context;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: classes4.dex */
public class a implements com.kwad.components.core.o.a.a.a {
    private final IAdWaynePlayerOfflineCompo ajF;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public a(IAdWaynePlayerOfflineCompo iAdWaynePlayerOfflineCompo) {
        this.ajF = iAdWaynePlayerOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class<a> getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.ajF.priority();
    }

    @Override // com.kwad.components.core.o.a.a.a
    public final boolean qt() {
        return this.ajF.getState() == IAdWaynePlayerOfflineCompo.AdWaynePlayerState.READY;
    }

    @Override // com.kwad.components.core.o.a.a.a
    public final IAdWaynePlayerPlayModule getAdWaynePlayerPlayModule(String str, boolean z) {
        if (!qt()) {
            return null;
        }
        try {
            return this.ajF.getAdWaynePlayerPlayModule(str, z);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
            return null;
        }
    }
}
