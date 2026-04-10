package com.bytedance.hume.readapk;

/* JADX INFO: loaded from: classes.dex */
public final class c<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f2083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B f2084b;

    private c(A a2, B b2) {
        this.f2083a = a2;
        this.f2084b = b2;
    }

    public static <A, B> c<A, B> a(A a2, B b2) {
        return new c<>(a2, b2);
    }

    public B b() {
        return this.f2084b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        A a2 = this.f2083a;
        if (a2 == null) {
            if (cVar.f2083a != null) {
                return false;
            }
        } else if (!a2.equals(cVar.f2083a)) {
            return false;
        }
        B b2 = this.f2084b;
        B b3 = cVar.f2084b;
        if (b2 == null) {
            if (b3 != null) {
                return false;
            }
        } else if (!b2.equals(b3)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f2083a;
        int iHashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b2 = this.f2084b;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public A a() {
        return this.f2083a;
    }
}
