package com.yuewen;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public final class lc3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13885b;
    public int c;

    public lc3(int i, int i2, int i3) {
        this.f13884a = i;
        this.f13885b = i2;
        this.c = i3;
    }

    public static /* synthetic */ lc3 e(lc3 lc3Var, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = lc3Var.f13884a;
        }
        if ((i4 & 2) != 0) {
            i2 = lc3Var.f13885b;
        }
        if ((i4 & 4) != 0) {
            i3 = lc3Var.c;
        }
        return lc3Var.d(i, i2, i3);
    }

    public final int a() {
        return this.f13884a;
    }

    public final int b() {
        return this.f13885b;
    }

    public final int c() {
        return this.c;
    }

    @NotNull
    public final lc3 d(int i, int i2, int i3) {
        return new lc3(i, i2, i3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lc3)) {
            return false;
        }
        lc3 lc3Var = (lc3) obj;
        return this.f13884a == lc3Var.f13884a && this.f13885b == lc3Var.f13885b && this.c == lc3Var.c;
    }

    public final int f() {
        return this.c;
    }

    public final int g() {
        return this.f13885b;
    }

    public final int h() {
        return this.f13884a;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f13884a) * 31) + Integer.hashCode(this.f13885b)) * 31) + Integer.hashCode(this.c);
    }

    public final void i(int i) {
        this.c = i;
    }

    public final void j(int i) {
        this.f13885b = i;
    }

    public final void k(int i) {
        this.f13884a = i;
    }

    @NotNull
    public String toString() {
        return "ScrollEvent(scrollOffset=" + this.f13884a + ", dy=" + this.f13885b + ", currentOffset=" + this.c + ")";
    }
}
