package com.kwad.components.core.r;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    private Set<b> PQ;

    static class a {
        private static d PR = new d(0);
    }

    public interface b {
        void onPageClose();
    }

    private d() {
        this.PQ = new HashSet();
    }

    /* synthetic */ d(byte b2) {
        this();
    }

    public static d qb() {
        return a.PR;
    }

    public final void a(b bVar) {
        this.PQ.add(bVar);
    }

    public final void b(b bVar) {
        this.PQ.remove(bVar);
    }

    public final void qc() {
        if (this.PQ.size() == 0) {
            return;
        }
        Iterator<b> it = this.PQ.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }
}
