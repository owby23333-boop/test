package com.kwad.sdk.h.kwai;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private final List<b> axg = new ArrayList();

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.axg.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i2) {
        if (bVar != null) {
            this.axg.add(i2, bVar);
        }
    }

    public final boolean bX() {
        Iterator<b> it = this.axg.iterator();
        while (it.hasNext()) {
            if (it.next().bX()) {
                return true;
            }
        }
        return false;
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.axg.remove(bVar);
        }
    }
}
