package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class dq2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f10319b;

    public dq2(boolean z, @NotNull String pushSource) {
        Intrinsics.checkNotNullParameter(pushSource, "pushSource");
        this.f10318a = z;
        this.f10319b = pushSource;
    }

    public static /* synthetic */ dq2 d(dq2 dq2Var, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dq2Var.f10318a;
        }
        if ((i & 2) != 0) {
            str = dq2Var.f10319b;
        }
        return dq2Var.c(z, str);
    }

    public final boolean a() {
        return this.f10318a;
    }

    @NotNull
    public final String b() {
        return this.f10319b;
    }

    @NotNull
    public final dq2 c(boolean z, @NotNull String pushSource) {
        Intrinsics.checkNotNullParameter(pushSource, "pushSource");
        return new dq2(z, pushSource);
    }

    @NotNull
    public final String e() {
        return this.f10319b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dq2)) {
            return false;
        }
        dq2 dq2Var = (dq2) obj;
        return this.f10318a == dq2Var.f10318a && Intrinsics.areEqual(this.f10319b, dq2Var.f10319b);
    }

    public final boolean f() {
        return this.f10318a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z = this.f10318a;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return (r0 * 31) + this.f10319b.hashCode();
    }

    @NotNull
    public String toString() {
        return "PushCheckResult(isPush=" + this.f10318a + ", pushSource=" + this.f10319b + ")";
    }
}
