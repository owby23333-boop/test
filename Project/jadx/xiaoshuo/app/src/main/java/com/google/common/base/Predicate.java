package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public interface Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(@NullableDecl T t);

    boolean equals(@NullableDecl Object obj);
}
