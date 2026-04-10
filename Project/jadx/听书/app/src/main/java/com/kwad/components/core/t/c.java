package com.kwad.components.core.t;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private Set<b> YJ;

    /* JADX INFO: loaded from: classes3.dex */
    public interface b {
        void onPageClose();
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private c() {
        this.YJ = new HashSet();
    }

    static class a {
        private static c YK = new c(0);
    }

    public static c sZ() {
        return a.YK;
    }

    public final void a(b bVar) {
        this.YJ.add(bVar);
    }

    public final void b(b bVar) {
        this.YJ.remove(bVar);
    }

    public final void ta() {
        if (this.YJ.size() == 0) {
            return;
        }
        Iterator<b> it = this.YJ.iterator();
        while (it.hasNext()) {
            it.next().onPageClose();
        }
    }
}
