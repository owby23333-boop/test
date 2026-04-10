package com.kwad.components.core.c;

import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.utils.bg;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements c {
    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyLocalCacheFirst";
    }

    @Override // com.kwad.components.core.c.c
    public final void d(final com.kwad.components.core.request.model.a aVar) {
        GlobalThreadPools.Jt().submit(new bg() { // from class: com.kwad.components.core.c.l.1
            @Override // com.kwad.sdk.utils.bg
            public final void doTask() throws Throwable {
                AdResultData adResultDataE = l.e(aVar);
                if (adResultDataE != null && !adResultDataE.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adResultDataE, true);
                } else {
                    n.a(aVar, new j(aVar));
                }
            }
        });
    }

    public static AdResultData e(com.kwad.components.core.request.model.a aVar) throws Throwable {
        a aVarNZ = a.nZ();
        if (aVarNZ == null) {
            return null;
        }
        int adNum = aVar.getAdNum();
        List<h> listA = aVarNZ.a(String.valueOf(aVar.getPosId()), System.currentTimeMillis() / 1000, e.x(aVar.getPosId()).oi());
        if (com.kwad.sdk.core.config.e.FW()) {
            l(listA);
        }
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        Collections.sort(listA);
        return h.k(listA.subList(0, Math.min(listA.size(), adNum)));
    }

    private static void l(List<h> list) {
        if (list == null) {
            return;
        }
        Iterator<h> it = list.iterator();
        while (it.hasNext()) {
            h next = it.next();
            if (g.om().a(next)) {
                com.kwad.sdk.core.d.c.d("StrategyLocalCacheFirst", "filterByMemCached contain: " + next.os());
                it.remove();
            }
        }
    }
}
