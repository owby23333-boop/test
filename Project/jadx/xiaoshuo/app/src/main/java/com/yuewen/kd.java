package com.yuewen;

import com.duokan.statistics.biz.constant.AppStartSource;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public final class kd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final kd f13449a = new kd();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static AppStartSource f13450b;

    @NotNull
    public static AppStartSource c;

    @NotNull
    public static AppStartSource d;

    @Nullable
    public static String e;

    static {
        AppStartSource appStartSource = AppStartSource.UNKNOWN;
        f13450b = appStartSource;
        c = appStartSource;
        d = appStartSource;
    }

    @NotNull
    public static final AppStartSource a() {
        return d;
    }

    @JvmStatic
    public static /* synthetic */ void b() {
    }

    @Nullable
    public static final String c() {
        String str = e;
        return str == null ? "" : str;
    }

    @JvmStatic
    public static /* synthetic */ void d() {
    }

    @NotNull
    public static final AppStartSource e() {
        return c;
    }

    @JvmStatic
    public static /* synthetic */ void f() {
    }

    @NotNull
    public static final AppStartSource g() {
        return f13450b;
    }

    @JvmStatic
    public static /* synthetic */ void h() {
    }

    public static final void i(@NotNull AppStartSource appStartSource) {
        Intrinsics.checkNotNullParameter(appStartSource, "<set-?>");
        d = appStartSource;
    }

    public static final void j(@Nullable String str) {
        e = str;
    }

    public static final void k(@NotNull AppStartSource appStartSource) {
        Intrinsics.checkNotNullParameter(appStartSource, "<set-?>");
        c = appStartSource;
    }

    public static final void l(@NotNull AppStartSource appStartSource) {
        Intrinsics.checkNotNullParameter(appStartSource, "<set-?>");
        f13450b = appStartSource;
    }
}
