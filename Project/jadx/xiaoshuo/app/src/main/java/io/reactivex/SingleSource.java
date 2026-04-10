package io.reactivex;

import io.reactivex.annotations.NonNull;

/* JADX INFO: loaded from: classes8.dex */
public interface SingleSource<T> {
    void subscribe(@NonNull SingleObserver<? super T> singleObserver);
}
