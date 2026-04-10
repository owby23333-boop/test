package top.canyie.pine.utils;

import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public final class ThreeTuple<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public A f2565a;
    public B b;
    public C c;

    public ThreeTuple() {
    }

    public ThreeTuple(A a2, B b, C c) {
        this.f2565a = a2;
        this.b = b;
        this.c = c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ThreeTuple)) {
            return false;
        }
        ThreeTuple threeTuple = (ThreeTuple) obj;
        return Objects.equals(this.f2565a, threeTuple.f2565a) && Objects.equals(this.b, threeTuple.b) && Objects.equals(this.c, threeTuple.c);
    }

    public int hashCode() {
        return (Objects.hashCode(this.f2565a) ^ Objects.hashCode(this.b)) ^ Objects.hashCode(this.c);
    }

    public String toString() {
        return "ThreeTuple{A: " + this.f2565a + "; b: " + this.b + "; c: " + this.c + "}";
    }
}
