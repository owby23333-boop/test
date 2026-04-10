package com.yuewen;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public final class i10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f12327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f12328b;
    public long c;
    public long d;

    @Nullable
    public String e;

    public i10() {
        this(0L, 0L, 0L, 0L, null, 31, null);
    }

    public final long a() {
        return this.f12327a;
    }

    public final long b() {
        return this.f12328b;
    }

    public final long c() {
        return this.c;
    }

    public final long d() {
        return this.d;
    }

    @Nullable
    public final String e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i10)) {
            return false;
        }
        i10 i10Var = (i10) obj;
        return this.f12327a == i10Var.f12327a && this.f12328b == i10Var.f12328b && this.c == i10Var.c && this.d == i10Var.d && Intrinsics.areEqual(this.e, i10Var.e);
    }

    @NotNull
    public final i10 f(long j, long j2, long j3, long j4, @Nullable String str) {
        return new i10(j, j2, j3, j4, str);
    }

    public final long h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = ((((((Long.hashCode(this.f12327a) * 31) + Long.hashCode(this.f12328b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31;
        String str = this.e;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final long i() {
        return this.f12327a;
    }

    @Nullable
    public final String j() {
        return this.e;
    }

    public final long k() {
        return this.c;
    }

    public final long l() {
        return this.f12328b;
    }

    public final void m(long j) {
        this.d = j;
    }

    public final void n(long j) {
        this.f12327a = j;
    }

    public final void o(@Nullable String str) {
        this.e = str;
    }

    public final void p(long j) {
        this.c = j;
    }

    public final void q(long j) {
        this.f12328b = j;
    }

    @NotNull
    public String toString() {
        return "ChapterEndInfo(chapterIndex=" + this.f12327a + ", chapterPageIndex=" + this.f12328b + ", chapterPageCount=" + this.c + ", chapterCount=" + this.d + ", chapterName=" + this.e + ")";
    }

    public i10(long j, long j2, long j3, long j4, @Nullable String str) {
        this.f12327a = j;
        this.f12328b = j2;
        this.c = j3;
        this.d = j4;
        this.e = str;
    }

    public /* synthetic */ i10(long j, long j2, long j3, long j4, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2, (i & 4) != 0 ? 0L : j3, (i & 8) == 0 ? j4 : 0L, (i & 16) != 0 ? null : str);
    }
}
