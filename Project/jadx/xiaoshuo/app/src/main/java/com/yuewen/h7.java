package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes17.dex */
public final class h7 extends h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h7 f11949a = new h7();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f11950b = "";

    @Override // com.yuewen.h2
    @NotNull
    public String d() {
        return "TRACK_QUALITY_AD_PAGE";
    }

    @Override // com.yuewen.h2
    @NotNull
    public synchronized String h() {
        String strH;
        strH = super.h();
        f11950b = strH;
        return strH;
    }

    @NotNull
    public final String i() {
        return f11950b;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f11950b = str;
    }
}
