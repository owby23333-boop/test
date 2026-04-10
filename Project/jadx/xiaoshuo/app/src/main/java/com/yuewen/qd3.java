package com.yuewen;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class qd3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final qd3 f16496a = new qd3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f16497b = "";

    @NotNull
    public static final String a() {
        return f16497b;
    }

    @rd3
    @JvmStatic
    public static /* synthetic */ void b() {
    }

    public static final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f16497b = str;
    }
}
