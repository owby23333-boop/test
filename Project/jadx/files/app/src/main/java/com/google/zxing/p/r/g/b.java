package com.google.zxing.p.r.g;

import com.umeng.message.proguard.ad;

/* JADX INFO: compiled from: ExpandedPair.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {
    private final com.google.zxing.p.r.b a;
    private final com.google.zxing.p.r.b b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.zxing.p.r.c f16275c;

    b(com.google.zxing.p.r.b bVar, com.google.zxing.p.r.b bVar2, com.google.zxing.p.r.c cVar, boolean z2) {
        this.a = bVar;
        this.b = bVar2;
        this.f16275c = cVar;
    }

    com.google.zxing.p.r.c a() {
        return this.f16275c;
    }

    com.google.zxing.p.r.b b() {
        return this.a;
    }

    com.google.zxing.p.r.b c() {
        return this.b;
    }

    public boolean d() {
        return this.b == null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return a(this.a, bVar.a) && a(this.b, bVar.b) && a(this.f16275c, bVar.f16275c);
    }

    public int hashCode() {
        return (a(this.a) ^ a(this.b)) ^ a(this.f16275c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.a);
        sb.append(ad.f20407t);
        sb.append(this.b);
        sb.append(" : ");
        com.google.zxing.p.r.c cVar = this.f16275c;
        sb.append(cVar == null ? "null" : Integer.valueOf(cVar.c()));
        sb.append(" ]");
        return sb.toString();
    }

    private static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
