package com.anythink.expressad.exoplayer.k;

import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private a() {
    }

    public static void a(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z2) {
        if (!z2) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(boolean z2, Object obj) {
        if (!z2) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static int a(int i2, int i3) {
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException();
        }
        return i2;
    }

    public static <T> T a(@Nullable T t2) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException();
    }

    private static <T> T a(@Nullable T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private static String a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    private static String a(@Nullable String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    private static void a() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Not in applications main thread");
        }
    }
}
