package com.yuewen;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class rq3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final rq3 f17119a = new rq3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f17120b = "unknown";

    @NotNull
    public static final String a() {
        return f17120b;
    }

    @JvmStatic
    @qq3
    public static /* synthetic */ void b() {
    }

    public static final void c(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f17120b = str;
    }
}
