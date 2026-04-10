package com.bumptech.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Jobs.java */
/* JADX INFO: loaded from: classes2.dex */
final class p {
    private final Map<com.bumptech.glide.load.c, j<?>> a = new HashMap();
    private final Map<com.bumptech.glide.load.c, j<?>> b = new HashMap();

    p() {
    }

    j<?> a(com.bumptech.glide.load.c cVar, boolean z2) {
        return a(z2).get(cVar);
    }

    void b(com.bumptech.glide.load.c cVar, j<?> jVar) {
        Map<com.bumptech.glide.load.c, j<?>> mapA = a(jVar.f());
        if (jVar.equals(mapA.get(cVar))) {
            mapA.remove(cVar);
        }
    }

    void a(com.bumptech.glide.load.c cVar, j<?> jVar) {
        a(jVar.f()).put(cVar, jVar);
    }

    private Map<com.bumptech.glide.load.c, j<?>> a(boolean z2) {
        return z2 ? this.b : this.a;
    }
}
