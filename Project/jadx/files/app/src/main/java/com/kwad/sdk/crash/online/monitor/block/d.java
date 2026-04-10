package com.kwad.sdk.crash.online.monitor.block;

import java.util.Random;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private static com.kwad.sdk.crash.online.monitor.kwai.a aru;

    public static com.kwad.sdk.crash.online.monitor.kwai.a Af() {
        return aru;
    }

    public static boolean Ag() {
        com.kwad.sdk.crash.online.monitor.kwai.a aVar = aru;
        return aVar != null && aVar.Aj();
    }

    public static void d(com.kwad.sdk.crash.online.monitor.kwai.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.Am()) {
                com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.Ad()) {
                com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            aru = aVar;
            boolean zBe = a.be(true);
            com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "hasTenBlockHook:" + zBe);
            if (aVar.ahM < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.Ak() && zBe) {
                BlockInjector.b(aVar);
            }
            if (aVar.Al()) {
                boolean zBf = a.bf(false);
                com.kwad.sdk.core.d.b.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + zBf);
                if (zBf) {
                    BlockInjector.tryProxyOtherOutput(aVar);
                }
            }
        } catch (Throwable th) {
            try {
                com.kwad.sdk.crash.b.f(th);
            } catch (Exception unused) {
            }
        }
    }
}
