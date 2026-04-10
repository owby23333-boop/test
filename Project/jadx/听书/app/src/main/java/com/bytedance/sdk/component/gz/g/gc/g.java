package com.bytedance.sdk.component.gz.g.gc;

import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g implements Comparable<g>, Runnable {
    private String dl;
    private int z = 5;
    private String g = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public g(String str) {
        this.dl = str;
    }

    public void z(int i) {
        this.z = i;
    }

    public int z() {
        return this.z;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        if (z() < gVar.z()) {
            return 1;
        }
        return z() >= gVar.z() ? -1 : 0;
    }
}
