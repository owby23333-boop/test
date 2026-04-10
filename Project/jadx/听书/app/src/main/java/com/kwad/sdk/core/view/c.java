package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private List<b> aML = new CopyOnWriteArrayList();

    public final void j(View view, boolean z) {
        Iterator<b> it = this.aML.iterator();
        while (it.hasNext()) {
            it.next().i(view, z);
        }
    }

    public final void a(b bVar) {
        if (c(bVar)) {
            return;
        }
        this.aML.add(bVar);
    }

    public final void b(b bVar) {
        this.aML.remove(bVar);
    }

    private boolean c(b bVar) {
        if (bVar != null) {
            return this.aML.contains(bVar);
        }
        return false;
    }
}
