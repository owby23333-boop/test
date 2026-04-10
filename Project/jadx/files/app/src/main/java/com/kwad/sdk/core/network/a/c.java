package com.kwad.sdk.core.network.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static b wK() {
        f fVar = (f) ServiceProvider.get(f.class);
        return (fVar == null || !fVar.sV()) ? new a() : new d();
    }
}
