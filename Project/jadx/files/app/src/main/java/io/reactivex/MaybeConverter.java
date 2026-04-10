package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface MaybeConverter<T, R> {
    @NonNull
    R apply(@NonNull Maybe<T> maybe);
}
