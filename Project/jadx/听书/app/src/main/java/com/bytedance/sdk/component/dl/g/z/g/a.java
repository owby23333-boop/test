package com.bytedance.sdk.component.dl.g.z.g;

import com.bytedance.sdk.component.dl.g.x;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private final Set<x> z = new LinkedHashSet();

    public synchronized void z(x xVar) {
        this.z.add(xVar);
    }

    public synchronized void g(x xVar) {
        this.z.remove(xVar);
    }

    public synchronized boolean dl(x xVar) {
        return this.z.contains(xVar);
    }
}
