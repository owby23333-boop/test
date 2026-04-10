package com.kwad.sdk.core.report;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes4.dex */
public class g extends b<n, f> {
    private static volatile boolean aGw;
    private static volatile g aGx;
    private static r<n, f> aGy;

    private g() {
    }

    private static g Is() {
        if (aGx == null) {
            synchronized (g.class) {
                if (aGx == null) {
                    aGx = new g();
                }
            }
        }
        aGx.checkInit();
        return aGx;
    }

    public static void a(n nVar) {
        a(nVar, false);
    }

    public static void a(n nVar, boolean z) {
        Is().b(nVar, z);
    }

    private void b(final n nVar, boolean z) {
        if (nVar == null || !aGw) {
            return;
        }
        if (z || ah(nVar.actionType)) {
            aGx.b(new k<n>() { // from class: com.kwad.sdk.core.report.g.1
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* JADX INFO: renamed from: It, reason: merged with bridge method [inline-methods] */
                public n Io() {
                    return nVar.Iv();
                }
            });
        } else {
            aGx.a(new k<n>() { // from class: com.kwad.sdk.core.report.g.2
                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.report.k
                /* JADX INFO: renamed from: It, reason: merged with bridge method [inline-methods] */
                public n Io() {
                    return nVar.Iv();
                }
            });
        }
    }

    private static boolean ah(long j) {
        s sVar = (s) ServiceProvider.get(s.class);
        return sVar != null && sVar.ah(j);
    }

    private synchronized void checkInit() {
        if (aGw) {
            return;
        }
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return;
        }
        com.kwad.sdk.service.a.h hVar = (com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class);
        if (hVar == null) {
            return;
        }
        Context context = fVar.getContext();
        if (context == null) {
            return;
        }
        int iAO = hVar.aO(context);
        j(context, iAO);
        t.init(context);
        t.IB();
        com.kwad.sdk.core.d.c.d("BatchReporter", "cache type = " + iAO);
        if (iAO == 2) {
            a(q.bD(context));
        }
        aGw = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public f a(n nVar) {
        r<n, f> rVar = aGy;
        if (rVar != null) {
            return (f) rVar.Iz();
        }
        return (f) super.a(nVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.report.b
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public f A(List<n> list) {
        r<n, f> rVar = aGy;
        if (rVar != null) {
            return (f) rVar.IA();
        }
        String strD = D(list);
        if (!TextUtils.isEmpty(strD)) {
            return new f(strD);
        }
        return new f(list);
    }

    private static String D(List<n> list) {
        if (list.get(0) == null || TextUtils.isEmpty(list.get(0).aHM)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(",\"actionList\":[");
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().aHM).append(',');
        }
        int length = sb.length();
        sb.replace(length - 1, length, "]");
        return sb.toString();
    }

    @Override // com.kwad.sdk.core.report.b
    protected final Runnable a(Context context, l<n> lVar, AtomicInteger atomicInteger) {
        Runnable runnableIy;
        r<n, f> rVar = aGy;
        return (rVar == null || (runnableIy = rVar.Iy()) == null) ? super.a(context, lVar, atomicInteger) : runnableIy;
    }
}
