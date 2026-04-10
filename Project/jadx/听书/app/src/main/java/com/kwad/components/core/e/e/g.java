package com.kwad.components.core.e.e;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private final List<f> PY;

    /* synthetic */ g(byte b) {
        this();
    }

    public static class a {
        private static final g PZ = new g(0);
    }

    private g() {
        this.PY = new CopyOnWriteArrayList();
    }

    public static g pY() {
        return a.PZ;
    }

    public final void a(f fVar) {
        this.PY.add(fVar);
    }

    public final void b(f fVar) {
        if (fVar != null) {
            this.PY.remove(fVar);
        }
    }

    public final void pZ() {
        Iterator<f> it = this.PY.iterator();
        while (it.hasNext()) {
            it.next().show();
        }
    }

    public final void qa() {
        Iterator<f> it = this.PY.iterator();
        while (it.hasNext()) {
            it.next().dismiss();
        }
    }
}
