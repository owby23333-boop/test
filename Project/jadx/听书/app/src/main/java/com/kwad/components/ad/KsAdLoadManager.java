package com.kwad.components.ad;

import android.content.Context;
import com.kwad.components.ad.adbit.c;
import com.kwad.components.core.c.d;
import com.kwad.components.core.c.g;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.l;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class KsAdLoadManager {
    private volatile boolean bA;

    /* synthetic */ KsAdLoadManager(byte b) {
        this();
    }

    private KsAdLoadManager() {
        this.bA = false;
    }

    enum Holder {
        INSTANCE;

        private final KsAdLoadManager mInstance = new KsAdLoadManager(0);

        Holder() {
        }
    }

    public static KsAdLoadManager M() {
        return Holder.INSTANCE.mInstance;
    }

    public final void a(com.kwad.components.core.request.model.a aVar) {
        if (!l.Cf().CG()) {
            com.kwad.components.core.request.model.a.a(aVar, e.aEn.errorCode, e.aEn.msg, true);
            return;
        }
        if (c.c(aVar) || b(aVar)) {
            return;
        }
        if (!this.bA) {
            N();
            this.bA = true;
        }
        d.od().d(aVar);
    }

    private static void N() {
        boolean zGt = com.kwad.sdk.core.config.e.Gt();
        com.kwad.sdk.core.d.c.d("AdLoadManager", "reportInstallerCheckRecord isInstallerCheckEnable: " + zGt);
        if (zGt) {
            Context context = ServiceProvider.getContext();
            try {
                com.kwad.components.ad.j.b.ak(context);
                com.kwad.components.ad.j.b.al(context);
            } catch (Throwable th) {
                com.kwad.sdk.crash.b.n(th);
            }
        }
    }

    private static boolean b(com.kwad.components.core.request.model.a aVar) {
        try {
            com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
            return false;
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
            return false;
        }
    }

    public final synchronized <T> void b(List<T> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            g.om().add(it.next());
        }
    }

    public final synchronized <T> void a(T t) {
        g.om().add(t);
    }
}
