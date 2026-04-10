package com.yuewen;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes17.dex */
public final class c7 extends h2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c7 f9562a = new c7();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f9563b = "";

    @Override // com.yuewen.h2
    @NotNull
    public String d() {
        return "TRACK_QUALITY_AD";
    }

    @Override // com.yuewen.h2
    @NotNull
    public synchronized String h() {
        String strH;
        strH = super.h();
        f9563b = strH;
        return strH;
    }

    @NotNull
    public final String i() {
        return f9563b;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        f9563b = str;
    }
}
