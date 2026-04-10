package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class vg4 extends ar2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f19026b;
    public final int c;

    @NotNull
    public final String d;
    public final long e;
    public final boolean f;
    public final boolean g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vg4(@NotNull String path, int i, @NotNull String errorDesc, long j, boolean z, boolean z2) {
        super(0, 1, null);
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(errorDesc, "errorDesc");
        this.f19026b = path;
        this.c = i;
        this.d = errorDesc;
        this.e = j;
        this.f = z;
        this.g = z2;
    }

    public final long b() {
        return this.e;
    }

    public final int c() {
        return this.c;
    }

    @NotNull
    public final String d() {
        return this.d;
    }

    @NotNull
    public final String e() {
        return this.f19026b;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.f;
    }
}
