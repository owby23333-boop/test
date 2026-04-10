package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class h {
    private static volatile h aEG;
    private List<a> aEF = new CopyOnWriteArrayList();

    public interface a {
        void a(f fVar, int i);
    }

    public static h Hy() {
        if (aEG == null) {
            synchronized (h.class) {
                if (aEG == null) {
                    aEG = new h();
                }
            }
        }
        return aEG;
    }

    private h() {
    }

    public final void a(a aVar) {
        this.aEF.add(aVar);
    }

    final void b(f fVar, int i) {
        Iterator<a> it = this.aEF.iterator();
        while (it.hasNext()) {
            it.next().a(fVar, i);
        }
    }
}
