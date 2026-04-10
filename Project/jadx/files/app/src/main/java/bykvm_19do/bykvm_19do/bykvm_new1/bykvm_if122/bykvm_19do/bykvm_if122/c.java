package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_if122.b;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Runnable, Comparable<c>, b {
    private b.a a = b.a.NORMAL;

    public c() {
        String str = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        if (a().a() < cVar.a().a()) {
            return 1;
        }
        return a().a() > cVar.a().a() ? -1 : 0;
    }

    public b.a a() {
        return this.a;
    }
}
