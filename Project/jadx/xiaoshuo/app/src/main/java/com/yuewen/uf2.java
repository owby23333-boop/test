package com.yuewen;

/* JADX INFO: loaded from: classes12.dex */
public class uf2<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K f18448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V f18449b;

    public uf2(K k, V v) {
        this.f18448a = k;
        this.f18449b = v;
    }

    public static <K, V> uf2<K, V> a(K k, V v) {
        return new uf2<>(k, v);
    }

    public K b() {
        return this.f18448a;
    }

    public K c() {
        return this.f18448a;
    }

    public V d() {
        return this.f18449b;
    }

    public V e() {
        return this.f18449b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uf2)) {
            return false;
        }
        uf2 uf2Var = (uf2) obj;
        K k = this.f18448a;
        if (k != null ? k.equals(uf2Var.f18448a) : uf2Var.f18448a == null) {
            V v = this.f18449b;
            V v2 = uf2Var.f18449b;
            if (v == null) {
                if (v2 == null) {
                    return true;
                }
            } else if (v.equals(v2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        K k = this.f18448a;
        int iHashCode = k == null ? 0 : k.hashCode();
        V v = this.f18449b;
        int iHashCode2 = v != null ? v.hashCode() : 0;
        return ((iHashCode * 37) + iHashCode2) ^ (iHashCode2 >>> 16);
    }

    public String toString() {
        return "[" + c() + ", " + e() + "]";
    }

    public uf2(uf2<? extends K, ? extends V> uf2Var) {
        this(uf2Var.c(), uf2Var.e());
    }
}
