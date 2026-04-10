package com.kwad.components.core.internal.api;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    @NonNull
    private List<b> JV = new ArrayList();
    private boolean JW = false;
    private boolean JX = false;

    public final void a(a aVar) {
        if (this.JX) {
            return;
        }
        Iterator<b> it = this.JV.iterator();
        while (it.hasNext()) {
            it.next().onAdEnter(aVar);
        }
        this.JX = true;
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        this.JV.add(bVar);
    }

    public final void b(a aVar) {
        if (this.JW) {
            return;
        }
        Iterator<b> it = this.JV.iterator();
        while (it.hasNext()) {
            it.next().onAdExit(aVar);
        }
        this.JW = true;
    }

    public final void b(b bVar) {
        if (bVar == null) {
            return;
        }
        this.JV.remove(bVar);
    }
}
