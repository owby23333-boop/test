package com.kwad.sdk.core.network.b;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static b HU() {
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && hVar.BF()) {
            return new d();
        }
        return new a();
    }
}
