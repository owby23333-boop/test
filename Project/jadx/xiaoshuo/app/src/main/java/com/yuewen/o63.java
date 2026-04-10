package com.yuewen;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class o63 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final o63 f15218a = new o63();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f15219b = "";

    @NotNull
    public static final String a() {
        return f15219b;
    }

    @JvmStatic
    @n63
    public static /* synthetic */ void b() {
    }

    public static final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f15219b = str;
    }
}
