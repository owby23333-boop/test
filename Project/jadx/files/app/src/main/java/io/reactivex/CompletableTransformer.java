package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public interface CompletableTransformer {
    @NonNull
    CompletableSource apply(@NonNull Completable completable);
}
