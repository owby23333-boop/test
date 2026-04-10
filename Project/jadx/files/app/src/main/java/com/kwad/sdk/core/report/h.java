package com.kwad.sdk.core.report;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class h extends b<q, g> {
    private static volatile boolean Ok = false;
    private static volatile h ahP;
    private static u<q, g> ahQ;

    private h() {
    }

    private static boolean C(long j2) {
        v vVar = (v) ServiceProvider.get(v.class);
        return vVar != null && vVar.C(j2);
    }

    public static void a(@NonNull q qVar) {
        a(qVar, false);
    }

    public static void a(@NonNull q qVar, boolean z2) {
        xi().b(qVar, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g a(q qVar) {
        u<q, g> uVar = ahQ;
        return (g) (uVar != null ? uVar.xr() : super.a(qVar));
    }

    private void b(final q qVar, boolean z2) {
        if (qVar == null || !Ok) {
            return;
        }
        if (z2 || C(qVar.aij)) {
            ahP.b(new m<q>() { // from class: com.kwad.sdk.core.report.h.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.m
                /* JADX INFO: renamed from: xj, reason: merged with bridge method [inline-methods] */
                public q xf() {
                    return qVar.xn();
                }
            });
        } else {
            ahP.a(new m<q>() { // from class: com.kwad.sdk.core.report.h.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.m
                /* JADX INFO: renamed from: xj, reason: merged with bridge method [inline-methods] */
                public q xf() {
                    return qVar.xn();
                }
            });
        }
    }

    private synchronized void checkInit() {
        if (Ok) {
            return;
        }
        com.kwad.sdk.service.kwai.e eVar = (com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class);
        if (eVar == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            return;
        }
        Context context = eVar.getContext();
        if (context == null) {
            return;
        }
        int iAv = fVar.av(context);
        i(context, iAv);
        w.init(context);
        w.xt();
        com.kwad.sdk.core.d.b.d("BatchReporter", "cache type = " + iAv);
        if (iAv == 2) {
            a(t.bg(context));
        }
        Ok = true;
    }

    private static g r(List<q> list) {
        u<q, g> uVar = ahQ;
        return uVar != null ? (g) uVar.xs() : new g(list);
    }

    private static h xi() {
        if (ahP == null) {
            synchronized (h.class) {
                if (ahP == null) {
                    ahP = new h();
                }
            }
        }
        ahP.checkInit();
        return ahP;
    }

    @Override // com.kwad.sdk.core.report.b
    protected final Runnable a(Context context, n<q> nVar, AtomicInteger atomicInteger) {
        Runnable runnableXq;
        u<q, g> uVar = ahQ;
        return (uVar == null || (runnableXq = uVar.xq()) == null) ? super.a(context, nVar, atomicInteger) : runnableXq;
    }

    @Override // com.kwad.sdk.core.report.b
    protected final /* synthetic */ com.kwad.sdk.core.network.g p(List list) {
        return r(list);
    }
}
