package com.google.a.a.a.a.a;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
final class d extends WeakReference<Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6783a;

    public d(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.f6783a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == d.class) {
            if (this == obj) {
                return true;
            }
            d dVar = (d) obj;
            if (this.f6783a == dVar.f6783a && get() == dVar.get()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f6783a;
    }
}
