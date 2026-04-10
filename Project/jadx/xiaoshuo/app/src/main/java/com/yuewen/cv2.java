package com.yuewen;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
public final class cv2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final cv2 f9997a = new cv2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f9998b = "unknown";
    public static int c;

    public static final int a() {
        return c;
    }

    @JvmStatic
    @bv2
    public static /* synthetic */ void b() {
    }

    @NotNull
    public static final String c() {
        return f9998b;
    }

    @JvmStatic
    @bv2
    public static /* synthetic */ void d() {
    }

    public static final void e(int i) {
        c = i;
    }

    public static final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f9998b = str;
    }
}
