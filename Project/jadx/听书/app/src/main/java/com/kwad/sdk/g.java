package com.kwad.sdk;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class g {
    private static AdHttpProxy asa;

    public static AdHttpProxy AI() {
        AdHttpProxy adHttpProxy = asa;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.oz.booleanValue()) {
            return AJ();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.HD() != null) {
                asa = new com.kwad.sdk.core.network.c.b();
            } else {
                asa = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            asa = new com.kwad.sdk.core.network.c.a();
        }
        return asa;
    }

    private static AdHttpProxy AJ() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.c.b() : new com.kwad.sdk.core.network.c.a();
    }
}
