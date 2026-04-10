package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
final class Platform {
    private Platform() {
    }

    public static boolean isInstanceOfThrowableClass(@NullableDecl Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }
}
