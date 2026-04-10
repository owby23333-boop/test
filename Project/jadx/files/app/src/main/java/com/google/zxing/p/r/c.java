package com.google.zxing.p.r;

import com.google.zxing.i;

/* JADX INFO: compiled from: FinderPattern.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    private final int a;
    private final int[] b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i[] f16263c;

    public c(int i2, int[] iArr, int i3, int i4, int i5) {
        this.a = i2;
        this.b = iArr;
        float f2 = i5;
        this.f16263c = new i[]{new i(i3, f2), new i(i4, f2)};
    }

    public i[] a() {
        return this.f16263c;
    }

    public int[] b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && this.a == ((c) obj).a;
    }

    public int hashCode() {
        return this.a;
    }
}
