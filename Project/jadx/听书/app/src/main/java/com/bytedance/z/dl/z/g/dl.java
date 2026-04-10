package com.bytedance.z.dl.z.g;

import com.bytedance.z.dl.z.g.g;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public abstract class dl implements g, Comparable<dl>, Runnable {
    private g.z z = g.z.NORMAL;
    private String g = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public g.z z() {
        return this.z;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public int compareTo(dl dlVar) {
        if (z().z() < dlVar.z().z()) {
            return 1;
        }
        return z().z() > dlVar.z().z() ? -1 : 0;
    }
}
