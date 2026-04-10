package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static AdHttpProxy Ya;

    @NonNull
    public static AdHttpProxy sq() {
        AdHttpProxy adHttpProxy = Ya;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            return sr();
        }
        try {
            Ya = com.kwad.sdk.core.network.kwai.c.ww() != null ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
        } catch (Throwable unused) {
            Ya = new com.kwad.sdk.core.network.b.a();
        }
        return Ya;
    }

    private static AdHttpProxy sr() {
        com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.b.b() : new com.kwad.sdk.core.network.b.a();
    }
}
