package com.google.zxing.p.r.g;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ExpandedRow.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    private final List<b> a;
    private final int b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f16276c;

    c(List<b> list, int i2, boolean z2) {
        this.a = new ArrayList(list);
        this.b = i2;
        this.f16276c = z2;
    }

    List<b> a() {
        return this.a;
    }

    int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.a.equals(cVar.a()) && this.f16276c == cVar.f16276c;
    }

    public int hashCode() {
        return this.a.hashCode() ^ Boolean.valueOf(this.f16276c).hashCode();
    }

    public String toString() {
        return "{ " + this.a + " }";
    }

    boolean a(List<b> list) {
        return this.a.equals(list);
    }
}
