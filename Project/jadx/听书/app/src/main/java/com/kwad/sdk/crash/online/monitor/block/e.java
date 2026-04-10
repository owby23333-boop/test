package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    private static com.kwad.sdk.crash.online.monitor.a.a aPR;

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.LT()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.LK()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            aPR = aVar;
            boolean zBH = a.bH(true);
            com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + zBH);
            if (aVar.avY < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.LR() && zBH) {
                c.b(aVar);
            }
            if (aVar.LS()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + a.bI(false));
            }
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Exception unused) {
            }
        }
    }

    public static com.kwad.sdk.crash.online.monitor.a.a LM() {
        return aPR;
    }

    public static boolean LN() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = aPR;
        return aVar != null && aVar.LQ();
    }
}
