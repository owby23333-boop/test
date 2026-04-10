package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public abstract class c implements Runnable, Comparable<c> {
    private int a;

    public c(String str) {
        this.a = 0;
        this.a = 5;
        String str2 = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());
    }

    public int a() {
        return this.a;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        if (a() < cVar.a()) {
            return 1;
        }
        return a() >= cVar.a() ? -1 : 0;
    }
}
