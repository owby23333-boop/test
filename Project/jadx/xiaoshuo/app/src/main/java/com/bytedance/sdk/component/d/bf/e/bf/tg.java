package com.bytedance.sdk.component.d.bf.e.bf;

import com.bytedance.sdk.component.d.bf.h;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class tg {
    private final Set<h> e = new LinkedHashSet();

    public synchronized void bf(h hVar) {
        this.e.remove(hVar);
    }

    public synchronized boolean d(h hVar) {
        return this.e.contains(hVar);
    }

    public synchronized void e(h hVar) {
        this.e.add(hVar);
    }
}
