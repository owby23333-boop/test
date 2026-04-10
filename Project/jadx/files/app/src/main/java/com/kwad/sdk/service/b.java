package com.kwad.sdk.service;

import com.kwad.sdk.service.kwai.d;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static void gatherException(Throwable th) {
        d dVar = (d) ServiceProvider.get(d.class);
        if (dVar != null) {
            dVar.gatherException(th);
        }
    }
}
