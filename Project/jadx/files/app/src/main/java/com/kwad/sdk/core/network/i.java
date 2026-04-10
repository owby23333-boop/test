package com.kwad.sdk.core.network;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class i {
    private static volatile i agd;
    private List<a> agc = new CopyOnWriteArrayList();

    public interface a {
        void a(g gVar, int i2);
    }

    private i() {
    }

    public static i wr() {
        if (agd == null) {
            synchronized (i.class) {
                if (agd == null) {
                    agd = new i();
                }
            }
        }
        return agd;
    }

    public final void a(a aVar) {
        this.agc.add(aVar);
    }

    final void b(g gVar, int i2) {
        Iterator<a> it = this.agc.iterator();
        while (it.hasNext()) {
            it.next().a(gVar, i2);
        }
    }
}
