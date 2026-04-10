package com.kwad.components.core.internal.api;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private List<b> Ri = new CopyOnWriteArrayList();
    private boolean Rj = false;
    private boolean Rk = false;

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Ri.add(bVar);
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.Ri.remove(bVar);
    }

    public final void h(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdEnter: " + aVar + ", hadNotifiedEnter: " + this.Rk);
        if (this.Rk) {
            return;
        }
        Iterator<b> it = this.Ri.iterator();
        while (it.hasNext()) {
            it.next().c(aVar);
        }
        this.Rk = true;
    }

    public final void i(a aVar) {
        com.kwad.sdk.core.d.c.d("KsAdListenerHolder", "notifyAdExit: " + aVar + ", hadNotifiedExit: " + this.Rj);
        if (this.Rj) {
            return;
        }
        Iterator<b> it = this.Ri.iterator();
        while (it.hasNext()) {
            it.next().d(aVar);
        }
        this.Rj = true;
    }
}
