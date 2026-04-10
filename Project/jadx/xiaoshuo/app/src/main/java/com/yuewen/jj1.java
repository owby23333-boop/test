package com.yuewen;

import android.os.Parcelable;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public interface jj1 {
    void a();

    @NotNull
    jj1 b(@Nullable String str, @NotNull Parcelable parcelable);

    @NotNull
    <T extends Parcelable> T c(@Nullable String str, @NotNull T t);

    @NotNull
    jj1 clear();

    boolean contains(@Nullable String str);

    @Nullable
    String[] d();

    boolean getBoolean(@Nullable String str, boolean z);

    float getFloat(@Nullable String str, float f);

    int getInt(@Nullable String str, int i);

    long getLong(@Nullable String str, long j);

    @NotNull
    String getString(@Nullable String str, @NotNull String str2);

    @Nullable
    Set<String> getStringSet(@Nullable String str, @Nullable Set<String> set);

    @NotNull
    jj1 putBoolean(@Nullable String str, boolean z);

    @NotNull
    jj1 putFloat(@Nullable String str, float f);

    @NotNull
    jj1 putInt(@Nullable String str, int i);

    @NotNull
    jj1 putLong(@Nullable String str, long j);

    @NotNull
    jj1 putString(@Nullable String str, @Nullable String str2);

    @NotNull
    jj1 putStringSet(@Nullable String str, @Nullable Set<String> set);

    @NotNull
    jj1 remove(@Nullable String str);
}
