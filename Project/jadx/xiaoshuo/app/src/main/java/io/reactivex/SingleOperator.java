package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes8.dex */
public interface SingleOperator<Downstream, Upstream> {
    @NonNull
    SingleObserver<? super Upstream> apply(@NonNull SingleObserver<? super Downstream> singleObserver) throws Exception;
}
