package com.kwad.components.ad.i;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class e {
    private final AtomicBoolean qY;
    private final List<com.kwad.components.ad.b.a.b> qZ;

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
        this.qY = new AtomicBoolean();
        this.qZ = new CopyOnWriteArrayList();
    }

    public final boolean T() {
        return this.qY.get();
    }

    public final void a(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.qZ.add(bVar);
        }
    }

    public final void b(com.kwad.components.ad.b.a.b bVar) {
        if (bVar != null) {
            this.qZ.remove(bVar);
        }
    }

    public final void ga() {
        this.qY.set(true);
        Iterator<com.kwad.components.ad.b.a.b> it = this.qZ.iterator();
        while (it.hasNext()) {
            it.next().U();
        }
    }

    public final void gc() {
        this.qY.set(false);
        Iterator<com.kwad.components.ad.b.a.b> it = this.qZ.iterator();
        while (it.hasNext()) {
            it.next().V();
        }
    }

    static class a {
        private static final e ra = new e(0);
    }

    public static e ge() {
        return a.ra;
    }
}
