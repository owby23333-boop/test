package com.yuewen;

import android.app.Application;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes6.dex */
public interface n8 {
    @NotNull
    Application a();

    @NotNull
    gk b();

    void c(@NotNull String str, @NotNull String str2);

    boolean d();

    void e(@NotNull Runnable runnable);

    boolean f();

    void g(@NotNull Runnable runnable);

    @NotNull
    String getAndroidId();

    @NotNull
    sc0 getDeviceInfo();

    @NotNull
    String getOaid();

    @Nullable
    ij1 h();
}
