package com.kwad.sdk.utils;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class an {
    private static void a(RuntimeException runtimeException) {
        com.kwad.sdk.core.d.b.printStackTrace(runtimeException);
    }

    public static String ae(String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            a(new NullPointerException("Argument cannot be null " + str2));
        }
        return str;
    }

    public static void checkArgument(boolean z2, @Nullable Object obj) {
        if (z2) {
            return;
        }
        a(new IllegalArgumentException("Expression cannot be false " + obj));
    }

    public static <T> T checkNotNull(T t2) {
        return (T) f(t2, "");
    }

    public static void e(Object... objArr) {
        for (int i2 = 0; i2 < 2; i2++) {
            checkNotNull(objArr[i2]);
        }
    }

    public static String et(String str) {
        return ae(str, "");
    }

    public static <T> T f(T t2, @Nullable String str) {
        if (t2 == null) {
            a(new NullPointerException("Argument cannot be null " + str));
        }
        return t2;
    }
}
