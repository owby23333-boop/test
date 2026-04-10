package com.kwad.components.offline.c;

import android.content.Context;
import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;

/* JADX INFO: loaded from: classes4.dex */
public class a implements com.kwad.components.core.o.a.d.a {
    private final IObiwanOfflineCompo ajX;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public a(IObiwanOfflineCompo iObiwanOfflineCompo) {
        this.ajX = iObiwanOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.ajX.priority();
    }

    public final void updateConfigs() {
        this.ajX.updateConfigs();
    }

    public final IObiwanLogcat getLog() {
        return this.ajX.getLog();
    }
}
