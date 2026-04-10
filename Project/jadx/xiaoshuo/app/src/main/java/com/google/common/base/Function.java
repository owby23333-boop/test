package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public interface Function<F, T> {
    @CanIgnoreReturnValue
    @NullableDecl
    T apply(@NullableDecl F f);

    boolean equals(@NullableDecl Object obj);
}
