package com.bumptech.glide.util;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public static void a(boolean z2, @NonNull String str) {
        if (!z2) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    public static <T> T a(@Nullable T t2) {
        a(t2, "Argument must not be null");
        return t2;
    }

    @NonNull
    public static <T> T a(@Nullable T t2, @NonNull String str) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    public static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    public static <T extends Collection<Y>, Y> T a(@NonNull T t2) {
        if (t2.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t2;
    }
}
