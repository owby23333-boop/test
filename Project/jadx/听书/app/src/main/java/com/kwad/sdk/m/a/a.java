package com.kwad.sdk.m.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private final List<b> aWS = new ArrayList();

    public final boolean onBackPressed() {
        Iterator<b> it = this.aWS.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.aWS.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.aWS.add(i, bVar);
        }
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.aWS.remove(bVar);
        }
    }
}
